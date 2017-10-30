package com.juran.examplemovie.client.bean.domain;


import java.io.Serializable;


public class CustomKey implements Serializable
{

	private static final long	serialVersionUID	= 2087906946069750455L;

	private String				key;

	private Boolean				value;

	public CustomKey()
	{
		super();
	}

	public CustomKey( CustomStatus key, Boolean value )
	{
		super();
		this.key = key.toString();
		this.value = value;
	}

	public String getKey()
	{
		return key;
	}

	public Boolean getValue()
	{
		return value;
	}

	public void setKey( String key )
	{
		this.key = key;
	}

	public void setValue( Boolean value )
	{
		this.value = value;
	}

}
