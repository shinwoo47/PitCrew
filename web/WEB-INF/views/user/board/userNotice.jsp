<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 공지사항</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/style.css" type="text/css">
    
<style>
	.hidden {
		display: none;
	}
	.centera {
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
	}
</style>
</head>
<body>
	<div id="preloder">
        <div class="loader"></div>
    </div>

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
            <img src="img/flag.png" alt="">
            <span>English</span>
            <i class="fa fa-angle-down"></i>
            <ul>
                <li><a href="#">English</a></li>
                <li><a href="#">Bangla</a></li>
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
                    </div>
                    <div class="col-lg-3">
                        <div class="header__top__language">
                            <c:if test="${ empty sessionScope.loginMember }">
                            <span><a href="${ pageContext.servletContext.contextPath }/member/login">로그인</span>
                            </c:if>
                            <c:if test="${ !empty sessionScope.loginMember }">
                            <h6><c:out value="${ sessionScope.loginMember.memName }"/>님 접속</h6>
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
                </div>
                <div class="col-lg-9">
                    <div class="header__nav">
                        <nav class="header__menu">
                            <ul>
                                <li><a href="${ pageContext.servletContext.contextPath }/user/clean/services">서비스</a></li>
                                <li><a href="#">고객지원센터</a>
                                    <ul class="dropdown">
                                        <li><a href="${ pageContext.servletContext.contextPath }/user/board/notice?category=공지">공지사항</a></li>
                                        <li><a href="./services-details.html">FAQ</a></li>
                                        <li><a href="./blog-details.html">문의사항</a></li>
                                    </ul>
                                </li>
                                <li><a href="./contact.html">MY</a>
                                    <ul class="dropdown">
                                        <li><a href="${ pageContext.servletContext.contextPath }/user/select/myRequest">의뢰내역</a></li>
                                        <li><a href="${ pageContext.servletContext.contextPath }/user/select/myInfo">정보수정</a></li>
                                        <li><a href="./blog-details.html">로그아웃</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                       
                        
                    </div>
                    
                </div>
            </div>
            <div class="canvas__open">
                <span class="fa fa-bars"></span>
            </div>
        </div>
    </header>
    
    
	<div class="centera">
	<div align="center" class="dashboard-wrapper">
         <div class="container-fluid dashboard-content">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/notice.png">
        
           <c:if test="${ category == 'PERSONAL' }">
            <button type="button" id="writeBoard">글쓰기</button>
            </c:if>
         <table id="boardList">
         	<tr>
         		<th class="hidden" width="100px">NO</th>
         		<th width="300px">제목</th>
   				<th width="100px">작성자</th>
   				<th width="100px">등록일</th>
   				<th>조회</th>
         	</tr>
         	<c:forEach items="${ requestScope.noticeList }" var="notice">
					<tr>
						<td class="hidden"><c:out value="${ notice.no }"/></td>
						<td><c:out value="${ notice.title }"/></td>
						<td><c:out value="${ notice.writer }"/></td>
						<td><c:out value="${ notice.writeDate }"/></td>
						<td><c:out value="${ notice.count }"/></td>
					</tr>
			</c:forEach>	
         	
         </table>         
         </div>
    </div>
    <script>	
    
    if(document.getElementsByTagName("td")) {
		
		const $tds = document.getElementsByTagName("td");
		for(let i = 0; i < $tds.length; i++) {
			
			$tds[i].onmouseenter = function() {
				this.parentNode.style.backgroundColor = "#00C1B6";
				this.parentNode.style.cursor = "pointer";
			}
			$tds[i].onmouseout = function() {
				this.parentNode.style.backgroundColor = "#fff";
			}
			$tds[i].onclick = function() {
				const no = this.parentNode.children[0].innerText;
				location.href = "${ pageContext.servletContext.contextPath }/user/notice/detail?no=" + no;
			}
			
		}
		
	}
	    
	    if(document.getElementById("writeBoard")) {
			const $writeNotice = document.getElementById("writeBoard");
			$writeNotice.onclick = function() {
				location.href = "${ pageContext.servletContext.contextPath }/user/notice/insert";
			}
		}
 
    </script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-3.3.1.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/bootstrap.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nice-select.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-ui.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nicescroll.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.magnific-popup.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.slicknav.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/owl.carousel.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/main.js"></script>
    </div>
    
    
    
</body>
</html>