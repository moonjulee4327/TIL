package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.CardVO;
import kr.or.ddit.vo.MemberVO;

// 서비스 interface : 비즈니스 로직
public interface MemberService {

	// 메소드 시그니처
	// MEMBER, ADDRESS, CARD 동시 INSERT 처리
	public int memberInsert(MemberVO memberVO);

	
}
