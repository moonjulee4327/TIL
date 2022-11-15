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
						data-title="${list.title}"> 
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
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="body-content"></p>
			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
<!-- 				<button type="button" class="btn btn-primary">Save changes</button> -->
			</div>
		</div>
	</div>
</div>
<!-- default modal 끝 -->
<script type="text/javascript">
$(function () {
	// data-id=...
	$(".btn-modal").click(function() {
		let data = $(this).data("id");
		let title = $(this).data("title");
		console.log("data : " + data);
		console.log("title : " + title);
		
		$("#body-content").html("<img src='" + data + "' style='width:100%;' />");
		$(".modal-title").html(title);
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
</script>