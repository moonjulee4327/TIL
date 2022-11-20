package com.MoonJu.board.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.MoonJu.board.vo.AttachFileBoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUploadUtil {
	
	
	public static AttachFileBoardVO fileUpload(MultipartFile[] multipartFiles, AttachFileBoardVO afbVO) {
		
		String uploadFolder = "C:\\eclipse-jee-2020-06-R-win32-x86_64\\workspace\\springBoardProj\\src\\main\\webapp\\resources\\upload";
		
		File uploadPath = new File(uploadFolder, getFolder());
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		String uploadFileName = "";
		
		for(MultipartFile multipartFile : multipartFiles) {
			uploadFileName = multipartFile.getOriginalFilename();
			
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				multipartFile.transferTo(saveFile);
				
				
				
				
			} catch (IllegalStateException | IOException e) {
				log.info(e.getMessage());
				return null;
			}
		}
		
		
		
		return null;
	}
	
	public static String getFolder() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
	
	
}
