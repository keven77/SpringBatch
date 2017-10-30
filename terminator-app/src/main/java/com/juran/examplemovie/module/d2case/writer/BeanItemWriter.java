package com.juran.examplemovie.module.d2case.writer;

import com.juran.examplemovie.module.d2case.bean.NewPerson;
import com.juran.examplemovie.module.d2case.bean.Person;
import com.juran.examplemovie.module.d2case.service.NewPersonService;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dell on 2017/9/27.
 */
@Component
public class BeanItemWriter extends LogBase implements ItemWriter<Person> {

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Autowired
    NewPersonService newPersonService;

    @Override
    public void write(List<? extends Person> items) throws Exception {
        JobParameters parameters = stepExecution.getJobParameters();
        logger.info("WriterParameters:{}", parameters);
        for (Person object : items){
            NewPerson target = new NewPerson();
            BeanUtils.copyProperties(object, target);
            target.setUserName("u_" + object.getName());
            newPersonService.insertBean(target);
        }
    }
}
