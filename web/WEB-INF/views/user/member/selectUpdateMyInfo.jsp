<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clean Home</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>

body {
	background-color: #ddd;
}

table.type09 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;

}
table.type09 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;
}
table.type09 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: skyblue;
}
table.type09 td {
    width: 430px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
.section {
	padding: 100px;
}

.updateButton {
	text-align: center;
	margin: auto;
	width: 50%;
}
</style> 
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
</head>
<body>

	<jsp:include page="../userMenubar.jsp"/>
	
	<section class="section">
	<h2 align="center">정보 수정</h2>
	<br><br><br><br>
	<form name="updateInfo" action="${ pageContext.servletContext.contextPath }/user/member/selectUpdate/myInfo" method="post" onsubmit="return check()">
	<table class="type09" align="center">
        <c:forEach items="${ selectUpdateMyInfo }" var="selectUpdateMyInfo">
        <tbody>        
            <tr>
                <th scope="row">이름</th>
                <td><c:out value="${ selectUpdateMyInfo.memName }"/></td>
            </tr>
            <tr>
                <th scope="row">아이디</th>
                <td><c:out value="${ selectUpdateMyInfo.id }"/></td>
            </tr>
            <tr>
                <th rowspan="3" scope="row">비밀번호 변경</th>
            </tr>
            <tr>
                <td><input type="password" name="memberPwd" id="memberPwd" placeholder="새비밀번호"></td>
            </tr>
            <tr>
                <td><input type="password" name="checkPwd" id="checkPwd" placeholder="비밀번호 다시 입력"></td>
            </tr>
            <tr>
                <th rowspan="5"  scope="row">집주소</th>
                <td><c:out value="${ fn:replace(selectUpdateMyInfo.address, \"$\" , \" \") }"/></td>
            </tr>
            <tr>
                <td><label>변경할 주소 </label></td>
            </tr>
            <tr>
            	<td><label>우편번호 </label>  <input type="text" name="zipCode" id="zipCode" readonly class="form-control2">
                <input type="button" value="검색" class="btn btn-yg" id="searchZipCode">
                </td>
            </tr>
            <tr>
            	<td><label>주소 </label>  <input type="text" name="address1" id="address1" readonly  class="form-control"></td>            
            <tr>
            	<td><label>상세주소 </label> <input type="text" name="address2" id="address2"  class="form-control">
            	
            <tr>
                <th rowspan="3" scope="row">이메일변경</th>
                <td>이메일 <c:out value="${ selectUpdateMyInfo.email }"/></td>
            </tr>
            <tr>
                <td><label>변경할 이메일 </label> <input type="text" id="udpateEmail" name="updateEmail"></td>
            </tr>
          </tbody>
          </c:forEach>
       </table>
       	<br>
       	<div class="updateButton"><button id="updateMyInfo">수정하기</button></div>
       </form>
     </section>
       
       
	
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		const $searchZipCode = document.getElementById("searchZipCode");
		
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
	</script>
	 
	<script>
		
	function check() {
		//비밀번호 정규식
		var getPwd = RegExp(/\w{8,15}$/)
		//이메일 정규식
		var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
		
		//비밀번호 형식 검사
	    if(!getPwd.test($("#memberPwd").val())){
	        alert("형식에 맞게 입력해주세요");
	        $("#memberPwd").val("");
	        $("#memberPwd").focus();
	        return false;
	    }
        		
		//비밀번호 비교
		if($("#memberPwd").val() != ($("#checkPwd").val())) {
			alert("비밀번호가 틀렸습니다.");
			$("#memberPwd").val("");
		    $("#checkPwd").val("");
			$("#memberPwd").focus();
			return false;
		}
		
	    //이메일 유효성 검사
	    if(!getMail.test($("#udpateEmail").val())){
	        alert("이메일형식에 맞게 입력해주세요")
	        $("#udpateEmail").val("");
	        $("#udpateEmail").focus();
	        return false;
	     }
	    
	    //주소 공백 확인
	     if($("#zipCode").val() == ""){
		        alert("주소를 입력해 주세요");
		        $("#zipCode").focus();
		        return false;
	     }
	    
		return true;
	}

	</script>
		
</body>
</html>