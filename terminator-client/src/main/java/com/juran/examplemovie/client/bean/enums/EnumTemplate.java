package com.juran.examplemovie.client.bean.enums;


/**
 * 工作流模板枚举
 * 
 * @author songsen.zhang
 * @version 2016年5月28日 2016年5月28日 下午7:41:15 songsen.zhang 创建
 */
public enum EnumTemplate
{
	/**
	 * @Fields BEISHU 北舒
	 */
	BEISHU(3),
	/**
	 * @Fields BID_DESIGNORDER 应标
	 */
	BID_DESIGNORDER(1),

	/**
	 * @Fields CHOOSE_DESIGNORDER 自选
	 */
	CHOOSE_DESIGNORDER(2),
	
	/**
	 * @Fields SELECTION_DESIGNER 精选
	 */
	SELECTION_DESIGNER(4);

	public static EnumTemplate getEnum( final Integer val )
	{
		for( final EnumTemplate enumWorkflow : EnumTemplate.values() )
		{
			if(enumWorkflow.getValue().equals(val))
			{
				return enumWorkflow;
			}
		}
		return null;
	}

	public static Integer getValue( final EnumTemplate val )
	{
		return val.getValue();
	}

	private final Integer value;

	EnumTemplate( Integer value )
	{
		this.value = value;
	}

	public Integer getValue()
	{
		return value;
	}
}
