package com.juran.examplemovie.client.bean.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "用户新增bean")
@ToString
@Getter
@Setter
public class MovieInsertReqBean {
	
	@ApiModelProperty(value = "电影名称",required=true, example = "黑客帝国",position = 1)
	private String movieName;
	@ApiModelProperty(value = "用户ID",required=true, example = "1",position = 2)
	private Long userId;
	
}
