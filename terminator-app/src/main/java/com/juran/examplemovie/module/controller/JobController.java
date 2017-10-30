package com.juran.examplemovie.module.controller;

import com.google.common.collect.Maps;
import com.juran.core.log.eventlog.aop.RestLog;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * Created by dell on 2017/9/28.
 */
@RestLog
@Controller
@RequestMapping("/job")
@Scope("prototype")
public class JobController extends LogBase {

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
    @Qualifier("beanJob")
    Job personJob;

    /**
     * 启动D2Job
     *
     * @return
     */
    @RequestMapping("/d2.job")
    @ResponseBody
    public String startD2Job() {
        logger.info("开始执行D2Job.");
        try {

            JobParameter channelJp = new JobParameter("d2Controller");
            JobParameter dateJp = new JobParameter(System.currentTimeMillis());
            Map<String, JobParameter> parameterMap = Maps.newHashMap();
            parameterMap.put("channel", channelJp);
            parameterMap.put("date", dateJp);
            JobParameters jps = new JobParameters(parameterMap);

            JobExecution result = beanJobLauncher.run(d2Job, jps);
            BatchStatus status = result.getStatus();
            return status.getBatchStatus().toString();
        } catch (Exception e) {
            logger.info("启动d2Job错误,异常:{}", e);
            return "exception";
        }
    }


    /**
     * 启动D3Job
     *
     * @return
     */
    @RequestMapping("/d3.job")
    @ResponseBody
    public String startD3Job() {
        logger.info("开始执行D3Job.");
        try {
            JobParameter channelJp = new JobParameter("d3Controller");
            JobParameter dateJp = new JobParameter(System.currentTimeMillis());
            Map<String, JobParameter> parameterMap = Maps.newHashMap();
            parameterMap.put("channel", channelJp);
            parameterMap.put("date", dateJp);
            JobParameters jps = new JobParameters(parameterMap);

            JobExecution result = beanJobLauncher.run(d3Job, jps);
            BatchStatus status = result.getStatus();
            return status.getBatchStatus().toString();
        } catch (Exception e) {
            logger.info("启动d3Job错误,异常:{}", e);
            return "exception";
        }
    }


    /**
     * 启动测试person
     *
     * @return
     */
    @RequestMapping("/person.job")
    @ResponseBody
    public String startPersonJob() {
        logger.info("开始执行PersonJob.");
        try {
            JobExecution result = beanJobLauncher.run(personJob, new JobParametersBuilder().addDate("time", new Date()).toJobParameters());
            BatchStatus status = result.getStatus();
            return status.getBatchStatus().toString();
        } catch (Exception e) {
            logger.info("启动PersonJob错误,异常:{}", e);
            return "exception";
        }
    }

}
