package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.BookVO;

public interface BookService {
	
	public List<BookVO> list();

	public BookVO detail(int bookId);

	public int update(BookVO bookVO);

	public int insert(BookVO bookVO);
	
}
