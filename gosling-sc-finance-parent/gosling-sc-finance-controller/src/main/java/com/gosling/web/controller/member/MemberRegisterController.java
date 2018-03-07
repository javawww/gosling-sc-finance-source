package com.gosling.web.controller.member;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gosling.core.json.AjaxJson;
import com.gosling.core.util.PageUtil;
import com.gosling.core.util.ResourceUtil;
import com.gosling.entity.bonus.Bonus;
import com.gosling.entity.bonus.BonusInf;
import com.gosling.entity.currency.CurrencyInfo;
import com.gosling.entity.log.Log;
import com.gosling.entity.log.LogInf;
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
 * @类描述：注册
 * @项目名称：gosling-sc-finance-controller
 * @包名： com.gosling.web.controller.member
 * @类名称：MemberRegisterController
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午5:12:29
 */
@Controller
public class MemberRegisterController extends BaseController{

	@Resource
	private MemberService			memberService;
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
	 * @描述:注册页面
	 * @方法名: skipRegisterFront
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:13:18
	 */
	@RequestMapping(value = "register.html")
	public String skipRegisterFront(HttpServletRequest request,Map<String, Object> dataMap){
		//获取推荐人 编号
		Member member_1 = WebFrontSession.getFrontMember(request);
		dataMap.put("member", member_1);
		
		//如何获取节点人编号
		//小公排   注册会员都在个人网体下   排网方式：从左到右  从上到下
		
		//根据当前会员编号查找其下面哪个会员存在 空位  
//		Member jdrMember = findJdrNumByCurrMember(member_1);
		List<Member> members = new ArrayList<Member>();
		members.add(member_1);
		
		Member jdrMember = getJiedianMember(members,0);
		//定A  B左右
//		List<Member> members_1 = memberService.getByTjrMemNum(member.getMemNum());
		
//		List<Member> members = getTreeNodeDtoByJdrNum(member_1);//通过接点人编号构建
//		System.out.println(JSON.toJSONString(members, true));
		
		//递归遍历多叉树 结构
//		Member members_3 = iteratorTree(members,0);
		dataMap.put("members_3", jdrMember);
		
		return "finance/member/register/register";
	}
	
	/**
	 * 
	 * @描述:未激活会员
	 * @方法名: skipActivation
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:15:21
	 */
	@RequestMapping(value = "activation.html")
	public String skipActivation(HttpServletRequest request,Map<String, Object> dataMap){
		Member member = WebFrontSession.getFrontMember(request);
		
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("jhState", 1);
		whereMap.put("tjrNum", member.getMemNum());
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<Member> inforList =  memberService.getAllByPage(pageMap);//通过分页查询数据 
		Integer totalRecods = memberService.getTotalPages(whereMap);//总记录数
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
		
		return "finance/member/activity/activation";
	}
	
