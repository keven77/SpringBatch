package com.juran.examplemovie.module.d3case;

import com.juran.examplemovie.client.bean.domain.D3CaseRetrieveRsp;
import com.juran.examplemovie.module.d3case.bean.D3CasePO;
import com.juran.examplemovie.module.d3case.processor.D3caseAdminProcessor;
import com.juran.examplemovie.module.d3case.processor.D3caseNorProcessor;
import com.juran.examplemovie.module.d3case.reader.D3caseAdminItemReader;
import com.juran.examplemovie.module.d3case.reader.D3caseNorItemReader;
import com.juran.examplemovie.module.d3case.writer.D3caseItemWriter;
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
 * @date 17:14 2017/9/28
 */
@Component
public class D3caseBatchConfig extends LogBase {

    @Autowired
    D3caseNorItemReader d3caseNorItemReader;
    @Autowired
    D3caseAdminItemReader d3caseAdminItemReader;

    @Autowired
    D3caseNorProcessor d3caseNorProcessor;
    @Autowired
    D3caseAdminProcessor d3caseAdminProcessor;

    @Autowired
    D3caseItemWriter d3caseItemWriter;

    @Autowired
    ThreadLocalUtil threadLocalUtil;
    @Autowired
    StepListener stepListener;
    @Autowired
    JobListener jobListener;

    @Bean(name = "d3Job")
    public Job d3ImportJob(JobBuilderFactory jobs, @Qualifier("d3StepNor") Step stepNor, @Qualifier("d3StepAdm") Step stepAdm) {
        return jobs.get("d3Job")
                .incrementer(new RunIdIncrementer())
                .flow(stepNor).next(stepAdm)
                .end()
                .listener(jobListener)
                .build();
    }

    @Bean(name = "d3StepNor")
    public Step d3caseStepNor(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("d3StepNor")
                .<List<D3CaseRetrieveRsp>, List<D3CasePO>>chunk(5)
                .reader(d3caseNorItemReader)
                .processor(d3caseNorProcessor)
                .writer(d3caseItemWriter)
                .faultTolerant().skipLimit(100).skip(Exception.class).retryLimit(5).retry(Exception.class)
                .listener(stepListener)
                .build();
    }

    @Bean(name = "d3StepAdm")
    public Step d3caseStepAdm(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("d3StepAdm")
                .<List<D3CaseRetrieveRsp>, List<D3CasePO>>chunk(5)
                .reader(d3caseAdminItemReader)
                .processor(d3caseAdminProcessor)
                .writer(d3caseItemWriter)
                .faultTolerant().skipLimit(100).skip(Exception.class).retryLimit(5).retry(Exception.class)
                .listener(stepListener)
                .build();
    }

}
