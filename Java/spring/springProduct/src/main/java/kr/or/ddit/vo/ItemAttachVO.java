package kr.or.ddit.vo;

import java.util.Date;


//@Data
public class ItemAttachVO {
	
	private int seq;
	private int itemId;
	private String fullname;
	private Date regdate;
	
	// 기본생성자
	public ItemAttachVO() {}

	// getter/setter 메소드
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
