<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Loanday Template">
    <meta name="keywords" content="Loanday, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery-3.3.1.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/bootstrap.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.nice-select.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery-ui.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.nicescroll.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.magnific-popup.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.slicknav.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/owl.carousel.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/main.js"></script>
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
  
   
    .section {
       width : 1000px;
        margin-right: auto;
        margin-left: auto;
       padding-top: 100px;
       
    }
   
 table.type05 {
  border-collapse: separate;
  border-spacing: 1px;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  margin: auto;
}
table.type05 th {
  width: 300px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #efefef;
}
table.type05 td {
  width: 1080px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
}
.pay {
    width: 100px;
    height: 100px;;
    margin: auto;

}
.btn-ya {
	width: 200px;
	 	height: 50px;
	 	background-color : red;
	 	font-size : 28px;
	 	color : white;
}
.btn-yb {
	width: 200px;
	 	height: 50px;
	 	background-color : blue;
	 	font-size : 28px;
	 	color : white;
}    
</style>
</head>

<body>

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-9">
                    </div>
                    <div class="col-lg-3">
                        <div class="header__top__language">
                            <img src="" alt="">
                            <span></span>
                            <i class="fa fa-angle-down"></i>
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
                                <li class="active"><a href="${ pageContext.servletContext.contextPath }/user/clean/services">서비스</a></li>
                                <li><a href="#">고객지원센터</a>
                                    <ul class="dropdown">
                                        <li><a href="./services.html">공지사항</a></li>
                                        <li><a href="./services-details.html">FAQ</a></li>
                                        <li><a href="./blog-details.html">문의사항</a></li>
                                    </ul>
                                </li>
                                <li><a href="./contact.html">MY</a>
                                    <ul class="dropdown">
                                        <li><a href="./services.html">공지사항</a></li>
                                        <li><a href="./services-details.html">FAQ</a></li>
                                        <li><a href="./blog-details.html">문의사항</a></li>
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
    <!-- Header Section End -->
    
    <!-- Section Section Start -->
   <body>
   <div class="section">
   <input type="button" class="btn-ya" value="주문결제" id="abc_ax">
   <input type="button" class="btn-yb" value="안내사항 보기" id="information">
      <h2 ><br>구매자 정보</h2> 
           <table class="type05" >
               <tr>
                    <th scope="row" >이름</th>
                    <td><c:out value="${ clean.time }"/></td>
               </tr>
               <tr>
                    <th scope="row">이메일</th>
                    <td>내용이 들어갑니다.</td>
               </tr>
               <tr>
                    <th scope="row">휴대폰 번호</th>
                    <td>내용이 들어갑니다.</td>
               </tr>
         </table>
         
       
   <div class="article"></div>
      <h2>결제정보</h2>
         <table class="type05">
            <tr>
                    <th scope="row">시작일</th>
                    <td>내용이 들어갑니다.</td>
               </tr>
                <tr>
                    <th scope="row">장소</th>
                    <td>내용이 들어갑니다.</td>
               </tr>
                <tr>
                    <th scope="row">가격</th>
                    <td>내용이 들어갑니다.</td>
            </tr>
            </table>
      </div>
</html>