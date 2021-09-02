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
import org.springframework.web.context.request.SessionScope;

import com.spring.test.controller.BoardController;
import com.spring.test.service.BoardService;
import com.spring.test.vo.BoardVO;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	
	// 사용자별(ID)로 쓴 전체글 리스트 조회
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String boardList(Model model, String memberId, HttpSession session) {
		logger.info("boardList 메소드 실행(GET)");
		
		ArrayList<BoardVO> boardList = service.listByUser(memberId);
		
		logger.info("boardList: {}", boardList);
		model.addAttribute("boardList", boardList);
		session.setAttribute("boardId", memberId);
		
		return "board/boardList";	
	}
	
	// 글 읽기(추천수)
	@RequestMapping(value = "/readBoard", method = RequestMethod.GET)
	public String readBoard(int boardNum, Model model) {
		logger.info("readBoard 메소드 실행(GET)");
		
		BoardVO board = service.readBoard(boardNum);
		logger.info("board: {}", board);
		model.addAttribute("board", board);
		
		return "board/readBoard";
	}
	
	// 추천수 올리기
	@RequestMapping(value = "/readBoard", method = RequestMethod.POST)
	public String updateLikeCnt(int boardNum) {
		
		// 추천수 올리기
		service.updateLikeCnt(boardNum);
		
		return "redirect:/board/readBoard?boardNum=" + boardNum;
	}
	
	// 글 쓰기 페이지로 이동
	@RequestMapping(value = "/writeBoard", method = RequestMethod.GET)
	public String writeBoard() {
		logger.info("writeBoard 메소드 실행(GET)");
		
		return "board/writeBoard";
	}
	
	// 글 쓰기
	@RequestMapping(value = "/writeBoard", method = RequestMethod.POST)
	public String writeBoard(String boardTitle, String boardContent, String memberId) {
		logger.info("writeBoard 메소드 실행(POST)");
		
		logger.info("boardTitle: {}", boardTitle);
		logger.info("boardContent: {}", boardContent);
		logger.info("memberId: {}", memberId);
		
		boolean result = service.writeBoard(boardTitle, boardContent, memberId);
		
		String returnUrl = null;
		
		if(result) {
			logger.info("게시글 작성 성공");
			returnUrl = "redirect:/board/boardList?memberId=" + memberId;
			
		} else {
			logger.info("게시글 작성 실패");
			returnUrl = "board/writeBoard";
		}
		
		return returnUrl;
	}
	
	// 글 수정으로 이동
	@RequestMapping(value="/updateBoard", method = RequestMethod.GET)
	public String updateBoard(int boardNum, Model model, HttpSession session) {
		logger.info("updateBoard 메소드 실행(GET)");
		
		// board객체에 readBoard의 내용을 가져온다.
		BoardVO board = service.readBoard(boardNum);
		
		// 로그인을 안하면 loginId의 값이 NULL이 되는데 이러면 로그인 창으로 안가고 500에러가 발생
		// ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
		String loginId = (String) session.getAttribute("memberId");
		String writerId = board.getMemberId();
		
		logger.info("loginId : {}", loginId);
		logger.info("writerId : {}", writerId);
		
		String returnUrl = null;
		
		// 강제로 주소를 바꾸려고 할때 자신이 쓴 글이 아니라면 글목록으로 다시 이동
		
		  if(loginId.equals(writerId)) { returnUrl = "board/updateBoard"; } else {
		  returnUrl = "member/login"; }
		 
				
		model.addAttribute("board", board);
		
		return returnUrl;
		//return "board/updateBoard";
	}
	
	// 글 수정
	@RequestMapping(value="/updateBoard", method = RequestMethod.POST)
	public String updateBoard(int boardNum, String boardTitle, String boardContent) {
		logger.info("updateBoard 메소드 실행(POST)");
		
		logger.info("boardNum: {}", boardNum);
		logger.info("boardTitle: {}", boardTitle);
		logger.info("boardContent: {}", boardContent);
		
		boolean result = service.updateBoard(boardNum, boardTitle, boardContent);
		//String memberId
		
		if(result) {
			logger.info("게시글 수정 성공");
		} else {
			logger.info("게시글 수정 실패");
		}
		//"redirect:/board/boardList?memberId=" + memberId;
		return "redirect:/member/memberList";
		//return "redirect:/board/boardList";
	}
	
	// 글 삭제
	@RequestMapping(value="deleteBoard", method = RequestMethod.POST)
	public String deleteBoard(int boardNum) {
		logger.info("deleteBoard 메소드 실행(POST)");
		logger.info("boardNum: {}", boardNum);
		
		// 게시글 제거
		boolean result = service.deleteBoard(boardNum);
		if(result) {
			logger.info("게시글 삭제 성공");
		} else {
			logger.info("게시글 삭제 실패");
		}
				
		return "redirect:/member/memberList";
	}
	
	
	
}




