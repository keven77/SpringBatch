package com.juran.examplemovie.app.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autodesk.mp.client.exceptions.NotFoundModelAnnotation;
import com.autodesk.mp.client.models.domainobject.assets.request.AssetGetParameter;
import com.autodesk.mp.client.models.domainobject.assets.result.AssetCollection;
import com.autodesk.mp.client.models.domainobject.assets.result.AssetThumbnail;
import com.autodesk.mp.client.models.domainobject.assets.result.Assets;
import com.autodesk.mp.client.models.domainobject.assets.result.SearchCollection;
import com.autodesk.mp.client.models.domainobject.members.result.KeyFilefolder;
import com.autodesk.mp.client.models.domainobject.members.result.MembersAsset;
import com.autodesk.mp.client.utils.acs.admin.AssetAdminUtility;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.juran.examplemovie.client.bean.domain.D3CaseDescUpdateBean;
import com.juran.examplemovie.client.bean.domain.D3CaseRetrieveRsp;
import com.juran.examplemovie.client.bean.domain.DesignFile;
import com.juran.examplemovie.client.bean.domain.DesignFileReq;
import com.juran.examplemovie.client.bean.domain.RspD3Case;
import com.juran.examplemovie.client.bean.domain.ThreeDimensionalCD;
import com.juran.examplemovie.client.bean.domain.ThumbnailsFileRsp;
import com.juran.examplemovie.client.bean.enums.EnumDesignFileType;
import com.juran.examplemovie.client.bean.enums.SpaceMappingEnum;

/**
 * 3D案例数据转换
 * 
 * @author xiaolan.hou D3CaseBeanConverter
 * @version 2016年8月16日 下午1:59:12
 */
public class D3CaseBeanConverter {
	
	public static final ResourceBundle BUNDLE;

	static {
		BUNDLE = ResourceBundle.getBundle("hsconfig");
	}
	/**
	 * 将列表转换为3D案例列表<br>
	 * 
	 * @param searchList
	 *            assetList
	 * @return
	 * @return D2CaseSearchRsp
	 * @throws HttpException
	 * @throws IOException
	 * @throws UnsupportedOperationException
	 * @throws ClientProtocolException
	 * @throws NotFoundModelAnnotation
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws ClassNotFoundException
	 */
	public static List<D3CaseRetrieveRsp> toD3CaseSearchRsp(final List<MembersAsset> membersAssets)
			throws ClientProtocolException, UnsupportedOperationException, IOException, HttpException,
			ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotFoundModelAnnotation {
		if (membersAssets == null || membersAssets.size() < 1) {
			return null;
		}

		List<D3CaseRetrieveRsp> cases = new ArrayList<>();
		for (final MembersAsset asset : membersAssets) {
			ThreeDimensionalCD d3case = toD3Case(asset);
			if (d3case == null) {
				continue;
			}
			try {
				d3case.setRoomArea(Double.valueOf(d3case.getRoomArea()));
			} catch (Exception e) {
				d3case.setRoomArea((double) 0);
			}
			AssetCollection retrieve = AssetAdminUtility.retrieve(new AssetGetParameter(false, false, asset.getAssetId()));
			D3CaseRetrieveRsp d3CaseRetrieveRsp = toD3CaseRenderImgRetrieveRsp(d3case, getFIles(retrieve));
			cases.add(d3CaseRetrieveRsp);
		}
		return cases;
	}

	/**
	 * 获取3D方案推荐位
	 * 
	 * @return
	 * @throws NotFoundModelAnnotation
	 * @throws HttpException
	 * @throws IOException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws ClassNotFoundException
	 * @throws UnsupportedOperationException
	 * @throws ClientProtocolException
	 */
	public static List<D3CaseRetrieveRsp> getRecommend3DCases(final SearchCollection searchList)
			throws ClientProtocolException, UnsupportedOperationException, ClassNotFoundException, NoSuchFieldException,
			SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, HttpException, NotFoundModelAnnotation {
		if (searchList == null) {
			return null;
		}
		List<D3CaseRetrieveRsp> cases = new ArrayList<>();
		ArrayList<Assets> assets = searchList.getAssets();
		if (assets != null) {
			if (assets.size() > 1) {
				int a = (int) (Math.random() * assets.size());
				int b = (int) (Math.random() * assets.size());
				while (a == b) {
					b = (int) (Math.random() * assets.size());
				}
				List<Integer> indexes = new ArrayList<>();
				indexes.add(a);
				indexes.add(b);
				for (Integer index : indexes) {
					Assets asset = assets.get(index);
					D3CaseRetrieveRsp recommend3dDetail = getRecommend3DDetail(asset);
					if (recommend3dDetail != null) {
						cases.add(recommend3dDetail);
					}
				}
			}
			if (assets.size() > 0 && assets.size() < 1) {
				for (Assets asset : assets) {
					D3CaseRetrieveRsp recommend3dDetail = getRecommend3DDetail(asset);
					cases.add(recommend3dDetail);
				}
			}
		}
		return cases;
	}

	public static D3CaseRetrieveRsp getRecommend3DDetail(Assets asset)
			throws ClientProtocolException, UnsupportedOperationException, IOException, HttpException,
			ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotFoundModelAnnotation {
		ThreeDimensionalCD d3case = toD3Case(asset);
		if (d3case == null) {
			return null;
		}
		try {
			d3case.setRoomArea(Double.valueOf(d3case.getRoomArea()));
		} catch (Exception e) {
			d3case.setRoomArea((double) 0);
		}
		// 获取案例主图
		List<DesignFileReq> images = getMainImages(asset.getThumbPathPrefix());
		return toCaseRetrieveRsp(d3case, images);
	}

