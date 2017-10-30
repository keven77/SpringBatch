package com.juran.examplemovie.app.writer;

import com.juran.examplemovie.app.dao.bean.Person;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author pengbo
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: 写入数据操作
 * @date ${date} ${time}
 */
public class PersonItemWriter implements ItemWriter<Person>{
    @Override
    public void write(List<? extends Person> list) throws Exception {

    }

}
