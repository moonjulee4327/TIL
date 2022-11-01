package kr.or.ddit.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

// 자바빈 클래스
public class CardVO {
	// 회원 아이디
	private String userId;
	private String no;
	// 2022-11-01 (기본 : 2022/11/01)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validMonth;

	public CardVO() {}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getValidMonth() {
		return validMonth;
	}

	public void setValidMonth(Date validMonth) {
		this.validMonth = validMonth;
	}

	@Override
	public String toString() {
		return "CardVO [userId=" + userId + ", no=" + no + ", validMonth=" + validMonth + "]";
	}
	
}
