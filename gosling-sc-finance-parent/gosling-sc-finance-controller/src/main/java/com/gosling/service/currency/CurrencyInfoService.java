package com.gosling.service.currency;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.dao.currency.CurrencyInfoDao;
import com.gosling.entity.currency.CurrencyInfo;

/**
 * 
 * @类描述：币种信息
 * @项目名称：gosling-sc-finance-controller
 * @包名： com.gosling.service.currency
 * @类名称：CurrencyInfoService
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午2:22:46
 */
@Service(value = "currencyInfoService")
public class CurrencyInfoService {
	
	@Resource
	private CurrencyInfoDao 			currencyInfoDao;
	
	public CurrencyInfo findOneCurrenInfoBymemNum(String memNum) {
		CurrencyInfo currencyInfo = 
				currencyInfoDao.findOneCurrenInfoBymemNum(memNum);
		return currencyInfo;
	}

	public CurrencyInfo findByMemId(Integer id) {
		return currencyInfoDao.findByMemId(id);
	}

	public int updatePostMoney(CurrencyInfo currencyInf) {
		return currencyInfoDao.updatePostMoney(currencyInf);
	}

	public int updateIntegralVal(CurrencyInfo currenInfo) {
		return currencyInfoDao.updateIntegralVal(currenInfo);
	}

	public Integer addCommon(CurrencyInfo currencyInfo) {
		return currencyInfoDao.addCommon(currencyInfo);
	}

	
	
}
