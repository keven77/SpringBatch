package com.juran.examplemovie.module.d2case.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.juran.core.web.response.BasePageRespBean;
import com.juran.examplemovie.app.util.MDQueryUtil;
import com.juran.examplemovie.module.d2case.bean.D2CasePO;
import com.juran.examplemovie.module.d2case.service.D2Service;
import com.juran.examplemovie.module.utils.ClassUtil;
import com.juran.examplemovie.module.utils.LogBase;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/9/27.
 */
@Service
public class D2ServiceImpl extends LogBase implements D2Service {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insertBean(D2CasePO d2CasePO) {
    }

    @Override
    public D2CasePO getBeanByOne(Long id) {
        Map<String, Object> valuesMap = Maps.newHashMap();
        valuesMap.put("assetId", id);
        Query basicQuery = MDQueryUtil.getDBObjectByValues(valuesMap);
        D2CasePO dbObject = mongoTemplate.findOne(basicQuery, D2CasePO.class);
        if (null == dbObject) {
            logger.info("数据不存在,assetId:{}", id);
        }
        return dbObject;
    }

    @Override
    public Boolean insertD2Bean(D2CasePO d2CasePO) {
        D2CasePO dbObject = this.getBeanByOne(d2CasePO.getAssetId());
        if (StringUtils.isEmpty(dbObject)) {
            mongoTemplate.insert(d2CasePO);
            logger.info("2D案例插入成功,案例ID:{},案例名称:{}", d2CasePO.getAssetId(), d2CasePO.getTitle());
            return Boolean.TRUE;
        } else {
            logger.info("2D案例已经存在,案例ID:{},案例名称:{}", d2CasePO.getAssetId(), d2CasePO.getTitle());
            return Boolean.FALSE;
        }
    }

    @Override
    public int updateD2Bean(D2CasePO t) {
        Map<String, Object> valuesMap = Maps.newHashMap();
        valuesMap.put("assetId", t.getAssetId());
        Query basicQuery = MDQueryUtil.getDBObjectByValues(valuesMap);//构建查询
        Update update = MDQueryUtil.getUpdateByValues(ClassUtil.getClassFieldAndValue(t, Boolean.FALSE));//构建更新
        WriteResult writeResult = mongoTemplate.updateMulti(basicQuery, update, D2CasePO.class);
        if (writeResult.getN() == 0) {
            logger.info("更新2D案例失败,数据不存在,assetId:{}.", t.getAssetId());
        } else {
            logger.info("更新2D案例成功,assetId:{}.", t.getAssetId());
        }
        return writeResult.getN();
    }

    @Override
    public BasePageRespBean<D2CasePO> getMongoObjectList(D2CasePO po, BasePageRespBean<D2CasePO> page) {
        Map<String, Object> valuesMap = ClassUtil.getClassFieldAndValue(po, Boolean.FALSE);
        Query basicQuery = MDQueryUtil.getDBObjectByValuesAndLike(valuesMap, Lists.newArrayList());
        //总条数
        long totalCount = mongoTemplate.count(basicQuery, D2CasePO.class);
        page.setCount(totalCount);
        //分页
        basicQuery.skip(page.getOffset()).limit(page.getLimit());
        List<D2CasePO> resList = mongoTemplate.find(basicQuery, D2CasePO.class);
        page.setData(resList);
        return page;
    }
}
