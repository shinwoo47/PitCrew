<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>\
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="description" content="Loanday Template">
    <meta name="keywords" content="Loanday, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&display=swap" rel="stylesheet">
    

    <!-- Css Styles -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/slicknav.min.css" type="text/css"> 
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/style.css" type="text/css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
body {
    background-color: #eee;
}

*[role="form"] {
    max-width: 530px;
    padding: 15px;
    margin: 0 auto;
    background-color: #fff;
    border-radius: 0.3em;
}

*[role="form"] h2 {
    margin-left: 5em;
    margin-bottom: 1em;
}
.form-control2 {
  width: 60%;
  height: 26px;
  padding: 6px 12px;
  font-size: 14px;
  line-height: 1.42857143;
  color: #555;
  background-color: #fff;
  background-image: none;
  border: 1px solid #ccc;
  border-radius: 4px;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
          box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
  -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
       -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
          transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
}
	.account{
		align="center";
	}
	.btn-account{
		align="center";
	}

</style>
<body>

	<!-- 네비 -->
	<jsp:include page="../cleaner/cleanermenubar.jsp"/>

<!------ Include the above in your HEAD tag ---------->

	<div class="container">
            <form class="form-horizontal" role="form" id="joinForm" onsubmit="return check()" action="${ pageContext.servletContext.contextPath }/cleaner/account/regist" method="post">
                <h2>계좌 등록</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">예금주</label>
                    <div class="col-sm-9">
                        <input type="text" id="accountHolder" name="accountHolder" placeholder="예금주명" class="form-control" autofocus>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">은행</label>
                    <div class="col-sm-9">
                        <input type="text" id="bank" name="bank" placeholder="예시) 신한은행" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">계좌번호</label>
                    <div class="col-sm-9">
                        <input type="text" id="accountNumber" name="accountNumber" placeholder="예시) 000-111111111" class="form-control">
                    </div>
                </div>
                               
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">등록하기</button>
                    </div>
                </div>
            </form> <!-- /form -->
	        <form id="authorizeFrm" class="form-horizontal" name="authorizeFrm" method="get" action="https://testapi.openbanking.or.kr/oauth/2.0/authorize" target="_authForm">
	    		<input type="hidden" name="client_id" value="2df87e25-3e96-43b2-86dd-8d75acce5208"/>
	    		<input type="hidden" name="scope" value="login inquiry transfer"/>
	    		<input type="hidden" name="redirect_uri" value="http://127.0.0.1:8020/pitcrew/cleaner/account/authorize"/>
	    		<input type="hidden" name="auth_type" value="0"/>
	    		<input type="hidden" name="response_type" value="code"/>
	    		<input type="hidden" name="state" value="12345678901234567890123456789012"/>
	    		<div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <!-- <button type="submit" class="btn btn-primary">계좌 인증</button> -->
                    </div>
                </div>
			</form>
        </div> <!-- ./container -->
        <jsp:include page="../cleaner/footer.jsp"/>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-3.3.1.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/bootstrap.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nice-select.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-ui.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nicescroll.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.magnific-popup.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.slicknav.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/owl.carousel.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/main.js"></script>
	<script>
	 $('#authorizeFrm').click(function(){
         window.open('', '_authForm');
     })
     
      $('#test').click(function(){
         location.href = "${ pageContext.servletContext.contextPath }/cleaner/account/test";
     })
     
     
     


	 function check() {
  	      if($("#accountHolder")[0].value == ""){
  		        alert("예금주명을 입력해 주세요");
  		        $("#accountHolder").focus();
  		        return false;
  	      }
  	      
  	      if($("#bank")[0].value == ""){
		        alert("은행을 입력해 주세요");
		        $("#bank").focus();
		        return false;
	      }
	      
	      if($("#accountNumber")[0].value == ""){
		        alert("계좌번호를 입력해 주세요");
		        $("#accountNumber").focus();
		        return false;
	      }
	      return true;
     }
	


	</script>
</body>
</html>