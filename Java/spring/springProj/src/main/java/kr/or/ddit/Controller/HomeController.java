package kr.or.ddit.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	// http://localhost/
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	/* 1. void 타입
	 	호출하는 URL과 동일한 뷰 이름을 나타냄
	 */
	@RequestMapping(value = "/goHome0101", method = RequestMethod.GET)
	public void home0101() {
		log.info("home0101에 왔다.");
		// return "goHome0101";
	}
	
	
	@RequestMapping(value = "/goHome0102", method = RequestMethod.GET)
	public void home0102() {
		log.info("home0102에 왔다.");
		// return "goHome0101";
	}
	
	/* 2. String 타입
	 	뷰 파일의 경로와 파일 이름을 나타내기 위해 사용
	 */
	@RequestMapping(value = "/goHome0201", method = RequestMethod.GET)
	public String home0201() {
		log.info("home0201에 왔다.");
		// forwording
		return "goHome0201";
	}
	
	@RequestMapping(value = "/sub/goHome0202", method = RequestMethod.GET)
	public String home0202() {
		log.info("home0202에 왔다.");
		// forwording
		return "goHome0202";
	}
	
	/* 3. 자바빈즈 클래스 타입
	 	JSON 객체 타입의 데이터를 만들어서 반환하는 용도로 사용
	 	pom.xml에 jackson-databind 의존 라이브러리가 추가되어 있어야 함
	 	
	 	@ResponseBody를 지정하지 않으면 HTTP 404 오류 발생
	 	의존 라이브러리가 추가 되어 있지 않으면 406 오류 발생
	 */
	@ResponseBody
	@RequestMapping(value = "/goHome0301", method = RequestMethod.GET)
	public BookVO home0301() {
		log.info("home0301");
		
		BookVO bookVO = new BookVO();
	    bookVO.setBookId(7);
	    bookVO.setTitle("천원짜리 변호사");
	    bookVO.setCategory("드라마");
	    bookVO.setPrice(10000);
	    bookVO.setInsertDate(new Date());
	    
	    return bookVO;
	}
	
	/* 4. 컬렉션 List 타입
	 	JSON 객체 배열 타입의 데이터를 만들어서 반환하는 용도로 사용
	 * */
	@ResponseBody
	@RequestMapping(value = "/goHome0401", method = RequestMethod.GET)
	public List<BookVO> home0401() {
		log.info("home0401");
		
		List<BookVO> list = new ArrayList<BookVO>();
		
		BookVO bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("천원짜리 변호사");
		bookVO.setCategory("드라마");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		list.add(bookVO); // 0
		
		bookVO = new BookVO();
		bookVO.setBookId(8);
		bookVO.setTitle("나의 해방일지");
		bookVO.setCategory("음악");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		list.add(bookVO); // 1
		
		return list;
	}
	
	/* 5. Map 타입
	 	Map 형태의 자료를 JSON 객체 타입의 데이터로 만들어서 반환
	 * */
	@ResponseBody
	@RequestMapping(value = "goHome0501", method = RequestMethod.GET)
	public Map<String, BookVO> home0501() {
		log.info("home0501");
		
		Map<String, BookVO> map = new HashMap<String, BookVO>();
		
		BookVO bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("천원짜리 변호사");
		bookVO.setCategory("드라마");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		map.put("key1", bookVO);
		
		bookVO = new BookVO();
		bookVO.setBookId(8);
		bookVO.setTitle("나의 해방일지");
		bookVO.setCategory("음악");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		map.put("key2", bookVO);
		
		return map;
	}
	
	/* 6.ResponseEntity<Void> 타입
	 	response 할 때 Http 헤더 정보와 내용을 가공 시 사용
	 * */
	// 200 OK 상태코드 응답
	@ResponseBody
	@RequestMapping(value = "/goHome0601", method = RequestMethod.GET)
	public ResponseEntity<Void> home0601() {
		log.info("home0601에 왔다.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/* 7.ResponseEntity<Void> 타입
 		response 할 때 Http 헤더 정보와 내용을 가공 시 사용
	 * */
	// "SUCCESS"메시지와 200 OK 상태코드 응답
	@ResponseBody
	@RequestMapping(value = "/goHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> home0701() {
		log.info("home0701에 왔다.");
		
		return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
	}
	
	/* 7.ResponseEntity<Void> 타입
		response 할 때 Http 헤더 정보와 객체 데이터를 전달
	 * */
	// 객체의 JSON타입의 데이터와 200 OK 상태코드 응답
	@ResponseBody
	@RequestMapping(value = "/goHome0801", method = RequestMethod.GET)
	public ResponseEntity<BookVO> home0801() {
		log.info("home0801에 왔다.");
		
		BookVO bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("천원짜리 변호사");
		bookVO.setCategory("드라마");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		return new ResponseEntity<BookVO>(bookVO, HttpStatus.OK);
	}
	
	// List와 Map도 8번을 응용하여 JSON타입의 데이터로 응답할 수 있다.
	
	/* 11. ResponseEntity<byte[]>타입	
	  	response할 때 Http헤더 정보와 바이너리 파일 데이터를 전달할 수 있음
	 */
	@ResponseBody
	@RequestMapping(value = "/goHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> home1101() throws IOException {
		log.info("home1101에 왔다.");
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		try {
			in = new FileInputStream("C:\\eclipse-jee-2020-06-R-win32-x86_64\\workspace\\springProj\\src\\main\\webapp\\resources\\upload\\go.jpg");
			headers.setContentType(MediaType.IMAGE_JPEG);
			// commons.io
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (IOException e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
	} 
	
	// 파일의 데이터를 브라우저가 다운로드 받도록 해보자
	@ResponseBody
	@RequestMapping(value = "goHome1102", method = RequestMethod.GET)
	public ResponseEntity<byte[]> home1102() throws Exception {
		log.info("home1102에 왔다.");
		
		String fileName = "sin.zip";
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			in = new FileInputStream("C:\\eclipse-jee-2020-06-R-win32-x86_64\\workspace\\springProj\\src\\main\\webapp\\resources\\upload\\" + fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment;filename\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
		
	}
	
	/* 컨트롤러 메서드 매개변수
    	1. Model
	       이동 대상에 전달할 데이터를 가지고 있는 인터페이스
	       
	    2. RedirectAttributes
	       리다이렉트 대상에 전달할 데이터를 가지고 있는 인터페이스
	       
	    3. 자바빈즈 클래스
	       요청 파라미터를 가지고 있는 자바빈즈 클래스
	       
	    4. MultipartFile
	       업로드된 파일 정보를 가지고 있는 인터페이스
	       
	    5. BindingResult
	       도메인 클래스(VO)의 입력값 검증 결과를 가지고 있는 인터페이스
	       스프링폼과 함께 사용됨
	       
	    6. java.util.Locale
	       클라이언트 로케일
	       
	    7. java.security.Principal
	       클라이언트 인증을 위한 사용자 정보를 가지고 있는 인터페이스
    */
	
	
}
