package com.MoonJu.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AttachFileBoardVO {
	
	private String writeNo;
	private int seq;
	private String fileName;
	private long fileSize;
	private Date regDate;
	
}
