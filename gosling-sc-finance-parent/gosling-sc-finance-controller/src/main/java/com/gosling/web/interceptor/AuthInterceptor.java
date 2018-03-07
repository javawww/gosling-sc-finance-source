package com.gosling.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gosling.core.util.ResourceUtil;
import com.gosling.entity.member.Member;
import com.gosling.web.util.WebFrontSession;

public class AuthInterceptor implements HandlerInterceptor{

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
	
	/*private List<String> excludeUrls;
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}*/
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		String requestPath = ResourceUtil.getRequestPath(request);
		//获取FRONT前端会员SESSION   
		Member memberFront = WebFrontSession.getFrontMember(request);
		//当前会员 SESSION为null  执行权限拦截 并页面跳转登录页面
		/*if(excludeUrls.contains(requestPath)){
			return true;
		}else */
		if (memberFront == null || "".equals(memberFront.toString())){
			//跳转到登录界面
			response.sendRedirect(request.getContextPath()+"/login.html");
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
