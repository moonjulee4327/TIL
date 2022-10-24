package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.BookVO;

/*
	Controller 어노테이션
	스프링 프레임워크에게 이 클래스는 웹 브라우저의 요청(request)를 
	받아들이는 컨트롤러야 하고 알려주는 것임
	스프링은 servlet-context.xml의 context:component-scan의 설정에 의해
	이 클래스를 자바빈 객체로 등록(메모리에 바인딩)
 * */
@Slf4j
@Controller
public class BookController {
	// 도서관리프로그램
	// BookService 서비스를 호출하기 위해 의존성 주입(DI)
	@Autowired
	BookService bookService;
	
	// URI => http://localhost/create
	// Request : client가 서버에 URI를 요청
	// Mapping : create() 메소드를 실행
	@RequestMapping(value = "/create", method=RequestMethod.GET)
	public ModelAndView create() {
		/*
		 * 	  ModelAndView
		 * 	1) Model : return할 데이터(String, int, List, Map, VO...)를 담당
		 *  2) View : 화면을 담당(뷰(view : JSP)의 경로)
		 *     ViewResolver => prefix + jsp파일명 + suffix
		 * */
		ModelAndView mav = new ModelAndView();
		
		// /WEB-INF/views/book/create.jsp
		mav.setViewName("book/create");
		// forwarding
		return mav;
	}
	
	// URI => http://localhost/create
	// 요청 파라미터 : {"title" : "개똥이", "category" : "분류", "price" : "100"}
	// BookVO : {"bookId" : 0, "title" : "개똥이", "category" : "분류", "price" : "100", "insertDate" : ""}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(ModelAndView mav, @ModelAttribute BookVO bookVO) {
		log.info("BookVO : " + bookVO.toString());
		
		int result = this.bookService.insert(bookVO);
		
		log.info("result : " + result);
		
		if(result < 1) { // 등록 실패
			// /create (get방식) URI를 재요청
			// 책 입력 화면으로 이동
			mav.setViewName("redirect:/create");
		}else {
			mav.setViewName("redirect:/detail?bookId=" + bookVO.getBookId());
		}
			
		return mav;
	}
	
	// 책 상세보기
	// 요청된 URI 주소 : /detail?bookId=1
	// URL : http://localhost/detail
	// 요청(HTTP) 파라미터, 쿼리 스트링 : bookId=1
	// bookVO => {bookId=0, title=null, category=null, price=0, insertDate=null}
	// @ModelAttribute 는 생략 가능
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mav, @ModelAttribute BookVO bookVO) {
		log.info("detail");
		
		log.info("bookVO : " + bookVO.toString());
		
		// select 결과 1행을 bookVO에 담을 것
		BookVO data = this.bookService.selectDetail(bookVO);
		
		// forwarding => "/WEB-INF/views/book/detail.jsp"찾아서
		// 해석/컴파일하여 html을 응답
		// 데이터(BookVO) 1행을 함께 응답.
		// but, redirect는 데이터를 응답해주지 못함
		mav.setViewName("book/detail");
		mav.addObject("data", data);
		mav.addObject("bookId", data.getBookId());
		
		return mav;
	}
	
	// 1) 요청URI => http://localhost/list
	// 2) 요청URI => http://localhost/list?keyword=개똥
	// @RequestParam(value="파라미터name(keyword)", required=false(?keyword= 일 때 오류방지), 파라미터 타입 변수명)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, @RequestParam(value = "keyword", required = false) String keyword) {
		List<BookVO> list = this.bookService.list(keyword);
		
		for(BookVO vo : list) {
			log.info("vo : " + vo.toString());
		}
		
		// forwarding
		mav.setViewName("book/list");
		// select 결과 목록을 데이터로 넘겨줌
		mav.addObject("data", list);
		
		return mav;
	}
	
	// 책 수정하기 폼
	// 요청URL => /update
	// 요청URI => /update?bookId=1
	// 요청파라미터 => bookId=1
	// bookVO => {bookId=0, title=null, category=null, price=0, insertDate=null}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(ModelAndView mav, BookVO bookVO) {
		// 책 수정 화면 = 책 입력 화면 + 책 상세 화면
		// 책 입력 화면 형식을 그대로 따라가고, 빈 칸을 데이터로 채워주면 됨
		// select 결과 1행을 bookVO에 담을 것
		
		// 책 상세 데이터
		BookVO data = this.bookService.selectDetail(bookVO);
		mav.addObject("data", data);
		
		// view : jsp의 경로
		// setvlet-context.xml에서 설정한대로...
		// /WEB/INF/views/ + ... + .jsp
		mav.setViewName("book/update");
		
		return mav;
	}
	
	// 책 변경
	// http://localhost/update?bookId=2&title=개똥이월드&price=12000
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public ModelAndView updatePost(ModelAndView mav, BookVO bookVO) {
		log.info("updatePost => bookVO : " + bookVO.toString());
		
		int result = this.bookService.update(bookVO);
		
		if(result > 0) { // 업데이트 성공 -> 책 상세페이지(detail.jsp)로 이동
			mav.setViewName("redirect:/detail?bookId=" + bookVO.getBookId());
		}else { // 업데이트 실패 => 업데이트 뷰(update.jsp)로 이동
			mav.setViewName("redirect:/update?bookId=" + bookVO.getBookId());
		}
		
		return mav;
	}
	
	// 요청URI => http://localhost/delete?bookId=1
	// 요청URL => http://localhost/delete
	// 요청파라미터 => {"bookId" : "1"}
	// 스프링에서는 요청 파라미터를 매개변수로 받을 수 있음
	// 매개변수 타입이 int 타입으로 자동 형 변환됨
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, int bookId) {
		log.info("bookId : " + bookId);
		
		int result = this.bookService.delete(bookId);
		
		// redirect => detail 메소드를 다시 실행함
		if(result > 0) { // 삭제 성공	
			mav.setViewName("redirect:/list");
		}else {
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		
		return mav;
	}
}




