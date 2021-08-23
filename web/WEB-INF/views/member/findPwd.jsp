<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>비밀번호 찾기</title>
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

    #findPwdBtn{
        background-color: skyblue;
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


    a{ 
    	color: #f58b34; text-decoration: none; 
    }

    .links{
        text-align: center;
        margin-bottom: 10px;
    }
    
    .checks{
    	color : red;
    }
    </style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
	<h2 align="center">비밀번호 찾기</h2>
	<div class="card align-middle" style="width:25rem;">
	    <div class="card-title" style="margin-top:30px;">
		</div>
		<div class="card-body">
      <form action="findPwd" class="form-signin" method="POST" onsubmit="return check()">
        <input type="text" name="memId" id="memId" class="form-control" placeholder="아이디" required><br>
        <input type="text" name="memName" id="memName" class="form-control" placeholder="이름" required><BR>
        <input type="email" name="email" id="email" class="form-control" placeholder="이메일" required><br>
        <p class="checks" id="checks">${findpw_checkf}</p><br/>
        <button id="findPwdBtn" class="btn btn-lg btn-primary btn-block">인증번호 발급</button>
      </form>
		</div>
        <div class="links">
          <a href="${ pageContext.servletContext.contextPath }/member/login">로그인</a> | <a href="${ pageContext.servletContext.contextPath }/member/findId">아이디 찾기</a> | <a href="${ pageContext.servletContext.contextPath }/member/regist">회원가입</a>
        </div>
	</div>
</body>
  
  <script>

	function check() {

		//아이디 정규식
		var idJ = /^[a-z0-9]{8,20}$/;
		//아이디 유효성 검사
		var getCheck= RegExp(/^[a-zA-Z0-9]{4,15}$/);
		//이름 유효성 검사
	    var getName = RegExp(/^[가-힣]+$/);
		//이메일 정규식
		var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
		
  		$("#memId").focusout(function(){
	    if($('#memId').val() == ""){
	   		$('#checks').text('아이디를 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
  		
  		$("#memName").focusout(function(){
	    if($('#memName').val() == ""){
	   		$('#checks').text('이름을 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     }
	    });
	     
  		$("#email").focusout(function(){
	    if($('#email').val() == ""){
	   		$('#checks').text('이메일을 입력해주세요');
	   	  	$('#checks').css('color', 'red');
	     }
	    });
  		
  		if(!getName.test($("#memName").val())) {
	        alert("이름이 올바르지 않습니다");
	        $("#memName").val("");
	        $("#memName").focus();
	        return false;
	    }
  		
  		if(!getCheck.test($("#memId").val())){
	        alert("형식에 맞게 입력해주세요");
	        $("#memId").val("");
	        $("#memId").focus();
	        return false;
     	}
		
  		if(!getMail.test($("#email").val())){
	        alert("이메일형식에 맞게 입력해주세요")
	        $("#email").val("");
	        $("#email").focus();
	        return false;
	    }
		
  		return true;
	}	
  		
  
  </script>
</html>