package com.juran.examplemovie.client.bean.enums;


import org.springframework.util.StringUtils;


/**
 * Bidder状态
 * 
 * @author : 张松森
 * @E-mail : songsen.zhang@leediancn.com
 * @date : 2016年3月6日 下午4:43:41
 * @version : 2016年3月6日 张松森 创建
 */
public enum EnumBidder
{

	/**
	 * @Fields CANCEL 取消应标
	 */
	CANCEL("3", "cancel"),

	/**
	 * @Fields REFUSED 拒绝应标
	 */
	REFUSED("2", "refused"),

	/**
	 * @Fields SELECTED 同意应标
	 */
	SELECTED("1", "selected"),

	/**
	 * @Fields UNSELECTED 应标中
	 */
	UNSELECTED("0", "unselected");

	public static EnumBidder getEnum( final String key )
	{
		if(StringUtils.isEmpty(key))
		{
			return null;
		}
		for( EnumBidder enumBidder : EnumBidder.values() )
		{
			if(enumBidder.getKey().equals(Integer.valueOf(key).toString()))
			{
				return enumBidder;
			}
		}
		return null;
	}

	public static EnumBidder getEnumOfVal( final String val )
	{
		if(StringUtils.isEmpty(val))
		{
			return null;
		}
		for( EnumBidder enumBidder : EnumBidder.values() )
		{
			if(enumBidder.getValue().equals(val))
			{
				return enumBidder;
			}
		}
		return null;
	}

	public static String getValue( final EnumBidder val )
	{
		return val.getValue();
	}

	private final String	key;

	private final String	value;

	EnumBidder( String key, String value )
	{
		this.key = key;
		this.value = value;
	}

	public String getKey()
	{
		return key;
	}

	public String getValue()
	{
		return value;
	}
}
