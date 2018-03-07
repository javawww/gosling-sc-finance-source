package com.gosling.service.member;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.dao.member.MemberDao;
import com.gosling.entity.member.Member;

@Service(value = "memberService")
public class MemberService {
	
	@Resource
	private MemberDao	memberDao;
	
	/**
	 * 
	 * @描述:登陆校验
	 * @方法名: findForLogin
	 * @param curMemNum
	 * @param curPassword
	 * @return
	 * @返回类型 Member
	 * @创建人 Administrator
	 * @创建时间 2018年2月28日下午10:13:21
	 */
	public Member findForLogin(String curMemNum, String curPassword) {
		return memberDao.findForLogin(curMemNum,curPassword);
	}
	
	/**
	 * 
	 * @描述:根据ID获取用户
	 * @方法名: getById
	 * @param id
	 * @return
	 * @返回类型 Member
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日上午11:02:46
	 */
	public Member getById(Integer id) {
		return memberDao.getById(id);
	}

	public Integer findmemberByNum(String toMemNum) {
		return memberDao.findmemberByNum(toMemNum);
	}

	public Member selectMemEntiBymemNum(String toMemNum) {
		return memberDao.selectMemEntiBymemNum(toMemNum);
	}

	public Integer updateMemberById(Member member) {
		return memberDao.updateMemberById(member);
		
	}

	public List<Member> getAllByPage(Map<String, Object> pageMap) {
		return memberDao.getAllByPage(pageMap);
	}

	public Integer getTotalPages(Map<String, Object> whereMap) {
		return memberDao.getTotalPages(whereMap);
	}

	public List<Member> getMemberListByJiedianNum(String jiedianNum) {
		return memberDao.getMemberListByJiedianNum(jiedianNum);
	}

	public Integer saveMember(Member member) {
		return memberDao.saveMember(member);
	}

	public Integer deleteById(Integer id) {
		return memberDao.deleteById(id);
	}

	public List<Member> selectAllMemsByjhState(int state) {
		return memberDao.selectAllMemsByjhState(state);
	}

	public List<Member> findAll() {
		return memberDao.findAll();
	}

	public Integer getLayerCounts(List<Integer> memNums) {
		return memberDao.getLayerCounts(memNums);
	}

	public List<Member> getLayerMembers(List<Integer> memNums) {
		return memberDao.getLayerMembers(memNums);
	}

}
