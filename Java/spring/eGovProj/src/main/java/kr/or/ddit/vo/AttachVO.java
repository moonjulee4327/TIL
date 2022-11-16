package kr.or.ddit.vo;

import java.util.Date;

import lombok.Data;

public class AttachVO {
	private String userNo;
	private int seq;
	private String filename;
	private int filesize;
	private Date regdate;
	
	public AttachVO() {}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "AttachVO [userNo=" + userNo + ", seq=" + seq + ", filename=" + filename + ", filesize=" + filesize
				+ ", regdate=" + regdate + "]";
	}
	
	
}
