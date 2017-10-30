package com.juran.examplemovie.client.bean.domain;


import java.io.Serializable;

import org.springframework.util.StringUtils;


/**
 * 订单状态
 * 
 * @author songsen.zhang
 * @version 2016年6月7日 2016年6月7日 下午1:37:18 songsen.zhang
 */
public class HsTag implements Serializable
{
	
	private static final long serialVersionUID = 1504121572764024269L;

	private final String		name				= "render-id";

	/**
	 * @Fields memberId 用户ID
	 */
	private String				id;

	public HsTag( String id )
	{
		super();
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	/**
	 * 重写toString()<br>
	 * 格式{status}-{desc}-{memberId}
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		if(name != null)
		{
			builder.append(name);
		}
		if(!StringUtils.isEmpty(id))
		{
			builder.append("-");
			builder.append(id);
		}
		return builder.toString();
	}
}
