package com.juran.examplemovie.module.dictionary.bean;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by dell on 2017/10/10.
 */
@Document(collection = "dictionary")
public class DictionaryPO implements Serializable {

    private static final long serialVersionUID = -6450733807262574377L;

    private String name;

    private String value;

    private String type;

    private Integer sort;

    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
