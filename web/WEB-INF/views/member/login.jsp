<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Clean Home</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/login/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="${ pageContext.servletContext.contextPath }/resources/login/images/img-01.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" id="loginForm" action="${ pageContext.servletContext.contextPath }/member/login" method="post">
					<span class="login100-form-title">
						Member Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid id is required">
						<input class="input100" type="text" name="memberId" placeholder="id">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="memberPwd" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<input type="submit" class="login100-form-btn" value="로그인" id="login">
					</div>

					<div class="text-center p-t-12">
						<a class="txt2" href="${ pageContext.servletContext.contextPath }/member/findId" style="margin-right: 20px;">
							아이디찾기
						</a>
						<a class="txt2" href="${ pageContext.servletContext.contextPath }/member/findPwd">
							비밀번호찾기
						</a>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="${ pageContext.servletContext.contextPath }/member/regist">
							Create your Account
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
					
				</form>
			</div>
		</div>
	</div>
	
	
<!--===============================================================================================-->	
	<script src="${ pageContext.servletContext.contextPath }/resources/login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${ pageContext.servletContext.contextPath }/resources/login/vendor/bootstrap/js/popper.js"></script>
	<script src="${ pageContext.servletContext.contextPath }/resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${ pageContext.servletContext.contextPath }/resources/login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${ pageContext.servletContext.contextPath }/resources/login/vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="${ pageContext.servletContext.contextPath }/resources/login/js/main.js"></script>

</body>
</html>