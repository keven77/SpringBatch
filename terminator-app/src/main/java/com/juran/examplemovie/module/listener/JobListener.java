package com.juran.examplemovie.module.listener;

import com.juran.core.utils.json.JsonUtil;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameters;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2017/9/27.
 */
@Component
public class JobListener extends LogBase implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        JobParameters jobParameters = jobExecution.getJobParameters();
        Long id = jobExecution.getId();
        String jobName = jobExecution.getJobInstance().getJobName();
        logger.info("Job监听--START--,JobId:[{}],JobName:[{}],参数:{}", id, jobName, JsonUtil.toJson(jobParameters));
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        JobParameters jobParameters = jobExecution.getJobParameters();
        Long id = jobExecution.getId();
        String jobName = jobExecution.getJobInstance().getJobName();
        logger.info("Job监听--END--,JobId:[{}],JobName:[{}],参数:{}", id, jobName, JsonUtil.toJson(jobParameters));
    }

}