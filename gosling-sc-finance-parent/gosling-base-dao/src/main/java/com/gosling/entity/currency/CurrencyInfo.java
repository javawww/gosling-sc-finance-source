package com.gosling.entity.currency;

import java.io.Serializable;

/**
 * 
 * @类描述：币种信息  关联用户   一对一
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.currency
 * @类名称：CurrencyInfo
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:05:14
 */
@SuppressWarnings("serial")
public class CurrencyInfo implements Serializable {

	private java.lang.Integer    			id; //主键
	private java.math.BigDecimal 			dynWallet;//动态钱包
	private java.math.BigDecimal 			statDJWallet;//静态冻结钱包
	private java.math.BigDecimal 			statJDWallet;//静态解冻钱包
	private java.math.BigDecimal 			seedsPenn;//种子积分
	private java.math.BigDecimal			manaMoney;//管家月俸
	private java.math.BigDecimal 			kidMoney;//神童日俸
	private java.lang.String 				memNum;//关联用户编码
	private java.lang.Integer 				memid;//关联用户主键ID
	
	//add -----------金姐项目
	private java.math.BigDecimal 			activPenn;//激活积分  对应类型  1
	private java.math.BigDecimal 			teamPoints;//团队收益  对应类型  2
	private java.math.BigDecimal			crashPoints;//现金积分  对应类型 3
	
	public java.math.BigDecimal getTeamPoints() {
		return teamPoints;
	}
	public void setTeamPoints(java.math.BigDecimal teamPoints) {
		this.teamPoints = teamPoints;
	}
	public java.math.BigDecimal getCrashPoints() {
		return crashPoints;
	}
	public void setCrashPoints(java.math.BigDecimal crashPoints) {
		this.crashPoints = crashPoints;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.math.BigDecimal getActivPenn() {
		return activPenn;
	}
	public void setActivPenn(java.math.BigDecimal activPenn) {
		this.activPenn = activPenn;
	}
	public java.math.BigDecimal getDynWallet() {
		return dynWallet;
	}
	public void setDynWallet(java.math.BigDecimal dynWallet) {
		this.dynWallet = dynWallet;
	}

	public java.lang.String getMemNum() {
		return memNum;
	}
	public void setMemNum(java.lang.String memNum) {
		this.memNum = memNum;
	}
	public java.lang.Integer getMemid() {
		return memid;
	}
	public void setMemid(java.lang.Integer memid) {
		this.memid = memid;
	}
	public java.math.BigDecimal getStatDJWallet() {
		return statDJWallet;
	}
	public void setStatDJWallet(java.math.BigDecimal statDJWallet) {
		this.statDJWallet = statDJWallet;
	}
	public java.math.BigDecimal getStatJDWallet() {
		return statJDWallet;
	}
	public void setStatJDWallet(java.math.BigDecimal statJDWallet) {
		this.statJDWallet = statJDWallet;
	}
	public java.math.BigDecimal getSeedsPenn() {
		return seedsPenn;
	}
	public void setSeedsPenn(java.math.BigDecimal seedsPenn) {
		this.seedsPenn = seedsPenn;
	}
	public java.math.BigDecimal getManaMoney() {
		return manaMoney;
	}
	public void setManaMoney(java.math.BigDecimal manaMoney) {
		this.manaMoney = manaMoney;
	}
	public java.math.BigDecimal getKidMoney() {
		return kidMoney;
	}
	public void setKidMoney(java.math.BigDecimal kidMoney) {
		this.kidMoney = kidMoney;
	}
	
}
