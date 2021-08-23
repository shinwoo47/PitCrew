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
  font-size: 14px;sun1010
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
            <form class="form-horizontal" role="form" form id="joinForm" action="${ pageContext.servletContext.contextPath }/member/regist" method="post" onsubmit="return check()">
                <h2>회원 가입</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">이름</label>
                    <div class="col-sm-9">
                        <input type="text" id="name" name="memberName" placeholder="Full Name" class="form-control" autofocus>
                    </div>
                </div>
                 <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Id</label>
                    <div class="col-sm-9">
                        <input type="text" maxlength="13" name="memberId" id="id" required class="form-control2">
                        <input type="button" value="중복확인" class="btn btn-or" id="duplicationCheck">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">비밀번호</label>
                    <div class="col-sm-9">
                        <input type="password" id="pwd" name="memberPwd" placeholder="Password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">비밀번호</label>
                    <div class="col-sm-9">
                        <input type="password" id="checkPwd" placeholder="Password Check" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <input type="email" id="email" name="email" placeholder="Email" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">생년월일</label>
                    <div class="col-sm-9">
                        <input type="date" id="birth" name="birth" class="form-control">
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
                                    <input type="radio" id="role" name="role" value="사용자">일반 사용자
                                </label>
                            </div>
                            <div class="col-sm-8">
                                <label class="radio-inline">
                                    <input type="radio" id="role" name="role" value="해결사">청소 도우미
                                </label>
                            </div>
                            
                        </div>
                    </div>
                </div> 
               
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                    <textarea rows="10" cols="45" readonly>
<(주)맡겨줘홈즈 >(' '이하 '맡겨줘홈즈')은(는) 「개인정보 보호법」 제30조에 따라 정보주체의 개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 다음과 같이 개인정보 처리방침을 수립·공개합니다.

○ 이 개인정보처리방침은 2021년 7월 1부터 적용됩니다.


제1조(개인정보의 처리 목적)

< (주)맡겨줘홈즈 >(' '이하 '맡겨줘홈즈')은(는) 다음의 목적을 위하여 개인정보를 처리합니다. 처리하고 있는 개인정보는 다음의 목적 이외의 용도로는 이용되지 않으며 이용 목적이 변경되는 경우에는 「개인정보 보호법」 제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.

1. 홈페이지 회원가입 및 관리

회원 가입의사 확인, 회원제 서비스 제공에 따른 본인 식별·인증, 회원자격 유지·관리, 서비스 부정이용 방지 목적으로 개인정보를 처리합니다.


2. 민원사무 처리

민원인의 신원 확인, 민원사항 확인, 사실조사를 위한 연락·통지 목적으로 개인정보를 처리합니다.


3. 재화 또는 서비스 제공

서비스 제공, 맞춤서비스 제공, 본인인증, 요금결제·정산을 목적으로 개인정보를 처리합니다.




제2조(개인정보의 처리 및 보유 기간)

① < (주)맡겨줘홈즈 >은(는) 법령에 따른 개인정보 보유·이용기간 또는 정보주체로부터 개인정보를 수집 시에 동의받은 개인정보 보유·이용기간 내에서 개인정보를 처리·보유합니다.

② 각각의 개인정보 처리 및 보유 기간은 다음과 같습니다.

1.<홈페이지 회원가입 및 관리>
<홈페이지 회원가입 및 관리>와 관련한 개인정보는 수집.이용에 관한 동의일로부터<1년>까지 위 이용목적을 위하여 보유.이용됩니다.
보유근거 : 표시/광고에 관한 법률
관련법령 : 표시/광고에 관한 기록 : 6개월
예외사유 : .


제3조(개인정보의 제3자 제공)

① < (주)맡겨줘홈즈 >은(는) 개인정보를 제1조(개인정보의 처리 목적)에서 명시한 범위 내에서만 처리하며, 정보주체의 동의, 법률의 특별한 규정 등 「개인정보 보호법」 제17조 및 제18조에 해당하는 경우에만 개인정보를 제3자에게 제공합니다.

② < (주)맡겨줘홈즈 >은(는) 다음과 같이 개인정보를 제3자에게 제공하고 있습니다.

