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

<!-- <!-- Theme CSS --> -->
<!-- <link href="css/clean-blog.min.css" rel="stylesheet"> -->

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
	
<style type="text/css">

body { font-family:'HY나무M'; }

.font-test { font:bold 28pt 'HY나무M'; }

</style>
<script type="text/javascript">
	function matching(){
		//coin>0
		alert('매칭신청하시겠습니까? 상대방 수락시 1코인이 차감됩니다.');
		//coin=0
// 		alert('매칭에 필요한 코인이 부족합니다. 충전화면으로 이동합니다.' );
// 		location.href='mypage_coin.jsp'
		
		
	}
</script>	
</head>

<body>


	<!-- Navigation -->
	<%@ include file="inc/topbar.jsp"%>


	<!-- Menu Bar -->
	<nav class="nav2" style="margin-top: 60px; margin-bottom: 20px;">
		<!-- 메뉴바 -->
		<a href=""><strong>Movie Board</strong></a> <a href="match_list.jsp"><strong>Matching
				Board</strong></a> <a href=""><strong>Review Board</strong></a> <a href=""><strong>Q&A
				Board</strong></a> <a href=""><strong>My Page</strong></a>
		<div class="nav-underline"></div>
	</nav>
	
	<!-- moviesidebar -->
	<%@ include file="inc/moviesidebar.jsp"%>
	
	<!-- 영화매칭관련 페이지들 소스는 여기부터 작성!! -->
	
	<div class ="container">
	<br><br>
	<h1 style="color:black; font-weight: bold;">작성자 프로필</h1>
	<div style="color:black; background-color:silver; padding:50px; margin:30px">
		
		<table border = "1" class= "table table-bordered" style="color:black; font-size: 1.2em;">
			<tr>
				<td rowspan ="4" width="150px"> 사진(이미지)</td>
			</tr>
			<tr align ="center" >
				<th width ="200px">이 름</th>
				<td width ="200px">김민엽</td>
			</tr>
			<tr align ="center">
				<th>성 별</th>
				<td>남 자</td>
			</tr>
			<tr align ="center">
				<th>연령대</th>
				<td>20후반</td>
			</tr>
		</table>	
	</div>
	<table border ="1" class= "table table-bordered" >
		<tr>
			<td bgcolor="skyblue">제목</td>
			<td>같이영화보아아아아요</td>
			<td bgcolor="skyblue">등록일시</td>
			<td>2019.01.10</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">영화명</td>
			<td>바람과 함께 사라지다</td>
			<td bgcolor="skyblue">영화관</td>
			<td>역삼CGV</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">내용</td>
			<td colspan="3">1월 11일 오후 7시 30분타임꺼 같이보실분괌
							영화는 내가 삼 여자만환영 망설이지말고 신청고고
							<br>
							<div align ="right"><button onclick="matching()" class ="btn btn default">매칭신청하기</button></div>
							
							</td>
							
		</tr>

	</table>	
		<div align ="center">
		<button class ="btn btn default" onclick ="location.href='match_update.jsp'">수정</button><!-- 작성자만 -->
		<button class ="btn btn default" onclick ="location.href='match_list.jsp'">목록</button></div>
	
		<br>
</div>
	

	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>

	

</body>

</html>
