<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style>

table.type09 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;

}
table.type09 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;
}
table.type09 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: skyblue;
}
table.type09 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
.section {
	padding: 100px;
}

div.button {
	text-align: center;
	margin: auto;
	width: 50%;
}

</style> 
	<meta charset="UTF-8">
    <meta name="description" content="Loanday Template">
    <meta name="keywords" content="Loanday, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Loanday | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&display=swap" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
 	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/slicknav.min.css" type="text/css"> 
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/style.css" type="text/css"> 
    
</head>
<body>
	<!-- 네비 -->
	<jsp:include page="../cleaner/cleanermenubar.jsp"/>

	<section class="section">
	<article class="article">
	<h2 align="center">회원 정보</h2>
	<table class="type09" align="center">
	
        <c:forEach items="${ selectMyInfo }" var="myInfo">
        <tbody>
            <tr>
                <th scope="row">이름</th>
                <td><c:out value="${ myInfo.memName }"/></td>
            <tr>
                <th scope="row">아이디</th>
                <td><c:out value="${ myInfo.id }"/></td>
            </tr>
            <tr>
                <th scope="row">이메일</th>
                <td><c:out value="${ myInfo.email }"/></td>
            </tr>
            <tr>
                <th scope="row">전화번호</th>
                <td><c:out value="${ myInfo.phone }"/></td>
            </tr>
            <tr>
                <th scope="row">주소</th>
                <td><c:out value="${ fn:replace(myInfo.address, \"$\" , \" \") }"/></td>
            </tr>
            <tr>
          </tbody>
          </c:forEach>
       </table>
       </article>
     </section>
            <div class="button">
<%--             	<button onclick="location.href=${ pageContext.servletContext.contextPath}/user/select/update/myInfo">수정하기</button> --%>
            	<input type="button" class="btn1" value="정보수정" id="selectUpdate">
            	<input type="button" class="btn2" value="회원탈퇴" id="delete">
<%--             	<button onclick="location.href=${ pageContext.servletContext.contextPath}/user/delete/myInfo">삭제하기</button> --%>
            </div>
		
</body>

<script>
	window.onload = function() {
	
		if(document.getElementById("selectUpdate")) {
			const $selectUpdate = document.getElementById("selectUpdate");
			$selectUpdate.onclick = function() {
				location.href = "/pitcrew/cleaner/member/update";
			}
		}
	}
</script>
</html>