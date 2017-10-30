package com.juran.examplemovie.module.project.bean;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 18:28 2017/10/12
 */
@Document(collection = "demand")
public class DemandPO {
    /**
     * @Fields communityName 小区名称
     */
    private String communityName;

    /**
     * @Fields consumerName 消费者姓名
     */
    private String consumerName;

    /**
     * @Fields consumerMobile 消费者电话
     */
    private String consumerMobile;

    /**
     * @Fields consumerAvatar 消费者头像
     */
    private String consumerAvatar;

    /**
     * @Fields houseArea 房屋面积
     */
    private String houseArea;

    /**
     * @Fields houseType 房屋类型
     */
    private String houseType;

    /**
     * @Fields decorationBudget 装修预算
     */
    private String decorationBudget;

    /**
     * @Fields province 项目地址（省）
     */
    private Integer province;

    /**
     * @Fields provinceName 项目地址（省）
     */
    private String provinceName;

    /**
     * @Fields city 项目地址（市）
     */
    private Integer city;

    /**
     * @Fields cityName 项目地址（市）
     */
    private String cityName;

    /**
     * @Fields district 项目地址（区）
     */
    private Integer district;

    /**
     * @Fields districtName 项目地址（区）
     */
    private String districtName;

    /**
     * @Fields selectedType 业主已选预约类型( 1:大师,2:工作室,3:精选,4:竟优,5:套餐,6:其他（本期为百万基金大赛）)"
     */
    private Integer selectedType;

    /**
     * @Fields dispatchType 派单预约类型( 1:大师,2:工作室,3:精选,4:竟优,5:套餐)"
     */
    private Integer dispatchType;

    /**
     * @Fields designStyle 设计风格 (多个，用 ","隔开)
     */
    private String designStyle;

    /**
     * @Fields publishTime 发布时间
     */
    private Date publishTime;

    /**
     * @Fields bookingStatus 预约状态(0:未派单,1:已派单,2:未通过)
     */
    private Integer bookingStatus;

    /**
     * @Fields auditer 审核人
     */
    private String auditer;

    /**
     * @Fields auditDesc 审核描述
     */
    private String auditDesc;

    /**
     * @Fields consumerUid 消费者UID
     */
    private String consumerUid;

    /**
     * @Fields customerId 消费者ID
     */
    private String consumerId;

    /**
     * @Fields detailDesc 需求详细描述
     */
    private String detailDesc;

    /**
     * @Fields id 设计需求编号
     */
    @Indexed(unique = true)
    private Long assetId;

    /**
     * @Fields wkCurMainStepId 工作流节点ID
     */
    private String wkCurMainStepId;

    /**
     * @Fields wkCurSubNodeId 工作流节点ID
     */
    private String wkCurSubNodeId;

    /**
     * 工作流模板ID
     */
    private String wkTemplateId;

    /**
     * 工作流ID
     */
    private Integer workflowId;

    /**
     * 工作流步骤标识
     */
    private Integer workflowStepId;

    /**
     * @Fields projectStatus
     */
    private String projectStatus;

    /**
     * @Fields mainDemand
     */
    private String mainDemand;

    /**
     * @Fields projectType 项目类型
     */
    private String projectType;

    /**
     * @Fields projectStartTime 项目开始时间
     */
    private Date projectStartTime;

    /**
     * @Fields address 详细地址
     */
    private String address;

    /**
     * @Fields dispatchDesignerUid 派单设计师uid
     */
    private String dispatchDesignerUid;

    /**
     * @Fields 派单设计师 acsMemberId
     */
    private Long dispatchDesignerId;

    /**
     * @Fields dispatchDesignerName 派单设计师姓名
     */
    private String dispatchDesignerName;

    /**
     * @Fields dispatchDesignerAvatar 派单设计师头像
     */
    private String dispatchDesignerAvatar;

    /**
     * @Fields dispatchDesignerAvatar 派单设计师threadId
     */
    private String dispatchDesignerThreadId;

    /**
     * @Fields selectedDesignerUid 消费者选择的设计师uid
     */
    private String selectedDesignerUid;

    /**
     * @Fields selectedDesignerId 消费者选择的设计师
     */
    private Long selectedDesignerId;

