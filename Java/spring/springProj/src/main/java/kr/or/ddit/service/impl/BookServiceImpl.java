package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dao.BookDao;
import kr.or.ddit.mapper.BookMapper;
import kr.or.ddit.service.BookService;
import kr.or.ddit.util.FileUploadUtil;
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
	
	@Autowired
	BookMapper bookMapper;
	
	@Inject
	FileUploadUtil fileUploadUtil;
	
	// BOOK 테이블에 insert
	// 메소드 재정의
	@Override
	public int insert(BookVO bookVO) {
		// insert 처리 결과(0 또는 1이상)
		return this.bookMapper.insert(bookVO);
	}
	
	// 책 상세보기
	@Override
	public BookVO selectDetail(BookVO bookVO) {
		// bookVO => {bookId=0, title=null, category=null, price=0, insertDate=null}
		return this.bookMapper.selectDetail(bookVO);
	}
	
	// 책 목록보기
	@Override
	public List<BookVO> list(String keyword) {
		return this.bookMapper.list(keyword);
	}
	
	@Override
	public List<BookVO> listAll() {
		return this.bookMapper.listAll();
	}
	
	// 책 수정하기
	@Override
	public int update(BookVO bookVO) {
		return this.bookMapper.update(bookVO);
	}
	
	// 책 삭제하기
	@Override
	public int delete(int bookId) {
		return this.bookMapper.delete(bookId);
	}
	
	// Attach 테이블 insert
	@Override
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.bookMapper.insertAttach(attachVOList);
	}
	
	// ExamMember 전체 조회
	@Override
	public List<ExamMemberVO> examMemberList(Map<String,String> map) {
		return this.bookMapper.examMemberList(map);
	}
	
	// MEM 테이블의 전체 행의 수 
	@Override
	public int getTotal(Map<String,String> map) {
		return this.bookMapper.getTotal(map);
	}
	
	// MEM 테이블 INSERT
	@Transactional
	@Override
	public int memberinsert(ExamMemberVO memberVO) {
		//  MEM 테이블 INSERT
		this.bookMapper.memberinsert(memberVO);
		
		// FileUploadUtil 활용 -> 업로드, attach 테이블에 insert
		return this.fileUploadUtil.fileUploadAction(memberVO.getPictureArray(), memberVO.getMemId());
		
	}
	
	// MEM 테이블 IDCHECK
	@Override
	public int memberIdCheck(String memId) {
		return this.bookMapper.memberIdCheck(memId);
	}
	
	// 상세 보기
	@Override
	public ExamMemberVO detail(String memId){
		return this.bookMapper.detail(memId);
	}
	
}
