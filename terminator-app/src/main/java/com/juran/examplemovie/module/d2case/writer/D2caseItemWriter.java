package com.juran.examplemovie.module.d2case.writer;

import com.juran.examplemovie.module.d2case.bean.D2CasePO;
import com.juran.examplemovie.module.d2case.service.D2Service;
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
 * @author pengbo
 * @version V1.0
 * @Title: 写入2d案例
 * @date 2017/09/27
 */
@Component
public class D2caseItemWriter extends LogBase implements ItemWriter<List<D2CasePO>> {

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Autowired
    D2Service d2Service;
    @Autowired
    ThreadLocalUtil threadLocalUtil;

    @Override
    public void write(List<? extends List<D2CasePO>> list) throws Exception {

        JobParameters parameters = stepExecution.getJobParameters();
        String channel = parameters.getString("channel");

        if (CollectionUtils.isEmpty(list)) {
            logger.info("2D案例写入数据的大小为0");
            return;
        }

        int count = 0;//计数
        int repeatCount = 0;
        for (List<D2CasePO> wList : list) {
            for (D2CasePO source : wList) {
                Boolean res = d2Service.insertD2Bean(source);
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
        logger.info("2D案例操作完成,处理总量:{},成功量:{},重复量:{},渠道:{}.", count, count - repeatCount, repeatCount, channel);
    }

}
