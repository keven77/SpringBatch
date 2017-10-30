package com.juran.examplemovie.client.bean.enums;



/**
 * 工作流节点描述 
 * @author songsen.zhang
 * @version 2016年7月1日 2016年7月1日 上午10:08:14 songsen.zhang   
 */
public enum EnumNode
{
	/**
	 * @Fields BEISHU_NODE designer：北舒套餐 consumer：北舒套餐
	 */
	BEISHU_NODE("beishu_node"),

	/**
	 * @Fields CONFIRM_CONTRACT designer：等待确认合同 consumer：确认合同
	 */
	CONFIRM_CONTRACT("confirm_contract"),

	/**
	 * @Fields DELIVERY designer：上传交付物 consumer：等待交付物
	 */
	DELIVERY("delivery"),

	/**
	 * @Fields MEASURE designer：量房 consumer：量房
	 */
	MEASURE("measure"),

	/**
	 * @Fields PAYMENT_OF_FIRST_FEE designer：等待设计首款 consumer：支付设计首款
	 */
	PAYMENT_OF_FIRST_FEE("payment_of_first_fee"),

	/**
	 * @Fields PAYMENT_OF_LAST_FEE designer：等待设计尾款 consumer：支付设计尾款
	 */
	PAYMENT_OF_LAST_FEE("payment_of_last_fee"),

	/**
	 * @Fields PAYMENT_OF_MEASURE designer：接受量房费 consumer：支付量房费
	 */
	PAYMENT_OF_MEASURE("payment_of_measure"),

	/**
	 * @Fields START_NODE designer： consumer：
	 */
	START_NODE("start_node"),
	
	/**
	 * @Fields DELIVERY_ESTIMATE designer： consumer：交付物评价
	 */
	DELIVERY_ESTIMATE("delivery_estimate"),
	
	
	/**
	 * @Fields INVITE_MEASURE_AND_PAY designer：等待设计师发送设计合同 consumer：未创建设计合同
	 */
	INVITE_MEASURE_AND_PAY("invite_measure_and_pay")
	
	
	
	
	;

	public static EnumNode getEnum( final String val )
	{
		for( EnumNode rnumNode : EnumNode.values() )
		{
			if(rnumNode.getValue().equals(val))
			{
				return rnumNode;
			}
		}
		return null;
	}

	public static String getValue( final EnumNode val )
	{
		return val.getValue();
	}

	private final String value;

	EnumNode( String value )
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}
