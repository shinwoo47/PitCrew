<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>아이디 찾기</title>
    <style>
        @import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
	
	html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 200px;
  		padding-bottom: 40px;
  		font-family: "Nanum Gothic", arial, helvetica, sans-serif;
  		background-repeat: no-repeat;
  		background-color: #eee;
	}
	
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
	}

    #submitBtn{
        background-color: skyBlue;
        border: none;
    }
	
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
    .card-title{
        margin-left: 30px;
    }
	 .links{
        text-align: center;
        margin-bottom: 10px;
    }

    a{ 
    	color: #f58b34; text-decoration: none; 
    }
    .text2{
    	color : blue;
    }
    </style>
<title>Insert title here</title>
</head>
<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
	<h2 align="center">아이디 찾기</h2>
	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
		</div>
			<div class="card-body">
      		<form action="findId" class="form-signin" method="POST">
  		 		<p class="text2"> ${findid2}</p>
        		<input type="text" name="memName" id="memName" class="form-control" placeholder="이름" required autofocus><BR>
        		<input type="email" name="email" id="email" class="form-control" placeholder="이메일" required><br>
       			<p class="check" id="check">${check}</p><br/>
       			<button id="submitBtn" class="btn btn-lg btn-primary btn-block" type="submit">아이디 찾기</button>
     		</form>
     		&nbsp;
			<div class="links">
			<a href="${ pageContext.servletContext.contextPath }/member/login">로그인</a> | <a href="${ pageContext.servletContext.contextPath }/member/findPwd">비밀번호 찾기</a> | <a href="${ pageContext.servletContext.contextPath }/member/regist">회원가입</a>
			</div>	
		</div>
	</div>
</body>
</html>