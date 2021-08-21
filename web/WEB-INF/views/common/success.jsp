<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function(){
			const successCode = "${ requestScope.successCode }";
			
			let successMessage = "";
			let movePath = "";
			
			switch(successCode){
				case "insertMember" : 
					successMessage = "회원 가입에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }";
					break;
				case "updateMember" : 
					successMessage = "회원 정보 변경에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/member/update";
					break;
				case "deleteMember" : 
					successMessage = "회원 탈퇴에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/index.jsp";
					break;
				case "insertNotice" : 
					successMessage = "공지사항 등록에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/notice/list";
					break;
				case "insertBoard" : 
					successMessage = "게시판 등록에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/board/list";
					break;
				case "insertThumbnail" : 
					successMessage = "썸네일 게시판 등록에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/thumbnail/list";
					break;
				case "cleanerLogin" : 
					successMessage = "해결사 로그인 성공";
					movePath = "${ pageContext.servletContext.contextPath }/cleaner/home";
					break;
				case "adminLogin" : 
					successMessage = "관리자 로그인 성공";
					movePath = "${ pageContext.servletContext.contextPath }/admin/home";
					break;
				case "userLogin" : 
					successMessage = "사용자 로그인 성공";
					movePath = "${ pageContext.servletContext.contextPath }/user/home";
					break;
				case "updateUserInfo" :
					movePath = "${ pageContext.servletContext.contextPath }";
					successMessage = "회원 정보 변경에 성공하셨습니다!";
				case "insertAccount" :
					movePath = "${ pageContext.servletContext.contextPath }/cleaner/account";
					successMessage = "계좌 정보 등록에 성공하셨습니다!";
					break;

				case "insertReport" :
					movePath = "${ pageContext.servletContext.contextPath }/cleaner/home";
					successMessage = "신고 등록에 성공하셨습니다!";
					break;

				case "insertProduct" : "상품 추가 성공"
					movePath = "${ pageContext.servletContext.contextPath }/product/list";
					successMessage = "상품 추가에 성공하셨습니다!";
					break;
				case "deleteBlacklist" : "블랙리스트 삭제 성공"
					movePath = "${ pageContext.servletContext.contextPath }/admin/select/allblacklist";
					successMessage = "블랙리스트 삭제에 성공하셨습니다!";
					break;
				case "cleanerinsertQuestion" : 
					movePath = "${ pageContext.servletContext.contextPath }/cleaner/notice/list?category=PERSONAL";
					successMessage = "문의사항 등록 성공!";
					break;
				case "cleanerupdateQuestion" : 
					movePath = "${ pageContext.servletContext.contextPath }/cleaner/notice/list?category=PERSONAL";
					successMessage = "문의사항 수정 성공!";
					break;
					
				case "userinsertQuestion" : 
					movePath = "${ pageContext.servletContext.contextPath }/user/board/notice?category=PERSONAL";
					successMessage = "문의사항 등록 성공!";
					break;
				case "userupdateQuestion" : 
					movePath = "${ pageContext.servletContext.contextPath }/user/board/notice?category=PERSONAL";
					successMessage = "문의사항 수정 성공!";
					break;
				case "userDeleteQuestion" : 
					movePath = "${ pageContext.servletContext.contextPath }/user/board/notice?category=PERSONAL";
					successMessage = "문의사항 삭제 성공!";
					break;
					
				case "updateCleanerInfo" : 
					movePath = "${ pageContext.servletContext.contextPath }/cleaner/member/select";
					successMessage = "회원정보 수정 성공!";
					break;
				case "completeRequest" : 
					movePath = "${ pageContext.servletContext.contextPath }/cleaner/request/manage";
					successMessage = "의뢰 완료 성공";
					break;
				case "updatePwd" : 
					movePath = "${ pageContext.servletContext.contextPath }/member/login";
					successMessage = "비밀번호 변경 완료!";
					break;	

			}

			alert(successMessage);
			
			location.replace(movePath);
		})();
	
	</script>
</body>
</html>