	/**
	 * 
	 * @描述:在线注册
	 * @方法名: doregisterFront
	 * @param request
	 * @param member
	 * @return
	 * @返回类型 AjaxJson
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:15:55
	 */
	@RequestMapping(value = "doregister.html")
	@ResponseBody
	public AjaxJson doregisterFront(HttpServletRequest request,Member member){
		AjaxJson j = new AjaxJson();
		//查询会员编号是否存在
		Integer result_1 = memberService.findmemberByNum(member.getMemNum());
		if(result_1==1){
			j.setSuccess(false);
			j.setMessage("会员编号已存在");
			return j;
		}
		
		//查询接点人编号是否存在
		Integer result_2 = memberService.findmemberByNum(member.getJiedianNum());
		if(result_2==0){
			j.setSuccess(false);
			j.setMessage("接点人编号不存在");
			return j;
		}
		
		//设置区域默认A区
		String areaType = "A";
		//校验接点人是否存在未激活账号
		List<Member>  members_1 = memberService.getMemberListByJiedianNum(member.getJiedianNum());
		if(members_1.size()>0){
			for (Member member_1 : members_1) {
				if(member_1.getJhState()==1){
					j.setSuccess(false);
					j.setMessage("接点人存在未激活账号,暂时不可注册");
					return j;
				}
			}
			//存在一个接点人了  所以设置区域为B区
			areaType = "B";
		}
		
		
		//经过重重校验  开始进行数据存储
		
		member.setJhState(1);//激活状态 默认 1未激活 2激活
		member.setDjState(1);//冻结状态  默认 1解冻 2 冻结
		member.setRoleState(1);//角色类型  默认1 普通会员
		member.setZtAmounts(0);
		member.setTeamAmounts(0);
		member.setaCounts(0);
		member.setbCounts(0);
		member.setAreaType(areaType);
		member.setIsLayerOver(1);//默认在局 状态
		
		Integer result_3 = memberService.saveMember(member);
		if(result_3==1){
			Member member_1 = memberService.selectMemEntiBymemNum(member.getMemNum());
			//为会员初始化 一条币种信息记录
			CurrencyInfo  currencyInfo = new CurrencyInfo();
			currencyInfo.setMemid(member_1.getId());
			currencyInfo.setMemNum(member_1.getMemNum());
			currencyInfo.setActivPenn(BigDecimal.ZERO);
			currencyInfo.setTeamPoints(BigDecimal.ZERO);
			currencyInfo.setCrashPoints(BigDecimal.ZERO);
			
			currencyInfoService.addCommon(currencyInfo);
		}
		return j;
	}
	
	/**
	 * 
	 * @描述:直推关系图谱
	 * @方法名: directionLinksFront
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:16:22
	 */
	@RequestMapping(value = "directionLinks.html",method = RequestMethod.GET)
	public String  directionLinksFront(HttpServletRequest request,Map<String, Object> dataMap){
		
		Member member = WebFrontSession.getFrontMember(request);
		member = memberService.getById(member.getId());
		//所有直推人员  即 推荐人编号为当前会员
		List<Member> memberModel = getTreeNodeDto(member);
//		List<Member> members =  memberService.getByTjrMemNum(member.getMemNum());
//		dataMap.put("member", member);
		dataMap.put("memberModel", memberModel);
		
		return "finance/direction/directionLinks";
	}
	
	/**
	 * 
	 * @描述:小公排安置图谱
	 * @方法名: contactLinksFront
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:16:59
	 */
	@RequestMapping(value = "contactLinks.html",method = RequestMethod.GET)
	public String  contactLinksFront(HttpServletRequest request,Map<String,Object> dataMap){
		Member member_1 = WebFrontSession.getFrontMember(request);
		member_1 = memberService.getById(member_1.getId());
		String memNum = request.getParameter("memNum");
		if(memNum!=null){
			member_1 = memberService.selectMemEntiBymemNum(memNum);
		}
		
		List<Member> members = getTreeNodeDtoByJdrNum(member_1);//通过接点人编号构建
		dataMap.put("members", members);
		
		return "finance/contact/contactLinks";
	}
	
	/**
	 * 
	 * @描述:我的推荐
	 * @方法名: skipMyRecommMembers
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:17:47
	 */
	@RequestMapping(value = "myrecommMembers.html")
	public String skipMyRecommMembers(HttpServletRequest request,Map<String,Object> dataMap){
		Member member = WebFrontSession.getFrontMember(request);
		
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("jhState", 2);
		whereMap.put("tjrNum", member.getMemNum());
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<Member> inforList =  memberService.getAllByPage(pageMap);//通过分页查询数据 
		Integer totalRecods = memberService.getTotalPages(whereMap);//总记录数
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
		
		return "finance/member/recommend/myrecommMembers";
	}
	/**
	 * 
	 * @描述:推广注册
	 * @方法名: tgRegisterFront
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:18:12
	 */
	@RequestMapping(value = "tgRegister.html")
	public String tgRegisterFront(HttpServletRequest request,Map<String,Object> dataMap){
		//推荐人 编号获取
		String memNo = request.getParameter("memNo");
		dataMap.put("memNo", memNo);
		Member  member_1 = memberService.selectMemEntiBymemNum(memNo);
		//接点人编号
//		List<Member> members = getTreeNodeDtoByJdrNum(member_1);//通过接点人编号构建
		
		List<Member> members = new ArrayList<Member>();
		members.add(member_1);
		//递归遍历多叉树 结构
//		Member members_2 = iteratorTree(members,0);
		//根据当前会员编号查找其下面哪个会员存在 空位  
//		Member jdrMember = findJdrNumByCurrMember(member_1);
		Member jdrMember = getJiedianMember(members,0);
		dataMap.put("members_2", jdrMember);
		
		return "finance/member/register/tgRegister.html";
	}
	
