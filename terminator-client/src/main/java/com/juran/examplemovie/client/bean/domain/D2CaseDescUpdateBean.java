package com.juran.examplemovie.client.bean.domain;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * Created by dell on 2017/8/14.
 */
public class D2CaseDescUpdateBean implements Serializable {
    private static final long serialVersionUID = -4796181301041582990L;

    @XmlAttribute(name = "room_type")
    private String roomType;

    @XmlAttribute(name = "description")
    private String description;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
