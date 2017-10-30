package com.juran.examplemovie.client.bean.enums;


/**
 * 工作流节点描述
 * 
 * @author songsen.zhang
 * @version 2016年5月28日 2016年5月28日 下午7:45:17 songsen.zhang 创建
 */
public enum EnumWorkflow
{
	/**
	 * @Fields AUTHOR_SEND_CONTRACT 设计师发送合同
	 */
	AUTHOR_SEND_CONTRACT("author_send_contract"),

	/**
	 * @Fields COMPLETE_DESIGN 工作流结束
	 */
	COMPLETE_DESIGN("complete_design"),

	/**
	 * @Fields CONFIRM_MEASURE 设计师同意量房
	 */
	CONFIRM_MEASURE("confirm_measure"),

	/**
	 * @Fields DECLINE_INVITE_MEASURE 设计师拒绝量房
	 */
	DECLINE_INVITE_MEASURE("decline_invite_measure"),

	/**
	 * @Fields DECLINE_MEASURE 消费者拒绝设计师
	 */
	DECLINE_MEASURE("decline_measure"),

	/**
	 * @Fields DELIVER_DESIGN_RESULTS 上传支付交付物
	 */
	DELIVER_DESIGN_RESULTS("deliver_design_results"),

	/**
	 * @Fields DELIVER_MEASURE_FILE 上传量房交付物
	 */
	DELIVER_MEASURE_FILE("deliver_measure_file"),

	/**
	 * @Fields STOP_MEASURE 消费者停止需求
	 */
	STOP_MEASURE("stop_measure"),

	/**
	 * @Fields INVITE_MEASURE 消费者邀请量房
	 */
	INVITE_MEASURE("invite_measure"),

	/**
	 * @Fields OPEN_3D_DESIGN 打开3d工具
	 */
	OPEN_3D_DESIGN("open_3d_design"),

	/**
	 * @Fields PAY_FOR_FIRST_FEE 支付设计首款
	 */
	PAY_FOR_FIRST_FEE("pay_for_first_fee"),

	/**
	 * @Fields PAY_FOR_LAST_FEE 支付尾款
	 */
	PAY_FOR_LAST_FEE("pay_for_last_fee"),

	/**
	 * @Fields PAY_FOR_MEASURE TODO 支付量房费
	 */
	PAY_FOR_MEASURE("pay_for_measure"),

	/**
	 * @Fields REVIEW_DESIGN_RESULTS 编辑交付物
	 */
	REVIEW_DESIGN_RESULTS("review_design_results"),

	/**
	 * @Fields CONFIRM_DESIGN_RESULTS 确认交付物
	 */
	CONFIRM_DESIGN_RESULTS("confirm_design_results"),

	/**
	 * @Fields DELAY_CONFIRM_DESIGN_RESULTS 延期确认交付物
	 */
	DELAY_CONFIRM_DESIGN_RESULTS("delay_confirm_design_results"),

	/**
	 * @Fields ESTIMATE 评价
	 */
	ESTIMATE("estimate"),

	/**
	 * @Fields DELAY_ESTIMATE 稍后评价
	 */
	DELAY_ESTIMATE("delay_estimate"),

	/**
	 * @Fields SELECTION_INVITE_MEASURE_AND_PAY 精选消费者选择设计师量房
	 */
	SELECTION_INVITE_MEASURE_AND_PAY("invite_measure_and_pay"),

	/**
	 * @Fields WAIT_PAY_FIRST_FEE 等待消费者付首款
	 */
	WAIT_PAY_FIRST_FEE("wait_pay_first_fee"),
	
	/**
	 * 设计师发起定金支付
	 */
	ORIGINATE_DEPOSIT_PAYMENT("originate_deposit_payment"),
	
	/**
	 * 消费者支付定金
	 */
	DEPOSIT_PAYMENT("deposit_payment"),
	
	/**
	 * 消费者定金支付成功
	 */
	PAYMENT_SUCCESS("payment_success");
	
	public static EnumWorkflow getEnum( final String val )
	{
		for( EnumWorkflow enumWorkflow : EnumWorkflow.values() )
		{
			if(enumWorkflow.getValue().equals(val))
			{
				return enumWorkflow;
			}
		}
		return null;
	}

	private final String value;

	private EnumWorkflow( final String value )
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}
