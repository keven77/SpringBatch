package com.juran.examplemovie.client.bean.domain;


import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.juran.examplemovie.client.bean.enums.EnumD2Cases;
import com.juran.examplemovie.client.util.NumberUtility;

import io.swagger.annotations.ApiModelProperty;


/**
 * 2D案例查询response
 * 
 * @author songsen.zhang
 * @version 2016年5月11日 2016年5月11日 上午10:53:42 songsen.zhang 简要描述修改内容，修改原因
 */
@XmlRootElement
public class D2CaseRetrieveRsp implements Serializable
{

	private static final long			serialVersionUID	= 7439138055691840874L;

	@XmlAttribute( name = "audit_desc" )
	@ApiModelProperty( value = "审核描述", name = "audit_desc" )
	private String						auditDesc;

	/**
	 * 厅
	 */
	@XmlAttribute( name = "bedroom" )
	@ApiModelProperty( value = "厅", name = "bedroom" )
	private String						bedroom;

	/**
	 * 案例的颜色（下拉框，白色、米色、黄色、橙色、红色、绿色、蓝色、紫色、粉色、咖啡色、灰色、黑色、彩色、其他）
	 */
	@XmlAttribute( name = "case_color" )
	@ApiModelProperty( value = "案例的颜色", name = "case_color" )
	private String						caseColor;

	/**
	 * 方案类型：01：效果图方案、02：DIY样板间
	 */
	@XmlAttribute( name = "case_type" )
	@ApiModelProperty( value = "方案类型", name = "case_type" )
	private String						caseType;

	/**
	 * 市
	 */
	@XmlAttribute( name = "city" )
	@ApiModelProperty( value = "市", name = "city" )
	private String						city;

	/** 项目地址（市） */
	@XmlAttribute( name = "city_name" )
	@ApiModelProperty( value = "市名称", name = "city_name" )
	private String						cityName;

	/**
	 * 浏览量
	 */
	@XmlAttribute( name = "click_number" )
	@ApiModelProperty( value = "浏览量", name = "click_number" )
	private Long						clickNumber;

	/**
	 * 小区名称
	 */
	@XmlAttribute( name = "community_name" )
	@ApiModelProperty( value = "小区名称", name = "community_name" )
	private String						communityName;

	@XmlAttribute( name = "create_date" )
	@ApiModelProperty( value = "创建时间", name = "create_date" )
	private String						createDate;

	/**
	 * 状态、0：待审核、1：审核通过、2：审核未通过、3：草稿
	 */
	@XmlAttribute( name = "custom_string_status" )
	@ApiModelProperty( value = "审核状态", name = "custom_string_status" )
	private Integer						customStringStatus;

	/**
	 * 装修类型：家装、公装
	 */
	@XmlAttribute( name = "decoration_type" )
	@ApiModelProperty( value = "装修类型", name = "decoration_type" )
	private String						decorationType;

	/**
	 * 方案描述
	 */
	@XmlAttribute( name = "description" )
	@ApiModelProperty( value = "案例描述", name = "description" )
	private String						description;

	/**
	 * 创建者编号
	 */
	@XmlAttribute( name = "designer_id" )
	@ApiModelProperty( value = "设计师ID", name = "designer_id" )
	private Long						designerId;

	/**
	 * 区
	 */
	@XmlAttribute( name = "district" )
	@ApiModelProperty( value = "区", name = "district" )
	private String						district;

	/** 项目地址（区） */
	@XmlAttribute( name = "district_name" )
	@ApiModelProperty( value = "区名称", name = "district_name" )
	private String						districtName;

	/**
	 * 收藏数
	 */
	@XmlAttribute( name = "favorite_count" )
	@ApiModelProperty( value = "收藏数", name = "favorite_count" )
	private Long						favoriteCount;

	/**
	 * 房屋类型
	 */
	@XmlAttribute( name = "house_type" )
	@ApiModelProperty( value = "房屋类型", name = "house_type" )
	private String						houseType;

	@XmlAttribute( name = "hs_designer_uid" )
	@ApiModelProperty( value = "设计师UID", name = "hs_designer_uid" )
	private String						hsDesignerUid;

