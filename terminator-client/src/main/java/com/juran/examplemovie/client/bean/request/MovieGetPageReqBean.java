package com.juran.examplemovie.client.bean.request;

import javax.ws.rs.QueryParam;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MovieGetPageReqBean extends MovieGetListReqBean{

	private static final long serialVersionUID = 5950779887316768345L;
	
	@QueryParam("offset")
	private Integer offset;
	@QueryParam("limit")
	private Integer limit;
	
}
