<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<style>
	.btn-yq {
	 	width: 200px;
	 	height: 50px;
	 	background-color : blue;
	 	font-size : 28px;
	 	color : white;
	}
	.checa {
		font-size : 30px;d
	}
	.checb {
		width: 25px;
	 	height: 25px;
	}
	.names {
		float: center;
	}
	.nss {
		width: 800px;
	 	height: 1700px;
	    margin-right: auto;
        margin-left: auto;
        background: rgb(186, 237, 255);
        font-size : 20px;
	}
	.line {
         width: 800px;
         border: 1px solid rgba(0, 0, 0, 0.466);
         margin-right: auto;
         margin-left: auto;
     }
    .btn_requ {
	 	 width: 220px;
	 	 height: 70px;
	 	 background-color : red;
	 	 font-size : 33px;
	 	 color : white;
	
	}
	.imgq {
		 width: 600px;
	 	 height: 400px;
	}
	</style>
</head>

<body>
  
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
    
    <section class="services spad">
        <div class="container">
            <div class="row">
         
	
               <!-- <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="services__item">
                        <div class="services__item__img">
                            <img src="${ pageContext.servletContext.contextPath }/resources/user/img/user/roomClean.png" alt="">
                        </div>
                        <div class="services__item__text">
                            <h4><span>01.</span>방청소</h4>
                            <div class="button">
                            <input type="button" class="btn-yq" value="선택" id="cleana">
                            </div>
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
                            <div class="button">
                            <input type="button" class="btn-yq" value="선택" id="cleanb">
                            </div>
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
                            <div class="button">
                            <input type="button" class="btn-yq" value="선택" id="cleanc">
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </div>	 -->
				<script>
					var time = ${ clean.time }; 
					var price = ${ clean.price };
				</script>
        		<div class= "nss"><br><br><div align="center">
        		<img src="${ pageContext.servletContext.contextPath }/resources/user/img/user/${clean.imgNo }" alt="" class= "imgq">
        		</div><br>
       			<h1 align = "center"><c:out value="${ clean.name }"/></h1>
       			<h4 align = "right">가격 : <c:out value="${ clean.price }"/>&nbsp;원</h4><br>
        		<div class="line"></div>
        		<form align = "center" action="${ pageContext.servletContext.contextPath }/user/clean/payment" method="post">
        		<br><br>
        		<c:if test="${ clean.cleanNo < 3 }">
        		
        	    <input type="checkbox" name="optionNo1" value="4" id="clea" class="checb">
      			<label for="baseball" class="checa">설거지&nbsp;&nbsp;5000원</label>
   				<br>
        		<input type="checkbox" name="optionNo2" value="5" id="cleb" class="checb" >
     		    <label for="football" class="checa">창틀&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5000원</label>
				</c:if>
     		    <br><br>
     		    <label>시작일 &nbsp; </label><input type="date" name="start"><br><br>
        		<label>시작시간 &nbsp; </label><input type="time" name="startTime" value="startTime">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br>
        		<textarea name="content" id="content" cols="60" rows="15" ></textarea><br><br>
        		<h4 align = "left" id="timea" >예상소요시간 : <c:out value="${ clean.time }"/>시간</h4><br>
        	    <h4 align = "left" id=pricea>예상금액 : &nbsp;<c:out value="${ clean.price }"/>원</h4>
      			
      			<input type="hidden"  name="cleanNo" value= "${ clean.cleanNo }"/>
      			<input type="hidden"  name="CleanPrice" value= "${ clean.price }"/>
      		
      			<button type="submit" class="btn_requ" value="주문하기" id="payment">주문하기</button>
        		</form>
        		
        		
        		
        		<script>
        		$(document).ready(function(){
        			$('#clea').change(function(){ 
        			      if($('#clea').is(":checked")){ 
        			    	  time += 0.5;
        			    	  price += 5000;
        			    	  console.log(time)
        			          $("#timea").html("예상소요시간 : " + time + "시간")
        			          $("#pricea").html("예상금액 : " + price + "원")
        			      }else{
        			    	  time += - 0.5;
        			    	  price -= 5000;
        			    	  $("#timea").html("예상소요시간 : " + time + "시간")
        			    	  $("#pricea").html("예상금액 : " + price + "원")
        			      }
        			   });
        			});	
        		
        		$(document).ready(function(){
        			$('#cleb').change(function(){ 
        			      if($('#cleb').is(":checked")){ 
        			    	  time +=  0.5;
        			    	  price += 5000;
        			    	  console.log(time)
        			          $("#timea").html("예상소요시간 : " + time + "시간")
        			          $("#pricea").html("예상금액 : " + price + "원")
        			      }else{
        			    	  time += - 0.5;
        			    	  price -= 5000;
        			    	  $("#timea").html("예상소요시간 : " + time + "시간")
        			    	  $("#pricea").html("예상금액 : " + price + "원")
        			      }
        			   });
        			});	
        		</script>
        		
        		
        		
       			
        
        

  
    <!-- Services End -->


    <!-- Search Begin -->
    
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