    /**
     * @Fields selectedDesignerName 消费者选择的设计师姓名
     */
    private String selectedDesignerName;

    /**
     * @Fields selectedDesignerName 消费者选择的设计师头像
     */
    private String selectedDesignerAvatar;

    /**
     * @Fields selectedDesignerName 消费者选择的设计师头像
     */
    private String selectedDesignerThreadId;

    /**
     * @Fields customKeys custom_keys
     */
    private String customKeys;

    /**
     * @Fields mainProjectId 主项目assetId
     */
    private Long mainProjectId;

    /**
     * @Fields termnatedStatus 需求终止状态 0：未终止 1：已终止
     */
    private Integer termnatedStatus;

    /**
     * @Fields serviceModel 类型
     */
    private Integer serviceModel;

    /**
     * 订单（JSON格式）
     */
    private String order;

    /*************** 适配老系统字段 start *********************/
    /**
     * 是否是北舒套餐
     */
    private String beishu;

    /** 状态 */
    private Integer customStringStatus;

    /** 联系人电话 */
    private String contactsMobile;

    /** 联系人姓名 */
    private String contactsName;

    /**
     * 是否显示
     */
    private String publicOrNot;

    /*************** 适配老系统字段 end *********************/

    /*************** 套餐统计服务依赖字段 start **************/
    private String customStringSource;

    private String customStringPayment;

    private String customStringQuote;

    private String customStringSendedTime;

    /*************** 套餐统计服务依赖字段 end ****************/
    /*************** 大赛需求字段 start *********************/
    private String channel;

    private String contest;

    private String store;

    private String submit;

    /*************** 大赛需求字段 end *********************/

    /**
     * 删除状态 1：已删除 0：未删除
     */
    private Integer deleteStatus;

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerMobile() {
        return consumerMobile;
    }

    public void setConsumerMobile(String consumerMobile) {
        this.consumerMobile = consumerMobile;
    }

    public String getConsumerAvatar() {
        return consumerAvatar;
    }

