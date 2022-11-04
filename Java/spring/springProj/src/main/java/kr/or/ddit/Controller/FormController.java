package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.mustachejava.Binding;

import kr.or.ddit.vo.ExamMemberVO;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/form")
@Slf4j
@Controller
public class FormController {
	
	// <form:form modelAttribute="member" method="post" action="register">
	@GetMapping("/registerForm01")
	public String registerForm01(Model model) {
		log.info("registerForm01에 왔다.");
		
		// <form:form modelAttribute="member" 같아야 한다.
		model.addAttribute("member", new ExamMemberVO());
		
		return "form/registerForm";
	}
	
	// <form:form modelAttribute="examMemberVO" method="post" action="register">
	@GetMapping("/registerForm02")
	public String registerForm02(@ModelAttribute ExamMemberVO examMemberVO) {
		log.info("registerForm02에 왔다.");
		
		return "form/registerForm02";
	}
	
	// <form:form modelAttribute="member" method="post" action="register">
	@GetMapping("/registerForm03")
	public String registerForm03(@ModelAttribute("examMemberVO111111") ExamMemberVO examMemberVO, Model model) {
		log.info("registerForm03에 왔다.");
		
		// 폼 객체의 프로퍼티에 값을 미리 지정해놓음
		examMemberVO.setMemId("gaeddongi");
		examMemberVO.setMemName("개똥이");
		// password는 값을 설정하여 view에 전달하더라도 password 필드에 반영이 안됨
		examMemberVO.setPassword("java");
		
		// 체크박스
		Map<String,String> hobbyMap = new HashMap<String,String>();
		
		hobbyMap.put("Sports", "Sports");
		hobbyMap.put("Music", "Music");
		hobbyMap.put("Movie", "Movie");		
		
		// 라디오 버튼
		Map<String,String> genderMap = new HashMap<String, String>();
		
		genderMap.put("Male", "Male");
		genderMap.put("Female", "Female");
		genderMap.put("Other", "Other");
		
		// select 박스
		Map<String,String> nationalityMap = new HashMap<String, String>();
		
		nationalityMap.put("Korea", "Korea");
		nationalityMap.put("Germany", "Germany");
		nationalityMap.put("Australia", "Australia");
		
		model.addAttribute("hobbyMap", hobbyMap);
		model.addAttribute("genderMap", genderMap);		
		model.addAttribute("nationalityMap", nationalityMap);
		
		return "form/registerForm03";
	}
	
	// 요청 URI : /form/register
	// 방식 : post
	// 파라미터 : {"memId":"faeddongi","memName":"개똥이","password":"java","introduction":"소개글","hobbyList":"[Sports, Movie]"}
	@PostMapping("/register")
	public String registerFormPost(@Validated ExamMemberVO examMemberVO, Model model, BindingResult result) {
		log.info("ExamMemberVO : " + examMemberVO.toString());
		
		// registerForm03.jsp 에서 post 요청 시 validated 확인 후
		// 문제 발생시 폼 화면으로 돌아감
		if(result.hasErrors()) {
			return "form/registerForm03";
		}
		
		String[] hobbyList = examMemberVO.getHobbyList();
		
		if(hobbyList != null) {
			for(String hobby : hobbyList) {
				log.info("hobby : " + hobby);
			}
		}
		
		model.addAttribute("hobbyList", hobbyList);
		
		return "form/success";
	}
	
}
