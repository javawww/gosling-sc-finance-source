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
	 * 
	 * @描述:忘记密码
	 * @方法名: skipForgetPassFront
	 * @param request
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:05:21
	 */
	@RequestMapping(value = "forget_pass.html",method = RequestMethod.GET)
	public String skipForgetPassFront(HttpServletRequest request){
		
		return "finance/member/forget_pass";
	}
	
	/**
	 * 
	 * @描述:找回密码
	 * @方法名: doForgetPassFront
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 AjaxJson
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:05:32
	 */
	@ResponseBody
	@RequestMapping(value = "doForget_pass.html")
	public AjaxJson doForgetPassFront(HttpServletRequest request,Map<String,Object> dataMap){
		AjaxJson j = new AjaxJson();
		//准备数据
		String memNum = request.getParameter("memNum");
		String protectQuest = request.getParameter("protectQuest");
		String protectAnswe = request.getParameter("protectAnswe");
		String verify_number = request.getParameter("verify_number");
		String loginPwd = request.getParameter("loginPwd");
		
		
		Member  member_1 = memberService.selectMemEntiBymemNum(memNum);
		//验证码是否正确
		String verifyNum = WebFrontSession.getVerifyNumber(request);
		if(!verify_number.equals(verifyNum)){
			j.setSuccess(false);
			j.setMessage("验证码输入错误");
			return j;
		}
		//校验会员编号是否存在
		if(member_1==null){
			j.setSuccess(false);
			j.setMessage("会员编号不存在");
			return j;
		}
		//校验密保问题 密保答案是否正确
		if(member_1.getProtectQuest()!=null && member_1.getProtectQuest()!=Integer.valueOf(protectQuest)){
			j.setSuccess(false);
			j.setMessage("密保问题和密保答案不匹配");
			return j;
		}
		if(member_1.getProtectAnswe()!=null && !member_1.getProtectAnswe().equals(protectAnswe)){
			j.setSuccess(false);
			j.setMessage("密保问题和密保答案不匹配");
			return j;
		}
		
		//更新会员密码
		member_1.setLoginPwd(loginPwd);
		memberService.updateMemberById(member_1);
		
		return j;
	}
	
	/**
	 *  
	 * @描述:注销
	 * @方法名: logoutFront
	 * @param request
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午4:57:54
	 */
	@RequestMapping(value="logout.html",method = RequestMethod.GET)
	public String logoutFront(HttpServletRequest request){
		WebFrontSession.removeMemberSession(request);
		return "redirect:login.html";
	}
}