	/**
	 * 
	 * @描述:删除未激活会员
	 * @方法名: delWjhMemberFront
	 * @param request
	 * @param id
	 * @param dataMap
	 * @return
	 * @返回类型 AjaxJson
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:18:37
	 */
	@RequestMapping(value = "member_del.html")
	@ResponseBody
	public AjaxJson  delWjhMemberFront(HttpServletRequest request,@RequestParam("id") Integer id,Map<String,Object> dataMap){
		AjaxJson  j = new AjaxJson();
		Integer result_1  = memberService.deleteById(id);
		if(result_1==0){
			j.setSuccess(false);
			j.setMessage("操作失败，请稍后重试");
			return j;
		}
		return j;
	}
	
	/**
	 * 
	 * @描述:激活页面
	 * @方法名: skipActivePageFront
	 * @param request
	 * @param id
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:18:57
	 */
	@RequestMapping(value = "active_page.html")
	public String skipActivePageFront(HttpServletRequest request,@RequestParam("id") Integer id,Map<String,Object> dataMap){
		//对应会员
		Member member_1 = memberService.getById(id);
		dataMap.put("member_1", member_1);
		//激活积分参数配置   多少元一单
		ParamConf paramConf = paramConfService.getById(1);
		BigDecimal singlePrice = paramConf.getSinglePrice();
		dataMap.put("singlePrice", singlePrice);
		
		return "finance/member/activity/active_page";
	}
	
