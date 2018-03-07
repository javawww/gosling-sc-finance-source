package com.gosling.service.bonus;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.dao.bonus.BonusDao;
import com.gosling.entity.bonus.Bonus;

@Service(value = "bonusService")
public class BonusService {

	@Resource
	private BonusDao			bonusDao;
	
	/**
	 * 
	 * @描述:列表
	 * @方法名: getAllByPage
	 * @param pageMap
	 * @return
	 * @返回类型 List<Bonus>
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午4:25:21
	 */
	public List<Bonus> getAllByPage(Map<String, Object> pageMap) {
		return bonusDao.getAllByPage(pageMap);
	}
	
	/**
	 * 
	 * @描述:数量
	 * @方法名: getTotalPages
	 * @param whereMap
	 * @return
	 * @返回类型 Integer
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午4:26:22
	 */
	public Integer getTotalPages(Map<String, Object> whereMap) {
		return bonusDao.getTotalPages(whereMap);
	}

	public Bonus getByCurrDateAndMemNum(String memNum) {
		return bonusDao.getByCurrDateAndMemNum(memNum);
	}

	public Integer insert(Bonus bonus) {
		return bonusDao.insert(bonus);
	}

	public Integer updateBonus(Bonus bonus) {
		return bonusDao.updateBonus(bonus);
	}

	
	
}
