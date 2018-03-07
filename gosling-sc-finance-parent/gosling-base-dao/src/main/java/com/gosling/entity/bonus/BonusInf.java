package com.gosling.entity.bonus;

import java.io.Serializable;
/**
 * 
 * @类描述：奖金明细
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.bonus
 * @类名称：BonusInf
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:08:04
 */
@SuppressWarnings("serial")
public class BonusInf implements Serializable{

	//层奖、推荐奖：共有属性
	private java.lang.Integer    			id; //主键
	private java.lang.String 				bonusDesc;//奖金描述  示例  来源A00005编号
	private java.lang.Integer 				bonusStatus;//奖金状态 1未结算 2已结算
	private java.lang.Integer				bonusType;  //奖金类型   1 层奖(50元)    2 推荐奖(200元)
	private java.math.BigDecimal 			bonusSalar;   //奖金金额  示例 500.64
	private java.util.Date  				bonusTime;  //生成时间
	private java.lang.Integer 				bonusId;// 关联 奖金一方  
	private java.lang.String 				memNum;//关联  会员
	
	public java.math.BigDecimal getBonusSalar() {
		return bonusSalar;
	}

	public void setBonusSalar(java.math.BigDecimal bonusSalar) {
		this.bonusSalar = bonusSalar;
	}

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getBonusDesc() {
		return bonusDesc;
	}

	public void setBonusDesc(java.lang.String bonusDesc) {
		this.bonusDesc = bonusDesc;
	}

	public java.lang.Integer getBonusStatus() {
		return bonusStatus;
	}

	public void setBonusStatus(java.lang.Integer bonusStatus) {
		this.bonusStatus = bonusStatus;
	}

	public java.lang.Integer getBonusType() {
		return bonusType;
	}

	public void setBonusType(java.lang.Integer bonusType) {
		this.bonusType = bonusType;
	}

	public java.util.Date getBonusTime() {
		return bonusTime;
	}

	public void setBonusTime(java.util.Date bonusTime) {
		this.bonusTime = bonusTime;
	}

	public java.lang.Integer getBonusId() {
		return bonusId;
	}

	public void setBonusId(java.lang.Integer bonusId) {
		this.bonusId = bonusId;
	}

	public java.lang.String getMemNum() {
		return memNum;
	}

	public void setMemNum(java.lang.String memNum) {
		this.memNum = memNum;
	}

}
