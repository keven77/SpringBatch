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
import com.juran.examplemovie.app.service.IAcsDemandService;
import com.juran.examplemovie.app.util.BeanConverter;
import com.juran.examplemovie.client.bean.domain.BookingDemand;

/**
 * 
 * @author 宋明旭
 * @date 2017年6月8日 下午12:23:17
 * @version 1.0
 * @description acs 需求项目相关服务实现
 *
 */
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class AcsDemandServiceImpl implements IAcsDemandService {

	@Override
	public List<BookingDemand> getDemands(int limit, int offset) {
		// 基于MemberAssetAPI查询列表
		MemberAssetsGetParameter parameter = getParameter(limit, offset);
		try {
			MembersAssetsCollection retrieve = MembersAdminAssetsUtility.retrieve(parameter);
			List<BookingDemand> data = new ArrayList<>();
			if (retrieve != null && retrieve.getCount() > 0) {
				ArrayList<MembersAsset> assets = retrieve.getAssets();
				for (MembersAsset membersAsset : assets) {
					BookingDemand bookingDemand = BeanConverter.getBookingDemand(membersAsset);
					data.add(bookingDemand);
				}
			}
			return data;
		} catch (UnsupportedOperationException | ClassNotFoundException | NoSuchFieldException | SecurityException
				| NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | HttpException | NotFoundModelAnnotation e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 获取asset查询参数
	 */
	private MemberAssetsGetParameter getParameter(Integer limit, Integer offset) {
		MemberAssetsGetParameter memberAssetsGetParameter = new MemberAssetsGetParameter();
		memberAssetsGetParameter.setSoftware("96");
		memberAssetsGetParameter.setRoleIds("4");
		memberAssetsGetParameter.setRolesOnly(true);
		memberAssetsGetParameter.setId(20742718l);
		memberAssetsGetParameter.setLimit(limit);
		memberAssetsGetParameter.setOffset(offset);
		memberAssetsGetParameter.setMediaTypeIds("53");
		memberAssetsGetParameter.setExtendedData(true);
		memberAssetsGetParameter.setSortBy("date");
		memberAssetsGetParameter.setSortOrder("desc");
		return memberAssetsGetParameter;
	}

}
