package com.gosling.entity.member;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @类描述：会员
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.member
 * @类名称：Member
 * @创建人：Administrator
 * @创建时间：2018年2月28日下午4:22:06
 */
@SuppressWarnings("serial")
public class Member implements Serializable{

	private java.lang.Integer    			id; //主键
	private java.lang.String 				memNum;//会员编号
	private java.lang.Integer   			jhState; //激活状态  1未激活  2已激活
	private java.lang.Integer   			gjLevel; //管家等级  1普通管家  2超级管家
	private java.lang.String 				realName;//真实姓名
	private java.lang.String 				teleNum;//手机号码
	private java.lang.String 				tjrNum;//推荐人编号
	private java.lang.Integer 				tjrId;//推荐人ID
	private java.util.Date       			registTime;//注册时间
	private java.util.Date       			jhTime;//激活时间
	private java.lang.Integer   			djState; //冻结状态  1解冻  2冻结
	private java.lang.Integer   			roleState; //角色类型  1普通会员  2超级管理员
	private java.lang.String 				weichat;//微信账号
	private java.lang.String 				alipay;//支付宝账号
	private java.lang.String 				alipayName;//支付宝昵称
	private java.lang.String 				loginPwd;//登录密码
	private java.lang.String 				tradePwd;//交易密码
	private java.lang.String 				bankNum;//银行卡号
	private java.lang.Integer   			bankType; //银行卡类型  1中国工商银行、2中国建设银行、3中国银行、4中国农业银行、5交通银行
	private java.lang.String 				khhAddress;//开户行地址
	private java.lang.String 				khhkName;//开户行名称 
	//追加字段
	private java.lang.String 				adloginPwd;//后台登录密码 即管理员
	private java.lang.Integer 				protectQuest;//密保问题 1最喜欢看的电影是什么?2曾经去过最远的地方是? 2父亲的生日日期是多少号?
	private java.lang.String 				protectAnswe;//密保答案
	
	private String 							jhShowTime;	//给前端页面看的激活时间
	private String 							showRegistTime;	//给前端页面看的激活时间
	private String 							payPic;	//图片存放的位置和图片名，如：\\goldentree\\upload\\20170619\\51354351.jpg
	
	//金姐项目    新增
	
	private java.lang.String				jiedianNum;//节点人编号
	private java.lang.Integer				jiedianId;//接点人ID
	private java.lang.String				areaType;//会员所属区域   值有：A区   B区
	private java.lang.Integer				isLayerOver;//是否出局  1在局  2出局    出局的会员将停止发放层奖
	
	private java.lang.Integer 				ztAmounts;//推荐人数量
	private java.lang.Integer             	teamAmounts;//团队数量 即直接推荐和间接推荐和本身数量和
	private java.lang.Integer				aCounts;//A区人数
	private java.lang.Integer				bCounts;//B区人数
	
	//其他字段需求
	private  Member							parent;//父节点
	private List<Member>					nodes;//儿子节点
	private int 							level;//深度
	
	private java.lang.Integer               floor;
	private java.lang.Integer				location;
	private java.lang.Integer				leftChildId;
	private java.lang.Integer				rightChildId;
	
	
	
