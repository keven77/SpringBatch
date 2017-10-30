package com.juran.examplemovie.client.bean.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

import com.alibaba.fastjson.annotation.JSONField;
import com.juran.examplemovie.client.bean.enums.EnumTemplate;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author songmingxu 预约项目入参
 */
public class BookingDemand implements Serializable {

	private static final long serialVersionUID = -2740140793641215699L;

	/**
	 * @Fields communityName 小区名称
	 */
	@JSONField(name = "community_name")
	@XmlAttribute(name = "community_name")
	@ApiModelProperty(value = "小区名称", name = "community_name")
	private String communityName;

	/**
	 * @Fields consumerName 消费者姓名
	 */
	@JSONField(name = "consumer_name")
	@XmlAttribute(name = "consumer_name")
	@ApiModelProperty(value = "消费者姓名", name = "consumer_name")
	private String consumerName;

	/**
	 * @Fields consumerMobile 消费者电话
	 */
	@JSONField(name = "consumer_mobile")
	@XmlAttribute(name = "consumer_mobile")
	@ApiModelProperty(value = "消费者电话", name = "consumer_mobile")
	private String consumerMobile;

	/**
	 * @Fields consumerAvatar 消费者头像
	 */
	@JSONField(name = "consumer_avatar")
	@XmlAttribute(name = "consumer_avatar")
	@ApiModelProperty(value = "消费者头像", name = "consumer_avatar")
	private String consumerAvatar;

	/**
	 * @Fields houseArea 房屋面积
	 */
	@JSONField(name = "house_area")
	@XmlAttribute(name = "house_area")
	@ApiModelProperty(value = "房屋面积", name = "house_area")
	private String houseArea;

	/**
	 * @Fields houseType 房屋类型
	 */
	@JSONField(name = "house_type")
	@XmlAttribute(name = "house_type")
	@ApiModelProperty(value = "房屋状态", name = "house_type")
	private String houseType;

	/**
	 * @Fields decorationBudget 装修预算
	 */
	@JSONField(name = "decoration_budget")
	@XmlAttribute(name = "decoration_budget")
	@ApiModelProperty(value = "装修预算", name = "decoration_budget")
	private String decorationBudget;

	/**
	 * @Fields province 项目地址（省）
	 */
	@JSONField(name = "province")
	@XmlAttribute(name = "province")
	@ApiModelProperty(value = "省", name = "province")
	private Integer province;

	/**
	 * @Fields provinceName 项目地址（省）
	 */
	@JSONField(name = "province_name")
	@XmlAttribute(name = "province_name")
	@ApiModelProperty(value = "省名称", name = "province_name")
	private String provinceName;

	/**
	 * @Fields city 项目地址（市）
	 */
	@JSONField(name = "city")
	@XmlAttribute(name = "city")
	@ApiModelProperty(value = "市", name = "city")
	private Integer city;

	/**
	 * @Fields cityName 项目地址（市）
	 */
	@JSONField(name = "city_name")
	@XmlAttribute(name = "city_name")
	@ApiModelProperty(value = "市名称", name = "city_name")
	private String cityName;

	/**
	 * @Fields district 项目地址（区）
	 */
	@JSONField(name = "district")
	@XmlAttribute(name = "district")
	@ApiModelProperty(value = "区", name = "district")
	private Integer district;

	/**
	 * @Fields districtName 项目地址（区）
	 */
	@JSONField(name = "district_name")
	@XmlAttribute(name = "district_name")
	@ApiModelProperty(value = "区名称", name = "district_name")
	private String districtName;

	/**
	 * @Fields selectedType 业主已选预约类型( 1:大师,2:工作室,3:精选,4:竟优,5:套餐,6:其他（本期为百万基金大赛）)"
	 */
	@JSONField(name = "selected_type")
	@XmlAttribute(name = "selected_type")
	@ApiModelProperty(value = "业主已选预约类型", name = "selected_type")
	private Integer selectedType;

	/**
	 * @Fields dispatchType 派单预约类型( 1:大师,2:工作室,3:精选,4:竟优,5:套餐)"
	 */
	@JSONField(name = "dispatch_type")
	@XmlAttribute(name = "dispatch_type")
	@ApiModelProperty(value = "派单预约类型", name = "dispatch_type")
	private Integer dispatchType;

	/**
	 * @Fields designStyle 设计风格 (多个，用 ","隔开)
	 */
	@JSONField(name = "design_style")
	@XmlAttribute(name = "design_style")
	@ApiModelProperty(value = "设计风格", name = "design_style")
	private String designStyle;

	/**
	 * @Fields publishTime 发布时间
	 */
	@JSONField(name = "publish_time")
	@XmlAttribute(name = "publish_time")
	@ApiModelProperty(value = "发布时间", name = "publish_time")
	private String publishTime;

