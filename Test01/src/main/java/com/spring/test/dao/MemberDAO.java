package com.spring.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.test.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession session; 
	
	public int join(MemberVO newMember) {
		int result = 0;
		memberMapper mapper = null;
		
		try {
			mapper = session.getMapper(memberMapper.class);
			result = mapper.join(newMember);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String selectMember(MemberVO loginMember) {
		String result = null;
		memberMapper mapper = null;
		
		try {
			mapper = session.getMapper(memberMapper.class);
			result = mapper.selectMember(loginMember);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<MemberVO> selectAllMember() {
		ArrayList<MemberVO> result = null;
		memberMapper mapper = null;
		
		try {
			mapper = session.getMapper(memberMapper.class);
			result = mapper.selectAllMember();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
