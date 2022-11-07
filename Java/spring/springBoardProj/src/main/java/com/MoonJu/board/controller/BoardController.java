package com.MoonJu.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MoonJu.board.service.BoardService;
import com.MoonJu.board.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/")
	public String boardIndex() {
		
		return "index";
	}
	
	@GetMapping("/list")
	public String boardList(Model model) {
		
		List<BoardVO> list = this.boardService.selectList();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@GetMapping("/write")
	public String boardInsertForm() {
			
		return "board/writeForm";
	}
	
	@PostMapping("/writePost")
	public String boardInsert(BoardVO boardVO) {
		
		int result = boardService.insertBoard(boardVO);
		
		if(result > 0) {
			log.info("글 쓰기 성공");			
		}else {
			log.info("글 쓰기 실패!!!!!");		
		}
		
		return "redirect:/board/list";
	}
	
}
