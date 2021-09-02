package com.spring.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.test.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession session;
	
	// 회원별 블로그 리스트
	public ArrayList<BoardVO> listByUser(String memberId) {
		ArrayList<BoardVO> result = null;
		boardMapper mapper = null;
		
		try {
			mapper = session.getMapper(boardMapper.class);
			result = mapper.listByUser(memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 글 쓰기
	public int writeBoard(BoardVO newBoard) {
		int result = 0;
		boardMapper mapper = null;
		
		try {
			mapper = session.getMapper(boardMapper.class);
			result = mapper.writeBoard(newBoard);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 글 상세보기
	public BoardVO readBoard(int boardNum) {
		BoardVO result = null;
		boardMapper mapper = null;
		
		try {
			mapper = session.getMapper(boardMapper.class);
			result = mapper.readBoard(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 글 삭제
	public int deleteBoard(int boardNum) {
		int result = 0;
		boardMapper mapper = null;
		
		try {
			mapper = session.getMapper(boardMapper.class);
			result = mapper.deleteBoard(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 글 수정
	public int updateBoard(BoardVO board) {
		int result = 0;
		boardMapper mapper = null;
		
		try {
			mapper = session.getMapper(boardMapper.class);
			result = mapper.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 추천수 증가
	public void updateLikeCnt(int boardNum) {
		boardMapper mapper = null;
		
		try {
			mapper = session.getMapper(boardMapper.class);
			mapper.updateLikeCnt(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
