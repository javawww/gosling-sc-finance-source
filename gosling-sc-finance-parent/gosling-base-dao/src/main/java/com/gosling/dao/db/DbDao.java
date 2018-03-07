package com.gosling.dao.db;

import java.util.List;
import java.util.Map;

import com.gosling.entity.db.Db;

/**
 * 
 * @类描述：数据库备份
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.db
 * @类名称：DbDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午1:58:04
 */
public interface DbDao {


	Integer insert(Db db);

	List<Db> getAllByPage(Map<String, Object> pageMap);

	Integer getTotalPages(Map<String, Object> whereMap);

	Db getById(Integer id);
	

}
