package com.spring.test.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.dao.MemberDAO;
import com.spring.test.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	// 회원가입
	public boolean join(String memberId, String memberPw, String memberName, int memberPhoto) {
		MemberVO newMember = new MemberVO();
		
		newMember.setMemberId(memberId);
		newMember.setMemberPw(memberPw);
		newMember.setMemberName(memberName);
		newMember.setMemberPhoto(memberPhoto);
		
		int result = dao.join(newMember);
		
		if(result > 0) 
			return true;
		else 
			return false;
		
	}

	// 로그인
	public String selectMember(String memberId, String memberPw) {
		MemberVO loginMember = new MemberVO();
		
		loginMember.setMemberId(memberId);
		loginMember.setMemberPw(memberPw);
		
		return dao.selectMember(loginMember);
	}

	// 모든 회원의 블로그 리스트 출력
	public ArrayList<MemberVO> selectAllMember() {
		
		return dao.selectAllMember();
	}



}
