package com.gosling.dao.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gosling.entity.menu.MemMenu;
import com.gosling.entity.menu.Menu;

/**
 * 
 * @类描述：菜单
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.menu
 * @类名称：MenuDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午1:59:46
 */
public interface MenuDao {

	 
	public List<Map> findCommon(Map map);
	
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
	//动态渲染左侧菜单
	public List<Menu> findlist();
	//根据父亲id获取所有儿子
	public List<Menu> findlistbypid_memId(@Param("id")Integer id,@Param("memId")Integer memId);

	public void deleteByAdminId(Integer adminId);

	public int insert(MemMenu memMenu);

	public MemMenu selectByMenuId_MemId(@Param("menuId")Integer menuId,@Param("memId")Integer memId);

	public List<Menu> findListByMemId(Integer memId);

}
