package com.juran.examplemovie.module.project.service;

import com.juran.examplemovie.module.project.bean.DemandPO;
import com.juran.examplemovie.module.utils.BaseService;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 10:20 2017/10/13
 */
public interface DemandService extends BaseService<DemandPO> {
    Boolean insertDemandBean(DemandPO t);
}
