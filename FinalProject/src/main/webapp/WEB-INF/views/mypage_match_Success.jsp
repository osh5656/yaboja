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
	<br><br>
	<div class="container">
	<h1 style="color:black; font-weight: bold;">진행중매칭</h1>
	<div style="color:black; background-color:silver; padding:20px; margin:10px">

<table border = "1" class ="table table-bordered">
	<tr align="center">
		<td style="width:150px; height:20px;">
		<h3 style="font-weight: bold;">★</h3>
		</td>
		<td>
		<h3 style="font-weight: bold;">♥ 강남CGV ♥</h3>
		</td>
		<td style="width:150px; height:20px;">
		<h3 style="font-weight: bold;">★</h3>
		</td>
	</tr>
	<tr align = "center"  valign="bottom">	
		<td style="width:150px; height:200px;">	
			<img src = "img/lch.PNG" width ="150px" height="200px"/> <!-- 본인 사진사이즈 설정 -->
		</td>	
		<td style="width:150px; height:200px;">	
<!-- 			<span style = "font-size : 20px;"></span><br> -->
			<img src = "img/home-bg-1.jpg"  width ="150px" height="200px"/>
		</td>
		<td>
			<img src = "img/osh.PNG" width ="150px" height="200px"/> <!-- 매칭상대 사진사이즈 설정 -->
		</td>
	</tr>
	<tr align ="center" valign ="middle">
		<td>
			김민엽
		</td>
		<td rowspan="3">
			<button class= "btn btn default">채팅방입장하기</button>
		</td>
		<td>
			오세현
		</td>
	</tr>
	<tr align ="center">
		<td>
			20대후반
		</td>
	
		<td>
			30대초반
		</td>
	</tr>
	<tr align ="center">
		<td>
			남
		</td>
	
		<td>
			여
		</td>
	</tr>
</table>
</div>
</div>
	
</body>

	
	
	
	

	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>

	

</body>

</html>
