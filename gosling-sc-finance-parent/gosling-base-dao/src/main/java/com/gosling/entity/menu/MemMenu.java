package com.gosling.entity.menu;

import java.io.Serializable;
/**
 * 
 * @类描述：会员菜单关联
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.menu
 * @类名称：MemMenu
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:20:29
 */
@SuppressWarnings("serial")
public class MemMenu implements Serializable{

	
	private java.lang.Integer    			id; //主键
	private java.lang.Integer    			memId; //关联会员ID
	private java.lang.Integer    			menuId; //关联菜单ID
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
	public java.lang.Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(java.lang.Integer menuId) {
		this.menuId = menuId;
	}
	
	
	

}
