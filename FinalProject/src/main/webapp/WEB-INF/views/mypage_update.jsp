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
		<h1>MY PAGE</h1>

		<div>
			<table border="1" class="table table-hover">
			<tr>
				<th style = "width : 178px;">ID</th>
				<td>내 아이디</td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td>비밀번호</td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td>비밀번호 확인</td>
			</tr>
			<tr>
				<th>NAME</th>
				<td>이름</td>
			</tr>
			<tr>
				<th>SEX</th>
				<td>성별</td>
			</tr>
			<tr>
				<th>AGE</th>
				<td>나이</td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td>이메일</td>
			</tr>
			<tr>
				<th><label for ="theater" style="float:left">REGISTERED THEATER</label></th>
				<th colspan = "3">
				<select id ="theater" name="theater" size ='1'>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
				</select>
				<select id ="theater" name="theater" size ='1'>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
				</select>
				<select id ="theater" name="theater" size ='1'>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
				</select>
<!-- 				<input type="button" value="2" onclick="" class = "btn btn"/> -->
<!-- 				<input type="button" value="3" onclick="" class = "btn btn"/> -->
				</th>
			</tr>
			<tr>
				<td colspan="2" align = "right">
					<input type="submit" value="수정" class = "btn btn-default" />
					<input type="button" value="취소" onclick="" class = "btn btn-default"/>
				</td>
			</tr>
			</table>
		</div>
		
	</div>


	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>



</body>

</html>