	/**
	 * 效果图方案/DIY样板间ID，效果图方案ID=ID，DIY样板间由3D推过来
	 */
	@XmlAttribute( name = "id" )
	@ApiModelProperty( value = "ID", name = "id" )
	private String						id;

	/**
	 * 图片集
	 */
	@XmlAttribute( name = "images" )
	@ApiModelProperty( value = "图片集", name = "images" )
	private List<ThumbnailsFileRsp>		images;

	/**
	 * 是否被推荐，N：不是 Y：是
	 */
	@XmlAttribute( name = "is_recommended" )
	@ApiModelProperty( value = "是否被推荐", name = "is_recommended" )
	private String						isRecommended;

	/**
	 * 基础装修报价
	 */
	@XmlAttribute( name = "prj_base_price" )
	@ApiModelProperty( value = "基础装修报价", name = "prj_base_price" )
	private Double						prjBasePrice;

	/**
	 * 家居家饰报价
	 */
	@XmlAttribute( name = "prj_furniture_price" )
	@ApiModelProperty( value = "家居家饰报价", name = "prj_furniture_price" )
	private Double						prjFurniturePrice;

	/**
	 * 隐蔽工程报价
	 */
	@XmlAttribute( name = "prj_hidden_price" )
	@ApiModelProperty( value = "隐蔽工程报价", name = "prj_hidden_price" )
	private Double						prjHiddenPrice;

	/**
	 * 主材报价
	 */
	@XmlAttribute( name = "prj_material_price" )
	@ApiModelProperty( value = "主材报价", name = "prj_material_price" )
	private Double						prjMaterialPrice;

	/**
	 * 家居饰品报价
	 */
	@XmlAttribute( name = "prj_other_price" )
	@ApiModelProperty( value = "家居饰品报价", name = "prj_other_price" )
	private Double						prjOtherPrice;

	/**
	 * 项目报价
	 */
	@XmlAttribute( name = "prj_price" )
	@ApiModelProperty( value = "项目报价", name = "prj_price" )
	private Double						prjPrice;

	/**
	 * 风格（下拉框，现代 田园 混搭 简约 地中海 中式 日式 韩式 新古典 欧式 美式 港式 北欧 其他）
	 */
	@XmlAttribute( name = "project_style" )
	@ApiModelProperty( value = "风格", name = "project_style" )
	private String						projectStyle;

	/**
	 * 总报价
	 */
	@XmlAttribute( name = "protocol_price" )
	@ApiModelProperty( value = "总报价", name = "protocol_price" )
	private Double						protocolPrice;

	/**
	 * 省（直辖）市
	 */
	@XmlAttribute( name = "province" )
	@ApiModelProperty( value = "省", name = "province" )
	private String						province;

	/** 项目地址（省） */
	@XmlAttribute( name = "province_name" )
	@ApiModelProperty( value = "省名称", name = "province_name" )
	private String						provinceName;

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
	private String						roomArea;

	/**
	 * 户型：室
	 */
	@XmlAttribute( name = "room_type" )
	@ApiModelProperty( value = "户型", name = "room_type" )
	private String						roomType;

	/**
	 * 标签
	 */
	@XmlAttribute( name = "search_tag" )
	@ApiModelProperty( value = "标签", name = "search_tag" )
	private String						searchTag;

	/**
	 * 方案名称
	 */
	@XmlAttribute( name = "title" )
	@ApiModelProperty( value = "方案名称", name = "title" )
	private String						title;

	/**
	 * 排序
	 */
	@XmlAttribute( name = "weight" )
	@ApiModelProperty( value = "排序", name = "weight" )
	private Long						weight;

	/**
	 * 排序类型， 置顶区（10），优先区（20），默认区（30）
	 */
	@XmlAttribute( name = "sort_type" )
	@ApiModelProperty( value = "排序类型", name = "sort_type" )
	private String						sortType;

	/**
	 * 置顶区排序（10-000000000x），优先排序区（20-0000000000），默认排序区（30-0000000000）
	 */
	@XmlAttribute( name = "sort" )
	@ApiModelProperty( value = "排序", name = "sort" )
	private String						sort;

	/**
	 * 排序类型， 置顶区（10），优先区（20），默认区（30） 用于acs里的条件查询
	 */
	@XmlAttribute( name = "custom_string_sort_type" )
	@ApiModelProperty( value = "排序类型", name = "custom_string_sort_type" )
	private String						customStringSortType;

