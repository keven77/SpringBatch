package com.juran.examplemovie.app.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpException;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONArray;
import com.autodesk.mp.client.exceptions.NotFoundModelAnnotation;
import com.autodesk.mp.client.models.domainobject.assets.request.AssetGetParameter;
import com.autodesk.mp.client.models.domainobject.assets.result.AssetCollection;
import com.autodesk.mp.client.models.domainobject.assets.result.AssetThumbnail;
import com.autodesk.mp.client.models.domainobject.members.result.MembersAsset;
import com.autodesk.mp.client.utils.acs.admin.AssetAdminUtility;
import com.google.common.collect.Lists;
import com.juran.examplemovie.client.bean.domain.D2Case;
import com.juran.examplemovie.client.bean.domain.D2CaseDescUpdateBean;
import com.juran.examplemovie.client.bean.domain.D2CaseRetrieveRsp;
import com.juran.examplemovie.client.bean.domain.DesignFileReq;
import com.juran.examplemovie.client.bean.domain.RspD2Case;
import com.juran.examplemovie.client.bean.domain.ThumbnailsFileRsp;
import com.juran.examplemovie.client.bean.enums.SpaceMappingEnum;

/**
 * 2D案例数据转换
 * 
 * @author songsen.zhang
 * @version 2016年5月31日 2016年5月31日 下午4:15:09 songsen.zhang 创建
 */
public class D2CaseBeanConverter
{
	
	public static List<D2CaseRetrieveRsp> getCases(List<MembersAsset> assets){
		List<D2CaseRetrieveRsp> caseRetrieveRsps = new ArrayList<>();
		if (assets != null && assets.size() > 0) {
			for (MembersAsset membersAsset : assets) {
				D2CaseRetrieveRsp caseInfo = getCaseInfo(membersAsset.getAssetId());
				caseRetrieveRsps.add(caseInfo);
			}
		}
		return caseRetrieveRsps;
	}
	
	public static D2CaseRetrieveRsp getCaseInfo(Long assetId){
		 //获取AsSet
		try {
			AssetCollection asset = AssetAdminUtility.retrieve(new AssetGetParameter(true, true, assetId));
			// 获取2D案例详情
			D2Case d2Case = D2CaseBeanConverter.toD2Case(asset);
			return toD2CaseRetrieveRsp(d2Case, D2CaseBeanConverter.getFIlesByAsSet(asset));
		} catch (UnsupportedOperationException | ClassNotFoundException | NoSuchFieldException | SecurityException
				| NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | HttpException | NotFoundModelAnnotation e) {
			return null;
		}
	}
	
	/**
	 * 将Asset转换为2D案例<br>
	 * 
	 * @param asset
	 *            Asset
	 * @return
	 * @return D2Case
	 */
	public static D2Case toD2Case( final AssetCollection asset )
	{
		final D2Case d2Case = JSONCustomDataUtility.toObject(asset.getExtendedData(), D2Case.class);
		d2Case.setId(asset.getAssetId().toString());
		d2Case.setFavoriteCount((long) asset.getFavoriteCount());
		return d2Case;
	}
	
	/**
	 * 从Asset 中直接获取 Thumbnails<br>
	 *
	 * @param asset
	 * @return List<ThumbnailsFileRsp>
	 */
	public static List<ThumbnailsFileRsp> getFIlesByAsSet(final AssetCollection asset) {
		List<ThumbnailsFileRsp> result = new ArrayList<ThumbnailsFileRsp>();
		for (AssetThumbnail thumbnailsFileRsp : asset.getThumbnails()) {
			ThumbnailsFileRsp rsp = new ThumbnailsFileRsp(String.valueOf(thumbnailsFileRsp.getFileId()), thumbnailsFileRsp.getCaption(),
					thumbnailsFileRsp.getThumbPathPrefix(), thumbnailsFileRsp.isPrimary());
			rsp.setDescription(thumbnailsFileRsp.getDescription());
			result.add(rsp);
		}
		return result;
	}
	
