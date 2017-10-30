package com.juran.examplemovie.module.d3case.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.juran.core.web.response.BasePageRespBean;
import com.juran.examplemovie.app.util.MDQueryUtil;
import com.juran.examplemovie.module.d3case.bean.D3CasePO;
import com.juran.examplemovie.module.d3case.service.D3Service;
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
 * Created by dell on 2017/9/29.
 */
@Service
public class D3ServiceImpl extends LogBase implements D3Service {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insertBean(D3CasePO d3CasePO) {
    }

    @Override
    public D3CasePO getBeanByOne(Long id) {
        Map<String, Object> valuesMap = Maps.newHashMap();
        valuesMap.put("designAssetId", id);
        Query basicQuery = MDQueryUtil.getDBObjectByValues(valuesMap);
        D3CasePO dbObject = mongoTemplate.findOne(basicQuery, D3CasePO.class);
        if (null == dbObject) {
            logger.info("D3数据不存在,designAssetId:{}", id);
        }
        return dbObject;
    }

    @Override
    public BasePageRespBean<D3CasePO> getMongoObjectList(D3CasePO po, BasePageRespBean<D3CasePO> page) {
        Map<String, Object> valuesMap = ClassUtil.getClassFieldAndValue(po, Boolean.FALSE);
        Query basicQuery = MDQueryUtil.getDBObjectByValuesAndLike(valuesMap, Lists.newArrayList());
        long totalCount = mongoTemplate.count(basicQuery, D3CasePO.class);
        page.setCount(totalCount);
        basicQuery.skip(page.getOffset()).limit(page.getLimit());
        List<D3CasePO> resList = mongoTemplate.find(basicQuery, D3CasePO.class);
        page.setData(resList);
        return page;
    }

    @Override
    public Boolean insertD3Bean(D3CasePO d3CasePO) {
        D3CasePO dbObject = this.getBeanByOne(d3CasePO.getDesignAssetId());
        if (StringUtils.isEmpty(dbObject)) {
            mongoTemplate.insert(d3CasePO);
            logger.info("3D案例插入成功,案例ID:{},案例名称:{}", d3CasePO.getDesignAssetId(), d3CasePO.getCustomStringName());
            return Boolean.TRUE;
        } else {
            logger.info("3D案例已经存在,案例ID:{},案例名称:{}", d3CasePO.getDesignAssetId(), d3CasePO.getCustomStringName());
            return Boolean.FALSE;
        }
    }

    @Override
    public int updateD3Bean(D3CasePO t) {
        Map<String, Object> valuesMap = Maps.newHashMap();
        valuesMap.put("designAssetId", t.getDesignAssetId());
        Query basicQuery = MDQueryUtil.getDBObjectByValues(valuesMap);//构建查询
        Update update = MDQueryUtil.getUpdateByValues(ClassUtil.getClassFieldAndValue(t, Boolean.FALSE));//构建更新
        WriteResult writeResult = mongoTemplate.updateMulti(basicQuery, update, D3CasePO.class);
        if (writeResult.getN() == 0) {
            logger.info("更新3D案例失败,数据不存在,assetId:{}.", t.getDesignAssetId());
        } else {
            logger.info("更新3D案例成功,assetId:{}.", t.getDesignAssetId());
        }
        return writeResult.getN();
    }

    @Override
    public List<String> getUidList(int limit, int offset, String type, String distinctField) {
        Map<String, Object> valuesMap = Maps.newHashMap();
        valuesMap.put("updateStatus", 1);
        valuesMap.put("caseType", type);
        Query basicQuery = MDQueryUtil.getDBObjectByValues(valuesMap);//构建查询
        return mongoTemplate.getCollection("d3Case").distinct(distinctField, basicQuery.getQueryObject());
    }

}
