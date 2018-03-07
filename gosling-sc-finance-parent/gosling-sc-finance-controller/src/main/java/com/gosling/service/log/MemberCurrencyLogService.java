package com.gosling.service.log;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.dao.log.MemberCurrencyLogDao;
import com.gosling.entity.log.Log;
import com.gosling.entity.log.LogInf;
import com.gosling.entity.log.MemberCurrencyLog;

@Service(value = "memberCurrencyLogService")
public class MemberCurrencyLogService {
	
	@Resource
	private MemberCurrencyLogDao		memberCurrencyLogDao;
	
	/**
	 * 
	 * @描述:列表
	 * @方法名: getAllByPage
	 * @param pageMap
	 * @return
	 * @返回类型 List<MemberCurrencyLog>
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午4:24:27
	 */
	public List<MemberCurrencyLog> getAllByPage(Map<String, Object> pageMap) {
		return memberCurrencyLogDao.getAllByPage(pageMap);
	}
	
	/**
	 * 
	 * @描述:数量
	 * @方法名: getTotalPages
	 * @param whereMap
	 * @return
	 * @返回类型 Integer
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午4:24:19
	 */
	public Integer getTotalPages(Map<String, Object> whereMap) {
		return memberCurrencyLogDao.getTotalPages(whereMap);
	}

	public Integer insert(MemberCurrencyLog currencyLog) {
		return memberCurrencyLogDao.insert(currencyLog);
	}

	public MemberCurrencyLog geyAllMessage(int id, String memNum) {
		return memberCurrencyLogDao.geyAllMessage(id, memNum);
	}

	public List<Log> getAllByPage_log(Map<String, Object> pageMap) {
		return memberCurrencyLogDao.getAllByPage_log(pageMap);
	}

	public Integer getTotalPages_log(Map<String, Object> whereMap) {
		return memberCurrencyLogDao.getTotalPages_log(whereMap);
	}

	public List<LogInf> getAllByPage_loginf(Map<String, Object> pageMap) {
		return memberCurrencyLogDao.getAllByPage_loginf(pageMap);
	}

	public Integer getTotalPages_loginf(Map<String, Object> whereMap) {
		return memberCurrencyLogDao.getTotalPages_loginf(whereMap);
	}

	public Log getByCurrDateAndMemNum(String memNum) {
		return memberCurrencyLogDao.getByCurrDateAndMemNum(memNum);
	}

	public Integer insertLog(Log log_1) {
		return memberCurrencyLogDao.insertLog(log_1);
	}

	public Integer updateLog(Log log) {
		return memberCurrencyLogDao.updateLog(log);
	}

	public Integer insertLoginf(LogInf loginf_1) {
		return memberCurrencyLogDao.insertLoginf(loginf_1);
	}

	
}
