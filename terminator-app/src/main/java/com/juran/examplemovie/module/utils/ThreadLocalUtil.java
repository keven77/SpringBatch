package com.juran.examplemovie.module.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2017/9/30.
 */
@Component
public class ThreadLocalUtil {

    @Autowired
    private ConfigUtil configUtil;

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return configUtil.getOffset();
        }
    };

    public void setOffset(Integer offset) {
        threadLocal.set(offset);
    }

    public Integer getOffset() {
        return threadLocal.get();
    }

}
