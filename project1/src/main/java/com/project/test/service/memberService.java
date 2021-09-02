package com.project.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.test.dao.memberDAO;
import com.project.test.vo.memberVO;

@Service
public class memberService {

	@Autowired
	private memberDAO dao;

	public boolean join(memberVO member) {
		int result = dao.join(member);
				
		if(result > 0) 
			return true;
		else 
			return false;

	}

	public String login(String memberId, String memberPw) {
		memberVO loginMember = new memberVO();
		
		loginMember.setId(memberId);
		loginMember.setPassword(memberPw);
		
		return dao.login(loginMember);
	}

	// id중복 확인
	public String idChk(String id) {
		return dao.idChk(id);
	}
	
	
}
