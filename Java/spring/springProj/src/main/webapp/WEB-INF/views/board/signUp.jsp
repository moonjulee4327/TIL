<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
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
				}else{
					$("#dispIdCheck").html("사용 가능한 아이디입니다.");
				}
			}
    	})
    	
//         frm.submit();
    });
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
                        <form name="frm" class="user" action="/board/signUp" method="post">
                            <div class="form-group">
	                            <input type="text" name="memId" id="memId" class="form-control form-control-user" id="exampleInputEmail" placeholder="아이디">
	                            <input type="button" id="idCheck" class="form-group row" value="중복 확인">
	                            <div id="dispIdCheck"></div>
	                        </div>
                            <div class="form-group">
                                <input type="text" name="memName" id="memName" class="form-control form-control-user" id="exampleInputEmail" placeholder="이름">
                            </div>
                            <div class="form-group">
                                <input type="text" name="memJob" id="memJob" class="form-control form-control-user" id="exampleInputEmail" placeholder="직업">
                            </div>
                            <div class="form-group">
                                <input type="text" name="memLike" id="memLike" class="form-control form-control-user" id="exampleInputEmail" placeholder="취미">
                            </div>
                            <div class="form-group">
                                <input type="text" name="memHp" id="memHp" class="form-control form-control-user" id="exampleInputEmail" placeholder="연락처">
                            </div>
                            <div class="form-group">
                                <input type="file" />
                            </div>
                            <a id="signUp" class="btn btn-primary btn-user btn-block">
                                	회원 가입하기
                            </a>
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