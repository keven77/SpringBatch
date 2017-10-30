package com.juran.examplemovie.module.d2case.bean;

/**
 * Created by dell on 2017/9/27.
 */
public class ImageInfo {

    /**
     * 文件标识
     */
    private String fileId;

    /**
     * 图片名称
     */
    private String fileName;

    /**
     * 图片URL
     */
    private String fileUrl;

    /**
     * 是否为主图
     */
    private Boolean primary ;

    /**
     * 描述图片所属的空间
     */
    private String description;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
