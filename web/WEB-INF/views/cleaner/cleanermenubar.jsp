<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Google Font -->
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
<title>Insert title here</title>
<style>
	.header__nav {
	padding: 20px; 0px;
	}
</style>
</head>
<body>
	
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="${ pageContext.servletContext.contextPath }/main"><img src="${ pageContext.servletContext.contextPath }/resources/images/main/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="header__nav">
                        <nav class="header__menu">
                            <ul>
                                <li><a href="${ pageContext.servletContext.contextPath }/cleaner/home">Home</a></li>
                                <li><a href="${ pageContext.servletContext.contextPath }/cleaner/request/enroll">청소 서비스</a></li>
                                <li><a href="${ pageContext.servletContext.contextPath }/cleaner/request/manage">일정 관리</a></li>
                               
                                <li><a href="#">MyPage</a>
                                    <ul class="dropdown">
                                        <li><a href="${ pageContext.servletContext.contextPath }/cleaner/member/select">회원정보</a></li>
                                        <li><a href="${ pageContext.servletContext.contextPath }/cleaner/account">계좌</a></li>
                                        <li><a href="${ pageContext.servletContext.contextPath }/cleaner/calculate">정산내역</a></li>
                                    </ul>
                                </li>
                                 <li><a href="#">고객센터</a>
                                    <ul class="dropdown">
                                        <li><a href="${ pageContext.servletContext.contextPath }/cleaner/notice/list?category=공지 ">공지사항</a></li>
                                        <li><a href="${ pageContext.servletContext.contextPath }/cleaner/notice/list?category=FAQ">FAQ</a></li>
                                        <li><a href="${ pageContext.servletContext.contextPath }/cleaner/notice/list?category=PERSONAL">문의사항</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
						<div class="header__search">
                            <c:if test="${ empty sessionScope.loginMember }">
                            <span><a href="${ pageContext.servletContext.contextPath }/member/login">로그인</span>
                            </c:if>
                            <c:if test="${ !empty sessionScope.loginMember }">
                            <h6><c:out value="${ sessionScope.loginMember.memName }"/>님 접속</h3>
                            <span><a href="${ pageContext.servletContext.contextPath }/member/logout">로그아웃</span>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </header>
    <!-- Header Section End -->
</body>
</html>
