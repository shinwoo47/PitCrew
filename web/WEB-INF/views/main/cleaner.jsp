<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Loanday Template">
    <meta name="keywords" content="Loanday, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Clean Home</title>

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
</head>

<body>
   
	<!-- 네비 -->
	<jsp:include page="../common/menubar.jsp"/>
    <!-- Hero Section Begin -->
    <section class="hero set-bg" data-setbg="${ pageContext.servletContext.contextPath }/resources/images/main/cleaner2.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="hero__text">
                        <h2>청소 해결사</h2>
                        <p>내 일정에 맞춰 일자리를 신청하세요</p>
                        <a href="${ pageContext.servletContext.contextPath }/cleaner/home" class="primary-btn1">지원하기</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Home About Begin -->
    <section class="home-about spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="home__about__text">
                        <div class="section-title">
                            <h2>교육 무료 지원</h2>
                            <p>첫 날, 서비스 교육을 무료로 진행합니다. 자세한 사항은 문의해주세요 </p>
                        </div>
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <div class="home__about__item">
                                    <h4>직접 선택하는 일정,지역</h4>
                                    <p>원하는 곳, 원하는 날을 직접 선택하세요</p>
                                </div>
                            </div>
                           
                        </div>
                    </div>
                </div>
                <div class="col-lg-5 offset-lg-1">
                    <div class="home__about__img">
                        <img src="${ pageContext.servletContext.contextPath }/resources/images/main/cleaner1.PNG" alt="">
                    </div>
                </div>
                <div class="about__content">
                <div class="row">
                    <div class="col-lg-5">
                        <div class="about__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/images/main/cleaner3.PNG"" alt="">
                            <a href="https://www.youtube.com/watch?v=RpvAmG1NNN0"
                                class="play-btn video-popup"><img src="img/about/video-play.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6 offset-lg-1">
                        <div class="about__text">
                            <h2>모집 과정</h2>
                            <ol>
                            	<li>온라인 지원</li>
                            	<li>꼼꼼한 검증</li>
                            	<li>자세한 교육</li>
                            	<li>청소 해결사 시작</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </section>
    <!-- Home About End -->

    
    <!-- Footer Section Begin -->
	<footer class="footer">
        <div class="row" style="float: right;">
			<h6 style="color: darkgrey;">맡겨줘 홈즈</h6>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-3.3.1.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/bootstrap.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nice-select.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-ui.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nicescroll.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.magnific-popup.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.slicknav.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/owl.carousel.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/main.js"></script>
</body>

</html>