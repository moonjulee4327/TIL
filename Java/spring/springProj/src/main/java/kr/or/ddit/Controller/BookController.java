package kr.or.ddit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
	Controller 어노테이션
	스프링 프레임워크에게 이 클래스는 웹 브라우저의 요청(request)를 
	받아들이는 컨트롤러야 하고 알려주는 것임
	스프링은 servlet-context.xml의 context:component-scan의 설정에 의해
	이 클래스를 자바빈 객체로 등록(메모리에 바인딩)
 * */
@Controller
public class BookController {
	// URI => http://localhost/create
	
	@RequestMapping(value = "/create", method=RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		
		// /WEB-INF/views/book/create.jsp
		mav.setViewName("book/create");
		
		return mav;
	}
	
}
