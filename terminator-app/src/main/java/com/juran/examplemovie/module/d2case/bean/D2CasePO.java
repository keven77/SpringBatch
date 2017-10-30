package com.juran.examplemovie.module.d2case.bean;

import com.juran.examplemovie.client.bean.domain.RspD2Case;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/9/27.
 */
@Document(collection = "d2Case")
public class D2CasePO {

    /**
     * 审核描述
     */
    private String auditDesc;

    /**
     * 案例的颜色（下拉框，白色、米色、黄色、橙色、红色、绿色、蓝色、紫色、粉色、咖啡色、灰色、黑色、彩色、其他）
     */
    private String caseColor;

    /**
     * 方案类型：01：效果图方案、02：DIY样板间
     */
    private String caseType;

    /**
     * 省（直辖）市
     */
    private String province;

    /** 项目地址（省） */
    private String provinceName;

    /**
     * 市
     */
    private String city;
    /**
     * 市
     */
    private String cityName;

    /**
     * 区
     */
    private String district;

    /** 区名称 */
    private String districtName;

    /**
     * 浏览量
     */
    private Long clickNumber;

    /**
     * 小区名称
     */
    private String communityName;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 状态、0：待审核、1：审核通过、2：审核未通过、3：草稿
     */
    private Integer	customStringStatus;

    /**
     * 装修类型：家装、公装
     */
    private String decorationType;

    /**
     * 方案描述
     */
    private String description;

    /**
     * 设计师ID
     */
    private Long designerId;

    /**
     * 收藏数
     */
    private Long favoriteCount;

    /**
     * 房屋类型
     */
    private String houseType;

    /**
     * 设计师UID
     */
    private String hsDesignerUid;

    /**
     * AssetId
     */
    @Indexed(unique = true)
    private Long assetId;

    /**
     * 图片集
     */
    private List<ImageInfo> images;

    /**
     * 是否被推荐，N：不是 Y：是
     */
    private String isRecommended;

    /**
     * 基础装修报价
     */
    private Double prjBasePrice;

    /**
     * 家居家饰报价
     */
    private Double prjFurniturePrice;

    /**
     * 隐蔽工程报价
     */
    private Double prjHiddenPrice;

    /**
     * 主材报价
     */
    private Double prjMaterialPrice;

    /**
     * 家居饰品报价
     */
    private Double prjOtherPrice;

    /**
     * 项目报价
     */
    private Double	prjPrice;

    /**
     * 风格（下拉框，现代 田园 混搭 简约 地中海 中式 日式 韩式 新古典 欧式 美式 港式 北欧 其他）
     */
    private String projectStyle;

    /**
     * 总报价
     */
    private Double protocolPrice;
    /**
     * 户型：室
     */
    private String roomType;

    /**
     * 厅
     */
    private String bedroom;

    /**
     * 卫
     */
    private String restroom;

    /**
     * 面积
     */
    private String roomArea;


    /**
     * 标签
     */
    private String searchTag;

    /**
     * 方案名称
     */
    private String title;

    /**
     * 排序
     */
    private Long weight;

    /**
     * 排序类型， 置顶区（10），优先区（20），默认区（30）
     */
    private String sortType;

    /**
     * 置顶区排序（10-000000000x），优先排序区（20-0000000000），默认排序区（30-0000000000）
     */
    private String sort;

    /**
     * 排序类型， 置顶区（10），优先区（20），默认区（30） 用于acs里的条件查询
     */
    private String customStringSortType;

    /**
     * 2D案例名称
     */
    private String customStringName;

    /**
     * 渠道信息(web,app,h5)
     */
    private String channel;

    /**
     * 大赛(元洲杯,百万基金)
     */
    private String contest;

    /**
     * 门店信息
     */
    private String store;

    /**
     * 图片信息
     */
    private List<RspD2Case> roomImages;

    /**
     * 特色标签
     */
    private String specialTag;

    /**
     * 活动设计师真实姓名
     */
    private String activityRealName;

    /**
     * 活动设计师 省
     */
    private String activityProvince;

    /**
     * 活动设计师 省名称
     */
    private String activityProvinceName;

    /**
     * 活动设计师 市
     */
    private String activityCity;

    /**
     * 活动设计师 市名称
     */
    private String activityCityName;

    /**
     * 活动设计师 区
     */
    private String activityDistrict;

    /**
     * 活动设计师 区名称
     */
    private String activityDistrictName;

    /**
     * 活动设计师 从业年限
     */
    private String activityExperience;

    /**
     * 活动设计师 毕业院校
     */
    private String activityGraduateFrom;

    /**
     * 活动设计师 个人荣誉
     */
    private String activityPersonalHonour;

    /**
     * 活动设计师 座右铭
     */
    private String activityMotto;

    /**
     * 活动设计师 头像
     */
    private String activityAvatar;

    /**
     * 活动设计师 参选主题竞赛单元 (别墅:0,小户型:1,适老设计:2,空间布局:3,陈设配饰:4,风格表达:5)
     */
    private String activityTag;

