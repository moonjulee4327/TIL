package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.service.GalleryService;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/gallery")
@Slf4j
@Controller
public class GalleryController {
	
	@Autowired
	GalleryService galleryService;
	
	@GetMapping("/list")
	public String list(Model model, @ModelAttribute BookVO bookVO) {
		
		BookVO list = this.galleryService.list(bookVO);
		
		model.addAttribute("bodyTitle", "이미지 목록");
		model.addAttribute("list", list);
		
		return "gallery/list";
	}
	
	@ResponseBody
	@GetMapping("/bookList")
	public List<BookVO> selectSel(){
		return this.galleryService.bookList();
	}
}
