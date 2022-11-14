<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="/resources/js/jquery-3.6.0.js"></script>
</head>
<body>
<div class="col grid-margin stretch-card" style="width: 700px">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title">Hoverable Table</h4>
      <p class="card-description"> Add class <code>.table-hover</code>
      </p>
      <div class="table-responsive">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>게시판 번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성 일자</th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach var="list" items="${list}" varStatus="stat">
	            <tr>
		              <td>${stat.count}</td>
		              <td><a href="javascript:detailForm(${list.writeNo})" onclick="detailForm()">${list.title}</a></td>
		              <td class="text-info">${list.writer}<i class="mdi mdi-arrow-up"></i>
		              </td>
		              <td>
		                <label class="badge badge-danger"><fmt:formatDate value="${list.writeDt}" pattern="yyyy-MM-dd"/></label>
		              </td>
	            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    <a href="/spa/write" class="btn btn-success"> 글 쓰기 </a>
    </div>
  </div>
	<div id="detailForm" class="card" style="width: 700px; display: none;">
	  <div class="card-body">
	    <h4 class="card-title">게시글 상세</h4>
	    <p class="card-description">게시판 글을 조회했습니다!</p>
	      <div class="form-group">
	        <label for="exampleInputName1">글 번호</label>
	        <input type="text" class="form-control" id="writeNo" name="writeNo" placeholder="글 번호">
	      </div>
	      <div class="form-group">
	        <label for="exampleInputName1">제목</label>
	        <input type="text" class="form-control" id="title" name="title" placeholder="제목">
	      </div>      
	      <div class="form-group">
	        <label for="exampleInputName1">작성자</label>
	        <input type="text" class="form-control" id="writer" name="writer" placeholder="작성자">
	      </div>      
	      <div class="form-group">
	        <label for="exampleTextarea1">내용</label>
	        <textarea class="form-control" id="content" name="content" rows="4"></textarea>
	      </div>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <br>
	      <div id="transForm">
		      <input type="button" onclick="updateForm()" class="btn btn-primary mr-2" value="Update" /> 
		      <input type="button" onclick="detailClose()" class="btn btn-light" value="Cancel" />
	      </div>
	      <div id="updateCfm" style="display: none;">
		      <input type="button" onclick="update()" class="btn btn-primary mr-2" value="confirm" /> 
		      <input type="button" onclick="detailClose()" class="btn btn-light" value="Cancel" />
	      </div>
	  </div>
	</div>
</div>
<script type="text/javascript">
function detailForm(writeNo) {
	$("#detailForm").css("display","block");
	
	console.log("writeNo : " + writeNo);
	
	$.ajax({
		url : "/spa/detail",
		type : "get",
		data : {writeNo:writeNo},
		dataType : "json",
		success : function(data) {
			console.log("data.content : " + data.content);
			$("#writeNo").val(data.writeNo);
			$("#title").val(data.title);
			$("#writer").val(data.writer);
			$("#content").val(data.content);
			
			$("input[class='form-control']").attr("readonly", true);
			$("#content").attr("readonly", true);
		}
	})
}

function detailClose() {
	$("#detailForm").css("display","none");
}

function updateForm() {
	$("input[class='form-control']").attr("readonly", false);
	$("#content").attr("readonly", false);
	
	$("#transForm").css("display","none");
	$("#updateCfm").css("display","block");
}

function update() {
	let writeNoVal = $("#writeNo").val();
	let titleVal = $("#title").val();
	let writerVal = $("#writer").val();
	let contentVal = $("#content").val();
	let dataVal = {
			writeNo : writeNoVal,
			title : titleVal,
			writer : writerVal,
			content : contentVal
	};
	console.log("dataVal.content : " + dataVal.content);
	$.ajax({
		url : "/spa/update",
		type : "post",
		contentType: "application/json; charset=UTF-8",
		data : JSON.stringify(dataVal),
		dataType : "json",
		success : function (result) {
			console.log("result : " + result);
// 			$.ajax({
// 				url : "/spa/",
// 				type : "get"
// 			})
		}
	});
}
</script>
</body>
</html>