1. < 맡겨줘홈즈 >
개인정보를 제공받는 자 : 맡겨줘홈즈
제공받는 자의 개인정보 이용목적 : 이메일, 휴대전화번호, 생년월일
제공받는 자의 보유.이용기간: 1년


제4조(개인정보처리 위탁)

① < (주)맡겨줘홈즈 >은(는) 원활한 개인정보 업무처리를 위하여 다음과 같이 개인정보 처리업무를 위탁하고 있습니다.

1. < >
위탁받는 자 (수탁자) :
위탁하는 업무의 내용 :
위탁기간 :
② < (주)맡겨줘홈즈 >은(는) 위탁계약 체결시 「개인정보 보호법」 제26조에 따라 위탁업무 수행목적 외 개인정보 처리금지, 기술적․관리적 보호조치, 재위탁 제한, 수탁자에 대한 관리․감독, 손해배상 등 책임에 관한 사항을 계약서 등 문서에 명시하고, 수탁자가 개인정보를 안전하게 처리하는지를 감독하고 있습니다.

③ 위탁업무의 내용이나 수탁자가 변경될 경우에는 지체없이 본 개인정보 처리방침을 통하여 공개하도록 하겠습니다.



제5조(정보주체와 법정대리인의 권리·의무 및 그 행사방법)



① 정보주체는 (주)맡겨줘홈즈에 대해 언제든지 개인정보 열람·정정·삭제·처리정지 요구 등의 권리를 행사할 수 있습니다.

② 제1항에 따른 권리 행사는(주)맡겨줘홈즈에 대해 「개인정보 보호법」 시행령 제41조제1항에 따라 서면, 전자우편, 모사전송(FAX) 등을 통하여 하실 수 있으며 (주)맡겨줘홈즈은(는) 이에 대해 지체 없이 조치하겠습니다.

③ 제1항에 따른 권리 행사는 정보주체의 법정대리인이나 위임을 받은 자 등 대리인을 통하여 하실 수 있습니다.이 경우 “개인정보 처리 방법에 관한 고시(제2020-7호)” 별지 제11호 서식에 따른 위임장을 제출하셔야 합니다.

④ 개인정보 열람 및 처리정지 요구는 「개인정보 보호법」 제35조 제4항, 제37조 제2항에 의하여 정보주체의 권리가 제한 될 수 있습니다.

⑤ 개인정보의 정정 및 삭제 요구는 다른 법령에서 그 개인정보가 수집 대상으로 명시되어 있는 경우에는 그 삭제를 요구할 수 없습니다.

⑥ (주)맡겨줘홈즈은(는) 정보주체 권리에 따른 열람의 요구, 정정·삭제의 요구, 처리정지의 요구 시 열람 등 요구를 한 자가 본인이거나 정당한 대리인인지를 확인합니다.



제6조(처리하는 개인정보의 항목 작성)

① < (주)맡겨줘홈즈 >은(는) 다음의 개인정보 항목을 처리하고 있습니다.

1< 홈페이지 회원가입 및 관리 >
필수항목 : 이메일, 휴대전화번호, 자택주소, 비밀번호, 로그인ID, 생년월일, 이름
선택항목 :
2< 재화 또는 서비스 제공 >
필수항목 : 이메일, 휴대전화번호, 자택주소, 비밀번호, 로그인ID, 생년월일, 이름, 신용카드정보, 은행계좌정보, 결제기록
선택항목 :


제7조(개인정보의 파기)


① < (주)맡겨줘홈즈 > 은(는) 개인정보 보유기간의 경과, 처리목적 달성 등 개인정보가 불필요하게 되었을 때에는 지체없이 해당 개인정보를 파기합니다.

② 정보주체로부터 동의받은 개인정보 보유기간이 경과하거나 처리목적이 달성되었음에도 불구하고 다른 법령에 따라 개인정보를 계속 보존하여야 하는 경우에는, 해당 개인정보를 별도의 데이터베이스(DB)로 옮기거나 보관장소를 달리하여 보존합니다.
1. 법령 근거 :
2. 보존하는 개인정보 항목 : 계좌정보, 거래날짜

③ 개인정보 파기의 절차 및 방법은 다음과 같습니다.
1. 파기절차
< (주)맡겨줘홈즈 > 은(는) 파기 사유가 발생한 개인정보를 선정하고, < (주)맡겨줘홈즈 > 의 개인정보 보호책임자의 승인을 받아 개인정보를 파기합니다.

