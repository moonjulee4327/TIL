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
					<input type="text" name="bookId" id="bookId" />
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
							<input type="text" id="title" name="title" class="form-control" readonly="readonly"/>
						</div>
						<div style="width: 30%; float: right;">
							<button type="button" data-toggle="modal" data-target="#modal-lg" class="btn btn-outline-secondary btn-block btn-flat"><i class="fa fa-book"></i>책 검색</button>
						</div>
					</div>
					<div class="form-group">
						<label for="inputStatus">카테고리</label> 
						<select id="category" name="category" class="form-control custom-select" disabled="disabled">
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
						<input type="text" id="price" name="price" class="form-control" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="insertDate">등록일자</label> 
						<input type="text" id="insertDate" name="insertDate" class="form-control" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="content">책 내용</label>
						<textarea id="content" name="content" class="form-control" rows="4" readonly="readonly"></textarea>
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
				<!-- 미리보기 이미지 보이기 시작 -->
				<div id="card-images" class="card-body" style="display: block;">
				
				</div>
				<!-- 미리보기 이미지 보이기 끝 -->
				<div class="card-footer">
					<div class="input-group">
						<div class="custom-file">
							<input type="file" name="uploadFile" class="custom-file-input"
								id="input_imgs" multiple="multiple" disabled="disabled" > <label
								class="custom-file-label" for="exampleInputFile">Choose
								file</label>
						</div>
						<div class="input-group-append">
							<span class="input-group-text" id="uploadBtn" style="cursor: pointer;">Upload</span>
						</div>
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
						<div class="input-group">
							<input type="text" id="searchVal" class="form-control form-control-lg"
								placeholder="Type your keywords here">
							<div class="input-group-append">
								<button type="button" id ="searchBtn" class="btn btn-lg btn-default">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
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
			<div class="modal-footer"> <!-- justify-content-between -->
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- modal-lg 끝 -->

<script type="text/javascript">
CKEDITOR.replace("content");
let dtResult = "";
$(function() {
	// 이미지 미리보기 시작
	// 이미지 객체를 담을 배열
	let sel_file = [];
	$("#input_imgs").on("change",handleImgFileSelect);
	
	// e : onchange 이벤트 객체
	function handleImgFileSelect(e) {
		// e.target : <input type="file"
		let files = e.target.files;
		// 이미지 오브젝트 배열
		let fileArr = Array.prototype.slice.call(files);
		
		// f : 각각의 이미지 파일
		fileArr.forEach(function(f) {
			if(!f.type.match("image.*")){
				alert("이미지 확장자만 가능합니다.");
				// 함수 종료
				return;
			}
			// 이미지를 배열에 넣음
			sel_file.push(f);
			
			let reader = new FileReader();
			// e : 리더가 이미지 읽을 때 그 이벤트
			reader.onload = function(e) {
				let img_html = "<img src=\"" + e.target.result + "\" style='width: 50%' />";
				$("#card-images").append(img_html);
			}
			// 다음 이미지 파일(f)을 위해 리더를 초기화
			reader.readAsDataURL(f);
		});
	}
	// 이미지 미리보기 끝
	
	// ajax 파일 업로드 시작
	$("#uploadBtn").on("click", function() {
		// 가상 폼
		let formData = new FormData();
		let inputFile = $("input[name='uploadFile']");
		// 이미지 파일들을 변수에 담음
		let files = inputFile[0].files;
		
		console.log("files : ", files);
		
		for(let i=0; i<files.length; i++){
			// uploadFile[]
			formData.append("uploadFile", files[i]);
		}
		
		// /upload/uploadAjaxAction
		// ATTACH 테이블 user_no 컬럼의 데이터에는 bookId가 들어가야 함
		let bookId = $("#bookId").val();
		console.log("bookId : " , bookId);
		
		formData.append("bookId", bookId);
		
		let header = "${_csrf.headerName}";
		let token = "${_csrf.token}";
		
		// ATTACH 테이블의 seq 컬럼의 데이터는 1부터 1씩 자동증가
		$.ajax({
			url : "/gallery/uploadAjaxAction",
			processData : false,
			contentType : false,
			data : formData,
			dataType : "json",
			type : "post",
			beforeSend : function(xhr) {
				xhr.setRequestHeader(header,token);
			},
			success : function(result) {
				console.log("result : ", JSON.stringify(result));
				
				if(result.status > 0){ // 다중 insert 성공
				     var Toast = Swal.mixin({
				       toast: true,
				       position: 'top-end',
				       showConfirmButton: false,
				       timer: 3000
				     });
					
					Toast.fire({
					      icon: 'success',
					      title: '이미지 등록을 성공했습니다!'
				    });
// 					location.href = "/gallery/list?bookId=" + result.bookId;
				}else{
					alert("실패");
				}
			}
		});
		
		
	});
	// ajax 파일 업로드 끝
		
	$("#searchBtn").on("click", function(event) {
		event.preventDefault();
		let searchVal = $("#searchVal").val();
// 		alert(searchVal);
		
		let data = {"title":searchVal};
		
		// 스프링 시큐리티를 위한 토큰 처리(csrf)
		let header = "${_csrf.headerName}";
		let token = "${_csrf.token}";
		
		console.log("header : ", header , "token : ", token);
		
		$.ajax({
			url : "/gallery/registPost",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			type : "post",
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader(header,token);
			},
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
	console.log("item.category : ", item.category);
// 	console.log("$('#category option').val() : ", $("#category options").val());
// 	$(선택자).is(':selected')
	$("#bookId").val(item.bookId);
	$("#title").val(item.title);
	$("#category").val(item.category).prop("selected", true);
	$("#price").val(item.price);
	$("#insertDate").val(dtResult);
	$("#content").val(item.content);
	CKEDITOR.instances.content.setData(item.content);
	
	$("#modal-lg").modal("hide"); // hide : 모달창 닫음 , show : 모달창 보임
	
	$("#input_imgs").attr("disabled",false);
	return;
}



// $(function() {
//     var Toast = Swal.mixin({
//       toast: true,
//       position: 'top-end',
//       showConfirmButton: false,
//       timer: 3000
//     });

// $('.swalDefaultSuccess').click(function() {
//     Toast.fire({
//       icon: 'success',
//       title: '성공'
//     })
//   });
// });
</script>