package com.gosling.service.email;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.dao.email.EmailMsgDao;
import com.gosling.entity.email.EmailMsg;

@Service(value = "emailMsgService")
public class EmailMsgService {

	@Resource
	private EmailMsgDao					emailMsgDao;
	
	
	public EmailMsg getById(Integer id) {
		return emailMsgDao.getById(id);
	}


	public int update(EmailMsg email) {
		return emailMsgDao.update(email);
	}


	public int insert(EmailMsg email) {
		return emailMsgDao.insert(email);
	}


	public List<EmailMsg> getAllByPage(Map<String, Object> pageMap) {
		return emailMsgDao.getAllByPage(pageMap);
	}

	public Integer getTotalPages(Map<String, Object> whereMap) {
		return emailMsgDao.getTotalPages(whereMap);
	}

}
