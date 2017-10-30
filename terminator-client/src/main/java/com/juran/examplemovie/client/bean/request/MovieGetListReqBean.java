package com.juran.examplemovie.client.bean.request;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MovieGetListReqBean  implements Serializable{

	private static final long serialVersionUID = 5950779887316768345L;
	
	@QueryParam("movieId")
	private Long id;
	@QueryParam("movieName")
	private String movieName;
	@QueryParam("userId")
	private Long userId;
	
}
