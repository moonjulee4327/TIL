package kr.or.ddit.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {
	
	// 요청 URI : /download?fileName=파일명.확장자
	@ResponseBody
	@RequestMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName, HttpSession session){
		log.info("download file : " + fileName);
		
		String realPath = session.getServletContext().getRealPath("/resources/upload");
		
		Resource resource = new FileSystemResource(realPath + fileName);
		
		log.info("path : " + (realPath + realPath));

		String resourceName = resource.getFilename();
		log.info("resourceName : " + resourceName);
		
		// 헤더를 통해서 파일을 보냄
		HttpHeaders headers = new HttpHeaders();
		
		try {
			headers.add("Content-Disposition", "attachment;filename=" + 
					new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
	
}
