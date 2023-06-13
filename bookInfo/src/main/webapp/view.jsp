<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
<link rel="stylesheet" href="./css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrap">
		<header>
			<nav class="navbar bg-body-tertiary" data-bs-theme="dark">
				<div class="container-fluid">
					<a class="navbar-brand navbar_title" href="index.jsp">도서 정보 사이트</a>
				</div>
			</nav>
		</header>
		<main class="view_main">
			<h2>도서 상세 정보</h2>
			<div class="card mb-3">
				<div class="row g-0">
					<div class="col-md-3">
						<c:if test="${book.img == null || book.img == ''}">
							<img src="/img/no_image.gif" class="img-fluid rounded-start"
								alt="이미지 없음">
						</c:if>
						<c:if test="${book.img != null && book.img != ''}">
							<img src="${book.img}" class="img-fluid rounded-start"
								alt="도서 이미지">
						</c:if>
					</div>
					<div class="col-md-9">
						<div class="card-body">
							<h4 class="card-title" style="font-weight: bold;">${book.book_name}</h4>
							<p class="card-text">
								<b>발행일:</b> ${book.publication_date} <br> <b>저자:</b>
								${book.author} <br> <b>출판사:</b> ${book.publisher} <br>
								<b>페이지:</b> ${book.page} <br> <b>카테고리:</b> ${book.category}
							</p>
							<p class="card-text">
								<b>도서 설명</b> <br> ${book.book_intro}
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-12 write_btn">
				<a class="btn btn-primary" href="edit?book_no=${book.book_no}"
					role="button">수정하기</a> <a
					onclick="chkDelete(${book.book_no}); return false;"
					class="btn btn-danger" role="button">삭제하기</a> <a
					class="btn btn-secondary" href="list" role="button">목록으로</a>
			</div>
		</main>
	</div>
	<script>
		<c:if test="${param.error != null}">
			alert("${param.error}");
		</c:if>
		<c:if test="${error != null}">
			alert("${error}");
		</c:if>
	</script>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>