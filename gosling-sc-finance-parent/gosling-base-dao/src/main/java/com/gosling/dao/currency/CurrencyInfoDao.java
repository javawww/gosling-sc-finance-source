package com.gosling.dao.currency;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gosling.entity.currency.CurrencyInfo;

/**
 * 
 * @类描述：币种信息
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.currency
 * @类名称：CurrencyInfoDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午1:57:41
 */
public interface CurrencyInfoDao {

	 
	public List<Map> findCommon(Map map);
	
	public int addCommon(CurrencyInfo currencyinfo);
	
	public int deleteCommon(int id); 
	
	public int updateCommon(Map map);
	
	public int findCommonCount(Map map);
	 
	public List<Map> findCommonByUser(Map map);
	
	public int findCommonByUserCount(Map map);
	
	public int updateCommonState(Map map);
	  
	public Map findCommonbyid(int id);
	
	public List<Map> findCommonxxByUser(int userid);
	
	public List<Map> findCommonxxByUserAndState(int userid);
	
	public int updateCommonxxState(int id);
	
	public List<Map> findCommonxqxx(Map map);
	
	public int findCommonxqxxCount(int commonId);
	
	public Map findCommonxxbyid(int id);
	
	public List<Map> findCommonbyindex();
	
	public int addCommonxx(Map map);
	
	public List<Map> findCommonByList(Map map);
	public int findCommonByListCount(Map map);
	
	public List<Map> findCommonxxByCommon(int commonId);
	
	public List<Map> findCommonbyuser(int id);
	public int deleteCommonxxByCommon(int commonId);	
	public int deleteCommonByUser(int id);

	public List<Map> findProByIndexAll(Map map);

	public CurrencyInfo findOneCurrenInfoBymemNum(String memNum);

	public int reduceMoneyByMemId(@Param("amount")BigDecimal amount, @Param("id")int id);

	public int addYuE(Map map);

	public int reduceYuE(Map map);

	public int updateCurrenInfoByMemId(CurrencyInfo currenInfo);

	public int deleteByMemId(int id);

	public CurrencyInfo findByMemId(Integer memId);

	
	//根据关联用户id查询他有的激活积分
	public BigDecimal findActivPennByMemId(Integer memId);


	public int updateIntegralVal(CurrencyInfo currenInfo);
	
	public int updateIntegralVal1(CurrencyInfo currenInfo);

	//add
	public int updatePostMoney(CurrencyInfo currencyInf);


}