	/**
	 * @Fields bookingStatus 预约状态(0:未派单,1:已派单,2:未通过)
	 */
	@JSONField(name = "booking_status")
	@XmlAttribute(name = "booking_status")
	@ApiModelProperty(value = "预约状态", name = "booking_status")
	private Integer bookingStatus;

	/**
	 * @Fields auditer 审核人
	 */
	@JSONField(name = "auditer")
	@XmlAttribute(name = "auditer")
	@ApiModelProperty(value = "审核人 ", name = "auditer")
	private String auditer;

	/**
	 * @Fields auditDesc 审核描述
	 */
	@JSONField(name = "audit_desc")
	@XmlAttribute(name = "audit_desc")
	@ApiModelProperty(value = "审核描述", name = "audit_desc")
	private String auditDesc;

	/**
	 * @Fields consumerUid 消费者UID
	 */
	@JSONField(name = "consumer_uid")
	@XmlAttribute(name = "consumer_uid")
	@ApiModelProperty(value = "消费者UID", name = "consumer_uid")
	private String consumerUid;

	/**
	 * @Fields customerId 消费者ID
	 */
	@JSONField(name = "consumer_id")
	@XmlAttribute(name = "consumer_id")
	@ApiModelProperty(value = "消费者ID", name = "consumer_id")
	private String consumerId;

	/**
	 * @Fields detailDesc 需求详细描述
	 */
	@JSONField(name = "detail_desc")
	@XmlAttribute(name = "detail_desc")
	@ApiModelProperty(value = "需求详细描述", name = "detail_desc")
	private String detailDesc;

	/**
	 * @Fields id 设计需求编号
	 */
	@JSONField(name = "needs_id")
	@XmlAttribute(name = "needs_id")
	@ApiModelProperty(value = "设计需求编号", name = "needs_id")
	private Long id;

	/**
	 * @Fields wkCurMainStepId 工作流节点ID
	 */
	@JSONField(name = "wk_cur_main_step_id")
	@XmlAttribute(name = "wk_cur_main_step_id")
	@ApiModelProperty(value = "工作流节点ID", name = "wk_cur_main_step_id")
	private String wkCurMainStepId;

	/**
	 * @Fields wkCurSubNodeId 工作流节点ID
	 */
	@JSONField(name = "wk_cur_sub_node_id")
	@XmlAttribute(name = "wk_cur_sub_node_id")
	@ApiModelProperty(value = "工作流节点ID", name = "wk_cur_sub_node_id")
	private String wkCurSubNodeId;

	/**
	 * 工作流模板ID {@link EnumTemplate}
	 */
	@JSONField(name = "wk_template_id")
	@XmlAttribute(name = "wk_template_id")
	@ApiModelProperty(value = "工作流模板ID", name = "wk_template_id")
	private String wkTemplateId;

	/**
	 * 工作流ID
	 */
	@JSONField(name = "workflow_id")
	@XmlAttribute(name = "workflow_id")
	@ApiModelProperty(value = "工作流ID", name = "workflow_id")
	private Integer workflowId;

	/**
	 * 工作流步骤标识
	 */
	@JSONField(name = "workflow_step_id")
	@XmlAttribute(name = "workflow_step_id")
	@ApiModelProperty(value = "工作流步骤标识", name = "workflow_step_id")
	private Integer workflowStepId;

	/**
	 * @Fields projectStatus
	 */
	@JSONField(name = "project_status")
	@XmlAttribute(name = "project_status")
	@ApiModelProperty(value = "项目类型", name = "project_status")
	private String projectStatus;

	/**
	 * @Fields mainDemand
	 */
	@JSONField(name = "main_demand")
	@XmlAttribute(name = "main_demand")
	@ApiModelProperty(value = "主项目", name = "main_demand")
	private String mainDemand;

	/**
	 * @Fields projectType 项目类型
	 */
	@JSONField(name = "project_type")
	@XmlAttribute(name = "project_type")
	@ApiModelProperty(value = "项目类型", name = "project_type")
	private String projectType;

	/**
	 * @Fields projectStartTime 项目开始时间
	 */
	@JSONField(name = "project_start_time")
	@XmlAttribute(name = "project_start_time")
	@ApiModelProperty(value = "项目开始时间", name = "project_start_time")
	private String projectStartTime;

	/**
	 * @Fields address 详细地址
	 */
	@JSONField(name = "address")
	@XmlAttribute(name = "address")
	@ApiModelProperty(value = "详细地址", name = "address")
	private String address;

	/**
	 * @Fields dispatchDesignerUid 派单设计师uid
	 */
	@JSONField(name = "dispatch_designer_uid")
	@XmlAttribute(name = "dispatch_designer_uid")
	@ApiModelProperty(value = "派单设计师uid", name = "dispatch_designer_uid")
	private String dispatchDesignerUid;

