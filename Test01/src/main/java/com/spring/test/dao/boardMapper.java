package com.spring.test.dao;

import java.util.ArrayList;

import com.spring.test.vo.BoardVO;

public interface boardMapper {

	// 유저별 글 리스트
	ArrayList<BoardVO> listByUser(String memberId);
	// 글 쓰기
	int writeBoard(BoardVO newBoard);
	// 글 읽기
	BoardVO readBoard(int boardNum);
	// 글 삭제
	int deleteBoard(int boardNum);
	// 글 수정
	int updateBoard(BoardVO board);
	// 추천수
	void updateLikeCnt(int boardNum);

}
