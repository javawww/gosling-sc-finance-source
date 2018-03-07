package com.gosling.dao.bonus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gosling.entity.bonus.BonusInf;
/**
 * 
 * @类描述：奖金明细
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.bonus
 * @类名称：BonusInfDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午1:57:13
 */
public interface BonusInfDao {


	Integer insert(BonusInf bonusInf);

	List<BonusInf> getByBonusId(Integer bonusId);

	
	List<BonusInf> getAllByPage(Map<String, Object> pageMap);

	Integer getTotalPages(Map<String, Object> whereMap);
	
	List<BonusInf>  getAllByMemNumAndType(@Param("memNum")String memNum,@Param("bonusType")Integer bonusType);

}
