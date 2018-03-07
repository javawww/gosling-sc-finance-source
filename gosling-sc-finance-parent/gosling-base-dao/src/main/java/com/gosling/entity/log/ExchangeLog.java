package com.gosling.entity.log;

import java.io.Serializable;

/**
 * 
 * @类描述：积分兑换OR互转记录
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.log
 * @类名称：ExchangeLog
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:13:43
 */
@SuppressWarnings("serial")
public class ExchangeLog implements Serializable{
	//互转情况
	private java.lang.Integer 				id;//主键
	private java.lang.String 				sendMemNum;//发钱人的会员编号 玩家互转所需
	private java.lang.Integer 				sendMemId;//外键 关联操作的当事人的ID，发钱人的id
	private java.lang.String 				receMemNum;//收钱人的会员编号 玩家互转所需***************
	private java.lang.Integer 				hzhType;//互转币种类型 5种子积分 6激活积分***************
	
	//兑换情况
	private java.lang.Integer 				zhhMemId;//转换币种操作人的id
	private java.lang.Integer 				zhhFromType;//转换币种类型  即源类型:5现金积分 0团队收益 2空##############
	private java.lang.Integer 				zhhToType;//兑换币种类型 即目标类型:5激活积分 3 4 6##############
	
	//共有属性
	private java.math.BigDecimal 			money;//转换数量***************##############
	private java.util.Date 					createTime;//互转时间 即创建时间
	private String 							showCreateTime;	//给前台看的互转时间
	private Integer 						optType;	//操作类型，0会员互转    1玩家转换
	
	
	
	public java.lang.Integer getZhhMemId() {
		return zhhMemId;
	}
	public void setZhhMemId(java.lang.Integer zhhMemId) {
		this.zhhMemId = zhhMemId;
	}
	public java.lang.String getSendMemNum() {
		return sendMemNum;
	}
	public void setSendMemNum(java.lang.String sendMemNum) {
		this.sendMemNum = sendMemNum;
	}
	public Integer getOptType() {
		return optType;
	}
	public void setOptType(Integer optType) {
		this.optType = optType;
	}
	public java.lang.String getReceMemNum() {
		return receMemNum;
	}
	public void setReceMemNum(java.lang.String receMemNum) {
		this.receMemNum = receMemNum;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getSendMemId() {
		return sendMemId;
	}
	public void setSendMemId(java.lang.Integer sendMemId) {
		this.sendMemId = sendMemId;
	}
	public java.lang.Integer getHzhType() {
		return hzhType;
	}
	public void setHzhType(java.lang.Integer hzhType) {
		this.hzhType = hzhType;
	}
	public java.lang.Integer getZhhFromType() {
		return zhhFromType;
	}
	public void setZhhFromType(java.lang.Integer zhhFromType) {
		this.zhhFromType = zhhFromType;
	}
	public java.lang.Integer getZhhToType() {
		return zhhToType;
	}
	public void setZhhToType(java.lang.Integer zhhToType) {
		this.zhhToType = zhhToType;
	}
	public java.math.BigDecimal getMoney() {
		return money;
	}
	public void setMoney(java.math.BigDecimal money) {
		this.money = money;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public String getShowCreateTime() {
		return showCreateTime;
	}
	public void setShowCreateTime(String showCreateTime) {
		this.showCreateTime = showCreateTime;
	}
	

}
