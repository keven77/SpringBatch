package com.juran.examplemovie.app.service;

import java.util.List;

import com.juran.examplemovie.client.bean.domain.D3CaseRetrieveRsp;

/**
 * 
 * @author 宋明旭
 * @date 2017年9月2日 下午17:22:36
 * @version 1.0
 * @description acs 3D方案相关服务
 *
 */
public interface IAcsD3CasesService {
	
	/**
	 * 获取案例入库列表数据
	 */
	List<D3CaseRetrieveRsp> getAllDesignersCases(int limit,int offset);
	
	/**
	 * 获取精选案例库案例
	 */
	List<D3CaseRetrieveRsp> getAdminCases(int limit,int offset);
	
}
