<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/validation.js"></script>
<script type="text/javascript">
$(function () {
    $("#idCheck").on("click", function() {
//     	alert("들어옴" + $("#memId").val());
    	$.ajax({
    		url : "/board/idCheck",
    		type : "get",
    		data : {
    			memId : $("#memId").val()
    		},
    		success : function(data) {
// 				console.log("넘어옴 : " + data);
				if(data > 0){
					$("#dispIdCheck").html("중복된 아이디입니다.");
					$("#memId").focus();
					$("#signUp").attr("disabled",true);
				}else{
					$("#dispIdCheck").html("사용 가능한 아이디입니다.");
					$("#signUp").removeAttr("disabled");
// 				    $("#signUp").on("click", function() {
// 						alert("눌림");
// 				     	frm.submit();
// 					});
				}
			}
    	})
    	
    });
	
//     $("#input_imgs").on("change", handleImgFileSelect);
//  	// 이미지 미리보기 시작////////////////////////////
	let sel_file = [];
	
	// <input type="file" id="productImage" name="productImage" class="form-control" multiple="multiple">
	$("#productImage").on("change", handleImgFileSelect);
	// 파라미터 e : onchange 이벤트 객체
	function handleImgFileSelect(e) {
		// 이벤트가 발생된 타겟 안에 이미지 파일들을 가져와보자
		let files = e.target.files;
		// 이미지가 여러개가 있을 수 있으므로 이미지를 분리하여 배열로 만듦
		let fileArr = Array.prototype.slice.call(files);
		// 파일 타입의 배열 반복. f : 파일 배열 안에 들어있는 각각의 이미지 파일 객체
		fileArr.forEach(function(f) {
			// 이미지 파일이 아닌 경우 이미지 미리보기 실패로 처리
			if(!f.type.match("image.*")){
				alert("이미지 확장자만 가능합니다.");
				// 함수를 종료
				return;
			}
			// 이미지 객체를(f) 전역 배열타입 변수(sel_file)에 넣자
			sel_file.push(f);
			// 이미지 객체를 읽을 자바스크립트의 reader 객체 생성
			let reader = new FileReader();
			// e : reader가 이미지 객체를 읽는 이벤트
			reader.onload = function(e) {
				// e.target : 이미지 객체
				// e.target.result : reader가 이미지를 다 읽은 결과
				let img_html = "<img src=\""+e.target.result+"\" />";
				// div 사이에 이미지가 렌더링되어 화면에 보임
				// 객체.append : 누적, .html : 새로고침, innerHTML : J/S
				$(".imgs_wrap").append(img_html);
			}
			// f : 이미지 파일 객체를 읽은 후 
			reader.readAsDataURL(f);
		}); // end forEach
	}
	
	// 이미지 미리보기 끝////////////////////////////
})

</script>
<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">회원 가입!</h1>
                        </div>
                        <form name="frm" class="user" action="/board/signUp" method="post" enctype="multipart/form-data">
                            <div class="form-group">
	                            <input type="text" name="memId" id="memId" class="form-control form-control-user" id="exampleInputEmail" placeholder="아이디" style="width: 70%; float: left">
	                            <input type="button" id="idCheck" class="form-group row" value="중복 확인" style="float: right;">
	                            <br>
	                        </div>
	                        <br>
                            <div id="dispIdCheck"></div>
                            <div class="form-group">
                                <input type="text" name="memName" id="memName" class="form-control form-control-user" id="exampleInputEmail" placeholder="이름" />
                            </div>
                            <div class="form-group">
                                <input type="text" name="memJob" id="memJob" class="form-control form-control-user" id="exampleInputEmail" placeholder="직업" />
                            </div>
                            <div class="form-group">
                                <input type="text" name="memLike" id="memLike" class="form-control form-control-user" id="exampleInputEmail" placeholder="취미" />
                            </div>
                            <div class="form-group">
                                <input type="text" name="memHp" id="memHp" class="form-control form-control-user" id="exampleInputEmail" placeholder="연락처" />
                            </div>
                            <div class="form-group">
                                <div class="mb-3">
								  <label for="formFileMultiple" class="form-label">증명사진</label>
								  <input name="pictureArray" class="form-control" type="file" id="productImage" multiple>
								</div>
								<div class="imgs_wrap">
								
								</div>
                            </div>
                            <input type="button" id="signUp" onclick="checkAddMem()" class="btn btn-primary btn-user btn-block" value="회원 가입하기" disabled>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="login.html">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>