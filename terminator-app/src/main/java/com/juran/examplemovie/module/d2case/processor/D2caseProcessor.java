package com.juran.examplemovie.module.d2case.processor;

import com.google.common.collect.Lists;
import com.juran.examplemovie.client.bean.domain.D2CaseRetrieveRsp;
import com.juran.examplemovie.client.bean.domain.ThumbnailsFileRsp;
import com.juran.examplemovie.module.d2case.bean.D2CasePO;
import com.juran.examplemovie.module.d2case.bean.ImageInfo;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author pengbo
 * @version V1.0
 * @Title: 处理审核中的2d案例
 * @date 2017/09/27
 */
@Component
public class D2caseProcessor extends LogBase implements ItemProcessor<List<D2CaseRetrieveRsp>, List<D2CasePO>> {

    @Override
    public List<D2CasePO> process(List<D2CaseRetrieveRsp> d2CaseRetrieveRsps) throws Exception {

        logger.info("接受数据大小:{},开始处理数据.", d2CaseRetrieveRsps.size());

        List<D2CasePO> targetList = Lists.newArrayList();//返回数据
        for (D2CaseRetrieveRsp source : d2CaseRetrieveRsps) {
            D2CasePO target = new D2CasePO();
            target.setUpdateStatus(1);//未更新
            target.setDeleteStatus(0);
            BeanUtils.copyProperties(source, target);
            if (StringUtils.isEmpty(source.getCreateDate())) {
                target.setUpdateDate(new Date());
            } else {
                target.setCreateDate(new Date(Long.valueOf(source.getCreateDate())));
            }
            target.setNewCase(source.getIsNew());
            target.setAssetId(Long.valueOf(source.getId()));
            List<ImageInfo> targetImageList = Lists.newArrayList();//新图片
            List<ThumbnailsFileRsp> imageList = source.getImages();//老图片
            for (ThumbnailsFileRsp image : imageList) {
                ImageInfo info = new ImageInfo();
                BeanUtils.copyProperties(image, info);
                info.setPrimary(image.getIsPrimary());
                targetImageList.add(info);
            }
            target.setImages(targetImageList);
            targetList.add(target);
        }
        return targetList;
    }
}
