<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<div class="card">
  <div class="card-body">
    <h4 class="card-title">글 쓰기</h4>
    <p class="card-description">자신이 말하고 싶은 글을 써보세요!</p>
    <form class="forms-sample" action="/board/writePost" method="post">
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
      <button type="submit" class="btn btn-primary mr-2"> Submit </button>
      <a href="/board/list" class="btn btn-light">Cancel</a>
    </form>
  </div>
</div>
</body>
</html>