package com.gosling.core.util;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {

	
	public static Map<String, Object> pageMap(Integer rowsPerPage,Integer page,Map<String, Object> whereMap){
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("start", rowsPerPage*(page-1));
		pageMap.put("limit", rowsPerPage); 
		if(whereMap.size() > 0){
			for (Map.Entry<String, Object> entry : whereMap.entrySet()) {  
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
				pageMap.put(entry.getKey(), entry.getValue());
			}  
		}
		return pageMap;
	}
	
	public static void main(String[] args) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("id", 10);
		whereMap.put("name", "zhangsan");
		Map<String, Object> pageMap = PageUtil.pageMap(20, 1,whereMap);
		System.out.println(pageMap);
	}
}
