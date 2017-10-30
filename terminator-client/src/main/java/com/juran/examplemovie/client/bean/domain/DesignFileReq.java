package com.juran.examplemovie.client.bean.domain;


import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.juran.examplemovie.client.bean.enums.EnumDesignFileType;

import io.swagger.annotations.ApiModelProperty;


/**
 * 3D方案图片数据结构
 * 
 * @author songsen.zhang
 * @version 2016年5月28日 2016年5月28日 下午8:55:45 songsen.zhang 简要描述修改内容，修改原因
 */
@XmlRootElement
public class DesignFileReq implements Serializable
{

	private static final long	serialVersionUID	= -5358758588858437530L;

	/**
	 * @Fields extended_data 自定义数据
	 */
	@XmlAttribute( name = "extended_data" )
	@ApiModelProperty(value = "自定义数据" ,name = "extended_data" )
	private String				extendedData;

	/**
	 * @Fields id 文件ID
	 */
	@XmlAttribute( name = "id" )
	@ApiModelProperty(value = "文件ID" ,name = "id" )
	private String				id;

	/**
	 * @Fields link URL orURI
	 */
	@XmlAttribute( name = "link" )
	@ApiModelProperty(value = "文件链接" ,name = "link" )
	private String				link;

	/**
	 * @Fields name 文件名
	 */
	@XmlAttribute( name = "name" )
	@ApiModelProperty(value = "文件名" ,name = "name" )
	private String				name;

	/**
	 * @Fields source 来源 0：HS同步 1：上传
	 */
	@XmlAttribute( name = "source" )
	@ApiModelProperty(value = " 来源" ,name = "source" )
	private Integer				source;

	/**
	 * @Fields source_id 来源id
	 */
	@XmlAttribute( name = "source_id" )
	@ApiModelProperty(value = "来源id" ,name = "source_id" )
	private String				sourceId;

	/**
	 * @Fields status 状态
	 */
	@XmlAttribute( name = "status" )
	@ApiModelProperty(value = "状态" ,name = "status" )
	private Integer				status;

	/**
	 * @Fields type 上传的文件类型
	 */
	@XmlAttribute( name = "type" )
	@ApiModelProperty(value = "上传的文件类型" ,name = "type" )
	private String				type;

	/**
	 * @Fields isPrimary 是否为主图
	 */
	@XmlAttribute( name = "is_primary" )
	@ApiModelProperty(value = "是否为主图" ,name = "is_primary" )
	private Boolean				isPrimary ;
	
	
	/** 
	* @Fields data 全景渲染图封面
	*/  
	@XmlAttribute( name = "cover" )
	@ApiModelProperty(value = "全景渲染图封面" ,name = "cover" )
	private String				cover;

	/**
	 * @Fields description 页面展示描述
	 */
	@XmlAttribute( name = "description" )
	@ApiModelProperty(value = "页面展示描述" ,name = "description" )
	private String description;

	@XmlAttribute( name = "isSelected" )
	@ApiModelProperty(value = "是否选中" ,name = "isSelected" )
	private Boolean isSelected;
	
	@XmlAttribute( name = "model_seekids" )
	@ApiModelProperty(value = "推荐商品的id集合" ,name = "model_seekids" )
	private List<String> modelSeekids;


	/**
	 * <p>
	 * method name DesignFile.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 */
	public DesignFileReq()
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
	 * @param type
	 * @param link
	 * @param status
	 * @param name
	 * @param source
	 * @param extendedData
	 */
	public DesignFileReq( String id, EnumDesignFileType type, String link, Integer status, String name, Integer source, String extendedData )
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
	 * @param link
	 * @param isPrimary
	 * @param name
	 */
	public DesignFileReq( String id,String link, Boolean isPrimary, String name )
	{
		super();
		this.id = id;
		this.link = link;
		this.isPrimary = isPrimary;
		this.name = name;
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
	public DesignFileReq( String id, EnumDesignFileType type, String link, Integer status, String name, Integer source, String extendedData, String sourceId )
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
	 * @param sourceId
	 */
	public DesignFileReq( String id, EnumDesignFileType type, String link, Integer status, String name, Integer source, String extendedData, String sourceId,Boolean isPrimary )
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
		this.isPrimary = isPrimary;
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

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getCover()
	{
		return cover;
	}

	public void setCover( String cover )
	{
		this.cover = cover;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean selected) {
		isSelected = selected;
	}

	public Boolean getPrimary() {
		return isPrimary;
	}

	public void setPrimary(Boolean primary) {
		isPrimary = primary;
	}

	public List<String> getModelSeekids() {
		return modelSeekids;
	}

	public void setModelSeekids(List<String> modelSeekids) {
		this.modelSeekids = modelSeekids;
	}
	
}
