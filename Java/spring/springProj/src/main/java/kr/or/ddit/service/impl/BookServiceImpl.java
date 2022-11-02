package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.BookDao;
import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.ExamMemberVO;

// 이 클래스는 서비스 클래스야 라고 스프링에게 알려준다.
// 스프링이 자바빈으로 등록해줌
@Service
public class BookServiceImpl implements BookService{
	// DI : 의존성 주입
	// 데이터베이스 접근을 위해 BookDao 인스턴스를 주입 받자
	@Autowired
	BookDao bookDao;
	
	// BOOK 테이블에 insert
	// 메소드 재정의
	@Override
	public int insert(BookVO bookVO) {
		// insert 처리 결과(0 또는 1이상)
		return this.bookDao.insert(bookVO);
	}
	
	// 책 상세보기
	@Override
	public BookVO selectDetail(BookVO bookVO) {
		// bookVO => {bookId=0, title=null, category=null, price=0, insertDate=null}
		return this.bookDao.selectDetail(bookVO);
	}
	
	// 책 목록보기
	@Override
	public List<BookVO> list(String keyword) {
		return this.bookDao.list(keyword);
	}
	
	@Override
	public List<BookVO> listAll() {
		return this.bookDao.listAll();
	}
	
	// 책 수정하기
	@Override
	public int update(BookVO bookVO) {
		return this.bookDao.update(bookVO);
	}
	
	// 책 삭제하기
	@Override
	public int delete(int bookId) {
		return this.bookDao.delete(bookId);
	}
	
	// Attach 테이블 insert
	@Override
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.bookDao.insertAttach(attachVOList);
	}
	
	// ExamMember 전체 조회
	@Override
	public List<ExamMemberVO> examMemList(Map<String,String> map) {
		return this.bookDao.examMemList(map);
	}
	
	// MEM 테이블의 전체 행의 수 
	@Override
	public int getTotal(Map<String,String> map) {
		return this.bookDao.getTotal(map);
	}
	
	// MEM 테이블 INSERT
	@Override
	public int memberinsert(ExamMemberVO memberVO) {
		return this.bookDao.memberinsert(memberVO);
	}
	
	// MEM 테이블 IDCHECK
	@Override
	public int memberIdCheck(String memId) {
		return this.bookDao.memberIdCheck(memId);
	}
	
}
