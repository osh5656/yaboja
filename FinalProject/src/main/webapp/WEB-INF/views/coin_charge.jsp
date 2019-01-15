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
		<a href=""><strong>Movie Board</strong></a> <a href=""><strong>Matching
				Board</strong></a> <a href=""><strong>Review Board</strong></a> <a href=""><strong>Q&A
				Board</strong></a> <a href=""><strong>My Page</strong></a>
		<div class="nav-underline"></div>
	</nav>

	<!-- mypagesidebar -->
	<%@ include file="inc/mypagesidebar.jsp"%>
	<br>
	<br>
	<div class="layout-container">
		<div id="main">
			<!-- sidebar를 include해준다. -->
			<div class="form">
				<div class="container container-fluid"></div>
				<div class="container container-fluid">
					<h2 style="">결제하기</h2>
					<div class="jumbotron jumbotron-fluid">
							<table>
								<tr>
									<th>ID ${userDto.id }123
								</tr>
								<tr>
									<th>COIN ${coinDto.coin }123coin
								</tr>
							</table>
					</div>
				</div>
			</div>
		</div>
	</div>
		<hr class="my-4">
	<div class="container">
		<div class="col-md-8 order-md-1">
			<form class="needs-validation" method="post"
				action="controller.do?category=POINT_CHARGE" name="payment"
				onSubmit="return CheckForm(this)">
				<div class="form-group">
					<label for="point">충전 금액</label> <select
						class="form-control form-control-lg" name="point_val">
						<option value="">충전할 금액을 선택해주세요.</option>
						<option value="5000">5000(10coin)</option>
						<option value="10000">10000(20coin)</option>
						<option value="20000">15000(30coin)</option>
						<option value="30000">20000(40coin)</option>
						<option value="50000">25000(50coin)</option>
					</select>
				</div>
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="paymentCheck"
					name="paymentCheck"> <label class="form-check-label"
						for="paymentCheck">포인트 충전 결제 진행에 동의합니다.</label>
				</div>
				<img alt="" src="">
				<button type="submit" class="btn btn-default pull-right">카카오결제하기</button>
			</form>
			</br> </br>

		</div>
	</div>

	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>



</body>

</html>
