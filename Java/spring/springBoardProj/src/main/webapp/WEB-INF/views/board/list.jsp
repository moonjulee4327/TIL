<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<div class="col grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title">Hoverable Table</h4>
      <p class="card-description"> Add class <code>.table-hover</code>
      </p>
      <div class="table-responsive">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>글 번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성 일자</th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach var="list" items="${list}">
            <tr>
              <td>${list.writeNo}</td>
              <td>${list.title}</td>
              <td class="text-info">${list.writer}<i class="mdi mdi-arrow-up"></i>
              </td>
              <td>
                <label class="badge badge-danger">${list.writeDt}</label>
              </td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    <a href="/board/write" class="btn btn-success"> 글 쓰기 </a>
    </div>
  </div>
</div>
</body>
</html>