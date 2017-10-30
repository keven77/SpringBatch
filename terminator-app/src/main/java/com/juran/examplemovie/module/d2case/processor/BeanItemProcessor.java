package com.juran.examplemovie.module.d2case.processor;

import com.juran.examplemovie.module.d2case.bean.NewPerson;
import com.juran.examplemovie.module.d2case.bean.Person;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2017/9/27.
 */
@Component
public class BeanItemProcessor extends LogBase implements ItemProcessor<Person, NewPerson> {

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public NewPerson process(Person item) throws Exception {
        JobParameters parameters = stepExecution.getJobParameters();
        logger.info("ProcessorParameters:{}", parameters);
        NewPerson target = new NewPerson();
        BeanUtils.copyProperties(item, target);
        target.setUserName("u_" + item.getName());
        return target;
    }
}
