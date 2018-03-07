package com.gosling.core.json;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
/**
 * 
 * @类描述：异步交互数据处理
 * @项目名称：gosling-base-core
 * @包名： com.gosling.core.json
 * @类名称：AjaxJson
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午3:02:54
 */
public class AjaxJson {

	private boolean success=true;//是否成功
	private String message="操作成功";//提示信息
	private Object obj=null;//其他信息
	private Map<String,Object> attributes;//其他参数
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	public String getJsonStr(){
		JSONObject obj=new JSONObject();
		obj.put("success",this.isSuccess());
		obj.put("message",this.getMessage());
		obj.put("obj",this.obj);
		obj.put("attributes",this.attributes);
		return obj.toJSONString();
	}
}