	/**
	 * 将Asset转换为3D案例<br>
	 * 
	 * @param asset
	 *            Asset
	 * @return
	 * @return D2Case
	 */
	public static ThreeDimensionalCD toD3Case(final Assets asset) {
		System.out.println(asset.getExtendedData());
		final ThreeDimensionalCD d3Case = JSONCustomDataUtility.toObject(asset.getExtendedData(),
				ThreeDimensionalCD.class);
		d3Case.setDesignAssetId(asset.getId());
		d3Case.setDesignerId(asset.getArtistId());
		d3Case.setFavoriteCount(asset.isFavoriteCount());
		Map<String, Object> map = (Map) asset.getExtendedData();
		List<DesignFile> list = get(map, DesignFile.class, "render-id");
		DesignFileDco dco = new DesignFileDco(d3Case.getDesignFile());
		dco.add(list);
		d3Case.setDesignFile(dco.convertArrayToJson());
		return d3Case;
	}

	/**
	 * 将3D案例CustomData转变为返回对象<br>
	 * 
	 * @param d3Case
	 *            3D案例CustomData @param designer 返回的设计师信息 @return
	 *            TODO返回结果描述 @return D3CaseRetrieveRsp 返回值类型 @throws
	 * @throws NotFoundModelAnnotation
	 * @throws HttpException
	 * @throws IOException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws ClassNotFoundException
	 * @throws UnsupportedOperationException
	 * @throws ClientProtocolException
	 */
	public static D3CaseRetrieveRsp toD3CaseRetrieveRsp(final ThreeDimensionalCD d3Case, final List<ThumbnailsFileRsp> thumbnailsFileRsp)
			throws ClientProtocolException, UnsupportedOperationException, ClassNotFoundException, NoSuchFieldException,
			SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, HttpException, NotFoundModelAnnotation {
		Long designerId;
		D3CaseRetrieveRsp result = null;
		Long area;
		try {
			area = Double.valueOf(d3Case.getRoomArea()).longValue();
		} catch (Exception e) {
			area = 0l;
		}
		if (d3Case != null && d3Case.getHsDesignerUid() != null) {
			String thumbPathPrefix = null;
			List<DesignFileReq> list = new ArrayList<DesignFileReq>();
			// 获取默认主图
			ThumbnailsFileRsp thumbnaillist = DesignBeanConverter.getThumbnailsMain(thumbnailsFileRsp);
			if (thumbnaillist.getFileUrl() != null) {
				list = D3CaseBeanConverter.getFiles(thumbnaillist.getFileUrl());
			}
			if (list.size() > 0) {
				thumbPathPrefix = list.get(0).getLink();
			}
			d3Case.setThumbnailMainPath(thumbPathPrefix);
			if (d3Case.getOriginalDesignerId() != null) {
				designerId = Long.parseLong(d3Case.getOriginalDesignerId());
			} else {
				designerId = d3Case.getDesignerId();
			}
			List<DesignFile> designFile = DesignFileDco.convertJsonToArray(d3Case.getDesignFile());
			result = new D3CaseRetrieveRsp(d3Case.getDesignAssetId(), d3Case.getBedroom(), d3Case.getCity(),
					d3Case.getCommunityName(), d3Case.getConception(), d3Case.getCustomStringArea(),
					d3Case.getCustomStringBedroom(), d3Case.getCustomStringForm(), d3Case.getCustomStringName(),
					d3Case.getCustomStringRestroom(), d3Case.getCustomStringStyle(), d3Case.getCustomStringType(),
					ThreeDimensionalBeanConverter.toDesignFileRsp(designFile, thumbnailsFileRsp),
					d3Case.getDesignName(), d3Case.getDistrict(), d3Case.getHsDesignerUid(), d3Case.getHsDesignId(),
					d3Case.getProjectStyle(), d3Case.getProjectType(), d3Case.getProvince(), d3Case.getPublishStatus(),
					d3Case.getRestroom(), Double.valueOf(area), d3Case.getRoomType(), d3Case.getFavoriteCount(),
					null, designerId, d3Case.getCustomStringIsStorage(), d3Case.getSort(),
					d3Case.getCustomStringSortType(), d3Case.getPublishStatus(), d3Case.getCustomStringKeywords(),
					d3Case.getOriginalAvatar(), d3Case.getOriginalHsDesignerUid(), d3Case.getOriginalAssetId());
			result.setDesignAssetId(d3Case.getDesignAssetId());
			result.setThumbnailMainPath(d3Case.getThumbnailMainPath());
			result.setDisplay(d3Case.getDisplay() == null ? false : d3Case.getDisplay());
			result.setIsSampleRoom(d3Case.getIsSampleRoom() == null ? false : d3Case.getIsSampleRoom());
		} else {
			result = new D3CaseRetrieveRsp();
			result.setDesignAssetId(d3Case.getDesignAssetId());
		}
		return result;
	}

