package com.juran.examplemovie.client.bean.domain;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;


/**
 * 3D 数据
 * 
 * @author songsen.zhang
 * @version 2016年5月26日 2016年5月26日 下午8:40:25 songsen.zhang 简要描述修改内容，修改原因
 */
public class ThreeDimensionalCD implements Serializable
{

	private static final long	serialVersionUID	= -1661078317533312226L;

	/**
	 * design_asset_id
	 */
	@JSONField( name = "design_asset_id" )
	private Long				designAssetId;

	/**
	 * 创建者编号
	 */
	@JSONField( name = "designer_id" )
	private Long				designerId;

	/**
	 * 厅
	 */
	@JSONField( name = "bedroom" )
	private String				bedroom;

	/**
	 * 市
	 */
	@JSONField( name = "city" )
	private String				city;

	/**
	 * 小区名称
	 */
	@JSONField( name = "community_name" )
	private String				communityName;

	/**
	 * 设计理念
	 */
	@JSONField( name = "conception" )
	private String				conception;

	/**
	 * 面积
	 */
	@JSONField( name = "custom_string_area" )
	private String				customStringArea;

	/**
	 * 厅
	 */
	@JSONField( name = "custom_string_bedroom" )
	private String				customStringBedroom;

	/**
	 * 类型
	 */
	@JSONField( name = "custom_string_form" )
	private String				customStringForm;

	/**
	 * 案例名称
	 */
	@JSONField( name = "custom_string_name" )
	private String				customStringName;

	/**
	 * 卫
	 */
	@JSONField( name = "custom_string_restroom" )
	private String				customStringRestroom;

	/**
	 * 风格
	 */
	@JSONField( name = "custom_string_style" )
	private String				customStringStyle;

	/**
	 * 户型
	 */
	@JSONField( name = "custom_string_type" )
	private String				customStringType;

	/**
	 * @Fields customStringOwnerType 方案所属角色
	 */
	@JSONField( name = "custom_string_owner_type" )
	private String				customStringOwnerType;

	/**
	 * 文件
	 */
	@JSONField( name = "design_file" )
	private String				designFile;

	/**
	 * 方案名称
	 */
	@JSONField( name = "design_name" )
	private String				designName;

	/**
	 * 区
	 */
	@JSONField( name = "district" )
	private String				district;

	/**
	 * homestyle设计师id<br>
	 */
	@JSONField( name = "hs_designer_uid" )
	private String				hsDesignerUid;

	/**
	 * 方案ID<br>
	 */
	@JSONField( name = "hs_design_id" )
	private String				hsDesignId;

	/**
	 * 风格（下拉框，现代 田园 混搭 简约 地中海 中式 日式 韩式 新古典 欧式 美式 港式 北欧 其他）
	 */
	@JSONField( name = "project_style" )
	private String				projectStyle;

	/**
	 * 空间（下拉框，客厅 卧室 厨房 餐厅 卫生间 阳台 玄关 书房 衣帽间 儿童房 楼梯 其他）,DIY样板间用
	 */
	@JSONField( name = "project_type" )
	private String				projectType;

	/**
	 * 省（直辖）市
	 */
	@JSONField( name = "province" )
	private String				province;

	/**
	 * 公私标志
	 */
	@JSONField( name = "publish_status" )
	private Integer				publishStatus;

	/**
	 * 卫
	 */
	@JSONField( name = "restroom" )
	private String				restroom;

	/**
	 * 面积
	 */
	@JSONField( name = "room_area" )
	private Double				roomArea;

	/**
	 * 室
	 */
	@JSONField( name = "room_type" )
	private String				roomType;

	/**
	 * 是否入库,N:未入库，Y:已入库 用于acs里的条件查询
	 */

	@JSONField( name = "custom_string_is_storage" )
	private String				customStringIsStorage;

	/**
	 * 置顶区排序（10-000000000x），优先排序区（20-0000000000），默认排序区（30-0000000000）
	 */
	@JSONField( name = "sort" )
	private String				sort;

