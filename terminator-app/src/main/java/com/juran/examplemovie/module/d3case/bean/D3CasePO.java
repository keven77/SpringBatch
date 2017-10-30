package com.juran.examplemovie.module.d3case.bean;

import com.juran.examplemovie.client.bean.domain.BookingDemand;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 18:18 2017/9/28
 */
@Document(collection = "d3Case")
public class D3CasePO {
    /**
     * design_asset_id
     */
    @Indexed(unique = true)
    private Long designAssetId;

    /**
     * 厅
     */
    private String bedroom;

    /**
     * 市
     */
    private String city;


    private String cityName;

    /**
     * 小区名称
     */

    private String communityName;

    /**
     * 设计理念
     */
    private String conception;

    /**
     * 面积
     */

    private String customStringArea;

    /**
     * 厅
     */

    private String customStringBedroom;

    /**
     * 类型
     */

    private String customStringForm;

    /**
     * 案例名称
     */
    private String customStringName;

    /**
     * 卫
     */
    private String customStringRestroom;

    /**
     * 风格
     */
    private String customStringStyle;

    /**
     * 户型
     */
    private String customStringType;

    /**
     * 3D方案文件
     */
    private List<D3FileInfo> designFile;

    /**
     * 方案名称
     */
    private String designName;

    /**
     * 区
     */
    private String district;

    private String districtName;

    /**
     * homestyle设计师id<br>
     */
    private String hsDesignerUid;

    /**
     * 创建者编号
     */
    private Long designerId;

    /**
     * 方案ID<br>
     */
    private String hsDesignId;

    /**
     * 风格（下拉框，现代 田园 混搭 简约 地中海 中式 日式 韩式 新古典 欧式 美式 港式 北欧 其他）
     */
    private String projectStyle;

    /**
     * 空间（下拉框，客厅 卧室 厨房 餐厅 卫生间 阳台 玄关 书房 衣帽间 儿童房 楼梯 其他）,DIY样板间用
     */
    private String projectType;

    /**
     * 省（直辖）市
     */
    private String province;

    private String provinceName;

    /**
     * 公私标志
     */
    private Integer publishStatus;

    /**
     * 卫
     */
    private String restroom;

    /**
     * 面积
     */
    private Double roomArea;

    /**
     * 室
     */
    private String roomType;

    /**
     * 收藏数
     */
    private Long favoriteCount;

    /**
     * 是否入库,N:未入库，Y:已入库 用于acs里的条件查询
     */

    private String customStringIsStorage;

    /**
     * 置顶区排序（10-000000000x），优先排序区（20-0000000000），默认排序区（30-0000000000）
     */
    private String sort;

    /**
     * 排序类型， 置顶区（10），优先区（20），默认区（30） 用于acs里的条件查询
     */
    private String customStringSortType;

    /**
     * 公私标志 用于acs里的条件查询
     */
    private Integer customStringPublishStatus;

    /**
     * 关键字
     */
    private String customStringKeywords;

    /**
     * 原始头像
     */
    private String originalAvatar;

    /**
     * 原始的设计师uid
     */

    private String originalHsDesignerUid;

    private Long originalAssetId;

    /**
     * 主图path
     */
    private String thumbnailMainPath;

    /**
     * 主图id
     */
    private Long thumbnailMainId;

    private Date dateSubmitted;

    private Date dateModifyed;

    /**
     * @Fields display 是否展示
     */
    private Boolean display;

    /**
     * @Fields isSampleRoom 是否精装
     */
    private Boolean sampleRoom;

    /**
     * @Fields renderingImages 渲染图片信息
     */
    private List<D3SpaceInfo> renderingImages;

    /**
     * 渠道信息
     */
    private String channel;

    /**
     * 大赛信息
     */
    private String contest;

    /**
     * 门店信息
     */
    private String store;

    private String roomMold;

    private String specialTag;

    private BookingDemand referenceDemand;

    private String houseQuote;

    private String demandDescription;

    private String newCase;

    private List<D3FileInfo> naviPanos;

    private String naviPanosDesc;

    /**
     * 标记该案例是否是精选案例：brilliant:精选 normal:普通
     */
    private String caseType;

    /**
     * 案例状态：0表示有效,1表示无效
     */
    private Integer status;

    /**
     * 更新状态：0表示更新,1表示无效
     */
    private Integer updateStatus;

    /**
     * 删除状态 1：已删除 0：未删除
     */
    private Integer deleteStatus;

    /**
     * 处理状态 1：处理 0：未处理 默认是0
     */
     private Integer handleStatus;

    /**
     * 选中的图片（以逗号分隔的字符串）
     */
    private String selectImage;

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getDesignAssetId() {
        return designAssetId;
    }

