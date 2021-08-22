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
	
	
	
	if(document.getElementById("popup")) {
	      const $popup = document.getElementById("popup");
	      $popup.onclick = function() {
	         var url = "/pitcrew/user/clean/list?number=" + 1;
	         var name = "test";
	         var option = "width = 700, height = 800, top = 100, " +
	            	"left = 300, location = no "
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
	
	if(document.getElementById("payment")) {
		const $payment = document.getElementById("payment");
		$payment.onclick = function() {
			
			/*var now = new Date();
			
			var year = now.getFullYear();
			var month = now.getMonth()+1;
			var day = now.getDate();
			var hours = now.getHours();
			var minutes = now.getMinutes();
		
			var sttDt = $("#start").val();
			sttDt = sttDt.split("-");
			var sttYear = sttDt[0];
			var sttMonth = sttDt[1];
			var sttDay = sttDt[2];
			
			var sttDe = $("#startTime").val();
			sttDe = sttDe.split(":");
			var sttHours = sttDe[0];
			var sttMinutes = sttDe[1];
			
			var date1= new Date(year, month, day, hours, minutes);
			var date2= new Date(sttYear, sttMonth, sttDay, sttHours, sttMinutes);
			
			alert(date1.getTime());

			
			if(date2.getTime() < date1.getTime()) {
				alert("불가")
				return false;
			}
			
			var elpsedMSec = date2.getTime() - date1.getTime();
			var elapsedMin = elapsedMSec / 1000 / 60;
			
			elapsedMin = parseInt(elapsedMin);
			alert(elpsedMSec);
			
			
			alert($("#start").val());
			alert($("#startTime").val());*/
			
			if($("#start").val() == "") {
				console.log($("#start" ).val())
				alert("날짜를 선택해주세요");
				return false;
			}  else if($("#startTime").val() ==  "") {
				alert("시간을 선택해주세요");
				return false;
			} else if($("#startTime").val() < 10) {
				alert("안됨");
				return false;
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
