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
		<a href=""><strong>Movie Board</strong></a> 
		<a href=""><strong>Matching Board</strong></a> 
		<a href="reviewBoard"><strong>Review Board</strong></a> 
		<a href=""><strong>Q&A Board</strong></a> 
		<a href="myPage"><strong>My Page</strong></a>
		<div class="nav-underline"></div>
	</nav>

	<!--adminsidebar -->
	<%@ include file="inc/adminSidebar.jsp"%>
	<!-- 내부jsp -->
	<br>
	<div class="container">
		<h2>회원관리</h2>
		<form action="#">
			<div align="right">
				<input type="text" class="control">
				<input type="submit"value="검색" class="btn btn-default"></input> 
			</div>
			<br>
			<table border="1" class="table">
				<thead align="center">
					<tr>
						<th>ID
						<th>NAME
						<th>GENDER
						<th>AGE
						<th>ADDRESS
						<th>E-MAIL
						<th>처리
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${userDto.user_id }id</td>
						<td>${userDto.user_name }name</td>
						<td>${userDto.user_gender }gender</td>
						<td>${userDto.user_age }20초</td>
						<td>${userDto.user_address }서울시 강남구</td>
						<td>${userDto.user_email }12345@67890</td>
						<td><button class="btn btn-default">탈퇴</button></td>
					</tr>
					<tr>
						<td>${userDto.user_id }id</td>
						<td>${userDto.user_name }name</td>
						<td>${userDto.user_gender }gender</td>
						<td>${userDto.user_age }20초</td>
						<td>${userDto.user_address }서울시 강남구</td>
						<td>${userDto.user_email }12345@67890</td>
						<td><button class="btn btn-default">탈퇴</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>



</body>

</html>
