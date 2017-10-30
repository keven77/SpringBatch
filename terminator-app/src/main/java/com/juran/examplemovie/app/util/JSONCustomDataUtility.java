package com.juran.examplemovie.app.util;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.autodesk.mp.client.models.domainobject.assets.result.CustomDataCollection;
import com.autodesk.mp.client.models.domainobject.assets.result.CustomDatas;
import com.autodesk.mp.client.models.domainobject.members.result.KeyFilefolder;
import com.autodesk.mp.client.models.domainobject.members.result.KeyFilefolderCollection;
import com.juran.examplemovie.client.bean.domain.CustomKey;
import com.juran.examplemovie.client.bean.domain.CustomKeyDco;
import com.juran.examplemovie.client.bean.domain.HsTagDco;
import com.juran.examplemovie.client.bean.domain.HsTagKey;


/**
 * 操作CustomData
 * 
 * @author songsen.zhang
 * @version 2016年5月24日 2016年5月24日 下午3:56:58 songsen.zhang 添加final
 */
public class JSONCustomDataUtility
{
	/**
	 * @Description：将CustomDataList 中的 CustomData 转换为 定义类
	 * @param list
	 *            CustomDataList
	 * @param clazz
	 *            需要转换的类型(与存入的对象属性相对应的类)
	 * @return: 返回结果描述
	 * @return T: 返回值类型
	 */
	public static <T> T jsonToJavaObject( final CustomDataCollection list, final Class<T> clazz )
	{
		StringBuffer sbf1 = new StringBuffer();
		for( CustomDatas abc : list.getCustomData() )
		{
			// System.out.println(abc.getData().toString().replace("'", "\""));
			sbf1.append("\"" + abc.getKey() + "\":\"" + abc.getData() + "\",");
		}
		StringBuffer sbf2 = new StringBuffer();
		sbf2.append("{");
		if(sbf1.length() > 0)
		{
			sbf2.append(sbf1.substring(0, sbf1.length() - 1));
		}
		sbf2.append("}");
		JSON jp = JSON.parseObject(JSON.toJSON(sbf2.toString()).toString());
		return JSON.toJavaObject(jp, clazz);
	}

	public static <T> T jsonToJavaObject( Object object, Class<T> clazz )
	{
		if(object != null && !"".equals(object))
		{
			JSON jp = JSON.parseObject(JSON.toJSON(object.toString()).toString());
			return JSON.toJavaObject(jp, clazz);
		}
		return null;
	}

	/**
	 * 将对象转换为CustomData<br>
	 * 
	 * @param bean
	 * @return TODO返回结果描述 @return String 返回值类型 @throws
	 */
	public static String toCustomdata( final Object bean )
	{
		StringBuffer buffer = new StringBuffer();
		List<Map<String, Object>> customdatas = new ArrayList<Map<String, Object>>();
		if(bean != null)
		{
			final String json = JSON.toJSONString(bean);
			final JSONObject jsonObject = JSON.parseObject(json);
			final Iterator<Entry<String, Object>> iterator = jsonObject.entrySet().iterator();
			while(iterator.hasNext())
			{
				Entry<String, Object> entry = iterator.next();
				if(entry.getValue() != null && !StringUtils.isEmpty(( entry.getValue().toString() )))
				{
					if("custom_keys".equals(entry.getKey()))
					{
						addCustomKeys(customdatas, entry);
					}
					if("hs_tag".equals(entry.getKey()))
					{
						addTag(customdatas, entry);
						continue;
					}
					Map<String, Object> customdata = new LinkedHashMap<String, Object>();
					customdata.put("key", entry.getKey());
					if(entry.getValue() instanceof Number)
					{
						customdata.put("data", new BigDecimal(entry.getValue().toString()).toPlainString());
					}
					else
					{
						customdata.put("data", entry.getValue().toString().replaceAll("\"", "'").replaceAll("%", "%25").replaceAll(",", "%2C").replaceAll("@", "%40"));
					}

					customdatas.add(customdata);
				}
			}
		}
		buffer.append("{\"custom_data\":");
		buffer.append(JSON.toJSONString(customdatas));
		buffer.append("}");
		System.out.println(buffer.toString().replaceAll(" ", "%20"));
		return buffer.toString().replaceAll(" ", "%20");
	}

