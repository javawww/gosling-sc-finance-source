package com.gosling.dao.bonus;

import java.util.List;
import java.util.Map;

import com.gosling.entity.bonus.Bonus;
/**
 * 
 * @类描述：奖金
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.bonus
 * @类名称：BonusDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午1:57:05
 */
public interface BonusDao {
	
	Bonus getByCurrDateAndMemNum(String memNum);

	Integer insert(Bonus bonus_1);

	List<Bonus> getByMemNum(String memNum);
	
	List<Bonus> getAll();
	
	Integer updateById(Bonus bonus);
	
	Integer updateBonus(Bonus bonus);
	
	List<Bonus> getAllByPage(Map<String, Object> pageMap);

	Integer getTotalPages(Map<String, Object> whereMap);
}
