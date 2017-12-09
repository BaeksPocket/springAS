<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head> 
<body>
	<p> <a href = "${pageContext.request.contextPath }/offers">
	학기 별 이수학점 조회</a>
	<p> <a href = "${pageContext.request.contextPath }/getgrade">
	이수 구분별 학점 조회</a>
	<p> <a href = "${pageContext.request.contextPath }/createoffer">
	수강 신청하기</a>
	<p> <a href = "${pageContext.request.contextPath }/putin">
	수강 신청 조회</a>
</body>
</html>