	private static void addTag( List<Map<String, Object>> customdatas, final Entry<String, Object> entry )
	{
		HsTagDco hsTagDco = new HsTagDco();
		List<HsTagKey> keys = hsTagDco.convertStringToArray(entry.getValue().toString());
		for( HsTagKey hsTagKey : keys )
		{
			Map<String, Object> customdata = new LinkedHashMap<String, Object>();
			customdata.put("key", hsTagKey.getKey());
			customdata.put("data", JSON.toJSONString(hsTagKey.getValue()).replaceAll("\"", "'"));
			customdatas.add(customdata);
		}
	}

	/**
	 * 为Custom添加状态项目<br>
	 * 
	 * @param customdatas
	 * @param entry
	 */
	private static void addCustomKeys( List<Map<String, Object>> customdatas, final Entry<String, Object> entry )
	{
		CustomKeyDco dco = new CustomKeyDco();
		List<CustomKey> keys = dco.convertStringToArray(entry.getValue().toString());
		for( CustomKey customKey : keys )
		{
			if(customKey.getValue())
			{
				Map<String, Object> customdata = new LinkedHashMap<String, Object>();
				customdata.put("key", customKey.getKey());
				customdata.put("data", customKey.getValue());
				customdatas.add(customdata);
			}
		}
	}

	public static <T> T toObject( final Object object, final Class<T> clazz )
	{
		if(object != null && !"".equals(object))
		{
			final JSON jp = JSON.parseObject(JSON.toJSON(object.toString()).toString());
			return JSON.toJavaObject(jp, clazz);
		}
		return null;
	}

	public static <T> T jsonToJavaObject( final Object object, final Class<T> clazz, final String level )
	{
		final String ToJson = object.toString().replace("‘" + level + "’", "'");
		final JSON jp = JSON.parseObject(JSON.toJSON(ToJson).toString());
		return JSON.toJavaObject(jp, clazz);
	}

	public static <T> T jsonToJavaObject1( final Object object, Class<T> c )
	{
		final JSONObject jp = JSON.parseObject(JSON.toJSON(object.toString()).toString());
		return JSON.toJavaObject(jp, c);
	}

	public static <T> T jsonToJavaObject( final KeyFilefolderCollection list, final Class<T> clazz )
	{
		StringBuffer sbf1 = new StringBuffer();
		for( final KeyFilefolder abc : list.getKeyFilefolder() )
		{
			// System.out.println(abc.getData().toString().replace("'", "\""));
			sbf1.append("\"" + abc.getKey() + "\":\"" + abc.getFilefolder() + "\",");
		}
		StringBuffer sbf2 = new StringBuffer();
		sbf2.append("{");
		if(sbf1.length() > 0)
		{
			sbf2.append(sbf1.substring(0, sbf1.length() - 1));
		}
		sbf2.append("}");
		final JSON jp = JSON.parseObject(JSON.toJSON(sbf2.toString()).toString());
		return JSON.toJavaObject(jp, clazz);
	}

	/**
	 * 根据制定Key 获取 value<br>
	 * 
	 * @param list
	 *            列表
	 * @param key
	 * @return
	 * @return Object
	 */
	public static Object jsonToJavaObject( final KeyFilefolderCollection list, final String key )
	{
		for( final KeyFilefolder abc : list.getKeyFilefolder() )
		{
			// System.out.println(abc.getData().toString().replace("'", "\""));
			if(key.equals(abc.getKey()))
			{
				return abc.getFilefolder();
			}
		}
		return null;
	}

}
