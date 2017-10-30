package com.juran.examplemovie.module.d3case.service;

import com.juran.examplemovie.module.d3case.bean.D3CasePO;
import com.juran.examplemovie.module.utils.BaseService;

import java.util.List;

/**
 * Created by dell on 2017/9/29.
 */
public interface D3Service extends BaseService<D3CasePO> {

    Boolean insertD3Bean(D3CasePO t);

    int updateD3Bean(D3CasePO t);

    List<String> getUidList(int limit, int offset, String type, String distinctField);

}
