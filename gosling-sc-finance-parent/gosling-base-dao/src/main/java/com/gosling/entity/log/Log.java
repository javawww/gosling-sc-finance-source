package com.gosling.entity.log;

import java.io.Serializable;
/**
 * 
 * @类描述：收支明细
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.log
 * @类名称：Log
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:17:10
 */
@SuppressWarnings("serial")
public class Log implements Serializable{

	private   java.lang.Integer 				id; //主键
	
	private   java.util.Date 					createTime;//创建时间
	
	private   java.lang.String 					memberNum;//关联变化的会员编号
	
	private  java.math.BigDecimal				layerBonus;//层奖     对应团队收益
	private  java.math.BigDecimal				tjrBonus;//推荐奖     对应现金积分
	private  java.math.BigDecimal				activeBonus;//激活积分   
	private  java.math.BigDecimal				totalBonus;//总收益

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

	public java.lang.String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(java.lang.String memberNum) {
		this.memberNum = memberNum;
	}

	public java.math.BigDecimal getLayerBonus() {
		return layerBonus;
	}

	public void setLayerBonus(java.math.BigDecimal layerBonus) {
		this.layerBonus = layerBonus;
	}

	public java.math.BigDecimal getTjrBonus() {
		return tjrBonus;
	}

	public void setTjrBonus(java.math.BigDecimal tjrBonus) {
		this.tjrBonus = tjrBonus;
	}

	public java.math.BigDecimal getActiveBonus() {
		return activeBonus;
	}

	public void setActiveBonus(java.math.BigDecimal activeBonus) {
		this.activeBonus = activeBonus;
	}

	public java.math.BigDecimal getTotalBonus() {
		return totalBonus;
	}

	public void setTotalBonus(java.math.BigDecimal totalBonus) {
		this.totalBonus = totalBonus;
	}
	
	
	
	
	
	

}
