package com.spring.test.dao;

import java.util.ArrayList;

import com.spring.test.vo.MemberVO;

public interface memberMapper {

	int join(MemberVO newMember);

	String selectMember(MemberVO loginMember);

	// 가입된 회원의 블로그 출력
	ArrayList<MemberVO> selectAllMember();

}
