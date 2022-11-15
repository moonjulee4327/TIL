package kr.or.ddit.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AttachVO {
	private String userNo;
	private int seq;
	private String filename;
	private int filesize;
	private Date regdate;
}
