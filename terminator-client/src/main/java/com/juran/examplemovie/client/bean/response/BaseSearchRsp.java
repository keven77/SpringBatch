package com.juran.examplemovie.client.bean.response;


import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModelProperty;


/**
 * 列表返回
 * 
 * @author songsen.zhang
 * @version 2016年5月26日 2016年5月26日 上午10:44:13 songsen.zhang 创建
 */
@XmlRootElement
public class BaseSearchRsp implements Serializable
{

	/**
	 * @Fields serialVersionUID
	 */
	private static final long	serialVersionUID	= -5766720348357223641L;

	/**
	 * @Fields count 总数
	 */
	@XmlAttribute( name = "count" )
	@ApiModelProperty( value = "总数", name = "count" )
	private Integer				count;

	/**
	 * @Fields date 返回时间
	 */
	@XmlAttribute( name = "date" )
	@ApiModelProperty( value = "返回时间", name = "date" )
	private Date				date;

	/**
	 * @Fields limit limit
	 */
	@XmlAttribute( name = "limit" )
	@ApiModelProperty( value = "显示个数", name = "limit" )
	private Integer				limit;

	/**
	 * @Fields offset offset
	 */
	@XmlAttribute( name = "offset" )
	@ApiModelProperty( value = "偏移量", name = "offset" )
	private Integer				offset;

	/**
	 * <p>
	 * method name BaseSearchRsp.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 */
	public BaseSearchRsp()
	{
		super();
	}

	/**
	 * <p>
	 * method name BaseSearchRsp.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param count
	 * @param limit
	 * @param offset
	 */

	/**
	 * get count<br>
	 * 
	 * @return count
	 * @return Integer
	 */
	public Integer getCount()
	{
		return count;
	}

	/**
	 * get date<br>
	 * 
	 * @return date
	 * @return Date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * get limit<br>
	 * 
	 * @return limit
	 * @return Integer
	 */
	public Integer getLimit()
	{
		return limit;
	}

	/**
	 * get offset<br>
	 * 
	 * @return offset
	 * @return Integer
	 */
	public Integer getOffset()
	{
		return offset;
	}

	/**
	 * set count<br>
	 * 
	 * @param count
	 *            count
	 */
	public void setCount( final Integer count )
	{
		this.count = count;
	}

	/**
	 * set date<br>
	 * 
	 * @param date
	 *            date
	 */
	public void setDate( final Date date )
	{
		this.date = date;
	}

	/**
	 * set limit<br>
	 * 
	 * @param limit
	 *            limit
	 */
	public void setLimit( final Integer limit )
	{
		this.limit = limit;
	}

	/**
	 * set offset<br>
	 * 
	 * @param offset
	 *            offset
	 */
	public void setOffset( final Integer offset )
	{
		this.offset = offset;
	}

}
