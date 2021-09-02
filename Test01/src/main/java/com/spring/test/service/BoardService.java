package com.spring.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.dao.BoardDAO;
import com.spring.test.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;

	public ArrayList<BoardVO> listByUser(String memberId) {
		return dao.listByUser(memberId);
	}

	// 글쓰기
	public boolean writeBoard(String boardTitle, String boardContent, String memberId) {
		BoardVO newBoard = new BoardVO();
		
		newBoard.setBoardTitle(boardTitle);
		newBoard.setBoardContent(boardContent);
		newBoard.setMemberId(memberId);
		
		if(dao.writeBoard(newBoard) > 0)
			return true;
		else
			return false;
	}

	public BoardVO readBoard(int boardNum) {
		return dao.readBoard(boardNum);
	}

	public boolean deleteBoard(int boardNum) {
		if(dao.deleteBoard(boardNum) > 0) 
			return true;
		else
			return false;
	}

	public boolean updateBoard(int boardNum, String boardTitle, String boardContent) {
		BoardVO board = new BoardVO();
		
		board.setBoardNum(boardNum);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		if(dao.updateBoard(board) > 0)
			return true;
		else
			return false;
	}

	public void updateLikeCnt(int boardNum) {
		dao.updateLikeCnt(boardNum);
	}
	

}
