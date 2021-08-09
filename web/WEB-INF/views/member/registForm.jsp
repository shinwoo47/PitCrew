<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
  height: 34px;
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

</style>
<body>


<!------ Include the above in your HEAD tag ---------->

<div class="container">
            <form class="form-horizontal" role="form" form id="joinForm" action="${ pageContext.servletContext.contextPath }/member/regist" method="post">
                <h2>Registration Form</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">Full Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="firstName" name="memberName" placeholder="Full Name" class="form-control" autofocus>
                    </div>
                </div>
                 <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Id</label>
                    <div class="col-sm-9">
                        <input type="text" maxlength="13" name="memberId" id="memberId" required class="form-control2">
                        <input type="button" value="중복확인" class="btn btn-or" id="duplicationCheck">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" name="memberPwd" placeholder="Password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <input type="email" id="email" name="email" placeholder="Email" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">Date of Birth</label>
                    <div class="col-sm-9">
                        <input type="date" id="birthDate" name="birth" class="form-control">
                    </div>
                </div>
               <div class="form-group">
                    <label for="phone" class="col-sm-3 control-label">핸드폰번호</label>
                    <div class="col-sm-9">
                        <input type="tel" id="phone" name="phone" placeholder="phone number" class="form-control">
                    </div>
                </div>
                 <div class="form-group">
                    <label class="control-label col-sm-3">우편번호</label>
                    <div class="col-sm-9">  
                       <input type="text" name="zipCode" id="zipCode" readonly class="form-control2">
                       <input type="button" value="검색" class="btn btn-yg" id="searchZipCode">
                    </div>
                </div>
                 <div class="form-group">
                    <label class="control-label col-sm-3">주소</label>
                    <div class="col-sm-9">  
                       <input type="text" name="address1" id="address1" readonly  class="form-control">
                    </div>
                </div>
                 <div class="form-group">
                    <label class="control-label col-sm-3">상세주소</label>
                    <div class="col-sm-9">  
                       <input type="text" name="address2" id="address2"  class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3">회원 종류 선택</label>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-8">
                                <label class="radio-inline">
                                    <input type="radio" id="userRadio" name="role" value="사용자">일반 사용자
                                </label>
                            </div>
                            <div class="col-sm-8">
                                <label class="radio-inline">
                                    <input type="radio" id="cleanerRadio" name="role" value="해결사">청소 도우미
                                </label>
                            </div>
                            
                        </div>
                    </div>
                </div> 
               
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">I accept <a href="#">terms</a>
                            </label>
                        </div>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		const $searchZipCode = document.getElementById("searchZipCode");
		const $goMain = document.getElementById("goMain");
		
		$searchZipCode.onclick = function() {
		
			//다음 우편번호 검색 창을 오픈하면서 동작할 콜백 메소드를 포함한 객체를 매개변수로 전달한다.
			new daum.Postcode({
				oncomplete: function(data){
					//팝업에서 검색결과 항목을 클릭했을 시 실행할 코드를 작성하는 부분
					document.getElementById("zipCode").value = data.zonecode;
					document.getElementById("address1").value = data.address;
					document.getElementById("address2").focus();
				}
			}).open();
		}
		
		$goMain.onclick = function() {
			location.href = "${ pageContext.servletContext.contextPath }";
		}
	</script>
</body>
</html>