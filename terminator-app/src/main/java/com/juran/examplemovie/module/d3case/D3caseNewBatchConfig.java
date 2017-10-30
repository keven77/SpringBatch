package com.juran.examplemovie.module.d3case;

import com.juran.examplemovie.module.d3case.bean.D3CasePO;
import com.juran.examplemovie.module.d3case.bean.NewD3CasePo;
import com.juran.examplemovie.module.d3case.processor.NewD3caseProcessor;
import com.juran.examplemovie.module.d3case.reader.D3caseNewItemReader;
import com.juran.examplemovie.module.d3case.writer.D3caseNewItemWriter;
import com.juran.examplemovie.module.listener.JobListener;
import com.juran.examplemovie.module.listener.StepListener;
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
 * @Title:
 * @date 10:17 2017/10/26
 */
@Component
public class D3caseNewBatchConfig extends LogBase {
    @Autowired
    D3caseNewItemReader d3caseNewItemReader;
    @Autowired
    D3caseNewItemWriter d3caseNewItemWriter;
    @Autowired
    NewD3caseProcessor newD3caseProcessor;
    @Autowired
    ThreadLocalUtil threadLocalUtil;
    @Autowired
    StepListener stepListener;
    @Autowired
    JobListener jobListener;

    @Bean(name = "d3NewJob")
    public Job d3ImportJob(JobBuilderFactory jobs, @Qualifier("newd3Step") Step stepNew) {
        return jobs.get("d3NewJob")
                .incrementer(new RunIdIncrementer())
                .flow(stepNew)
                .end()
                .listener(jobListener)
                .build();
    }

    @Bean(name = "newd3Step")
    public Step d3caseStepNew(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("newd3Step")
                .<List<D3CasePO>, List<NewD3CasePo>>chunk(5)
                .reader(d3caseNewItemReader)
                .processor(newD3caseProcessor)
                .writer(d3caseNewItemWriter)
                .faultTolerant().skipLimit(100).skip(Exception.class).retryLimit(5).retry(Exception.class)
                .listener(stepListener)
                .build();
    }
}
