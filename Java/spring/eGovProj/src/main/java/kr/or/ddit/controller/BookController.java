package kr.or.ddit.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.security.CustomUser;
import kr.or.ddit.service.BookService;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/book")
@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	MemberService memberService;
	
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
	
	// 요청 URI : /book/detail?bookId=3
	// 요청 파라미터 : bookId=3
	// 1) String , int 매개변수 받기 (자동형변환)
	// 2) Map<String,String> / Map<String,Object>
	// 3) @ModelAttribute BookVO vo
	// 4) @RequestParam Map<String,String> / Map<String,Object>
	@GetMapping("/detail")
	public String detail(@RequestParam int bookId, Model model) {
		
		log.info("bookId : " + bookId);
		
		BookVO data = this.bookService.detail(bookId);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = sdf.format(data.getInsertDate());
		
		model.addAttribute("bodyTitle", "도서 상세");
		model.addAttribute("data", data);
		model.addAttribute("date", date);
		
		return "book/detail";
		
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BookVO bookVO) {
		
		log.info("bookVO : " + bookVO.toString());
		
		int bookId = bookVO.getBookId();
		
		int result = this.bookService.update(bookVO);
		
		log.info("result : " + result);
		
		return "redirect:/book/detail?bookId=" + bookId;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/addBookForm")
	public String registerForm() {
		
//		MemberVO memVO = this.memberService.read(memberVO.getMemId());
		
//		log.info("auth : " + auth.getName());
		
//		model.addAttribute("memberVO", memVO);
		
		return "book/register";
	}
	
	@PostMapping("/registerPost")
	public String registerPost(@ModelAttribute BookVO bookVO) {
		log.info("bookVO : " + bookVO.toString());
		
		int result = this.bookService.insert(bookVO);
		
		return "redirect:/book/list";
	}
	
	@GetMapping("comfirm")
	public String comfirm() {
		return "/tiles/index2";
	}
}
