package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/book")
@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/list")
	public String list(Model model) {
		// 공통 bodyTitle
		model.addAttribute("bodyTitle", "도서 목록");
		
		List<BookVO> list = this.bookService.list();
		
		for(BookVO vo : list) {
			log.info("BookVO : " + vo.toString());			
		}
		
		model.addAttribute("list", list);
		
		// forwarning
		return "book/list";
	}
}
