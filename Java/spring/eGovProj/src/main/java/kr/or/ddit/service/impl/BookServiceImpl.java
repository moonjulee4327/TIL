package kr.or.ddit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.BookMapper;
import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<BookVO> list() {
		return this.bookMapper.list();
	}
	
	@Override
	public BookVO detail(int bookId) {
		return this.bookMapper.detail(bookId);
	}
	
	@Override
	public int update(BookVO bookVO) {
//		return this.bookMapper.update(bookVO);
		
		log.info("before bookVO : " + bookVO.toString());
		
		int result = this.bookMapper.insert(bookVO);
		
		log.info("after bookVO : " + bookVO.toString());
		// merge into 사용
		return result;
	}
	
	@Override
	public int insert(BookVO bookVO) {
		return this.bookMapper.insert(bookVO);
	}
	

}
