<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>야보자</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Menu Bar -->
<link href="css/menubar.css" rel="stylesheet">
<!-- Content -->
<link href="css/index_content.css" rel="stylesheet">
<!-- jQuery -->
<script src="vendor/jquery/jquery.min.js"></script>

</head>

<body>

	<!-- Navigation -->
	<%@ include file="inc/topbar.jsp"%>


	<!-- Menu Bar -->
	<nav class="nav2" style="margin-top: 60px; margin-bottom: 20px;">
		<!-- 메뉴바 -->
		<a href=""><strong>Movie Board</strong></a> <a href=""><strong>Matching
				Board</strong></a> <a href=""><strong>Review Board</strong></a> <a href=""><strong>Q&A
				Board</strong></a> <a href=""><strong>My Page</strong></a>
		<div class="nav-underline"></div>
	</nav>

	<!-- 영화매칭, 마이페이지말고는 여기부터 소스 넣으면 돼!!! -->
	<%-- <jsp:include page="sidebar.jsp"/> --%>
	<div class="container">
		<h2>후기게시판</h2>
		<form action="reviewInsert.jsp">
			<div align="right">
				<input type="text" class="control">
				<input type="submit"value="검색" class="btn btn-default"></input> 
				<input type="submit" value="글쓰기"class="btn btn-default">
			</div>
			<br>
			<table border="1" class="table table-hover">
				<thead align="center">
					<tr>
						<th>글번호
						<th>제목
						<th>작성자
						<th>날짜
						<th>조회수
					</tr>
				</thead>
				<%-- <c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="4">----작성된 글이 존재하지 않습니다----</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="dto" items="${list }">
						<tr>
							<td>${dto.seq }</td>
							<td>${dto.writer }</td>
							<td><a href="boarddetail.jts?seq=${dto.seq }">${dto.title }</a></td>
							<td>${dto.regdate }</td>					
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose> --%>
				<tbody>
					<tr>
						<td>${boardDto.board_seq }123</td>
						<td>${boardDto.board_title }123</td>
						<td>${userDto.user_name }123</td>
						<td>${boardDto.board_regdate }123</td>
						<td>${boardDto.view_count }123</td>
					</tr>
					<tr>
						<td>${boardDto.board_seq }123</td>
						<td>${boardDto.board_title }123</td>
						<td>${userDto.user_name }123</td>
						<td>${boardDto.board_regdate }123</td>
						<td>${boardDto.view_count }123</td>
					</tr>
				</tbody>
			</table>
		</form>
		<nav aria-label="..." style="text-align: center;">
			<ul class="pagination" id="pasing"><- 1 2 3 4 5 6 7 8 9 -></ul>
		</nav>
	</div>


	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>



</body>

</html>
