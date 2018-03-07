package com.gosling.entity.system;

import java.io.Serializable;
/**
 * 
 * @类描述：系统参数配置
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.entity.system
 * @类名称：ParamConf
 * @创建人：Administrator
 * @创建时间：2018年3月7日上午11:22:40
 */
@SuppressWarnings("serial")
public class ParamConf implements Serializable{

	
	private java.lang.Integer    			id; //主键
	private java.math.BigDecimal 			jhIntegral;//激活积分 激活普通会员使用 示例50元
	private java.math.BigDecimal 			yszzIntegral;//银树种植一颗消耗的种子积分 示例200元 
	private java.math.BigDecimal 			jszzIntegral;//金树种植一颗消耗的种子积分 示例1000元
	private java.math.BigDecimal 			ystqIntegral;//银树日分红每次偷取额度 示例 0.2元
	private java.math.BigDecimal 			jstqIntegral;//金树日分红每次偷取额度 示例0.5元
	private java.lang.Integer 				ystqCount;//银树日分红可被偷取次数 默认无管家 示例10次 该字段无效
	private java.lang.Integer 				jstqCount;//金树日分红可被偷取次数 默认无管家 示例10次 该字段无效
	private java.math.BigDecimal 			wgjCount;//金树 银树 无管家状态可被偷取次数 示例10次
	private java.math.BigDecimal 			ptgjCount;//金树 银树 有管家状态可被偷取次数 示例8次
	private java.math.BigDecimal 			cjgjCount;//超级管家偷取次数  该字段无效
	private java.math.BigDecimal 			shtMoney;//神童日俸 针对神童是否处于工作状态的限定
	private java.math.BigDecimal 			ptgjMoney;//管家月俸  针对管家是否处于工作状态的限定
	private java.math.BigDecimal 			cjgjMoney;//超级管家月俸  该字段无效
	private java.math.BigDecimal 			ysCapacity;//银树日分红收益产能 示例10元
	private java.math.BigDecimal 			jsCapacity;//金树日分红收益产能 示例100元
	private java.lang.Integer 				ysCapaCycle;//银树日分红产能周期 分钟 示例5分钟
	private java.lang.Integer 				jsCapaCycle;//金树日分红产能周期 分钟 示例10分钟
	private java.lang.Integer 				ysCapaLimit;//银树日分红产能上限  即分红次数 示例30次
	private java.lang.Integer 				jsCapaLimit;//金树日分红产能上限  即分红次数 示例30次
	private java.lang.String    			dsjScale;	  //代数奖比例 示例0.05,0.02,0.01,0.005,0.003,0.001
														//对应种植金树或银树所需的种子积分的乘机
	private java.lang.String    			zhtParam;	  //直推参数 示例1_1,3_2,6_3,15_4,20_10,50_15
														//说明  直推1个拿1代....
	private java.lang.String    			tixCycle;	//提现周期 1_1,2_1,3_1,4_0,5_1,6_1,7_0
														//说明 1_1 礼拜一可以提现 4_0礼拜四不可提现...
	private java.lang.String 				dyWalDeposit;//示例：1,100,2000,100,0.02 动态钱包每天提现次数,提现最低,提现最高,提现倍数,手续费
	private java.lang.String 				jtWalDeposit;//示例：1,100,2000,100,0.02 静态钱包每天提现次数,提现最低,提现最高,提现倍数,手续费
	private java.lang.String 				epSellTrade;//示例：100,2000,100 最低挂卖额度,最高挂卖额度,挂卖倍数
	private java.lang.String 				epBuyTrade;//示例：100,2000,100 最低买进额度,最高买进额度,买进倍数
	//*********************************玩家自己 币种的转换 即转换
	private java.lang.String 				dyWal2Jhjf;//动态钱包转激活积分 示例：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String 				dyWal2Zzjf;//动态钱包转种子积分示例：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String 				dyWal2GjMoney;//动态钱包转管家月俸示例：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String 				dyWal2ShtMoney;//动态钱包转神童日俸示例：100,2000,100 最低额度,最高额度,转换倍数
	
	private java.lang.String 				jtWal2Jhjf;//静态钱包(收益钱包)转激活积分示例：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String 				jtWal2Zzjf;//静态钱包(收益钱包)转种子积分示例：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String 				jtWal2GjMoney;//静态钱包(收益钱包)转管家月俸示例：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String 				jtWal2ShtMoney;//静态钱包(收益钱包)转神童日俸示例：100,2000,100 最低额度,最高额度,转换倍数
	