2. 파기방법

전자적 파일 형태의 정보는 기록을 재생할 수 없는 기술적 방법을 사용합니다



제8조(개인정보의 안전성 확보 조치)

< (주)맡겨줘홈즈 >은(는) 개인정보의 안전성 확보를 위해 다음과 같은 조치를 취하고 있습니다.

1. 정기적인 자체 감사 실시
개인정보 취급 관련 안정성 확보를 위해 정기적(분기 1회)으로 자체 감사를 실시하고 있습니다.

2. 개인정보 취급 직원의 최소화 및 교육
개인정보를 취급하는 직원을 지정하고 담당자에 한정시켜 최소화 하여 개인정보를 관리하는 대책을 시행하고 있습니다.

3. 내부관리계획의 수립 및 시행
개인정보의 안전한 처리를 위하여 내부관리계획을 수립하고 시행하고 있습니다.

4. 해킹 등에 대비한 기술적 대책
<(주)맡겨줘홈즈>('맡겨줘홈즈')은 해킹이나 컴퓨터 바이러스 등에 의한 개인정보 유출 및 훼손을 막기 위하여 보안프로그램을 설치하고 주기적인 갱신·점검을 하며 외부로부터 접근이 통제된 구역에 시스템을 설치하고 기술적/물리적으로 감시 및 차단하고 있습니다.

5. 개인정보의 암호화
이용자의 개인정보는 비밀번호는 암호화 되어 저장 및 관리되고 있어, 본인만이 알 수 있으며 중요한 데이터는 파일 및 전송 데이터를 암호화 하거나 파일 잠금 기능을 사용하는 등의 별도 보안기능을 사용하고 있습니다.

6. 개인정보에 대한 접근 제한
개인정보를 처리하는 데이터베이스시스템에 대한 접근권한의 부여,변경,말소를 통하여 개인정보에 대한 접근통제를 위하여 필요한 조치를 하고 있으며 침입차단시스템을 이용하여 외부로부터의 무단 접근을 통제하고 있습니다.

7. 비인가자에 대한 출입 통제
개인정보를 보관하고 있는 물리적 보관 장소를 별도로 두고 이에 대해 출입통제 절차를 수립, 운영하고 있습니다.




제9조(개인정보 자동 수집 장치의 설치•운영 및 거부에 관한 사항)



① (주)맡겨줘홈즈 은(는) 이용자에게 개별적인 맞춤서비스를 제공하기 위해 이용정보를 저장하고 수시로 불러오는 ‘쿠키(cookie)’를 사용합니다.
② 쿠키는 웹사이트를 운영하는데 이용되는 서버(http)가 이용자의 컴퓨터 브라우저에게 보내는 소량의 정보이며 이용자들의 PC 컴퓨터내의 하드디스크에 저장되기도 합니다.
가. 쿠키의 사용 목적 : 이용자가 방문한 각 서비스와 웹 사이트들에 대한 방문 및 이용형태, 인기 검색어, 보안접속 여부, 등을 파악하여 이용자에게 최적화된 정보 제공을 위해 사용됩니다.
나. 쿠키의 설치•운영 및 거부 : 웹브라우저 상단의 도구>인터넷 옵션>개인정보 메뉴의 옵션 설정을 통해 쿠키 저장을 거부 할 수 있습니다.
다. 쿠키 저장을 거부할 경우 맞춤형 서비스 이용에 어려움이 발생할 수 있습니다.

제10조 (개인정보 보호책임자)

① (주)맡겨줘홈즈 은(는) 개인정보 처리에 관한 업무를 총괄해서 책임지고, 개인정보 처리와 관련한 정보주체의 불만처리 및 피해구제 등을 위하여 아래와 같이 개인정보 보호책임자를 지정하고 있습니다.

▶ 개인정보 보호책임자
성명 :이하림
직책 :대표이사
직급 :대표이사
연락처 :02-556-5611, helloharim09@gmail.com,
※ 개인정보 보호 담당부서로 연결됩니다.

