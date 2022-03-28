	
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
	if (isNaN(document.frm.price.value)) {
		alert("가격은 숫자로 입력해야 합니다.");
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
