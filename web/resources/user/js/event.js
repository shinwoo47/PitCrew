window.onload = function() {
	
	if(document.getElementById("selectUpdate")) {
		const $selectUpdate = document.getElementById("selectUpdate");
		$selectUpdate.onclick = function() {
			location.href = "/pitcrew/user/select/update/myInfo";
		}
	}
	
	if(document.getElementById("updateMyInfo")) {
		
		const $updateMyInfo = document.getElementById("updateMyInfo");
		var newPwd = document.getElementById("newPwd").value;
		var retypeNewPwd = document.getElementById("retypeNewPwd").value;
		
		$updateMyInfo.onclick = function() {
			
			if(newPwd != retypeNewPwd) {
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			} else {
				location.href = "/pitcrew/user/update/myInfo";
			}
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
	
	$(document).ready(function(){
		$('#clea').change(function(){ 
		      if($('#clea').is(":checked")){ 
		         alert('체크박스 체크함'); 
		      }else{
		         alert('체크박스 해제함'); 
		      }
		   });
		});	
}