	/**
	 * @Fields 派单设计师 acsMemberId
	 */
	@JSONField(name = "dispatch_designer_id")
	@XmlAttribute(name = "dispatch_designer_id")
	@ApiModelProperty(value = "派单设计师 acsMemberId", name = "dispatch_designer_id")
	private Long dispatchDesignerId;

	/**
	 * @Fields dispatchDesignerName 派单设计师姓名
	 */
	@JSONField(name = "dispatch_designer_name")
	@XmlAttribute(name = "dispatch_designer_name")
	@ApiModelProperty(value = "派单设计师姓名", name = "dispatch_designer_name")
	private String dispatchDesignerName;

	/**
	 * @Fields dispatchDesignerAvatar 派单设计师头像
	 */
	@JSONField(name = "dispatch_designer_avatar")
	@XmlAttribute(name = "dispatch_designer_avatar")
	@ApiModelProperty(value = "派单设计师头像", name = "dispatch_designer_avatar")
	private String dispatchDesignerAvatar;

	/**
	 * @Fields dispatchDesignerAvatar 派单设计师threadId
	 */
	@JSONField(name = "dispatch_designer_thread_id")
	@XmlAttribute(name = "dispatch_designer_thread_id")
	@ApiModelProperty(value = "派单设计师聊天threadId", name = "dispatch_designer_thread_id")
	private String dispatchDesignerThreadId;

	/**
	 * @Fields selectedDesignerUid 消费者选择的设计师uid
	 */
	@JSONField(name = "selected_designer_uid")
	@XmlAttribute(name = "selected_designer_uid")
	@ApiModelProperty(value = "派单设计师uid", name = "selected_designer_uid")
	private String selectedDesignerUid;

	/**
	 * @Fields selectedDesignerId 消费者选择的设计师
	 */
	@JSONField(name = "selected_designer_id")
	@XmlAttribute(name = "selected_designer_id")
	@ApiModelProperty(value = "消费者选择的设计师 acsMemberId", name = "selected_designer_id")
	private Long selectedDesignerId;

	/**
	 * @Fields selectedDesignerName 消费者选择的设计师姓名
	 */
	@JSONField(name = "selected_designer_name")
	@XmlAttribute(name = "selected_designer_name")
	@ApiModelProperty(value = "消费者选择的设计师姓名", name = "selected_designer_name")
	private String selectedDesignerName;

	/**
	 * @Fields selectedDesignerName 消费者选择的设计师头像
	 */
	@JSONField(name = "selected_designer_avatar")
	@XmlAttribute(name = "selected_designer_avatar")
	@ApiModelProperty(value = "消费者选择的设计师头像", name = "selected_designer_avatar")
	private String selectedDesignerAvatar;

	/**
	 * @Fields selectedDesignerName 消费者选择的设计师头像
	 */
	@JSONField(name = "selected_designer_thread_id")
	@XmlAttribute(name = "selected_designer_thread_id")
	@ApiModelProperty(value = "消费者选择的设计师threadId", name = "selected_designer_thread_id")
	private String selectedDesignerThreadId;

	/**
	 * @Fields customKeys custom_keys
	 */
	@JSONField(name = "custom_keys")
	@XmlAttribute(name = "custom_keys")
	@ApiModelProperty(value = "assetCustomData的key值,用于关键字查询", name = "custom_keys")
	private String customKeys;

	/**
	 * @Fields mainProjectId 主项目assetId
	 */
	@JSONField(name = "main_projrct_id")
	@XmlAttribute(name = "main_projrct_id")
	@ApiModelProperty(value = "主项目assetId", name = "main_projrct_id")
	private Long mainProjectId;

	/**
	 * @Fields termnatedStatus 需求终止状态 0：未终止 1：已终止
	 */
	@JSONField(name = "termnated_status")
	@XmlAttribute(name = "termnated_status")
	@ApiModelProperty(value = "需求终止状态", name = "termnated_status")
	private Integer termnatedStatus;

	/**
	 * @Fields serviceModel 类型
	 */
	@JSONField(name = "service_model")
	@XmlAttribute(name = "service_model")
	@ApiModelProperty(value = "类型", name = "service_model")
	private Integer serviceModel;

	/**
	 * 订单（JSON格式）
	 */
	@JSONField(name = "order")
	@XmlAttribute(name = "order")
	@ApiModelProperty(value = "订单", name = "order")
	private String order;

	/*************** 适配老系统字段 start *********************/
	/**
	 * 是否是北舒套餐
	 */
	@JSONField(name = "is_beishu")
	@XmlAttribute(name = "is_beishu")
	@ApiModelProperty(value = "是否是北舒套餐", name = "is_beishu")
	private String isBeishu;

