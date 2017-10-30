package com.juran.examplemovie.app.service;

import java.util.List;

import com.juran.examplemovie.client.bean.domain.BookingDemand;

/**
 * 
 * @author 宋明旭
 * @date 2017年9月2日 下午17:22:36
 * @version 1.0
 * @description acs 需求项目相关服务
 *
 */
public interface IAcsDemandService {
	
	List<BookingDemand> getDemands(int limit,int offset);
	
}
