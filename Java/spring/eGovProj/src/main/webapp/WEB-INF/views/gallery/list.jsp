<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<div class="col-12">
	<div class="card card-primary">
		<div class="card-header">
			<h4 class="card-title">Ekko Lightbox</h4>
			<!-- 도서 선택 시작-->
			<!-- ajax로 불러오기 -->
			<select class="custom-select">
	        </select>
		</div>
		<!-- 도서 선택 끝-->
		<div class="card-body">
			<div class="row">
				<!-- 모달을 띄우는 방법
					1. button으로 띄우기 
					<button type="button" class="btn btn-default" 
					data-toggle="modal" data-target="#modal-default">
					Launch Default Modal</button>
					
					2. a태그로 띄우기
					<a data-toggle="modal" href="#modal-default">Open Modal</a>
					
					3. 기타 요소로 띄우기
					<p data-toggle="modal" data-target="#modal-default">Open Modal</p>
				-->
				<c:forEach var="attachVO" items="${list.attachVOList}">
				<div class="col-sm-2">
					<a class="btn-modal"
						data-toggle="modal" data-target="#modal-default"
						data-id="/resources/upload${attachVO.filename}"
						data-title="${list.title}" data-userno="${list.bookId}" data-seq="${attachVO.seq}"> 
						<img src="/resources/upload${attachVO.filename}"
						class="img-fluid mb-2" alt="white sample">
					</a>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<!-- default modal 시작 -->
<div class="modal fade" id="modal-default" style="display: none;"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title"></h4>
				<input type="hidden" id="txtUserNo" value="" />
				<input type="hidden" id="txtSeq" value="" />
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="body-content" style="width: 100%"></p>
			</div>
			<div class="modal-footer justify-content-between">
				<div style="float: left;">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
				<div style="float: right;">
					<span id="spn1">
						<button type="button" id="edit" class="btn btn-primary">수정</button>						
						<button type="button" id="delete" class="btn btn-danger">삭제</button>						
					</span>
					<span id="spn2" style="display: none;">
						<div class="input-group justify-content-between">
							<div class="custom-file" style="float: left;">
								<input type="file" class="custom-file-input" id="uploadFile" name="uploadFile" style="width: 250px">
								<label class="custom-file-label" for="exampleInputFile">파일을 선택하세요.</label>
							</div>
						<div style="float: right;">
							<button type="button" id="uploadBtn" class="btn btn-success">확인</button>
							<button type="button" id="cancel" class="btn btn-warning">취소</button>
						</div>
						</div>						
					</span>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- default modal 끝 -->
<script type="text/javascript">
$(function () {
	// data-id=...
	$(".btn-modal").click(function() {
		// data-id= ...
		let data = $(this).data("id");
		// data-title= ...
		let title = $(this).data("title");
		// userId와 seq는 ATTACH 테이블의 복합키(composite key)로써의 기본키(primary key, 식별키)
		// data-userNo= ...
		let userNo = $(this).data("userno");
		// data-seq= ...
		let seq = $(this).data("seq");
		
		console.log("data : " + data + "title : " + title + "userNo : " + userNo + "seq : " + seq);
		
		$("#body-content").html("<img src='" + data + "' style='width:100%;' />");
		$(".modal-title").html(title);
		$("#txtUserNo").val(userNo);
		$("#txtSeq").val(seq);
	});
});

let currentBookId = "${param.bookId}";
let sel = "";

$(function () {
	$.ajax({
		url : "/gallery/bookList",
		dataType: "json",
		type : "get",
		success : function(data) {
// 			console.log("data : " + JSON.stringify(data));
			// item : BookVO
			$.each(data, function(index, item) {
				console.log("item.bookId : " + item.bookId);
				console.log("item.title : " + item.title);
				
				if(item.bookId == currentBookId){
					sel = "selected='selected'"
				}else{
					sel = "";
				}
				
				$(".custom-select").append("<option value='" + item.bookId + "' " + sel + ">" + item.title + "</option>");
			});
		}
	});
	
	// custom-select 가 바뀌면 이미지 목록을 다시 가져옴
	$(".custom-select").on("change", function() {
		// 선택된 option의 value를 가져와보자
		let bookId = $(this).val();
		console.log("bookId : " + bookId);
		
		location.href="/gallery/list?bookId=" + bookId;
	});
});

$(function () {
	$("#edit").on("click", function(){
		$("#spn1").css("display","none");
		$("#spn2").css("display","block");
	});
});

$(function () {
	$("#cancel").on("click", function(){
		$("#spn1").css("display","block");
		$("#spn2").css("display","none");
	});
});

