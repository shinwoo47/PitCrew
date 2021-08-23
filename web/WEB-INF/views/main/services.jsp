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
    <title>맡겨줘 홈즈</title>

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
    <section class="hero set-bg" data-setbg="${ pageContext.servletContext.contextPath }/resources/images/main/service1.PNG">
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="hero__text">
                        <h2>간단하고 편리한 </h2>
                        <h2>청소 서비스</h2>
                        <p>필요한 청소만 골라서 신청</p>
                        <a href="${ pageContext.servletContext.contextPath }/user/home" class="primary-btn1">시작하기</a>
                    </div>
                </div>
                
            </div>
        </div>
    </section>

    <!-- Services Section Begin -->
    <section class="services spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/images/main/service2.PNG" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>01.</span>방청소</h4>
                            <p>침구류 및 의류 정리정돈</p>
                            <p>막대걸레 이용한 바닥 청소</p>
                            <p>쇼파 및 침대 밑 청소</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/images/main/service3.PNG" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>02.</span>화장실</h4>
                            <p>세면대, 거울 세척</p>
                            <p>변기, 욕조 세척</p>
                            <p>수납장 및 욕실 용품 정리</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/images/main/service4.PNG" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>03.</span>전체청소</h4>
                            <p>방청소와 화장실청소</p>
                            <p>설거지와 창틀은 덤</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/images/main/service5.PNG" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>04.</span>설거지</h4>
                            <p>조리 도구와 식기 청소</p>
                            <p>싱크대청소와 마무리</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/images/main/service6.PNG" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>05.</span>창틀청소</h4>
                            <p>창문 틀에 쌓인 이물질 청소</p>
                        </div>
                    </div>
                </div>
               
            </div>
        </div>
    </section>
    <!-- Services End -->
    <!-- Contact End -->

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