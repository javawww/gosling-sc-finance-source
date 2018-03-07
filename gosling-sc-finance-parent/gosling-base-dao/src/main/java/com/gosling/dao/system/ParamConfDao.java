package com.gosling.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gosling.entity.system.ParamConf;

/**
 * 
 * @类描述：全局参数
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.system
 * @类名称：ParamConfDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午1:59:54
 */
public interface ParamConfDao {

	 
	public List<Map> findCommon(Map map);
	public ParamConf findParamById(@Param("id") Integer id);
	
	public int addCommon(Map map);
	
	public int deleteCommon(int id); 
	
	public int updateCommon(Map map);
	
	public int findCommonCount(Map map);
	 
	public List<Map> findCommonByUser(Map map);
	
	public int findCommonByUserCount(Map map);
	
	public int updateCommonState(Map map);
	  
	public Map findCommonbyid(int id);
	
	public List<Map> findCommonxxByUser(int userid);
	
	public List<Map> findCommonxxByUserAndState(int userid);
	
	public int updateCommonxxState(int id);
	
	public List<Map> findCommonxqxx(Map map);
	
	public int findCommonxqxxCount(int commonId);
	
	public Map findCommonxxbyid(int id);
	
	public List<Map> findCommonbyindex();
	
	public int addCommonxx(Map map);
	
	public List<Map> findCommonByList(Map map);
	public int findCommonByListCount(Map map);
	
	public List<Map> findCommonxxByCommon(int commonId);
	
	public List<Map> findCommonbyuser(int id);
	public int deleteCommonxxByCommon(int commonId);	
	public int deleteCommonByUser(int id);

	public List<Map> findProByIndexAll(Map map);
	//更新数据
	public Integer update(ParamConf paramconf);
	public Map findAll();
	
	//通过ID获取唯一数据
	public ParamConf getById(int id);
	

}
