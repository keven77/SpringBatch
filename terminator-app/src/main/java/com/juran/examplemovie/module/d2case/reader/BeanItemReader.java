package com.juran.examplemovie.module.d2case.reader;

import com.google.common.collect.Lists;
import com.juran.examplemovie.module.d2case.bean.Person;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dell on 2017/9/27.
 */
@Component
public class BeanItemReader extends LogBase implements ItemReader<Person> {

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    private int count = 0;

    @Override
    public Person read() throws Exception {
        JobParameters parameters = stepExecution.getJobParameters();
        logger.info("ReaderParameters:{}", parameters);
        count++;
        logger.info("-----------------------count:{}--------------------------------", count);
        if (count > 4) {
            return null;
        }
        List<Person> returnList = Lists.newArrayList();
        Person person = new Person();
        person.setAddress("东城区东直门南大街甲3号，东直门桥西南");
        person.setAge(10);
        person.setUid(1L);
        person.setName("熊大");

        Person person2 = new Person();
        person2.setAddress("北京市朝阳区东三环中路7号");
        person2.setAge(12);
        person2.setUid(2L);
        person2.setName("熊二");

        Person person3 = new Person();
        person3.setAddress("海淀区北四环西路9号");
        person3.setAge(13);
        person3.setUid(3L);
        person3.setName("列然");

        Person person4 = new Person();
        person4.setAddress("北京市海淀区中关村东路18号");
        person4.setAge(10);
        person4.setUid(4L);
        person4.setName("屋里");

        returnList.add(person);
        returnList.add(person2);
        returnList.add(person3);
        returnList.add(person4);
        return person;
    }
}
