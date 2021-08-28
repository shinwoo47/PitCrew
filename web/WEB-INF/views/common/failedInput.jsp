<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function(){
			const failedCode = "${ requestScope.failedCode }";
			
			let failedMessage = "";
			let movePath = "";
			
			switch(failedCode) {
				case "failedInput" : 
					movePath = "${ pageContext.servletContext.contextPath }/member/findPwd";
					failedMessage = "정보를 다시 입력해주세요!";
					break;
		}

		alert(failedMessage);
		
		location.replace(movePath);
	})();
		
	</script>
</body>
</html>