	/**
	 * 
	 * @描述:更新激活
	 * @方法名: doActiveMemberFront
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 AjaxJson
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午5:19:25
	 */
	@RequestMapping(value = "doActiveMember.html")
	@ResponseBody
	public AjaxJson  doActiveMemberFront(HttpServletRequest request,Map<String, Object> dataMap){
		AjaxJson j = new AjaxJson();
		//准备数据
		String activeMemNum = request.getParameter("memNum");   //当前激活的会员编号
		Member member_2 = memberService.selectMemEntiBymemNum(activeMemNum);//当前激活的会员对象
		
		String tradePass = request.getParameter("tradePass"); //获得交易密码
		Member member_1 = WebFrontSession.getFrontMember(request);
		member_1 = memberService.getById(member_1.getId());        //当前登录会员对象
		
		CurrencyInfo currencyInfo = currencyInfoService.findByMemId(member_1.getId()); //当前登录会员币种对象
		
		ParamConf paramConf = paramConfService.getById(1);//全局参数配置
		
		//校验二级密码
		if(!member_1.getTradePwd().equals(tradePass)){
			j.setSuccess(false);
			j.setMessage("二级交易密码输入错误");
			return j;
		}
		
		//校验激活积分是否满足
		BigDecimal singlePrice = paramConf.getSinglePrice();        //需要多少激活积分才能激活
		BigDecimal directivePrice = paramConf.getDirectivePrice();	//直推一单的收益
		
		if(currencyInfo.getActivPenn().compareTo(singlePrice)==-1){
			j.setSuccess(false);
			j.setMessage("激活积分不足");
			return j;
		}
				
		//校验通过 更新激活会员信息
		member_2.setJhState(2);//已激活
		member_2.setJhTime(new Date());//激活时间
		memberService.updateMemberById(member_2);//执行sql语句
		
		//单独的更新推荐数量  即 直推数量 +1   --- 推荐人编号
		Member member_tjr = memberService.selectMemEntiBymemNum(member_2.getTjrNum());
		member_tjr.setZtAmounts(member_tjr.getZtAmounts()+1);
		memberService.updateMemberById(member_tjr);
		
		// 团队数量 +1   ----  推荐人 编号
		updateMemTeamCounts(member_2.getTjrNum(),0);
		
		//A区数量+1 B区数量 +1   ---  接点人编号
		updateMemAreaCounts(member_2,0);
		
		//减少当前会员激活积分  增加当前会员现金积分
		CurrencyInfo _currencyInfo = new CurrencyInfo();
		_currencyInfo.setMemNum(member_1.getMemNum());
		_currencyInfo.setActivPenn(BigDecimal.ZERO.subtract(singlePrice));
		_currencyInfo.setCrashPoints(directivePrice);
		currencyInfoService.updateIntegralVal(_currencyInfo);
		
		CurrencyInfo finalCurrencyInfo = currencyInfoService.findByMemId(member_1.getId());//更新会员币种信息金额后
		//***********************************************************************************************************************
		//奖金明细  对应日志记录信息  记录推荐奖奖金统计表  一方   【推荐奖】 即【现金积分】  【收入】
		Bonus bonus =  bonusService.getByCurrDateAndMemNum(member_1.getMemNum());//通过当前日期获取一条记录
		if(bonus == null){//如果为空 新增一条记录时   推荐奖和层奖  和总收益  默认为当前会员 币种信息金额
			Bonus bonus_1 = new Bonus();
			bonus_1.setMemNum(member_1.getMemNum());
			bonus_1.setTjrBonus(finalCurrencyInfo.getCrashPoints());//初始化推荐奖
			bonus_1.setLayerBonus(finalCurrencyInfo.getTeamPoints());//初始化层奖
			bonus_1.setTotalBonus(finalCurrencyInfo.getCrashPoints().add(finalCurrencyInfo.getTeamPoints()));//初始化总收益
			Integer result_1 = bonusService.insert(bonus_1);
			bonus =  bonusService.getByCurrDateAndMemNum(member_1.getMemNum());
		}else{//如果已经存在  更新处理  对应的推荐奖  层奖  总收益 依次累加处理
			bonus.setTjrBonus(directivePrice);
			bonus.setTotalBonus(directivePrice);
			Integer result = bonusService.updateBonus(bonus);
		}
		//奖金明细  对应日志记录信息  记录推荐奖奖金明细表  多方
		BonusInf   bonusInf = new BonusInf();
		bonusInf.setBonusDesc("会员:"+activeMemNum+"被激活时获得的推荐奖");
		bonusInf.setBonusStatus(2);//2、默认结算状态  秒结秒发
		bonusInf.setBonusType(2);//2、推荐奖
		bonusInf.setBonusSalar(directivePrice);
		bonusInf.setBonusId(bonus.getId());//关联一方
		bonusInf.setMemNum(member_1.getMemNum());//关联会员编号
		
		Integer result_2 = bonusInfService.insert(bonusInf);
		//***********************************************************************************************************************
		//记录财务明细 记录一条 日志信息  【激活积分】 【支出】
		Log   log = memberCurrencyLogService.getByCurrDateAndMemNum(member_1.getMemNum());
		if(log==null){//如果为空  新增一条记录时   团队收益  现金积分  激活积分  总收益  默认为当前会员 币种信息金额
			Log  log_1 = new Log();
			log_1.setMemberNum(member_1.getMemNum());
			log_1.setLayerBonus(finalCurrencyInfo.getTeamPoints());//初始化层奖
			log_1.setTjrBonus(finalCurrencyInfo.getCrashPoints());// 初始化推荐奖
			log_1.setActiveBonus(finalCurrencyInfo.getActivPenn());//初始化激活积分
			log_1.setTotalBonus(finalCurrencyInfo.getTeamPoints().add(finalCurrencyInfo.getCrashPoints()).add(finalCurrencyInfo.getActivPenn()));//初始化总收益
			
			Integer result = memberCurrencyLogService.insertLog(log_1);
			log = memberCurrencyLogService.getByCurrDateAndMemNum(member_1.getMemNum());
		}else{//如果已经存在  更新处理 对应 团队收益  现金积分 激活积分 总收益  依次累加处理
			log.setActiveBonus(BigDecimal.ZERO.subtract(singlePrice));
			log.setTotalBonus(BigDecimal.ZERO.subtract(singlePrice));
			
			Integer result = memberCurrencyLogService.updateLog(log);
		}
		//财务明细  记录日志信息  记录激活积分变动   多方
		LogInf loginf_1 = new LogInf();
		loginf_1.setCurrencyType(1);
		loginf_1.setSalary(BigDecimal.ZERO.subtract(singlePrice));//扣除  负数
		loginf_1.setOrigSalary(currencyInfo.getActivPenn());//原始激活积分
		loginf_1.setPreSalary(finalCurrencyInfo.getActivPenn());//当前激活积分
		loginf_1.setOptDesc("会员:"+activeMemNum+"被激活时扣除激活积分");
		loginf_1.setMemNum(member_1.getMemNum());//关联会员编号
		loginf_1.setLogPid(log.getId());//关联日志一方
		
		Integer result = memberCurrencyLogService.insertLoginf(loginf_1);
		//记录一条 日志信息  【现金积分】 【 收入】
		LogInf loginf_2 = new LogInf();
		loginf_2.setCurrencyType(3);
		loginf_2.setSalary(directivePrice);//正数
		loginf_2.setOrigSalary(currencyInfo.getCrashPoints());//原始现金积分
		loginf_2.setPreSalary(finalCurrencyInfo.getCrashPoints());//当前现金积分
		loginf_2.setOptDesc("会员:"+activeMemNum+"被激活时获得的推荐奖进入现金积分");
		loginf_2.setMemNum(member_1.getMemNum());//关联会员编号
		loginf_2.setLogPid(log.getId());//关联日志一方
		
		memberCurrencyLogService.insertLoginf(loginf_2);
		//*********************************************************************************************************************
		//层奖计算
		iteratorTeamCrash(member_2,member_2.getMemNum(),0);
		
		return j;
	}
	//---------------------------------------------------------------------------------
	private List<Member> getTreeNodeDto(Member member) {
		List<Member> depList=memberService.selectAllMemsByjhState(2);
		List<Member> resultList = new ArrayList<Member>();
		Member rootNode = new Member();
		rootNode.setMemNum(member.getMemNum());
		rootNode.setZtAmounts(member.getZtAmounts());
		rootNode.setTeamAmounts(member.getTeamAmounts());
		rootNode.setJhState(member.getJhState());//获取激活状态
		
		if(depList.size()>0){
			rootNode=constructTree(rootNode, depList, 0);
			resultList.add(rootNode);
		}
		return resultList;
	}
	