	private java.lang.String 				zzjf2Jhjf;//种子积分转激活积分示例：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String 				zzjf2GjMoney;//种子积分转管家月俸示例：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String 				zzjf2ShtMoney;//种子积分转神童日俸示例：100,2000,100 最低额度,最高额度,转换倍数
	
	//*********************************两个会员之间的转换   即 互转
	private java.lang.String 				zzjf2Zzjf;//会员间种子积分互转示例：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String 				jhjf2Jhjf;//会员间激活积分互转示例：100,2000,100 最低额度,最高额度,转换倍数
	
	
	
	//--------------------------------金姐项目参数配置字段----------------------------------------------
	//双轨小公排，680一单，成功激活后，平台赠送等额的产品。
	private java.math.BigDecimal			singlePrice;//多少元一单
	//层奖：7层之内每激活一个新会员，获得50元，累积到团队收益钱包
	private java.math.BigDecimal			activeGetPrice;//激活会员获得金额  
//	推荐奖：每推荐一单拿200元，进入个人的现金积分，可提现，可转为激活积分。识别推荐人二维码、推广链接、或者个人平台注册。
	private java.math.BigDecimal			directivePrice;//直推一单收益
//	个人团队收益钱包累积达到10000后停止发放层奖。
	private java.math.BigDecimal			stopLayerPrice;//停止发放层奖的额度
//	现金积分：来源于推荐奖，财务明细记录来源于每个编号、日期、多少额度。可以提现、提现设置扣除多少百分比手续费。可以转为激活积分。
	private java.lang.String				cashIntegralTX;//示例：1,100,2000,100,0.02 现金积分 每天提现次数,提现最低,提现最高,提现倍数,手续费
	private java.lang.String				cashInteg2ActiveInteg;//现金积分转换激活积分：100,2000,100 最低额度,最高额度,转换倍数
//	激活积分:会员之间可以互转，可由现金积分转换而来，后台充值，主要用于激活新会员
	private java.lang.String				activeInteg2activeInteg;//会员间激活积分  互转示例：100,2000,100 最低额度,最高额度,转换倍数
//	团队收益：可转为激活积分，可提现，限制最低600起转账或提现，提现需要扣除10%手续费。
	private java.lang.String				teamInteg2ActiveInteg;//团队收益转换激活积分：100,2000,100 最低额度,最高额度,转换倍数
	private java.lang.String				teamIntegralTX;//示例：1,100,2000,100,0.02 团队收益 每天提现次数,提现最低,提现最高,提现倍数,手续费
	
	
	
	
	
	
	public java.math.BigDecimal getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(java.math.BigDecimal singlePrice) {
		this.singlePrice = singlePrice;
	}
	public java.math.BigDecimal getActiveGetPrice() {
		return activeGetPrice;
	}
	public void setActiveGetPrice(java.math.BigDecimal activeGetPrice) {
		this.activeGetPrice = activeGetPrice;
	}
	public java.math.BigDecimal getDirectivePrice() {
		return directivePrice;
	}
	public void setDirectivePrice(java.math.BigDecimal directivePrice) {
		this.directivePrice = directivePrice;
	}
	public java.math.BigDecimal getStopLayerPrice() {
		return stopLayerPrice;
	}
	public void setStopLayerPrice(java.math.BigDecimal stopLayerPrice) {
		this.stopLayerPrice = stopLayerPrice;
	}
	public java.lang.String getCashIntegralTX() {
		return cashIntegralTX;
	}
	public void setCashIntegralTX(java.lang.String cashIntegralTX) {
		this.cashIntegralTX = cashIntegralTX;
	}
	public java.lang.String getCashInteg2ActiveInteg() {
		return cashInteg2ActiveInteg;
	}
	public void setCashInteg2ActiveInteg(java.lang.String cashInteg2ActiveInteg) {
		this.cashInteg2ActiveInteg = cashInteg2ActiveInteg;
	}
	public java.lang.String getActiveInteg2activeInteg() {
		return activeInteg2activeInteg;
	}
	public void setActiveInteg2activeInteg(java.lang.String activeInteg2activeInteg) {
		this.activeInteg2activeInteg = activeInteg2activeInteg;
	}
	public java.lang.String getTeamInteg2ActiveInteg() {
		return teamInteg2ActiveInteg;
	}
	public void setTeamInteg2ActiveInteg(java.lang.String teamInteg2ActiveInteg) {
		this.teamInteg2ActiveInteg = teamInteg2ActiveInteg;
	}
	public java.lang.String getTeamIntegralTX() {
		return teamIntegralTX;
	}
	public void setTeamIntegralTX(java.lang.String teamIntegralTX) {
		this.teamIntegralTX = teamIntegralTX;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.math.BigDecimal getJhIntegral() {
		return jhIntegral;
	}
	public void setJhIntegral(java.math.BigDecimal jhIntegral) {
		this.jhIntegral = jhIntegral;
	}

	public java.lang.String getZhtParam() {
		return zhtParam;
	}
	public void setZhtParam(java.lang.String zhtParam) {
		this.zhtParam = zhtParam;
	}

	public java.lang.String getDyWalDeposit() {
		return dyWalDeposit;
	}
	public void setDyWalDeposit(java.lang.String dyWalDeposit) {
		this.dyWalDeposit = dyWalDeposit;
	}
	public java.lang.String getJtWalDeposit() {
		return jtWalDeposit;
	}
	public void setJtWalDeposit(java.lang.String jtWalDeposit) {
		this.jtWalDeposit = jtWalDeposit;
	}
	public java.lang.String getEpSellTrade() {
		return epSellTrade;
	}
	public void setEpSellTrade(java.lang.String epSellTrade) {
		this.epSellTrade = epSellTrade;
	}
	public java.lang.String getEpBuyTrade() {
		return epBuyTrade;
	}
	public void setEpBuyTrade(java.lang.String epBuyTrade) {
		this.epBuyTrade = epBuyTrade;
	}
	public java.lang.String getDyWal2Jhjf() {
		return dyWal2Jhjf;
	}
	public void setDyWal2Jhjf(java.lang.String dyWal2Jhjf) {
		this.dyWal2Jhjf = dyWal2Jhjf;
	}

	public java.lang.String getJtWal2Jhjf() {
		return jtWal2Jhjf;
	}
	public void setJtWal2Jhjf(java.lang.String jtWal2Jhjf) {
		this.jtWal2Jhjf = jtWal2Jhjf;
	}

	public java.lang.String getJhjf2Jhjf() {
		return jhjf2Jhjf;
	}
	public void setJhjf2Jhjf(java.lang.String jhjf2Jhjf) {
		this.jhjf2Jhjf = jhjf2Jhjf;
	}
	public java.math.BigDecimal getYszzIntegral() {
		return yszzIntegral;
	}
	public void setYszzIntegral(java.math.BigDecimal yszzIntegral) {
		this.yszzIntegral = yszzIntegral;
	}
	public java.math.BigDecimal getJszzIntegral() {
		return jszzIntegral;
	}
	public void setJszzIntegral(java.math.BigDecimal jszzIntegral) {
		this.jszzIntegral = jszzIntegral;
	}
	public java.math.BigDecimal getYstqIntegral() {
		return ystqIntegral;
	}
	public void setYstqIntegral(java.math.BigDecimal ystqIntegral) {
		this.ystqIntegral = ystqIntegral;
	}
	public java.math.BigDecimal getJstqIntegral() {
		return jstqIntegral;
	}
	public void setJstqIntegral(java.math.BigDecimal jstqIntegral) {
		this.jstqIntegral = jstqIntegral;
	}
	public java.lang.Integer getYstqCount() {
		return ystqCount;
	}
	public void setYstqCount(java.lang.Integer ystqCount) {
		this.ystqCount = ystqCount;
	}
	public java.lang.Integer getJstqCount() {
		return jstqCount;
	}
	public void setJstqCount(java.lang.Integer jstqCount) {
		this.jstqCount = jstqCount;
	}
	public java.math.BigDecimal getWgjCount() {
		return wgjCount;
	}
	public void setWgjCount(java.math.BigDecimal wgjCount) {
		this.wgjCount = wgjCount;
	}
	public java.math.BigDecimal getPtgjCount() {
		return ptgjCount;
	}
	public void setPtgjCount(java.math.BigDecimal ptgjCount) {
		this.ptgjCount = ptgjCount;
	}
	public java.math.BigDecimal getCjgjCount() {
		return cjgjCount;
	}
	public void setCjgjCount(java.math.BigDecimal cjgjCount) {
		this.cjgjCount = cjgjCount;
	}
	public java.math.BigDecimal getShtMoney() {
		return shtMoney;
	}
	public void setShtMoney(java.math.BigDecimal shtMoney) {
		this.shtMoney = shtMoney;
	}
	public java.math.BigDecimal getPtgjMoney() {
		return ptgjMoney;
	}
	public void setPtgjMoney(java.math.BigDecimal ptgjMoney) {
		this.ptgjMoney = ptgjMoney;
	}
	public java.math.BigDecimal getCjgjMoney() {
		return cjgjMoney;
	}
	public void setCjgjMoney(java.math.BigDecimal cjgjMoney) {
		this.cjgjMoney = cjgjMoney;
	}
	public java.math.BigDecimal getYsCapacity() {
		return ysCapacity;
	}
	public void setYsCapacity(java.math.BigDecimal ysCapacity) {
		this.ysCapacity = ysCapacity;
	}
	public java.math.BigDecimal getJsCapacity() {
		return jsCapacity;
	}
	public void setJsCapacity(java.math.BigDecimal jsCapacity) {
		this.jsCapacity = jsCapacity;
	}
	public java.lang.Integer getYsCapaCycle() {
		return ysCapaCycle;
	}
	public void setYsCapaCycle(java.lang.Integer ysCapaCycle) {
		this.ysCapaCycle = ysCapaCycle;
	}
	public java.lang.Integer getJsCapaCycle() {
		return jsCapaCycle;
	}
	public void setJsCapaCycle(java.lang.Integer jsCapaCycle) {
		this.jsCapaCycle = jsCapaCycle;
	}
	public java.lang.Integer getYsCapaLimit() {
		return ysCapaLimit;
	}
	public void setYsCapaLimit(java.lang.Integer ysCapaLimit) {
		this.ysCapaLimit = ysCapaLimit;
	}
	public java.lang.Integer getJsCapaLimit() {
		return jsCapaLimit;
	}
	public void setJsCapaLimit(java.lang.Integer jsCapaLimit) {
		this.jsCapaLimit = jsCapaLimit;
	}
	public java.lang.String getDsjScale() {
		return dsjScale;
	}
	public void setDsjScale(java.lang.String dsjScale) {
		this.dsjScale = dsjScale;
	}
	public java.lang.String getTixCycle() {
		return tixCycle;
	}
	public void setTixCycle(java.lang.String tixCycle) {
		this.tixCycle = tixCycle;
	}
	public java.lang.String getDyWal2Zzjf() {
		return dyWal2Zzjf;
	}
	public void setDyWal2Zzjf(java.lang.String dyWal2Zzjf) {
		this.dyWal2Zzjf = dyWal2Zzjf;
	}
	public java.lang.String getDyWal2GjMoney() {
		return dyWal2GjMoney;
	}
	public void setDyWal2GjMoney(java.lang.String dyWal2GjMoney) {
		this.dyWal2GjMoney = dyWal2GjMoney;
	}
	public java.lang.String getDyWal2ShtMoney() {
		return dyWal2ShtMoney;
	}
	public void setDyWal2ShtMoney(java.lang.String dyWal2ShtMoney) {
		this.dyWal2ShtMoney = dyWal2ShtMoney;
	}
	public java.lang.String getJtWal2Zzjf() {
		return jtWal2Zzjf;
	}
	public void setJtWal2Zzjf(java.lang.String jtWal2Zzjf) {
		this.jtWal2Zzjf = jtWal2Zzjf;
	}
	public java.lang.String getJtWal2GjMoney() {
		return jtWal2GjMoney;
	}
	public void setJtWal2GjMoney(java.lang.String jtWal2GjMoney) {
		this.jtWal2GjMoney = jtWal2GjMoney;
	}
	public java.lang.String getJtWal2ShtMoney() {
		return jtWal2ShtMoney;
	}
	public void setJtWal2ShtMoney(java.lang.String jtWal2ShtMoney) {
		this.jtWal2ShtMoney = jtWal2ShtMoney;
	}
	public java.lang.String getZzjf2Jhjf() {
		return zzjf2Jhjf;
	}
	public void setZzjf2Jhjf(java.lang.String zzjf2Jhjf) {
		this.zzjf2Jhjf = zzjf2Jhjf;
	}
	public java.lang.String getZzjf2GjMoney() {
		return zzjf2GjMoney;
	}
	public void setZzjf2GjMoney(java.lang.String zzjf2GjMoney) {
		this.zzjf2GjMoney = zzjf2GjMoney;
	}
	public java.lang.String getZzjf2ShtMoney() {
		return zzjf2ShtMoney;
	}
	public void setZzjf2ShtMoney(java.lang.String zzjf2ShtMoney) {
		this.zzjf2ShtMoney = zzjf2ShtMoney;
	}
	public java.lang.String getZzjf2Zzjf() {
		return zzjf2Zzjf;
	}
	public void setZzjf2Zzjf(java.lang.String zzjf2Zzjf) {
		this.zzjf2Zzjf = zzjf2Zzjf;
	}
	

}
