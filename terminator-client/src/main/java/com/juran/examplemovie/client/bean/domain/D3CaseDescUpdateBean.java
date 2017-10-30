package com.juran.examplemovie.client.bean.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

public class D3CaseDescUpdateBean implements Serializable{

	private static final long serialVersionUID = -6733251227528823375L;
	
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