	private Member constructTree(Member rootNode, List<Member> orgList, int rootLevel) {
		List<Member> childNodeList = new ArrayList<Member>();
		for(int i=0; i<orgList.size(); i++){
			Member org = orgList.get(i);
			if(org.getTjrNum()!=null && org.getTjrNum().equalsIgnoreCase(rootNode.getMemNum())){
				Member childNode = new Member();
				childNode.setMemNum(org.getMemNum());
				childNode.setParent(rootNode);
				childNode.setLevel(rootLevel+1);
				childNode.setZtAmounts(org.getZtAmounts());
				childNode.setTeamAmounts(org.getTeamAmounts());
				childNode.setJhState(org.getJhState());//获取激活状态
				
				childNodeList.add(childNode);
			}
		}
		rootNode.setNodes(childNodeList);
		for(int j=0; j<childNodeList.size();j++){
			constructTree(childNodeList.get(j), orgList, ++rootLevel);
			--rootLevel;
		}		
		return rootNode;
	}
	
	private List<Member> getTreeNodeDtoByJdrNum(Member member) {
		List<Member> depList=memberService.findAll();
		List<Member> resultList = new ArrayList<Member>();
		Member rootNode = new Member();
		rootNode.setMemNum(member.getMemNum());
		rootNode.setJhTime(member.getJhTime());
		rootNode.setaCounts(member.getaCounts());
		rootNode.setbCounts(member.getbCounts());
		rootNode.setId(member.getId());
		
		
		if(depList.size()>0){
			rootNode=constructTreeByJdrNum(rootNode, depList, 0);
			resultList.add(rootNode);
		}
		return resultList;
	}
	