// ajax 파일 업로드 구현 시작
// 이미지 체킹
let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$"); // 정규식
let maxSize = 5242880; // 5MB 까지 허용

function checkExtension(fileName, fileSize){ // 파일 명과 사이즈 체킹
	if(fileSize >= maxSize){
		alert("파일 사이즈가 초과되었습니다.");
		return false;
	}

	// fileName : 개똥이.zip
	if(regex.test(fileName)){
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
	return true;
}

// e : 클릭 이벤트
$(function () {
	$("#uploadBtn").on("click", function(e) {
		// 가상의 form 태그 생성 <form></form>
		let formData = new FormData();
		// <input type="file" name="uploadFile"
		let inputFile = $("input[name='uploadFile']");
		// 파일 object 안에 이미지를 
		let files = inputFile[0].files;
		
		console.log("files : " + files);
		
		// 가상의 form인 formData Object에 filedata를 추가해보자
		for(let i=0; i < files.length; i++){
			// 파일 확장자/크기 체킹(exe, sh, zip, alz는 업로드 불가)
			if(!checkExtension(files[i].name, files[i].size)){
				// 반복문 종료 및 함수 종료
				return false;
			}
			
			// <form><input type='file' name='uploadFile' /></form>
			formData.append("uploadFile", files[i]);
			
		}
		/*
			<form>
				<input type='file' name='uploadFile' />
				<input type='text' name='userNo' value="3" />
				<input type='text' name='seq' value="5" />
			</form>
		*/
		
		console.log("txtUserNo : " + $("#txtUserNo").val());
		console.log("txtSeq : " + $("#txtSeq").val());
		
		formData.append("userNo",$("#txtUserNo").val());
		formData.append("seq",$("#txtSeq").val());

		console.log("formData", formData);

		$.ajax({
			url : "/gallery/updatePost",
			processData : false,
			contentType : false,
			data : formData,
			type : "post",
			dataType:"json",
			success : function(result){
				console.log("result", result);
				console.log("updatePost");
				alert("이미지 변경 성공!");
				location.href="/gallery/list?bookId=${param.bookId}";
 				// $("#body-content img").attr("src","/resources/upload"+result.filename);
			}
		});
	}); // ajax 파일업로드 끝
	
	// 이미지 미리보기 시작
	let sel_file = [];
	$("#uploadFile").on("change",handleImgFileSelect);
	// e : onchange 이벤트 객체
	function handleImgFileSelect(e) {
		// 이벤트가 발생 된 타겟 안에 들어있는 이미지 파일들을 가져와보자
		let files = e.target.files;
		// 이미지가 여러개가 있을 수 있스므로 이미지들을 각각 분리해서 배열로 만듦
		let fileArr = Array.prototype.slice.call(files);
		
		fileArr.forEach(function(f) {
			// 이미지 파일이 아닌 경우 이미지 미리보기 X
			if(!f.type.match("image.*")){
				alert("이미지 확장자만 가능합니다.");
				// 함수 종료
				return;
			}
			// 이미지 객체를 전역 배열 타입 변수에 넣자
			sel_file.push(f);
			// 이미지 객체를 읽을 자바스크립트 reader 객체 생성
			let reader = new FileReader();
			reader.onload = function(e) {
				// e.target : f(이미지 객체)
				// e.target.result : reader가 이미지를 다 읽은 결과
				let img_html = "<img src=\"" + e.target.result + "\" style='width:100%' />";
				// p사이에 이미자가 랜더링 되어 화면에 보임
				// 객체.append : 누적, .html : 새로고침, .innerHTML : J/S
				$("#body-content").html(img_html);
			}
			// f : 이미지 파일 객체를 읽은 후 다음 이미지 파일(f)을 위해 초기화 람
			reader.readAsDataURL(f);
		});
	}
	// 이미지 미리보기 끝
	
	// 이미지 삭제 시작
	$("#delete").on("click", function(){
		let userNo = $("#txtUserNo").val();
		let seq = $("#txtSeq").val();

		console.log("userNo : " + userNo + " seq : " + seq);
		
		let data = {"userNo" : userNo, "seq" : seq};

		// contentType : 보내는 타입
		// dataType : 응답 데이터 타입
		$.ajax({
			url : "/gallery/deletePost",
			contentType : "application/json;charset=utf-8",
			data :  JSON.stringify(data),
			dataType : "json",
			type : "post",
			success : function(result) {
// 				console.log("result : " + JSON.stringify(result));
				
				if(result > 0){
					location.href = "/gallery/list?bookId=${param.bookId}";
				}else{
					alert("이미지 삭제가 실패하였습니다.");
				}
			}
		});
	});
	// 이미지 삭제 끝
});
</script>