package com.gosling.web.controller.currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gosling.core.json.AjaxJson;
import com.gosling.core.util.PageUtil;
import com.gosling.core.util.ResourceUtil;
import com.gosling.entity.bonus.Bonus;
import com.gosling.entity.bonus.BonusInf;
import com.gosling.entity.currency.CurrencyInfo;
import com.gosling.entity.log.Log;
import com.gosling.entity.log.LogInf;
import com.gosling.entity.log.MemberCurrencyLog;
import com.gosling.entity.member.Member;
import com.gosling.entity.system.ParamConf;
import com.gosling.service.bonus.BonusInfService;
import com.gosling.service.bonus.BonusService;
import com.gosling.service.currency.CurrencyInfoService;
import com.gosling.service.log.MemberCurrencyLogService;
import com.gosling.service.member.MemberService;
import com.gosling.service.system.ParamConfService;
import com.gosling.web.controller.BaseController;
import com.gosling.web.util.WebFrontSession;

/**
 * 
 * @类描述：币种信息
 * @项目名称：gosling-sc-finance-controller
 * @包名： com.gosling.web.controller.currency
 * @类名称：CurrencyController
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午4:21:07
 */
@Controller
public class CurrencyController extends BaseController{

	@Resource
	private MemberCurrencyLogService			memberCurrencyLogService;
	@Resource
	private MemberService						memberService;
	@Resource
	private CurrencyInfoService 				currencyInfoService;
	@Resource
	private ParamConfService					paramConfService;
	@Resource
	private BonusService						bonusService;
	@Resource
	private BonusInfService						bonusInfService;
	
	
	/**
	 * 跳转 会员转账
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = "tranMemLists.html")
	public String skipMemberTransFront(HttpServletRequest request,Map<String, Object> dataMap){
		Member  member =  WebFrontSession.getFrontMember(request);
		//通过会员编号 查找所有关于此会员 转账记录  分页查询
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
//		whereMap.put("toMemNum", member.getMemNum());
//		whereMap.put("fromMemNum", member.getMemNum());
		whereMap.put("optType", 1);
		whereMap.put("memNum", member.getMemNum());
		
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<MemberCurrencyLog> inforList =  memberCurrencyLogService.getAllByPage(pageMap);//通过分页查询数据 
		
		Integer totalRecods = memberCurrencyLogService.getTotalPages(whereMap);//总记录数
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
		
		return "finance/exchange/tranMemLists";
	}
	/**
	 * //跳转到奖金明细页面
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = "bonusInf.html")
	public String skipBonusInfFront(HttpServletRequest request,Map<String, Object> dataMap){
		Member member = WebFrontSession.getFrontMember(request);
		
//		List<Bonus> bonus = bonusService.getByMemNum(member_1.getMemNum());
//		dataMap.put("bonus", bonus);
		//通过会员编号 查找所有关于此会员 转账记录  分页查询
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("memNum", member.getMemNum());
		
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<Bonus> inforList =  bonusService.getAllByPage(pageMap);//通过分页查询数据 
		
		Integer totalRecods = bonusService.getTotalPages(whereMap);//总记录数
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
		
		
		return "finance/bonus/bonusInf";
	}
	/**
	 * 财务明细详细页面
	 * bonus_detail.html
	 */
	@RequestMapping(value = "bonus_detail.html")
	public String skipBonusDetailFront(HttpServletRequest request,Map<String,Object> dataMap){
		String bonusId = request.getParameter("id");
//		List<BonusInf> bonusInfs =  bonusInfService.getByBonusId(Integer.valueOf(id));
//		dataMap.put("bonusInfs", bonusInfs);
		
		//通过会员编号 查找所有关于此会员 转账记录  分页查询
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("bonusId", bonusId);
		
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<BonusInf> inforList =  bonusInfService.getAllByPage(pageMap);//通过分页查询数据 
		
		Integer totalRecods = bonusInfService.getTotalPages(whereMap);//总记录数
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
		
		
		
		return "finance/bonus/bonus_detail";
	}
	
