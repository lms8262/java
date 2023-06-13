<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<c:if test="${bookList == null && error == null}">
		<jsp:forward page="list" />
	</c:if>
	<div class="wrap">
		<header>
			<nav class="navbar bg-body-tertiary" data-bs-theme="dark">
				<div class="container-fluid">
					<a class="navbar-brand navbar_title" href="index.jsp">도서 정보 사이트</a>
				</div>
			</nav>
		</header>
		<main class="index_main">
			<div class="col-12 write_btn">
				<a class="btn btn-primary" role="button" href="write">도서 정보 추가</a>
			</div>
			<nav class="nav nav-pills nav-justified main_tab">
				<a class="nav-link all" aria-current="page" href="list">전체</a> <a
					class="nav-link comic" href="list?listCategory=comic">만화</a> <a
					class="nav-link novel" href="list?listCategory=novel">소설</a> <a
					class="nav-link etc" href="list?listCategory=etc">기타</a>
			</nav>
			<div class="row book_list">
				<c:forEach var="book" items="${bookList}" varStatus="status">
					<div class="col-3 card-group">
						<div class="card book">
							<c:if test="${book.img == null || book.img == ''}">
								<img src="/img/no_image.gif" class="card-img-top" alt="이미지 없음">
							</c:if>
							<c:if test="${book.img != null && book.img != ''}">
								<img src="${book.img}" class="card-img-top" alt="도서 이미지">
							</c:if>
							<div class="card-body">
								<h3 class="card-title">${book.book_name}</h3>
								<a href="view?book_no=${book.book_no}" class="btn btn-dark">상세정보
									보기</a>
							</div>
						</div>
					</div>
				</c:forEach>
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
</body>
</html>