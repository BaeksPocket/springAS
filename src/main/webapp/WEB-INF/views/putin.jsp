<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<h3>수강 신청 내역</h3>
	<table>
		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>코드</td>
			<td>과목</td>
			<td>분반</td>
			<td>학점</td>
		</tr>

		<c:forEach var="offer" items="${offers}">
			<tr>
				<td>${offer.year}</td>
				<td>${offer.semester}</td>
				<td>${offer.code }</td>
				<td>${offer.subject }</td>
				<td>${offer.division}</td>
				<td>${offer.grades}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>