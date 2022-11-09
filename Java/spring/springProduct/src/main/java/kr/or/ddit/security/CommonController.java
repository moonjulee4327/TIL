package kr.or.ddit.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {
	
	// 스프링 시큐리티 접근 권한 거부
	@RequestMapping("/security/accessError")
	public String accessDeied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		
		model.addAttribute("msg", "돌아가세요");
		
		return "security/accessError";
	}
	
	// 기본 로그인 페이지가 아닌 사용자가 직접 정의한 로그인 페이지를 사용함
	@GetMapping("/security/login")
	public String loginForm(String error, String logout, Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);
		// 오류 메시지
		if(error != null) {
			model.addAttribute("error", "Login Error!!!");
		}
		
		// 로그아웃 메시지
		if(logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
		
		// forwarding
		return "security/loginForm";
	}
}
