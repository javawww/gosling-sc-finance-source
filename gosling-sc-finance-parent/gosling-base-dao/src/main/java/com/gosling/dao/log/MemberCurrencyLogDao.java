package com.gosling.dao.log;

import java.util.List;
import java.util.Map;

import com.gosling.entity.log.Log;
import com.gosling.entity.log.LogInf;
import com.gosling.entity.log.MemberCurrencyLog;

/**
 * 
 * @类描述：币种日志
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.log
 * @类名称：MemberCurrencyLogDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午1:59:00
 */
public interface MemberCurrencyLogDao {


	Integer insert(MemberCurrencyLog currencyLog);
	
	Integer update(MemberCurrencyLog currencyLog);

	Integer getTotalPages(Map<String, Object> whereMap);

	List<MemberCurrencyLog> getAllByPage(Map<String, Object> pageMap);

	MemberCurrencyLog getById(int id);
	
	//根据id和memNum查询
	MemberCurrencyLog geyAllMessage(int id,String memNum);
	
	
	
	//Log   数据交互也存在该DAO中进行实现
	Integer insertLog(Log  log);
	Log getByCurrDateAndMemNum(String memberNum);
	Integer updateLog(Log Log);

	Integer getTotalPages_log(Map<String, Object> whereMap);
	List<Log> getAllByPage_log(Map<String, Object> pageMap);
	
	//LogInf  数据交互也在该DAO中进行实现
	Integer insertLoginf(LogInf loginf_1);
	
	Integer getTotalPages_loginf(Map<String, Object> whereMap);
	List<LogInf> getAllByPage_loginf(Map<String, Object> pageMap);

	List<LogInf> getLoginfoByPid(Integer logPid);
	

}
