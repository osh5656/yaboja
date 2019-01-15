<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
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

<!-- Theme CSS -->
<link href="css/clean-blog.min.css" rel="stylesheet">

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

	<!-- mypagesidebar -->
	<%@ include file="inc/mypagesidebar.jsp"%>

	<!-- 마이페이지 부분 소스는 여기부터 작성!! -->
	</br>
	</br>
	<div class="container">
		<div align="right">
			<input type="button" name="btn1" value="매칭하러가기" class="btn btn-default" />
		</div>
		<h1>아쿠아맨</h1>
		<h3>AQUAMAN,2018</h3>
		</br>

		<div align="left">
			<table border="1" class="table table-hover">
				<tr>
					<td rowspan="5" style="width: 168px;"><img
						src="img/aquaman.JPG" width="200" height="300"></td>
					<td>개요 | 액션, 모험 , SF | 미국,오스트레일리아 | 143분 | 2018.12.19 개봉</td>
				</tr>

				<tr>
					<td>감독 제임스 완</td>
				</tr>
				<tr>
					<td>출연 제이슨 모모아(아서커리/ 아쿠아맨), 앰버 허드(메라) ...</td>
				</tr>
				<tr>
					<td>등급 [국내]12세 관람가 [해외] PG-13</td>
				</tr>
				<tr>
					<td>흥행 예매율 5위 | 누적관객 4,664,447명</td>
				</tr>

			</table>
		</div>
		</br> </br>

		<div>
			<h1>한줄 평</h1>
		</div>

		<div>
			<form action="" method="post">
				<input type="hidden" name="" value="" />
				<table border="1" class="table table-hover">
					<tr>

						<td><textarea rows="5" cols="120" name=""></textarea></td>
						<td colspan="2"><input type="submit" value="작성" class= "btn btn-default"  style="height:110px;"></td>
					</tr>

				</table>
			</form>
		</div>
		<div>
			<c:choose>
				<c:when test="${empty list  }">
					<h3>작성된 댓글이 없습니다.</h3>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<th>id</th>
							<th>날짜</th>
							<th>이름</th>
							<th>내용</th>
						</tr>

						<c:forEach var="dto" items="${list }">
							<tr>
								<td>${dto.id }</td>
								<td>${dto.date }</td>
								<td>${dto.name }</td>
								<td>${dto.content }</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>

		</div>
	</div>

	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>



</body>

</html>