	/**
	 * 提现申请页面
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = "postMoney.html")
	public String skipPostMoneyFront(HttpServletRequest request,Map<String, Object> dataMap){
		Member  member =  WebFrontSession.getFrontMember(request);
		//通过会员编号 查找所有关于此会员 转账记录  分页查询
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
//		whereMap.put("toMemNum", member.getMemNum());
//		whereMap.put("fromMemNum", member.getMemNum());
		whereMap.put("optType", 4);
		whereMap.put("memNum", member.getMemNum());
		
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<MemberCurrencyLog> inforList =  memberCurrencyLogService.getAllByPage(pageMap);//通过分页查询数据 
		
		Integer totalRecods = memberCurrencyLogService.getTotalPages(whereMap);//总记录数
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
		
		
		return "finance/currency/postMoney";
	}
	
	/**
	 * 申请提现 执行动作
	 * doTXsubmit.html
	 */
	@ResponseBody
	@RequestMapping(value = "doTXsubmit.html")
	public AjaxJson  doTXSubmitFront(HttpServletRequest request,MemberCurrencyLog currencyLog){
		AjaxJson  j = new AjaxJson();
		//准备数据
		Member currMember = WebFrontSession.getFrontMember(request);
		currMember = memberService.getById(currMember.getId());         //查询当前操作人的信息 获取里面的交易密码
		CurrencyInfo  currencyInf = currencyInfoService.findByMemId(currMember.getId());   //查询当前操作人的钱包有多少
		ParamConf paramConf = paramConfService.getById(1);         
		//校验 二级交易密码是否正确
		String tradePass = request.getParameter("tradePass");
		if(!tradePass.equals(currMember.getTradePwd())){
			j.setSuccess(false);
			j.setMessage("二级交易密码不正确");
			return j;
		}
		BigDecimal  salary = currencyLog.getSalary();    //提现金额   先判断提现的是现金积分还是团队收益
		if(currencyLog.getTxType()==2){//团队收益提现
			//校验 提现金额是否不足
			if(currencyInf.getTeamPoints().compareTo(salary)==-1){
				j.setSuccess(false);
				j.setMessage("团队收益不足");
				return j;
			}
			//1,100,2000,100,0.02 团队收益 每天提现次数,提现最低,提现最高,提现倍数,手续费
			String[] teamIntegralTX = paramConf.getTeamIntegralTX().split(",");
			if(salary.divideAndRemainder(new BigDecimal(teamIntegralTX[3]))[1]!=BigDecimal.ZERO){
				j.setSuccess(false);
				j.setMessage("提现金额不是"+teamIntegralTX[3]+"的倍数");
				return j;
			}
			if(salary.compareTo(new BigDecimal(teamIntegralTX[1]))==-1){
				j.setSuccess(false);
				j.setMessage("提现金额不得低于"+teamIntegralTX[1]);
				return j;
			}
			if(salary.compareTo(new BigDecimal(teamIntegralTX[2])) == 1){
				j.setSuccess(false);
				j.setMessage("提现金额不得高于"+teamIntegralTX[2]);
				return j;
			}
			BigDecimal realSalary = salary.multiply(new BigDecimal(1-Float.valueOf(teamIntegralTX[4])));
			
			currencyInf.setTeamPoints(BigDecimal.ZERO.subtract(salary));
			currencyInfoService.updatePostMoney(currencyInf);
			
			//记录日志
			currencyLog.setMemId(currMember.getId());
			currencyLog.setMemNum(currMember.getMemNum());
			currencyLog.setOptDesc("货币提现");
			currencyLog.setSalary(BigDecimal.ZERO.subtract(salary));
			currencyLog.setTxStatus(1);
			currencyLog.setRealSalary(realSalary);
			Integer result_2 = memberCurrencyLogService.insert(currencyLog);
			
			
		}
		
		if(currencyLog.getTxType()==3){//现金积分提现
			//校验 提现金额是否不足
			if(currencyInf.getCrashPoints().compareTo(salary)==-1){
				j.setSuccess(false);
				j.setMessage("现金积分不足");
				return j;
			}
			//1,100,2000,100,0.02 团队收益 每天提现次数,提现最低,提现最高,提现倍数,手续费
			String[] cashIntegralTX = paramConf.getCashIntegralTX().split(",");
			if(salary.divideAndRemainder(new BigDecimal(cashIntegralTX[3]))[1]!=BigDecimal.ZERO){
				j.setSuccess(false);
				j.setMessage("提现金额不是"+cashIntegralTX[3]+"的倍数");
				return j;
			}
			if(salary.compareTo(new BigDecimal(cashIntegralTX[1]))==-1){
				j.setSuccess(false);
				j.setMessage("提现金额不得低于"+cashIntegralTX[1]);
				return j;
			}
			if(salary.compareTo(new BigDecimal(cashIntegralTX[2])) == 1){
				j.setSuccess(false);
				j.setMessage("提现金额不得高于"+cashIntegralTX[2]);
				return j;
			}
			BigDecimal realSalary = salary.multiply(new BigDecimal(1-Float.valueOf(cashIntegralTX[4])));
			BigDecimal crashPoints=currencyInf.getCrashPoints();
			currencyInf.setCrashPoints(crashPoints.subtract(salary));
			currencyInfoService.updatePostMoney(currencyInf);
			
			//记录日志
			currencyLog.setMemId(currMember.getId());
			currencyLog.setMemNum(currMember.getMemNum());
			currencyLog.setOptDesc("货币提现");
			currencyLog.setSalary(BigDecimal.ZERO.subtract(salary));
			currencyLog.setTxStatus(1);
			currencyLog.setRealSalary(realSalary);
			Integer result_2 = memberCurrencyLogService.insert(currencyLog);
		}
		
		return j;
	}
	
