window.onload = function() {
	
	if(document.getElementById("selectUpdate")) {
		const $selectUpdate = document.getElementById("selectUpdate");
		$selectUpdate.onclick = function() {
			location.href = "/pitcrew/user/member/selectUpdate/myInfo";
		}
	}
	
	if(document.getElementById("cleana")) {
		const $cleana = document.getElementById("cleana");
		$cleana.onclick = function() {
			console.log(1);
			location.href = "/pitcrew/user/clean/select?number=" + 1;
			
		}
	}
	if(document.getElementById("cleanb")) {
		const $cleanb = document.getElementById("cleanb");
		$cleanb.onclick = function() {
			location.href = "/pitcrew/user/clean/select?number=" + 2;
		}
	}
	if(document.getElementById("cleanc")) {
		const $cleanc = document.getElementById("cleanc");
		$cleanc.onclick = function() {
			location.href = "/pitcrew/user/clean/select?number=" + 3;
		}
	}
	
	
	/* 자세히 보기 클릭시 팝업 함수 실행 */
	if(document.getElementById("popup")) {
	      const $popup = document.getElementById("popup");
	      $popup.onclick = function() {
	         var url = "/pitcrew/user/clean/list?number=" + 1;
	         var name = "test";
	         var option = "width = 700, height = 800, top = 100, left = 300, location = no "
	         window.open(url, name, option);
	      }
	   }
	
	if(document.getElementById("popup2")) {
		const $popup2 = document.getElementById("popup2");
		$popup2.onclick = function() {
			var url = "/pitcrew/user/clean/list?number=" + 2;
			var name = "test";
			var option = "width = 700, height = 800, top = 100, left = 300, location = no"
			window.open(url, name, option);
		}
	}
	
	if(document.getElementById("popup3")) {
		const $popup3 = document.getElementById("popup3");
		$popup3.onclick = function() {
			var url = "/pitcrew/user/clean/list?number=" + 3;
			var name = "test";
			var option = "width = 700, height = 800, top = 100, left = 300, location = no"
			window.open(url, name, option);
		}
	}
	
	if(document.getElementById("popup4")) {
		const $popup4 = document.getElementById("popup4");
		$popup4.onclick = function() {
			var url = "/pitcrew/user/clean/list?number=" + 4;
			var name = "test";
			var option = "width = 700, height = 800, top = 100, left = 300, location = no"
			window.open(url, name, option);
		}
	}
	
	if(document.getElementById("popup5")) {
		const $popup5 = document.getElementById("popup5");
		$popup5.onclick = function() {
			var url = "/pitcrew/user/clean/list?number=" + 5;
			var name = "test";
			var option = "width = 700, height = 800, top = 100, left = 300, location = no"
			window.open(url, name, option);
		}
	}
	
	if(document.getElementById("information")) {
		const $information = document.getElementById("information");
		$information.onclick = function() {
			var url = "/pitcrew/user/clean/informa";
			var name = "test";
			var option = "width = 700, height = 800, top = 100, left = 300, location = no"
			window.open(url, name, option);
		}
	}
	
	/* 주문하기 클릭시 함수 실행 */
	if(document.getElementById("payment")) {
		const $payment = document.getElementById("payment");
		$payment.onclick = function() {
			 
			/* 현재 날짜 년, 월, 일  사용자가 입력한 날짜 년, 월, 일로 변수 선언 */
			 var now = new Date();				
			 var year = now.getFullYear();
			var month = now.getMonth()+1;
			var day = now.getDate();
			var sttDt = $("#start").val();
			sttDt = sttDt.split("-");
			var sttYear = sttDt[0];
			var sttMonth = sttDt[1];
			var sttDay = sttDt[2];
				
			/* 지난 날짜 선택 불가, 날짜 필수 선택*/
			if($("#start").val() == "") {
				alert("날짜를 선택해주세요");
				return false;
			} else if($("#startTime").val() ==  "") {
				alert("시간을 선택해주세요");
				return false;
			} else if(year > sttYear) {
				alert("지난 날짜는 선택할 수 없습니다");
				return false;
			} else if(year == sttYear) {
				if(month > sttMonth){
					alert("지난 날짜는 선택할 수 없습니다");
					return false;
				}
			} else if(year == sttYear) {
				if(month >= sttMonth) {
					if(day + 2 <= sttDay) {
						alert("2일 전 날짜부터 의뢰하실 수 있습니다");
						return false;
					}
				}
			} else if(month > sttMonth) {
				alert("지난 날짜는 선택할 수없 습니다");
				return false;
				
				if(day > sttDay) {
					alert("지난 날짜는 선택할 수없 습니다");
					return false;
				}
			} else { 
				location.href = "/pitcrew/user/clean/payment";
			}
		}
	}
	
	if(document.getElementById("quitMember")) {
		const $quitMember = document.getElementById("quitMember");
		$quitMember.onclick = function() {
			location.href = "/pitcrew/user/quit/member";
		}
	}
	
}
