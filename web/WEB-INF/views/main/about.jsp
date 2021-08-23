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
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
    <!-- 네비 -->
	<jsp:include page="../common/menubar.jsp"/>

    

    <!-- About Section Begin -->
    <section class="about spad">
        <div class="container">
            <div class="about__content">
                <div class="row">
                    <div class="col-lg-5">
                        <div class="about__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/images/main/abount1.PNG"" alt="">
                            <a href="https://www.youtube.com/watch?v=RpvAmG1NNN0"
                                class="play-btn video-popup"><img src="img/about/video-play.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6 offset-lg-1">
                        <div class="about__text">
                            <h2>What We Do!</h2>
                            <h4>바쁜 1, 2인 가구 자취생을 위해 </h4>
                            <h4>부분 청소 서비스를  제공합니다.</h4>
                        </div>
                    </div>
                </div>
            </div>
             <div class="about__text">
                 <h2>When!</h2>
            
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="about__item">
                        <img src="${ pageContext.servletContext.contextPath }/resources/images/main/about2.PNG"" alt="">
                    </div>
                </div>
                 <div class="col-lg-4 col-md-4">
                    <div class="about__item">
                        <img src="${ pageContext.servletContext.contextPath }/resources/images/main/about3.PNG"" alt="">
                    </div>
                </div> <div class="col-lg-4 col-md-4">
                    <div class="about__item">
                        <img src="${ pageContext.servletContext.contextPath }/resources/images/main/about4.PNG"" alt="">
                    </div>
                </div>
            </div>
            <h4>바쁠 때 딱 누가 이 부분만 청소해 줬으면 한다면!</h4>
            <h4>어디서 부터 청소해야 할지 감이 안잡힌다면!</h4><h4 style="color: red;">맡겨줘 홈즈 가 해결해 드립니다</h4>
            </div>
        </div>
    </section>
    <!-- About End -->

    <!-- Footer Section Begin -->
    <footer class="footer">
        <div class="row" style="float: right;">
			<h6 style="color: darkgrey;">맡겨줘 홈즈</h6>
        </div>
    </footer>
    <!-- Footer Section End -->

 

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>