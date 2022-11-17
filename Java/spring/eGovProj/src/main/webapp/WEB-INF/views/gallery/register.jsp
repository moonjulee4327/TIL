<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<script src="/resources/ckeditor/ckeditor.js"></script>
<section class="content">
	<div class="row">
		<div class="col-md-6">
			<div class="card card-primary">
				<div class="card-header">
					<h3 class="card-title">도서 정보</h3>
					<div class="card-tools">
						<button type="button" class="btn btn-tool"
							data-card-widget="collapse" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
					</div>
				</div>
				<div class="card-body" style="display: block;">
					<div class="form-group">
						<div style="clear: both;">
							<label for="inputName">제목</label>
						</div>
						<div style="width: 70%; float: left;"> 
							<input type="text" id="title" name="title" class="form-control"/>
						</div>
						<div style="width: 30%; float: right;">
							<button type="button" data-toggle="modal" data-target="#modal-lg" class="btn btn-outline-secondary btn-block btn-flat"><i class="fa fa-book"></i>책 검색</button>
						</div>
					</div>
					<div class="form-group">
						<label for="inputStatus">카테고리</label> 
						<select id="category" name="category" class="form-control custom-select">
							<option value="a0101" selected>소설</option>
							<option value="a0102">에쎄이</option>
							<option value="a0103">어린이</option>
							<option value="a0104">요리</option>
							<option value="a0105">수험서</option>
							<option value="a0106">자격증</option>
						</select>
					</div>
					<div class="form-group">
						<label for="price">가격</label> 
						<input type="text" id="price" name="price" class="form-control">
					</div>
					<div class="form-group">
						<label for="insertDate">등록일자</label> 
						<input type="text" id="insertDate" name="insertDate" class="form-control">
					</div>
					<div class="form-group">
						<label for="content">책 내용</label>
						<textarea id="content" name="content" class="form-control" rows="4"></textarea>
					</div>
				</div>

			</div>

		</div>
		<div class="col-md-6">
			<div class="card card-secondary">
				<div class="card-header">
					<h3 class="card-title">이미지 정보</h3>
					<div class="card-tools">
						<button type="button" class="btn btn-tool"
							data-card-widget="collapse" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
					</div>
				</div>
				<div class="card-body" style="display: block;">
					<div class="form-group">
						<label for="inputEstimatedBudget">Estimated budget</label> <input
							type="number" id="inputEstimatedBudget" class="form-control">
					</div>
					<div class="form-group">
						<label for="inputSpentBudget">Total amount spent</label> <input
							type="number" id="inputSpentBudget" class="form-control">
					</div>
					<div class="form-group">
						<label for="inputEstimatedDuration">Estimated project
							duration</label> <input type="number" id="inputEstimatedDuration"
							class="form-control">
					</div>
				</div>

			</div>

		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<a href="#" class="btn btn-secondary">취소</a> 
			<input type="submit" value="이미지 등록 완료" class="btn btn-success float-right">
		</div>
	</div>
</section>

<!-- modal-lg 시작 -->
<div class="modal fade show" id="modal-lg"
	style="padding-right: 17px; display: none;" aria-modal="true"
	role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">책 검색</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- 검색 영역 시작 -->
				<div class="row">
					<div class="col-md-8 offset-md-2">
						<form action="simple-results.html">
							<div class="input-group">
								<input type="search" id="searchVal" class="form-control form-control-lg"
									placeholder="Type your keywords here">
								<div class="input-group-append">
									<button type="submit" id ="searchBtn" class="btn btn-lg btn-default">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- 검색 영역 끝 -->
				<!-- 결과 영역 시작 -->
				<div class="row mt-3">
					<div class="col-md-10 offset-md-1">
						<div class="list-group">
						</div>
					</div>
				</div>
				<!-- 결과 영역 끝-->
			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>
<!-- modal-lg 끝 -->

<script type="text/javascript">
CKEDITOR.replace("content");
let dtResult = "";
$(function() {
	$("#searchBtn").on("click", function(event) {
		event.preventDefault();
		let searchVal = $("#searchVal").val();
// 		alert(searchVal);
		
		let data = {"title":searchVal};
		
		$.ajax({
			url : "/gallery/registPost",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			type : "post",
			dataType : "json",
			success : function(result) {
				console.log("result : " + JSON.stringify(result[0].title));
				
				let content = "";
				
				$.each(result, function(index, item) {
					console.log("bookId : " + item.bookId);
					console.log("title : " + item.title);
					let dt = new Date(item.insertDate);
					let dtYY = dt.getFullYear();
					let dtMM = dt.getMonth();
					let dtDD = dt.getDate();
					let dtHH = dt.getHours();
					let dtMI = dt.getMinutes();
					dtResult = dtYY + "-" + dtMM + "-" + dtDD + " " + dtHH + ":" + dtMI;
					
					// 내용이 길어서 50자로 해보자
					let cont = item.content + "...";
					let filename = "/noimage.jpg";
					if(item.attachVOList.length > 0){
						$.each(item.attachVOList,function (index, item) {
							filename = item.filename;
						});
					}

					console.log("item : ", item);
					
				    content += "<div class='list-group-item' onclick='clickVal("+JSON.stringify(item)+")'><div class='row'><div class='col-auto'>";
	                content += "<img class='img-fluid' src='/resources/upload"+ filename +"' alt='Photo' style='max-height: 160px;'></div>";						
	                content += "<div class='col px-4'><div>";
	                content += "<div class='float-right'>"+dtResult+"</div>";
	                content += "<h3 id='chVal'>"+item.title+"</h3>";
	                content += "<p class='mb-0'>"+cont.substring(0,50)+"</p>";
	                content += "</div></div></div></div>";
	               
	                $(".list-group").append(content);   

				});
			}
		});
	});
	
});

function clickVal(item) {
// 	alert($("#chVal").html());
// 	opener.$("#title").val() = $("#chVal").html();
	// $(parent.document).find("#title").val($("#chVal").html());
	// console.log("item : ", item.title);
	$("#title").val(item.title);
	$("#price").val(item.price);
	$("#insertDate").val(dtResult);
	$("#content").val(item.content);
	CKEDITOR.instances.content.setData(item.content);
}

</script>