package com.spring.test.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNum;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private String inputDate;
	private int likeCnt;
}