	/**
	 * 将3D案例CustomData转变为返回对象<br>
	 * 
	 * @param d3Case
	 *            3D案例CustomData @param designer 返回的设计师信息 @return
	 *            TODO返回结果描述 @return D3CaseRetrieveRsp 返回值类型 @throws
	 * @throws HttpException
	 * @throws IOException
	 * @throws UnsupportedOperationException
	 * @throws ClientProtocolException
	 */
	public static D3CaseRetrieveRsp toCaseRetrieveRsp(final ThreeDimensionalCD d3Case,final List<DesignFileReq> images)
			throws ClientProtocolException, UnsupportedOperationException, IOException, HttpException {
		Long area;
		Long designerId;
		String uid;
		try {
			area = Double.valueOf(d3Case.getRoomArea()).longValue();
		} catch (Exception e) {
			area = 0l;
		}
		if (d3Case.getOriginalDesignerId() != null) {
			designerId = Long.parseLong(d3Case.getOriginalDesignerId());
		} else {
			designerId = d3Case.getDesignerId();
		}
		if (d3Case.getOriginalHsDesignerUid() != null) {
			uid = d3Case.getOriginalHsDesignerUid();
		} else {
			uid = d3Case.getHsDesignerUid();
		}
		final D3CaseRetrieveRsp result = new D3CaseRetrieveRsp(d3Case.getDesignAssetId(), d3Case.getBedroom(),
				d3Case.getCity(), d3Case.getCommunityName(), d3Case.getConception(), d3Case.getCustomStringArea(),
				d3Case.getCustomStringBedroom(), d3Case.getCustomStringForm(), d3Case.getCustomStringName(),
				d3Case.getCustomStringRestroom(), d3Case.getCustomStringStyle(), d3Case.getCustomStringType(), images,
				d3Case.getDesignName(), d3Case.getDistrict(), uid, d3Case.getHsDesignId(), d3Case.getProjectStyle(),
				d3Case.getProjectType(), d3Case.getProvince(), d3Case.getPublishStatus(), d3Case.getRestroom(),
				Double.valueOf(area), d3Case.getRoomType(), d3Case.getFavoriteCount(), null, designerId,
				d3Case.getCustomStringIsStorage(), d3Case.getSort(), d3Case.getCustomStringSortType(),
				d3Case.getPublishStatus(), d3Case.getCustomStringKeywords(), d3Case.getOriginalAvatar(),
				d3Case.getOriginalHsDesignerUid(), d3Case.getOriginalAssetId());
		  result.setDesignAssetId(d3Case.getDesignAssetId());
          result.setThumbnailMainPath(d3Case.getThumbnailMainPath());
          result.setDisplay(d3Case.getDisplay() == null ? false : d3Case.getDisplay());
          result.setIsSampleRoom(d3Case.getIsSampleRoom() == null ? false : d3Case.getIsSampleRoom());

          result.setChannel(d3Case.getChannel());
          result.setContest(d3Case.getContest());
          result.setStore(d3Case.getStore());
          result.setRoomArea(d3Case.getRoomArea());
          result.setRoomMold(d3Case.getRoomMold());
          result.setSpecialTag(d3Case.getSpecialTag());
          result.setHouseQuote(d3Case.getHouseQuote());
          result.setDemandDescription(d3Case.getDemandDescription());
          result.setProvinceName(d3Case.getProvinceName());
          result.setCityName(d3Case.getCityName());
          result.setDistrictName(d3Case.getDistrictName());
          result.setIsNew(d3Case.getIsNew());
		return result;
	}

	/**
	 * 获取主图信息<br>
	 * 
	 * @param thumbPathPrefix
	 * @return
	 * @return List<ThumbnailsFileRsp>
	 */
	public static List<DesignFileReq> getFiles(final String thumbPathPrefix) {
		if (StringUtils.isEmpty(thumbPathPrefix)) {
			return null;
		}
		List<DesignFileReq> files = new ArrayList<DesignFileReq>();
		if (thumbPathPrefix.indexOf("nopicture") > -1) {
			// TODO 待完善无主图处理
		} else {
			files.add(new DesignFileReq(null, thumbPathPrefix, true, "mainImage"));
		}
		return files;
	}

	/**
	 * 将Asset转换为3D案例<br>
	 * 
	 * @param asset
	 *            Asset
	 * @return
	 * @return ThreeDimensionalCD
	 */
	public static ThreeDimensionalCD toD3Case(final AssetCollection asset) {
		final ThreeDimensionalCD d3Case = JSONCustomDataUtility.toObject(asset.getExtendedData(),
				ThreeDimensionalCD.class);
		d3Case.setFavoriteCount((long) asset.getFavoriteCount());
		d3Case.setDesignAssetId(asset.getAssetId());
		Map<String, Object> map = (Map) asset.getExtendedData();
		List<DesignFile> list = get(map, DesignFile.class, "render-id");
		DesignFileDco dco = new DesignFileDco(d3Case.getDesignFile());
		dco.add(list);
		d3Case.setDesignFile(dco.convertArrayToJson());
		return d3Case;
	}

