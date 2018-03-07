package com.gosling.entity.log;

import java.io.Serializable;
/**
 * 
 * @类描述：充值OR取现记录
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.log
 * @类名称：CZQXLog
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:09:59
 */
@SuppressWarnings("serial")
public class CZQXLog implements Serializable {

	
	private java.lang.Integer  				id;//主键
	private java.lang.Integer 				czqxType;//充值类型   
	private java.lang.String 				czqxMark;//备注 充值备注 取现备注 玩家附加充值、取现相关信息
	private java.lang.Integer 				czqxWay;//充值方式  0线下打款 目前仅此一种  取现方式没有
	private java.math.BigDecimal 			czqxSalar;//充值 取现 金额  1:1比例充值
	private java.util.Date 					czqxTime;//充值时间  取现时间  即创建时间
	private java.lang.Integer 				czqxtatus;//充值状态  取现状态 0 审核中 1交易完成 2交易失败
	private java.math.BigDecimal			qxPoundSalar;//提现手续费 即平台手续费 计算得出
	private java.math.BigDecimal 			qxRealSalar;//提现实际到账金额  = 提现金额-提现手续费
	private java.lang.Integer 				memId;//外键 关联充值提现的当事人
	private java.lang.String 				memNo;//关联 当前操作用户
	private java.lang.Integer 				optType;//操作类型 1充值操作 2取现操作
	
	private java.lang.String 				showTime;//显示充值取现 的 时间   不与数据库交互
	private java.lang.String 				showState;//显示充值取现的 状态  不与数据库交互
	private java.lang.String 				showType;//显示充值取现的币种类型  不与数据库交互
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getCzqxType() {
		return czqxType;
	}
	public void setCzqxType(java.lang.Integer czqxType) {
		this.czqxType = czqxType;
	}
	public java.lang.String getCzqxMark() {
		return czqxMark;
	}
	public void setCzqxMark(java.lang.String czqxMark) {
		this.czqxMark = czqxMark;
	}
	public java.lang.Integer getCzqxWay() {
		return czqxWay;
	}
	public void setCzqxWay(java.lang.Integer czqxWay) {
		this.czqxWay = czqxWay;
	}
	public java.math.BigDecimal getCzqxSalar() {
		return czqxSalar;
	}
	public void setCzqxSalar(java.math.BigDecimal czqxSalar) {
		this.czqxSalar = czqxSalar;
	}
	public java.util.Date getCzqxTime() {
		return czqxTime;
	}
	public void setCzqxTime(java.util.Date czqxTime) {
		this.czqxTime = czqxTime;
	}
	public java.lang.Integer getCzqxtatus() {
		return czqxtatus;
	}
	public void setCzqxtatus(java.lang.Integer czqxtatus) {
		this.czqxtatus = czqxtatus;
	}
	public java.math.BigDecimal getQxPoundSalar() {
		return qxPoundSalar;
	}
	public void setQxPoundSalar(java.math.BigDecimal qxPoundSalar) {
		this.qxPoundSalar = qxPoundSalar;
	}
	public java.math.BigDecimal getQxRealSalar() {
		return qxRealSalar;
	}
	public void setQxRealSalar(java.math.BigDecimal qxRealSalar) {
		this.qxRealSalar = qxRealSalar;
	}
	public java.lang.Integer getMemId() {
		return memId;
	}
	public void setMemId(java.lang.Integer memId) {
		this.memId = memId;
	}
	public java.lang.String getMemNo() {
		return memNo;
	}
	public void setMemNo(java.lang.String memNo) {
		this.memNo = memNo;
	}
	public java.lang.Integer getOptType() {
		return optType;
	}
	public void setOptType(java.lang.Integer optType) {
		this.optType = optType;
	}
	public java.lang.String getShowTime() {
		return showTime;
	}
	public void setShowTime(java.lang.String showTime) {
		this.showTime = showTime;
	}
	public java.lang.String getShowState() {
		return showState;
	}
	public void setShowState(java.lang.String showState) {
		this.showState = showState;
	}
	public java.lang.String getShowType() {
		return showType;
	}
	public void setShowType(java.lang.String showType) {
		this.showType = showType;
	}
	
	


}
