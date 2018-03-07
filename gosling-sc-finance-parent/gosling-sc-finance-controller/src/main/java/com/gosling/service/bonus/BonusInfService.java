package com.gosling.service.bonus;

import java.util.List;

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

}
