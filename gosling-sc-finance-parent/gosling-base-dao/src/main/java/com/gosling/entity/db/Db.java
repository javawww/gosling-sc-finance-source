package com.gosling.entity.db;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @类描述：数据库备份
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.db
 * @类名称：Db
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:11:51
 */
@SuppressWarnings("serial")
public class Db implements Serializable{

	private Integer id;		//主键
	private String name;	//备份名字
	private String message;	//备注信息
	private Date   createTime;	//备份日期
	private String location;//备份所在的位置
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	 
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
