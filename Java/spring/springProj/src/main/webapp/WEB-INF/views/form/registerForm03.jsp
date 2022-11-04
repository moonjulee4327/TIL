<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/ckeditor/ckeditor.js"></script>
<title>Spring Form</title>
<script type="text/javascript">
   window.onload=function(){
      
   		CKEDITOR.replace("introduction");
   }
</script>
</head>
<body>
   <!--
    modelAttribute 속성에 폼 객체의 속성명을 지정함 
    태그라이브러리를 입력하게되면 modelAttribute  속성 사용가능
    -->
    <!-- 폼 객체의 속성 명과 스프링 폼 태그의 modelAttribute 속성값은 
    컨트롤러에  model.attribute("name",value ) <-- name값과 일치해야함 
    -->
    <form:form modelAttribute="examMemberVO111111" method="post" action="/form/register">
       <table>
          <tr>
             <td><form:label path="memId">유저 ID</form:label></td>
             <td>
             <!-- <input type="text" name="memId" id="memId"와 동일하다 -->
                <form:hidden path="memId" />*****
                <font color="red"><form:errors path="memId" /></font> 
             </td>
          </tr>
          <tr>
             <td><form:label path="memName" >이름</form:label></td>
             <td>
                <form:input path="memName" />
                <font color="red"><form:errors path="memName" /></font> 
             </td>
          </tr>
          <tr>
             <td><form:label path="password" >비밀번호</form:label></td>
             <td>
                <form:password path="password" />
                <font color="red"><form:errors path="password" /></font> 
             </td>
          </tr>
          <tr>
             <td>자기소개</td>
             <td>
                <form:textarea path="introduction" row="6" cols="30" />
             </td>
          </tr>
          <tr>
             <td>취미(hobbyList)</td>
             <td>
                <form:checkboxes path="hobbyList" items="${hobbyMap}" />
             </td>
          </tr>
          <tr>
             <td>개발자 여부</td>
             <td>
             <!-- value가 Y이면 체크를 하면 Y이지만 체크하지 않으면 null이 들어간다. -->
                <form:checkbox path="developer" value="Y" />
             </td>
          </tr>
          <tr>
             <td>외국인 여부</td>
             <td>
             <!-- value가 false이면 체크하면 true이고 체크하지 않으면 false이다. -->
                <form:checkbox path="foreigner" value="false" />
             </td>
          </tr>
<!--           <tr> -->
<!--              <td>성별</td> -->
<!--              <td> -->
<%--                 <form:radiobuttons path="gender" items="${genderMap}" /> --%>
<!--              </td> -->
<!--           </tr> -->
          <tr>
             <td>성별</td>
             <td>
                <form:radiobutton path="gender" value="Male" label="Male" />
                <form:radiobutton path="gender" value="Female" label="Female" />
                <form:radiobutton path="gender" value="Other" label="Other" />
             </td>
          </tr>
<!--           <tr> -->
<!--              <td>국적</td> -->
<!--              <td> -->
<%--                 <form:select path="nationality" items="${nationalityMap}" /> --%>
<!--              </td> -->
<!--           </tr> -->
          <tr>
             <td>국적</td>
             <td>
             	<select id="nationality" name="nationality">
             		<option value="Korea">Korea</option>
             		<option value="Germany">Germany</option>
             		<option value="Australia">Australia</option>             		
             	</select>
             </td>
          </tr>
       </table>
       <form:button name="register">등록</form:button>
    
    </form:form>

</body>
</html>