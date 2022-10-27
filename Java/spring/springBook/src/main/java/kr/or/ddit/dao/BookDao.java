package kr.or.ddit.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BookVO;

@Repository
public class BookDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insertBook(BookVO bookVO) {
		return sqlSessionTemplate.insert("book.insert", bookVO);
	}
	
	public List<BookVO> selsctList(String keyword) {
		return sqlSessionTemplate.selectList("book.selectList", keyword);
	}
	
	public BookVO selectOne(String bookId) {
		return sqlSessionTemplate.selectOne("book.selectOne", bookId);
	}
}
