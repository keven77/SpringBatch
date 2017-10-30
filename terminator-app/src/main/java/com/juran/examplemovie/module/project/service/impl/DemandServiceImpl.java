package com.juran.examplemovie.module.project.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.juran.core.web.response.BasePageRespBean;
import com.juran.examplemovie.app.util.MDQueryUtil;
import com.juran.examplemovie.module.project.bean.DemandPO;
import com.juran.examplemovie.module.project.service.DemandService;
import com.juran.examplemovie.module.utils.ClassUtil;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 实现写入需求项目数据
 * @date 10:22 2017/10/13
 */
@Service
public class DemandServiceImpl extends LogBase implements DemandService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insertBean(DemandPO demandPO) {}

    @Override
    public DemandPO getBeanByOne(Long id) {
        Map<String, Object> valuesMap = Maps.newHashMap();
        valuesMap.put("assetId", id);
        Query basicQuery = MDQueryUtil.getDBObjectByValues(valuesMap);
        DemandPO dbObject = mongoTemplate.findOne(basicQuery, DemandPO.class);
        if (null == dbObject) {
            logger.info("数据不存在,assetId:{}", id);
        }
        return dbObject;
    }

    @Override
    public BasePageRespBean<DemandPO> getMongoObjectList(DemandPO demandPO, BasePageRespBean<DemandPO> page) {
        Map<String, Object> valuesMap = ClassUtil.getClassFieldAndValue(demandPO, Boolean.FALSE);
        Query basicQuery = MDQueryUtil.getDBObjectByValuesAndLike(valuesMap, Lists.newArrayList());
        //总条数
        long totalCount = mongoTemplate.count(basicQuery, DemandPO.class);
        page.setCount(totalCount);
        //分页
        basicQuery.skip(page.getOffset()).limit(page.getLimit());
        List<DemandPO> resList = mongoTemplate.find(basicQuery, DemandPO.class);
        page.setData(resList);
        return page;
    }

    @Override
    public Boolean insertDemandBean(DemandPO demandPO) {
        DemandPO dbObject = this.getBeanByOne(demandPO.getAssetId());
        if (StringUtils.isEmpty(dbObject)) {
            mongoTemplate.insert(demandPO);
            logger.info("项目插入成功,项目ID:{}", demandPO.getAssetId());
            return Boolean.TRUE;
        } else {
            logger.info("项目已经存在,项目ID:{}", demandPO.getAssetId());
            return  Boolean.FALSE;
        }
    }
}
