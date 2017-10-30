package com.juran.examplemovie.client.util;

/**
 * 
 * @author : 张松森
 * @E-mail : songsen.zhang@leediancn.com
 * @date : 2016年1月26日 下午7:49:10
 * @version : 2016年1月26日 张松森 TODO简要描述修改内容，修改原因
 */
public class NumberUtility
{

	public static Double divide( Double num )
	{
		if(num != null)
		{
			return num / 100;
		}
		else
		{
			return null;
		}
	}

	public static Double multiply( Double num )
	{
		if(num != null)
		{
			return num * 100;
		}
		else
		{
			return null;
		}
	}

}
