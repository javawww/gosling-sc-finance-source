package com.gosling.service.member;

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

}