	/**
	 * 提现撤销操作 
	 * revoke	
	 */
	@ResponseBody
	@RequestMapping(value = "revokeMoney.html")
	 public AjaxJson memberDj(HttpServletRequest request,Map<String,Object> dataMap,int id){
		AjaxJson j=new AjaxJson();
		//准备数据
		Member currMember = WebFrontSession.getFrontMember(request);
		String memNum=currMember.getMemNum();   //获取当前操作人的名字、
		//根据id和memNum查询到要撤销提现的那条记录
		MemberCurrencyLog currencyLog=memberCurrencyLogService.geyAllMessage(id,memNum); 
		BigDecimal salary=currencyLog.getSalary();
		//查询出操作人的钱包
		CurrencyInfo  currencyInf = currencyInfoService.findByMemId(currMember.getId());
		if(currencyLog.getTxType()==2){//撤销团队收益提现
			BigDecimal teamPoints=currencyInf.getTeamPoints();
			currencyInf.setTeamPoints(teamPoints.subtract(salary));
			int result_1=currencyInfoService.updatePostMoney(currencyInf);
			if(result_1==0){
				j.setSuccess(false);
				j.setMessage("操作失败");
				return j;
			}
		}	
		if(currencyLog.getTxType()==3){//撤销现金积分提现
			BigDecimal crashPoints=currencyInf.getCrashPoints();
			currencyInf.setCrashPoints(crashPoints.subtract(salary));
			int result_2=currencyInfoService.updatePostMoney(currencyInf);
			if(result_2==0){
				j.setSuccess(false);
				j.setMessage("操作失败");
				return j;
			}
	}
		return j;
}	
	/**
	 * 货币充值  页面
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = "rechargeLists.html")
	public String skipRechargeLists(HttpServletRequest request,Map<String, Object> dataMap){
		Member member = WebFrontSession.getFrontMember(request);
		member = memberService.getById(member.getId());
		dataMap.put("member", member);
		
		//通过会员编号 查找所有关于此会员 转账记录  分页查询
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
	//				whereMap.put("toMemNum", member.getMemNum());
	//				whereMap.put("fromMemNum", member.getMemNum());
		whereMap.put("optType", 2);
		whereMap.put("memNum", member.getMemNum());
		
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<MemberCurrencyLog> inforList =  memberCurrencyLogService.getAllByPage(pageMap);//通过分页查询数据 
		
		Integer totalRecods = memberCurrencyLogService.getTotalPages(whereMap);//总记录数
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
		
		return "finance/recharge/rechargeLists";
	}
	/**
	 * 币种兑换 页面 
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = "tranMoneyList.html")
	public String skipTranMoneyList(HttpServletRequest request,Map<String, Object> dataMap){
		Member  member =  WebFrontSession.getFrontMember(request);
		//通过会员编号 查找所有关于此会员 转账记录  分页查询
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
//		whereMap.put("toMemNum", member.getMemNum());
//		whereMap.put("fromMemNum", member.getMemNum());
		whereMap.put("optType", 3);
		whereMap.put("memNum", member.getMemNum());
		
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<MemberCurrencyLog> inforList =  memberCurrencyLogService.getAllByPage(pageMap);//通过分页查询数据 
		
		Integer totalRecods = memberCurrencyLogService.getTotalPages(whereMap);//总记录数
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
		
		
		return "finance/exchange/tranMoneyList";
	}
	
	/**
	 * 记录  会员转账数据
	 * @param request
	 * @param currencyLog
	 * @return
	 */
	@RequestMapping(value = "doMemberTran.html") 
	@ResponseBody
	public AjaxJson memberTranFront(HttpServletRequest request,MemberCurrencyLog currencyLog){
		AjaxJson  j = new AjaxJson();
		//准备数据
		Member currMember = WebFrontSession.getFrontMember(request);
		currMember = memberService.getById(currMember.getId());
		CurrencyInfo  currencyInf = currencyInfoService.findByMemId(currMember.getId());
		ParamConf paramConf = paramConfService.getById(1);
		String[] activeInteg2activeInteg = paramConf.getActiveInteg2activeInteg().split(",");
		//校验转入会员是否存在
		String toMemNum = request.getParameter("toMemNum");
		Integer result_1 = memberService.findmemberByNum(toMemNum);
		Member toMember = null;
		if(result_1==0){
			j.setSuccess(false);
			j.setMessage("转入会员编号不存在");
			return j;
		}else{
			toMember = memberService.selectMemEntiBymemNum(toMemNum);
		}
		//不可以自己转账给自己
		if(currMember.getMemNum().equals(toMemNum)){
			j.setSuccess(false);
			j.setMessage("不可以转账给自己账户");
			return j;
		}
		//校验 二级交易密码是否正确
		String tradePass = request.getParameter("tradePass");
		if(!tradePass.equals(currMember.getTradePwd())){
			j.setSuccess(false);
			j.setMessage("二级交易密码不正确");
			return j;
		}
		//校验 转入金额 是否满足条件
		BigDecimal  salary = currencyLog.getSalary();
		if(currencyInf.getActivPenn().compareTo(salary)==-1){
			j.setSuccess(false);
			j.setMessage("激活积分不足");
			return j;
		}
		//100,2000,100 最低额度,最高额度,转换倍数
		if(salary.divideAndRemainder(new BigDecimal(activeInteg2activeInteg[2]))[1]!=BigDecimal.ZERO){
			j.setSuccess(false);
			j.setMessage("转账金额不是"+activeInteg2activeInteg[2]+"的倍数");
			return j;
		}
		if(salary.compareTo(new BigDecimal(activeInteg2activeInteg[0]))==-1){
			j.setSuccess(false);
			j.setMessage("转账金额不得低于"+activeInteg2activeInteg[0]);
			return j;
		}
		if(salary.compareTo(new BigDecimal(activeInteg2activeInteg[1])) == 1){
			j.setSuccess(false);
			j.setMessage("转账金额不得高于"+activeInteg2activeInteg[1]);
			return j;
		}
		//---------------------------------
		//更新当前会员  激活积分  减少
		CurrencyInfo currenInfo_1 = new CurrencyInfo();
		currenInfo_1.setMemNum(currMember.getMemNum());
		currenInfo_1.setActivPenn(BigDecimal.ZERO.subtract(salary));//负值  减少操作
		int  result_3 = currencyInfoService.updateIntegralVal(currenInfo_1);
		//记录日志
		currencyLog.setMemId(currMember.getId());
		currencyLog.setMemNum(currMember.getMemNum());
		currencyLog.setFromMemNum(currMember.getMemNum());//转出会员编号
		currencyLog.setToMemNum(toMember.getMemNum());//转入会员编号
		currencyLog.setOptDesc("转出");
		currencyLog.setSalary(BigDecimal.ZERO.subtract(salary));
		Integer result_2 = memberCurrencyLogService.insert(currencyLog);
		//更新转入会员  激活积分  增加
		CurrencyInfo currenInfo_2 = new CurrencyInfo();
		currenInfo_2.setMemNum(toMember.getMemNum());
		currenInfo_2.setActivPenn(salary);//负值  减少操作
		int  result_4 = currencyInfoService.updateIntegralVal(currenInfo_2);
		//记录日志 
		MemberCurrencyLog  currencyLog_2 = new MemberCurrencyLog();
		currencyLog_2.setMemId(toMember.getId());
		currencyLog_2.setMemNum(toMember.getMemNum());
		currencyLog_2.setFromMemNum(currMember.getMemNum());//转出会员编号
		currencyLog_2.setToMemNum(toMember.getMemNum());//转入会员编号
		currencyLog_2.setOptDesc("转入");
		currencyLog_2.setSalary(salary);
		currencyLog_2.setCurrenType(currencyLog.getCurrenType());
		currencyLog_2.setOptType(currencyLog.getOptType());
		Integer result_5 = memberCurrencyLogService.insert(currencyLog_2);
		
		
		
	    return j;
	}
	