	/**
	 * 主图path
	 */
	@JSONField( name = "thumbnail_main_path" )
	private String				thumbnailMainPath;

	/**
	 * 主图id
	 */
	@JSONField( name = "thumbnail_main_id" )
	private Long				thumbnailMainId;

	/**
	 * @Fields isCustomThumbnailMain 是否是用户设置的主图 0:否 1:是
	 */
	@JSONField( name = "is_custom_thumbnail_main" )
	private Integer				isCustomThumbnailMain;

	/**
	 * 点赞数
	 */
	@JSONField( name = "favorite_count" )
	private Long				favoriteCount;

	/**
	 * 排序类型， 置顶区（10），优先区（20），默认区（30） 用于acs里的条件查询
	 */
	@JSONField( name = "custom_string_sort_type" )
	private String				customStringSortType;

	/**
	 * 关键字
	 */
	@JSONField( name = "custom_string_keywords" )
	private String				customStringKeywords;

	/**
	 * 公私标志 用于acs里的条件查询
	 */
	@JSONField( name = "custom_string_publish_status" )
	private Integer				customStringPublishStatus;

	/**
	 * 小区名称 用于ACS查询用
	 */
	@JSONField( name = "custom_string_community_name" )
	private String				customStringCommunityName;

	/**
	 * 原始头像
	 */
	@JSONField( name = "original_avatar" )
	private String				originalAvatar;

	/**
	 * 原始的设计师uid
	 */

	@JSONField( name = "original_hs_designer_uid" )
	private String				originalHsDesignerUid;

	/**
	 * 原始的设计师id
	 */

	@JSONField( name = "original_designer_id" )
	private String				originalDesignerId;

	@JSONField( name = "original_asset_id" )
	private Long				originalAssetId;

	/**
	 * 原始的设计师姓名
	 */

	@JSONField( name = "original_nick_name" )
	private String				originalNickName;

	/**
	 * @Fields hsTag 3D标签
	 */
	@JSONField( name = "hs_tag" )
	private String				hsTag;

	/**
	 * @Fields sourcePhoto2d 原始户型图路径
	 */
	@JSONField( name = "source_photo_2d" )
	private String				sourcePhoto2d;

	/**
	 * @Fields customStringHsSchemeSyn 用于判断是否从homestyler同步3D方案 (有HS同步来的方案：1;
	 *         没有HS同步来的方案：0)
	 */
	@JSONField( name = "custom_string_hs_scheme_syn" )
	private String				customStringHsSchemeSyn;

	/**
	 * asset 入库时间
	 */
	@JSONField( name = "date_submitted" )
	private String								dateSubmitted;

	/**
	 * 修改时间
	 */
	@JSONField( name = "dateModifyed" )
	private String						dateModifyed;
	
	/**
	 * @Fields display 是否展示
	 */
	@JSONField( name = "display" )
	private Boolean						display;

	/**
	 * @Fields isSampleRoom 是否精装
	 */
	@JSONField( name = "is_sample_room" )
	private Boolean				isSampleRoom;

	/**
	 * @Fields originalAssetVersion 入库时原Asset版本
	 */
	@JSONField( name = "original_asset_version" )
	private String				originalAssetVersion;

	/**
	 * 渠道信息
	 */
	@JSONField( name = "channel" )
	private String channel;

	/**
	 * 大赛信息
	 */
	@JSONField( name = "contest" )
	private String contest;

	/**
	 * 门店信息
	 */
	@JSONField( name = "store" )
	private String store;
	
	/**
	 * 房屋类型维度的描述信息
	 */
	@JSONField( name = "room_desc_list" )
	private String roomDescList;

	@JSONField(name = "roomMold")
	private String roomMold;

	@JSONField(name = "specialTag")
	private String specialTag;

	@JSONField(name = "mainImage")
	private String mainImage;

	@JSONField(name = "selectImage")
	private String selectImage;

	@JSONField(name = "houseQuote")
	private String houseQuote;

	@JSONField(name = "demandDescription")
	private String demandDescription;

