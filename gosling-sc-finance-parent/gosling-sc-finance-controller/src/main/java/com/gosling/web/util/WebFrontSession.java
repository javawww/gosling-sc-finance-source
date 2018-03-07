package com.gosling.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gosling.core.util.Constants;
import com.gosling.entity.member.Member;

public class WebFrontSession {

	
	/**
	 * 放入前端SESSION
	 * @param request
	 * @param member
	 */
	public static void putFrontMember(HttpServletRequest request,Member member){
		
		HttpSession session = request.getSession();
		
		session.setAttribute(Constants.SESSION_FRONT_MEMBER, member);
		
	}
	
	/**
	 * 获取前端SESSION
	 * @param request
	 * @return
	 */
	public static Member getFrontMember(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		Member member = (Member)session.getAttribute(Constants.SESSION_FRONT_MEMBER);
		
		return member;
		
	}
	
	/**
	 * 获取用户验证码
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getVerifyNumber(HttpServletRequest request){
		
		String verify_member = (String)request.getSession().getAttribute(Constants.VERIFY_NUMBER_NAME);
		
		return verify_member;
		
	}
	/**
	 * 注销操作  移除客户端SESSION
	 * @param request
	 */
	public static void removeMemberSession(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null){
			session.removeAttribute(Constants.SESSION_FRONT_MEMBER);
		}
	}
}
