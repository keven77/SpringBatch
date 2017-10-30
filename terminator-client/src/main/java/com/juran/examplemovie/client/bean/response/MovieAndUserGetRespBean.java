package com.juran.examplemovie.client.bean.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MovieAndUserGetRespBean extends MovieGetRespBean{
	
	private static final long serialVersionUID = 2319373492525352371L;
	
	private String userName;
	private String userSex;
	
}
