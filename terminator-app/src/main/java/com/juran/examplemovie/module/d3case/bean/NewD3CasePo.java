package com.juran.examplemovie.module.d3case.bean;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 设计家 3D案例保存字段
 * @date 11:09 2017/10/25
 */
@Document(collection = "newD3Case")
public class NewD3CasePo {
    /**
     * 方案Id,原Acs_Asset_Id
     */
    @Indexed(unique = true)
    private Long caseId;
    /**
     * guid，3D工具方案id
     */
    private String hsDesignId;
    /**
     * Acs_Project_Id 项目Id
     */
    private String projectId;
    /**
     * 是否加入精选案例库
     */
    private Integer storageStatus;
    /**
     * 大赛的标识(812,814等)
     */
    private String contest;
    /**
     * 终端来源(h5,web,app)
     */
    private String channel;
    /**
     * 门店信息
     */
    private String store;
    /**
     * 是否有渲染图，渲染图数量大于零才允许显示
     */
    private Integer display;
    /**
     * 案例封面
     */
    private String caseCover;
    /**
     * 住宅空间、商务空间等，设计家端编辑详情页需要维护
     */
    private String houseType;
    /**
     * 是否是精选户型
     */
    private Integer brilliant;
    /**
     * 案例类型(normal:普通方案,brilliant:精选案例)
     */
    private String caseType;
    /**
     * 特色标签
     */
    private String specialTag;
    /**
     * 参考报价
     */
    private Double houseQuote;
    /**
     * 业主需求
     */
    private String demandDescription;
    /**
     * 全屋信息
     */
    private List<NewD3FileInfo> naviPanos;
    /**
     * 案例的空间信息
     */
    private List<NewD3SpaceInfo> spaceDetails;
    /**
     * 处理状态 1：处理 0：未处理 默认是1
     */
    private Integer handleStatus;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getHsDesignId() {
        return hsDesignId;
    }

    public void setHsDesignId(String hsDesignId) {
        this.hsDesignId = hsDesignId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(Integer storageStatus) {
        this.storageStatus = storageStatus;
    }

    public String getContest() {
        return contest;
    }

    public void setContest(String contest) {
        this.contest = contest;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getCaseCover() {
        return caseCover;
    }

    public void setCaseCover(String caseCover) {
        this.caseCover = caseCover;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Integer getBrilliant() {
        return brilliant;
    }

    public void setBrilliant(Integer brilliant) {
        this.brilliant = brilliant;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getSpecialTag() {
        return specialTag;
    }

    public void setSpecialTag(String specialTag) {
        this.specialTag = specialTag;
    }

    public Double getHouseQuote() {
        return houseQuote;
    }

    public void setHouseQuote(Double houseQuote) {
        this.houseQuote = houseQuote;
    }

    public String getDemandDescription() {
        return demandDescription;
    }

    public void setDemandDescription(String demandDescription) {
        this.demandDescription = demandDescription;
    }

    public List<NewD3FileInfo> getNaviPanos() {
        return naviPanos;
    }

    public void setNaviPanos(List<NewD3FileInfo> naviPanos) {
        this.naviPanos = naviPanos;
    }

    public List<NewD3SpaceInfo> getSpaceDetails() {
        return spaceDetails;
    }

    public void setSpaceDetails(List<NewD3SpaceInfo> spaceDetails) {
        this.spaceDetails = spaceDetails;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }
}
