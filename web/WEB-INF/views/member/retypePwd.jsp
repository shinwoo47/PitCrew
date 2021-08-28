<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Clean Home</title>
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
	 
	    .card-title {
	        margin-left: 30px;
	    }
	
	    a { 
	    	color: #f58b34; text-decoration: none; 
	    }
	
	    .links {
	        text-align: center;
	        margin-bottom: 10px;
	    }
	    
	    .checks {
	    	color : red;
	    }
	</style>
</head>
 <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
 	
 	<!-- 비밀번호 변경 폼 -->
	<h2 align="center">비밀번호 변경</h2>
	<div class="card align-middle" style="width:25rem;">
	    <div class="card-title" style="margin-top:30px;">
		</div>
		<div class="card-body">
      <form action="${ pageContext.servletContext.contextPath }/member/update/password" class="form-signin" method="POST" onsubmit="return check()">
      	<input type="text" name="memId" id="memId" class="form-control" placeholder="아이디 입력" required><br>
        <input type="password" name="certificationNum" id="certificationNum" class="form-control" placeholder="인증번호 입력" required><br>
        <input type="password" name="memberPwd" id="memberPwd" class="form-control" placeholder="새 비밀번호" required><BR>
        <input type="password" name="checkPwd" id="checkPwd" class="form-control" placeholder="새 비밀번호 확인" required><br>
        <p class="checks" id="checks">${findpw_checkf}</p><br/>
        <button id="findPwdBtn" class="btn btn-lg btn-primary btn-block">비밀번호 변경</button>
      </form>
		</div>
        <div class="links">
            <a href="${ pageContext.servletContext.contextPath }/member/findId">아이디 찾기</a> | <a href="${ pageContext.servletContext.contextPath }/member/login">로그인</a> | <a href="${ pageContext.servletContext.contextPath }/member/regist">회원가입</a>
        </div>
	</div>
	
	<!-- 비밀번호 업데이트 폼 끝 -->
	
</body>
  
  <script>

	function check() {
		
		/* 아이디 정규식 */
		var idJ = /^[a-z0-9]{8,20}$/;
		
		/* 비밀번호 정규식 */
		var getPwd = RegExp(/\w{8,15}$/)
		
		$("#memId").focusout(function() {
			
		     if($('#memId').val() == "") {
		    	$('#checks').text('아이디를 입력해주세요.');
		   	  	$('#checks').css('color', 'red');
		     }
		 });
		  
		/* 비밀번호 유효성 검사 */
		if(!getPwd.test($("#pwd").val())) {

			alert("형식에 맞게 입력해주세요");
			$("#pwd").val("");
			$("#pwd").focus();
			return false;
	      }
  			
		/* 바꿀 비밀번호와 재입력한 비밀번호가 맞는 지 비교 */	
		if($("#memberPwd").val() != ($("#checkPwd").val())) {
			
			alert("비밀번호가 틀렸습니다.");
			$("#pwd").val("");
		    $("#checkPwd").val("");
			$("#memberPwd").focus();
			return false;
		}
			
		return true;
	
	}
  
  </script>
</html>

