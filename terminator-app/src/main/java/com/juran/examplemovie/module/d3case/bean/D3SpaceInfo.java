package com.juran.examplemovie.module.d3case.bean;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 18:30 2017/9/28
 */
public class D3SpaceInfo {
    private List<D3FileInfo> data;

    private String description;

    private String typeName;

    private String typeKey;

    private Boolean exist;

    public List<D3FileInfo> getData() {
        return data;
    }

    public void setData(List<D3FileInfo> data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }
}
