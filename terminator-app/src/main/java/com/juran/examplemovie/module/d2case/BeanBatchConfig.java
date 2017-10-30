package com.juran.examplemovie.module.d2case;

import com.juran.examplemovie.app.dao.bean.Person;
import com.juran.examplemovie.module.listener.JobListener;
import com.juran.examplemovie.module.d2case.processor.BeanItemProcessor;
import com.juran.examplemovie.module.d2case.reader.BeanItemReader;
import com.juran.examplemovie.module.d2case.writer.BeanItemWriter;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2017/9/27.
 */
//@Configuration
//@EnableBatchProcessing // 开启批处理
@Component
public class BeanBatchConfig extends LogBase {

    @Autowired
    BeanItemProcessor beanItemProcessor;
    @Autowired
    BeanItemWriter beanItemWriter;
    @Autowired
    BeanItemReader beanItemReader;
    @Autowired
    JobListener jobListener;

    @Bean(name = "beanJob")
    public Job importJob(JobBuilderFactory jobs, @Qualifier("beanStep")Step step) {
        return jobs.get("beanJob")
                .incrementer(new RunIdIncrementer())
                .listener(jobListener)
                .flow(step)
                .end()
                .build();
    }

    @Bean(name = "beanStep")
    public Step personStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("beanStep")
                .<Person, Person>chunk(1)
                .listener(jobListener)
                .reader(beanItemReader)
                .processor(beanItemProcessor)
                .writer(beanItemWriter)
                .build();
    }

}
