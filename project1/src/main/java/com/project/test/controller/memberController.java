package com.project.test.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.test.controller.memberController;
import com.project.test.service.memberService;
import com.project.test.vo.memberVO;

@Controller
@RequestMapping(value = "/member")
public class memberController {

	private static final Logger logger = LoggerFactory.getLogger(memberController.class);
	
	@Autowired
	private memberService service;
	
	
	// 회원가입 페이지로 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		logger.info("join 메소드 실행(GET)");
		
		return "member/join";
	}
	
	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(memberVO member) {
		logger.info("join 메소드 실행(POST)");
		
		boolean result = service.join(member);
		
		String returnUrl = null;
		if(result) {
			logger.info("회원가입 성공");
			returnUrl = "redirect:/";
		} else {
			logger.info("회원가입 실패");
			returnUrl = "member/join";
		}
		
		return returnUrl;
	}
	
	// 로그인 창으로 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login 메소드 실행(GET)");
		
		return "member/login";
	}
	
	// 로그인 여부 확인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, String id, String password) {
		logger.info("login 메소드 실행(POST)");
		
		logger.info("id: {}", id);
		logger.info("password: {}", password);
		
		String loginId = service.login(id, password);
		logger.info("loginId: {}", loginId);
		
		String returnUrl = null;
		if(loginId == null) {
			logger.info("로그인 실패");
			returnUrl = "member/login"; 
		} else {
			logger.info("로그인 성공");
			session.setAttribute("id", id);
			returnUrl = "redirect:/";
		}
		
		return returnUrl; 
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("logout 메소드 실행(GET)");
		
		session.removeAttribute("id");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String idCheck() {
		logger.info("idCheck 메소드 실행(GET)");
		
		return "member/idCheck";
	}
	

	// id 중복 체크
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST) 
	public String idCheck(String id) { 
		logger.info("idCheck 메소드 실행(POST)");
	  
		logger.info("id: {}", id);
	  
		String result = service.idChk(id); 
		 
		if(result == null) {
			logger.info("사용할 수 있는 ID입니다."); 
			return "yes"; 
		} else {
			logger.info("중복된 ID입니다."); 
			return "no"; 
		} 
		
	}
	 
}
