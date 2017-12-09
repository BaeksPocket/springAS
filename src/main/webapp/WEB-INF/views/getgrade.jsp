<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>

<body>
<h3>1392065 이수 구분별 학점 조회</h3>
	<table>
		<tr>
			<c:forEach var="offer" items="${offers}">
				<td>${offer.division}</td>
			</c:forEach>
		</tr>


		<tr>
			<c:forEach var="offer" items="${offers}">
				<td>${offer.grades}</td>
			</c:forEach>
		</tr>

	</table>
</body>
</html>