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
	log.info("ID 검증 시작");
	
	// TODO 1. ID가 DB에 있는지 확인
	Map<String, Object> userInfo = loginMapper.selectUserInfo(params);
	// TODO 1-1. ID가 존재하지 않으면 로그인 실패
	if (userInfo == null) {
		resultMap.put("REPL_PAGE_MSG", "존재하는 ID가 없습니다.");
	}
	else {
		// TODO 1-2. ID가 존재하면 회원정보 활용
		log.info("ID는 있음");
		
		// TODO 2. PW가 맞는지 확인(조회한 회원정보의 PW 값을 String 비교)
		String dbPw = (String) userInfo.get("PW");
		String requestPw = (String) params.get("password"); 
		
		// requestPw와 dbPw 가 같은지 확인
		if (!requestPw.equals(dbPw)) {
			resultMap.put("REPL_PAGE_MSG", "PW가 일치하지 않습니다.");
		}
		
		// 회원 정보 설정
		resultMap.put("USER_INFO", userInfo);
		
		log.info("user 정보 : {}", userInfo);
	}
	
	return resultMap;
	
}


}

