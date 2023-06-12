<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
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
			<h2>신규 도서 정보 등록</h2>
			<form class="row g-3" name="frm" method="post" action="insert"
				enctype="multipart/form-data">
				<div class="col-md-6">
					<label for="book_name" class="form-label">도서명<span>(필수)</span></label>
					<input type="text" class="form-control" id="book_name"
						name="book_name">
				</div>
				<div class="col-md-6">
					<label for="publication_date" class="form-label">발행일</label> <input
						type="text" class="form-control" id="publication_date" placeholder="YYYY-MM-DD 형식으로 입력"
						name="publication_date">
				</div>
				<div class="col-md-6">
					<label for="author" class="form-label">저자<span>(필수)</span></label>
					<input type="text" class="form-control" id="author" name="author">
				</div>
				<div class="col-md-6">
					<label for="publisher" class="form-label">출판사</label> <input
						type="text" class="form-control" id="publisher" name="publisher">
				</div>
				<div class="col-md-6">
					<label for="page" class="form-label">페이지</label> <input
						type="number" class="form-control" id="page" name="page">
				</div>
				<div class="col-md-6">
					<label for="category_no" class="form-label">카테고리 번호<span>(필수)</span></label>
					<input type="number" class="form-control" id="category_no"
						placeholder="100(만화), 200(소설), 300(기타)" name="category_no">
				</div>
				<div class="col-12">
					<label for="book_intro" class="form-label">도서 설명<span>(필수)</span></label>
					<textarea class="form-control" id="book_intro" rows="10"
						name="book_intro"></textarea>
				</div>
				<div class="col-12">
					<label for="img" class="form-label">이미지</label> <input
						class="form-control" type="file" id="img" name="img">
				</div>
				<div class="col-12 write_btn">
					<a class="btn btn-primary" href="#" role="button">등록</a> <a
						class="btn btn-secondary" href="#" role="button">취소</a>
				</div>
			</form>
		</main>
		<footer>
			<div></div>
		</footer>
	</div>
</body>
</html>