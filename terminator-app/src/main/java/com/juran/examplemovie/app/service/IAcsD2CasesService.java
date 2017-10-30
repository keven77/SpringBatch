package com.juran.examplemovie.app.service;

import java.util.List;

import com.juran.examplemovie.client.bean.domain.D2CaseRetrieveRsp;

/**
 * 
 * @author 宋明旭
 * @date 2017年9月2日 下午17:22:36
 * @version 1.0
 * @description acs 2D方案相关服务
 *
 */
public interface IAcsD2CasesService {
	
	List<D2CaseRetrieveRsp> getAuditWatingCases();
	
	List<D2CaseRetrieveRsp> getAuditSuccessCases(int limit,int offset);
	
	List<D2CaseRetrieveRsp> getAuditFailCases();
	
}
