package com.juran.examplemovie.module.project.writer;

import com.juran.examplemovie.module.project.bean.DemandPO;
import com.juran.examplemovie.module.project.service.DemandService;
import com.juran.examplemovie.module.utils.LogBase;
import com.juran.examplemovie.module.utils.ThreadLocalUtil;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 写入需求项目
 * @date 18:22 2017/10/12
 */
@Component
public class DemandItemWriter extends LogBase implements ItemWriter<List<DemandPO>> {

    @Autowired
    DemandService demandService;
    @Autowired
    ThreadLocalUtil threadLocalUtil;

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public void write(List<? extends List<DemandPO>> list) throws Exception {
        JobParameters parameters = stepExecution.getJobParameters();
        String channel = parameters.getString("channel");

        if (CollectionUtils.isEmpty(list)) {
            logger.info("项目写入数据的大小为0");
            return;
        }

        int count = 0;//计数
        int repeatCount = 0;
        for (List<DemandPO> wList : list) {
            for (DemandPO source : wList) {
                Boolean res = demandService.insertDemandBean(source);
                if (!res) {
                    repeatCount++;
                }
            }
            count = count + wList.size();
        }
        //如果操作量=重复量，设置offset500000，目的是让程序停止（全部相同表示之后的所有数据都导入过，没有必要继续进行）
        if (repeatCount == count) {
            threadLocalUtil.setOffset(500000);
        }
        logger.info("项目操作完成,处理总量:{},成功量:{},重复量:{},渠道:{}.", count, count - repeatCount, repeatCount, channel);
    }
}
