package com.project.test.dao;

import com.project.test.vo.memberVO;

public interface memberMapper {

	int join(memberVO member);

	String login(memberVO loginMember);

	String idChk(String id);

}
