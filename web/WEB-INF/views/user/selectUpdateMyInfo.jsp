<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${ pageContext.servletContext.contextPath }/resources/user/js/event.js"></script>
<title>Insert title here</title>
<style>

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
    width: 350px;
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
                            <c:if test="${ empty sessionScope.loginMember }">
                            <span><a href="${ pageContext.servletContext.contextPath }/member/login"></a>로그인</span>
                            </c:if>
                            <c:if test="${ !empty sessionScope.loginMember }">
                            <h6><c:out value="${ sessionScope.loginMember.memName }"/>님 접속</h3>
                            <span><a href="${ pageContext.servletContext.contextPath }/member/logout"></a>로그아웃</span>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </header>   
	<br><br><br><br>
	<section class="section">
	<h2 align="center">정보 수정</h2>
	<br><br><br><br>
	<form action="${ pageContext.servletContext.contextPath }/user/update/myInfo" method="post">
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
                <td><label>새 비밀번호 </label> <input type="password" name="newPwd" id="newPwd"></td>
            </tr>
            <tr>
                <td><label>다시 입력 </label> <input type="password" name="retypeNewPwd" id="retypeNewPwd"></td>
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
                <td><label>변경할 이메일 </label> <input type="text" name="updateEmail"></td>
            </tr>
          </tbody>
          </c:forEach>
       </table>
       	<br>
       	<div class="updateButton"><input type="submit" value="수정하기" id="updateMyInfo"></div>
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
		
</body>
</html>