package com.juran.examplemovie.client.bean.enums;


/**
 * 案例审核枚举
 * 
 * @author : 张松森
 * @E-mail : songsen.zhang@leediancn.com
 * @date : 2016年3月7日 上午11:46:29
 * @version : 2016年3月7日 张松森 TODO简要描述修改内容，修改原因
 */
public enum EnumD2Cases
{

	/**
	 * @Fields FAIL 审核未通过
	 */
	FAIL(2),

	/**
	 * @Fields SUCCESS 审核通过
	 */
	SUCCESS(1),

	/**
	 * @Fields WAITING 审核中
	 */
	WAITING(0);

	public static EnumD2Cases getEnum( final Integer val )
	{
		for( EnumD2Cases enumNeed : EnumD2Cases.values() )
		{
			if(enumNeed.getValue().equals(val))
			{
				return enumNeed;
			}
		}
		return null;
	}

	public static Integer getValue( final EnumD2Cases val )
	{
		return val.getValue();
	}

	private final Integer value;

	EnumD2Cases( Integer value )
	{
		this.value = value;
	}

	public Integer getValue()
	{
		return value;
	}
}
