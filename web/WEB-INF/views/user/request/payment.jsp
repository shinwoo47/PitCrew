<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Clean Home</title>
    <meta name="description" content="Loanday Template">
    <meta name="keywords" content="Loanday, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

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
	<script src="${ pageContext.servletContext.contextPath }/resources/user/js/event.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
   
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery-3.3.1.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/bootstrap.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.nice-select.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery-ui.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.nicescroll.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.magnific-popup.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.slicknav.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/owl.carousel.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/main.js"></script>
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<style>
   
	    .section {
	       width : 1000px;
	        margin-right: auto;
	        margin-left: auto;
	       padding-top: 100px;
	       
	    }
   
		 table.type05 {
		  border-collapse: separate;
		  border-spacing: 1px;
		  text-align: left;
		  line-height: 1.5;
		  border-top: 1px solid #ccc;
		  margin: auto;
		  
		}
		
		table.type05 th {
		  width: 300px;
		  padding: 10px;
		  font-weight: bold;
		  vertical-align: top;
		  border-bottom: 1px solid #ccc;
		  background: #efefef;
		}
		
		table.type05 td {
		  width: 1080px;
		  padding: 10px;
		  vertical-align: top;
		  border-bottom: 1px solid #ccc;
		}
		
		.pay {
		    width: 100px;
		    height: 100px;;
		    margin: auto;
		
		}
		
		.btn-yb {
			width: 200px;
			 	height: 50px;
			 	background-color : blue;
			 	font-size : 28px;
			 	color : white;
		} 
		 
		.btn_requ {
			 	 width: 220px;
			 	 height: 70px;
			 	 background-color : red;
			 	 font-size : 33px;
			 	 color : white;
		}
		 
		.btn_q {
			 margin: auto;
		 	  width: 10%;
		}
	</style>
</head>
<body>

   <jsp:include page="../userMenubar.jsp"/>
	
	<!-- 결제할 정보 -->    
	<div class="section">
   	<input type="button" class="btn-yb" value="안내사항 보기" id="information">
    <h2 ><br>구매자 정보</h2> 
     	<table class="type05" >
			<tr>
                <th scope="row" >이름</th>
                <td><c:out value="${ clean.memName }"/></td>
          	</tr>
           	<tr>
                <th scope="row">이메일</th>
                <td><c:out value="${ clean.email }"/></td>
            </tr>
            <tr>
                <th scope="row">휴대폰 번호</th>
                <td><c:out value="${ clean.phone }"/></td>
            </tr>
		</table>
   		<br>
   			<div class="article">
      	<h2>결제정보</h2>
         	<table class="type05">
            	<tr>
                    <th scope="row">시작일</th>
                    <td><c:out value="${ clean.rewDate }"/>&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;(<c:out value="${ clean.time }"/>)시간</td>
               </tr>
                <tr>
                    <th scope="row">주소</th>
                    <td><c:out value="${ fn:replace(clean.address, \"$\" , \" \") }"/></td>
                    
               </tr>
                <tr>
                    <th scope="row">가격</th>
                    <td><c:out value="${ clean.proPrice }"/></td>
	            </tr>
            </table>
      		<br><br>
		</div>
	</div>
	<div class="btn_q">
      <button type="submit" class="btn_requ" value="주문하기" id="paymentProceed" >결제하기</button>
	</div>
	
	<!-- 결제할 정보 끝 -->
</body>

	<script>
		
		/* 결제하기 버튼 누르면 결제하기 API가 화면에 나온다.*/
		$("#paymentProceed").click(function() {
		
			/* 생갹 가능하다.*/
			var IMP = window.IMP;
			
			/* 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용 */
			IMP.init('imp80360263');								
			IMP.request_pay({
				
				/* PG사 선택 */
				pg: 'html5_inicis', 							
					
				/* 거래할 수단(카드) */
				pay_method: 'card',								
				
				/*고유 상품 아이디(필수 입력) */
				merchant_uid: 'merchant_' + new Date().getTime(),
	
				name: '주문명:맡겨줘 홈즈',
				
				/* 상품 가격 */
				amount: '${ clean.proPrice }',
	
				/* 구매자 이메일 */
				buyer_email: "${ clean.email }",
				
				/* 구매자 이름 */
				buyer_name: "${ clean.memName}",
				
				/* 구매자 전화번호 */
				buyer_tel: "${ clean.phone }",
				
				/* 결제 진행 화면 */
			}, function (rsp) {
				
				/* 결제 성공 시 이동할 url경로 입력한 의뢰 날짜, data에 컨트롤러에 보내줄 데이터를 입격한다.*/
				if (rsp.success) {
					console.log("${ clean.reqDate }");
					$.ajax({
						url: "${pageContext.servletContext.contextPath}/user/pay/request",
						type: 'POST',
						data: {
							impUid : rsp.imp_uid,
							serPrice: rsp.paid_amount,
							reqDate: "${ clean.rewDate }",
							productNo: "${ clean.productNo }",
							reqOption1: "${ clean.optionNo1 }",
							reqOption2: "${ clean.optionNo2 }",
							reqReq: "${ clean.reqReq }",
						},
						
						success : function(data, textStatus, xhr) {
							var msg = '결제가 완료되었습니다.';
							alert(msg);
							location.href = "${pageContext.servletContext.contextPath}/user/home"; 
						},
						error: function(xhr, status, error){}
					});
					
				/* 결제 실패시 */	
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
					alert(msg);
				}
			});
		});
		
	</script>

</html>