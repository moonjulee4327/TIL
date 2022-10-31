package kr.or.ddit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.AttachVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@Slf4j
@Controller
public class FileUploadUtil {
	
	private String uploadFolder = "C:\\eclipse-jee-2020-06-R-win32-x86_64\\workspace\\springProduct\\src\\main\\webapp\\resources\\upload";
	
	// DI(의존성 주입)
	@Autowired
	BookService bookService;
	
	// 파일 업로드 실행
	public int FileUploadUtil(MultipartFile[] multipartFiles, String tid) {
		log.info("파일 업로드를 수행합니다.");
		
		List<AttachVO> attachVOList = new ArrayList<AttachVO>();
		
		// 1) 파일 업로드 수행(연/월/일, UUID)
		// 1-1) 연/월/일
		File uploadPath = new File(uploadFolder, getFolder());
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		// <input type="file" name="" multiple>
		// ATTACH 테이블의 seq 컬럼에 들어갈 값
		int seq = 1;
		
		for(MultipartFile multipartFile : multipartFiles) {
			log.info("--------------------");
			log.info("파일명 : " + multipartFile.getOriginalFilename());
			log.info("파일크기 : " + multipartFile.getSize());
			
			// IE처리 => 경로를 제외한 파일명만 추출
			// c:\\upload\\image01.jpg => image01.jpg
			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				// 파일 복사
				multipartFile.transferTo(saveFile);
				
				AttachVO attachVO = new AttachVO();
				attachVO.setSeq(seq++);
				attachVO.setTid(tid);
				// getFolder() : 연/월/일
				// uploadFileName : UUID + 파일명
				// 윈도우 경로 => "C:\\eclipse-jee-2020-06-R-win32-x86_64\\workspace\\springProduct\\src\\main\\webapp\\resources\\upload\\파일명.확장자명"
				// 웹 경로 => \\ 를 / 로 바꾼다.
				attachVO.setAttachName("/" + getFolder().replace("\\", "/") + "/" + uploadFileName);
				log.info("AttachName : " + getFolder().replace("\\", "/")+ "/"  + uploadFileName);
				attachVO.setAttachSize(Long.valueOf(multipartFile.getSize()).intValue());
				attachVO.setAttachType(Files.probeContentType(saveFile.toPath()));
				
				attachVOList.add(attachVO);
				
				// 썸네일 처리
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				
			} catch (IllegalStateException | IOException e) {
				log.error(e.getMessage());
			}
		
		}
		
		// 2) ATTACH 테이블에 다중 insert
		// SEQ, TID, NAME, ATTACH_SIZE, ATTACH_TYPE, REGIST_DATE
		for(AttachVO attachVO : attachVOList) {
			log.info("attachVO : " + attachVO.toString());
		}
		
		// Attach 테이블에 insert 실행
		int result = this.bookService.insertAttach(attachVOList);
		log.info("ATTACH 테이블에 insert 결과 : " + result);
		
		log.info("파일 업로드를 완료했습니다.");
		return 0;
	}
	
	// 연/월/일 폴더 생성
	public String getFolder() {
		// 2022-10-28형식(format) 지정
		// 간단한 날짜 형식
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		
		// 날짜 객체 생성(java.util패키지)
		Date date = new Date();
		// 2022-10-28
		String str = sdf.format(date);
		// File.separator 사용
		return str.replace("-", File.separator);
	}
		
		
	// 이미지인지 체킹(썸네일 용)
	// 모바일과 같은 환경에서 많은 데이터를 소비해야 하므로
	// 이미지의 경우 특별한 경우가 아니면 썸네일을 제작해줘야 함
	public boolean checkImageType(File file) {
		/*
			.jpeg / .jpg(JPEG 이미지)의 MINE 타입 : image/jpeg
		 * */
		// MINE 타입을 통해 이미지 여부 확인
		// file.toPat() : 파일 객체를 path객체로 변환
		String contentType;
		try {
			contentType = Files.probeContentType(file.toPath());
			log.info("contentType : " + contentType); // image/jpeg, image/png, image/gif
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
