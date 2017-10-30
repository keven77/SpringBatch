package com.juran.examplemovie.module.d2case.service;

import com.juran.examplemovie.module.d2case.bean.D2CasePO;
import com.juran.examplemovie.module.utils.BaseService;

/**
 * Created by dell on 2017/9/27.
 */
public interface D2Service extends BaseService<D2CasePO> {

    Boolean insertD2Bean(D2CasePO t);

    int updateD2Bean(D2CasePO t);

}
