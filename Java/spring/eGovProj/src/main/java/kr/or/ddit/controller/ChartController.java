package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChartController {
	
	// json 구글차트
	@GetMapping("/chart01")
	public String chart01() {
		return "chart/chart01";
	}
	
	// json 구글 멀티 차트
	@GetMapping("/chart01Multi")
	public String chart01Multi() {
		return "chart/chart01Multi";
	}
	
	// oracle 구글차트
	@GetMapping("/chart02")
	public String chart02() {
		return "chart/chart02";
	}
}
