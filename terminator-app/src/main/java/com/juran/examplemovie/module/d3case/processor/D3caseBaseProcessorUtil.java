package com.juran.examplemovie.module.d3case.processor;

import com.google.common.collect.Lists;
import com.juran.examplemovie.client.bean.domain.D3CaseRetrieveRsp;
import com.juran.examplemovie.client.bean.domain.DesignFileReq;
import com.juran.examplemovie.client.bean.domain.RspD3Case;
import com.juran.examplemovie.module.d3case.bean.D3CasePO;
import com.juran.examplemovie.module.d3case.bean.D3FileInfo;
import com.juran.examplemovie.module.d3case.bean.D3SpaceInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 10:41 2017/9/29
 */
public class D3caseBaseProcessorUtil {

    /**
     * 3D数据转换
     *
     * @param d3CaseRetrieveRsps
     * @param caseType
     * @return
     */
    public static List<D3CasePO> transformData(List<D3CaseRetrieveRsp> d3CaseRetrieveRsps, String caseType) {
        List<D3CasePO> targetList = Lists.newArrayList();
        for (D3CaseRetrieveRsp source : d3CaseRetrieveRsps) {
            D3CasePO d3CasePO = new D3CasePO();
            d3CasePO.setStatus(0);//有效状态
            d3CasePO.setUpdateStatus(1);//未更新
            BeanUtils.copyProperties(source, d3CasePO);
            d3CasePO.setSampleRoom(source.getIsSampleRoom());
            d3CasePO.setDeleteStatus(0);
            d3CasePO.setHandleStatus(0);
            d3CasePO.setNewCase(source.getIsNew());
            if (StringUtils.isEmpty(d3CasePO.getDateSubmitted())) {
                d3CasePO.setDateSubmitted(new Date());
            } else {
                d3CasePO.setDateSubmitted(new Date(Long.valueOf(source.getDateSubmitted())));
            }
            if (StringUtils.isEmpty(d3CasePO.getDateModifyed())) {
                d3CasePO.setDateModifyed(new Date());
            } else {
                d3CasePO.setDateModifyed(new Date(Long.valueOf(source.getDateModifyed())));
            }
            List<DesignFileReq> designFileReqs = source.getDesignFile(); //原3d方案文件
            List<D3FileInfo> d3FileInfos = Lists.newArrayList(); //新3d方案文件
            for (DesignFileReq designFileReq : designFileReqs) {
                d3FileInfos.add(D3caseBaseProcessorUtil.transformFile(designFileReq));
            }
            d3CasePO.setDesignFile(d3FileInfos);

            List<RspD3Case> rspD3Cases = source.getRenderingImages();
            List<D3SpaceInfo> d3SpaceInfoList = Lists.newArrayList();
            for (RspD3Case rspD3Case : rspD3Cases) {
                D3SpaceInfo d3SpaceInfo = new D3SpaceInfo();
                BeanUtils.copyProperties(rspD3Case, d3SpaceInfo);
                List<DesignFileReq> designFileReqList = rspD3Case.getData(); //原空间信息里的list文件
                List<D3FileInfo> d3FileInfoList = Lists.newArrayList(); //新空间信息里的list文件
                for (DesignFileReq designFileReq : designFileReqList) {
                    d3FileInfoList.add(D3caseBaseProcessorUtil.transformFile(designFileReq));
                }
                d3SpaceInfo.setData(d3FileInfoList);
                d3SpaceInfoList.add(d3SpaceInfo);
            }
            d3CasePO.setRenderingImages(d3SpaceInfoList);
            d3CasePO.setCaseType(caseType);
            targetList.add(d3CasePO);
        }
        return targetList;
    }

    /**
     * 转换文件对象
     *
     * @param sourceFile
     * @return
     */
    public static D3FileInfo transformFile(DesignFileReq sourceFile) {
        D3FileInfo d3FileInfo = new D3FileInfo();
        BeanUtils.copyProperties(sourceFile, d3FileInfo);
        d3FileInfo.setFileId(sourceFile.getId());
        d3FileInfo.setPrimary(sourceFile.getIsPrimary());
        return d3FileInfo;
    }

}
