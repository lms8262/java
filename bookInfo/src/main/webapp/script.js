function chkForm() {
	var f = document.frm;

	if (frm.book_name.value == '') {
		alert("도서명을 입력해주세요.");
		return false;
	}

	if (frm.publication_date.value == '') {
		alert("발행일을 입력해주세요.");
		return false;
	}

	if (frm.author.value == '') {
		alert("저자명을 입력해주세요.");
		return false;
	}

	if (frm.publisher.value == '') {
		alert("출판사명을 입력해주세요.");
		return false;
	}

	if (frm.page.value == '') {
		alert("페이지 수를 입력해주세요.");
		return false;
	}

	if (frm.category.value == '') {
		alert("카테고리를 입력해주세요.");
		return false;
	}

	if (frm.book_intro.value == '') {
		alert("도서 설명을 입력해주세요.");
		return false;
	}

	f.submit();
}

function chkDelete(book_no) {
	const result = confirm("삭제하시겠습니까?");

	if (result) {
		const url = location.origin;
		location.href = url + "/bookInfo/delete?book_no=" + book_no;
	} else {
		false;
	}
}