	public static <T> List<T> get(Map map, final Class<T> clazz, final String status) {
		List<T> result = new ArrayList<T>();
		Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			if (entry.getKey().indexOf(status) > -1) {
				result.add(JSON.toJavaObject(JSON.parseObject(entry.getValue().toString()), clazz));
			}
		}
		return result;
	}

	public static <T> List<T> memberGet(ArrayList<KeyFilefolder> list, final Class<T> clazz, final String status) {
		List<T> result = new ArrayList<T>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getKey().indexOf(status) > -1) {
				result.add(JSON.toJavaObject(JSON.parseObject(list.get(i).getFilefolder().toString()), clazz));
			}
		}
		return result;
	}

	/**
	 * 将Asset转换为3D案例<br>
	 * 
	 * @param asset
	 *            Asset
	 * @return
	 * @return ThreeDimensionalCD
	 */
	public static ThreeDimensionalCD toD3Case(final MembersAsset asset) {
		ThreeDimensionalCD d3Case = null;
		try {
			d3Case = JSONCustomDataUtility.jsonToJavaObject(asset.getExtendedData(),
					ThreeDimensionalCD.class);
		} catch (Exception e) {
			System.out.println("ERROR assetId : "+asset.getAssetId()+" ;Data :"+JSON.toJSONString(asset.getExtendedData()));
			d3Case = new ThreeDimensionalCD();
		}
		d3Case.setDesignAssetId(asset.getAssetId());
		d3Case.setFavoriteCount((long) asset.getFavoriteCount());
		if (asset.getExtendedData() != null && asset.getExtendedData().getKeyFilefolder().size() > 0) {
			ArrayList<KeyFilefolder> keyFilefolders = asset.getExtendedData().getKeyFilefolder();
			List<DesignFile> list = D3CaseBeanConverter.memberGet(keyFilefolders, DesignFile.class, "render-id");
			DesignFileDco dco = new DesignFileDco(d3Case.getDesignFile());
			dco.add(list);
			d3Case.setDesignFile(dco.convertArrayToJson());
		}
		return d3Case;
	}

	/**
	 * 获取3D案例主图<br>
	 * @param thumbPathPrefix
	 * @return
	 * @throws ClientProtocolException
	 * @throws UnsupportedOperationException
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IOException
     * @throws HttpException
     * @throws NotFoundModelAnnotation
     */
	public static List<DesignFileReq> getMainImages(String thumbPathPrefix)
			throws ClientProtocolException, UnsupportedOperationException, ClassNotFoundException, NoSuchFieldException,
			SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, HttpException, NotFoundModelAnnotation {
		// 获取案例主图
		List<DesignFileReq> images = new ArrayList<DesignFileReq>();
		if (!StringUtils.isEmpty(thumbPathPrefix)) {
			images.addAll(getFiles(thumbPathPrefix));
		}
		return images;
	}

	/**
	 * 从Asset 中直接获取 Thumbnails<br>
	 * 
	 * @param asset
	 * @return
	 * @return List<ThumbnailsFileRsp>
	 */
	public static List<ThumbnailsFileRsp> getFIles(final AssetCollection asset) {
		List<ThumbnailsFileRsp> result = new ArrayList<ThumbnailsFileRsp>();
		for (AssetThumbnail thumbnailsFileRsp : asset.getThumbnails()) {
			result.add(
					new ThumbnailsFileRsp(String.valueOf(thumbnailsFileRsp.getFileId()), thumbnailsFileRsp.getCaption(),
							thumbnailsFileRsp.getThumbPathPrefix(), thumbnailsFileRsp.isPrimary()));
		}
		return result;
	}
	
	/**
	 * 3D转换
	 * 
	 * @param d3Case
	 * @param designer
	 * @param thumbnailsFileRsp
	 * @return
	 * @throws ClientProtocolException
	 * @throws UnsupportedOperationException
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IOException
	 * @throws HttpException
	 * @throws NotFoundModelAnnotation
	 */
	public static D3CaseRetrieveRsp toD3CaseRenderImgRetrieveRsp(ThreeDimensionalCD d3Case,
			List<ThumbnailsFileRsp> thumbnailsFileRsp) {

		D3CaseRetrieveRsp result = null;
		Long area = 0L;
		try {
			area = Double.valueOf(d3Case.getRoomArea()).longValue();
		} catch (Exception e) {
			return null;
		}
		if (d3Case != null && d3Case.getHsDesignerUid() != null) {
			// 图片信息
			List<DesignFileReq> list = Lists.newArrayList();
			String thumbPathPrefix = null;
			// 获取默认主图
			ThumbnailsFileRsp thumbnail = getThumbnailsMain(thumbnailsFileRsp);
			if (thumbnail != null && !StringUtils.isEmpty(thumbnail.getFileUrl())) {
				list = D3CaseBeanConverter.getFiles(thumbnail.getFileUrl());
			}
			if (!CollectionUtils.isEmpty(list)) {
				thumbPathPrefix = list.get(0).getLink();
			}
			d3Case.setThumbnailMainPath(thumbPathPrefix);

			Long designerId = 0L;// 设计者ID
			if (d3Case.getOriginalDesignerId() != null) {
				designerId = Long.parseLong(d3Case.getOriginalDesignerId());
			} else {
				designerId = d3Case.getDesignerId();
			}

			List<DesignFile> designFile = DesignFileDco.convertJsonToArray(d3Case.getDesignFile());
			Map<String, DesignFile> typeMap = new HashMap<>();
			for (DesignFile designFileInfo : designFile) {
				typeMap.put(designFileInfo.getType(), designFileInfo);
			}
			if (!typeMap.containsKey("9")) {
				//补充户型图
				String photo2d = d3Case.getPhoto2d();
				if (!StringUtils.isEmpty(photo2d)) {
					String replaceAll = photo2d.replaceAll("'", "\"");
					DesignFile parseObject = JSON.parseObject(replaceAll, DesignFile.class);
					designFile.add(parseObject);
				}
			}
			result = new D3CaseRetrieveRsp(d3Case.getDesignAssetId(), d3Case.getBedroom(), d3Case.getCity(),
					d3Case.getCommunityName(), d3Case.getConception(), d3Case.getCustomStringArea(),
					d3Case.getCustomStringBedroom(), d3Case.getCustomStringForm(), d3Case.getCustomStringName(),
					d3Case.getCustomStringRestroom(), d3Case.getCustomStringStyle(), d3Case.getCustomStringType(),
					toDesignFileRsp(designFile, thumbnailsFileRsp), d3Case.getDesignName(), d3Case.getDistrict(),
					d3Case.getHsDesignerUid(), d3Case.getHsDesignId(), d3Case.getProjectStyle(),
					d3Case.getProjectType(), d3Case.getProvince(), d3Case.getPublishStatus(), d3Case.getRestroom(),
					Double.valueOf(area), d3Case.getRoomType(), d3Case.getFavoriteCount(), null, designerId,
					d3Case.getCustomStringIsStorage(), d3Case.getSort(), d3Case.getCustomStringSortType(),
					d3Case.getPublishStatus(), d3Case.getCustomStringKeywords(), d3Case.getOriginalAvatar(),
					d3Case.getOriginalHsDesignerUid(), d3Case.getOriginalAssetId());
			result.setDesignAssetId(d3Case.getDesignAssetId());
			result.setThumbnailMainPath(d3Case.getThumbnailMainPath());
			result.setDisplay(d3Case.getDisplay() == null ? false : d3Case.getDisplay());
			result.setIsSampleRoom(d3Case.getIsSampleRoom() == null ? false : d3Case.getIsSampleRoom());

			result.setChannel(d3Case.getChannel());
			result.setContest(d3Case.getContest());
			result.setStore(d3Case.getStore());
			result.setRoomArea(d3Case.getRoomArea());
			result.setRoomMold(d3Case.getRoomMold());
			result.setSpecialTag(d3Case.getSpecialTag());
			result.setHouseQuote(d3Case.getHouseQuote());
			result.setDemandDescription(d3Case.getDemandDescription());
			result.setProvinceName(d3Case.getProvinceName());
			result.setCityName(d3Case.getCityName());
			result.setDistrictName(d3Case.getDistrictName());
			result.setIsNew(d3Case.getIsNew());
			result.setSelectImage(d3Case.getSelectImage());
			// 返回数据
			Map<String, RspD3Case> returnMap = Maps.newHashMap();
			// 获取空间+全景渲染图片
			List<DesignFileReq> fullImageList = toDesignFileRsp4FullImage(designFile);
			getFullImages(fullImageList, returnMap, d3Case);
			// 获取空间+普通渲染图片
			getNormalImages(thumbnailsFileRsp, returnMap, d3Case, designFile);
			// 设置描述信息
			setImageDescription(returnMap, d3Case.getRoomDescList());
			// 获取DesignFileReq
			List<DesignFileReq> dfList = toDesignFileRsp(designFile, thumbnailsFileRsp);// 把主图添加到集合中
			// 设置图片
			setMainImageAndSelectImage(returnMap, d3Case.getMainImage(), d3Case.getSelectImage(), dfList);
			// 空间排序
			List<RspD3Case> returnList = sortReturnList(returnMap);
			result.setRenderingImages(returnList);
			result.setDesignFile(dfList);// 重新设置主图等图片信息
			result.setNaviPanos(getNaviPanos(designFile,d3Case.getThumbnailMainPath(), d3Case.getMainImage(), d3Case.getSelectImage()));
			result.setNaviPanosDesc(d3Case.getNaviPanosDesc());
		} else {
			result = new D3CaseRetrieveRsp();
			result.setDesignAssetId(d3Case.getDesignAssetId());
		}
		return result;
	}
	
	/**
	 * 排序
	 * 
	 * @param returnMap
	 * @return
	 */
	public static List<RspD3Case> sortReturnList(Map<String, RspD3Case> returnMap) {
		if (CollectionUtils.isEmpty(returnMap))
			return Collections.EMPTY_LIST;

		// 返回数据returnList
		List<RspD3Case> returnList = Lists.newArrayList();
		Set<String> keySet = returnMap.keySet();
		List<SpaceMappingEnum> enums = Lists.newArrayList();
		for (String key : keySet) {
			enums.add(SpaceMappingEnum.getEnumByValue(key));
		}
		enums.sort((SpaceMappingEnum s1, SpaceMappingEnum s2) -> s1.getSort().compareTo(s2.getSort()));
		for (SpaceMappingEnum se : enums) {
			String key = se.getValue();
			for (Map.Entry<String, RspD3Case> entry : returnMap.entrySet()) {
				if (key.equalsIgnoreCase(entry.getKey())) {
					RspD3Case rspD3Case = entry.getValue();
					rspD3Case.setTypeKey(entry.getKey());
					rspD3Case.setExist(true);
					if (rspD3Case.getData().size() < 1) {
						rspD3Case.setExist(false);
					}
					returnList.add(rspD3Case);
					break;
				}
			}
		}
		return returnList;
	}
	
	/**
	 * 设置描述
	 * 
	 * @param returnMap
	 * @param description
	 */
	public static void setImageDescription(Map<String, RspD3Case> returnMap, String description) {
		if (StringUtils.isEmpty(description))
			return;
		JSONArray array = JSONArray.parseArray(description);
		for (Map.Entry<String, RspD3Case> entry : returnMap.entrySet()) {
			for (int i = 0; i < array.size(); i++) {
				JSONObject object = (JSONObject) array.get(i);
				String key = (String) object.get("roomType");
				String value = (String) object.get("description");
				if (key.equals(entry.getKey())) {
					entry.getValue().setDescription(value);
					continue;
				}
			}
		}
	}
	
	/**
	 * 返回全景渲染图List
	 * 
	 * @param designFiles
	 * @return
	 */
	public static List<DesignFileReq> toDesignFileRsp4FullImage(List<DesignFile> designFiles) {
		// 返回结果
		List<DesignFileReq> list = Lists.newArrayList();
		if (!CollectionUtils.isEmpty(designFiles)) {
			for (DesignFile designFile : designFiles) {
				if (!StringUtils.isEmpty(designFile.getCover())) {// 360全景渲染图
					DesignFileReq req = new DesignFileReq(designFile.getId(),
							EnumDesignFileType.getEnum(designFile.getType()), designFile.getLink(),
							designFile.getStatus(), designFile.getName(), designFile.getSource(),
							designFile.getExtendedData(), designFile.getSourceId(), null);
					req.setCover(designFile.getCover());
					list.add(req);
				}
			}
		}
		return list;
	}
	
	/**
	 * 获取空间 + 全景图片的返回Map
	 * 
	 * @param images
	 * @param returnMap
	 */
	public static void getFullImages(List<DesignFileReq> images, Map<String, RspD3Case> returnMap, ThreeDimensionalCD d3Case) {
		if (CollectionUtils.isEmpty(images))
			return;
		for (DesignFileReq file : images) {
			String imageUrl = file.getLink();
			if (StringUtils.isEmpty(imageUrl) || !imageUrl.contains("http"))
				continue;
			String httpUrl = get360RenderJson(imageUrl);
			if (StringUtils.isEmpty(httpUrl)) {
				continue;
			}
			String getResult = HttpClientUtils.getByUrl(httpUrl);// 请求数据
			JSONObject object = null;
			try {
				object = JSONObject.parseObject(getResult);
			} catch (Exception e) {
				object = null;
			}
			if (object != null) {
				JSONObject roomObject = (JSONObject) object.get("attributes");
				if (roomObject != null) {
					String roomType = (String) roomObject.get("roomType");
					if (StringUtils.isEmpty(roomType)) {
						roomType = SpaceMappingEnum.UNKNOW.getValue();
					}
					String showName = SpaceMappingEnum.designName(roomType);// 获取空间显示的名称
					RspD3Case rspD3Case = returnMap.get(roomType);
					if (rspD3Case == null) {
						List<DesignFileReq> roomTypeImageList = new ArrayList<>();
						rspD3Case = new RspD3Case();
						rspD3Case.setTypeName(showName);
						rspD3Case.setDescription(getDesc(d3Case, roomType));
						file.setModelSeekids(getSeekids(file));
						roomTypeImageList.add(file);
						rspD3Case.setData(roomTypeImageList);
						returnMap.put(roomType, rspD3Case);
					} else {
						List<DesignFileReq> data = rspD3Case.getData();
						file.setModelSeekids(getSeekids(file));
						data.add(file);
					}
				}
			}else {
				String roomType = SpaceMappingEnum.UNKNOW.getValue();
				String showName = SpaceMappingEnum.designName(roomType);// 获取空间显示的名称
				RspD3Case rspD3Case = returnMap.get(roomType);
				if (rspD3Case == null) {
					List<DesignFileReq> roomTypeImageList = new ArrayList<>();
					rspD3Case = new RspD3Case();
					rspD3Case.setTypeName(showName);
					rspD3Case.setDescription(getDesc(d3Case, roomType));
					file.setModelSeekids(getSeekids(file));
					roomTypeImageList.add(file);
					rspD3Case.setData(roomTypeImageList);
					returnMap.put(roomType, rspD3Case);
				} else {
					List<DesignFileReq> data = rspD3Case.getData();
					file.setModelSeekids(getSeekids(file));
					data.add(file);
				}
			}
		}
	}
	
	/**
	 * 获取空间 + 普通渲染图片的返回Map
	 * 
	 * @param images
	 * @param returnMap
	 */
	public static void getNormalImages(List<ThumbnailsFileRsp> images, Map<String, RspD3Case> returnMap,
			ThreeDimensionalCD d3Case, List<DesignFile> designFile) {
		if (designFile != null && designFile.size() > 0 && images != null && images.size() > 0) {
			Map<String, DesignFile> fileMap = new HashMap<>();
			for (DesignFile file : designFile) {
				// type=0--->普通渲染图
				if ("0".equals(file.getType())) {
					fileMap.put(file.getId(), file);
				}
			}
			for (ThumbnailsFileRsp file : images) {
				// 普通渲染图
				if (fileMap.containsKey(file.getFileId())) {
					DesignFile fileInfo = fileMap.get(file.getFileId());
					String imageUrl = file.getDescription();
					if (!StringUtils.isEmpty(imageUrl) && imageUrl.contains("http")) {
						String httpUrl = getHttpUrlByImageUrl(imageUrl);// 返回json的请求地址
						String getResult = HttpClientUtils.getByUrl(httpUrl);// 请求数据
						JSONObject object = null;
						try {
							object = JSONObject.parseObject(getResult);
						} catch (Exception e) {
							object = null;
						}
						if (object != null) {
							JSONObject roomObject = (JSONObject) object.get("attributes");
							if (roomObject != null) {
								String roomType = (String) roomObject.get("roomType");
								if (StringUtils.isEmpty(roomType)) {
									roomType = SpaceMappingEnum.UNKNOW.getValue();
								}
								String showName = SpaceMappingEnum.designName(roomType);// 获取空间显示的名称

								RspD3Case rspD3Case = returnMap.get(roomType);
								if (rspD3Case == null) {
									rspD3Case = new RspD3Case();
									rspD3Case.setTypeName(showName);
									rspD3Case.setDescription(getDesc(d3Case, roomType));
									List<DesignFileReq> roomTypeImageList = new ArrayList<>();

									DesignFileReq req = new DesignFileReq();
									req.setId(file.getFileId());
									req.setLink(file.getFileUrl());
									req.setName(file.getFileName());
									roomTypeImageList.add(req);
									rspD3Case.setData(roomTypeImageList);
									returnMap.put(roomType, rspD3Case);
								} else {
									List<DesignFileReq> data = rspD3Case.getData();
									DesignFileReq req = new DesignFileReq();
									req.setId(file.getFileId());
									req.setLink(file.getFileUrl());
									req.setName(file.getFileName());
									data.add(req);
								}
							}
						}
					} else {
						RspD3Case rspD3Case = returnMap.get(SpaceMappingEnum.UNKNOW.getValue());
						if (rspD3Case == null) {
							rspD3Case = new RspD3Case();
							rspD3Case.setTypeName(SpaceMappingEnum.designName(SpaceMappingEnum.UNKNOW.getValue()));
							rspD3Case.setDescription(getDesc(d3Case, SpaceMappingEnum.UNKNOW.getValue()));
							List<DesignFileReq> roomTypeImageList = new ArrayList<>();

							DesignFileReq req = new DesignFileReq();
							req.setId(file.getFileId());
							req.setLink(file.getFileUrl());
							req.setName(fileInfo.getName());
							req.setSourceId(fileInfo.getSourceId());
							req.setSource(fileInfo.getSource());
							roomTypeImageList.add(req);
							rspD3Case.setData(roomTypeImageList);
							returnMap.put(SpaceMappingEnum.UNKNOW.getValue(), rspD3Case);
						} else {
							List<DesignFileReq> data = rspD3Case.getData();
							DesignFileReq req = new DesignFileReq();
							req.setId(file.getFileId());
							req.setLink(file.getFileUrl());
							req.setName(fileInfo.getName());
							req.setSourceId(fileInfo.getSourceId());
							req.setSource(fileInfo.getSource());
							data.add(req);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 获取空间描述
	 * 
	 * @param d3Case
	 * @param roomType
	 * @return
	 */
	public static String getDesc(ThreeDimensionalCD d3Case, String roomType) {
		Map<String, String> typeMap = new HashMap<>();
		if (d3Case.getRoomDescList() != null) {
			String roomDescList = d3Case.getRoomDescList();
			String replaceAll = roomDescList.replaceAll("'", "\"");
			List<D3CaseDescUpdateBean> parseArray = JSON.parseArray(replaceAll, D3CaseDescUpdateBean.class);
			for (D3CaseDescUpdateBean d3CaseDescUpdateBean : parseArray) {
				typeMap.put(d3CaseDescUpdateBean.getRoomType(), d3CaseDescUpdateBean.getDescription());
			}
		}
		return typeMap.get(roomType);
	}
	
	/**
	 * 获取json访问地址
	 * 
	 * @param imageUrl
	 * @return
	 */
	public static String getHttpUrlByImageUrl(String imageUrl) {
		int lastIndex = imageUrl.lastIndexOf(".");
		if (lastIndex > -1) {
			StringBuffer sb = new StringBuffer();
			String prefix = imageUrl.substring(0, lastIndex);
			sb.append(prefix);
			sb.append(".json");
			return sb.toString();
		}
		return null;
	}
	
	/**
	 * 获取推荐商品的模型ids
	 * 
	 * @return
	 */
	public static List<String> getSeekids(DesignFileReq file) {
		List<String> seekids = new ArrayList<>();
		// 全景渲染图
		if ("4".equals(file.getType())) {
			String renderUrl = get360RenderJson(file.getLink());
			String[] split = renderUrl.split("/");
			String param = split[split.length - 2] + "/" + split[split.length - 1];
			String paramUrl = getTagHost() + param;
			String httpUrl = getHttpUrlByImageUrl(paramUrl);
			String getResult = HttpClientUtils.getByUrl(httpUrl);// 请求数据
			JSONObject object = null;
			try {
				object = JSONObject.parseObject(getResult);
			} catch (Exception e) {
				object = null;
			}
			if (object != null) {
				JSONObject tagsObject = (JSONObject) object.get("tags");
				Map tagsMap = tagsObject;
				Set keySet = tagsMap.keySet();
				for (Object tag : keySet) {
					JSONObject tagJson = (JSONObject) tagsMap.get(tag);
					String seekid = String.valueOf(tagJson.get("seekId"));
					seekids.add(seekid);
				}
			}
		}
		return seekids;
	}
	/**
	 * 获取360全景渲染图的Json文件
	 *
	 * @param renderUrl
	 * @return
	 */
	public static String get360RenderJson(String renderUrl) {
		String[] split = renderUrl.split("&");
		for (int k = 0; k < split.length; k++) {
			if (split[k].indexOf("data=") > -1) {
				String b = split[k].substring(split[k].lastIndexOf("=") + 1, split[k].length());
				try {
					String decode = URLDecoder.decode(b, "utf-8");
					if (!decode.startsWith("http")) {
						decode = "http:" + decode;
					}
					return getHttpUrlByImageUrl(decode);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 获取推荐商品host
	 * 
	 * @return
	 */
	public static String getTagHost() {
		return BUNDLE.getString("homestyler.3d.tag.host");
	}
	
	/**
	 * 得到主图信息
	 *
	 * @param thumbnailList
	 * @return
	 */
	public static ThumbnailsFileRsp getThumbnailsMain(List<ThumbnailsFileRsp> thumbnailList) {
		if (CollectionUtils.isEmpty(thumbnailList)) {
			return null;
		}
		ThumbnailsFileRsp target = new ThumbnailsFileRsp();
		for (ThumbnailsFileRsp file : thumbnailList) {
			if (file.getIsPrimary()) {
				BeanUtils.copyProperties(file, target);
				break;
			}
		}
		return target;
	}
	
	/**
	 * 设置图片选中
	 *
	 * @param returnMap
	 * @param mainImage
	 * @param selectImage
	 */
	public static void setMainImageAndSelectImage(Map<String, RspD3Case> returnMap, String mainImage, String selectImage,
			List<DesignFileReq> dfList) {
		List<String> idList = Lists.newArrayList();
		if (!StringUtils.isEmpty(mainImage)) {
			String[] mainList = mainImage.split(",");
			for (String s : mainList) {
				idList.add(s);
			}
		}
		if (!StringUtils.isEmpty(selectImage)) {
			String[] selectList = selectImage.split(",");
			for (String sl : selectList) {
				idList.add(sl);
			}
		}
		if (CollectionUtils.isEmpty(returnMap))
			return;

		for (Map.Entry<String, RspD3Case> entry : returnMap.entrySet()) {
			RspD3Case rspD3Case = entry.getValue();
			List<DesignFileReq> desList = rspD3Case.getData();
			for (DesignFileReq des : desList) {
				if (idList.contains(des.getSourceId()) || idList.contains(des.getId())) {
					des.setIsSelected(Boolean.TRUE);
				}
				if (!StringUtils.isEmpty(mainImage)) {
					if (mainImage.equals(des.getSourceId()) || mainImage.equals(des.getId())) {
						dfList.add(des);// 把主图添加到集合中
						des.setIsPrimary(Boolean.TRUE);
					}
				}
			}
		}
	}
	
	/**
	 * 获取普通渲染图片数据库结果List
	 * 
	 * @param designFiles
	 * @param images
	 * @return
	 */
	public static List<DesignFileReq> toDesignFileRsp(List<DesignFile> designFiles, List<ThumbnailsFileRsp> images) {
		// 返回结果
		List<DesignFileReq> list = Lists.newArrayList();

		Map<String, ThumbnailsFileRsp> map = Maps.newHashMap();
		for (ThumbnailsFileRsp file : images) {
			map.put(file.getFileId(), file);
		}
		if (!CollectionUtils.isEmpty(designFiles)) {
			for (DesignFile designFile : designFiles) {
				//普通渲染图
				if ("0".equals(designFile.getType())) {
					ThumbnailsFileRsp file = map.get(designFile.getId());
					if (file != null) {
						list.add(new DesignFileReq(designFile.getId(), EnumDesignFileType.getEnum(designFile.getType()),
								file.getFileUrl(), designFile.getStatus(), designFile.getName(), designFile.getSource(),
								designFile.getExtendedData(), designFile.getSourceId(), file.getIsPrimary()));
					}
				}
				//户型图
				if ("9".equals(designFile.getType())) {
					ThumbnailsFileRsp file = map.get(designFile.getId());
					if (file != null) {
						list.add(new DesignFileReq(designFile.getId(), EnumDesignFileType.getEnum(designFile.getType()),
								file.getFileUrl(), designFile.getStatus(), designFile.getName(), designFile.getSource(),
								designFile.getExtendedData(), designFile.getSourceId(), file.getIsPrimary()));
					}else {
						//处理异常情况--户型图修改后缩略图创建异常
						for (ThumbnailsFileRsp floorFile : images) {
							if ("base_floor_plan.png".equals(floorFile.getFileName())) {
								list.add(new DesignFileReq(designFile.getId(), EnumDesignFileType.getEnum(designFile.getType()),
										floorFile.getFileUrl(), designFile.getStatus(), designFile.getName(), designFile.getSource(),
										designFile.getExtendedData(), designFile.getSourceId(), floorFile.getIsPrimary()));
								break;
							}
						}
					}
				}
			}
		}
		return list;
	}
	
	/**
	 * 获取全屋漫游图
	 */
	public static List<DesignFileReq> getNaviPanos(List<DesignFile> designFile, String cover, String mainImage, String selectImage) {
		List<DesignFileReq> rspBean = new ArrayList<>();
		if (CollectionUtils.isEmpty(designFile)) {
			return rspBean;
		}
		List<String> idList = Lists.newArrayList();
		if (!StringUtils.isEmpty(mainImage)) {
			String[] mainList = mainImage.split(",");
			for (String s : mainList) {
				idList.add(s);
			}
		}
		if (!StringUtils.isEmpty(selectImage)) {
			String[] selectList = selectImage.split(",");
			for (String sl : selectList) {
				idList.add(sl);
			}
		}
		for (DesignFile file : designFile) {
			if ("11".equals(file.getType())) {
				DesignFileReq designFileReq = new DesignFileReq();
				designFileReq.setCover(cover);
				designFileReq.setLink(file.getLink());
				designFileReq.setSourceId(file.getSourceId());
				if (idList.contains(file.getSourceId())){
					designFileReq.setIsSelected(Boolean.TRUE);
				}
				rspBean.add(designFileReq);
			}
		}
		return rspBean;
	}
	
}
