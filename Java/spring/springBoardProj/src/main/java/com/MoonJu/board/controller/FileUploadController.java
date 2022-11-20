package com.MoonJu.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.MoonJu.board.util.FileUploadUtil;
import com.MoonJu.board.vo.AttachFileBoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/fileUploadExercise")
@Controller
public class FileUploadController {

	@GetMapping("/fileUpload")
	public String fileUploadForm() {
		return "fileUploadExercise/fileUpload";
	}
	
	@PostMapping("/fileUploadPost")
	public String fileUploadPost(MultipartFile[] uploadFile, AttachFileBoardVO attachFileBoardVO) {
		
		log.info("uploadFile : " + uploadFile[0].getOriginalFilename());
		
		FileUploadUtil.fileUpload(uploadFile, attachFileBoardVO);
		
		return "redirect:/fileUploadExercise/fileUpload";
	}
}
