<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>req-ex01.jsp 입니다~~</h1>
	<p> 오늘은 목요일 입니당</p>
	
	<form action="/basic/request/basic01">
		<input type="submit" value="GET요창!">
	</form>
	
	<form action="/basic/request/basic01" method="post">
		<input type="submit" value="POST요창!">
	</form>
</body>
</html>