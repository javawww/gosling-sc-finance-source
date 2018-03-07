package com.gosling.service.announcement;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.dao.announcement.InformationDao;
import com.gosling.entity.announcement.Information;

@Service(value = "informationService")
public class InformationService {
	
	@Resource
	private InformationDao			informationDao;
	
	/**
	 * 
	 * @描述:取数据
	 * @方法名: getAllByPage
	 * @param pageMap
	 * @return
	 * @返回类型 List<Information>
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午2:47:57
	 */
	public List<Information> getAllByPage(Map<String, Object> pageMap) {
		return informationDao.getAllByPage(pageMap);
	}
	
	/**
	 * 
	 * @描述:取数量
	 * @方法名: getTotalPages
	 * @param whereMap
	 * @return
	 * @返回类型 Integer
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午2:48:11
	 */
	public Integer getTotalPages(Map<String, Object> whereMap) {
		return informationDao.getTotalPages(whereMap);
	}
	
	/**
	 * 
	 * @描述:取一条数据
	 * @方法名: getById
	 * @param valueOf
	 * @return
	 * @返回类型 Information
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午2:51:43
	 */
	public Information getById(Integer id) {
		return informationDao.getById(id);
	}

}
