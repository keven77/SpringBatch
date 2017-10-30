package com.juran.examplemovie.module.project;

import com.juran.examplemovie.client.bean.domain.BookingDemand;
import com.juran.examplemovie.module.listener.JobListener;
import com.juran.examplemovie.module.listener.StepListener;
import com.juran.examplemovie.module.project.bean.DemandPO;
import com.juran.examplemovie.module.project.processor.DemandProcessor;
import com.juran.examplemovie.module.project.reader.DemandItemReader;
import com.juran.examplemovie.module.project.writer.DemandItemWriter;
import com.juran.examplemovie.module.utils.LogBase;
import com.juran.examplemovie.module.utils.ThreadLocalUtil;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 项目
 * @date 12:16 2017/9/29
 */
@Component
public class ProjBatchConfig extends LogBase{

    @Autowired
    DemandItemReader demandItemReader;
    @Autowired
    DemandProcessor demandProcessor;
    @Autowired
    DemandItemWriter demandItemWriter;

    @Autowired
    ThreadLocalUtil threadLocalUtil;
    @Autowired
    StepListener stepListener;
    @Autowired
    JobListener jobListener;

    @Bean(name = "demandJob")
    public Job d2ImportJob(JobBuilderFactory jobs, @Qualifier("demandStep") Step step) {
        return jobs.get("demandJob")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .listener(jobListener)
                .build();
    }

    @Bean(name = "demandStep")
    public Step d2caseStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("demandStep")
                .<List<BookingDemand>, List<DemandPO>>chunk(1)
                .reader(demandItemReader)
                .processor(demandProcessor)
                .writer(demandItemWriter)
                .faultTolerant().skipLimit(100).skip(Exception.class).retryLimit(5).retry(Exception.class)
                .listener(stepListener)
                .build();
    }
}