	private Member constructTreeByJdrNum(Member rootNode, List<Member> orgList, int rootLevel) {
		List<Member> childNodeList = new ArrayList<Member>();
		for(int i=0; i<orgList.size(); i++){
			Member org = orgList.get(i);
			if(org.getJiedianNum()!=null && org.getJiedianNum().equalsIgnoreCase(rootNode.getMemNum())){
				Member childNode = new Member();
				childNode.setMemNum(org.getMemNum());
				childNode.setParent(rootNode);
				childNode.setLevel(rootLevel+1);
				childNode.setAreaType(org.getAreaType());
				childNode.setJhState(org.getJhState());
				childNode.setJhTime(org.getJhTime());
				//a b 两区人数
				childNode.setaCounts(org.getaCounts());
				childNode.setbCounts(org.getbCounts());
				
				childNodeList.add(childNode);
			}
		}
		rootNode.setNodes(childNodeList);
		for(int j=0; j<childNodeList.size();j++){
			constructTreeByJdrNum(childNodeList.get(j), orgList, ++rootLevel);
			--rootLevel;
		}		
		return rootNode;
	}
	
	public void updateMemTeamCounts(String tjrNum,int flag){
		Member updamem = new Member();
		//通过推荐人编号  获取对应推荐人对象
		updamem = memberService.selectMemEntiBymemNum(tjrNum);
		if(updamem!=null){
			updamem.setTeamAmounts(updamem.getTeamAmounts()+1);
			int result = memberService.updateMemberById(updamem);
			updateMemTeamCounts(updamem.getTjrNum(),flag);
		}
	}
	
	private void updateMemAreaCounts(Member needActiveMem, int flag) {
		String jiedianNum = needActiveMem.getJiedianNum();
		Member updamem = new Member();
		//通过接点人编号  获取对应接点人对象
		updamem = memberService.selectMemEntiBymemNum(jiedianNum);
		if(updamem!=null){
			if(needActiveMem.getAreaType().equals("A")){//激活会员处于A区
				updamem.setaCounts(updamem.getaCounts()+1);
			}
			if(needActiveMem.getAreaType().equals("B")){//激活会员处于B区
				updamem.setbCounts(updamem.getbCounts()+1);
			}
			int result = memberService.updateMemberById(updamem);
			updateMemAreaCounts(updamem,flag);
		}
	}
	