▶ 개인정보 보호 담당부서
부서명 :총무팀
담당자 :박종현
연락처 :02-556-5485, whdgusqkr92@nate.com,
② 정보주체께서는 (주)맡겨줘홈즈 의 서비스(또는 사업)을 이용하시면서 발생한 모든 개인정보 보호 관련 문의, 불만처리, 피해구제 등에 관한 사항을 개인정보 보호책임자 및 담당부서로 문의하실 수 있습니다. (주)맡겨줘홈즈 은(는) 정보주체의 문의에 대해 지체 없이 답변 및 처리해드릴 것입니다.

제11조(개인정보 열람청구)
정보주체는 ｢개인정보 보호법｣ 제35조에 따른 개인정보의 열람 청구를 아래의 부서에 할 수 있습니다.
< (주)맡겨줘홈즈 >은(는) 정보주체의 개인정보 열람청구가 신속하게 처리되도록 노력하겠습니다.

▶ 개인정보 열람청구 접수·처리 부서
부서명 : 총무팀
담당자 : 박종현
연락처 : 02-556-5611, 123@naver.com,


제12조(권익침해 구제방법)



정보주체는 개인정보침해로 인한 구제를 받기 위하여 개인정보분쟁조정위원회, 한국인터넷진흥원 개인정보침해신고센터 등에 분쟁해결이나 상담 등을 신청할 수 있습니다. 이 밖에 기타 개인정보침해의 신고, 상담에 대하여는 아래의 기관에 문의하시기 바랍니다.

1. 개인정보분쟁조정위원회 : (국번없이) 1833-6972 (www.kopico.go.kr)
2. 개인정보침해신고센터 : (국번없이) 118 (privacy.kisa.or.kr)
3. 대검찰청 : (국번없이) 1301 (www.spo.go.kr)
4. 경찰청 : (국번없이) 182 (cyberbureau.police.go.kr)

「개인정보보호법」제35조(개인정보의 열람), 제36조(개인정보의 정정·삭제), 제37조(개인정보의 처리정지 등)의 규정에 의한 요구에 대 하여 공공기관의 장이 행한 처분 또는 부작위로 인하여 권리 또는 이익의 침해를 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.

※ 행정심판에 대해 자세한 사항은 중앙행정심판위원회(www.simpan.go.kr) 홈페이지를 참고하시기 바랍니다.

제13조(개인정보 처리방침 변경)


① 이 개인정보처리방침은 2021년 7월 1부터 적용됩니다.

② 이전의 개인정보 처리방침은 아래에서 확인하실 수 있습니다.

예시 ) - 20XX. X. X ~ 20XX. X. X 적용 (클릭)

예시 ) - 20XX. X. X ~ 20XX. X. X 적용 (클릭)

