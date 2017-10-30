package com.juran.examplemovie.client.execption.enums;

/**
 * 
 * @author 王云龙
 * @date 2017年5月8日 下午1:38:23
 * @version 1.0
 * @description 主材相关错误枚举
 *
 */
public enum MovieErrorEnum {
	
	SELECT_MOVIE_BY_ID_MUST_HAS_EXECUTE(200010001,"通过ID查询电影必须传递execute"),
	SELECT_MOVIE_BY_ID_MUST_HAS_ID(200010002,"通过ID查询电影必须传递电影id"),
	SELECT_MOVIE_BY_PAGE_LIMIT_ERROR(200010002,"分页查询电影时limit非法"),
	SELECT_MOVIE_BY_PAGE_OFFSET_ERROR(200010002,"分页查询电影时offset非法"),
	
	UPDATE_MOVIE_BUT_NOT_HAS_MOVIE(200010003,"更新电影信息但是没找到该电影"),
	UPDATE_MOVIE_MUST_HAS_MOVIE_ID(200010003,"更新电影信息必须输入电影ID"),
	UPDATE_MOVIE_MUST_HAS_REGEX_NAME(200010004,"更新电影时输入电影名不合法"),
	UPDATE_MOVIE_ERROR(200010004,"更新电影失败"),
	
	INSERT_MOVIE_BUT_ALREADY_HAS_MOVIE(200010004,"新增电影但是该电影已存在"),
	INSERT_MOVIE_MUST_HAS_NAME(200010004,"新增电影时必须输入电影名"),
	INSERT_MOVIE_MUST_HAS_REGEX_NAME(200010004,"新增电影时输入电影名不合法"),
	INSERT_MOVIE_MUST_HAS_USER_ID(200010004,"新增电影时必须输入用户ID"),
	INSERT_MOVIE_ERROR(200010004,"新增电影失败"),
	
	SERVICE_USER_TIMEOUT(200010004,"movie resource调用user rsource响应超时"),
	SERVICE_USER_HAS_NOT_INSTANCE(200010004,"movie resource调用user rsource没有有效服务"),
	SERVICE_USER_UNKNOW_ERROR(200010004,"movie resource调用user rsource发生未知异常");
	
	private final int errorCode;
	private final String errorMsg;
	
	private MovieErrorEnum(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public static MovieErrorEnum valueOf(int errorCode) {  
        for (MovieErrorEnum accountError : MovieErrorEnum.values()) {  
            if (accountError.errorCode == errorCode) {  
                return accountError;
            }  
        }  
        throw new IllegalArgumentException("No matching constant for [" + errorCode + "]");
    }  	
	
	@Override
	public String toString() {
		return Integer.toString(this.errorCode);
	}
	
}
