package com.gosling.entity.log;

import java.io.Serializable;

/**
 * 
 * @类描述：币种明细
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.log
 * @类名称：LogInf
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:17:54
 */
@SuppressWarnings("serial")
public class LogInf implements Serializable{

	
	private java.lang.Integer 			id;//主键
	private java.util.Date				createTime;//创建时间
	private java.lang.Integer			currencyType;//币种类型  1、激活积分2、团队收益3、现金收益
	private java.math.BigDecimal 		salary;//金额  购买数量  有正数 表示收入  有负数 表示支出
	private java.math.BigDecimal 		origSalary;//原始余额
	private java.math.BigDecimal 		preSalary;//当前余额 
	private java.lang.String 			optDesc;//操作描述
	private java.lang.String 			memNum;//关联会员编号
	private java.lang.Integer 		    logPid;//关联LogEntity主键  一对多关联关系	
	
	
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.lang.Integer getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(java.lang.Integer currencyType) {
		this.currencyType = currencyType;
	}
	public java.math.BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(java.math.BigDecimal salary) {
		this.salary = salary;
	}
	public java.math.BigDecimal getOrigSalary() {
		return origSalary;
	}
	public void setOrigSalary(java.math.BigDecimal origSalary) {
		this.origSalary = origSalary;
	}
	public java.math.BigDecimal getPreSalary() {
		return preSalary;
	}
	public void setPreSalary(java.math.BigDecimal preSalary) {
		this.preSalary = preSalary;
	}
	public java.lang.String getOptDesc() {
		return optDesc;
	}
	public void setOptDesc(java.lang.String optDesc) {
		this.optDesc = optDesc;
	}
	public java.lang.Integer getLogPid() {
		return logPid;
	}
	public void setLogPid(java.lang.Integer logPid) {
		this.logPid = logPid;
	}
	public java.lang.String getMemNum() {
		return memNum;
	}
	public void setMemNum(java.lang.String memNum) {
		this.memNum = memNum;
	}
	
	


}
