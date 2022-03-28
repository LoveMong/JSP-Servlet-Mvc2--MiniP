

$(document).ready(function(){

// login_register 폼 변경 TAP
    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	
// 아이디 생성 시 중복 검사
	$('#idCheck').click(function(){
     
   	if (document.jrm.userid.value == "") {
		alert('아이디를 입력해주세요.');
		jrm.userid.focus();
		return;
	}
	var url = "idCheck.do?userid=" + document.jrm.userid.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");	
     
     
     });
     
// 중복 체크된 아이디 사용
   $('#start').click(function(){
	  
	var userid = $('#userid').val();
	
	opener.jrm.userid.value = userid; //opener -> 자식창에서 부모창을 가리
	
	self.close();

});
     



});
	
// Login 유효성 검사
function loginCheck() {

	if (document.frm.userid.value.length == 0) {
		alert("아이디를 입력해주세요.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	
	return true;

}

function joinCheck() {

	var pwd = document.getElementById('jpwd').value;
	var cpwd = document.getElementById('cpwd').value;
	
	console.log("pwd:"+pwd);
	console.log("cpwd:"+cpwd);
	
	if (document.jrm.userid.value.length == 0) {
		alert("아이디를 입력해주세요.");
		jrm.userid.focus();
		return false;
	}
	if (document.jrm.name.value.length == 0) {
		alert("이름을 입력해주세요.");
		jrm.name.focus();
		return false;
	}
	if (document.jrm.email.value.length == 0) {
		alert("이메일을 입력해주세요.");
		jrm.email.focus();
		return false;
	}
	if (document.jrm.phone.value.length == 0) {
		alert("핸드폰 번호를 입력해주세요.");
		jrm.phone.focus();
		return false;
	}
	if (document.jrm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		jrm.pwd.focus();
		return false;
	}
	if (document.jrm.cpwd.value == "") {
		alert("비밀번호를 확인해주세요.");
		jrm.cpwd.focus();
		return false;
	}
	if (pwd != cpwd) {
		alert("비밀번호를 확인해주세요.");
		jrm.cpwd.focus();
		return false;
	}
	
	return true;
	
	};
	
 function idok(userid) {
	  
	opener.jrm.userid.value = document.jrm.userid.value;
	
	self.close();
};

function editCheck() {
			

    var epwd = document.getElementById('epwd').value;
	var ecpwd = document.getElementById('ecpwd').value;
	
		
	if (document.prm.userid.value.length == 0) {
		alert("아이디를 입력해주세요.");
		prm.userid.focus();
		return false;
	}
	if (document.prm.name.value.length == 0) {
		alert("이름을 입력해주세요.");
		prm.name.focus();
		return false;
	}
	if (document.prm.email.value.length == 0) {
		alert("이메일을 입력해주세요.");
		prm.email.focus();
		return false;
	}
	if (document.prm.phone.value.length == 0) {
		alert("핸드폰 번호를 입력해주세요.");
		prm.phone.focus();
		return false;
	}
	if (document.prm.epwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		prm.epwd.focus();
		return false;
	}
	if (document.prm.ecpwd.value == "") {
		alert("비밀번호를 확인해주세요.");
		prm.ecpwd.focus();
		return false;
	}
	if (epwd != ecpwd) {
		alert("비밀번호를 확인해주세요.");
		prm.cpwd.focus();
		return false;
	}

	return true;
	
};







