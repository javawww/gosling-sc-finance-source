package com.gosling.web.controller.information;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gosling.core.util.PageUtil;
import com.gosling.core.util.ResourceUtil;
import com.gosling.entity.announcement.Information;
import com.gosling.service.announcement.InformationService;
import com.gosling.web.controller.BaseController;
import com.ning.http.client.Request;

/**
 * 
 * @类描述：公告
 * @项目名称：gosling-sc-finance-controller
 * @包名： com.gosling.web.controller.information
 * @类名称：InformationController
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午2:44:59
 */
@Controller
public class InformationController extends BaseController{

	@Resource
	private 			InformationService   			informationService;
	
	/**
	 * 
	 * @描述:列表
	 * @方法名: skipInformationFront
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午2:45:49
	 */
	@RequestMapping(value = "information.html",method = RequestMethod.GET)
	public String skipInformationFront(HttpServletRequest request,Map<String, Object> dataMap){
		String pagestr = request.getParameter("page");
		Integer page = pagestr==null ? 1 : Integer.valueOf(pagestr);
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("pubTime", new Date());
		
		Integer  rowsPerPage = Integer.valueOf(ResourceUtil.getConfigByName("rowsPerPage"));
		Map<String, Object> pageMap = PageUtil.pageMap(rowsPerPage, page, whereMap);
		
		
		List<Information> inforList =  informationService.getAllByPage(pageMap);//通过分页查询数据 
		Integer totalRecods = informationService.getTotalPages(whereMap);//总记录数
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
		
		return "finance/information/information";
	}
	
	/**
	 * 
	 * @描述:公告详情
	 * @方法名: informationdetail
	 * @param request
	 * @param dataMap
	 * @return
	 * @返回类型 String
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午2:52:12
	 */
	@RequestMapping(value = "informationdetail.html",method = RequestMethod.GET)
	public String informationdetail(HttpServletRequest request,Map<String,Object> dataMap){
		String id = request.getParameter("id");
		Information information = 
				informationService.getById(Integer.valueOf(id));
		if(information!=null){
			dataMap.put("information", information);
		}
		return "finance/information/informationdetail";
	}
}
