package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.ExamMemberVO;

// 서비스 interface : 비즈니스 로직
public interface BookService {
	
	// 메소드 시그니처
	
	// BOOK 테이블에 insert
	public int insert(BookVO bookVO);
	
	// 책 상세보기
	public BookVO selectDetail(BookVO bookVO);
	
	// 책 목록보기
	public List<BookVO> list(String keyword);
	
	public List<BookVO> listAll();
	
	// 책 수정하기
	public int update(BookVO bookVO);
	
	// 책 삭제하기
	public int delete(int bookId);
	
	// Attach 테이블 insert
	public int insertAttach(List<AttachVO> attachVOList);

	// ExamMember 전체 조회
	public List<ExamMemberVO> examMemList(Map<String,String> map);
	
	// MEM 테이블의 전체 행의 수 
	public int getTotal(Map<String,String> map);
	
	// MEM 테이블 INSERT
	public int memberinsert(ExamMemberVO memberVO);
	
	// MEM 테이블 IDCHECK
	public int memberIdCheck(String memId);
}
