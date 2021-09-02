package com.project.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.test.service.boardService;
import com.project.test.vo.BoardVO;

@Controller
@RequestMapping(value = "/board")
public class boardController {

	private static final Logger logger = LoggerFactory.getLogger(boardController.class);
	
	@Autowired
	private boardService service;
	
	// 커뮤니티 리스트로 이동
	@RequestMapping(value = "/comuList", method = RequestMethod.GET)
	public String comuList() {
		logger.info("comuList 메소드 실행(GET)");
		
		return "board/comuList";
	}
	
	// 자유게시판으로 이동
	@RequestMapping(value = "/freeBoard", method = RequestMethod.GET)
	public String freeBoard(Model model) {
		logger.info("freeBoard 메소드 실행(GET)");
		
		ArrayList<BoardVO> freeBoardList = service.selectAllFreeBoard();
		
		logger.info("freeBoardList: {}", freeBoardList);
		model.addAttribute("freeBoardList", freeBoardList);
		
		return "board/freeBoard";
	}
	
	// 자유게시판 글쓰기로 이동
	@RequestMapping(value = "/writeFreeBoard", method = RequestMethod.GET)
	public String writeFreeBoard(HttpSession session) {
		logger.info("writeFreeBoard 메소드 실행(GET)");
		
		String id = (String) session.getAttribute("id");
		
		logger.info(id);
		
		String returnUrl = null;
		if(id == null) {
			logger.info("로그인 후 이용해 주세요.");
			returnUrl = "member/login";
		} else {
			logger.info("글쓰기로 이동");
			returnUrl = "board/writeFreeBoard";
		}
		
		return returnUrl;
	}
	
	// 자유게시판 글쓰기
	@RequestMapping(value = "/writeFreeBoard", method = RequestMethod.POST)
	public String writeFreeBoard(String boardTitle, String boardContent, String id) {
		logger.info("writeFreeBoard 메소드 실행(POST)");
		
		boolean result = service.writeFreeBoard(boardTitle, boardContent, id);
		
		String returnUrl = null;
		
		if(result) {
			logger.info("게시글 작성 성공");
			returnUrl = "redirect:/board/freeBoard";
		} else {
			logger.info("게시글 작성 실패");
			returnUrl = "board/writeFreeBoard";
		}
		
		return returnUrl;
	}
	
	//글 상세 보기로 이동
	@RequestMapping(value = "/readBoard", method = RequestMethod.GET)
	public String readBoard() {
		logger.info("readBoard 메소드 실행(GET)");
		
		return "board/readBoard";
	}
}
