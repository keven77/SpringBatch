package com.juran.examplemovie.module.d2case;

import com.juran.examplemovie.client.bean.domain.D2CaseRetrieveRsp;
import com.juran.examplemovie.module.d2case.bean.D2CasePO;
import com.juran.examplemovie.module.d2case.processor.D2caseProcessor;
import com.juran.examplemovie.module.d2case.reader.D2caseFaiItemReader;
import com.juran.examplemovie.module.d2case.reader.D2caseItemReader;
import com.juran.examplemovie.module.d2case.reader.D2caseSucItemReader;
import com.juran.examplemovie.module.d2case.writer.D2caseItemWriter;
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
 * @author pengbo
 * @version V1.0
 * @Title: 2d案例Job
 * @date 2017/09/28
 */
@Component
public class D2caseBatchConfig extends LogBase {

    @Autowired
    D2caseItemReader d2caseItemReader;
    @Autowired
    D2caseProcessor d2caseProcessor;
    @Autowired
    D2caseItemWriter d2caseItemWriter;

    @Autowired
    D2caseSucItemReader d2caseSucItemReader;
    @Autowired
    D2caseFaiItemReader d2caseFaiItemReader;
    @Autowired
    ThreadLocalUtil threadLocalUtil;
    @Autowired
    StepListener stepListener;
    @Autowired
    JobListener jobListener;

    @Bean(name = "d2Job")
    public Job d2ImportJob(JobBuilderFactory jobs, @Qualifier("d2Step") Step step, @Qualifier("d2StepSuc") Step stepSuc, @Qualifier("d2StepFai") Step stepFai) {
        return jobs.get("d2Job")
                .incrementer(new RunIdIncrementer())
                .flow(step).next(stepSuc).next(stepFai)
                .end()
                .listener(jobListener)
                .build();
    }

    @Bean(name = "d2Step")
    public Step d2caseStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("d2Step")
                .<List<D2CaseRetrieveRsp>, List<D2CasePO>>chunk(1)
                .reader(d2caseItemReader)
                .processor(d2caseProcessor)
                .writer(d2caseItemWriter)
                .faultTolerant().skipLimit(100).skip(Exception.class).retryLimit(5).retry(Exception.class)
                .listener(stepListener)
                .build();
    }

    @Bean(name = "d2StepSuc")
    public Step d2caseStepSuc(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("d2StepSuc")
                .<List<D2CaseRetrieveRsp>, List<D2CasePO>>chunk(5)
                .reader(d2caseSucItemReader)
                .processor(d2caseProcessor)
                .writer(d2caseItemWriter)
                .faultTolerant().skipLimit(100).skip(Exception.class).retryLimit(5).retry(Exception.class)
                .listener(stepListener)
                .build();
    }

    @Bean(name = "d2StepFai")
    public Step d2caseStepFai(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("d2StepFai")
                .<List<D2CaseRetrieveRsp>, List<D2CasePO>>chunk(1)
                .reader(d2caseFaiItemReader)
                .processor(d2caseProcessor)
                .writer(d2caseItemWriter)
                .faultTolerant().skipLimit(100).skip(Exception.class).retryLimit(5).retry(Exception.class)
                .listener(stepListener)
                .build();
    }

}
