package com.juran.examplemovie.client.bean.domain;


import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.juran.examplemovie.client.bean.enums.EnumBidder;
import com.juran.examplemovie.client.bean.enums.EnumFullflowStatus;
import com.juran.examplemovie.client.bean.enums.EnumNode;
import com.juran.examplemovie.client.bean.enums.EnumStage;
import com.juran.examplemovie.client.bean.enums.EnumStatus;
import com.juran.examplemovie.client.bean.enums.EnumWorkflow;


/**
 * Custom keys 操作
 * 
 * @author songsen.zhang
 * @version 2016年6月21日 2016年6月21日 下午4:36:02 songsen.zhang 创建
 */
public class CustomKeyDco
{

	/**
	 * 添加新状态<br>
	 * 
	 * @param keys
	 *            原始状态
	 * @param customKey
	 *            新状态
	 */
	public void add( List<CustomKey> keys, final CustomKey customKey )
	{
		keys.add(customKey);
	}

	/**
	 * 添加新状态<br>
	 * 
	 * @param keys
	 *            原始状态
	 * @param customKeys
	 *            新状态
	 */
	public void add( List<CustomKey> keys, final List<CustomKey> customKeys )
	{
		keys.addAll(customKeys);
	}

	/**
	 * String 类型转换为类型列表<br>
	 * 
	 * @param keys
	 *            原类型
	 * @return
	 * @return List<CustomKey>
	 */
	public List<CustomKey> convertStringToArray( final String keys )
	{
		List<CustomKey> list;
		try
		{
			list = (ArrayList<CustomKey>) JSON.parseArray(StringUtils.isEmpty(keys) ? "[]" : keys, CustomKey.class);
		}
		catch(Exception e)
		{
			list = new ArrayList<CustomKey>();
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
	public String convertArrayToJson( final List<CustomKey> keys )
	{
		final String keysJson = JSON.toJSONString(keys).replace("\"", "'");

		return keysJson;
	}

	/**
	 * 修改列表中当前设计师状态<br>
	 * 
	 * @param keys
	 *            原有状态列表
	 * @param newKeys
	 *            最新的状态列表
	 */
	public void update( List<CustomKey> keys, final List<CustomKey> newKeys )
	{
		for( CustomKey newStatus : newKeys )
		{
			CustomStatus newKey = convertStringToBean(newStatus.getKey());
			if(newKey == null)
			{
				continue;
			}
			EnumBidder enumBidder = EnumBidder.getEnumOfVal(newKey.getDesc());
			EnumNode enumNode = EnumNode.getEnum(newKey.getDesc());
			EnumWorkflow enumWorkflow = EnumWorkflow.getEnum(newKey.getDesc());
			EnumStage enumStage = EnumStage.getEnum(newKey.getDesc());
			EnumFullflowStatus enumFullflowStatus = EnumFullflowStatus.getEnum(newKey.getDesc());
			for( CustomKey customKey : keys )
			{
				CustomStatus key = convertStringToBean(customKey.getKey());
				if(key == null)
				{
					continue;
				}
				if(key.getMemberId().equals(newKey.getMemberId()))
				{
					EnumBidder designerEnumBidder = EnumBidder.getEnumOfVal(key.getDesc());
					EnumNode designerEnumNode = EnumNode.getEnum(key.getDesc());
					EnumWorkflow designerEnumWorkflow = EnumWorkflow.getEnum(key.getDesc());
					EnumFullflowStatus designerEnumFullflowStatus = EnumFullflowStatus.getEnum(key.getDesc());
					EnumStage designerEnumStage = EnumStage.getEnum(key.getDesc());
					if(enumStage != null && designerEnumStage != null)
					{
						customKey.setValue(false);
						continue;
					}
					if(enumBidder != null && designerEnumBidder != null)
					{
						customKey.setValue(false);
						continue;
					}
					if(enumNode != null && designerEnumNode != null)
					{
						customKey.setValue(false);
						continue;
					}
					if(enumWorkflow != null && designerEnumWorkflow != null)
					{
						customKey.setValue(false);
						continue;
					}
					if(enumFullflowStatus != null && designerEnumFullflowStatus != null)
					{
						customKey.setValue(false);
						continue;
					}
				}
			}
		}
	}

	/**
	 * 将原始数据中value 为 flase 的剔除<br>
	 * 
	 * @param keys
	 * @return
	 * @return List<CustomKey> 所有value 为 true 的数据
	 */
	public List<CustomKey> delete( final List<CustomKey> keys )
	{
		List<CustomKey> result = new ArrayList<CustomKey>();
		keys.stream().filter(( p ) -> p.getValue()).forEach(( p ) -> result.add(p));;
		return result;
	}

	/**
	 * 获取列表中所有true 的数据<br>
	 * 
	 * @param keys
	 * @return
	 * @return List<CustomKey>
	 */
	public List<CustomKey> getByTrue( final List<CustomKey> keys )
	{
		List<CustomKey> result = new ArrayList<CustomKey>();
		keys.stream().filter(( p ) -> p.getValue()).forEach(( p ) -> result.add(p));;
		return result;
	}

	/**
	 * 获取列表中所有false 的数据<br>
	 * 
	 * @param keys
	 * @return
	 * @return List<CustomKey>
	 */
	public List<CustomKey> getByFalse( final List<CustomKey> keys )
	{
		List<CustomKey> result = new ArrayList<CustomKey>();
		keys.stream().filter(( p ) -> !p.getValue()).forEach(( p ) -> result.add(p));;
		return result;
	}

	/**
	 * 转换String 为对象<br>
	 * 
	 * @param key
	 *            String
	 * @return
	 * @return AssetNameModel
	 */
	private CustomStatus convertStringToBean( final String key )
	{
		if(StringUtils.isEmpty(key))
		{
			return null;
		}
		final String[] info = key.split("-");
		if(info.length >= 3)
		{
			return new CustomStatus(EnumStatus.getEnum(info[0]), info[1], Long.valueOf(info[2]));
		}
		return null;
	}
}
