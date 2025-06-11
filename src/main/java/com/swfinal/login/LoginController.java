package com.swfinal.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
	
	LoginService loginService;
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@GetMapping("/login-template")
	public String loginTemplate() {
	
		return "login-template"; 
	}
	
	@GetMapping("/login-xhr")
	public String loginXhr() {
		return "login-xhr"; 
	}
	
	@PostMapping("/request-login")
	@ResponseBody
	public Map<String, Object> requestLogin(@RequestBody Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		String userid = (String) params.get("userId");
		String password = (String) params.get("userPw");
		String username = (String) params.get("userNm");
		String useremail = (String) params.get("userEmail");

	}
	// 페이지 요청 Controller 메서드
	@GetMapping("/login-thymeleaf")
	public String loginThymeleaf() {
		return "login-thymeleaf"; // /templates/login-thymeleaf.html 경로 작성
	}
	
	// 로그인 요청 Controller 메서드
	@PostMapping("/request-login-thymeleaf")
	public String requestLogin(@RequestParam Map<String, Object> params, Model model, HttpSession session) {
		
		log.info("Thymeleaf 로그인 요청");
		
		
		Map<String, Object> result = loginService.requestLoginThymeleaf(params);
		
	}
}
