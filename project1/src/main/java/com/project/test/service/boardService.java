package com.project.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.test.dao.boardDAO;
import com.project.test.vo.BoardVO;

@Service
public class boardService {

	@Autowired
	private boardDAO dao;
	
	public ArrayList<BoardVO> selectAllFreeBoard() {
		
		return dao.selectAllFreeBoard();
	}

	public boolean writeFreeBoard(String boardTitle, String boardContent, String id) {
		BoardVO newBoard = new BoardVO();
		
		newBoard.setBoardTitle(boardTitle);
		newBoard.setBoardContent(boardContent);
		newBoard.setId(id);
		
		if(dao.writeFreeBoard(newBoard) > 0) 
			return true;
		else
			return false;
	}

}
