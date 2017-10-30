package com.juran.examplemovie.app.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;
import com.autodesk.mp.client.exceptions.NotFoundModelAnnotation;
import com.autodesk.mp.client.models.domainobject.assets.result.AssetCollection;
import com.autodesk.mp.client.models.domainobject.members.result.KeyFilefolder;
import com.juran.examplemovie.client.bean.domain.DesignFileReq;
import com.juran.examplemovie.client.bean.domain.ThumbnailsFileRsp;

/**
 * 需求数据转换
 * 
 * @author songsen.zhang
 * @version 2016年5月31日 2016年5月31日 下午4:14:42 songsen.zhang 创建
 */
public class DesignBeanConverter {



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
	 * 获取3D案例主图<br>
	 * 
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
		if (org.springframework.util.StringUtils.isEmpty(thumbPathPrefix)) {
			images.addAll(D3CaseBeanConverter.getFiles(thumbPathPrefix));
		}
		return images;
	}

	/**
	 * 得到主图信息<br>
	 * 
	 * @param thumbnailList
	 * @return ThumbnailsFileRsp
	 */
	public static ThumbnailsFileRsp getThumbnailsMain(List<ThumbnailsFileRsp> thumbnailList) {
		final int len = thumbnailList.size();
		ThumbnailsFileRsp thumbnailsFileRsp = new ThumbnailsFileRsp();
		for (int i = 0; i < len; i++) {
			final ThumbnailsFileRsp file = thumbnailList.get(i);
			if (file.getIsPrimary()) {
				thumbnailsFileRsp.setFileId(file.getFileId());
				thumbnailsFileRsp.setFileName(file.getFileName());
				thumbnailsFileRsp.setFileUrl(file.getFileUrl());
				thumbnailsFileRsp.setIsPrimary(file.getIsPrimary());
				break;
			}
		}
		return thumbnailsFileRsp;
	}

	/**
	 * 获取项目ThreadId<br>
	 * 
	 * @param asset
	 *            设计项目
	 * @param designerId
	 *            设计师ID
	 * @return
	 * @return String
	 */
	public static String getProjectThreadId(final AssetCollection asset, final Long designerId) {
		Map<String, Object> map = (Map) asset.getExtendedData();
		return map.get("msg-design-" + designerId) != null ? map.get("msg-design-" + designerId).toString() : null;
	}
}
