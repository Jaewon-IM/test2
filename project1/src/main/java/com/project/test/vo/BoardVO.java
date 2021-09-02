package com.project.test.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String id;
	private String indate;
	private int cnt;
	private int likes;
}
