package com.gosling.web.controller.member;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gosling.core.json.AjaxJson;
import com.gosling.entity.member.Member;
import com.gosling.service.bonus.BonusInfService;
import com.gosling.service.bonus.BonusService;
import com.gosling.service.currency.CurrencyInfoService;
import com.gosling.service.log.MemberCurrencyLogService;
import com.gosling.service.member.MemberService;
import com.gosling.service.menu.MenuService;
import com.gosling.service.system.ParamConfService;
import com.gosling.web.controller.BaseController;
import com.gosling.web.util.WebFrontSession;

/**
 * 
 * @类描述：会员
 * @项目名称：gosling-sc-finance-controller
 * @包名： com.gosling.web.controller.member
 * @类名称：MemberController
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午5:07:17
 */
@Controller
public class MemberController extends BaseController{
	
	@Resource
	private MemberService				memberService;
	@Resource
	private MenuService					menuService;
	@Resource
	private CurrencyInfoService     currencyInfoService;
	@Resource
	private ParamConfService		paramConfService;
	@Resource
	private MemberCurrencyLogService	memberCurrencyLogService;
	@Resource
	private BonusService				bonusService;
	@Resource
	private BonusInfService 			bonusInfService;
	
	/**
	 * 
	 * @描述:资料修改
	 * @方法名: memberInfoEditFront
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:08:30
	 */
	@RequestMapping(value = "memberInfo_edit.html")
	public String memberInfoEditFront(HttpServletRequest request,Map<String, Object> dataMap){
		Member member = WebFrontSession.getFrontMember(request);
		member = memberService.getById(member.getId());
		dataMap.put("member", member);
		return "finance/member/memberInfo_edit";
	}
	
	/**
	 * 
	 * @描述:密码修改
	 * @方法名: memberPassEditFront
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:08:47
	 */
	@RequestMapping(value = "memberPass_edit.html")
	public String memberPassEditFront(HttpServletRequest request,Map<String, Object> dataMap){
		Member member = WebFrontSession.getFrontMember(request);
		member = memberService.getById(member.getId());
		dataMap.put("member", member);
		
		return "finance/member/memberPass_edit";
	}
	
	/**
	 * 
	 * @描述:更新会员信息
	 * @方法名: doUpdateMemberInfoFront
	 * @param request
	 * @param member
	 * @return
	 * @返回类型 AjaxJson
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:09:13
	 */
	@ResponseBody
	@RequestMapping(value = "doUpdateMemberInfo.html")
	public AjaxJson doUpdateMemberInfoFront(HttpServletRequest request,Member member){
		 AjaxJson  j = new AjaxJson();
		 Integer result_1 = memberService.updateMemberById(member);
		 if(result_1==0){
			 j.setSuccess(false);
			 j.setMessage("操作失败,请稍后重试");
		 }
		 return j;
	 }
	
}