예시 ) - 20XX. X. X ~ 20XX. X. X 적용 (클릭)
                    </textarea>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="agree">이용약관 동의</a>
                            </label>
                        </div>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block" disabled id="reg_submit">Register</button>
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	
	window.onload = function() {
		var agree = $("input[type=checkbox]:checked").length
		var role = $("input[type^=ra]:checked").length;
		
		console.log(agree);
		console.log(role);
	}
	
	function check() {
	      var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	      var getCheck= RegExp(/^[a-zA-Z0-9]{4,15}$/);
	      var getName = RegExp(/^[가-힣]+$/);
	      var getPwd = RegExp(/\w{8,15}$/)
	      var getPhone = RegExp(/^01(?:0)-(?:\d{3}|\d{4})-\d{4}$/);
	 	  
	      //이름 공백 확인
	      if($("#name").val() == ""){
		        alert("이름 입력해 주세요");
		        $("#name").focus();
		        return false;
	      }
	      
	      //이름 유효성
	      if (!getName.test($("#name").val())) {
	        alert("이름이 올바르지 않습니다");
	        $("#name").val("");
	        $("#name").focus();
	        return false;
	      }
	      
	      //아이디 공백 확인
	      if($("#id").val() == ""){
		        alert("아이디를 입력해 주세요");
		        $("#id").focus();
		        return false;
	      }
	 
	      //아이디의 유효성 검사
	      if(!getCheck.test($("#id").val())){
		        alert("아이디를 형식에 맞게 입력해주세요");
		        $("#id").val("");
		        $("#id").focus();
		        return false;
	      }
	 
	      //비밀번호 공백 확인
	      if($("#pwd").val() == ""){
		        alert("비밀번호를 입력해 주세요");
		        $("#pwd").focus();
		        return false;
	      }
	    
	      //비밀번호 형식 검사
	      if(!getPwd.test($("#pwd").val())){
		        alert("비밀번호는 최소 8자리입니다.");
		        $("#pwd").val("");
		        $("#pwd").focus();
		        return false;
	      }
	 
 
	     //비밀번호 똑같은지
	     if($("#pwd").val() != ($("#checkPwd").val())){ 
		      alert("비밀번호가 틀렸습니다.");
		      $("#pwd").val("");
		      $("#checkPwd").val("");
		      $("#pwd").focus();
		      return false;
	     }
	     
	     //이메일 공백 확인
	     if($("#email").val() == ""){
	        alert("이메일을 입력해주세요");
	        $("#email").focus();
	        return false;
	     }
	           
	     //이메일 유효성 검사
	     if(!getMail.test($("#email").val())){
	        alert("이메일형식에 맞게 입력해주세요")
	        $("#email").val("");
	        $("#email").focus();
	        return false;
	     }
	     
	     //생년월일 공백 확인
	     if($("#birth").val() == ""){
	        alert("생년월일 입력해주세요");
	        $("#birth").focus();
	        return false;
	     }
	     
	     //전화번호 공백 확인
	     if($("#phone").val() == ""){
		        alert("전화번호를 입력해 주세요");
		        $("#phone").focus();
		        return false;
	     }
	     
	     //전화번호 형식 확인 
	     if(!getPhone.test($("#phone").val()).replace("-","")){
		        alert("전화번호를 형식에 맞게 입력해주세요");
		        $("#phone").val("");
		        $("#phone").focus();
		        return false;
		 }	 
		 
	     //주소 공백 확인
	     if($("#zipCode").val() == ""){
		        alert("주소를 입력해 주세요");
		        $("#zipCode").focus();
		        return false;
	     }
	     
	     //이용자 종류 선택 여부체크
	     if ($("input[type^=ra]:checked").length == 0){ 
	    	  alert("이용자 종류를 선택하세요"); 
	    	  $("#role").focus(); 
	    	  return false; 
	     }
	     
	     //약관동의 체크
	     
	     if ($("input[type=checkbox]:checked").length == 0){ 
	    	  alert("약관동의를 체크해 주세요"); 
	    	  $("#agree").focus(); 
	    	  return false; 
	     }

	     return true;
	 }
		const $searchZipCode = document.getElementById("searchZipCode");
		const $goMain = document.getElementById("goMain");
		const $idCheck = document.getElementById("duplicationCheck");
		console.log($idCheck);
		
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
	
		
		$idCheck.onclick = function() {
			console.log("idcheck")
				// id = "id_reg" / name = "userId"
				var user_id = $('#id').val();
				console.log(user_id)
				$.ajax({
					url : '${pageContext.request.contextPath}/member/idCheck?userId='+ user_id,
					type : 'get',
					success : function(data) {
						console.log("1 = 중복o / 0 = 중복x : "+ data);							
						
						if (data == 1) {
								alert("중복된 아이디 입니다.")
								$("#reg_submit").attr("disabled", true);	
							} else {
								if(user_id == ""){
									console.log("hi")
									$('#idcheck').text('아이디를 입력해주세요 :)');
									$('#idcheck').css('color', 'red');
									$("#reg_submit").attr("disabled", true);				
									
								} else {
									alert("중복되지 않은 아이디입니다.")
									$("#reg_submit").attr("disabled", false);
								}
								
							}
						}, 
					error : function() {
							console.log("실패");
					}
				});
		}
		
		$("#emailCheck").click(function() {// 메일 입력 유효성 검사
			var mail = $("#email").val(); //사용자의 이메일 입력값. 
			
			if (mail == "") {
				alert("메일 주소가 입력되지 않았습니다.");
			} else {
				mail = mail+"@"+$(".domain").val(); //셀렉트 박스에 @뒤 값들을 더함.
				$.ajax({
					type : 'post',
					url : '/CheckMail',
					data : {
						mail:mail
						},
					dataType :'json',

				});
				alert("인증번호가 전송되었습니다.") 
				isCertification=true; //추후 인증 여부를 알기위한 값
			}
		});
	</script>
</body>
</html>