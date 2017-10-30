package com.juran.examplemovie.module.d3case.bean;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 18:26 2017/9/28
 */
public class D3FileInfo {
    /**
     * @Fields extended_data 自定义数据
     */
    private String  extendedData;

    /**
     * @Fields id 文件ID
     */
    private String  fileId;

    /**
     * @Fields link URL orURI
     */
    private String  link;

    /**
     * @Fields name 文件名
     */
    private String  name;

    /**
     * @Fields source 来源 0：HS同步 1：上传
     */
    private Integer  source;

    /**
     * @Fields source_id 来源id
     */
    private String  sourceId;

    /**
     * @Fields status 状态
     */
    private Integer  status;

    /**
     * @Fields type 上传的文件类型
     */
    private String  type;

    /**
     * @Fields isPrimary 是否为主图
     */
    private Boolean  primary ;


    /**
     * @Fields data 全景渲染图封面
     */
    private String  cover;

    /**
     * @Fields description 页面展示描述
     */
    private String description;

    private Boolean selected;

    private List<String> modelSeekids;

    public String getExtendedData() {
        return extendedData;
    }

    public void setExtendedData(String extendedData) {
        this.extendedData = extendedData;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public List<String> getModelSeekids() {
        return modelSeekids;
    }

    public void setModelSeekids(List<String> modelSeekids) {
        this.modelSeekids = modelSeekids;
    }
}
