package com.juran.examplemovie.app.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.autodesk.mp.client.models.domainobject.assets.result.AssetCollection;
import com.autodesk.mp.client.models.domainobject.assets.result.ReferenceAssets;
import com.autodesk.mp.client.models.domainobject.assets.result.ReferencesCollection;
import com.juran.examplemovie.client.bean.domain.DesignFile;
import com.juran.examplemovie.client.bean.domain.DesignFileReq;
import com.juran.examplemovie.client.bean.domain.ThreeDimensionalCD;
import com.juran.examplemovie.client.bean.domain.ThumbnailsFileRsp;
import com.juran.examplemovie.client.bean.enums.EnumDesignFileType;


/**
 * 3D数据转换
 * 
 * @author songsen.zhang
 * @version 2016年5月25日 2016年5月25日 下午10:42:07 songsen.zhang 简要描述修改内容，修改原因
 */
public class ThreeDimensionalBeanConverter
{

	/**
	 * 类型转换<br>
	 * 
	 * @param designFiles
	 * @return
	 * @return List<DesignFile>
	 */
	public static List<DesignFile> toDesignFile( final List<DesignFileReq> designFiles )
	{
		List<DesignFile> list = new ArrayList<DesignFile>();
		for( final DesignFileReq designFile : designFiles )
		{
			list.add(new DesignFile(designFile.getId(), EnumDesignFileType.getEnum(designFile.getType()), designFile.getLink(), designFile.getStatus(), designFile.getName(),
				designFile.getSource(), designFile.getExtendedData(), designFile.getSourceId()));
		}
		return list;
	}

	/**
	 * 类型转换<br>
	 * 
	 * @param designFiles
	 * @return @return List<DesignFileReq>
	 */
	public static List<DesignFileReq> toDesignFileRsp( final List<DesignFile> designFiles )
	{
		List<DesignFileReq> list = new ArrayList<DesignFileReq>();
		for( final DesignFile designFile : designFiles )
		{
			list.add(new DesignFileReq(designFile.getId(), EnumDesignFileType.getEnum(designFile.getType()), designFile.getLink(), designFile.getStatus(), designFile.getName(),
				designFile.getSource(), designFile.getExtendedData(), designFile.getSourceId()));
		}
		return list;
	}
	/**
	 * 3D详情类型转换<br>
	 * 
	 * @param designFiles
	 * @param  images
	 * @return @return List<DesignFileReq>
	 */
	public static List<DesignFileReq> toDesignFileRsp( final List<DesignFile> designFiles,List<ThumbnailsFileRsp> images )
	{
		List<DesignFileReq> list = new ArrayList<DesignFileReq>();
 		Map<String, ThumbnailsFileRsp> map = new HashMap<String,ThumbnailsFileRsp>();
 		for(int i = 0;i<images.size();i++){
 			ThumbnailsFileRsp file = images.get(i);
 			map.put(file.getFileId(), file);
 		}
 		if(designFiles.size()>0){
 		for( final DesignFile designFile : designFiles )
 		{
 			ThumbnailsFileRsp file = map.get(designFile.getId());
 			if(file!=null&&!"4".equals(designFile.getType())&&!"0".equals(designFile.getType())){
 				list.add(new DesignFileReq(designFile.getId(), EnumDesignFileType.getEnum(designFile.getType()), file.getFileUrl(), designFile.getStatus(), designFile.getName(),
 						designFile.getSource(), designFile.getExtendedData(), designFile.getSourceId(),file.getIsPrimary()));
 			}else  if(file==null&&"4".equals(designFile.getType())){
 				DesignFileReq designFileReq = new DesignFileReq(designFile.getId(), EnumDesignFileType.getEnum(designFile.getType()), designFile.getLink(), designFile.getStatus(), designFile.getName(),
						designFile.getSource(), designFile.getExtendedData(), designFile.getSourceId(),false);
 				designFileReq.setCover(designFile.getCover());
 				list.add(designFileReq);
 			}else if(file!=null&&"0".equals(designFile.getType())){
 				list.add(new DesignFileReq(designFile.getId(), EnumDesignFileType.getEnum(designFile.getType()), file.getFileUrl(), designFile.getStatus(), designFile.getName(),
 						designFile.getSource(), designFile.getExtendedData(), designFile.getSourceId(),file.getIsPrimary()));
 			}
 		}
 		}
		return list;
	}
	
