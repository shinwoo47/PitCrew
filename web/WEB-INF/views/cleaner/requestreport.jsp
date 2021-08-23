<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>\
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Loanday Template">
    <meta name="keywords" content="Loanday, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <title>Loanday | Template</title>

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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  	
  	<style>
	.blog__details__text {
	margin-bottom: 65px;
	border: 1px solid black;
	padding: 10px 10px 10px 10px;
	}
	.requestReq {
	margin-bottom: 20px;
	}
  	</style>
</head>

<body>
    
    <!-- 네비 -->
	<jsp:include page="../cleaner/cleanermenubar.jsp"/>

    

    <!-- Blog Details Section Begin -->
    <section class="blog-details spad">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="blog__details__title">
                        <div class="container">
                        <form action="${ pageContext.servletContext.contextPath }/cleaner/request/report" method="post" onsubmit="return check()" encType="multipart/form-data">
							  <h2 style="padding-bottom:100px;">신고 작성</h2>      
							  <table class="table table-hover">
							    <tbody>
							      <tr>
							        <td>신고 사유</td>
							        <td>
							        	<select style="padding:5px;" id="reportCategory" name="reportCategory">
											<option value="1">폭언 폭행</option>
											<option value="2">과도한 서비스 요구</option>
											<option value="3">서비스 범위초과</option>
											<option value="4">기타</option>
										</select>
									</td>
							      </tr>
							      <tr>
							        <td>첨부파일</td>
							        <td>
							        	<input type="hidden" name="reqNo" id="reqNo" value="${ reqNo }"/>
										<input type="file" name="report" multiple><br>
                        			</td>
							      </tr>
							      <tr>
							        <td>상세 내용</td>
							       	<td colspan="3">
										<textarea id="body" name="body" cols="60" rows="15" style="resize:none;"></textarea>
									</td>
							      </tr>
							    </tbody>
							    	<td><button type="reset">취소하기</button></td>
							      	<td><button type="submit">신고하기</button></td>
							  </table>
							  </form>
							</div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Section End -->

    <jsp:include page="../cleaner/footer.jsp"/>

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
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-3.3.1.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/bootstrap.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nice-select.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-ui.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nicescroll.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.magnific-popup.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.slicknav.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/owl.carousel.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/main.js"></script>
     <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=572342b1ef19fad40c1a5ac213542717&libraries=services"></script>
     <script>
     
     function check() {
  	      if($("#body")[0].value == ""){
  		        alert("내용을 입력해 주세요");
  		        $("#body").focus();
  		        return false;
  	      }
  	      return true;
     }
     window.onload = function() {

		
		$("#report").on("click", function(){ 
			const no = $("#reqNo").val();
			console.log(no)
			location.href = "${ pageContext.servletContext.contextPath }/cleaner/request/report?no=" + no;

		});
     }

    </script>
</body>

</html>