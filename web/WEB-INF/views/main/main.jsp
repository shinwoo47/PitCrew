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
    <section class="hero set-bg" data-setbg="${ pageContext.servletContext.contextPath }/resources/images/main/main1.PNG">
        
    </section>
    
    <section class="hero set-bg" data-setbg="${ pageContext.servletContext.contextPath }/resources/images/main/main2.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-5" style="margin-left: 400px;">
                    <div class="hero__text">
                    	<p>원하는 구역만 골라받는</p>
                        <h2>청소 서비스</h2>  
                        <a href="${ pageContext.servletContext.contextPath }/service" class="primary-btn1">더 알아보기</a>
                    </div>
                </div>
                
            </div>
        </div>
    </section>
    
    <section class="hero set-bg" data-setbg="${ pageContext.servletContext.contextPath }/resources/images/main/main3.PNG">
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="hero__text">
                        <h2>청소 해결사</h2>
                        <p>원하는 지역 선택하여 장소 선택!</p>
                        <a href="${ pageContext.servletContext.contextPath }/clean" class="primary-btn1">더 알아보기</a>
                    </div>
                </div>
                
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    

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