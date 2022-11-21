package kr.or.ddit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.service.GalleryService;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

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
	
	// 요청 URI : /gallery/updatePost
	// 첨부파일 이미지를 변경함
	// 파라미터 : attachVO{"userNo" : "3", "seq" : "5"} + 파일 객체 (name은 uploadFile)
	@ResponseBody
	@PostMapping("/updatePost")
	public AttachVO updatePost(MultipartFile[] uploadFile, @ModelAttribute AttachVO attachVO) {
		log.info("uploadFile : " + uploadFile + ", attachVO : " + attachVO);
		
		String uploadFolder = "C:\\eGovFrameDev-3.10.0-64bit\\workspace\\eGovProj\\src\\main\\webapp\\resources\\upload";
		
		// 연월일 폴더 생성
		File uploadPath = new File(uploadFolder, getFolder());
		log.info("uploadPath : " + uploadPath);
		
		// 만약 연/월/일 해당 폴더가 없으면 생성
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		// 원래 파일명
		String uploadFileName = "";
		
		// 파일 배열로부터 파일 하나씩 가져오기
		// MultipartFile[] uploadFile -> input type=file의 name=uploadFile 같아야 한다.
		for(MultipartFile multipartFile : uploadFile) {
			log.info("---------------------");
			log.info("upload File Name : " + multipartFile.getOriginalFilename());
			log.info("upload File Size : " + multipartFile.getSize());
			// 개똥이.jpg
			uploadFileName = multipartFile.getOriginalFilename(); 

			// 같은 날 같은 이미지 업로드 시 파일 중복 방지 시작
			UUID uuid = UUID.randomUUID();
			// 원래의 파일 이름과 구분하기 위해 _를 붙임
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			// 같은 날 같은 이미지 업로드 시 파일 중복 방지 끝
			
			// File 객체 설계(복사할 대상 경로, 파일명)
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				// 파일 복사 실행
				multipartFile.transferTo(saveFile);
				
				// 썸네일 처리
				// 이미지 체크(썸네일은 이미지만 가능하다)
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName)); 
					// 썸네일 생성
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				
				String filename = "/" + getFolder().replace("\\", "/") + "/" + uploadFileName;
				
//				attachVO.setUserNo("3");
//				attachVO.setUserNo("1");
				attachVO.setFilename(filename);
				
				int result = this.galleryService.imageUpdate(attachVO);
				
				if(result > 0) {
					log.info("성공~~~~");
				}else {
					log.info("실패");
				}
					
				return attachVO;
			} catch (IllegalStateException e) {
				log.error(e.getMessage());
				return null;
			} catch (IOException e) {
				log.error(e.getMessage());
				return null;
			}
		}
		
		
		return null;
	} 
	
	// 연/월/일 폴더 생성
	public String getFolder() {
		// 2022-11-16 형식 지정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		// 2022-11-16
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
	
	// 이미지인지 체킹
	public boolean checkImageType(File file) {
		// MINE 타입을 알아냄 .jpg , .jpeg
		String contentType;
		try {
			contentType = Files.probeContentType(file.toPath());
			log.info("contentType : " + contentType);
			// image / jpeg는 image로 시작함 -> true
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 이 파일이 이미지가 아닐 경우
		return false;
	}
	
	@ResponseBody
	@PostMapping("/deletePost")
	public int deletePost(@RequestBody AttachVO attachVO) {
		
		log.info("attachVO :" + attachVO.toString());
		
		return this.galleryService.imageDelete(attachVO);
	}
	
	// 이미지 다중 등록
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	@GetMapping("/register")
	public String register(Model model) {
		
		log.info("들어오나");
		
		model.addAttribute("bodyTitle", "이미지 등록");
		
		return "gallery/register";
	}
	
	@ResponseBody
	@PostMapping("/registPost")
	public List<BookVO> registPost(@RequestBody BookVO bookVO) {
		log.info("bookVO : " + bookVO.toString());
		
		List<BookVO> bookVOList = this.galleryService.searchBook(bookVO);
		
		return bookVOList;
	}
	
	/*
	 * 	요청 파라미터 : uploadFile[] , bookId => 폼으로 오므로 RequestBody는 안쓴다.
	 * 	응답 데이터 : {"bookId":"3","status":"1"}
	 * 
	 * */
	@ResponseBody
	@PostMapping("/uploadAjaxAction")
	public Map<String, String> uploadAjaxAction(MultipartFile[] uploadFile, @RequestParam String bookId) {
		log.info("uploadFile[0].getOriginalFilename() : " + uploadFile[0].getOriginalFilename() + ", bookId : " + bookId);
		
		List<AttachVO> attachVOList = new ArrayList<AttachVO>();
		
		// ATTACH 테이블의 bookId에 해당하는 MAX(SEQ)+1 를 가져와보자(이미 첨부 파일을 가지고 있다면...)
		int seq = this.galleryService.getSeq(bookId);
		log.info("seq : " + seq);
		
		// 파일 업로드 + 썸네일 이미지
		// 윈도우 업로드 경로 설정
		String uploadFolder = "C:\\eGovFrameDev-3.10.0-64bit\\workspace\\eGovProj\\src\\main\\webapp\\resources\\upload";
		
		// 연월일 폴더 생성
		File uploadPath = new File(uploadFolder, getFolder());
		log.info("uploadPath : " + uploadPath);
		
		// 만약 연/월/일 해당 폴더가 없으면 생성
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		String uploadFileName = "";
		for(MultipartFile multipartFile : uploadFile) {
			AttachVO attachVO = new AttachVO();
			uploadFileName = multipartFile.getOriginalFilename(); 

			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				multipartFile.transferTo(saveFile);
				
//				attachVO.setUserNo(bookId);
//				attachVO.setSeq(seq++);
//				attachVO.setFilename(uploadFileName);
//				attachVO.setFilesize(Long.valueOf(multipartFile.getSize()).intValue());
//				
//				attachVOList.add(attachVO);
				
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
					
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				
				String filename = "/" + getFolder().replace("\\", "/") + "/" + uploadFileName;
				
				attachVO.setUserNo(bookId);
				attachVO.setSeq(seq++);
				attachVO.setFilename(filename);
				attachVO.setFilesize(Long.valueOf(multipartFile.getSize()).intValue());
				
				attachVOList.add(attachVO);
				
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			
		}
		
		int result = this.galleryService.uploadAjaxAction(attachVOList);
		
		if(result > 0) {
			log.info("성공");
		}else {
			log.info("실패");
		}
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("bookId", bookId);
		map.put("status", String.valueOf((result)));
		
		return map;
	}
	
}
