package com.juran.examplemovie.client.bean.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MovieGetRespBean implements Serializable{
	
	private static final long serialVersionUID = 2655723251668803749L;
	
	private Long id;
	private String movieName;
	private Long userId;
	
}
