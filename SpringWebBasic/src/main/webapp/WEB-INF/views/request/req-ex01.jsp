<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>req-ex01.jsp �Դϴ�~~</h1>
	<p> ������ ����� �Դϴ�</p>
	
	<form action="/basic/request/basic01">
		<input type="submit" value="GET��â!">
	</form>
	
	<form action="/basic/request/basic01" method="post">
		<input type="submit" value="POST��â!">
	</form>
</body>
</html>