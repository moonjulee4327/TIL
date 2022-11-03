package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.BookService;
import kr.or.ddit.util.ArticlePage;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.ExamMemberVO;
import lombok.extern.slf4j.Slf4j;

//@RequestMapping("/board")
@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	BookService bookService;
	
	@Inject
	FileUploadUtil fileUploadUtil; 
	
	/**
	 * 	1. RequestMapping의 value속성에 요청 경로를 설정
	 * 	- 요청 경로는 반드시 설정해야 하는 필수 정보
	 * 	- 속성이 하나일 때는 속성명을 생략할 수 있음(RequestMapping("/board/register")) 가능
	 * 	- 컨트롤러의 클래스 레벨과 메소드 레벨로 지정할 수 있음 
	 * 	- 클래스 레벨로 요청 경로를 지정하면 메소드 레벨에서 지정한 경로의 기본 경로로 취급됨
	 * 	- 클래스 레벨의 요청 경로에 메소드 레벨의 요청 경로를 덧붙인 형태가 최종 경로가 됨
	 */
	// value속성에 요청 경로 값을 입력
	// 요청 URL : http://localhost/board/register
	@RequestMapping(value = "/register")
	public void registerForm() {
		log.info("registerForm");
	}
	
	// 속성이 하나일 때는 속성명을 생략할 수 있다.
	@RequestMapping("/modify")
	public void modifyForm() {
		log.info("modifyForm");
	}
	
	/*
	 * 	2. 경로 패턴 매핑
	 * 	요청 경로를 동적으로 표현이 가능한 경로 패턴을 지정할 수 있음
	 * 	- URL 경로 상의 변하는 값을 경로 변수로 취급
	 * 	- 경로(Path) 변수(Variable)에 해당라는 값을 파라미터 변수에 설정할 수 있음 
	 * */
	// 요청 URI : http://localhost/board/read/100 => 100번글
	// 요청 URI : http://localhost/board/read/101 => 101번글
	// 요청 URI : http://localhost/board/read/102 => 102번글
	// ...
	// 요청 URI : http://localhost/board/read?boardId=102 => 102번글(지금까지는 이렇게 했다.)
	
	@RequestMapping("/read/{boardNo}")
	public String read(@PathVariable("boardNo") int boardNo) {
		log.info("boardNo : " + boardNo);
		
		// 뷰 이름 지정
		return "board/read";
	}
	
	@RequestMapping("/formHome")
	public String formHome() {
		// forwardimg
		return "board/formHome";
	}
	
	/*
		3. Http 메소드 매핑
		method 속성을 사용하는 HTTP메소드를 매핑 조건으로 지정 가능
		화면으로 응답하는 경우 HTTP 메소드로 GET방식과 POST방식 두 가지를 사용함
	 */
	
	
//	@GetMapping("/register2")
	@RequestMapping(value = "/register2", method = RequestMethod.GET)
	public String register2(Model model) {
		// Model 인터페이스 => 데이터 담당
		model.addAttribute("name", "개똥이");
		
		// forwardimg. 경로담당
		return "board/formHome";
	}
	
//	@PostMapping("/register2")
	@RequestMapping(value = "/register2", method = RequestMethod.POST)
	public String register2Post(Model model) {
		// Model 인터페이스 => 데이터 담당
		model.addAttribute("name", "메뚜기");
		
		// forwardimg. 경로담당
		return "board/formHome";
	}
	
	/*
	 	4. Params 매핑
	 	- 요청 파라미터를 매핑 조건으로 지정하는 경우 params속성을 사용함
	 	- 버튼이나 링그에 따라 호출할 메소드를 바꿔야 할 때 사용
	 * */
	// <p><a href="/board/get?register">Register</a></p>
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="register")
	public String getRegister() {
		log.info("getRegister에 왔다.");
		// forwarding. 경로 담당
		return "board/formHome";
	}
	
	// <p><a href="/board/get?modify">Modify</a></p>
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="modify")
	public String getModify() {
		log.info("getModify에 왔다.");
		// forwarding. 경로 담당
		return "board/formHome";
	}
	
	/*
	 	<form action="/board/post" method="post">
			<button type="submit" name="register">Register</button>
		</form>
	 * */
	@RequestMapping(value = "/post", method = RequestMethod.POST, params="register")
	public String postRegister() {
		log.info("postRegister에 왔다.");
		// forwarding. 경로 담당
		return "board/formHome";
	}
	
	/*
	 	<form action="/board/post" method="post">
			<button type="submit" name="modify">Modify</button>
		</form>
	 * */
	@RequestMapping(value = "/post", method = RequestMethod.POST, params="modify")
	public String postModify() {
		log.info("postModify에 왔다.");
		// forwarding. 경로 담당
		return "board/formHome";
	}
	
	
	/*
	   5. Header 매핑
	   요청 헤더를 매핑 조건으로 지정하는 경우에는 headers 속성을 사용
	 * */
	// 요청URI : http://localhost/board/ajaxHome
	@RequestMapping("/ajaxHome")
	public String ajaxHome() {
		log.info("ajaxHome에 왔다.");
		
		return "board/ajaxHome";
	}
	
	// success: function(result) {
	// 요청URI : http://localhost/board/7
	// /7 => 경로 변수(동적)
	// @ResponseBody를 통해서  JSON데이터로 리턴
