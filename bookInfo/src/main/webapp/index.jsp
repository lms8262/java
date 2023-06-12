<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
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
		<main class ="index_main">
			<nav class="nav nav-pills nav-justified main_tab">
				<a class="nav-link active" aria-current="page" href="#">전체</a> <a
					class="nav-link" href="#">만화</a> <a class="nav-link" href="#">소설</a>
				<a class="nav-link" href="#">기타</a>
			</nav>
			<div class="row book_list">
				<div class="col-3 card-group">
					<div class="card book">
						<img src="img/no_image.gif" class="card-img-top" alt="...">
						<div class="card-body">
							<h3 class="card-title">제목</h3>
							<a href="#" class="btn btn-dark">상세정보 보기</a>
						</div>
					</div>
				</div>
			</div>
		</main>
		<footer>
			<div></div>
		</footer>
	</div>
</body>
</html>