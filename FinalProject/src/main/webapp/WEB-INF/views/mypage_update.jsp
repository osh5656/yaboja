<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
   function PwSameCheck(PW){
      var pw1 = document.getElementById("pw1").value;
      var pw2 = document.getElementById("pw2").value;
      
      if(pw1 != pw2){
         document.getElementById("notsame").innerHTML = "비밀번호가 일치하지 않습니다.";
         return false;
      }else if(pw1 = pw2){
         location.href="mypage.do";
         return true;
      }
   }
   </script>

</head>

<body>


   <!-- Navigation -->
   <%@ include file="inc/topbar.jsp"%>


  <c:choose>
		<c:when test="${dto.usergrade eq 'admin'}">
			<nav class="nav2" style="margin-top: 60px; margin-bottom: 20px;">
			<!-- 메뉴바 -->
			<a href="movieBoard.do"><strong>Movie Board</strong></a> 
			<a href="matchingboardlist.do"><strong>Matching Board</strong></a> 
			<a href="reviewBoard.do"><strong>Review Board</strong></a> 
			<a href="qnaboard.do"><strong>Q&A Board</strong></a> 
			<a href="adminPreferences.do"><strong>preferences</strong></a>
			<div class="nav-underline"></div>
			</nav>		
		</c:when>
		<c:otherwise>
			<nav class="nav2" style="margin-top: 60px; margin-bottom: 20px;">
			<!-- 메뉴바 -->
			<a href="movieBoard.do"><strong>Movie Board</strong></a> 
			<a href="matchingboardlist.do"><strong>Matching Board</strong></a> 
			<a href="reviewboard.do"><strong>Review Board</strong></a> 
			<a href="qnaboard.do"><strong>Q&A Board</strong></a> 
			<a href="mypage.do"><strong>My Page</strong></a>
			<div class="nav-underline"></div>
			</nav>		
		</c:otherwise>
	</c:choose>

   <!-- mypagesidebar -->
   <%@ include file="inc/mypagesidebar.jsp"%>

   <!-- 마이페이지 부분 소스는 여기부터 작성!! -->
   </br>
   </br>
   <div class="container">
      <h1>MY PAGE</h1>
   <form action="mypage_update.do" method="post" onsubmit="return PwSameCheck()">
   <table class="table">
   <%-- <tr>
      <td rowspan="9" width="150px;" height="170px;" align="center">
      <img alt="프로필 사진" src=${dto.profile } style="width: 150px;height: 170px;">
      </td>
   </tr> --%>
   <tr>
      <th>아이디</th>
      <td><input name="userid" value="${dto.userid }" readonly="readonly"/></td>
   </tr>
   <tr>
      <th>비밀번호</th>
      <td><input type="password" name="userpw" id="pw1" value="${dto.userpw }"/></td>
   </tr>
   <tr>
      <th>비밀번호확인</th>
      <td><input type="password" id="pw2"/></td>
      <th id="notsame" style="color:red;">
   </tr>
   <tr>
      <th>이름</th>
      <td><input name="username" value="${dto.username }" /></td>
   </tr>
   <tr>
      <th>이메일</th>
      <td><input name="useremail" value="${dto.useremail }" readonly="readonly"/></td>
   </tr>
   <tr>
      <th>성별</th>
      <td>
         <input type="radio" id="man" name="usersex" value="남"/><label for="man">남</label>
         <input type="radio" id="woman" name="usersex" value="여"/><label for="woman">여</label>
      </td>
   </tr>
   <tr>
      <th>연령대</th>
      <td>
         <input type="radio" id="10" name="userage" value="10"/><label for="10">10</label>
         <input type="radio" id="20" name="userage" value="20"/><label for="20">20</label>
         <input type="radio" id="30" name="userage" value="30"/><label for="30">30</label>
         <input type="radio" id="40" name="userage" value="40"/><label for="40">40</label>
         <input type="radio" id="50" name="userage" value="50"/><label for="50">50</label>
      </td>
   </tr>
   <tr>
      <th>주소</th>
      <td><input type="text" name="useraddress" value="${dto.useraddress }"/></td>
   </tr>
   <%-- <tr>
      <th>애용관1</th>
      <td><input name="theater1" value="${dto.theater1 }"></td>
   </tr>
   <tr>
      <th>애용관2</th>
      <td><input name="theater2" value="${dto.theater2 }"></td>
   </tr>
   <tr>
      <th>애용관3</th>
      <td><input name="theater3" value="${dto.theater3 }"></td>
   </tr> --%>
   </table>
   <input type="button" value="취소" class="btn btn-default pull-right"/>
   <input type="submit" value="수정" class="btn btn-default pull-right"/>
   </form>
      
   </div>


   <!-- Footer -->
   <%@ include file="inc/footer.jsp"%>



</body>

</html>