	/**
	 * 2D案例名称
	 */
	@XmlAttribute( name = "custom_string_name" )
	@ApiModelProperty( value = "2D案例名称", name = "custom_string_name" )
	private String						customStringName;

	/**
	 * 渠道信息
	 */
	@XmlAttribute( name = "channel" )
	@ApiModelProperty( value = "渠道(web,app,h5)", name = "channel" )
	private String channel;

	/**
	 * 大赛信息
	 */
	@XmlAttribute( name = "contest" )
	@ApiModelProperty( value = "大赛(元洲杯,百万基金)", name = "contest" )
	private String contest;

	/**
	 * 门店信息
	 */
	@XmlAttribute( name = "store" )
	@ApiModelProperty( value = "门店编码", name = "store" )
	private String store;

	@XmlAttribute(name = "roomImages")
	@ApiModelProperty(value = "图片信息", name = "roomImages")
	private List<RspD2Case> roomImages;

	@XmlAttribute( name = "specialTag" )
	@ApiModelProperty( value = "特色标签", name = "specialTag" )
	private String specialTag;
	
	/*************元洲设计大赛维护设计师信息 start**************/
	@XmlAttribute( name = "activity_real_name" )
	@ApiModelProperty( value = "活动设计师真实姓名", name = "activity_real_name" )
	private String activityRealName;
	
	@XmlAttribute( name = "activity_province" )
	@ApiModelProperty( value = "活动设计师 省", name = "activity_province" )
	private String						activityProvince;

	@XmlAttribute( name = "activity_province_name" )
	@ApiModelProperty( value = "活动设计师 省名称", name = "activity_province_name" )
	private String						activityProvinceName;
	
	@XmlAttribute( name = "activity_city" )
	@ApiModelProperty( value = "活动设计师 市", name = "activity_city" )
	private String						activityCity;

	@XmlAttribute( name = "activity_city_name" )
	@ApiModelProperty( value = "活动设计师 市名称", name = "activity_city_name" )
	private String						activityCityName;
	
	@XmlAttribute( name = "activity_district" )
	@ApiModelProperty( value = "活动设计师 区", name = "activity_district" )
	private String						activityDistrict;

	@XmlAttribute( name = "activity_district_name" )
	@ApiModelProperty( value = "活动设计师 区名称", name = "activity_district_name" )
	private String						activityDistrictName;
	
	@XmlAttribute( name = "activity_experience" )
	@ApiModelProperty( value = "活动设计师 从业年限", name = "activity_experience" )
	private String						activityExperience;
	
	@XmlAttribute( name = "activity_graduate_from" )
	@ApiModelProperty( value = "活动设计师 毕业院校", name = "activity_graduate_from" )
	private String						activityGraduateFrom;
	
	@XmlAttribute( name = "activity_personal_honour" )
	@ApiModelProperty( value = "活动设计师 个人荣誉", name = "activity_personal_honour" )
	private String						activityPersonalHonour;
	
	@XmlAttribute( name = "activity_motto" )
	@ApiModelProperty( value = "活动设计师 座右铭", name = "activity_motto" )
	private String						activityMotto;
	
	@XmlAttribute( name = "activity_avatar" )
	@ApiModelProperty( value = "活动设计师 头像", name = "activity_avatar" )
	private String						activityAvatar;
	
	@XmlAttribute( name = "activity_tag" )
	@ApiModelProperty( value = "活动设计师 参选主题竞赛单元 (别墅:0,小户型:1,适老设计:2,空间布局:3,陈设配饰:4,风格表达:5)", name = "activity_tag" )
	private String						activityTag;
	
	@XmlAttribute( name = "activity_brand" )
	@ApiModelProperty( value = "活动品牌", name = "activity_brand" )
	private String						activityBrand;
	
	@XmlAttribute( name = "activity_commencement_date" )
	@ApiModelProperty( value = "活动 工程开工日期", name = "activity_commencement_date" )
	private String						activityCommencementDate;
	
	@XmlAttribute( name = "activity_desc_demand" )
	@ApiModelProperty( value = "活动 业主需求", name = "activity_desc_demand" )
	private String						activityDescDemand;
	
