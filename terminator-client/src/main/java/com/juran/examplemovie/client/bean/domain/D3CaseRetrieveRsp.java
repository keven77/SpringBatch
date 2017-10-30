package com.juran.examplemovie.client.bean.domain;


import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModelProperty;


/**
 * 3D案例查询response
 * 
 * @author xiaolan.hou D3CaseRetrieveRsp
 * @version 2016年8月15日 下午3:21:22
 */
@XmlRootElement
public class D3CaseRetrieveRsp implements Serializable
{

	private static final long			serialVersionUID	= 7439138055691840874L;

	/**
	 * design_asset_id
	 */
	@XmlAttribute( name = "design_asset_id" )
	@ApiModelProperty( value = "案例id", name = "design_asset_id" )
	private Long						designAssetId;

	/**
	 * 厅
	 */
	@XmlAttribute( name = "bedroom" )
	@ApiModelProperty( value = "厅", name = "bedroom" )
	private String						bedroom;

	/**
	 * 市
	 */
	@XmlAttribute( name = "city" )
	@ApiModelProperty( value = "市", name = "city" )
	private String						city;

	@XmlAttribute( name = "cityName" )
	@ApiModelProperty( value = "市", name = "cityName" )
	private String cityName;

	/**
	 * 小区名称
	 */
	@XmlAttribute( name = "community_name" )
	@ApiModelProperty( value = "小区名称", name = "community_name" )
	private String						communityName;

	/**
	 * 设计理念
	 */
	@XmlAttribute( name = "conception" )
	@ApiModelProperty( value = "设计理念", name = "conception" )
	private String						conception;

	/**
	 * 面积
	 */
	@XmlAttribute( name = "custom_string_area" )
	@ApiModelProperty( value = "面积", name = "custom_string_area" )
	private String						customStringArea;

	/**
	 * 厅
	 */
	@XmlAttribute( name = "custom_string_bedroom" )
	@ApiModelProperty( value = "厅", name = "custom_string_bedroom" )
	private String						customStringBedroom;

	/**
	 * 类型
	 */
	@XmlAttribute( name = "custom_string_form" )
	@ApiModelProperty( value = "类型", name = "custom_string_form" )
	private String						customStringForm;

	/**
	 * 案例名称
	 */
	@XmlAttribute( name = "custom_string_name" )
	@ApiModelProperty( value = "案例名称", name = "custom_string_name" )
	private String						customStringName;

	/**
	 * 卫
	 */
	@XmlAttribute( name = "custom_string_restroom" )
	@ApiModelProperty( value = "卫", name = "custom_string_restroom" )
	private String						customStringRestroom;

	/**
	 * 风格
	 */
	@XmlAttribute( name = "custom_string_style" )
	@ApiModelProperty( value = "风格", name = "custom_string_style" )
	private String						customStringStyle;

	/**
	 * 户型
	 */
	@XmlAttribute( name = "custom_string_type" )
	@ApiModelProperty( value = "户型", name = "custom_string_type" )
	private String						customStringType;

	/** 3D方案文件 */
	@XmlAttribute( name = "design_file" )
	@ApiModelProperty( value = " 3D方案文件", name = "design_file" )
	private List<DesignFileReq>			designFile;

	/**
	 * 方案名称
	 */
	@XmlAttribute( name = "design_name" )
	@ApiModelProperty( value = " 方案名称", name = "design_name" )
	private String						designName;

	/**
	 * 区
	 */
	@XmlAttribute( name = "district" )
	@ApiModelProperty( value = "区", name = "district" )
	private String						district;

	@XmlAttribute( name = "districtName" )
	@ApiModelProperty( value = "区", name = "districtName" )
	private String districtName;

	/**
	 * homestyle设计师id<br>
	 */
	@XmlAttribute( name = "hs_designer_uid" )
	@ApiModelProperty( value = "设计师uid", name = "hs_designer_uid" )
	private String						hsDesignerUid;

	/**
	 * 创建者编号
	 */
	@XmlAttribute( name = "designer_id" )
	@ApiModelProperty( value = "创建者id", name = "designer_id" )
	private Long						designerId;

	/**
	 * 方案ID<br>
	 */
	@XmlAttribute( name = "hs_design_id" )
	@ApiModelProperty( value = "方案ID", name = "hs_design_id" )
	private String						hsDesignId;

