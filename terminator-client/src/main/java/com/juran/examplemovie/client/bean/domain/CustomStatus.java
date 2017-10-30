package com.juran.examplemovie.client.bean.domain;


import java.io.Serializable;

import org.springframework.util.StringUtils;

import com.juran.examplemovie.client.bean.enums.EnumBidder;
import com.juran.examplemovie.client.bean.enums.EnumFullflowStatus;
import com.juran.examplemovie.client.bean.enums.EnumNode;
import com.juran.examplemovie.client.bean.enums.EnumStage;
import com.juran.examplemovie.client.bean.enums.EnumStatus;
import com.juran.examplemovie.client.bean.enums.EnumWorkflow;


/**
 * 订单状态
 * 
 * @author songsen.zhang
 * @version 2016年6月7日 2016年6月7日 下午1:37:18 songsen.zhang
 */
public class CustomStatus implements Serializable
{

	private static final long	serialVersionUID	= -600090100752397934L;

	/**
	 * @Fields desc 状态描述
	 */
	private String				desc;

	/**
	 * @Fields memberId 用户ID
	 */
	private Long				memberId;

	/**
	 * @Fields status 类型
	 */
	private EnumStatus			status;

	/**
	 * <p>
	 * method name CustomStatus.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param status
	 * @param desc
	 * @param memberId
	 */
	public CustomStatus( final EnumStatus status, final String desc, final Long memberId )
	{
		super();
		this.status = status;
		this.desc = desc;
		this.memberId = memberId;
	}

	/**
	 * <p>
	 * method name CustomStatus.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param status
	 * @param stage
	 * @param memberId
	 */
	public CustomStatus( final EnumStatus status, final EnumStage stage, final Long memberId )
	{
		super();
		this.status = status;
		this.desc = stage.getValue();
		this.memberId = memberId;
	}

	/**
	 * <p>
	 * method name CustomStatus.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param status
	 * @param desc
	 * @param memberId
	 */
	public CustomStatus( final EnumStatus status, final EnumBidder desc, final Long memberId )
	{
		super();
		this.status = status;
		this.desc = desc.getValue();
		this.memberId = memberId;
	}

	/**
	 * <p>
	 * method name CustomStatus.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param status
	 * @param desc
	 * @param memberId
	 */
	public CustomStatus( final EnumStatus status, final EnumNode desc, final Long memberId )
	{
		super();
		this.status = status;
		this.desc = desc.getValue();
		this.memberId = memberId;
	}

	/**
	 * <p>
	 * method name CustomStatus.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param status
	 */
	public CustomStatus( final EnumStatus status )
	{
		super();
		this.status = status;
	}

	/**
	 * <p>
	 * method name CustomStatus.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param status
	 * @param desc
	 * @param memberId
	 */
	public CustomStatus( final EnumStatus status, final EnumWorkflow desc, final Long memberId )
	{
		super();
		this.status = status;
		this.desc = desc.getValue();
		this.memberId = memberId;
	}

	/**
	 * <p>
	 * method name CustomStatus.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param status
	 * @param desc
	 * @param memberId
	 */
	public CustomStatus( final EnumStatus status, final EnumFullflowStatus desc, final Long memberId )
	{
		super();
		this.status = status;
		this.desc = desc.getValue();
		this.memberId = memberId;
	}

	/**
	 * get desc<br>
	 * 
	 * @return desc
	 * @return String
	 */
	public String getDesc()
	{
		return desc;
	}

	/**
	 * get member id<br>
	 * 
	 * @return member id
	 * @return Long
	 */
	public Long getMemberId()
	{
		return memberId;
	}

	/**
	 * get status<br>
	 * 
	 * @return status
	 * @return EnumStatus
	 */
	public EnumStatus getStatus()
	{
		return status;
	}

	/**
	 * set desc<br>
	 * 
	 * @param desc
	 */
	public void setDesc( final String desc )
	{
		this.desc = desc;
	}

	/**
	 * set member id<br>
	 * 
	 * @param memberId
	 */
	public void setMemberId( final Long memberId )
	{
		this.memberId = memberId;
	}

	/**
	 * set status<br>
	 * 
	 * @param status
	 */
	public void setStatus( final EnumStatus status )
	{
		this.status = status;
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
		if(status != null)
		{
			builder.append(status.getValue());
		}
		if(!StringUtils.isEmpty(desc))
		{
			builder.append("-");
			builder.append(desc);
		}
		if(memberId != null)
		{
			builder.append("-");
			builder.append(memberId);
		}
		return builder.toString();
	}
	
}
