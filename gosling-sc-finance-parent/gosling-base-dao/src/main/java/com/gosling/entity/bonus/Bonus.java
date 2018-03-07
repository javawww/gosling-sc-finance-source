package com.gosling.entity.bonus;

import java.io.Serializable;

/**
 * 
 * @类描述：奖金
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.bonus
 * @类名称：Bonus
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:07:07
 */
@SuppressWarnings("serial")
public class Bonus implements Serializable{
	
	private  java.lang.Integer   			id;//主键
	private  java.util.Date 	 			jsTime;//结算时间
	private  java.math.BigDecimal			layerBonus;//层奖
	private  java.math.BigDecimal			tjrBonus;//推荐奖
	private  java.math.BigDecimal			totalBonus;//总收益
	private  java.lang.String 				memNum;//会员编号 
	
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.util.Date getJsTime() {
		return jsTime;
	}
	public void setJsTime(java.util.Date jsTime) {
		this.jsTime = jsTime;
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
	public java.math.BigDecimal getTotalBonus() {
		return totalBonus;
	}
	public void setTotalBonus(java.math.BigDecimal totalBonus) {
		this.totalBonus = totalBonus;
	}
	public java.lang.String getMemNum() {
		return memNum;
	}
	public void setMemNum(java.lang.String memNum) {
		this.memNum = memNum;
	}
	
	
	
	

}
