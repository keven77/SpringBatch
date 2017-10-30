package com.juran.examplemovie.module.d3case.bean;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 11:28 2017/10/25
 */
public class NewD3SpaceInfo {
    /**
     * 空间类型
     */
    private String roomTypeCode;
    /**
     * 空间图片
     */
    private String selectedImageIds;
    /**
     * 空间描述
     */
    private String description;

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

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
