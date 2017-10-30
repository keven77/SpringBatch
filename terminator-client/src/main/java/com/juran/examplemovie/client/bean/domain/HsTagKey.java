package com.juran.examplemovie.client.bean.domain;


import java.io.Serializable;


public class HsTagKey implements Serializable
{

	private static final long	serialVersionUID	= 2087906946069750455L;

	private String				key;

	private DesignFile				value;

	public HsTagKey()
	{
		super();
	}

	public HsTagKey( HsTag key, DesignFile value )
	{
		super();
		this.key = key.toString();
		this.value = value;
	}

	public String getKey()
	{
		return key;
	}

	public DesignFile getValue()
	{
		return value;
	}

	public void setKey( String key )
	{
		this.key = key;
	}

	public void setValue( DesignFile value )
	{
		this.value = value;
	}

}
