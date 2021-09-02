package com.project.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.test.vo.memberVO;


@Repository
public class memberDAO {

	@Autowired
	private SqlSession session;
	
	public int join(memberVO member) {
		int result = 0;
		memberMapper mapper;
		
		try {
			mapper = session.getMapper(memberMapper.class);
			result = mapper.join(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String login(memberVO loginMember) {
		String result = null;
		memberMapper mapper;
		
		try {
			mapper = session.getMapper(memberMapper.class);
			result = mapper.login(loginMember);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String idChk(String id) {
		String result = null;
		memberMapper mapper;
		
		try {
			mapper = session.getMapper(memberMapper.class);
			result = mapper.idChk(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
