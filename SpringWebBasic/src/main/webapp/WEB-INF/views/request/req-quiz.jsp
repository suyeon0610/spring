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
	 # ����
	 1. RequestController�� ���� ������ ȭ�鿡 �����ִ� �޼��� ����.
	 - url: /request/quiz: GET
	 - view: /request/req-quiz.jsp
	 - method name: quiz()
	 
	 2. RequestController�� ���۵� ���̵�, ��й�ȣ �Ķ���͸� �޾�
	  �α����� ó���ϴ� �޼��� ����
	 - url: /request/quiz: POST
	 - views:
	 	������: /request/login-success.jsp
	 	���н�: /request/login-fail.jsp
	 	- method name: quiz()
	 	
	 3. �α��� ���� ����
	 - id: abcd1234, pw: aaa1111	
	 --%>

	<form action="/basic/request/quiz" method="post">
		# ID: <input type="text" name="id"> 
		# PW: <input type="password" name="pw">
		<br>
		<input type="submit" value="�α���">
	</form>

</body>
</html>