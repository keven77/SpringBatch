package com.juran.examplemovie.module.d3case.service.impl;

import com.juran.core.web.response.BasePageRespBean;
import com.juran.examplemovie.module.d3case.bean.NewD3CasePo;
import com.juran.examplemovie.module.d3case.service.D3NewService;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 10:46 2017/10/26
 */
@Service
public class D3NewServiceImpl extends LogBase implements D3NewService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insertBean(NewD3CasePo d3CasePO) {

    }

    @Override
    public NewD3CasePo getBeanByOne(Long id) {
        return null;
    }

    @Override
    public BasePageRespBean<NewD3CasePo> getMongoObjectList(NewD3CasePo newD3CasePo, BasePageRespBean<NewD3CasePo> page) {
        return null;
    }

    @Override
    public Boolean insertD3Bean(NewD3CasePo d3CasePO) {
        NewD3CasePo dbObject = this.getBeanByOne(d3CasePO.getCaseId());
        if (StringUtils.isEmpty(dbObject)) {
            mongoTemplate.insert(d3CasePO);
            logger.info("新3D案例插入成功,案例ID:{}", d3CasePO.getCaseId());
            return Boolean.TRUE;
        } else {
            logger.info("新3D案例已经存在,案例ID:{}", d3CasePO.getCaseId());
            return Boolean.FALSE;
        }
    }
}
