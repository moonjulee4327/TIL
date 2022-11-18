package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;

public interface GalleryService {

	public BookVO list(BookVO bookVO);

	public List<BookVO> bookList();

	public int imageUpdate(AttachVO attachVO);

	public int imageDelete(AttachVO attachVO);

	public List<BookVO> searchBook(BookVO bookVO);

	public int uploadAjaxAction(List<AttachVO> attachVOList);

	public int getSeq(String bookId);

}
