package com.gosling.entity.email;

import java.io.Serializable;

/**
 * 
 * @类描述：邮件
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.email
 * @类名称：EmailMsg
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:12:48
 */
@SuppressWarnings("serial")
public class EmailMsg implements Serializable{

	
	private java.lang.Integer    			id; //主键
	private java.lang.String  				msgSubject;//邮件主题 邮件标题
	private java.lang.String  				msgContent;//邮件正文 邮件内容 html编辑器
	private java.lang.String  				memNum;//编辑该邮件的会员编号
	private java.lang.Integer    			sendid; //外键 关联发件人 当前登录用户
	private java.lang.String    			receids; //外键 关联收件人 一或多个 示例1,2,3 发送至 张三,李四,王五
	private java.util.Date       			sendTime;//发送时间 即 创建时间
	private java.lang.Integer    			msgStatus; //查看状态 0未读邮件 1已读邮件
	private java.lang.Integer 				msgType;//邮件类型 0注册问题 1安全问题 2账号问题3交易问题 4其他问题
	
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getMsgSubject() {
		return msgSubject;
	}
	public void setMsgSubject(java.lang.String msgSubject) {
		this.msgSubject = msgSubject;
	}
	public java.lang.String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(java.lang.String msgContent) {
		this.msgContent = msgContent;
	}
	public java.lang.Integer getSendid() {
		return sendid;
	}
	public void setSendid(java.lang.Integer sendid) {
		this.sendid = sendid;
	}
	public java.lang.String getReceids() {
		return receids;
	}
	public void setReceids(java.lang.String receids) {
		this.receids = receids;
	}
	public java.util.Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(java.util.Date sendTime) {
		this.sendTime = sendTime;
	}
	public java.lang.Integer getMsgStatus() {
		return msgStatus;
	}
	public void setMsgStatus(java.lang.Integer msgStatus) {
		this.msgStatus = msgStatus;
	}
	public java.lang.String getMemNum() {
		return memNum;
	}
	public void setMemNum(java.lang.String memNum) {
		this.memNum = memNum;
	}
	public java.lang.Integer getMsgType() {
		return msgType;
	}
	public void setMsgType(java.lang.Integer msgType) {
		this.msgType = msgType;
	}
	
	
	
	
	


}
