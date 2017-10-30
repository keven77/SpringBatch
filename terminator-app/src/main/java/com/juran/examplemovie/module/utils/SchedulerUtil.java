package com.juran.examplemovie.module.utils;

import com.google.common.collect.Maps;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * Created by dell on 2017/7/25.
 */
@Component
public class SchedulerUtil extends LogBase {

    @Autowired
    @Qualifier("beanJobLauncher")
    JobLauncher beanJobLauncher;

    @Autowired
    @Qualifier("d2Job")
    Job d2Job;

    @Autowired
    @Qualifier("d3Job")
    Job d3Job;

    @Autowired
    @Qualifier("d3NewJob")
    Job d3NewJob;

    @Autowired
    @Qualifier("demandJob")
    Job demandJob;

    @Autowired
    @Qualifier("beanJob")
    Job personJob;

    /**
     * 2D案例定时任务：60分钟一次
     */
    @Scheduled(fixedRate = 1000 * 60 * 60)
    public void d2Tasks() {
        try {
            String threadName = Thread.currentThread().getName();
            Long threadId = Thread.currentThread().getId();
            Date currentDateTime = new Date();
            logger.info("2D案例[定时任务]--开始--线程名称:[{}],线程ID:[{}],时间:{}.", threadName, threadId, currentDateTime);

            JobParameter channelJp = new JobParameter("d2Task");
            JobParameter dateJp = new JobParameter(currentDateTime);
            Map<String, JobParameter> parameterMap = Maps.newHashMap();
            parameterMap.put("channel", channelJp);
            parameterMap.put("date", dateJp);
            JobParameters jps = new JobParameters(parameterMap);

            JobExecution result = beanJobLauncher.run(d2Job, jps);
            BatchStatus status = result.getStatus();
            Date end = new Date();
            String res = status.getBatchStatus().toString();
            logger.info("2D案例[定时任务]----结束----,时间:{},状态:{},更耗时:{}s.", end, res, (end.getTime() - currentDateTime.getTime()) / 1000);
        } catch (Exception e) {
            logger.error("2D案例定时任务异常,信息:{}", e);
        }
    }

    /**
     * 3D案例定时任务：30分钟一次
     */
    @Scheduled(fixedRate = 1000 * 60 * 30)
    public void d3Tasks() {
        try {
            String threadName = Thread.currentThread().getName();
            Long threadId = Thread.currentThread().getId();
            Date currentDateTime = new Date();
            logger.info("3D案例[定时任务]----开始----,线程名称:[{}],线程ID:[{}],时间:{}.", threadName, threadId, currentDateTime);

            JobParameter channelJp = new JobParameter("d3Task");
            JobParameter dateJp = new JobParameter(currentDateTime);
            Map<String, JobParameter> parameterMap = Maps.newHashMap();
            parameterMap.put("channel", channelJp);
            parameterMap.put("date", dateJp);
            JobParameters jps = new JobParameters(parameterMap);

            JobExecution result = beanJobLauncher.run(d3Job, jps);
            BatchStatus status = result.getStatus();
            Date end = new Date();
            String res = status.getBatchStatus().toString();
            logger.info("3D案例[定时任务]----结束----,时间:{},状态:{},更耗时:{}s.", end, res, (end.getTime() - currentDateTime.getTime()) / 1000);
        } catch (Exception e) {
            logger.error("3D案例定时任务异常,信息:{}", e);
        }
    }

    /**
     * 新3D案例定时任务：30分钟一次
     */
    @Scheduled(fixedRate = 1000 * 60 * 30)
    public void d3NewTasks() {
        try {
            String threadName = Thread.currentThread().getName();
            Long threadId = Thread.currentThread().getId();
            Date currentDateTime = new Date();
            logger.info("新3D案例[定时任务]----开始----,线程名称:[{}],线程ID:[{}],时间:{}.", threadName, threadId, currentDateTime);

            JobParameter channelJp = new JobParameter("d3NewTask");
            JobParameter dateJp = new JobParameter(currentDateTime);
            Map<String, JobParameter> parameterMap = Maps.newHashMap();
            parameterMap.put("channel", channelJp);
            parameterMap.put("date", dateJp);
            JobParameters jps = new JobParameters(parameterMap);

            JobExecution result = beanJobLauncher.run(d3NewJob, jps);
            BatchStatus status = result.getStatus();
            Date end = new Date();
            String res = status.getBatchStatus().toString();
            logger.info("新3D案例[定时任务]----结束----,时间:{},状态:{},更耗时:{}s.", end, res, (end.getTime() - currentDateTime.getTime()) / 1000);
        } catch (Exception e) {
            logger.error("新3D案例定时任务异常,信息:{}", e);
        }
    }

    /**
     * 项目定时任务：20分钟一次
     */
    @Scheduled(fixedRate = 1000 * 60 * 20)
    public void DemandTasks() {
        try {
            String threadName = Thread.currentThread().getName();
            Long threadId = Thread.currentThread().getId();
            Date currentDateTime = new Date();
            logger.info("项目[定时任务]----开始----,线程名称:[{}],线程ID:[{}],时间:{}.", threadName, threadId, currentDateTime);

            JobParameter channelJp = new JobParameter("DemandTask");
            JobParameter dateJp = new JobParameter(currentDateTime);
            Map<String, JobParameter> parameterMap = Maps.newHashMap();
            parameterMap.put("channel", channelJp);
            parameterMap.put("date", dateJp);
            JobParameters jps = new JobParameters(parameterMap);

            JobExecution result = beanJobLauncher.run(demandJob, jps);
            BatchStatus status = result.getStatus();
            Date end = new Date();
            String res = status.getBatchStatus().toString();
            logger.info("项目[定时任务]----结束----,时间:{},状态:{},更耗时:{}s.", end, res, (end.getTime() - currentDateTime.getTime()) / 1000);
        } catch (Exception e) {
            logger.error("项目定时任务异常,信息:{}", e);
        }
    }

}
