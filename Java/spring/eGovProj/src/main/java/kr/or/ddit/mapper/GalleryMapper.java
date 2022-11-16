package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;

public interface GalleryMapper {
	
	public BookVO list(BookVO bookVO);
	
	public List<BookVO> bookList();
	
	public int imageUpdate(AttachVO attachVO);
	
	public int imageDelete(AttachVO attachVO);
}
