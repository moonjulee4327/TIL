package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String books(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
		
		List<BookVO> bookVO = bookService.selsctList(keyword);
		
		model.addAttribute("listOfBooks", bookVO);
		
		return "books";
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBook() {
		
		return "addBook";
	}
	
	@RequestMapping(value = "/processAddBook", method = RequestMethod.POST)
	public String processAddBook(@ModelAttribute BookVO bookVO) {
		
		log.info(bookVO.toString());
		
		this.bookService.insertBook(bookVO);
		
		return "redirect:/books";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(@RequestParam String bookId, Model model ) {
		
		BookVO bookVO = this.bookService.selectOne(bookId);
		
		model.addAttribute("bookVO", bookVO);
		
		return "product";
	}
	
}
