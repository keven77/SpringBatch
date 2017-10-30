package com.juran.examplemovie.client.bean.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "电影修改bean")
@ToString
@Getter
@Setter
public class MovieUpdateReqBean {
	
	@ApiModelProperty(value = "电影ID",required=true, example = "1",position = 1)
	private Long id;
	@ApiModelProperty(value = "电影名称",required=false, example = "黑客帝国",position = 2)
	private String movieName;
	@ApiModelProperty(value = "用户ID",required=false, example = "1",position = 3)
	private Long userId;
	
}
