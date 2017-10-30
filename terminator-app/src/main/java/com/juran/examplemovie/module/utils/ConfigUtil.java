package com.juran.examplemovie.module.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 16:09 2017/9/29
 */
@ConfigurationProperties(prefix = "batchConfig")
public class ConfigUtil {
    private Integer offset;
    private Integer limit;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
