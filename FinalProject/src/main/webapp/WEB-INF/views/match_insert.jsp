<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- <html lang="en"> -->

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

.font-test { font:bold 24pt 'HY나무M'; }

</style>

<script type="text/javascript">
function inputConfirm(){
	var x = document.getElementsByName("title")[0].value;
// 	alert(x);
	if(x=="" || x==" "){
		alert('제목을 입력해주세요');
	}
	//내용, 영화명, 영화관 유효성검사 (else if로 추가)
	else{
		//모든사항 누락 없을 시에
		alert('정상적으로 매칭게시글이 입력되었습니다.');
		location.href='match_list.jsp';
	}
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
	
	<br>
	<br>
	<div class = "container" >
	<h1 style="color:black; font-weight: bold;">매칭글 작성하기</h1>
	<br>
	<form id="" method ="post" action ="" name ="">
	<table border ="1" class= "table table-bordered">
		<tr align ="center">
			<th width ="70px">이름</th>
			<td width ="120px">김민엽</td>
			<td rowspan ="2" width="120px"><div style="width=150px; height=200px;">사진</div></td>
			<td width ="100px">
			<label for= "theater" style="float:left">영화관 선택</label>
			</td>
			<th width ="100px">게시날짜</th>
		</tr>
		<tr align ="center">
			<th>연령대</th>
			<td>20후반</td>
			<td>
				<select id = "theater" name ="theater" size='1'>
					<option value="서울">--- 서울 ---</option>
					<option value="강남CGV">강남CGV</option>
					<option value="역삼CGV">역삼CGV</option>
					<option value="사당CGV">사당CGV</option>
					<option value="잠실CGV">잠실CGV</option>
					<option value="문정CGV">문정CGV</option>
					<option value="경기">--- 경기 ---</option>
					<option value="범계CGV">범계CGV</option>
				</select>
			</td>
			<td>20190106</td>
			
		
		</tr>
		<tr align ="center">
			<th>제목</th>
			<td colspan = "2"><input name="title" type="text" class="form-control" placeholder="제목을 입력하세요" name="title" maxlength="50"></td>
			<td>
				<label for= "moviename" style="float:left">영화선택</label>
				
			</td>
			<td>
				<select id = "moviename" name ="moviename" size='1'>
					<option value="아쿠아맨">아쿠아맨</option>
					<option value="도어락">도어락</option>
					<option value="분노의 질주">분노의 질주</option>
					<option value="언니">언니</option>
					<option value="완벽한 타인">완벽한타인</option>
				</select>
			</td>
		</tr>
		<tr align ="center">
			<td colspan = "5" style="color:navy; font-weight: bold; font-size: 1.5em;">★ 어디서든 외롭지않게 야! 보자 ★</td>
			
		</tr>
		<tr align ="center">
			<td colspan = "5">
				<textarea rows="30" cols="100%" >내용을 입력하세요
				</textarea>
			</td>
			
		</tr>
		<tr align = "right">
			
			<td colspan = "5">
				<input type ="button" value ="취소" class="btn btn default" onclick = "location.href='match_list.jsp'"/>
				<input type ="button" value ="글 작성하기" class="btn btn default" class="glyphicon glyphicon-heart" onclick = "inputConfirm()"/>
			</td>
			
		</tr>
	</table>
	
	
	</form>
</div>
	
	

	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>

	

</body>

</html>
