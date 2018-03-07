package com.gosling.service.bonus;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.dao.bonus.BonusInfDao;
import com.gosling.entity.bonus.BonusInf;

@Service(value = "bonusInfService")
public class BonusInfService {
	
	@Resource
	private 	BonusInfDao			bonusInfDao;
	
	/**
	 * 
	 * @描述:获取数据
	 * @方法名: getAllByMemNumAndType
	 * @param memNum
	 * @param bonusType
	 * @return
	 * @返回类型 List<BonusInf>
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午2:26:51
	 */
	public List<BonusInf> getAllByMemNumAndType(String memNum, int bonusType) {
		return bonusInfDao.getAllByMemNumAndType(memNum, bonusType);
	}
	
	/**
	 * 
	 * @描述:列表
	 * @方法名: getAllByPage
	 * @param pageMap
	 * @return
	 * @返回类型 List<BonusInf>
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午4:27:15
	 */
	public List<BonusInf> getAllByPage(Map<String, Object> pageMap) {
		return bonusInfDao.getAllByPage(pageMap);
	}
	
	/**
	 * 
	 * @描述:数量
	 * @方法名: getTotalPages
	 * @param whereMap
	 * @return
	 * @返回类型 Integer
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午4:27:38
	 */
	public Integer getTotalPages(Map<String, Object> whereMap) {
		return bonusInfDao.getTotalPages(whereMap);
	}

	public Integer insert(BonusInf bonusInf) {
		return bonusInfDao.insert(bonusInf);
	}

}
