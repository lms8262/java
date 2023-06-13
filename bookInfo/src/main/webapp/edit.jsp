<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
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
		<main class="book_write">
			<h2>도서 정보 수정</h2>
			<form class="row g-3" name="frm" method="post"
				action="update?book_no=${book.book_no}"
				enctype="multipart/form-data">
				<div class="col-md-6">
					<label for="book_name" class="form-label">도서명</label> <input
						type="text" class="form-control" id="book_name" name="book_name"
						value="${book.book_name}">
				</div>
				<div class="col-md-6">
					<label for="publication_date" class="form-label">발행일</label> <input
						type="text" class="form-control" id="publication_date"
						placeholder="YYYY-MM-DD 형식으로 입력" name="publication_date"
						value="${book.publication_date}">
				</div>
				<div class="col-md-6">
					<label for="author" class="form-label">저자</label> <input
						type="text" class="form-control" id="author" name="author"
						value="${book.author}">
				</div>
				<div class="col-md-6">
					<label for="publisher" class="form-label">출판사</label> <input
						type="text" class="form-control" id="publisher" name="publisher"
						value="${book.publisher}">
				</div>
				<div class="col-md-6">
					<label for="page" class="form-label">페이지</label> <input
						type="number" class="form-control" id="page" name="page"
						value="${book.page}">
				</div>
				<div class="col-md-6">
					<label for="category" class="form-label">카테고리</label> <input
						type="text" class="form-control" id="category"
						placeholder="만화, 소설, 그 외..." name="category"
						value="${book.category}">
				</div>
				<div class="col-12">
					<label for="book_intro" class="form-label">도서 설명</label>
					<textarea class="form-control" id="book_intro" rows="10"
						name="book_intro">${book.book_intro}</textarea>
				</div>
				<div class="col-12">
					<label for="file" class="form-label">이미지 파일</label> <input
						class="form-control" type="file" id="file" name="file">
				</div>
			</form>
			<div class="col-12 write_btn">
				<a onclick="chkForm(); return false;" class="btn btn-primary" role="button">수정</a> <a
					class="btn btn-secondary" href="view?book_no=${book.book_no}" role="button">취소</a>
			</div>
		</main>
	</div>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>