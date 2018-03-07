package com.gosling.dao.announcement;

import java.util.List;
import java.util.Map;

import com.gosling.entity.announcement.Information;
/**
 * 
 * @类描述：公告
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.announcement
 * @类名称：InformationDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午12:01:50
 */
public interface InformationDao {
	
	Integer insert(Information information);

	List<Information> getAll();

	List<Information> getAllByPage(Map<String, Object> pageMap);

	Integer getTotalPages(Map<String, Object> whereMap);

	Information getById(Integer id);

	Integer update(Information information);

	Integer delById(Integer id);
}
