package com.juran.examplemovie.client.bean.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2017/8/14.
 */
public class RspD2Case implements Serializable {
    private static final long serialVersionUID = -5421074651601774102L;

    private List<DesignFileReq> data;

    private String description;

    private String typeName;

    private String typeKey;

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public List<DesignFileReq> getData() {
        return data;
    }

    public void setData(List<DesignFileReq> data) {
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
}
