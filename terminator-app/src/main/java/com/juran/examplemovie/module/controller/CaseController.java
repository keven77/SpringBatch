package com.juran.examplemovie.module.controller;

import com.juran.core.web.response.BasePageRespBean;
import com.juran.examplemovie.module.d2case.bean.D2CasePO;
import com.juran.examplemovie.module.d2case.bean.ImageInfo;
import com.juran.examplemovie.module.d2case.service.D2Service;
import com.juran.examplemovie.module.d3case.bean.D3CasePO;
import com.juran.examplemovie.module.d3case.service.D3Service;
import com.juran.examplemovie.module.utils.CommonUtil;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by dell on 2017/10/11.
 */
@Controller
@RequestMapping("/case/update")
public class CaseController extends LogBase {

    @Autowired
    D2Service d2Service;

    @Autowired
    D3Service d3Service;

    @RequestMapping("/d2")
    @ResponseBody
    public String d2Update() {
        long startTime = System.currentTimeMillis();
        logger.info("*********开始更新D2.*********");
        int offset = 0;
        int limit = 100;
        try {
            while (true) {
                BasePageRespBean<D2CasePO> params = new BasePageRespBean<>();
                params.setLimit(limit);
                params.setOffset(offset);
                params = d2Service.getMongoObjectList(null, params);
                List<D2CasePO> returnList = params.getData();
                for (D2CasePO po : returnList) {
                    //更新主图
                    List<ImageInfo> infoList = po.getImages();
                    for (ImageInfo info : infoList) {
                        if (info.getPrimary()) {
                            po.setThumbnailMainPath(info.getFileUrl());
                            continue;
                        }
                    }
                    //更新设计师头像
                    String avatar = CommonUtil.getAvatarByUid(po.getHsDesignerUid());
                    if (!StringUtils.isEmpty(avatar)) {
                        po.setOriginalAvatar(avatar);
                    }
                    //更新数据状态
                    po.setUpdateStatus(0);
                    int res = d2Service.updateD2Bean(po);
                    if (res == 0) {
                        logger.info("更新状态:res:{},assetId:{}", res, po.getAssetId());
                    }
                }
                if (returnList.size() == limit) {
                    offset = offset + 100;
                    logger.info("------------offset:{}------------", offset);
                } else {
                    break;
                }
            }
            long endTime = System.currentTimeMillis();
            logger.info("*********结束更新D2,消耗时间:{}.*********", (endTime - startTime) / 1000);
            return "ok";
        } catch (Exception e) {
            logger.error("2d更新异常,信息:{}", e);
            return "error";
        }
    }

    @RequestMapping("/d3/normal")
    @ResponseBody
    public String d3Update() {
        long startTime = System.currentTimeMillis();
        logger.info("*********开始更新普通D3.*********");
        try {
            List<String> uidList = d3Service.getUidList(0, 0, "normal", "hsDesignerUid");
            int index = 1;
            for (String uid : uidList) {
                String avatar = CommonUtil.getAvatarByUid(uid);
                if (StringUtils.isEmpty(avatar)) {
                    continue;
                }
                BasePageRespBean<D3CasePO> params = new BasePageRespBean<>();
                D3CasePO po = new D3CasePO();
                po.setHsDesignerUid(uid);
                params = d3Service.getMongoObjectList(po, params);
                List<D3CasePO> uList = params.getData();
                for (D3CasePO source : uList) {
                    source.setOriginalAvatar(avatar);
                    source.setUpdateStatus(0);
                    int res = d3Service.updateD3Bean(source);
                    if (res == 0) {
                        logger.info("更新状态:res:{},assetId:{}", res, source.getDesignAssetId());
                    }
                }
                    logger.info("去重后的uid大小:{},index:{},uList大小:{},uid:{}", uidList.size(), index, uList.size(), uid);
                index++;
            }
            long endTime = System.currentTimeMillis();
            logger.info("*********结束更新D3,消耗时间:{}.*********", (endTime - startTime) / 1000);
            return "ok";
        } catch (Exception e) {
            logger.error("3d更新异常,信息:{}", e);
            return "error";
        }
    }

    @RequestMapping("/d3/brilliant")
    @ResponseBody
    public String d3UpdateBrilliant() {
        long startTime = System.currentTimeMillis();
        logger.info("*********开始更新精选D3.*********");
        try {
            List<String> uidList = d3Service.getUidList(0, 0, "brilliant", "originalHsDesignerUid");
            int index = 1;
            for (String uid : uidList) {
                String avatar = CommonUtil.getAvatarByUid(uid);
                if (StringUtils.isEmpty(avatar)) {
                    continue;
                }
                BasePageRespBean<D3CasePO> params = new BasePageRespBean<>();
                D3CasePO po = new D3CasePO();
                po.setOriginalHsDesignerUid(uid);
                params = d3Service.getMongoObjectList(po, params);
                List<D3CasePO> uList = params.getData();
                for (D3CasePO source : uList) {
                    source.setOriginalAvatar(avatar);
                    source.setUpdateStatus(0);
                    int res = d3Service.updateD3Bean(source);
                    if (res == 0) {
                        logger.info("更新状态:res:{},assetId:{}", res, source.getDesignAssetId());
                    }
                }
                logger.info("去重后的uid大小:{},index:{},uList大小:{},uid:{}", uidList.size(), index, uList.size(), uid);
                index++;
            }
            long endTime = System.currentTimeMillis();
            logger.info("*********结束更新精选D3,消耗时间:{}.*********", (endTime - startTime) / 1000);
            return "ok";
        } catch (Exception e) {
            logger.error("3d更新异常,信息:{}", e);
            return "error";
        }
    }

}