	public Member getJiedianMember(List<Member> topMembers,int x){//进入该方法   topMembers  id=1  x=0
		Member member2 = null;  //这个对象是最终要返回的接点人
		if(null==member2)
		{
			int abcd = 0;//定义一个终止循环的条件
			List<Member> pmembers = topMembers;//这里 直接帮id=1的集合 赋值给 一个pmembers 的集合
			List<Member> members = pmembers; //这个也不太清楚
			List<Integer>   memNums = new ArrayList<Integer>();//这里是讲in(1,2,3)这里面的1,2,3..放到一个集合里面
			//memNums.add(pmembers.get(0).getId());//这里就是第一次  将第一个父级节点的ID放入该集合中     
			memNums.clear();
			memNums.add(topMembers.get(0).getId()); //this have a error   :java.lang.IndexOutOfBoundsException: Index: 1, Size: 1
			for (int i = 0; i>-1; i++) 
			{//进入无限循环
				if(abcd ==1)//is clause not come in  
				{//
					break;
				}
				//===================================================================================================
				Integer sonCounts = memberService.getLayerCounts(memNums);
				//x++;
				if (sonCounts<Math.pow(2,x+1))
				{
				//The node in there.
					pmembers=members;
					for (int j = 0; j <pmembers.size(); j++) //感觉这个j < Math.pow(2,x-1) 调整下
					{
						if(pmembers.size() <= Math.pow(2,x-1)) //there have error
						{
							for (int n = 0; n <pmembers.size(); n++)
							{
								Member member_2 = pmembers.get(n);//this have a  error   j is 2  but pmembers size is 2
								memNums.clear();
								memNums.add(member_2.getId());
								Integer result_2 = memberService.getLayerCounts(memNums);
								if(result_2 < 2)//关键这个条件没有进来
								{
									member2 = pmembers.get(n);
									abcd =1;
									break;
								}
							}
							if (abcd ==1)
							{
								break;
							}
							
						}
					}
				}
				else
				{
					pmembers = members;
					members = memberService.getLayerMembers(memNums);//This perhaps error
					memNums.clear();
					for (int j = 0; j < members.size(); j++) // j < Math.pow(2,x+1)  这个条件什么意思呢  2.0  should be is 4.0
					{
						//这个地方应该可以的了，开始写的是
						memNums.add(members.get(j).getId());//this have a error  : java.lang.IndexOutOfBoundsException: Index: 1, Size: 1
					}
					
				}
				x++;
			}
			
		}
		return member2;
	}
	