	/**
	 * 风格（下拉框，现代 田园 混搭 简约 地中海 中式 日式 韩式 新古典 欧式 美式 港式 北欧 其他）
	 */
	@XmlAttribute( name = "project_style" )
	@ApiModelProperty( value = "风格", name = "project_style" )
	private String						projectStyle;

	/**
	 * 空间（下拉框，客厅 卧室 厨房 餐厅 卫生间 阳台 玄关 书房 衣帽间 儿童房 楼梯 其他）,DIY样板间用
	 */
	@XmlAttribute( name = "project_type" )
	@ApiModelProperty( value = "空间", name = "project_type" )
	private String						projectType;

	/**
	 * 省（直辖）市
	 */
	@XmlAttribute( name = "province" )
	@ApiModelProperty( value = "省（直辖）市", name = "province" )
	private String						province;

	@XmlAttribute( name = "provinceName" )
	@ApiModelProperty( value = "省（直辖）市", name = "provinceName" )
	private String provinceName;

	/**
	 * 公私标志
	 */
	@XmlAttribute( name = "publish_status" )
	@ApiModelProperty( value = "公私标志", name = "publish_status" )
	private Integer						publishStatus;

	/**
	 * 卫
	 */
	@XmlAttribute( name = "restroom" )
	@ApiModelProperty( value = "卫", name = "restroom" )
	private String						restroom;

	/**
	 * 面积
	 */
	@XmlAttribute( name = "room_area" )
	@ApiModelProperty( value = "面积", name = "room_area" )
	private Double						roomArea;

	/**
	 * 室
	 */
	@XmlAttribute( name = "room_type" )
	@ApiModelProperty( value = "室", name = "room_type" )
	private String						roomType;

	/**
	 * 收藏数
	 */
	@XmlAttribute( name = "favorite_count" )
	@ApiModelProperty( value = "点赞数", name = "favorite_count" )
	private Long						favoriteCount;

	/**
	 * 是否入库,N:未入库，Y:已入库 用于acs里的条件查询
	 */

	@XmlAttribute( name = "custom_string_is_storage" )
	@ApiModelProperty( value = "是否入库", name = "custom_string_is_storage" )
	private String						customStringIsStorage;

	/**
	 * 置顶区排序（10-000000000x），优先排序区（20-0000000000），默认排序区（30-0000000000）
	 */
	@XmlAttribute( name = "sort" )
	@ApiModelProperty( value = "排序区", name = "sort" )
	private String						sort;

	/**
	 * 排序类型， 置顶区（10），优先区（20），默认区（30） 用于acs里的条件查询
	 */
	@XmlAttribute( name = "custom_string_sort_type" )
	@ApiModelProperty( value = "排序类型", name = "custom_string_sort_type" )
	private String						customStringSortType;

	/**
	 * 公私标志 用于acs里的条件查询
	 */
	@XmlAttribute( name = "custom_string_publish_status" )
	@ApiModelProperty( value = "公私标志", name = "custom_string_publish_status" )
	private Integer						customStringPublishStatus;

	/**
	 * 关键字
	 */
	@XmlAttribute( name = "custom_string_keywords" )
	@ApiModelProperty( value = "关键字", name = "custom_string_keywords" )
	private String						customStringKeywords;

	/**
	 * 原始头像
	 */
	@XmlAttribute( name = "original_avatar" )
	@ApiModelProperty( value = "原始头像", name = "original_avatar" )
	private String						originalAvatar;

	/**
	 * 原始的设计师uid
	 */

	@XmlAttribute( name = "original_hs_designer_uid" )
	@ApiModelProperty( value = "原始的设计师uid", name = "original_hs_designer_uid" )
	private String						originalHsDesignerUid;

	@XmlAttribute( name = "original_asset_id" )
	@ApiModelProperty( value = "原始的案例id", name = "original_asset_id" )
	private Long						originalAssetId;

	/**
	 * 主图path
	 */
	@JSONField( name = "thumbnail_main_path" )
	@ApiModelProperty( value = "主图path", name = "thumbnail_main_path" )
	private String						thumbnailMainPath;

	/**
	 * 主图id
	 */
	@JSONField( name = "thumbnail_main_id" )
	@ApiModelProperty( value = "主图id", name = "thumbnail_main_id" )
	private Long						thumbnailMainId;

	@XmlAttribute( name = "date_submitted" )
	@ApiModelProperty( value = "入库时间", name = "date_submitted" )
	private String						dateSubmitted;

	@XmlAttribute( name = "dateModifyed" )
	@ApiModelProperty( value = "修改时间", name = "dateModifyed" )
	private String						dateModifyed;

