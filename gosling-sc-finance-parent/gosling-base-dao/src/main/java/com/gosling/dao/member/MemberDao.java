package com.gosling.dao.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gosling.entity.member.Member;
/**
 * 
 * @类描述：会员
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.member
 * @类名称：MemberDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午1:59:32
 */
public interface MemberDao {
	 
		public List<Map> findCommon(Map map);
		
		public int addCommon(Object o);
		
		public int getMemberCounts();
		
		public int getMemberCountsByFloor(int floor);
		
		public int deleteCommon(int id); 
		
		public int updateCommon(Map map);
		
		public int updateCommon(Object m);
		
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

		//add by tongzm
		
		public int findmemberByNum(String memNum);//根据用户编号校验用户是否存在
		public Member findmemberByValid(Member member);//登录校验并返回用户对象

		public int updatememberByNum(Member memNum);//普通用户升级管理员

		public List<Member> findMembersByRolestate_page(Map map);

		public int findMembersCountByRolestate_page(Map map);

		public List<Member> findAll();

		public List<Member> findListByTjrNum(String tjrNum);

		public List<Map> findCommonActived(Map map);

		public Map findCommonByMemNum(Map map);

		public List<Map> findTreeTable();

		public Member findCommonById(Integer id);

		public Member findForLogin(@Param("curMemNum")String curMemNum, @Param("curPassword")String curPassword);

		public List<Member> findJhMember(String curMemNum);

		public List<Member> findWjhMember(String curMemNum);

		public List<Map> findMemberListFB(Map map);

		public int findCommonCountFB(Map map);

		public Member selectMemEntiBymemNum(String memNum);

		public List<Member> selectAllMemsByjhState(Integer jhState);

		public Member findForTrade(Map map);

		public int deleteById(int id);

		public Integer saveMember(Member member);

		public Member getById(Integer id);
		
		public Member getByMemNum(String memNum);

		public Integer updateMemberById(Member member);

		//end
		
		
		List<Member> getAllByPage(Map<String, Object> pageMap);

		Integer getTotalPages(Map<String, Object> whereMap);

		public List<Member> getByTjrMemNum(String memNum);

		public List<Member> getMemberListByJiedianNum(String jiedianNum);

		public Integer getCountsByJiedianNum(String jiedianNum);
		
		//二叉树
		public Integer getLayerCounts(List<Integer> memNums);
		
		public List<Member>  getLayerMembers(List<Integer> memNums);
		
		
}