    public void setConsumerAvatar(String consumerAvatar) {
        this.consumerAvatar = consumerAvatar;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getDecorationBudget() {
        return decorationBudget;
    }

    public void setDecorationBudget(String decorationBudget) {
        this.decorationBudget = decorationBudget;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(Integer selectedType) {
        this.selectedType = selectedType;
    }

    public Integer getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(Integer dispatchType) {
        this.dispatchType = dispatchType;
    }

    public String getDesignStyle() {
        return designStyle;
    }

    public void setDesignStyle(String designStyle) {
        this.designStyle = designStyle;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Integer bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getAuditer() {
        return auditer;
    }

    public void setAuditer(String auditer) {
        this.auditer = auditer;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getConsumerUid() {
        return consumerUid;
    }

    public void setConsumerUid(String consumerUid) {
        this.consumerUid = consumerUid;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getWkCurMainStepId() {
        return wkCurMainStepId;
    }

    public void setWkCurMainStepId(String wkCurMainStepId) {
        this.wkCurMainStepId = wkCurMainStepId;
    }

    public String getWkCurSubNodeId() {
        return wkCurSubNodeId;
    }

    public void setWkCurSubNodeId(String wkCurSubNodeId) {
        this.wkCurSubNodeId = wkCurSubNodeId;
    }

    public String getWkTemplateId() {
        return wkTemplateId;
    }

    public void setWkTemplateId(String wkTemplateId) {
        this.wkTemplateId = wkTemplateId;
    }

    public Integer getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Integer workflowId) {
        this.workflowId = workflowId;
    }

    public Integer getWorkflowStepId() {
        return workflowStepId;
    }

    public void setWorkflowStepId(Integer workflowStepId) {
        this.workflowStepId = workflowStepId;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getMainDemand() {
        return mainDemand;
    }

    public void setMainDemand(String mainDemand) {
        this.mainDemand = mainDemand;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Date getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(Date projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDispatchDesignerUid() {
        return dispatchDesignerUid;
    }

    public void setDispatchDesignerUid(String dispatchDesignerUid) {
        this.dispatchDesignerUid = dispatchDesignerUid;
    }

    public Long getDispatchDesignerId() {
        return dispatchDesignerId;
    }

    public void setDispatchDesignerId(Long dispatchDesignerId) {
        this.dispatchDesignerId = dispatchDesignerId;
    }

    public String getDispatchDesignerName() {
        return dispatchDesignerName;
    }

    public void setDispatchDesignerName(String dispatchDesignerName) {
        this.dispatchDesignerName = dispatchDesignerName;
    }

    public String getDispatchDesignerAvatar() {
        return dispatchDesignerAvatar;
    }

    public void setDispatchDesignerAvatar(String dispatchDesignerAvatar) {
        this.dispatchDesignerAvatar = dispatchDesignerAvatar;
    }

    public String getDispatchDesignerThreadId() {
        return dispatchDesignerThreadId;
    }

    public void setDispatchDesignerThreadId(String dispatchDesignerThreadId) {
        this.dispatchDesignerThreadId = dispatchDesignerThreadId;
    }

    public String getSelectedDesignerUid() {
        return selectedDesignerUid;
    }

    public void setSelectedDesignerUid(String selectedDesignerUid) {
        this.selectedDesignerUid = selectedDesignerUid;
    }

    public Long getSelectedDesignerId() {
        return selectedDesignerId;
    }

    public void setSelectedDesignerId(Long selectedDesignerId) {
        this.selectedDesignerId = selectedDesignerId;
    }

    public String getSelectedDesignerName() {
        return selectedDesignerName;
    }

    public void setSelectedDesignerName(String selectedDesignerName) {
        this.selectedDesignerName = selectedDesignerName;
    }

    public String getSelectedDesignerAvatar() {
        return selectedDesignerAvatar;
    }

    public void setSelectedDesignerAvatar(String selectedDesignerAvatar) {
        this.selectedDesignerAvatar = selectedDesignerAvatar;
    }

    public String getSelectedDesignerThreadId() {
        return selectedDesignerThreadId;
    }

    public void setSelectedDesignerThreadId(String selectedDesignerThreadId) {
        this.selectedDesignerThreadId = selectedDesignerThreadId;
    }

    public String getCustomKeys() {
        return customKeys;
    }

    public void setCustomKeys(String customKeys) {
        this.customKeys = customKeys;
    }

    public Long getMainProjectId() {
        return mainProjectId;
    }

    public void setMainProjectId(Long mainProjectId) {
        this.mainProjectId = mainProjectId;
    }

    public Integer getTermnatedStatus() {
        return termnatedStatus;
    }

    public void setTermnatedStatus(Integer termnatedStatus) {
        this.termnatedStatus = termnatedStatus;
    }

    public Integer getServiceModel() {
        return serviceModel;
    }

    public void setServiceModel(Integer serviceModel) {
        this.serviceModel = serviceModel;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getBeishu() {
        return beishu;
    }

    public void setBeishu(String beishu) {
        this.beishu = beishu;
    }

    public Integer getCustomStringStatus() {
        return customStringStatus;
    }

    public void setCustomStringStatus(Integer customStringStatus) {
        this.customStringStatus = customStringStatus;
    }

    public String getContactsMobile() {
        return contactsMobile;
    }

    public void setContactsMobile(String contactsMobile) {
        this.contactsMobile = contactsMobile;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getPublicOrNot() {
        return publicOrNot;
    }

    public void setPublicOrNot(String publicOrNot) {
        this.publicOrNot = publicOrNot;
    }

    public String getCustomStringSource() {
        return customStringSource;
    }

    public void setCustomStringSource(String customStringSource) {
        this.customStringSource = customStringSource;
    }

    public String getCustomStringPayment() {
        return customStringPayment;
    }

    public void setCustomStringPayment(String customStringPayment) {
        this.customStringPayment = customStringPayment;
    }

    public String getCustomStringQuote() {
        return customStringQuote;
    }

    public void setCustomStringQuote(String customStringQuote) {
        this.customStringQuote = customStringQuote;
    }

    public String getCustomStringSendedTime() {
        return customStringSendedTime;
    }

    public void setCustomStringSendedTime(String customStringSendedTime) {
        this.customStringSendedTime = customStringSendedTime;
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

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
