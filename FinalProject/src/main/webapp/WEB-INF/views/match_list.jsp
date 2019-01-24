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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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

.font-test { font:bold 24pt 'HY나무M'; }

</style>
	
	

</head>
<script type="text/javascript">
function searchclick(){
	var x = document.getElementsByName("keyword")[0].value;
// 	alert(x);
	if(x=="" || x==" "){
		alert('검색어를 입력해주세요');
	}
	else{
		alert('확인');
	}
	
function boardlist(){
	var x = document.getElementsByName("listsize").value;
	alert(x);
}
}

</script>

<body>


	<!-- Navigation -->
	<%@ include file="inc/topbar.jsp"%>


	<!-- Menu Bar -->
	<nav class="nav2" style="margin-top: 60px; margin-bottom: 20px;">
		<!-- 메뉴바 -->
		<a href=""><strong>Movie Board</strong></a> <a href="matchingboardlist.do"><strong>Matching
				Board</strong></a> <a href=""><strong>Review Board</strong></a> <a href=""><strong>Q&A
				Board</strong></a> <a href=""><strong>My Page</strong></a>
		<div class="nav-underline"></div>
	</nav>
	
	<!-- moviesidebar -->
	<%@ include file="inc/moviesidebar.jsp"%>
	
	<!-- 영화매칭관련 페이지들 소스는 여기부터 작성!! -->
	
<div id ="context"  class = "container">
<br>
<br>
<h1 style="color:black; font-weight: bold;"> 매칭 게시판 </h1>

<div align ="right">

  <input type= "text" name ="keyword" placeholder="검색어를 입력하세요" ></input>
  <input onclick ="searchclick()" type="button" value="검색" class="btn btn default" />
<!--   <input type= "submit" value ="검색" class="btn btn default" onclick ='searchclick()'> -->

<input type="button" value="매칭만들기" class="btn btn default" onclick = "location.href='matchingForm.do'"/>


</div>
<br>
     
<table border = 1 class= "table table-bordered">
	<tr align ="center">
		<th width ="100px">작성자</th>
		<th width ="300px">제 목</th>
		<th width ="70px">성 별</th>
		<th width ="70px">연 령</th>
		<th width ="150px">영화관</th>
		<th width ="200px">영 화</th>
		<th width ="100px">날 짜</th>
		
	</tr>
	
	<c:choose>
		<c:when test="${empty matchingboardlist1 }">
			<h3>----등록된 매칭글이 없습니다----</h3>
		</c:when>
		<c:otherwise>
			<c:forEach var="i" begin="0" end="${listsize }">
					
				<tr align = "center">
					<td><c:out value="${matchingboardlist2[i].username }" /></td> 
					<td><a href ="matchingboardselectone.do?matchingboard=${matchingboardlist1[i].matchingboard }"><c:out value="${matchingboardlist1[i].matchingboardtitle }" /></a></td>
					<td><c:out value="${matchingboardlist2[i].usersex }" /></td>
					<td><c:out value="${matchingboardlist2[i].userage }" /></td>
					<td><c:out value="${matchingboardlist4[i].cinema }" /></td>
					<td><c:out value="${matchingboardlist3[i].movietitle }" /></td>
					<td><c:out value="${matchingboardlist1[i].matchingboarddate }"/></td>
					
			</tr>
			</c:forEach>
			
		</c:otherwise>
	
	</c:choose>
<%

%>
</table> 
<nav aria-label="..." style="text-align: center;">
      <ul class="pagination" id="pasing">페이징</ul>
   </nav>
</div>
	

	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>

	

</body>

</html>
