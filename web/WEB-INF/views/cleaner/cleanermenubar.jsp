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
</head>
<body>
	<!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__search">
            <i class="fa fa-search search-switch"></i>
        </div>
        <div class="offcanvas__logo">
            <a href="./index.html"><img src="img/logo.png" alt=""></a>
        </div>
        <nav class="offcanvas__menu mobile-menu">
            <ul>
                <li class="active"><a href="./index.html">Home</a></li>
                <li><a href="./about.html">About</a></li>
                <li><a href="./services.html">Services</a></li>
                <li><a href="./blog.html">Blog</a></li>
                <li><a href="#">Pages</a>
                    <ul class="dropdown">
                        <li><a href="./services.html">Features</a></li>
                        <li><a href="./services-details.html">Services Details</a></li>
                        <li><a href="./blog-details.html">Blog Details</a></li>
                    </ul>
                </li>
                <li><a href="./contact.html">Contact</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <ul class="offcanvas__widget">
            <li><i class="fa fa-map-marker"></i> 96 Ernser Vista Suite 437, NY, US</li>
            <li><i class="fa fa-phone"></i> (123) 456-78-910</li>
            <li><i class="fa fa-envelope"></i> Info@colorlib.com</li>
           
        </ul>
        <div class="offcanvas__language">
            <ul>
                <li><a href="./member/registForm.jsp">Login</a></li>
            </ul>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-9">
                        <ul class="header__top__widget">
                            <li><i class="fa fa-map-marker"></i> 96 Ernser Vista Suite 437, NY, US</li>
                            <li><i class="fa fa-phone"></i> (123) 456-78-910</li>
                            <li><i class="fa fa-envelope"></i> Info@colorlib.com</li>
                        </ul>
                    </div>
                    
                    <div class="col-lg-3">
                        <div class="header__top__language">
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
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./index.html"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="header__nav">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="./index.html">Home</a></li>
                                <li><a href="${ pageContext.servletContext.contextPath }/cleaner/request/enroll">청소 서비스</a></li>
                                <li><a href="./services.html">일정 관리</a></li>
                                <li><a href="./blog.html">Blog</a></li>
                                <li><a href="#">MyPage</a>
                                    <ul class="dropdown">
                                        <li><a href="./services.html">회원정보</a></li>
                                        <li><a href="./services-details.html">계좌</a></li>
                                        <li><a href="./blog-details.html">정산내역</a></li>
                                    </ul>
                                </li>
                                 <li><a href="#">고객센터</a>
                                    <ul class="dropdown">
                                        <li><a href="./services.html">공지사항</a></li>
                                        <li><a href="./services-details.html">FAQ</a></li>
                                        <li><a href="./blog-details.html">문의사항</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                        <div class="header__search">
                            <i class="fa fa-search search-switch"></i>
                        </div>
                    </div>
                </div>
            </div>
            <div class="canvas__open">
                <span class="fa fa-bars"></span>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
</body>
</html>