//	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT)
//	public ResponseEntity<String> ajaxModify(@PathVariable("boardNo") int boardNo) {
//		log.info("ajaxModify에 왔다.");
//		log.info("boardNo : " + boardNo);
//		
//		// success: function(result) {
//		// 헤더에 String 데이터를 넣음
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		
//		return entity;
//	}
	
	
	/*
	 	headers:{
					"X-HTTP-method-Override":"PUT"
				}
				
		추가 시 쓰는 Mapping
	 * */
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, headers="X-HTTP-method-Override=PUT")
	public ResponseEntity<String> ajaxModify(@PathVariable("boardNo") int boardNo) {
		log.info("ajaxModify에 왔다.");
		log.info("boardNo : " + boardNo);
		
		// success: function(result) {
		// 헤더에 String 데이터를 넣음
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	// 요청 => $.get("/board/"+boardNo, function(data) {
	// 요청URI : http://localhost/board/7
	// /7 : 경로 변수
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<BookVO> getRaed(@PathVariable("boardNo") int boardNo) {
		log.info("boardNo : " + boardNo);
		
		BookVO bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("천원짜리 변호사");
		bookVO.setCategory("드라마");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		// vo를 응답데이터에 포함
		// HttpStatus.OK : 통신 상태 200
		ResponseEntity<BookVO> entity = new ResponseEntity<BookVO>(bookVO, HttpStatus.OK);
		
		return entity;
		
	}
	
	// 요청URI : /board/getBook
	// data : {"boardNo":7}
	// contentType : application/json; charset:utf-8
	@ResponseBody
	@RequestMapping(value = "/getBook", method = RequestMethod.POST)
	public List<BookVO> getBook(@RequestBody String boardNo) {
		log.info("boardNo : " + boardNo);
		// List 인터페이스를 ArrayList 클래스로 구현
		List<BookVO> bookVOList = new ArrayList<BookVO>();
		
		BookVO bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("천원짜리 변호사");
		bookVO.setCategory("드라마");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		bookVOList.add(bookVO);
		
		bookVO = new BookVO();
		bookVO.setBookId(8);
		bookVO.setTitle("모놀로그");
		bookVO.setCategory("음악");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		bookVOList.add(bookVO);
		
		return bookVOList;
	}
	
	// 요청 URI : /board/list?currentPage=2
	// 요청 파라미터 : currentPage=2
	@GetMapping("/board/list")
	public String boardList(Model model, @RequestParam(defaultValue = "1", required = false) int currentPage, @RequestParam Map<String,String> map) {
		
		log.info("currentPage : " + currentPage);
		
		// /board/list 이렇게 요청되었을 경우 처리
		String cPage = map.get("currentPage");
		String show = map.get("show");
		String keyword = map.get("keyword");
		
		if(cPage == null) {
			map.put("currentPage", "1");
		}
		if(show == null) {
			map.put("show", "10");
		}
		if(keyword == null) {
			map.put("keyword","");
		}
		
		// map : {currentPage=3, show=50}
		log.info("map : " + map);
		
		List<ExamMemberVO> list = this.bookService.examMemList(map);
		int total = this.bookService.getTotal(map);
//		int total = this.bookService.getTotal();
		
		// 한 화면에 보여질 행 수
		int size = Integer.parseInt(map.get("show"));
		
//		log.info("ExamMemberVO : " + list.get(0).toString());
		
//		model.addAttribute("list", list);
		
		// (전체 글 수, 현재 페이지, 한 화면에 보여질 행 수, select 결과 list)
		model.addAttribute("list", new ArticlePage<ExamMemberVO>(total, currentPage, size, list));
		
		return "board/list";
	}
	
	@GetMapping("/board/signUp")
	public String boardSignUp() {
		return "board/signUp";
	}
	
	@PostMapping("/board/signUp")
	public String boardSignUpPost(MultipartFile[] file, ExamMemberVO memberVO) {

//		bookService.memberinsert(memberVO);
		
//		log.info("파일 이름 : " + file.getOriginalFilename());
		
		
		this.bookService.memberinsert(memberVO);
		
		
		return "redirect:/board/list";
		
	}
	
	@ResponseBody
	@GetMapping("/board/idCheck")
	public int boardIdCheck(String memId) {
		
		log.info("memId : " + memId);
		
		int result = this.bookService.memberIdCheck(memId);
		
		return result;
		
	}
	
	
	/*
	  	8. 파일업로드 폼 방식 요청 처리
	  	파일업로드 폼 파일<input type="file" ... 요소(=태그)> 값을 
	  	스프링 MVC가 지원하는 MultipartFile 매개변수로 처리함
	 
	 */
	@GetMapping("/board/register06")
	public String register06() {
		log.info("register06에 왔다.");
		return "board/register06";
	}
	
	// <input type="file" name="picture">
	// MultipartFile picture 이 두개의 명은 같아야 한다.
	@PostMapping("/board/registerFile01")
	public String registerFile01Post(MultipartFile picture) {
		log.info("registerFile01");
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("size : " + picture.getSize());
		log.info("contentType(MINE타입) : " + picture.getContentType());
		
		// forward
		return "board/success";
	}
	
	// <input type="file" name="picture">
	// MultipartFile picture 이 두개의 명은 같아야 한다.
	@PostMapping("/board/registerFile02")
	public String registerFile02Post(String userId, String password, MultipartFile picture) {
		log.info("registerFile02");
		log.info("userId : " + userId);
		log.info("password : " + password);
		
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("size : " + picture.getSize());
		log.info("contentType(MINE타입) : " + picture.getContentType());
		
		// forward
		return "board/success";
	}
	
	// <input type="file" name="picture">
	// MultipartFile picture 이 두개의 명은 같아야 한다.
	@PostMapping("/board/registerFile03")
	public String registerFile03Post(ExamMemberVO memVO, MultipartFile picture) {
		log.info("registerFile02");
		log.info("memVO : " + memVO.toString());
		
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("size : " + picture.getSize());
		log.info("contentType(MINE타입) : " + picture.getContentType());
		
		// forward
		return "board/success";
	}
	
	// <input type="file" name="picture">
	// <input type="file" name="picture2">
	// MultipartFile picture 이 두개의 명은 같아야 한다.
	@PostMapping("/board/registerFile05")
	public String registerFile05Post(ExamMemberVO memVO, MultipartFile picture, MultipartFile picture2) {
		log.info("registerFile05");
		log.info("memVO : " + memVO.toString());
		
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("size : " + picture.getSize());
		log.info("contentType(MINE타입) : " + picture.getContentType());

		log.info("originalName : " + picture2.getOriginalFilename());
		log.info("size : " + picture2.getSize());
		log.info("contentType(MINE타입) : " + picture2.getContentType());
		
		// forward
		return "board/success";
	}
	
	@PostMapping("/board/registerFile06")
	public String registerFile06Post(ExamMemberVO memVO, List<MultipartFile> pictureList) {
		log.info("registerFile06");
		log.info("memVO : " + memVO.toString());
		
		for(MultipartFile picture : pictureList) {
			log.info("originalName : " + picture.getOriginalFilename());
			log.info("size : " + picture.getSize());
			log.info("originalName : " + picture.getContentType());
		}
		
		// forward
		return "board/success";
	}
	
	@PostMapping("/board/registerFile07")
	public String registerFile07Post(ExamMemberVO memVO, MultipartFile[] pictures) {
		log.info("registerFile07");
		log.info("memVO : " + memVO.toString());
		
		MultipartFile[] pictureArray = memVO.getPictureArray();
		
		for(MultipartFile picture : pictureArray) {
			log.info("originalName : " + picture.getOriginalFilename());
			log.info("size : " + picture.getSize());
			log.info("originalName : " + picture.getContentType());
		}
		
		// forwarding
		return "board/success";
	}
	
	@GetMapping("/board/register07")
	public String register07Get() {
		// forwarding
		return "board/register07";
	}
	
	// formData.append("file",file);
	// 매개변수 MultipartFile file 가 명이 같음
//	@PostMapping("/board/uploadAjax")
	@RequestMapping(value = "/board/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile[] file) {
		String originalFileName = file[0].getOriginalFilename();
		log.info("originalName : " + originalFileName);
		ResponseEntity<String> enity = new ResponseEntity<String>("SUCCESS : " + originalFileName, HttpStatus.OK);
		
		UUID uid = UUID.randomUUID();
		
		this.fileUploadUtil.fileUploadAction(file, uid.toString());
		
		return enity;
	}
	
}
