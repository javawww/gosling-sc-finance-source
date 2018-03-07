package com.gosling.web.controller.index;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.gosling.core.util.QRUtil;
import com.gosling.entity.bonus.BonusInf;
import com.gosling.entity.currency.CurrencyInfo;
import com.gosling.entity.member.Member;
import com.gosling.entity.system.ParamConf;
import com.gosling.service.bonus.BonusInfService;
import com.gosling.service.currency.CurrencyInfoService;
import com.gosling.service.member.MemberService;
import com.gosling.service.system.ParamConfService;
import com.gosling.web.controller.BaseController;
import com.gosling.web.util.WebFrontSession;
/**
 * 
 * @类描述：首页
 * @项目名称：gosling-sc-finance-controller
 * @包名： com.gosling.web.controller.index
 * @类名称：IndexController
 * @创建人：Administrator
 * @创建时间：2018年2月28日下午10:10:22
 */
@Controller
public class IndexController extends BaseController{
	
	@Resource
	private 		MemberService									memberService;
	@Resource
	private 		CurrencyInfoService						currencyInfoService;
	@Resource
	private 		ParamConfService						paramConfService;
	@Resource
	private 		BonusInfService 						bonusInfService;
	
	
	/**
	 * 跳转首页
	 * @param request
	 * @param response
	 * @param dataMap
	 * @return
	 * @throws IOException 
	 * @throws WriterException 
	 */
	@RequestMapping(value = {"/","index.html","index"},method = RequestMethod.GET)
	public String skipIndexFront(HttpServletRequest request,HttpServletResponse response,Map<String, Object> dataMap) throws IOException, WriterException 
	{
		Member member = WebFrontSession.getFrontMember(request);
		if(member != null && !"".equals(member.getMemNum())) {
			//根据session中member id 获取数据库 用户对象
			member = memberService.getById(member.getId());
			dataMap.put("member", member);
			
			//校验通过  获取关联币种信息 
			CurrencyInfo  currencyinfo = 
					currencyInfoService.findOneCurrenInfoBymemNum(member.getMemNum());
			if(currencyinfo!=null){
				dataMap.put("currencyinfo", currencyinfo);
			}
			//获取全网 初始参数 配置信息  放置SESSION中 全局获取
			int paramId = 1;
			ParamConf paramConf =
					paramConfService.findParamById(paramId);
			if(paramConf!=null){
				dataMap.put("paramrequest", paramConf);
				//全局参数 不可从 SESSION中获取  用的时候 一定去数据库获取最新数据
				//request.getSession().setAttribute("paramSession", paramConf);
			}
			
			//团队收益总计   现金收益总计getAllByMemNumAndType  1 层奖(50元)    2 推荐奖(200元)
			List<BonusInf> layerBonusInfs =  
					bonusInfService.getAllByMemNumAndType(member.getMemNum(), 1);
			BigDecimal layerBonusTotal = BigDecimal.ZERO;
			if(layerBonusInfs.size() > 0){
				for (BonusInf bonusInfs : layerBonusInfs) {
					//bb = bb.add(new BigDecimal("5"));
					layerBonusTotal = layerBonusTotal.add(bonusInfs.getBonusSalar());
				}
			}
			dataMap.put("layerBonusTotal", layerBonusTotal);//累计层奖  也就是 累计团队收益
			
			List<BonusInf> cashBonusInfs =  bonusInfService.getAllByMemNumAndType(member.getMemNum(), 2);
			BigDecimal cashBonusTotal = BigDecimal.ZERO;
			if(layerBonusInfs.size() > 0){
				for (BonusInf bonusInfs : cashBonusInfs) {
					//bb = bb.add(new BigDecimal("5"));
					cashBonusTotal = cashBonusTotal.add(bonusInfs.getBonusSalar());
				}
			}
			dataMap.put("cashBonusTotal", cashBonusTotal);//累计推荐奖  也就是 累计现金积分
			
			qrcodeLinks(request, dataMap, member);
	    	return "finance/index/index";
		}else {
			return "redirect:login.html";
		}
	}
	/**
	 * 
	 * @描述:二维码封装
	 * @方法名: qrcodeLinks
	 * @param request
	 * @param dataMap
	 * @param member
	 * @throws WriterException
	 * @throws IOException
	 * @返回类型 void
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午2:40:33
	 */
	private void qrcodeLinks(HttpServletRequest request, Map<String, Object> dataMap, Member member)
			throws WriterException, IOException {
		//返回我的二维码
		String path = request.getContextPath();
		String tglink = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		String basepath = tglink + path + "/";
		
		String suffix = "tgRegister.html?memNo="+member.getMemNum();
		String tgLink = basepath + suffix;
		String picName = member.getMemNum() +".gif";//每个玩家都有自己的推广图片
		//设定路径，目前路径为项目根路径的为upload+年月日+会员名，如upload/20170610/A00000.gif
		String uploadPath=request.getServletContext().getRealPath("/upload/");
		//如果图片存在，不存在就建
		File outputFile = new File(uploadPath, picName); 
		//文件夹创建
		outputFile.mkdirs();
		//二维码宽高设置
		int width = 300; 
		int height = 300; 
		//二维码的图片格式
		String format = "gif"; 
		Hashtable hints = new Hashtable(); 
		//内容所使用编码 
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
		//推广链接动态生成二维码
		BitMatrix bitMatrix = new MultiFormatWriter().encode(tgLink,  BarcodeFormat.QR_CODE, width, height, hints); 
		//生成二维码 
		QRUtil.writeToFile(bitMatrix, format, outputFile); 
		//为前台提供数据
		dataMap.put("tgRegisterUrl", tgLink);
		dataMap.put("tgRegisterPic", basepath + "/upload/"+picName);
	}
}