	/**
	 * 币种兑换  提交事件
	 */
	@ResponseBody
	@RequestMapping(value = "doCurrencyDH.html")
	public AjaxJson doCUrrencyDHFront(HttpServletRequest request,MemberCurrencyLog currencyLog){
		AjaxJson  j = new AjaxJson();
		//准备数据
		Member currMember = WebFrontSession.getFrontMember(request);
		currMember = memberService.getById(currMember.getId());
		CurrencyInfo  currencyInf = currencyInfoService.findByMemId(currMember.getId());
		ParamConf paramConf = paramConfService.getById(1);
		BigDecimal  salary = currencyLog.getSalary();
		//校验 二级交易密码是否正确
		String tradePass = request.getParameter("tradePass");
		if(!tradePass.equals(currMember.getTradePwd())){
			j.setSuccess(false);
			j.setMessage("二级交易密码不正确");
			return j;
		}
		//团队收益  转换  激活积分
		String[] teamInteg2ActiveInteg = paramConf.getTeamInteg2ActiveInteg().split(",");
		if(currencyLog.getFromCurrenType() == 2){
			if(currencyInf.getTeamPoints().compareTo(salary)==-1){
				j.setSuccess(false);
				j.setMessage("团队收益不足");
				return j;
			}
			//100,2000,100 最低额度,最高额度,转换倍数
			if(salary.divideAndRemainder(new BigDecimal(teamInteg2ActiveInteg[2]))[1]!=BigDecimal.ZERO){
				j.setSuccess(false);
				j.setMessage("兑换金额不是"+teamInteg2ActiveInteg[2]+"的倍数");
				return j;
			}
			if(salary.compareTo(new BigDecimal(teamInteg2ActiveInteg[0]))==-1){
				j.setSuccess(false);
				j.setMessage("兑换金额不得低于"+teamInteg2ActiveInteg[0]);
				return j;
			}
			if(salary.compareTo(new BigDecimal(teamInteg2ActiveInteg[1])) == 1){
				j.setSuccess(false);
				j.setMessage("兑换金额不得高于"+teamInteg2ActiveInteg[1]);
				return j;
			}
			//更新当前会员 团队收益 减少  激活积分 增加
			CurrencyInfo currenInfo_1 = new CurrencyInfo();
			currenInfo_1.setMemNum(currMember.getMemNum());
			currenInfo_1.setTeamPoints(BigDecimal.ZERO.subtract(salary));
			currenInfo_1.setActivPenn(salary);
			int  result_3 = currencyInfoService.updateIntegralVal(currenInfo_1);
			//记录日志
			currencyLog.setMemId(currMember.getId());
			currencyLog.setMemNum(currMember.getMemNum());
			currencyLog.setOptDesc("币种兑换");
			Integer result_2 = memberCurrencyLogService.insert(currencyLog);
			
		}
		//现金积分 转换  激活积分
		String[] cashInteg2ActiveInteg = paramConf.getCashInteg2ActiveInteg().split(",");
		if(currencyLog.getFromCurrenType() == 3){
			if(currencyInf.getCrashPoints().compareTo(salary)==-1){
				j.setSuccess(false);
				j.setMessage("现金积分不足");
				return j;
			}
			//100,2000,100 最低额度,最高额度,转换倍数
			if(salary.divideAndRemainder(new BigDecimal(cashInteg2ActiveInteg[2]))[1]!=BigDecimal.ZERO){
				j.setSuccess(false);
				j.setMessage("兑换金额不是"+cashInteg2ActiveInteg[2]+"的倍数");
				return j;
			}
			if(salary.compareTo(new BigDecimal(cashInteg2ActiveInteg[0]))==-1){
				j.setSuccess(false);
				j.setMessage("兑换金额不得低于"+cashInteg2ActiveInteg[0]);
				return j;
			}
			if(salary.compareTo(new BigDecimal(cashInteg2ActiveInteg[1])) == 1){
				j.setSuccess(false);
				j.setMessage("兑换金额不得高于"+cashInteg2ActiveInteg[1]);
				return j;
			}
			//更新当前会员 现金积分 减少  激活积分 增加
			CurrencyInfo currenInfo_1 = new CurrencyInfo();
			currenInfo_1.setMemNum(currMember.getMemNum());
			currenInfo_1.setCrashPoints(BigDecimal.ZERO.subtract(salary));
			currenInfo_1.setActivPenn(salary);
			int  result_3 = currencyInfoService.updateIntegralVal(currenInfo_1);
			//记录日志
			currencyLog.setMemId(currMember.getId());
			currencyLog.setMemNum(currMember.getMemNum());
			currencyLog.setOptDesc("币种兑换");
			Integer result_2 = memberCurrencyLogService.insert(currencyLog);
			
		}
		
		return j;
		
	}
	