    public void setDesignAssetId(Long designAssetId) {
        this.designAssetId = designAssetId;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
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

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getConception() {
        return conception;
    }

    public void setConception(String conception) {
        this.conception = conception;
    }

    public String getCustomStringArea() {
        return customStringArea;
    }

    public void setCustomStringArea(String customStringArea) {
        this.customStringArea = customStringArea;
    }

    public String getCustomStringBedroom() {
        return customStringBedroom;
    }

    public void setCustomStringBedroom(String customStringBedroom) {
        this.customStringBedroom = customStringBedroom;
    }

    public String getCustomStringForm() {
        return customStringForm;
    }

    public void setCustomStringForm(String customStringForm) {
        this.customStringForm = customStringForm;
    }

    public String getCustomStringName() {
        return customStringName;
    }

    public void setCustomStringName(String customStringName) {
        this.customStringName = customStringName;
    }

    public String getCustomStringRestroom() {
        return customStringRestroom;
    }

    public void setCustomStringRestroom(String customStringRestroom) {
        this.customStringRestroom = customStringRestroom;
    }

    public String getCustomStringStyle() {
        return customStringStyle;
    }

    public void setCustomStringStyle(String customStringStyle) {
        this.customStringStyle = customStringStyle;
    }

    public String getCustomStringType() {
        return customStringType;
    }

    public void setCustomStringType(String customStringType) {
        this.customStringType = customStringType;
    }

    public List<D3FileInfo> getDesignFile() {
        return designFile;
    }

    public void setDesignFile(List<D3FileInfo> designFile) {
        this.designFile = designFile;
    }

    public String getDesignName() {
        return designName;
    }

    public void setDesignName(String designName) {
        this.designName = designName;
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

    public String getHsDesignerUid() {
        return hsDesignerUid;
    }

    public void setHsDesignerUid(String hsDesignerUid) {
        this.hsDesignerUid = hsDesignerUid;
    }

    public Long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }

    public String getHsDesignId() {
        return hsDesignId;
    }

    public void setHsDesignId(String hsDesignId) {
        this.hsDesignId = hsDesignId;
    }

    public String getProjectStyle() {
        return projectStyle;
    }

    public void setProjectStyle(String projectStyle) {
        this.projectStyle = projectStyle;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
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

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getRestroom() {
        return restroom;
    }

    public void setRestroom(String restroom) {
        this.restroom = restroom;
    }

    public Double getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(Double roomArea) {
        this.roomArea = roomArea;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getCustomStringIsStorage() {
        return customStringIsStorage;
    }

    public void setCustomStringIsStorage(String customStringIsStorage) {
        this.customStringIsStorage = customStringIsStorage;
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

    public Integer getCustomStringPublishStatus() {
        return customStringPublishStatus;
    }

    public void setCustomStringPublishStatus(Integer customStringPublishStatus) {
        this.customStringPublishStatus = customStringPublishStatus;
    }

    public String getCustomStringKeywords() {
        return customStringKeywords;
    }

    public void setCustomStringKeywords(String customStringKeywords) {
        this.customStringKeywords = customStringKeywords;
    }

    public String getOriginalAvatar() {
        return originalAvatar;
    }

    public void setOriginalAvatar(String originalAvatar) {
        this.originalAvatar = originalAvatar;
    }

    public String getOriginalHsDesignerUid() {
        return originalHsDesignerUid;
    }

    public void setOriginalHsDesignerUid(String originalHsDesignerUid) {
        this.originalHsDesignerUid = originalHsDesignerUid;
    }

    public Long getOriginalAssetId() {
        return originalAssetId;
    }

    public void setOriginalAssetId(Long originalAssetId) {
        this.originalAssetId = originalAssetId;
    }

    public String getThumbnailMainPath() {
        return thumbnailMainPath;
    }

    public void setThumbnailMainPath(String thumbnailMainPath) {
        this.thumbnailMainPath = thumbnailMainPath;
    }

    public Long getThumbnailMainId() {
        return thumbnailMainId;
    }

    public void setThumbnailMainId(Long thumbnailMainId) {
        this.thumbnailMainId = thumbnailMainId;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public Date getDateModifyed() {
        return dateModifyed;
    }

    public void setDateModifyed(Date dateModifyed) {
        this.dateModifyed = dateModifyed;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Boolean getSampleRoom() {
        return sampleRoom;
    }

    public void setSampleRoom(Boolean sampleRoom) {
        this.sampleRoom = sampleRoom;
    }

    public List<D3SpaceInfo> getRenderingImages() {
        return renderingImages;
    }

    public void setRenderingImages(List<D3SpaceInfo> renderingImages) {
        this.renderingImages = renderingImages;
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

    public BookingDemand getReferenceDemand() {
        return referenceDemand;
    }

    public void setReferenceDemand(BookingDemand referenceDemand) {
        this.referenceDemand = referenceDemand;
    }

    public String getHouseQuote() {
        return houseQuote;
    }

    public void setHouseQuote(String houseQuote) {
        this.houseQuote = houseQuote;
    }

    public String getDemandDescription() {
        return demandDescription;
    }

    public void setDemandDescription(String demandDescription) {
        this.demandDescription = demandDescription;
    }

    public String getNewCase() {
        return newCase;
    }

    public void setNewCase(String newCase) {
        this.newCase = newCase;
    }

    public List<D3FileInfo> getNaviPanos() {
        return naviPanos;
    }

    public void setNaviPanos(List<D3FileInfo> naviPanos) {
        this.naviPanos = naviPanos;
    }

    public String getNaviPanosDesc() {
        return naviPanosDesc;
    }

    public void setNaviPanosDesc(String naviPanosDesc) {
        this.naviPanosDesc = naviPanosDesc;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getSelectImage() {
        return selectImage;
    }

    public void setSelectImage(String selectImage) {
        this.selectImage = selectImage;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }
}
