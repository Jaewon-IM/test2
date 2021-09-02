package com.project.test.dao;

import java.util.ArrayList;

import com.project.test.vo.BoardVO;

public interface boardMapper {

	ArrayList<BoardVO> selectAllFreeBoard();

	int writeFreeBoard(BoardVO newBoard);

}
