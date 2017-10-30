package com.juran.examplemovie.client.bean.enums;


/**
 * 是否推荐
 * 
 * @author songsen.zhang
 * @version 2016年6月24日 2016年6月24日 上午11:44:07 songsen.zhang
 */
public enum EnumFullflowStatus
{

	/**
	 * @Fields SELF_RECOMMEND 自选已推荐
	 */
	SELF_RECOMMEND("self_recommend"),

	/**
	 * @Fields SELF_UNRECOMMEND 自选待推荐
	 */
	SELF_UNRECOMMEND("self_unrecommend"),

	/**
	 * @Fields BID_RECOMMEND 应标已推荐
	 */
	BID_RECOMMEND("bid_recommend"),

	/**
	 * @Fields BID_UNRECOMMEND 应标待推荐
	 */
	BID_UNRECOMMEND("bid_unrecommend");

	public static EnumFullflowStatus getEnum( final String val )
	{
		for( final EnumFullflowStatus enumFullflowStatus : EnumFullflowStatus.values() )
		{
			if(enumFullflowStatus.getValue().equals(val))
			{
				return enumFullflowStatus;
			}
		}
		return null;
	}

	public static String getValue( final EnumFullflowStatus val )
	{
		return val.getValue();
	}

	private final String value;

	EnumFullflowStatus( String value )
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}
