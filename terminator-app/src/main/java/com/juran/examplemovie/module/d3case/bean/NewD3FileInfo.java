package com.juran.examplemovie.module.d3case.bean;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 11:33 2017/10/25
 */
public class NewD3FileInfo {
    /**
     * 选中的全景图ID
     */
    private String selectedImageIds;
    /**
     * 描述
     */
    private String description;

    public String getSelectedImageIds() {
        return selectedImageIds;
    }

    public void setSelectedImageIds(String selectedImageIds) {
        this.selectedImageIds = selectedImageIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
