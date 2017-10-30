package com.juran.examplemovie.client.bean.domain;


import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;


/**
 * hs tag 操作
 * 
 * @author songsen.zhang
 * @version 2016年6月21日 2016年6月21日 下午4:36:02 songsen.zhang 创建
 */
public class HsTagDco
{

	/**
	 * 添加新状态<br>
	 * 
	 * @param keys
	 *            原始状态
	 * @param hsTagKey
	 *            新状态
	 */
	public void add( List<HsTagKey> keys, final HsTagKey hsTagKey )
	{
		keys.add(hsTagKey);
	}

	/**
	 * 添加新状态<br>
	 * 
	 * @param keys
	 *            原始状态
	 * @param customKeys
	 *            新状态
	 */
	public void add( List<HsTagKey> keys, final List<HsTagKey> hsTagKeys )
	{
		keys.addAll(hsTagKeys);
	}

	/**
	 * String 类型转换为类型列表<br>
	 * 
	 * @param keys
	 *            原类型
	 * @return
	 * @return List<HsTagKey>
	 */
	public List<HsTagKey> convertStringToArray( final String keys )
	{
		List<HsTagKey> list;
		try
		{
			list = (ArrayList<HsTagKey>) JSON.parseArray(StringUtils.isEmpty(keys) ? "[]" : keys, HsTagKey.class);
		}
		catch(Exception e)
		{
			list = new ArrayList<HsTagKey>();
		}
		return list;
	}

	/**
	 * 将列表转换为String<br>
	 * 
	 * @param keys
	 *            列表
	 * @return
	 * @return String
	 */
	public String convertArrayToJson( final List<HsTagKey> keys )
	{
		final String keysJson = JSON.toJSONString(keys).replace("\"", "'");

		return keysJson;
	}

}
