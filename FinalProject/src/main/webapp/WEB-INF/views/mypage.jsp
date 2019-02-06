<%@page import="com.yaboja.dto.MovieDto"%>
<%@page import="com.yaboja.dto.UserDto"%>
<%@page import="com.yaboja.dto.ReviewboardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<ReviewboardDto> boardlist = (List)request.getAttribute("boardlist");
UserDto userDto = (UserDto)session.getAttribute("dto");
List<MovieDto> moviedto = (List)request.getAttribute("moviedto");
%>
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
<script type="text/javascript">
	function userDelete() {
		alert("탈퇴하시겠습니까?");
		document.location.href = "userDelete.do";
	}
</script>
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
	<br>
	<br>
	<div class="layout-container">
		<div id="main">
			<!-- sidebar를 include해준다. -->
			<div class="form">
				<div class="container container-fluid"></div>
				<div class="container container-fluid">
					<h2>내 정보</h2>
					<div class="jumbotron jumbotron-fluid">
						<form action="mypage_updateform.do" method="post">
							<input type="hidden" name="userseq" value="${dto.userseq }" />
							<table>
								<tr>
								<td rowspan="11" width="150px;" height="170px;" align="center">
									<label>PROFILE</label>
									<img alt="프로필 사진" src=${dto.userprofile } style="width: 150px;height: 170px;">
								</td>
								</tr>
								<tr align="center">
									<td rowspan="10" width="100px"></td>
								</tr>
								<tr>
									<th><label>ID</label>
									<td><input readonly="readonly" name="userid"
										value="${dto.userid }" class="form-control"></td>
								</tr>
								<tr>
									<th><label>NAME</label>
									<td><input readonly="readonly" name="username"
										value="${dto.username }" class="form-control"></td>
								</tr>
								<tr>
									<th><label>EMAIL</label>
									<td><input readonly="readonly" name="useremail"
										value="${dto.useremail }" class="form-control"></td>
								</tr>
								<tr>
									<th><label>SEX</label>
									<td><input readonly="readonly" name="usersex"
										value="${dto.usersex }" class="form-control"></td>
								</tr>
								<tr>
									<th><label>AGE</label>
									<td><input readonly="readonly" name="userage"
										value="${dto.userage }" class="form-control"></td>
								</tr>
								<tr>
									<th><label>ADDRESS</label>
									<td><input readonly="readonly" name="useraddress"
										value="${dto.useraddress }" class="form-control"></td>
								</tr>
								<tr>
									<th><label>CINEMA1</label>
									<td><input readonly="readonly" name="usercinema1"
										value="${cinemadto1.cinema }" class="form-control"></td>
								</tr>
								<tr>
									<th><label>CINEMA2</label></th>
									<td><input readonly="readonly" name="usercinema2"
										value="${cinemadto2.cinema}" class="form-control"></td>
								</tr>
								<tr>
									<th><label>CINEMA3</label>
									<td><input readonly="readonly" name="usercinema3"
										value="${cinemadto3.cinema }" class="form-control"></td>
								</tr>
							</table>
							<input type="button" class="btn btn-danger pull-right" value="탈퇴"
								onclick="userDelete()"> <input type="submit"
								class="btn btn-default pull-right" value="내 정보 수정">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr class="my-4">
	<div class="layout-container">
		<div id="main">
			<!-- sidebar를 include해준다. -->
			<div class="form">
				<div class="container container-fluid">
					<h2>내 게시글</h2>
				</div>
				<div class="container container-fluid">
					<div class="jumbotron jumbotron-fluid">
						<table class="table table-hover">
							<thead align="center">
								<tr>
									<th>글번호
									<th>제목
									<th>작성자
									<th>날짜
									<th>조회수
								</tr>
							</thead>
<%
				if(boardlist.size() == 0){
%>
							<tr>
								<td colspan="5" align="center">----작성된 글이 존재하지 않습니다----</td>
							</tr>
<%
				} else{
					for(int i = 0 ; i < boardlist.size() ; i++){
%>
							<tr>
								<td><%= boardlist.get(i).getReviewboardseq()%></td>
								<td><a href="review_detail.do?reviewboardseq=<%= boardlist.get(i).getReviewboardseq()%>">[<%=moviedto.get(i).getMovietitle() %>] <%=boardlist.get(i).getReviewboardtitle() %></a></td>
								<td><%= dto.getUsername() %></td>
								<td><%= boardlist.get(i).getReviewboarddate() %></td>
								<td><%= boardlist.get(i).getReviewboardview() %></td>
							</tr>
<%
					}
				}
%>							

						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>

</body>

</html>