	/**
	 * 会员充值  执行动作
	 * doRechargeInfo.html
	 */
	@ResponseBody
	@RequestMapping(value = "doRechargeInfo.html")
	public AjaxJson  doRechargeInfoFront(HttpServletRequest request,MemberCurrencyLog currencyLog){
		AjaxJson   j = new AjaxJson();
		//准备数据
		Member currMember = WebFrontSession.getFrontMember(request);
		currMember = memberService.getById(currMember.getId());
		BigDecimal  salary = currencyLog.getSalary();
		//校验 二级交易密码是否正确
		String tradePass = request.getParameter("tradePass");
		if(!tradePass.equals(currMember.getTradePwd())){
			j.setSuccess(false);
			j.setMessage("二级交易密码不正确");
			return j;
		}
		//记录日志
		currencyLog.setMemId(currMember.getId());
		currencyLog.setMemNum(currMember.getMemNum());
		currencyLog.setOptDesc("货币充值");
		currencyLog.setSalary(salary);
		currencyLog.setRechargeStatus(1);
		Integer result_2 = memberCurrencyLogService.insert(currencyLog);
		
		return j;
	}
	
	/**
	 * 财务明细  也就是收支明细
	 * logInf.html
	 */
	@RequestMapping(value = "logInf.html")
	public String skipLogPageFront(HttpServletRequest request,Map<String, Object> dataMap){
		Member member = WebFrontSession.getFrontMember(request);
		
//		List<Bonus> bonus = bonusService.getByMemNum(member_1.getMemNum());
//		dataMap.put("bonus", bonus);
		//通过会员编号 查找所有关于此会员 转账记录  分页查询
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("memberNum", member.getMemNum());
		
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<Log> inforList =  memberCurrencyLogService.getAllByPage_log(pageMap);//通过分页查询数据 
		
		Integer totalRecods = memberCurrencyLogService.getTotalPages_log(whereMap);//总记录数
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
		
		
		return "finance/log/logInf";
	}
	/**
	 * 财务明细  各个币种信息变化  详情页面
	 * loginf_detail.html
	 */
	@RequestMapping(value = "loginf_detail.html")
	public String skipLoginfDetailFront(HttpServletRequest request,Map<String,Object> dataMap){
		String logPid = request.getParameter("id");
		
		//通过会员编号 查找所有关于此会员 转账记录  分页查询
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("logPid", logPid);
		
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<LogInf> inforList =  memberCurrencyLogService.getAllByPage_loginf(pageMap);//通过分页查询数据 
		
		Integer totalRecods = memberCurrencyLogService.getTotalPages_loginf(whereMap);//总记录数
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
		
		return "finance/log/loginf_detail";
	}
	
	
}
