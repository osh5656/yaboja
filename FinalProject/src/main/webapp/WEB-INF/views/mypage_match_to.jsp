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

<script type="text/javascript">

function deletecheck() {
	if(confirm("신청한 매칭을 삭제하시겠습니까?")){
		var matchingseq = document.getElementById('matchingseq').value;
		location.href='matchingdelete.do?matchingseq='+matchingseq;

		alert('삭제되었습니다');
		
	}else{
		alert('잘해보세요');
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
		<a href=""><strong>Movie Board</strong></a> <a href=""><strong>Matching
				Board</strong></a> <a href=""><strong>Review Board</strong></a> <a href=""><strong>Q&A
				Board</strong></a> <a href=""><strong>My Page</strong></a>
		<div class="nav-underline"></div>
	</nav>

	<!-- mypagesidebar -->
	<%@ include file="inc/mypagesidebar.jsp"%>

	<!-- 마이페이지 부분 소스는 여기부터 작성!! -->
	<br/>
	<br/>
	<input type="hidden" id="matchingseq" value="${ matchingdto.matchingseq}"/>
	<div class="container">
		<div>
			<h1>마이페이지_매칭관리</h1>
		</div>
		<br/> <br/>
		<div>
			<h3>신청한 매칭</h3>
		</div>
		
		<c:choose>
			<c:when test="${empty matchingdto }">
			<br/>
			<h4>------------------------------신청한 매칭이 없습니다------------------------------</h4>
			</c:when>
			<c:otherwise>
		<div align ="center">
			<h3>-----------------------------------------<fmt:formatDate pattern =" yyyy-MM-dd " value ="${matchingdto.matchingdate}" />-----------------------------------------</h3>
		</div>
		<br/>
		<table border="1" class="table table-hover">
			<tr>
				<td style="width: 88px;" rowspan="2"><c:out value="${writerUser.userprofile }" /></td>
				<td><c:out value="${writerUser.username }" /></td>
				<td rowspan="2" style="width: 98px;" align="center"><input
					type="button" value="취소" onclick="deletecheck()" class="btn btn-default"></td>
			</tr>
			<tr>
				<td><c:out value="${matchingboarddto.matchingboardtitle }" /></td>
			</tr>
		</table>
		</c:otherwise>
		</c:choose>
		
		</br>

	</div>




	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>



</body>

</html>
