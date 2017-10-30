package com.juran.examplemovie.client.bean.enums;


/**
 * 工作流状态
 * 
 * @author songsen.zhang
 * @version 2016年6月7日 2016年6月7日 上午11:42:50 songsen.zhang 创建
 */
public enum EnumStatus
{

	/**
	 * @Fields BEISHU 北舒
	 */
	BEISHU(3, "beishu"),

	/**
	 * @Fields BID 应标
	 */
	BID(1, "bid"),

	/**
	 * @Fields FULLFLOW 全流程
	 */
	FULLFLOW(2, "fullflow"),

	/**
	 * @Fields PKG 套餐
	 */
	PKG(4, "pkg"),

	/**
	 * @Fields ELITE 精选
	 */
	ELITE(5, "elite"),

	/**
	 * @Fields ELITE_SELECTION 精选备用方案
	 */
	ELITE_SELECTION(8, "elite_selection"),

	/**
	 * @Fields MASTER 大师
	 */
	MASTER(6, "master"),

	/**
	 * @Fields STUDIO 工作室
	 */
	STUDIO(7, "studio"),
	
	ACTIVITY(8,"activity"),
	
	//20161110 发布alpha 消费者发布的需求查不到,修改此值
	MATERIALS(99, "materials");  

	public static EnumStatus getEnum( final Integer key )
	{
		for( final EnumStatus enumStatus : EnumStatus.values() )
		{
			if(enumStatus.getKey().equals(key))
			{
				return enumStatus;
			}
		}
		return null;
	}

	public static EnumStatus getEnum( final String val )
	{
		for( final EnumStatus enumStatus : EnumStatus.values() )
		{
			if(enumStatus.getValue().equals(val))
			{
				return enumStatus;
			}
		}
		return null;
	}

	public static Integer getValue( final EnumTemplate val )
	{
		return val.getValue();
	}

	private final Integer	key;

	private final String	value;

	private EnumStatus( Integer key, String value )
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
