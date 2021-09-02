package com.spring.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.test.service.MemberService;
import com.spring.test.vo.MemberVO;
import com.spring.test.controller.MemberController;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	// 회원가입 페이지로 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		logger.info("join 메소드 실행(GET)");
		
		return "member/join";
	}
	
	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(String memberId, String memberPw, String memberName, int memberPhoto) {
		logger.info("join 메소드 실행(POST)");
		
		logger.info("memberId : {}", memberId);
		logger.info("memberPw : {}", memberPw);
		logger.info("memberName : {}", memberName);
		logger.info("memberPhoto : {}", memberPhoto);
		
		String returnUrl;
		boolean result = service.join(memberId, memberPw, memberName, memberPhoto);
	
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
	public String login(HttpSession session, String memberId, String memberPw) {
		logger.info("login 메소드 실행(POST)");
			
		logger.info("memberId: {}", memberId);
		logger.info("memberPw: {}", memberPw);
			
		String loginId = service.selectMember(memberId, memberPw);
		logger.info("loginId: {}", loginId);
			
		String returnUrl = null;
		if(loginId == null) {
			logger.info("로그인 실패");
			returnUrl = "member/login"; 
		} else {
			logger.info("로그인 성공");
			session.setAttribute("memberId", memberId);
			returnUrl = "redirect:/";
		}
			
		return returnUrl; 
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("logout 메소드 실행(GET)");
		
		session.removeAttribute("memberId");
		
		return "redirect:/";
	}
	
	// 가입된 회원의 블로그 리스트로 이동
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberList(Model model) {
		logger.info("memberList 메소드 실행(GET)");
		
		ArrayList<MemberVO> memberList = service.selectAllMember();
		
		logger.info("memberList: {}", memberList);
		model.addAttribute("memberList", memberList);
		
		return "member/memberList";
	}
}
