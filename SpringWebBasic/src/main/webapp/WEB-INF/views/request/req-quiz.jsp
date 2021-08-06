<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%--
	 # 문제
	 1. RequestController에 현재 파일을 화면에 열어주는 메서드 선언.
	 - url: /request/quiz: GET
	 - view: /request/req-quiz.jsp
	 - method name: quiz()
	 
	 2. RequestController에 전송된 아이디, 비밀번호 파라미터를 받아
	  로그인을 처리하는 메서드 선언
	 - url: /request/quiz: POST
	 - views:
	 	성공시: /request/login-success.jsp
	 	실패시: /request/login-fail.jsp
	 	- method name: quiz()
	 	
	 3. 로그인 성공 조건
	 - id: abcd1234, pw: aaa1111	
	 --%>

	<form action="/basic/request/quiz" method="post">
		# ID: <input type="text" name="id"> 
		# PW: <input type="password" name="pw">
		<br>
		<input type="submit" value="로그인">
	</form>

</body>
</html>