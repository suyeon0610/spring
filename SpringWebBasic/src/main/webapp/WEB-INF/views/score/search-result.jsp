<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>${stu.stuName}의 점수</h2>
	<p>
		#국어: ${stu.kor}
		#영어: ${stu.eng}
		#수학: ${stu.math}
		#총점: ${stu.total}
		#평균: ${stu.average}
	</p>
	

</body>
</html>