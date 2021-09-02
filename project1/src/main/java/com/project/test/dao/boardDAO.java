package com.project.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.test.vo.BoardVO;

@Repository
public class boardDAO {

	@Autowired
	private SqlSession session;
	
	public ArrayList<BoardVO> selectAllFreeBoard() {
		ArrayList<BoardVO> list = null;
		boardMapper mapper = null;
		
		try {
			mapper = session.getMapper(boardMapper.class);
			list = mapper.selectAllFreeBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int writeFreeBoard(BoardVO newBoard) {
		int result = 0;
		boardMapper mapper = null;
		
		try {
			mapper = session.getMapper(boardMapper.class);
			result = mapper.writeFreeBoard(newBoard);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
