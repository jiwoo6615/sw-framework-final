package com.swfinal.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {
	
	LoginMapper loginMapper;
	public LoginService(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	
	@Transactional(readOnly = true)
	public Map<String, Object> requestLoginThymeleaf(Map<String, Object> params) {
		log.info("Thymeleaf 서비스 요청");
		
		Map<String, Object> resultMap = new HashMap<String, Object>() ;
		resultMap.put("REPL_PAGE_MSG", "성공");
		
		
		
		
	}

}

