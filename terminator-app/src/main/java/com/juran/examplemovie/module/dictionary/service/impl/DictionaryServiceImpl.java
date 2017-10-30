package com.juran.examplemovie.module.dictionary.service.impl;

import com.juran.core.web.response.BasePageRespBean;
import com.juran.examplemovie.module.dictionary.bean.DictionaryPO;
import com.juran.examplemovie.module.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/10/10.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insertBean(DictionaryPO dictionaryPO) {
        mongoTemplate.insert(dictionaryPO);
    }

    @Override
    public DictionaryPO getBeanByOne(Long id) {
        return null;
    }

    @Override
    public BasePageRespBean<DictionaryPO> getMongoObjectList(DictionaryPO dictionaryPO, BasePageRespBean<DictionaryPO> page) {
        return null;
    }
}
