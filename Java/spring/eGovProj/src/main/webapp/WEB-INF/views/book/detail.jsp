<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/resources/AdminLTE/plugins/jquery/jquery.min.js"></script>
<script src="/resources/ckeditor/ckeditor.js"></script>

<div class="card card-danger">
	<div class="card-header">
		<h3 class="card-title">도서 상세 정보</h3>
	</div>
	<div class="card-body">
		<form action="/book/update" method="post" id="frm" name="frm">
			<div class="form-group" id="bookIdDisp">
				<label>도서 아이디</label>
				<div class="input-group">
					<input type="text" id="bookId" name="bookId" class="form-control" value="${data.bookId}" readonly="readonly"/>
				</div>
			</div>
			
			<div class="form-group">
				<label>도서 명</label>
				<div class="input-group">
					<input type="text" id="title" name="title" class="form-control" value="${data.title}" readonly="readonly"/>
				</div>
			</div>
			
			<div class="form-group">
				<label>도서 분류</label>
				<div class="input-group">
					<input type="text" id="category" name="category" class="form-control" value="${data.category}" readonly="readonly"/>
				</div>
			</div>
			
			<div class="form-group">
				<label>판매 금액</label>
				<div class="input-group">
					<input type="text" id="price" name="price" class="form-control" value='<fmt:formatNumber pattern="#,###" value="${data.price}"/>' readonly="readonly"/>
				</div>
			</div>

			<div class="form-group">
				<label>내용</label>
				<div class="input-group">
					<textarea id="content" name="content" readonly="readonly">${data.content}</textarea>
				</div>
			</div>
			
			<div class="form-group">
				<label>입력 일자</label>
				<div class="input-group">
					<input type="text" id="insertDate" name="insertDate" class="form-control" value="${date}" readonly="readonly"/>
				</div>
			</div>
			
		</form>
	</div>
	<!-- 일반모드 시작 -->
	<div id="detailForm" class="card-footer">
		<div style="float: right; margin: 0 10px 0 0;">
			<a href="/book/list" id="goList" class="btn btn-block bg-gradient-info btn-sm" style="width: 100px; float: right;" onclick="goList()">목록</a>
		</div>
		<div style="float: right;">
			<button id="goUpdate" class="btn btn-block bg-gradient-primary btn-sm" style="width: 100px; float: right;" onclick="goUpdateForm()">수정</button>
		</div>
	</div>
	<!-- 일반모드 시작 -->
	<!-- 수정모드 시작 -->
	<div id="updateForm" class="card-footer" style="display: none;">
		<div style="float: right; margin: 0 10px 0 0;">
			<a href="/book/detail?bookId=${data.bookId}" class="btn btn-block bg-gradient-danger btn-sm" style="width: 100px; float: right;">취소</a>
		</div>
		<div style="float: right;">
			<button id="goUpdate" class="btn btn-block bg-gradient-primary btn-sm" style="width: 100px; float: right;" onclick="update()">확인</button>
		</div>
	</div>
	<!-- 수정모드 시작 -->
</div>

<script type="text/javascript">
	function goUpdateForm() {
		$("#bookIdDisp").css("display","none");
		$("#title").removeAttr("readonly");
		$("#category").removeAttr("readonly");
		$("#price").removeAttr("readonly");
		$("#content").removeAttr("readonly");
		
		$("#title").attr("required", true);
		$("#category").attr("required", true);
		$("#price").attr("required", true);
		$("#content").attr("required", true);
		
		CKEDITOR.instances['content'].setReadOnly(false);
		
		$("#detailForm").css("display","none");
		$("#updateForm").css("display","block");
	}
	
// 	function updateClose() {
// 		$("#updateForm").css("display","none");
// 		$("#detailForm").css("display","block");
		
// 		$("#bookId").attr("readonly","readonly");
// 		$("#title").attr("readonly","readonly");
// 		$("#category").attr("readonly","readonly");
// 		$("#price").attr("readonly","readonly");
// 	}
	
	$("#price").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/g,""));	
	});
	
	function update() {
		$("#frm").submit();
	}
	
	CKEDITOR.replace("content");
</script>