	private void iteratorTeamCrash(Member member_2,String activMemNum,int flag) {
		ParamConf paramConf = paramConfService.getById(1);//全局参数配置
		BigDecimal activeGetPrice = paramConf.getActiveGetPrice();//激活会员  层奖金额  每层都一样
		BigDecimal stopLayerPrice = paramConf.getStopLayerPrice();//停止发放层奖金额
		String jiedrNum = member_2.getJiedianNum();//激活对象  的接点人 
		
		if(flag<7){
			if(jiedrNum!=null && !"".equals(jiedrNum)){//避免主账号异常
				flag ++;// 第一次 0 ++  flag为1 1<7  一次类推 可以进入7次 
				Member pmember = memberService.selectMemEntiBymemNum(jiedrNum);//获取接点人对象
				CurrencyInfo currencyInfo = currencyInfoService.findByMemId(pmember.getId());//接点人币种信息金额
				if(pmember.getIsLayerOver()!=null && pmember.getIsLayerOver() == 2){//当前会员团队收益 超出 发放金额限制  已经出局 了  不再发放层奖
					
					//递归调用 自己  直到结束
					iteratorTeamCrash(pmember, activMemNum,flag);
				}else{//发放层奖   并且记录  奖金明细  财务明细
					CurrencyInfo _currencyInfo = new CurrencyInfo();
					_currencyInfo.setTeamPoints(activeGetPrice);//团队收益  发放层奖  
					_currencyInfo.setMemNum(jiedrNum);
					currencyInfoService.updateIntegralVal(_currencyInfo);
					
					CurrencyInfo finalCurrencyInfo = currencyInfoService.findByMemId(pmember.getId());//获得团队收益 最终的币种信息金额
					if(finalCurrencyInfo.getTeamPoints().compareTo(stopLayerPrice) == 1){//如果此时团队收益大于 限制发放额度时 设置 出局状态 后面用不发放了
						pmember.setIsLayerOver(2);//出局状态
						memberService.updateMemberById(pmember);
					}
					//************************************************************************************************
					//奖金明细   对应日志记录信息  记录奖金统计表  一方  【层奖】【收入】
					Bonus bonus =  bonusService.getByCurrDateAndMemNum(pmember.getMemNum());//通过当前日期获取一条记录
					if(bonus == null){//新增一条奖金明细     推荐奖和层奖  和总收益  默认为当前会员 币种信息金额
						Bonus bonus_1 = new Bonus();
						bonus_1.setMemNum(pmember.getMemNum());
						bonus_1.setTjrBonus(finalCurrencyInfo.getCrashPoints());//初始化推荐奖
						bonus_1.setLayerBonus(finalCurrencyInfo.getTeamPoints());//初始化层奖
						bonus_1.setTotalBonus(finalCurrencyInfo.getCrashPoints().add(finalCurrencyInfo.getTeamPoints()));//初始化总收益
						
						Integer result_1 = bonusService.insert(bonus_1);
						bonus =  bonusService.getByCurrDateAndMemNum(pmember.getMemNum());
					}else{//如果存在  依次增加 层奖  总收益
						bonus.setLayerBonus(activeGetPrice);
						bonus.setTotalBonus(activeGetPrice);
						bonusService.updateBonus(bonus);
					}
					//奖金明细  记录奖金明细表  多方
					BonusInf   bonusInf = new BonusInf();
					bonusInf.setBonusDesc("会员"+activMemNum+"激活获得的层奖收益");
					bonusInf.setBonusStatus(2);//已结算
					bonusInf.setBonusType(1);//层奖
					bonusInf.setBonusSalar(activeGetPrice);//层奖金额
					bonusInf.setBonusId(bonus.getId());//关联 一方 奖金明细
					bonusInf.setMemNum(pmember.getMemNum());//关联会员编号
					
					Integer result_2 = bonusInfService.insert(bonusInf);
					//*******************************************************************************************************
					//财务明细  记录日志信息    一方 
					Log   log = memberCurrencyLogService.getByCurrDateAndMemNum(pmember.getMemNum());
					if(log==null){//如果为空  新增一条记录时   团队收益  现金积分  激活积分  总收益  默认为当前会员 币种信息金额
						Log  log_1 = new Log();
						log_1.setMemberNum(pmember.getMemNum());
						log_1.setLayerBonus(finalCurrencyInfo.getTeamPoints());//初始化层奖
						log_1.setTjrBonus(finalCurrencyInfo.getCrashPoints());// 初始化推荐奖
						log_1.setActiveBonus(finalCurrencyInfo.getActivPenn());//初始化激活积分
						log_1.setTotalBonus(finalCurrencyInfo.getTeamPoints().add(finalCurrencyInfo.getCrashPoints()).add(finalCurrencyInfo.getActivPenn()));//初始化总收益
						
						memberCurrencyLogService.insertLog(log_1);
						log = memberCurrencyLogService.getByCurrDateAndMemNum(pmember.getMemNum());
					}else{//如果已经存在  更新处理 对应 团队收益  现金积分 激活积分 总收益  依次累加处理
						log.setLayerBonus(activeGetPrice);
						log.setTotalBonus(activeGetPrice);
						
						memberCurrencyLogService.updateLog(log);
					}
					
					LogInf loginf_1 = new LogInf();
					loginf_1.setCurrencyType(2);
					loginf_1.setSalary(activeGetPrice);//扣除  负数
					loginf_1.setOrigSalary(currencyInfo.getTeamPoints());//原始团队收益
					loginf_1.setPreSalary(finalCurrencyInfo.getTeamPoints());//当前团队收益
					loginf_1.setOptDesc("会员:"+activMemNum+"被激活时获取的层奖进入团队收益");
					loginf_1.setMemNum(pmember.getMemNum());//关联会员编号
					loginf_1.setLogPid(log.getId());//关联日志一方
					
					memberCurrencyLogService.insertLoginf(loginf_1);
					//******************************************************************************************************
					//递归调用 自己  直到结束
					iteratorTeamCrash(pmember, activMemNum,flag);
				}
			}
		}
	}
}
