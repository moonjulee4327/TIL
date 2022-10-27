package kr.or.ddit.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.BookDao;
import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.BookVO;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDao bookDao;
	
	@Override
	public int insertBook(BookVO bookVO) {
		return bookDao.insertBook(bookVO);
	}
	
	@Override
	public List<BookVO> selsctList(String keyword) {
		return bookDao.selsctList(keyword);
	}
	
	@Override
	public BookVO selectOne(String bookId) {
		return bookDao.selectOne(bookId);
	}
	
}
