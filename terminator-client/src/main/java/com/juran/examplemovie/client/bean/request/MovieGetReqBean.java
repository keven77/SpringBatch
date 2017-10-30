package com.juran.examplemovie.client.bean.request;

import java.io.Serializable;

import javax.ws.rs.PathParam;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MovieGetReqBean implements Serializable{

	private static final long serialVersionUID = 5950779887316768345L;
	
//	@QueryParam("execute")
//	private String execute=UserContants.Execute.BASE;
	@PathParam("movieId")
	private Long id;


}
