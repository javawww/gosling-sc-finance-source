package com.gosling.service.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.dao.system.ParamConfDao;
import com.gosling.entity.system.ParamConf;

@Service(value = "paramConfService")
public class ParamConfService {

	@Resource
	private 		ParamConfDao			paramConfDao;
	
	/**
	 * 
	 * @描述:获取唯一对象
	 * @方法名: findParamById
	 * @param paramId
	 * @return
	 * @返回类型 ParamConf
	 * @创建人 Administrator
	 * @创建时间 2018年3月7日下午2:24:35
	 */
	public ParamConf findParamById(int paramId) {
		return paramConfDao.findParamById(paramId);
	}

}
