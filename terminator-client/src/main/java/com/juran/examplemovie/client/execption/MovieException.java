package com.juran.examplemovie.client.execption;

import java.util.UUID;

import com.juran.core.exception.ParentException;
import com.juran.core.exception.bean.ErrorMsgBean;
import com.juran.examplemovie.client.execption.enums.MovieErrorEnum;

/**
 * 
 * @author 王云龙
 * @date 2017年1月18日 下午1:38:07
 * @version 1.0
 * @description 电影相关异常
 *
 */
public class MovieException extends ParentException {

	private static final long serialVersionUID = -6215751052263475161L;
	
	public MovieException(ErrorMsgBean errorMsgBean) {
		this.setErrorMsgBean(errorMsgBean);
	}

	public MovieException(MovieErrorEnum movieErrorEnum) {
		setErrorCode(movieErrorEnum.getErrorCode());
		setErrorMsg(movieErrorEnum.getErrorMsg());
		setErrorId(UUID.randomUUID().toString());
	}

}