	/**
	 * 取3D案例渲染图<br>
	 * 
	 * @param d3Case
	 * @param  images
	 * @return @return List<DesignFileReq>
	 */
	public static List<DesignFileReq> getDesignFileRsp(  final List<DesignFile> designFiles, final List<ThumbnailsFileRsp> images )
	{
		List<DesignFileReq> list = new ArrayList<DesignFileReq>();
 		Map<String, ThumbnailsFileRsp> map = new HashMap<String,ThumbnailsFileRsp>();
 		for(int i = 0;i<images.size();i++){
 			ThumbnailsFileRsp file = images.get(i);
 			map.put(file.getFileId(), file);
 		}
 		if(designFiles.size()>0){
 		for( final DesignFile designFile : designFiles )
 		{
 			ThumbnailsFileRsp file = map.get(designFile.getId());
 			 if(file!=null&&"0".equals(designFile.getType())){
 				list.add(new DesignFileReq(designFile.getId(), EnumDesignFileType.getEnum(designFile.getType()), file.getFileUrl(), designFile.getStatus(), designFile.getName(),
 						designFile.getSource(), designFile.getExtendedData(), designFile.getSourceId(),file.getIsPrimary()));
 		}
 		}
 		}
		return list;
	}

	/**
	 * 获取 references Asset IDs<br>
	 * 
	 * @param references
	 *            references
	 * @return references Asset IDs
	 * @return List<String>
	 */
	public static List<String> toAssetList( final ReferencesCollection references )
	{
		if(references == null || references.getReferenceAssets().size() <= 0)
		{
			return null;
		}

		List<String> result = new ArrayList<String>();

		final List<ReferenceAssets> list = references.getReferenceAssets();

		final int len = list.size();

		for( int i = 0; i < len; i++ )
		{
			result.add(list.get(i).getAssetId().toString());
		}
		return result;
	}

	/**
	 * 将修改后的数据赋值到新数据<br>
	 * 
	 * @param request
	 * @return
	 * @return ThreeDimensionalCD
	 */
	public static ThreeDimensionalCD toThreeDimensional( final ThreeDimensionalCD request )
	{
		final ThreeDimensionalCD threeDimensional = new ThreeDimensionalCD(null, request.getBedroom(), request.getCity(), request.getCommunityName(), request.getConception(),
			request.getCustomStringArea(), request.getCustomStringBedroom(), request.getCustomStringForm(), request.getCustomStringName(), request.getCustomStringRestroom(),
			request.getCustomStringStyle(), request.getCustomStringType(), request.getDesignFile(), request.getDesignName(), request.getDistrict(), request.getHsDesignerUid(),
			request.getHsDesignId(), request.getProjectStyle(), request.getProjectType(), request.getProvince(), request.getPublishStatus(), request.getRestroom(),
			request.getRoomArea(), request.getRoomType(), null, null, null, null, null, null, null, null);
		return threeDimensional;
	}

	/**
	 * 将Asset转换为3D详情<br>
	 * 
	 * @param asset
	 *            Asset
	 * @return 3D详情
	 * @return ThreeDimensionalCD
	 */
	public static ThreeDimensionalCD toThreeDimensional( final AssetCollection asset )
	{
		final ThreeDimensionalCD threeDimensional = JSONCustomDataUtility.toObject(asset.getExtendedData(), ThreeDimensionalCD.class);
		return threeDimensional;
	}
}
