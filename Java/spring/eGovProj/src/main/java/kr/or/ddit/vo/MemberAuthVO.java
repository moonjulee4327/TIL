package kr.or.ddit.vo;

import lombok.Data;

@Data
public class MemberAuthVO {
	
	private String memId; // memId, auth 복합키 
	private String auth; // 필수적으로 있어야 함
	
}
