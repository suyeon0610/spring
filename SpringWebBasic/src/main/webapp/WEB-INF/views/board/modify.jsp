<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<form method="post">
		<h3>${bId}번 글 수정 하기</h3>
		#작성자 <input type="text" name="writer" value="${article.writer}"> <br>
		#제목 <input type="text" name="title" value="${article.title}"> <br>
		#내용 <br>
		<textarea rows="5" name="content" >${article.content}</textarea> <br>
		
		<input type="submit" value="확인">
	</form>
	
	
	

</body>
</html>