package com.juran.examplemovie.client.bean.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/**
 * 文件 {@link D2CaseCreationReq}
 * 
 * @author songsen.zhang
 * @version 2016年5月8日 2016年5月8日 上午11:26:33 songsen.zhang 创建
 */
@XmlRootElement
public class ThumbnailsFileRsp implements Serializable
{

	private static final long	serialVersionUID	= -9114962083240698067L;

	/**
	 * @Fields fileId 文件标识
	 */
	@XmlAttribute( name = "file_id" )
	@ApiModelProperty(value = "文件标识" ,name = "file_id" )
	private String				fileId;

	/**
	 * @Fields fileName 图片名称
	 */
	@XmlAttribute( name = "file_name" )
	@ApiModelProperty(value = "图片名称" ,name = "file_name" )
	private String				fileName;

	/**
	 * @Fields fileUrl 图片URL
	 */
	@XmlAttribute( name = "file_url" )
	@ApiModelProperty(value = "图片URL" ,name = "file_url" )
	private String				fileUrl;

	/**
	 * @Fields isPrimary 是否为主图
	 */
	@XmlAttribute( name = "is_primary" )
	@ApiModelProperty(value = "是否为主图" ,name = "is_primary" )
	private Boolean				isPrimary ;

	@XmlAttribute( name = "description" )
	@ApiModelProperty(value = "描述图片所属的空间" ,name = "description" )
	private String description;

	public ThumbnailsFileRsp()
	{
		super();
	}

	public ThumbnailsFileRsp( String fileId, String fileName, String fileUrl, Boolean isPrimary )
	{
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.isPrimary = isPrimary;
	}

	public String getFileId()
	{
		return fileId;
	}

	public String getFileName()
	{
		return fileName;
	}

	public String getFileUrl()
	{
		return fileUrl;
	}

	public Boolean getIsPrimary()
	{
		return isPrimary;
	}

	public void setFileId( String fileId )
	{
		this.fileId = fileId;
	}

	public void setFileName( String fileName )
	{
		this.fileName = fileName;
	}

	public void setFileUrl( String fileUrl )
	{
		this.fileUrl = fileUrl;
	}

	public void setIsPrimary( Boolean isPrimary )
	{
		this.isPrimary = isPrimary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
