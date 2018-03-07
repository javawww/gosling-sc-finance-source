package com.gosling.dao.email;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gosling.entity.email.EmailMsg;
/**
 * 
 * @类描述：邮件
 * @项目名称：gosling-base-dao
 * @包名： com.gosling.dao.email
 * @类名称：EmailMsgDao
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午1:58:17
 */
public interface EmailMsgDao {


	/**
	 * 插入一条数据
	 * @param template
	 * @return
	 */
	Integer insert(EmailMsg template);

	/**
	 * 更新一条数据
	 * @param template
	 * @return
	 */
    Integer update(EmailMsg template);

    /**
     * 通过id删除一条数据
     * @param id
     * @return
     */
    Integer deleteById(Integer id);
    
	/**
	 * 通过id 获得唯一对象 
	 * 注意@Param("值")   值对应mapper配置文件#{id}  
	 * @param id
	 * @return
	 */
	EmailMsg getById(@Param("id") java.lang.Integer id);
	
	/**
	 * 分页查询数据 返回一个集合
	 * @param queryMap
	 * @param start
	 * @param size
	 * @return
	 */
	List<EmailMsg> getByPage(@Param("queryMap") Map<String, Object> queryMap,
            @Param("start") Integer start, @Param("size") Integer size);
	/**
	 * 通过tempSex 性别 查询  返回一个集合
	 * @param type
	 * @return
	 */
	
	List<EmailMsg> getEmailBySendid(@Param("sendid")Integer sendid);
	
	List<EmailMsg> getEmailByReceids(@Param("receids")Integer receids);
	
	List<EmailMsg> getAll();
	
	List<EmailMsg> getByTempSex(@Param("tempSex")Integer tempSex);
	
	
	/**
	 * 分页查询
	 * @param pageMap
	 * @return
	 */
	List<EmailMsg> getAllByPage(Map<String, Object> pageMap);

	Integer getTotalPages(Map<String, Object> whereMap);
	

}
