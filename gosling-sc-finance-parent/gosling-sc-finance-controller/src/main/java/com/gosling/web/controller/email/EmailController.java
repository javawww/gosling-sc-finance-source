package com.gosling.web.controller.email;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gosling.core.json.AjaxJson;
import com.gosling.core.util.PageUtil;
import com.gosling.core.util.ResourceUtil;
import com.gosling.entity.email.EmailMsg;
import com.gosling.entity.member.Member;
import com.gosling.service.email.EmailMsgService;
import com.gosling.service.member.MemberService;
import com.gosling.web.controller.BaseController;
import com.gosling.web.util.WebFrontSession;

/**
 * 
 * @类描述：邮件
 * @项目名称：gosling-sc-finance-controller
 * @包名： com.gosling.web.controller.email
 * @类名称：EmailController
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午4:51:32
 */
@Controller
public class EmailController extends BaseController {
	
	@Resource
	private 			EmailMsgService   			emailMsgService;
	@Resource
	private 			MemberService				memberService;
	
	
	/**
	 * 邮件详情
	 * front/emailMsg_detail.html
	 */
	@RequestMapping(value = "emailMsg_detail.html")
	public String emailMsgDetailFront(HttpServletRequest request,@RequestParam("id")Integer id,Map<String, Object> dataMap){
		EmailMsg email = emailMsgService.getById(id);
		if(email!=null){
			dataMap.put("email", email);
		}
		//更新邮件状态为  已读邮件
		email.setMsgStatus(1);
		emailMsgService.update(email);
		
		return "finance/email/emailMsg_detail";
	}
	
	
	
	/**
	 * 发送邮件
	 * front/emailMsg_send.html
	 */
	@RequestMapping(value = "emailMsg_send.html")
	public String emailMsgFront(HttpServletRequest request,Map<String,Object> dataMap){
		
		return "finance/email/emailMsg_send";
	}
	
	/**
	 * 编辑邮件  执行事件
	 * front/doEmailmsg_add.html
	 */
	@ResponseBody
	@RequestMapping(value  = "doEmailmsg_add.html")
	public AjaxJson doEmailmsgAddFront(HttpServletRequest request,EmailMsg email){
		AjaxJson   j = new AjaxJson();
		//准备数据
		Member member = WebFrontSession.getFrontMember(request);
		//判断收件人编号是否存在
		String receMemNum = request.getParameter("receMemNum");
		Member result_1 = memberService.selectMemEntiBymemNum(receMemNum);
		if(result_1==null){
			j.setSuccess(false);
			j.setMessage("收件人编号不存在");
			return j;
		}
		
		email.setMsgStatus(0);  //0默认未读邮件
		email.setMemNum(member.getMemNum());
		email.setSendid(member.getId());
		email.setReceids(result_1.getMemNum());//对应接收人编号
		int result = emailMsgService.insert(email);
		
		return j;
	}
	
	/**
	 * 已收件列表
	 * front/emailMsg_rece_list.html
	 */
	@RequestMapping(value = "emailMsg_rece_list.html")
	public String emailMsgReceiveListFront(HttpServletRequest request,Map<String, Object> dataMap){
		//准备数据
		Member member = WebFrontSession.getFrontMember(request);
		
		String pagestr = request.getParameter("page");
		String msgStatus = request.getParameter("msgStatus");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		Map<String, Object> whereMap = new HashMap<String, Object>();
		if(msgStatus!=null && !"".equals(msgStatus)){
			whereMap.put("msgStatus", Integer.valueOf(msgStatus));
		}
		whereMap.put("receids", member.getMemNum());
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<EmailMsg> inforList =  emailMsgService.getAllByPage(pageMap);//通过分页查询数据 
		Integer totalRecods = emailMsgService.getTotalPages(whereMap);//总记录数
		
		Integer totalPages = 0;
		if (totalRecods % rowsPerPage == 0) {
			totalPages =  totalRecods / rowsPerPage;
		} else {
			totalPages =  totalRecods / rowsPerPage + 1;
		}
		dataMap.put("inforLists", inforList);//数据
		dataMap.put("totalPages", totalPages);//总页数
		dataMap.put("page", page);//第几页
		dataMap.put("rowsPerPage", rowsPerPage);//一页多少条
		dataMap.put("totalRecods", totalRecods);//共多少条记录
		
		return "finance/email/emailMsg_rece_list";
	}
	
	/**
	 * 发件列表
	 * front/emailMsg_send_list.html
	 */
	@RequestMapping(value = "emailMsg_send_list.html")
	public String emailMsgSendListFront(HttpServletRequest request,Map<String, Object> dataMap){
		//准备数据
		Member member = WebFrontSession.getFrontMember(request);
		
		String pagestr = request.getParameter("page");
		String msgStatus = request.getParameter("msgStatus");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		Map<String, Object> whereMap = new HashMap<String, Object>();
		if(msgStatus!=null && !"".equals(msgStatus)){
			whereMap.put("msgStatus", Integer.valueOf(msgStatus));
		}
		whereMap.put("sendid", member.getId());
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<EmailMsg> inforList =  emailMsgService.getAllByPage(pageMap);//通过分页查询数据 
		Integer totalRecods = emailMsgService.getTotalPages(whereMap);//总记录数
		
		Integer totalPages = 0;
		if (totalRecods % rowsPerPage == 0) {
			totalPages =  totalRecods / rowsPerPage;
		} else {
			totalPages =  totalRecods / rowsPerPage + 1;
		}
		dataMap.put("inforLists", inforList);//数据
		dataMap.put("totalPages", totalPages);//总页数
		dataMap.put("page", page);//第几页
		dataMap.put("rowsPerPage", rowsPerPage);//一页多少条
		dataMap.put("totalRecods", totalRecods);//共多少条记录
		
		
		return "finance/email/emailMsg_send_list";
	}
	
	
}

