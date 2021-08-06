<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>${bId}번 글 상세 보기</h3>
	
	#작성자 <input type="text" value="${article.writer}" readonly="readonly"> <br>
	#제목 <input type="text" value="${article.title}" readonly="readonly"> <br>
	#내용 <br>
	<textarea rows="5" readonly="readonly">${article.content}</textarea> <br>
	
	<a href='<c:url value="/board/list" />'>글 목록</a>
	<a href='<c:url value="/board/modify?bId=${bId}" />'>글 수정</a>
	
</body>
</html>