	/**
	 * @Fields display 是否展示
	 */	
	@XmlAttribute( name = "display" )
	@ApiModelProperty( value = "是否显示", name = "display" )
	private Boolean						display;
	
	/**
	 * @Fields isSampleRoom 是否精装
	 */
	@XmlAttribute( name = "is_sample_room" )
	@ApiModelProperty( value = "是否精装", name = "is_sample_room" )
	private Boolean				isSampleRoom;

	/**
	 * @Fields renderingImages 渲染图片信息
	 */
	@XmlAttribute(name = "renderingImages")
	@ApiModelProperty(value = "图片信息", name = "renderingImages")
	private List<RspD3Case> renderingImages;

	/**
	 * 渠道信息
	 */
	@XmlAttribute(name = "channel")
	@ApiModelProperty(value = "channel", name = "channel")
	private String channel;

	/**
	 * 大赛信息
	 */
	@XmlAttribute(name = "contest")
	@ApiModelProperty(value = "contest", name = "contest")
	private String contest;

	/**
	 * 门店信息
	 */
	@XmlAttribute(name = "store")
	@ApiModelProperty(value = "store", name = "store")
	private String store;

	@XmlAttribute(name = "roomMold")
	@ApiModelProperty(value = "roomMold", name = "roomMold")
	private String roomMold;

	@XmlAttribute(name = "specialTag")
	@ApiModelProperty(value = "specialTag", name = "specialTag")
	private String specialTag;
	
	@XmlAttribute(name = "reference_demand")
	@ApiModelProperty(value = "与3D方案相关联的项目", name = "reference_demand")
	private BookingDemand referenceDemand;

	@XmlAttribute(name = "houseQuote")
	@ApiModelProperty(value = "房屋报价", name = "houseQuote")
	private String houseQuote;

	@XmlAttribute(name = "demandDescription")
	@ApiModelProperty(value = "需求描述", name = "demandDescription")
	private String demandDescription;
	
	@XmlAttribute(name = "is_new")
	@ApiModelProperty(value = "新方案的标识，(新方案:1，旧方案:0)", name = "is_new")
	private String isNew;
	
	@XmlAttribute(name = "navi_panos")
	@ApiModelProperty(value = "全屋漫游图列表", name = "navi_panos")
	private List<DesignFileReq> naviPanos;

	@XmlAttribute(name = "naviPanosDesc")
	@ApiModelProperty(value = "全屋漫游图描述", name = "naviPanosDesc")
	private String naviPanosDesc;
	
	@XmlAttribute(name = "selectImage")
	private String selectImage;

	public String getNaviPanosDesc() {
		return naviPanosDesc;
	}

