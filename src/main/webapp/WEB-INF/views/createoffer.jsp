<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<h3>수강 신청 하기</h3>
	<sf:form method="post"	action="${ pageContext.request.contextPath}/docreate" modelAttribute="offer">
		<table class = "formtable">
			<tr> <td class ="label">Year :</td> <td> <sf:input class="control" type="text" path="year" /><br/>
				<sf:errors path="year" class="error"/>
			</td>  </tr>
			<tr> <td class ="label">Semester :</td> <td> <sf:input class="control" type="text" path="semester"/><br/>
				<sf:errors path="semester" class="error"/>
			 </td>  </tr>
			<tr> <td class ="label">Code :</td> <td> <sf:input class="control" type="text" path="code"/> </td>  </tr>
			<tr> <td class ="label">Subject :</td> <td> <sf:input class="control" type="text" path="subject"/> </td>  </tr>
			<tr> <td class ="label">Division :</td> <td> <sf:input class="control" type="text" path="division"/> </td>  </tr>
			<tr> <td class ="label">Grade :</td> <td> <sf:input class="control" type="text" path="grades"/> </td>  </tr>
			<tr> <td class ="label"></td> <td> <input class="control" type="submit" value="신청"> </td>  </tr>
		</table>
	</sf:form>
</body>
</html>