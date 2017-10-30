package com.juran.examplemovie.client.bean.enums;


/**
 * 阶段状态描述
 * 
 * @author songsen.zhang
 * @version 2016年8月22日 2016年8月22日 下午5:30:01 songsen.zhang 创建
 */
public enum EnumStage
{
	/**
	 * 消费者选择设计师的时候的标识，用来标记这个设计师已经被选择量房了
	 */
	IS_SELECTED_MEASURE(1, "is_selected_measure");

	public static EnumStage getEnum( final Integer key )
	{
		for( final EnumStage enumStage : EnumStage.values() )
		{
			if(enumStage.getKey().equals(key))
			{
				return enumStage;
			}
		}
		return null;
	}

	public static EnumStage getEnum( final String val )
	{
		for( final EnumStage enumStatus : EnumStage.values() )
		{
			if(enumStatus.getValue().equals(val))
			{
				return enumStatus;
			}
		}
		return null;
	}

	public static Integer getValue( final EnumStage val )
	{
		return val.getKey();
	}

	private final Integer	key;

	private final String	value;

	private EnumStage( Integer key, String value )
	{
		this.key = key;
		this.value = value;
	}

	public Integer getKey()
	{
		return key;
	}

	public String getValue()
	{
		return value;
	}

}