    /**
     * 活动品牌
     */
    private String activityBrand;

    /**
     * 活动 工程开工日期
     */
    private String activityCommencementDate;

    /**
     * 活动 业主需求
     */
    private String activityDescDemand;

    /**
     * 活动 设计说明
     */
    private String activityDesignSpecification;

    /**
     * 是否是新方案(新方案:1,旧方案:0)
     */
    private String newCase;

    /**
     * 案例状态：0表示有效,1表示无效
     */
    private Integer status;

    private String originalAvatar;

    private String thumbnailMainPath;

    /**
     * 更新状态：0表示更新,1表示无效
     */
    private Integer updateStatus;

    /**
     * 删除状态 1：已删除 0：未删除
     */
    private Integer deleteStatus;

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getOriginalAvatar() {
        return originalAvatar;
    }

    public void setOriginalAvatar(String originalAvatar) {
        this.originalAvatar = originalAvatar;
    }

    public String getThumbnailMainPath() {
        return thumbnailMainPath;
    }

    public void setThumbnailMainPath(String thumbnailMainPath) {
        this.thumbnailMainPath = thumbnailMainPath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getCaseColor() {
        return caseColor;
    }

    public void setCaseColor(String caseColor) {
        this.caseColor = caseColor;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Long getClickNumber() {
        return clickNumber;
    }

    public void setClickNumber(Long clickNumber) {
        this.clickNumber = clickNumber;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCustomStringStatus() {
        return customStringStatus;
    }

    public void setCustomStringStatus(Integer customStringStatus) {
        this.customStringStatus = customStringStatus;
    }

    public String getDecorationType() {
        return decorationType;
    }

    public void setDecorationType(String decorationType) {
        this.decorationType = decorationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHsDesignerUid() {
        return hsDesignerUid;
    }

    public void setHsDesignerUid(String hsDesignerUid) {
        this.hsDesignerUid = hsDesignerUid;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public List<ImageInfo> getImages() {
        return images;
    }

    public void setImages(List<ImageInfo> images) {
        this.images = images;
    }

    public String getIsRecommended() {
        return isRecommended;
    }

    public void setIsRecommended(String isRecommended) {
        this.isRecommended = isRecommended;
    }

    public Double getPrjBasePrice() {
        return prjBasePrice;
    }

    public void setPrjBasePrice(Double prjBasePrice) {
        this.prjBasePrice = prjBasePrice;
    }

    public Double getPrjFurniturePrice() {
        return prjFurniturePrice;
    }

    public void setPrjFurniturePrice(Double prjFurniturePrice) {
        this.prjFurniturePrice = prjFurniturePrice;
    }

    public Double getPrjHiddenPrice() {
        return prjHiddenPrice;
    }

    public void setPrjHiddenPrice(Double prjHiddenPrice) {
        this.prjHiddenPrice = prjHiddenPrice;
    }

    public Double getPrjMaterialPrice() {
        return prjMaterialPrice;
    }

    public void setPrjMaterialPrice(Double prjMaterialPrice) {
        this.prjMaterialPrice = prjMaterialPrice;
    }

    public Double getPrjOtherPrice() {
        return prjOtherPrice;
    }

    public void setPrjOtherPrice(Double prjOtherPrice) {
        this.prjOtherPrice = prjOtherPrice;
    }

    public Double getPrjPrice() {
        return prjPrice;
    }

    public void setPrjPrice(Double prjPrice) {
        this.prjPrice = prjPrice;
    }

    public String getProjectStyle() {
        return projectStyle;
    }

    public void setProjectStyle(String projectStyle) {
        this.projectStyle = projectStyle;
    }

    public Double getProtocolPrice() {
        return protocolPrice;
    }

    public void setProtocolPrice(Double protocolPrice) {
        this.protocolPrice = protocolPrice;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getRestroom() {
        return restroom;
    }

    public void setRestroom(String restroom) {
        this.restroom = restroom;
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea;
    }

    public String getSearchTag() {
        return searchTag;
    }

    public void setSearchTag(String searchTag) {
        this.searchTag = searchTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCustomStringSortType() {
        return customStringSortType;
    }

    public void setCustomStringSortType(String customStringSortType) {
        this.customStringSortType = customStringSortType;
    }

    public String getCustomStringName() {
        return customStringName;
    }

    public void setCustomStringName(String customStringName) {
        this.customStringName = customStringName;
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

    public List<RspD2Case> getRoomImages() {
        return roomImages;
    }

    public void setRoomImages(List<RspD2Case> roomImages) {
        this.roomImages = roomImages;
    }

    public String getSpecialTag() {
        return specialTag;
    }

    public void setSpecialTag(String specialTag) {
        this.specialTag = specialTag;
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

    public String getActivityPersonalHonour() {
        return activityPersonalHonour;
    }

    public void setActivityPersonalHonour(String activityPersonalHonour) {
        this.activityPersonalHonour = activityPersonalHonour;
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

    public String getNewCase() {
        return newCase;
    }

    public void setNewCase(String newCase) {
        this.newCase = newCase;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
