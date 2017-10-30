package com.juran.examplemovie.module.project.reader;

import com.juran.examplemovie.app.service.IAcsDemandService;
import com.juran.examplemovie.client.bean.domain.BookingDemand;
import com.juran.examplemovie.module.utils.ConfigUtil;
import com.juran.examplemovie.module.utils.LogBase;
import com.juran.examplemovie.module.utils.ThreadLocalUtil;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 获取需求项目
 * @date 18:04 2017/10/12
 */
@Component
public class DemandItemReader extends LogBase implements ItemReader<List<BookingDemand>> {

    @Autowired
    private IAcsDemandService demandService;
    @Autowired
    ConfigUtil configUtil;
    @Autowired
    ThreadLocalUtil threadLocalUtil;

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public List<BookingDemand> read() throws Exception {

        JobParameters jobParameters = stepExecution.getJobParameters();
        String channel = jobParameters.getString("channel");

        int currentOffset = threadLocalUtil.getOffset();
        logger.info("---------------------------需求项目读,渠道:{},OFFSET:{}-------------------------------------", channel, currentOffset);
        List<BookingDemand> demands = demandService.getDemands(configUtil.getLimit(), currentOffset);
        threadLocalUtil.setOffset(currentOffset + configUtil.getLimit());

        if (CollectionUtils.isEmpty(demands)) {
            logger.info("获取需求项目数量:0,Batch处理结束,渠道:{}.", channel);
            return null;
        }

        logger.info("需求项目:limit和offset以及size数量:{},{},{},渠道:{}", configUtil.getLimit(), currentOffset, demands.size(), channel);
        return demands;
    }
}