	/** 状态 */
	@JSONField(name = "custom_string_status")
	@XmlAttribute(name = "custom_string_status")
	@ApiModelProperty(value = "状态", name = "custom_string_status")
	private Integer customStringStatus;

	/** 联系人电话 */
	@JSONField(name = "contacts_mobile")
	@XmlAttribute(name = "contacts_mobile")
	@ApiModelProperty(value = "联系人电话", name = "contacts_mobile")
	private String contactsMobile;

	/** 联系人姓名 */
	@JSONField(name = "contacts_name")
	@XmlAttribute(name = "contacts_name")
	@ApiModelProperty(value = "联系人姓名", name = "contacts_name")
	private String contactsName;

	/**
	 * 是否显示
	 */
	@JSONField(name = "is_public")
	@XmlAttribute(name = "is_public")
	@ApiModelProperty(value = "是否显示", name = "is_public")
	private String isPublic;

	/*************** 适配老系统字段 end *********************/

	/*************** 套餐统计服务依赖字段 start **************/
	@JSONField(name = "custom_string_source")
	@XmlAttribute(name = "custom_string_source")
	@ApiModelProperty(value = "套餐项目来源(0:预约,1:扫码)", name = "custom_string_source")
	private String customStringSource;

	@JSONField(name = "custom_string_payment")
	@XmlAttribute(name = "custom_string_payment")
	@ApiModelProperty(value = "支付状态状态(0:未支付,1:已支付)", name = "custom_string_payment")
	private String customStringPayment;

	@JSONField(name = "custom_string_quote")
	@XmlAttribute(name = "custom_string_quote")
	@ApiModelProperty(value = "报价状态(0:未报价,1:已报价)", name = "custom_string_quote")
	private String customStringQuote;

	@JSONField(name = "custom_string_sended_time")
	@XmlAttribute(name = "custom_string_sended_time")
	@ApiModelProperty(value = "是否已发送给财务(0:未发送,1:已发送)", name = "custom_string_sended_time")
	private String customStringSendedTime;

	/*************** 套餐统计服务依赖字段 end ****************/
	/*************** 大赛需求字段 start *********************/
	@JSONField(name = "channel")
	@XmlAttribute(name = "channel")
	@ApiModelProperty(value = "渠道(web,app,h5)", name = "channel")
	private String channel;

	@JSONField(name = "contest")
	@XmlAttribute(name = "contest")
	@ApiModelProperty(value = "大赛类型", name = "contest")
	private String contest;

	@JSONField(name = "store")
	@XmlAttribute(name = "store")
	@ApiModelProperty(value = "门店code", name = "store")
	private String store;
	
	@JSONField(name = "is_submit")
	@XmlAttribute(name = "is_submit")
	@ApiModelProperty(value = "是否提交参赛", name = "is_submit")
	private String isSubmit;

	/*************** 大赛需求字段 end *********************/

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

	public String getDesignStyle() {
		return designStyle;
	}

	public void setDesignStyle(String designStyle) {
		this.designStyle = designStyle;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getProjectStartTime() {
		return projectStartTime;
	}

	public void setProjectStartTime(String projectStartTime) {
		this.projectStartTime = projectStartTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDispatchDesignerAvatar() {
		return dispatchDesignerAvatar;
	}

	public void setDispatchDesignerAvatar(String dispatchDesignerAvatar) {
		this.dispatchDesignerAvatar = dispatchDesignerAvatar;
	}

	public String getSelectedDesignerAvatar() {
		return selectedDesignerAvatar;
	}

	public void setSelectedDesignerAvatar(String selectedDesignerAvatar) {
		this.selectedDesignerAvatar = selectedDesignerAvatar;
	}

	public String getDispatchDesignerThreadId() {
		return dispatchDesignerThreadId;
	}

	public void setDispatchDesignerThreadId(String dispatchDesignerThreadId) {
		this.dispatchDesignerThreadId = dispatchDesignerThreadId;
	}

	public String getSelectedDesignerThreadId() {
		return selectedDesignerThreadId;
	}

	public void setSelectedDesignerThreadId(String selectedDesignerThreadId) {
		this.selectedDesignerThreadId = selectedDesignerThreadId;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getIsBeishu() {
		return isBeishu;
	}

	public void setIsBeishu(String isBeishu) {
		this.isBeishu = isBeishu;
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

	public String getConsumerAvatar() {
		return consumerAvatar;
	}

	public void setConsumerAvatar(String consumerAvatar) {
		this.consumerAvatar = consumerAvatar;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
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

	public String getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(String isSubmit) {
		this.isSubmit = isSubmit;
	}

}
