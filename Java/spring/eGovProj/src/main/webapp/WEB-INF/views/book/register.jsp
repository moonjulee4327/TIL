<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="/resources/AdminLTE/plugins/jquery/jquery.min.js"></script>
<script src="/resources/ckeditor/ckeditor.js"></script>
<!-- <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script> -->
<div class="card card-danger">
	<div class="card-header">
		<h3 class="card-title">도서 등록</h3>
	</div>
	<div class="card-body">
		<form action="/book/registerPost" method="post" id="frm" name="frm">
			
			<div class="form-group">
				<label>도서 명</label>
				<div class="input-group">
					<input type="text" id="title" name="title" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label>도서 분류</label>
				<div class="input-group">
					<input type="text" id="category" name="category" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label>판매 금액</label>
				<div class="input-group">
					<input type="text" id="price" name="price" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label>내용</label>
				<div class="input-group" id="editor">
					<textarea id="content" name="content" class="form-control" rows="4"></textarea>
				</div>
			</div>
			
		</form>
	</div>
	<div style="float: right;">
		<button id="registerBook" class="btn btn-block bg-gradient-primary btn-sm" style="width: 100px; float: right;" onclick="registerBook()">등록</button>
	</div>
</div>

<script type="text/javascript">
function registerBook() {
	$("#frm").submit();
}

// replace에 name을 주면 사용가능
CKEDITOR.replace("content");
// ClassicEditor.create( document.querySelector( '#editor' ) );
</script>