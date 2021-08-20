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
      <form action="findPwd" class="form-signin" method="POST">
        <input type="text" name="memId" id="memId" class="form-control" placeholder="아이디" required><br>
        <input type="text" name="memName" id="memName" class="form-control" placeholder="이름" required><BR>
        <input type="email" name="email" id="email" class="form-control" placeholder="이메일" required><br>
        <p class="checks" id="checks">${findpw_checkf}</p><br/>
        <button id="findPwdBtn" class="btn btn-lg btn-primary btn-block" type="submit">비밀번호 찾기</button>
      </form>
		</div>
        <div class="links">
            <a href="${ pageContext.servletContext.contextPath }/member/findId">아이디 찾기</a> | <a href="${ pageContext.servletContext.contextPath }/member/login">로그인</a> | <a href="${ pageContext.servletContext.contextPath }/member/regist">회원가입</a>
        </div>
	</div>
</body>
  
  <script>

	
	  	//아이디 정규식
		var idJ = /^[a-z0-9]{8,20}$/;
		
  		$("#memId").focusout(function(){
	     if($('#member_id').val() == ""){
	   		$('#checks').text('아이디를 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
  		
  		$("#memName").focusout(function(){
	     if($('#name').val() == ""){
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
  		
//   		window.onoload = function() {
  			
//   			const $findMyPwdBtn = document.getElementById("findMyPwdBtn");
//   			$findMyPwdBtn.onclick = function() {
//   				location.href = "${ pageContext.servletContext.contextPath }/member/findPwd";
//   			}
//   		}
  
  </script>
</html>