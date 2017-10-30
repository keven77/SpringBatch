package com.juran.examplemovie.app.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.autodesk.mp.client.exceptions.NotFoundModelAnnotation;
import com.autodesk.mp.client.models.domainobject.members.request.MemberAssetsGetParameter;
import com.autodesk.mp.client.models.domainobject.members.result.MembersAsset;
import com.autodesk.mp.client.models.domainobject.members.result.MembersAssetsCollection;
import com.autodesk.mp.client.utils.acs.admin.MembersAdminAssetsUtility;
import com.juran.examplemovie.app.service.IAcsD3CasesService;
import com.juran.examplemovie.app.util.D3CaseBeanConverter;
import com.juran.examplemovie.client.bean.domain.D3CaseRetrieveRsp;

/**
 * 
 * @author 宋明旭
 * @date 2017年6月8日 下午12:23:17
 * @version 1.0
 * @description acs 3D方案服务实现
 *
 */
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class AcsD3CasesServiceImpl implements IAcsD3CasesService {

	@Override
	public List<D3CaseRetrieveRsp> getAllDesignersCases(int limit, int offset) {
		List<MembersAsset> list = getPageList(false,limit,offset);
		try {
			return D3CaseBeanConverter.toD3CaseSearchRsp(list);
		} catch (UnsupportedOperationException | ClassNotFoundException | NoSuchFieldException | SecurityException
				| NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | HttpException | NotFoundModelAnnotation e) {
			return null;
		}
	}

	@Override
	public List<D3CaseRetrieveRsp> getAdminCases(int limit, int offset) {
		List<MembersAsset> list = getPageList(true,limit,offset);
		try {
			return D3CaseBeanConverter.toD3CaseSearchRsp(list);
		} catch (UnsupportedOperationException | ClassNotFoundException | NoSuchFieldException | SecurityException
				| NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | HttpException | NotFoundModelAnnotation e) {
			return null;
		}
	}

	/**
	 * 获取所有方案的列表
	 * 
	 * @param mediaTypeId
	 * @return
	 */
	public static List<MembersAsset> getList(boolean appFeatured) {
		List<MembersAsset> list = new ArrayList<>();
		Integer limit = 50;
		Integer offset = 0;
		MembersAssetsCollection retrieve = new MembersAssetsCollection();
		do {
			retrieve = getAssets(getMemberAssetsParameter(limit, offset, appFeatured));
			list.addAll(retrieve.getAssets());
			offset += 50;
		} while (list.size() < retrieve.getCount());

		return list;
	}

	/**
	 * 获取所有方案的列表
	 * 
	 * @param mediaTypeId
	 * @return
	 */
	public static List<MembersAsset> getPageList(boolean appFeatured, int limit, int offset) {
		MembersAssetsCollection retrieve = getAssets(getMemberAssetsParameter(limit, offset, appFeatured));
		return retrieve.getAssets();
	}

	/**
	 * 封装查询对象memberAssets
	 * 
	 * @return
	 */
	public static MemberAssetsGetParameter getMemberAssetsParameter(int limit, int offset, boolean appFeatured) {
		MemberAssetsGetParameter memberAssetsGetParameter = new MemberAssetsGetParameter();
		memberAssetsGetParameter.setId(20742718l);
		memberAssetsGetParameter.setSoftware("96");
		memberAssetsGetParameter.setLimit(limit);
		memberAssetsGetParameter.setOffset(offset);
		memberAssetsGetParameter.setSortBy("date");
		memberAssetsGetParameter.setSortOrder("desc");
		memberAssetsGetParameter.setMediaTypeIds("60");
		memberAssetsGetParameter.setExtendedData(true);
		memberAssetsGetParameter.setRoleIds("4");
		memberAssetsGetParameter.setRolesOnly(false);
		memberAssetsGetParameter.setReferencedAssets(true);
		memberAssetsGetParameter.setApp_featured(appFeatured);// 3D是否入库判断参数，false,表示是原来的3D，true表示是新复制的3D
		memberAssetsGetParameter.setCustomDataIncludeAll(true);// 查询条件为且的关系，false的话为或的关系
		memberAssetsGetParameter.setAssetStatus("public");// 查询公共数据部分
		memberAssetsGetParameter.setCustomDataIncludeAll(false);
		return memberAssetsGetParameter;
	}

	/**
	 * 获取assets
	 * 
	 * @param memberAssetsGetParameter
	 */
	public static MembersAssetsCollection getAssets(MemberAssetsGetParameter memberAssetsGetParameter) {
		MembersAssetsCollection retrieve = new MembersAssetsCollection();
		try {
			retrieve = MembersAdminAssetsUtility.retrieve(memberAssetsGetParameter);
		} catch (UnsupportedOperationException | ClassNotFoundException | NoSuchFieldException | SecurityException
				| NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | HttpException | NotFoundModelAnnotation e) {
			e.printStackTrace();
		}
		System.out.println(retrieve.getCount());
		return retrieve;

	}

}
