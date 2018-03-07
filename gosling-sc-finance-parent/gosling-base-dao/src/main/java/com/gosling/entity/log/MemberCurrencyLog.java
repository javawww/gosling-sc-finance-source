package com.gosling.entity.log;

import java.io.Serializable;

/**
 * 
 * @类描述：币种变更日志
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.log
 * @类名称：MemberCurrencyLog
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:18:50
 */
@SuppressWarnings("serial")
public class MemberCurrencyLog implements Serializable {
	
	private java.lang.Integer			id;//主键
	private java.lang.Integer 			memId;//关联会员ID
	private java.lang.String			memNum;//关联会员编号
	
	//会员之间 转账  即 会员互转
	private java.lang.String 			toMemNum;//转入会员编号
	private java.lang.String			fromMemNum;//转出会员编号
	private java.lang.Integer 			currenType;//互转  币种类型   1、激活积分 2、团队收益 3、现金收益
	
	//币种兑换  
	private java.lang.Integer 			toCurrenType;//转入币种类型 
	private java.lang.Integer 			fromCurrenType;//转出币种类型
	
	//会员充值
	private java.lang.Integer			rechargeType;//充值类型
	private java.util.Date				checkedTime;//审核时间
	private java.lang.String 			certificatePic;//凭证图片地址
	private java.lang.String 			rechargeMark;//充值备注
	private java.lang.Integer 			rechargeStatus;//充值状态  1提交审核 2审核通过 3审核失败
	
	//会员提现申请
	private java.lang.Integer			txType;//提现类型
	private java.lang.Integer			txStatus;//提现状态 1提交审核 默认 2审核通过 3审核失败
	private java.math.BigDecimal		realSalary;//到账金额
	
	//金额
	private java.math.BigDecimal 		salary;//金额  购买数量
	
	//操作描述
	private java.lang.String 			optDesc;//操作描述
	//创建时间
	private java.util.Date 				createTime;//创建时间
	
	//操作类型
	private java.lang.Integer			optType;//操作类型 1会员转账  2会员充值 3货币兑换4提现申请 
	
	
	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getMemId() {
		return memId;
	}

	public void setMemId(java.lang.Integer memId) {
		this.memId = memId;
	}

	public java.lang.String getMemNum() {
		return memNum;
	}

	public void setMemNum(java.lang.String memNum) {
		this.memNum = memNum;
	}

	public java.lang.String getToMemNum() {
		return toMemNum;
	}

	public void setToMemNum(java.lang.String toMemNum) {
		this.toMemNum = toMemNum;
	}

	public java.lang.String getFromMemNum() {
		return fromMemNum;
	}

	public void setFromMemNum(java.lang.String fromMemNum) {
		this.fromMemNum = fromMemNum;
	}

	public java.lang.Integer getCurrenType() {
		return currenType;
	}

	public void setCurrenType(java.lang.Integer currenType) {
		this.currenType = currenType;
	}

	public java.lang.Integer getToCurrenType() {
		return toCurrenType;
	}

	public void setToCurrenType(java.lang.Integer toCurrenType) {
		this.toCurrenType = toCurrenType;
	}

	public java.lang.Integer getFromCurrenType() {
		return fromCurrenType;
	}

	public void setFromCurrenType(java.lang.Integer fromCurrenType) {
		this.fromCurrenType = fromCurrenType;
	}

	public java.lang.Integer getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(java.lang.Integer rechargeType) {
		this.rechargeType = rechargeType;
	}

	public java.util.Date getCheckedTime() {
		return checkedTime;
	}

	public void setCheckedTime(java.util.Date checkedTime) {
		this.checkedTime = checkedTime;
	}

	public java.lang.String getCertificatePic() {
		return certificatePic;
	}

	public void setCertificatePic(java.lang.String certificatePic) {
		this.certificatePic = certificatePic;
	}

	public java.lang.String getRechargeMark() {
		return rechargeMark;
	}

	public void setRechargeMark(java.lang.String rechargeMark) {
		this.rechargeMark = rechargeMark;
	}

	public java.lang.Integer getRechargeStatus() {
		return rechargeStatus;
	}

	public void setRechargeStatus(java.lang.Integer rechargeStatus) {
		this.rechargeStatus = rechargeStatus;
	}

	public java.math.BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(java.math.BigDecimal salary) {
		this.salary = salary;
	}

	public java.lang.String getOptDesc() {
		return optDesc;
	}

	public void setOptDesc(java.lang.String optDesc) {
		this.optDesc = optDesc;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.lang.Integer getOptType() {
		return optType;
	}

	public void setOptType(java.lang.Integer optType) {
		this.optType = optType;
	}

	public java.lang.Integer getTxType() {
		return txType;
	}

	public void setTxType(java.lang.Integer txType) {
		this.txType = txType;
	}

	public java.lang.Integer getTxStatus() {
		return txStatus;
	}

	public void setTxStatus(java.lang.Integer txStatus) {
		this.txStatus = txStatus;
	}

	public java.math.BigDecimal getRealSalary() {
		return realSalary;
	}

	public void setRealSalary(java.math.BigDecimal realSalary) {
		this.realSalary = realSalary;
	}
	

}
