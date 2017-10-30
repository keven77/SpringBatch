package com.juran.examplemovie.module.listener;

import com.juran.examplemovie.module.utils.ConfigUtil;
import com.juran.examplemovie.module.utils.LogBase;
import com.juran.examplemovie.module.utils.ThreadLocalUtil;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2017/10/1.
 */
@Component
public class StepListener extends LogBase implements StepExecutionListener {

    @Autowired
    ThreadLocalUtil threadLocalUtil;
    @Autowired
    ConfigUtil configUtil;

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        Long stepId = stepExecution.getId();
        String stepName = stepExecution.getStepName();
        BatchStatus batchStatus = stepExecution.getStatus();
        logger.info("Step监听END,参数,StepId:[{}], StepName:[{}], 状态:[{}]", stepId, stepName, batchStatus.toString());
        threadLocalUtil.setOffset(configUtil.getOffset());//重新设置ThreadLocal中的offset
        return new ExitStatus(batchStatus.toString());
    }
}
