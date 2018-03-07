package com.gosling.web.controller.member;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gosling.core.json.AjaxJson;
import com.gosling.entity.member.Member;
import com.gosling.service.member.MemberService;
import com.gosling.web.controller.BaseController;
import com.gosling.web.util.WebFrontSession;


/**
 * 
 * @类描述：登陆操作
 * @项目名称：gosling-sc-finance-controller
 * @包名： com.gosling.web.controller.member
 * @类名称：MemberLoginController
 * @创建人：Administrator
 * @创建时间：2018年2月28日下午6:52:38
 */
@Controller
public class MemberLoginController extends BaseController{

	@Resource
	private 		MemberService 					memberService;
	
	/**
	 * 前端 跳转登录页面
	 * @param request
	 * @param response
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = "login.html" ,method = RequestMethod.GET)
	public String skipLoginFront(HttpServletRequest request,HttpServletResponse response,
			Map<String, Object> dataMap){
		
		return "finance/member/login";
	}
	
	/**
	 * 用户登录校验，必填参数Member对象，对象要具有用户和密码两项值
	 */
	@ResponseBody
	@RequestMapping(value = "dologin.html",method = RequestMethod.POST)
	public AjaxJson loginCheck(HttpServletRequest httpServletRequest,Model model,Member me) {
		AjaxJson j = new AjaxJson();
		
		String curMemNum = me.getMemNum();
		String curPassword = me.getLoginPwd();
		Member m = memberService.findForLogin(curMemNum, curPassword);
		String verify_number = httpServletRequest.getParameter("verify_number");
		String verify_number_session = WebFrontSession.getVerifyNumber(httpServletRequest);
		
		if(!verify_number.equals(verify_number_session)){
			j.setSuccess(false);
			j.setMessage("校验码输入错误");
			return j;
		}else if(m.getJhState() == 1){//1未激活
			j.setSuccess(false);
			j.setMessage("帐号未激活");
			return j;
		}else if(m.getDjState() == 2){//2冻结状态
			j.setSuccess(false);
			j.setMessage("帐号冻结中");
			return j;
		}
		//登录成功
		WebFrontSession.putFrontMember(httpServletRequest, m);
		
		return j;
	}
	
	/**
	 * 找回密码   
	 */
	@RequestMapping(value = "forget_pass.html",method = RequestMethod.GET)
	public String skipForgetPassFront(HttpServletRequest request){
		
		return "finance/member/forget_pass";
	}
	
}