	public java.lang.Integer getLeftChildId() {
		return leftChildId;
	}
	public void setLeftChildId(java.lang.Integer leftChildId) {
		this.leftChildId = leftChildId;
	}
	public java.lang.Integer getRightChildId() {
		return rightChildId;
	}
	public void setRightChildId(java.lang.Integer rightChildId) {
		this.rightChildId = rightChildId;
	}
	public java.lang.Integer getFloor() {
		return floor;
	}
	public void setFloor(java.lang.Integer floor) {
		this.floor = floor;
	}
	public java.lang.Integer getLocation() {
		return location;
	}
	public void setLocation(java.lang.Integer location) {
		this.location = location;
	}
	public String getPayPic() {
		return payPic;
	}
	public void setPayPic(String payPic) {
		this.payPic = payPic;
	}
	public String getShowRegistTime() {
		return showRegistTime;
	}
	public void setShowRegistTime(String showRegistTime) {
		this.showRegistTime = showRegistTime;
	}
	public String getJhShowTime() {
		return jhShowTime;
	}
	public void setJhShowTime(String jhShowTime) {
		this.jhShowTime = jhShowTime;
	}
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
	public java.lang.Integer getJhState() {
		return jhState;
	}
	public void setJhState(java.lang.Integer jhState) {
		this.jhState = jhState;
	}
	public java.lang.Integer getGjLevel() {
		return gjLevel;
	}
	public void setGjLevel(java.lang.Integer gjLevel) {
		this.gjLevel = gjLevel;
	}
	public java.lang.String getRealName() {
		return realName;
	}
	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}
	public java.lang.String getTeleNum() {
		return teleNum;
	}
	public void setTeleNum(java.lang.String teleNum) {
		this.teleNum = teleNum;
	}
	public java.lang.String getTjrNum() {
		return tjrNum;
	}
	public void setTjrNum(java.lang.String tjrNum) {
		this.tjrNum = tjrNum;
	}
	
	public java.lang.Integer getTjrId() {
		return tjrId;
	}
	public void setTjrId(java.lang.Integer tjrId) {
		this.tjrId = tjrId;
	}
	public java.util.Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(java.util.Date registTime) {
		this.registTime = registTime;
	}
	public java.util.Date getJhTime() {
		return jhTime;
	}
	public void setJhTime(java.util.Date jhTime) {
		this.jhTime = jhTime;
	}
	public java.lang.Integer getDjState() {
		return djState;
	}
	public void setDjState(java.lang.Integer djState) {
		this.djState = djState;
	}
	public java.lang.Integer getRoleState() {
		return roleState;
	}
	public void setRoleState(java.lang.Integer roleState) {
		this.roleState = roleState;
	}
	public java.lang.String getWeichat() {
		return weichat;
	}
	public void setWeichat(java.lang.String weichat) {
		this.weichat = weichat;
	}
	public java.lang.String getAlipay() {
		return alipay;
	}
	public void setAlipay(java.lang.String alipay) {
		this.alipay = alipay;
	}
	public java.lang.String getAlipayName() {
		return alipayName;
	}
	public void setAlipayName(java.lang.String alipayName) {
		this.alipayName = alipayName;
	}
	public java.lang.String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(java.lang.String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public java.lang.String getTradePwd() {
		return tradePwd;
	}
	public void setTradePwd(java.lang.String tradePwd) {
		this.tradePwd = tradePwd;
	}
	public java.lang.String getBankNum() {
		return bankNum;
	}
	public void setBankNum(java.lang.String bankNum) {
		this.bankNum = bankNum;
	}
	public java.lang.Integer getBankType() {
		return bankType;
	}
	public void setBankType(java.lang.Integer bankType) {
		this.bankType = bankType;
	}
	public java.lang.String getKhhAddress() {
		return khhAddress;
	}
	public void setKhhAddress(java.lang.String khhAddress) {
		this.khhAddress = khhAddress;
	}
	public java.lang.String getKhhkName() {
		return khhkName;
	}
	public void setKhhkName(java.lang.String khhkName) {
		this.khhkName = khhkName;
	}
	public java.lang.String getAdloginPwd() {
		return adloginPwd;
	}
	public void setAdloginPwd(java.lang.String adloginPwd) {
		this.adloginPwd = adloginPwd;
	}
	public java.lang.Integer getZtAmounts() {
		return ztAmounts;
	}
	public void setZtAmounts(java.lang.Integer ztAmounts) {
		this.ztAmounts = ztAmounts;
	}
	public java.lang.Integer getTeamAmounts() {
		return teamAmounts;
	}
	public void setTeamAmounts(java.lang.Integer teamAmounts) {
		this.teamAmounts = teamAmounts;
	}
	public java.lang.Integer getProtectQuest() {
		return protectQuest;
	}
	public void setProtectQuest(java.lang.Integer protectQuest) {
		this.protectQuest = protectQuest;
	}
	public java.lang.String getProtectAnswe() {
		return protectAnswe;
	}
	public void setProtectAnswe(java.lang.String protectAnswe) {
		this.protectAnswe = protectAnswe;
	}
	public java.lang.String getJiedianNum() {
		return jiedianNum;
	}
	public void setJiedianNum(java.lang.String jiedianNum) {
		this.jiedianNum = jiedianNum;
	}
	public java.lang.Integer getJiedianId() {
		return jiedianId;
	}
	public void setJiedianId(java.lang.Integer jiedianId) {
		this.jiedianId = jiedianId;
	}
	public java.lang.String getAreaType() {
		return areaType;
	}
	public void setAreaType(java.lang.String areaType) {
		this.areaType = areaType;
	}
	public java.lang.Integer getIsLayerOver() {
		return isLayerOver;
	}
	public void setIsLayerOver(java.lang.Integer isLayerOver) {
		this.isLayerOver = isLayerOver;
	}
	 
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public java.lang.Integer getaCounts() {
		return aCounts;
	}
	public void setaCounts(java.lang.Integer aCounts) {
		this.aCounts = aCounts;
	}
	public java.lang.Integer getbCounts() {
		return bCounts;
	}
	public void setbCounts(java.lang.Integer bCounts) {
		this.bCounts = bCounts;
	}
	public Member getParent() {
		return parent;
	}
	public void setParent(Member parent) {
		this.parent = parent;
	}
	public List<Member> getNodes() {
		return nodes;
	}
	public void setNodes(List<Member> nodes) {
		this.nodes = nodes;
	}
	
	
}
