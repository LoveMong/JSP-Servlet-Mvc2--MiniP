	
// 상품 등록 유효성 검사
function productCheck() {

	if (document.frm.name.value.length == 0) {
		alert("상품명을 입력해주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.price.value.length == 0) {
		alert("상품가격을 입력해주세요.");
		frm.price.focus();
		return false;
	}
	if (document.frm.pictureUrl.value.length == 0) {
		alert("사진을 등록해주세요.");
		frm.pictureUrl.focus();
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







