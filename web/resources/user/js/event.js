window.onload = function() {
	
	if(document.getElementById("selectUpdate")) {
		const $selectUpdate = document.getElementById("selectUpdate");
		$selectUpdate.onclick = function() {
			location.href = "/pitcrew/user/select/update/myInfo";
		}
	}
	
	if(document.getElementById("updateMyInfo")) {
		
		var time;
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
	
	if(document.getElementById("popup")) {
		const $popup = document.getElementById("popup");
		$popup.onclick = function() {
			var url = "/pitcrew/user/clean/list?number=" + 1;
			var name = "test";
			var option = "width = 700, height = 600, top = 100, left = 300, location = no"
			window.open(url, name, option);
			window.open;
		}
	}
	
	if(document.getElementById("popup2")) {
		const $popup2 = document.getElementById("popup2");
		$popup2.onclick = function() {
			var url = "/pitcrew/user/clean/list?number=" + 2;
			var name = "test";
			var option = "width = 700, height = 600, top = 100, left = 300, location = no"
			window.open(url, name, option);
			window.open;
		}
	}
	
	if(document.getElementById("popup3")) {
		const $popup3 = document.getElementById("popup3");
		$popup3.onclick = function() {
			var url = "/pitcrew/user/clean/list?number=" + 3;
			var name = "test";
			var option = "width = 700, height = 600, top = 100, left = 300, location = no"
			window.open(url, name, option);
			window.open;
		}
	}
	
	if(document.getElementById("popup4")) {
		const $popup4 = document.getElementById("popup4");
		$popup4.onclick = function() {
			var url = "/pitcrew/user/clean/list?number=" + 4;
			var name = "test";
			var option = "width = 700, height = 600, top = 100, left = 300, location = no"
			window.open(url, name, option);
			window.open;
		}
	}
	
	if(document.getElementById("popup5")) {
		const $popup5 = document.getElementById("popup5");
		$popup5.onclick = function() {
			var url = "/pitcrew/user/clean/list?number=" + 5;
			var name = "test";
			var option = "width = 700, height = 600, top = 100, left = 300, location = no"
			window.open(url, name, option);
			window.open;
		}
	}
}

