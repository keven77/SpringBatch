package com.juran.examplemovie.module.project.processor;

import com.alibaba.druid.util.StringUtils;
import com.google.common.collect.Lists;
import com.juran.core.utils.dateTime.DateTimeUtil;
import com.juran.examplemovie.client.bean.domain.BookingDemand;
import com.juran.examplemovie.module.project.bean.DemandPO;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 需求项目数据处理
 * @date 18:24 2017/10/12
 */
@Component
public class DemandProcessor extends LogBase implements ItemProcessor<List<BookingDemand>, List<DemandPO>> {
    @Override
    public List<DemandPO> process(List<BookingDemand> bookingDemands) throws Exception {

        logger.info("接受数据大小:{},开始处理数据.", bookingDemands.size());
        List<DemandPO> targetList = Lists.newArrayList();
        for (BookingDemand bookingDemand : bookingDemands) {
            DemandPO demandPO = new DemandPO();
            BeanUtils.copyProperties(bookingDemand, demandPO);
            if (StringUtils.isEmpty(bookingDemand.getPublishTime())) {
                demandPO.setPublishTime(new Date());
            } else {
                if (bookingDemand.getPublishTime().length() == 13) {
                    demandPO.setPublishTime(new Date(Long.valueOf(bookingDemand.getPublishTime())));
                } else {
                    demandPO.setPublishTime(DateTimeUtil.getFormatDateTime(bookingDemand.getPublishTime(), DateTimeUtil.DateFormat.FORMAT_DATETIME_NORMAL));
                }
            }
            if (StringUtils.isEmpty(bookingDemand.getProjectStartTime())) {
                demandPO.setProjectStartTime(new Date());
            } else {
                if (bookingDemand.getProjectStartTime().length() == 13) {
                    demandPO.setProjectStartTime(new Date(Long.valueOf(bookingDemand.getProjectStartTime())));
                } else {
                    demandPO.setProjectStartTime(DateTimeUtil.getFormatDateTime(bookingDemand.getProjectStartTime(), DateTimeUtil.DateFormat.FORMAT_DATETIME_NORMAL));
                }
            }
            demandPO.setBeishu(bookingDemand.getIsBeishu());
            demandPO.setPublicOrNot(bookingDemand.getIsPublic());
            demandPO.setSubmit(bookingDemand.getIsSubmit());
            demandPO.setAssetId(bookingDemand.getId());
            demandPO.setDeleteStatus(0);
            targetList.add(demandPO);
        }
        return targetList;
    }
}
