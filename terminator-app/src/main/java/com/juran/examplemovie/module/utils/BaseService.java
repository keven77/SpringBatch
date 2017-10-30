package com.juran.examplemovie.module.utils;

import com.juran.core.web.response.BasePageRespBean;

/**
 * Created by dell on 2017/9/27.
 */
public interface BaseService<T> {

    void insertBean(T t);

    T getBeanByOne(Long id);

    BasePageRespBean<T> getMongoObjectList(T t, BasePageRespBean<T> page);

}
