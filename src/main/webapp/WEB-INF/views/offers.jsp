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

	<%-- <c:forEach var="offer" items="${offers}">
		<p>
			<c:out value="${offer}"></c:out>
		</p>
	</c:forEach> --%>
	<table>
		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>이수 학점</td>
			<td>상세보기</td>
		</tr>

		<c:forEach var="offer" items="${offers}">
			<tr>
				<td>${offer.year}</td>
				<td>${offer.semester}</td>
				<td>${offer.grades }</td>
				<td><a href = "${pageContext.request.contextPath}/showlist?year=${ offer.year}&semester=${ offer.semester}">링크</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>