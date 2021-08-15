<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Loanday Template">
    <meta name="keywords" content="Loanday, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Loanday | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/style.css" type="text/css">
	<script src="${ pageContext.servletContext.contextPath }/resources/user/js/event.js"></script>	
	<style>
		.btn_z {
			width: 120px;
			height: 40px;
			color: #fff;
			background: #004fff;
			font_size: 16px;
			positon: absolute;
			
}
	</style>

</head>

<body>
    <!-- Page Preloder -->
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
                        <a href="./index.html"><img src=" ${ pageContext.servletContext.contextPath }/resources/user/img/user/infor.png" alt="pit"></a>  
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="header__nav">
                        <nav class="header__menu">
                            <ul>
                                <li><a href="${ pageContext.servletContext.contextPath }/user/clean/services">서비스</a></li>
                                <li><a href="#">고객지원센터</a>
                                    <ul class="dropdown">
                                        <li><a href="./services.html">공지사항</a></li>
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
                        <div class="header__search">
                            <i class="fa fa-search search-switch"></i>
                        </div><div class= "reqs_rs" align="center"><br><br>
                        <h3 id="rses">준비  및  유의  사항</h3><br>
                        <h3>청소도구를준비해주세요.</h3><br>
                        <p>미 준비시 일부 서비스의 제한이 있을 수 있습니다. <br><br>
                      	  귀중품, 현금 은 안전한 곳에 보관해주세요. 관리 소홀로<br>
                       	  인한 분실 및 파손시 보상이 불가능해집니다.<br><br>
						반려동물이 있는 경우 안전장치를 해주세요.</p></div>
                        
                    </div>
                    
                </div>
            </div>
            <div class="canvas__open">
                <span class="fa fa-bars"></span>
            </div>
        </div>
    </header>
    <!-- Header Section End -->


    <!-- Services Section Begin -->
    <section class="services spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/user/img/user/roomClean.png" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>01.</span>방청소</h4>
                            <button id="popup" class="btn_z">자세히보기</button>
                         
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/user/img/user/bathroomClean.png" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>02.</span>화장실 청소</h4>
                             <button id="popup2" class="btn_z">자세히보기</button>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/user/img/user/allClean.png" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>03.</span>전체청소</h4>
                             <button id="popup3" class="btn_z">자세히보기</button>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/user/img/user/washDish.png" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>04.</span>설거지</h4>
                             <button id="popup4" class="btn_z">자세히보기</button>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/user/img/user/windowClean.png" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>05.</span>창틀청소</h4>
                             <button id="popup5" class="btn_z">자세히보기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Services End -->


    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->

    <!-- Js Plugins -->
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery-3.3.1.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/bootstrap.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.nice-select.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery-ui.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.nicescroll.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.magnific-popup.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.slicknav.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/owl.carousel.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/main.js"></script>
</body>

</html>