    /**
     * 转换数据
     * @param d2Case
     * @param designer
     * @param images
     * @return
     */
    public static D2CaseRetrieveRsp toD2CaseRetrieveRsp(final D2Case d2Case, final List<ThumbnailsFileRsp> images) {
        Long area = 0L;
        try {
            area = Double.valueOf(d2Case.getRoomArea()).longValue();
        } catch (Exception e) {
        	
        }
//        d2Case.setPrjPrice(NumberUtility.divide(d2Case.getPrjPrice()));
        d2Case.setProtocolPrice(NumberUtility.divide(d2Case.getProtocolPrice()));
        D2CaseRetrieveRsp result = new D2CaseRetrieveRsp(d2Case.getAuditDesc(), d2Case.getBedroom(), d2Case.getCaseColor(), d2Case.getCaseType(), d2Case.getCity(),
                d2Case.getCityName(), d2Case.getClickNumber(), d2Case.getCommunityName(), d2Case.getCreateDate(), d2Case.getCustomStringStatus(), d2Case.getDecorationType(),
                d2Case.getDescription(), null, d2Case.getDesignerId(), d2Case.getDistrict(), d2Case.getDistrictName(), d2Case.getFavoriteCount(), d2Case.getHouseType(),
                d2Case.getHsDesignerUid(), d2Case.getId(), d2Case.getIsRecommended(), d2Case.getPrjBasePrice(), d2Case.getPrjFurniturePrice(), d2Case.getPrjHiddenPrice(),
                d2Case.getPrjMaterialPrice(), d2Case.getPrjOtherPrice(), d2Case.getPrjPrice(), d2Case.getProjectStyle(), d2Case.getProtocolPrice(), d2Case.getProvince(),
                d2Case.getProvinceName(), d2Case.getRestroom(), area.toString(), d2Case.getRoomType(), d2Case.getSearchTag(), d2Case.getTitle(), d2Case.getWeight(), images,
                d2Case.getSort(), d2Case.getSortType(), d2Case.getCustomStringSortType(), d2Case.getCustomStringName());
        result.setChannel(d2Case.getChannel());
        result.setContest(d2Case.getContest());
        result.setStore(d2Case.getStore());
        result.setActivityRealName(d2Case.getActivityRealName());
        result.setActivityProvince(d2Case.getActivityProvince());
        result.setActivityProvinceName(d2Case.getActivityProvinceName());
        result.setActivityCity(d2Case.getActivityCity());
        result.setActivityCityName(d2Case.getActivityCityName());
        result.setActivityDistrict(d2Case.getActivityDistrict());
        result.setActivityDistrictName(d2Case.getActivityDistrictName());
        result.setActivityExperience(d2Case.getActivityExperience());
        result.setActivityPersonalHonour(d2Case.getActivityPersonalHonour());
        result.setActivityGraduateFrom(d2Case.getActivityGraduateFrom());
        result.setActivityMotto(d2Case.getActivityMotto());
        result.setActivityAvatar(d2Case.getActivityAvatar());
        result.setActivityTag(d2Case.getActivityTag());
        result.setActivityBrand(d2Case.getActivityBrand());
        result.setActivityCommencementDate(d2Case.getActivityCommencementDate());
        result.setActivityDescDemand(d2Case.getActivityDescDemand());
        result.setActivityDesignSpecification(d2Case.getActivityDesignSpecification());
        result.setIsNew(d2Case.getIsNew());
        result.setSpecialTag(d2Case.getSpecialTag());
        List<RspD2Case> roomImages = getReturnD2Case(d2Case);
        setRoomInfo(images, roomImages);
        List<RspD2Case> sortList = sortList(roomImages);
        result.setRoomImages(sortList);
        List<ThumbnailsFileRsp> imageList = result.getImages();
        if (imageList != null && imageList.size() > 0) {
        	Map<Boolean, String> imagMap = new HashMap<>();
			for (ThumbnailsFileRsp thumbnailsFileRsp : imageList) {
				imagMap.put(thumbnailsFileRsp.getIsPrimary(), "1");
			}
			//不存在主图
			if (!imagMap.containsKey(true)) {
				ThumbnailsFileRsp thumbnailsFileRsp = imageList.get(0);
				thumbnailsFileRsp.setIsPrimary(true);
			}
		}
        return result;
    }
    
    /**
     * 封装对象
     * @param d2Case
     * @return
     */
    public static List<RspD2Case> getReturnD2Case(D2Case d2Case){
        List<RspD2Case> roomImages = Lists.newArrayList();
        String d2String = d2Case.getD2CaseDescList();
        JSONArray array = JSONArray.parseArray(d2String);
        List<D2CaseDescUpdateBean> updateBeenList = Lists.newArrayList();
        if (array != null) {
        	for (int i=0;i< array.size();i++){
        		D2CaseDescUpdateBean bean = JSONCustomDataUtility.toObject(array.get(i), D2CaseDescUpdateBean.class);
        		updateBeenList.add(bean);
        	}
		}
        for (D2CaseDescUpdateBean bean : updateBeenList){
            RspD2Case rspD2Case = new RspD2Case();
            rspD2Case.setTypeName(SpaceMappingEnum.designName(bean.getRoomType()));
            rspD2Case.setDescription(bean.getDescription());
            rspD2Case.setTypeKey(bean.getRoomType());
            roomImages.add(rspD2Case);
        }
        return roomImages;
    }
    
    /**
     * 组装返回数据
     * @param images
     * @param roomImages
     */
    public static void setRoomInfo(List<ThumbnailsFileRsp> images, List<RspD2Case> roomImages){
        for (RspD2Case d2Case : roomImages){
            List<DesignFileReq> fileList = d2Case.getData();
            for (ThumbnailsFileRsp th : images){
                if (d2Case.getTypeKey().equalsIgnoreCase(th.getDescription())){
                    DesignFileReq fileReq = new DesignFileReq();
                    fileReq.setId(th.getFileId());
                    fileReq.setLink(th.getFileUrl());
                    fileReq.setName(th.getFileName());
                    fileReq.setIsPrimary(th.getIsPrimary());
                    if (CollectionUtils.isEmpty(fileList)){
                        fileList = Lists.newArrayList();
                    }
                    fileList.add(fileReq);
                }
            }
            d2Case.setData(fileList);
        }
    }
    
    /**
     * 排序
     * @param roomImages
     * @return
     */
    public static List<RspD2Case> sortList(List<RspD2Case> roomImages){
        List<RspD2Case> sortList = Lists.newArrayList();
        List<SpaceMappingEnum> enumList = Lists.newArrayList();
        for (RspD2Case d2Case : roomImages){
            enumList.add(SpaceMappingEnum.getEnumByValue(d2Case.getTypeKey()));
        }
        enumList.sort((SpaceMappingEnum s1, SpaceMappingEnum s2) -> s1.getSort().compareTo(s2.getSort()));
        for (SpaceMappingEnum num : enumList){
            for (RspD2Case d2Case : roomImages){
                if (num.getValue().equalsIgnoreCase(d2Case.getTypeKey())){
                    sortList.add(d2Case);
                    break;
                }
            }
        }
        return sortList;
    }
}
