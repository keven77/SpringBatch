package com.juran.examplemovie.module.d3case.service;

import com.juran.examplemovie.module.d3case.bean.NewD3CasePo;
import com.juran.examplemovie.module.utils.BaseService;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 10:44 2017/10/26
 */
public interface D3NewService extends BaseService<NewD3CasePo>{
    Boolean insertD3Bean(NewD3CasePo t);
}