	public void setNaviPanosDesc(String naviPanosDesc) {
		this.naviPanosDesc = naviPanosDesc;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getDemandDescription() {
		return demandDescription;
	}

	public void setDemandDescription(String demandDescription) {
		this.demandDescription = demandDescription;
	}

	public String getHouseQuote() {
		return houseQuote;
	}

	public void setHouseQuote(String houseQuote) {
		this.houseQuote = houseQuote;
	}

	public String getRoomMold() {
		return roomMold;
	}

	public void setRoomMold(String roomMold) {
		this.roomMold = roomMold;
	}

	public String getSpecialTag() {
		return specialTag;
	}

	public void setSpecialTag(String specialTag) {
		this.specialTag = specialTag;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getContest() {
		return contest;
	}

	public void setContest(String contest) {
		this.contest = contest;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public Boolean getDisplay()
	{
		return display;
	}

	public void setDisplay( Boolean display )
	{
		this.display = display;
	}

	public Long getOriginalAssetId()
	{
		return originalAssetId;
	}

	public void setOriginalAssetId( Long originalAssetId )
	{
		this.originalAssetId = originalAssetId;
	}

	public D3CaseRetrieveRsp()
	{
		super();
	}

	public D3CaseRetrieveRsp( Long designAssetId, String bedroom, String city, String communityName, String conception, String customStringArea, String customStringBedroom,
			String customStringForm, String customStringName, String customStringRestroom, String customStringStyle, String customStringType, List<DesignFileReq> designFile,
			String designName, String district, String hsDesignerUid, String hsDesignId, String projectStyle, String projectType, String province, Integer publishStatus,
			String restroom, Double roomArea, String roomType, Long favoriteCount, String designer, Long designerId, String customStringIsStorage, String sort,
			String customStringSortType, Integer customStringPublishStatus, String customStringKeywords, String originalAvatar, String originalHsDesignerUid, Long originalAssetId)
	{
		super();
		this.designAssetId = designAssetId;
		this.bedroom = bedroom;
		this.city = city;
		this.communityName = communityName;
		this.conception = conception;
		this.customStringArea = customStringArea;
		this.customStringBedroom = customStringBedroom;
		this.customStringForm = customStringForm;
		this.customStringName = customStringName;
		this.customStringRestroom = customStringRestroom;
		this.customStringStyle = customStringStyle;
		this.customStringType = customStringType;
		this.designFile = designFile;
		this.designName = designName;
		this.district = district;
		this.hsDesignerUid = hsDesignerUid;
		this.hsDesignId = hsDesignId;
		this.projectStyle = projectStyle;
		this.projectType = projectType;
		this.province = province;
		this.publishStatus = publishStatus;
		this.restroom = restroom;
		this.roomArea = roomArea;
		this.roomType = roomType;
		this.favoriteCount = favoriteCount;
		this.designerId = designerId;
		this.customStringIsStorage = customStringIsStorage;
		this.sort = sort;
		this.customStringSortType = customStringSortType;
		this.customStringPublishStatus = customStringPublishStatus;
		this.customStringKeywords = customStringKeywords;
		this.originalAvatar = originalAvatar;
		this.originalHsDesignerUid = originalHsDesignerUid;
		this.originalAssetId = originalAssetId;

	}

	public Long getDesignAssetId()
	{
		return designAssetId;
	}

	public void setDesignAssetId( Long designAssetId )
	{
		this.designAssetId = designAssetId;
	}

	public String getBedroom()
	{
		return bedroom;
	}

	public String getCity()
	{
		return city;
	}

	public String getCommunityName()
	{
		return communityName;
	}

	public String getConception()
	{
		return conception;
	}

	public String getCustomStringArea()
	{
		return customStringArea;
	}

	public String getCustomStringBedroom()
	{
		return customStringBedroom;
	}

	public String getCustomStringForm()
	{
		return customStringForm;
	}

	public String getCustomStringName()
	{
		return customStringName;
	}

	public String getCustomStringRestroom()
	{
		return customStringRestroom;
	}

	public String getCustomStringStyle()
	{
		return customStringStyle;
	}

	public String getCustomStringType()
	{
		return customStringType;
	}

	public List<DesignFileReq> getDesignFile()
	{
		return designFile;
	}

	public String getDesignName()
	{
		return designName;
	}

	public String getDistrict()
	{
		return district;
	}

	public String getHsDesignerUid()
	{
		return hsDesignerUid;
	}

	public String getHsDesignId()
	{
		return hsDesignId;
	}

	public String getProjectStyle()
	{
		return projectStyle;
	}

	public String getProjectType()
	{
		return projectType;
	}

	public String getProvince()
	{
		return province;
	}

	public Integer getPublishStatus()
	{
		return publishStatus;
	}

	public String getRestroom()
	{
		return restroom;
	}

	public Double getRoomArea()
	{
		return roomArea;
	}

	public String getRoomType()
	{
		return roomType;
	}

	public void setBedroom( String bedroom )
	{
		this.bedroom = bedroom;
	}

	public void setCity( String city )
	{
		this.city = city;
	}

	public void setCommunityName( String communityName )
	{
		this.communityName = communityName;
	}

	public void setConception( String conception )
	{
		this.conception = conception;
	}

	public void setCustomStringArea( String customStringArea )
	{
		this.customStringArea = customStringArea;
	}

	public void setCustomStringBedroom( String customStringBedroom )
	{
		this.customStringBedroom = customStringBedroom;
	}

	public void setCustomStringForm( String customStringForm )
	{
		this.customStringForm = customStringForm;
	}

	public void setCustomStringName( String customStringName )
	{
		this.customStringName = customStringName;
	}

	public void setCustomStringRestroom( String customStringRestroom )
	{
		this.customStringRestroom = customStringRestroom;
	}

	public void setCustomStringStyle( String customStringStyle )
	{
		this.customStringStyle = customStringStyle;
	}

	public void setCustomStringType( String customStringType )
	{
		this.customStringType = customStringType;
	}

	public void setDesignFile( List<DesignFileReq> designFile )
	{
		this.designFile = designFile;
	}

	public void setDesignName( String designName )
	{
		this.designName = designName;
	}

	public void setDistrict( String district )
	{
		this.district = district;
	}

	public void setHsDesignerUid( String hsDesignerUid )
	{
		this.hsDesignerUid = hsDesignerUid;
	}

	public void setHsDesignId( String hsDesignId )
	{
		this.hsDesignId = hsDesignId;
	}

	public void setProjectStyle( String projectStyle )
	{
		this.projectStyle = projectStyle;
	}

	public void setProjectType( String projectType )
	{
		this.projectType = projectType;
	}

	public void setProvince( String province )
	{
		this.province = province;
	}

	public void setPublishStatus( Integer publishStatus )
	{
		this.publishStatus = publishStatus;
	}

	public void setRestroom( String restroom )
	{
		this.restroom = restroom;
	}

	public void setRoomArea( Double roomArea )
	{
		this.roomArea = roomArea;
	}

	public void setRoomType( String roomType )
	{
		this.roomType = roomType;
	}

	public Long getFavoriteCount()
	{
		return favoriteCount;
	}

	public void setFavoriteCount( Long favoriteCount )
	{
		this.favoriteCount = favoriteCount;
	}

	public Long getDesignerId()
	{
		return designerId;
	}

	public void setDesignerId( Long designerId )
	{
		this.designerId = designerId;
	}

	public String getCustomStringIsStorage()
	{
		return customStringIsStorage;
	}

	public void setCustomStringIsStorage( String customStringIsStorage )
	{
		this.customStringIsStorage = customStringIsStorage;
	}

	public String getSort()
	{
		return sort;
	}

	public void setSort( String sort )
	{
		this.sort = sort;
	}

	public String getCustomStringSortType()
	{
		return customStringSortType;
	}

	public void setCustomStringSortType( String customStringSortType )
	{
		this.customStringSortType = customStringSortType;
	}

	public Integer getCustomStringPublishStatus()
	{
		return customStringPublishStatus;
	}

	public void setCustomStringPublishStatus( Integer customStringPublishStatus )
	{
		this.customStringPublishStatus = customStringPublishStatus;
	}

	public String getCustomStringKeywords()
	{
		return customStringKeywords;
	}

	public void setCustomStringKeywords( String customStringKeywords )
	{
		this.customStringKeywords = customStringKeywords;
	}

	public String getOriginalAvatar()
	{
		return originalAvatar;
	}

	public void setOriginalAvatar( String originalAvatar )
	{
		this.originalAvatar = originalAvatar;
	}

	public String getOriginalHsDesignerUid()
	{
		return originalHsDesignerUid;
	}

	public void setOriginalHsDesignerUid( String originalHsDesignerUid )
	{
		this.originalHsDesignerUid = originalHsDesignerUid;
	}

	public String getThumbnailMainPath()
	{
		return thumbnailMainPath;
	}

	public void setThumbnailMainPath( String thumbnailMainPath )
	{
		this.thumbnailMainPath = thumbnailMainPath;
	}

	public Long getThumbnailMainId()
	{
		return thumbnailMainId;
	}

	public void setThumbnailMainId( Long thumbnailMainId )
	{
		this.thumbnailMainId = thumbnailMainId;
	}

	public String getDateSubmitted()
	{
		return dateSubmitted;
	}

	public void setDateSubmitted( String dateSubmitted )
	{
		this.dateSubmitted = dateSubmitted;
	}

	public Boolean getIsSampleRoom() {
		return isSampleRoom;
	}

	public void setIsSampleRoom(Boolean isSampleRoom) {
		this.isSampleRoom = isSampleRoom;
	}

	public List<RspD3Case> getRenderingImages() {
		return renderingImages;
	}

	public void setRenderingImages(List<RspD3Case> renderingImages) {
		this.renderingImages = renderingImages;
	}

	public BookingDemand getReferenceDemand() {
		return referenceDemand;
	}

	public void setReferenceDemand(BookingDemand referenceDemand) {
		this.referenceDemand = referenceDemand;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public List<DesignFileReq> getNaviPanos() {
		return naviPanos;
	}

	public void setNaviPanos(List<DesignFileReq> naviPanos) {
		this.naviPanos = naviPanos;
	}

	public String getDateModifyed() {
		return dateModifyed;
	}

	public void setDateModifyed(String dateModifyed) {
		this.dateModifyed = dateModifyed;
	}

	public String getSelectImage() {
		return selectImage;
	}

	public void setSelectImage(String selectImage) {
		this.selectImage = selectImage;
	}
	
	
}
