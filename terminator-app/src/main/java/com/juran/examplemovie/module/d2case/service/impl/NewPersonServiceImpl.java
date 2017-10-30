package com.juran.examplemovie.module.d2case.service.impl;

import com.google.common.collect.Maps;
import com.juran.core.utils.json.JsonUtil;
import com.juran.core.web.response.BasePageRespBean;
import com.juran.examplemovie.app.util.MDQueryUtil;
import com.juran.examplemovie.module.d2case.bean.NewPerson;
import com.juran.examplemovie.module.d2case.service.NewPersonService;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by dell on 2017/9/27.
 */
@Service
public class NewPersonServiceImpl extends LogBase implements NewPersonService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insertBean(NewPerson newPerson) {
        logger.info("保存数据:{}", JsonUtil.toJson(newPerson));
        mongoTemplate.insert(newPerson);
    }

    @Override
    public NewPerson getBeanByOne(Long id) {
        logger.info("查询参数ID:{}", id);
        Map<String, Object> valuesMap = Maps.newHashMap();
        valuesMap.put("id", id);
        Query basicQuery = MDQueryUtil.getDBObjectByValues(valuesMap);
        NewPerson dbObject = mongoTemplate.findOne(basicQuery, NewPerson.class);
        if (null == dbObject)
            logger.info("数据不存在,ID:{}", id);
        return dbObject;
    }

    @Override
    public BasePageRespBean<NewPerson> getMongoObjectList(NewPerson newPerson, BasePageRespBean<NewPerson> page) {
        return null;
    }
}