	@JSONField(name = "provinceName")
	private String provinceName;

	@JSONField(name = "cityName")
	private String cityName;

	@JSONField(name = "districtName")
	private String districtName;

	/**
	 * 是否是制图员上传的户型图 (0:普通方案，1:户型图)
	 */
	@JSONField(name = "is_apartment_renderings")
	private String isApartmentRenderings;
	
	/**
	 * 新方案的标识，(新方案:1，旧方案:0)
	 */
	@JSONField(name = "is_new")
	private String isNew;
	
	/**
	 * 户型图
	 */
	@JSONField(name = "photo_2d")
	private String photo2d;
	
	/**
	 * customData锁
	 */
	@JSONField(name = "lock")
	private String lock;

	/**
	 * 全景渲染图描述
	 */
	@JSONField(name = "naviPanosDesc")
	private String naviPanosDesc;

	public String getNaviPanosDesc() {
		return naviPanosDesc;
	}

	public void setNaviPanosDesc(String naviPanosDesc) {
		this.naviPanosDesc = naviPanosDesc;
	}

	public String getDateModifyed() {
		return dateModifyed;
	}

	public void setDateModifyed(String dateModifyed) {
		this.dateModifyed = dateModifyed;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getSelectImage() {
		return selectImage;
	}

	public void setSelectImage(String selectImage) {
		this.selectImage = selectImage;
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

	public String getOriginalAssetVersion()
	{
		return originalAssetVersion;
	}

	public void setOriginalAssetVersion( String originalAssetVersion )
	{
		this.originalAssetVersion = originalAssetVersion;
	}

	public Boolean getIsSampleRoom()
	{
		return isSampleRoom;
	}

	public void setIsSampleRoom( Boolean isSampleRoom )
	{
		this.isSampleRoom = isSampleRoom;
	}

	public Long getOriginalAssetId()
	{
		return originalAssetId;
	}

	public void setOriginalAssetId( Long originalAssetId )
	{
		this.originalAssetId = originalAssetId;
	}

	public ThreeDimensionalCD()
	{
		super();
	}

	public ThreeDimensionalCD( String hsDesignerUid, String hsDesignId )
	{
		super();
		this.hsDesignerUid = hsDesignerUid;
		this.hsDesignId = hsDesignId;
	}

	public ThreeDimensionalCD( String bedroom, String city, String communityName, String conception, String customStringArea, String customStringBedroom, String customStringForm,
			String customStringName, String customStringRestroom, String customStringStyle, String customStringType, String designFile, String designName, String district,
			String hsDesignerUid, String hsDesignId, String projectStyle, String projectType, String province, Integer publishStatus, String restroom, Double roomArea,
			String roomType, Long designAssetId, String customStringIsStorage, String sort, String thumbnailMainPath, Long thumbnailMainId, Long favoriteCount,
			String customStringSortType, Integer customStringPublishStatus )
	{
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
		this.customStringIsStorage = customStringIsStorage;
		this.sort = sort;
		this.thumbnailMainPath = thumbnailMainPath;
		this.thumbnailMainId = thumbnailMainId;
		this.favoriteCount = favoriteCount;
		this.customStringSortType = customStringSortType;
		this.customStringPublishStatus = customStringPublishStatus;
	}

	public ThreeDimensionalCD( Long designAssetId, String bedroom, String city, String communityName, String conception, String customStringArea, String customStringBedroom,
			String customStringForm, String customStringName, String customStringRestroom, String customStringStyle, String customStringType, String designFile, String designName,
			String district, String hsDesignerUid, String hsDesignId, String projectStyle, String projectType, String province, Integer publishStatus, String restroom,
			Double roomArea, String roomType, String customStringIsStorage, String sort, String thumbnailMainPath, Long thumbnailMainId, Long favoriteCount,
			String customStringSortType, Integer customStringPublishStatus, String customStringCommunityName )
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
		this.customStringIsStorage = customStringIsStorage;
		this.sort = sort;
		this.thumbnailMainPath = thumbnailMainPath;
		this.thumbnailMainId = thumbnailMainId;
		this.favoriteCount = favoriteCount;
		this.customStringSortType = customStringSortType;
		this.customStringPublishStatus = customStringPublishStatus;
		this.customStringCommunityName = customStringCommunityName;
	}

	public String getCustomStringOwnerType()
	{
		return customStringOwnerType;
	}

	public void setCustomStringOwnerType( String customStringOwnerType )
	{
		this.customStringOwnerType = customStringOwnerType;
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

	public String getDesignFile()
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

	public void setDesignFile( String designFile )
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

	public Long getDesignAssetId()
	{
		return designAssetId;
	}

	public void setDesignAssetId( Long designAssetId )
	{
		this.designAssetId = designAssetId;
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

	public Long getFavoriteCount()
	{
		return favoriteCount;
	}

	public void setFavoriteCount( Long favoriteCount )
	{
		this.favoriteCount = favoriteCount;
	}

	public String getCustomStringSortType()
	{
		return customStringSortType;
	}

	public void setCustomStringSortType( String customStringSortType )
	{
		this.customStringSortType = customStringSortType;
	}
	public Long getDesignerId()
	{
		return designerId;
	}

	public void setDesignerId( Long designerId )
	{
		this.designerId = designerId;
	}
	public String getCustomStringKeywords()
	{
		return customStringKeywords;
	}

	public void setCustomStringKeywords( String customStringKeywords )
	{
		this.customStringKeywords = customStringKeywords;
	}

	public Integer getCustomStringPublishStatus()
	{
		return customStringPublishStatus;
	}

	public void setCustomStringPublishStatus( Integer customStringPublishStatus )
	{
		this.customStringPublishStatus = customStringPublishStatus;
	}

	public String getCustomStringCommunityName()
	{
		return customStringCommunityName;
	}

	public void setCustomStringCommunityName( String customStringCommunityName )
	{
		this.customStringCommunityName = customStringCommunityName;
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

	public String getOriginalDesignerId()
	{
		return originalDesignerId;
	}

	public void setOriginalDesignerId( String originalDesignerId )
	{
		this.originalDesignerId = originalDesignerId;
	}

	public String getOriginalNickName()
	{
		return originalNickName;
	}

	public void setOriginalNickName( String originalNickName )
	{
		this.originalNickName = originalNickName;
	}

	public String getHsTag()
	{
		return hsTag;
	}

	public void setHsTag( String hsTag )
	{
		this.hsTag = hsTag;
	}

	public String getSourcePhoto2d()
	{
		return sourcePhoto2d;
	}

	public void setSourcePhoto2d( String sourcePhoto2d )
	{
		this.sourcePhoto2d = sourcePhoto2d;
	}

	public Integer getIsCustomThumbnailMain()
	{
		return isCustomThumbnailMain;
	}

	public void setIsCustomThumbnailMain( Integer isCustomThumbnailMain )
	{
		this.isCustomThumbnailMain = isCustomThumbnailMain;
	}

	public String getCustomStringHsSchemeSyn()
	{
		return customStringHsSchemeSyn;
	}

	public void setCustomStringHsSchemeSyn( String customStringHsSchemeSyn )
	{
		this.customStringHsSchemeSyn = customStringHsSchemeSyn;
	}

	public String getDateSubmitted()
	{
		return dateSubmitted;
	}

	public void setDateSubmitted( String dateSubmitted )
	{
		this.dateSubmitted = dateSubmitted;
	}

	public String getRoomDescList() {
		return roomDescList;
	}

	public void setRoomDescList(String roomDescList) {
		this.roomDescList = roomDescList;
	}

	public String getIsApartmentRenderings() {
		return isApartmentRenderings;
	}

	public void setIsApartmentRenderings(String isApartmentRenderings) {
		this.isApartmentRenderings = isApartmentRenderings;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public String getPhoto2d() {
		return photo2d;
	}

	public void setPhoto2d(String photo2d) {
		this.photo2d = photo2d;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		this.lock = lock;
	}
	
}