	@XmlAttribute( name = "activity_design_specification" )
	@ApiModelProperty( value = "活动 设计说明", name = "activity_design_specification" )
	private String						activityDesignSpecification;
	
	@XmlAttribute( name = "is_new" )
	@ApiModelProperty( value = "是否是新方案(新方案:1,旧方案:0)", name = "is_new" )
	private String						isNew;
	/*************元洲设计大赛维护设计师信息 end**************/

	public List<RspD2Case> getRoomImages() {
		return roomImages;
	}

	public void setRoomImages(List<RspD2Case> roomImages) {
		this.roomImages = roomImages;
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

	public D2CaseRetrieveRsp()
	{
		super();
	}

	public D2CaseRetrieveRsp( final String id, final EnumD2Cases customStringStatus )
	{
		super();
		this.id = id;
		this.customStringStatus = customStringStatus.getValue();
	}

	public D2CaseRetrieveRsp( List<ThumbnailsFileRsp> images )
	{
		super();
		this.images = images;
	}


	public String getSpecialTag() {
		return specialTag;
	}

	public void setSpecialTag(String specialTag) {
		this.specialTag = specialTag;
	}

	public String getAuditDesc()
	{
		return auditDesc;
	}

	public String getBedroom()
	{
		return bedroom;
	}

	public String getCaseColor()
	{
		return caseColor;
	}

	public String getCaseType()
	{
		return caseType;
	}

	public String getCity()
	{
		return city;
	}

	public String getCityName()
	{
		return cityName;
	}

	public Long getClickNumber()
	{
		return clickNumber;
	}

	public String getCommunityName()
	{
		return communityName;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public Integer getCustomStringStatus()
	{
		return customStringStatus;
	}

	public String getDecorationType()
	{
		return decorationType;
	}

	public String getDescription()
	{
		return description;
	}

	public Long getDesignerId()
	{
		return designerId;
	}

	public String getDistrict()
	{
		return district;
	}

	public String getDistrictName()
	{
		return districtName;
	}

	public Long getFavoriteCount()
	{
		return favoriteCount;
	}

	public String getHouseType()
	{
		return houseType;
	}

	public String getHsDesignerUid()
	{
		return hsDesignerUid;
	}

	public String getId()
	{
		return id;
	}

	public List<ThumbnailsFileRsp> getImages()
	{
		return images;
	}

	public String getIsRecommended()
	{
		return isRecommended;
	}

	public Double getPrjBasePrice()
	{
		return prjBasePrice;
	}

	public Double getPrjFurniturePrice()
	{
		return prjFurniturePrice;
	}

	public Double getPrjHiddenPrice()
	{
		return prjHiddenPrice;
	}

	public Double getPrjMaterialPrice()
	{
		return prjMaterialPrice;
	}

	public Double getPrjOtherPrice()
	{
		return prjOtherPrice;
	}

	public Double getPrjPrice()
	{
		return NumberUtility.divide(prjPrice);
	}

	public String getProjectStyle()
	{
		return projectStyle;
	}

	public Double getProtocolPrice()
	{
		return NumberUtility.divide(protocolPrice);
	}

	public String getProvince()
	{
		return province;
	}

	public String getProvinceName()
	{
		return provinceName;
	}

	public String getRestroom()
	{
		return restroom;
	}

	public String getRoomArea()
	{
		return roomArea;
	}

	public String getRoomType()
	{
		return roomType;
	}

	public String getSearchTag()
	{
		return searchTag;
	}

	public String getTitle()
	{
		return title;
	}

	public Long getWeight()
	{
		return weight;
	}

	public void setAuditDesc( String auditDesc )
	{
		this.auditDesc = auditDesc;
	}

	public void setBedroom( String bedroom )
	{
		this.bedroom = bedroom;
	}

	public void setCaseColor( String caseColor )
	{
		this.caseColor = caseColor;
	}

	public void setCaseType( String caseType )
	{
		this.caseType = caseType;
	}

	public void setCity( String city )
	{
		this.city = city;
	}

	public void setCityName( String cityName )
	{
		this.cityName = cityName;
	}

	public void setClickNumber( Long clickNumber )
	{
		this.clickNumber = clickNumber;
	}

	public void setCommunityName( String communityName )
	{
		this.communityName = communityName;
	}

	public void setCreateDate( String createDate )
	{
		this.createDate = createDate;
	}

	public void setCustomStringStatus( Integer customStringStatus )
	{
		this.customStringStatus = customStringStatus;
	}

	public void setDecorationType( String decorationType )
	{
		this.decorationType = decorationType;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}

	public void setDesignerId( Long designerId )
	{
		this.designerId = designerId;
	}

	public void setDistrict( String district )
	{
		this.district = district;
	}

	public void setDistrictName( String districtName )
	{
		this.districtName = districtName;
	}

	public void setFavoriteCount( Long favoriteCount )
	{
		this.favoriteCount = favoriteCount;
	}

	public void setHouseType( String houseType )
	{
		this.houseType = houseType;
	}

	public void setHsDesignerUid( String hsDesignerUid )
	{
		this.hsDesignerUid = hsDesignerUid;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	public void setImages( List<ThumbnailsFileRsp> images )
	{
		this.images = images;
	}

	public void setIsRecommended( String isRecommended )
	{
		this.isRecommended = isRecommended;
	}

	public void setPrjBasePrice( Double prjBasePrice )
	{
		this.prjBasePrice = prjBasePrice;
	}

	public void setPrjFurniturePrice( Double prjFurniturePrice )
	{
		this.prjFurniturePrice = prjFurniturePrice;
	}

	public void setPrjHiddenPrice( Double prjHiddenPrice )
	{
		this.prjHiddenPrice = prjHiddenPrice;
	}

	public void setPrjMaterialPrice( Double prjMaterialPrice )
	{
		this.prjMaterialPrice = prjMaterialPrice;
	}

	public void setPrjOtherPrice( Double prjOtherPrice )
	{
		this.prjOtherPrice = prjOtherPrice;
	}

	public void setPrjPrice( Double prjPrice )
	{
		this.prjPrice = prjPrice;
	}

	public void setProjectStyle( String projectStyle )
	{
		this.projectStyle = projectStyle;
	}

	public void setProtocolPrice( Double protocolPrice )
	{
		this.protocolPrice = protocolPrice;
	}

	public void setProvince( String province )
	{
		this.province = province;
	}

	public void setProvinceName( String provinceName )
	{
		this.provinceName = provinceName;
	}

	public void setRestroom( String restroom )
	{
		this.restroom = restroom;
	}

	public void setRoomArea( String roomArea )
	{
		this.roomArea = roomArea;
	}

	public void setRoomType( String roomType )
	{
		this.roomType = roomType;
	}

	public void setSearchTag( String searchTag )
	{
		this.searchTag = searchTag;
	}

	public void setTitle( String title )
	{
		this.title = title;
	}

	public void setWeight( Long weight )
	{
		this.weight = weight;
	}

	public String getSortType()
	{
		return sortType;
	}

	public void setSortType( String sortType )
	{
		this.sortType = sortType;
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

	public String getCustomStringName()
	{
		return customStringName;
	}

	public void setCustomStringName( String customStringName )
	{
		this.customStringName = customStringName;
	}

	public String getActivityRealName() {
		return activityRealName;
	}

	public void setActivityRealName(String activityRealName) {
		this.activityRealName = activityRealName;
	}

	public String getActivityProvince() {
		return activityProvince;
	}

	public void setActivityProvince(String activityProvince) {
		this.activityProvince = activityProvince;
	}

	public String getActivityProvinceName() {
		return activityProvinceName;
	}

	public void setActivityProvinceName(String activityProvinceName) {
		this.activityProvinceName = activityProvinceName;
	}

	public String getActivityCity() {
		return activityCity;
	}

	public void setActivityCity(String activityCity) {
		this.activityCity = activityCity;
	}

	public String getActivityCityName() {
		return activityCityName;
	}

	public void setActivityCityName(String activityCityName) {
		this.activityCityName = activityCityName;
	}

	public String getActivityDistrict() {
		return activityDistrict;
	}

	public void setActivityDistrict(String activityDistrict) {
		this.activityDistrict = activityDistrict;
	}

	public String getActivityDistrictName() {
		return activityDistrictName;
	}

	public void setActivityDistrictName(String activityDistrictName) {
		this.activityDistrictName = activityDistrictName;
	}

	public String getActivityExperience() {
		return activityExperience;
	}

	public void setActivityExperience(String activityExperience) {
		this.activityExperience = activityExperience;
	}

	public String getActivityGraduateFrom() {
		return activityGraduateFrom;
	}

	public void setActivityGraduateFrom(String activityGraduateFrom) {
		this.activityGraduateFrom = activityGraduateFrom;
	}

	public String getActivityMotto() {
		return activityMotto;
	}

	public void setActivityMotto(String activityMotto) {
		this.activityMotto = activityMotto;
	}

	public String getActivityAvatar() {
		return activityAvatar;
	}

	public void setActivityAvatar(String activityAvatar) {
		this.activityAvatar = activityAvatar;
	}

	public String getActivityTag() {
		return activityTag;
	}

	public void setActivityTag(String activityTag) {
		this.activityTag = activityTag;
	}

	public String getActivityPersonalHonour() {
		return activityPersonalHonour;
	}

	public void setActivityPersonalHonour(String activityPersonalHonour) {
		this.activityPersonalHonour = activityPersonalHonour;
	}

	public String getActivityBrand() {
		return activityBrand;
	}

	public void setActivityBrand(String activityBrand) {
		this.activityBrand = activityBrand;
	}

	public String getActivityCommencementDate() {
		return activityCommencementDate;
	}

	public void setActivityCommencementDate(String activityCommencementDate) {
		this.activityCommencementDate = activityCommencementDate;
	}

	public String getActivityDescDemand() {
		return activityDescDemand;
	}

	public void setActivityDescDemand(String activityDescDemand) {
		this.activityDescDemand = activityDescDemand;
	}

	public String getActivityDesignSpecification() {
		return activityDesignSpecification;
	}

	public void setActivityDesignSpecification(String activityDesignSpecification) {
		this.activityDesignSpecification = activityDesignSpecification;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public D2CaseRetrieveRsp( String auditDesc, String bedroom, String caseColor, String caseType, String city, String cityName, Long clickNumber, String communityName,
			String createDate, Integer customStringStatus, String decorationType, String description, String designer, Long designerId, String district,
			String districtName, Long favoriteCount, String houseType, String hsDesignerUid, String id, String isRecommended, Double prjBasePrice, Double prjFurniturePrice,
			Double prjHiddenPrice, Double prjMaterialPrice, Double prjOtherPrice, Double prjPrice, String projectStyle, Double protocolPrice, String province, String provinceName,
			String restroom, String roomArea, String roomType, String searchTag, String title, Long weight, List<ThumbnailsFileRsp> images, String sort, String sortType,
			String customStringSortType, String customStringName )
	{
		super();
		this.auditDesc = auditDesc;
		this.bedroom = bedroom;
		this.caseColor = caseColor;
		this.caseType = caseType;
		this.city = city;
		this.cityName = cityName;
		this.clickNumber = clickNumber;
		this.communityName = communityName;
		this.createDate = createDate;
		this.customStringStatus = customStringStatus;
		this.decorationType = decorationType;
		this.description = description;
		this.designerId = designerId;
		this.district = district;
		this.districtName = districtName;
		this.favoriteCount = favoriteCount;
		this.houseType = houseType;
		this.hsDesignerUid = hsDesignerUid;
		this.id = id;
		this.isRecommended = isRecommended;
		this.prjBasePrice = prjBasePrice;
		this.prjFurniturePrice = prjFurniturePrice;
		this.prjHiddenPrice = prjHiddenPrice;
		this.prjMaterialPrice = prjMaterialPrice;
		this.prjOtherPrice = prjOtherPrice;
		this.prjPrice = prjPrice;
		this.projectStyle = projectStyle;
		this.protocolPrice = protocolPrice;
		this.province = province;
		this.provinceName = provinceName;
		this.restroom = restroom;
		this.roomArea = roomArea;
		this.roomType = roomType;
		this.searchTag = searchTag;
		this.title = title;
		this.weight = weight;
		this.images = images;
		this.sort = sort;
		this.sortType = sortType;
		this.customStringSortType = customStringSortType;
		this.customStringName = customStringName;
	}

}
