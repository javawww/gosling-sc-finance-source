package com.gosling.entity.currency;

import java.io.Serializable;
/**
 * 
 * @类描述：充值
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.currency
 * @类名称：Recharge
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:23:31
 */
@SuppressWarnings("serial")
public class Recharge implements Serializable{


	private java.lang.Integer    			id; //主键
	private java.lang.String 	     		memNum;//会员编号 
	private java.math.BigDecimal 			recharge;   //充值金额  示例 500或 -200 对应增加 减少
	private java.lang.Integer				rechaType;//充值币种 0激活积分 1 2 3 等等
	private java.lang.String 				rechaMark;//充值备注
	private java.lang.Integer 				memid;//外键  针对后台充值操作的管理员ID
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getMemNum() {
		return memNum;
	}
	public void setMemNum(java.lang.String memNum) {
		this.memNum = memNum;
	}
	public java.math.BigDecimal getRecharge() {
		return recharge;
	}
	public void setRecharge(java.math.BigDecimal recharge) {
		this.recharge = recharge;
	}
	public java.lang.Integer getRechaType() {
		return rechaType;
	}
	public void setRechaType(java.lang.Integer rechaType) {
		this.rechaType = rechaType;
	}
	public java.lang.String getRechaMark() {
		return rechaMark;
	}
	public void setRechaMark(java.lang.String rechaMark) {
		this.rechaMark = rechaMark;
	}
	public java.lang.Integer getMemid() {
		return memid;
	}
	public void setMemid(java.lang.Integer memid) {
		this.memid = memid;
	}
	
	

}
