package com.MoonJu.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MoonJu.board.service.BoardService;
import com.MoonJu.board.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/spa")
@Slf4j
@Controller
public class SpaController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<BoardVO> list = this.boardService.selectList();
		
		model.addAttribute("list", list);
		
		return "spa/spaIndex";
	}
	
	@ResponseBody
	@GetMapping("/detail")
	public BoardVO detail(@RequestParam int writeNo) {
		
//		log.info("writeNo : " + writeNo);
		
		BoardVO data = this.boardService.detail(writeNo);
		
		return data;
	}
	
	@ResponseBody
	@PostMapping("/update")
	public int update(@RequestBody BoardVO boardVO) {
		
		log.info("boardVO : " + boardVO.toString());
		
		int result = this.boardService.update(boardVO);
		
		return result;
	}
	
	@ResponseBody
	@GetMapping("/list")
	public List<BoardVO> list(){
		return this.boardService.selectList();
	}
	
	
}
