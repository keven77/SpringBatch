package com.juran.examplemovie.client.bean.domain;


import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.juran.examplemovie.client.bean.enums.EnumDesignFileType;


/**
 * 3D方案图片数据结构
 * 
 * @author songsen.zhang
 * @version 2016年5月28日 2016年5月28日 下午8:55:45 songsen.zhang 简要描述修改内容，修改原因
 */
public class DesignFile implements Serializable
{

	private static final long	serialVersionUID	= -6309055920556002827L;

	/**
	 * @Fields extended_data 自定义数据
	 */
	@JSONField( name = "extended_data" )
	private String				extendedData;

	/**
	 * @Fields id 文件ID
	 */
	@JSONField( name = "id" )
	private String				id;

	/**
	 * @Fields link URL orURI
	 */
	@JSONField( name = "link" )
	private String				link;

	/**
	 * @Fields name 文件名
	 */
	@JSONField( name = "name" )
	private String				name;

	/**
	 * @Fields source 来源 0：HS同步 1：上传
	 */
	@JSONField( name = "source" )
	private Integer				source;

	/**
	 * @Fields source_id 来源id
	 */
	@JSONField( name = "source_id" )
	private String				sourceId;

	/**
	 * @Fields status 状态
	 */
	@JSONField( name = "status" )
	private Integer				status;

	/**
	 * @Fields type 上传的文件类型
	 */
	@JSONField( name = "type" )
	private String				type;
	
	
	/** 
	* @Fields data 全景渲染图封面
	*/  
	@JSONField( name = "cover" )
	private String				cover;

	/**
	 * <p>
	 * method name DesignFile.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 */
	public DesignFile()
	{
		super();
	}

	/**
	 * <p>
	 * method name DesignFile.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param id
	 */
	public DesignFile( final String id )
	{
		super();
		this.id = id;
	}

	/**
	 * <p>
	 * method name DesignFile.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param id
	 * @param type
	 * @param link
	 * @param status
	 * @param name
	 * @param source
	 * @param extendedData
	 */
	public DesignFile( String id, EnumDesignFileType type, String link, Integer status, String name, Integer source, String extendedData )
	{
		super();
		this.id = id;
		this.type = type.getValue();
		this.link = link;
		this.status = status;
		this.name = name;
		this.source = source;
		this.extendedData = extendedData;
	}

	/**
	 * <p>
	 * method name DesignFile.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param id
	 * @param type
	 * @param link
	 * @param status
	 * @param name
	 * @param source
	 * @param extendedData
	 * @param sourceId
	 */
	public DesignFile( String id, EnumDesignFileType type, String link, Integer status, String name, Integer source, String extendedData, String sourceId )
	{
		super();
		this.id = id;
		this.type = type.getValue();
		this.link = link;
		this.status = status;
		this.name = name;
		this.source = source;
		this.extendedData = extendedData;
		this.sourceId = sourceId;
	}
	
	public DesignFile( String id, String type, String link, Integer status, String name, Integer source, String extendedData, String sourceId )
	{
		super();
		this.id = id;
		this.type = type;
		this.link = link;
		this.status = status;
		this.name = name;
		this.source = source;
		this.extendedData = extendedData;
		this.sourceId = sourceId;
	}

	/**
	 * 获取自定义数据<br>
	 * 
	 * @return 自定义数据
	 * @return String
	 */
	public String getExtendedData()
	{
		return extendedData;
	}

	/**
	 * 获取文件ID<br>
	 * 
	 * @return 文件ID
	 * @return String
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * 获取link<br>
	 * 
	 * @return link
	 * @return String
	 */
	public String getLink()
	{
		return link;
	}

	/**
	 * 获取文件名称<br>
	 * 
	 * @return 文件名称
	 * @return String
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 获取文件来源<br>
	 * 
	 * @return 文件来源
	 * @return Integer
	 */
	public Integer getSource()
	{
		return source;
	}

	/**
	 * 获取来源ID<br>
	 * 
	 * @return 来源ID
	 * @return String
	 */
	public String getSourceId()
	{
		return sourceId;
	}

	/**
	 * 获取状态<br>
	 * 
	 * @return 状态
	 * @return Integer
	 */
	public Integer getStatus()
	{
		return status;
	}

	/**
	 * 获取类型<br>
	 * 
	 * @return 类型
	 * @return String
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * 设置自定义数据<br>
	 * 
	 * @param extendedData
	 *            自定义数据
	 */
	public void setExtendedData( final String extendedData )
	{
		this.extendedData = extendedData;
	}

	/**
	 * 设置文件ID<br>
	 * 
	 * @param id
	 *            文件ID
	 */
	public void setId( final String id )
	{
		this.id = id;
	}

	/**
	 * 设置link<br>
	 * 
	 * @param link
	 *            link
	 */
	public void setLink( final String link )
	{
		this.link = link;
	}

	/**
	 * 设置文件名称<br>
	 * 
	 * @param name
	 *            文件名称
	 */
	public void setName( final String name )
	{
		this.name = name;
	}

	/**
	 * 设置文件<br>
	 * 
	 * @param source
	 *            文件来源
	 */
	public void setSource( final Integer source )
	{
		this.source = source;
	}

	/**
	 * 设置文件来源ID<br>
	 * 
	 * @param sourceId
	 *            来源ID
	 */
	public void setSourceId( final String sourceId )
	{
		this.sourceId = sourceId;
	}

	/**
	 * 设置状态<br>
	 * 
	 * @param status
	 *            状态
	 */
	public void setStatus( final Integer status )
	{
		this.status = status;
	}

	/**
	 * 设置文件类型<br>
	 * 
	 * @param type
	 *            文件类型 {@link EnumDesignFileType}
	 */
	public void setType( final String type )
	{
		this.type = type;
	}

	public String getCover()
	{
		return cover;
	}

	public void setCover( String cover )
	{
		this.cover = cover;
	}

	
}
