package com.MoonJu.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int writeNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDt;
	
	
}
