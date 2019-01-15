<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
</head>

<body>


	<!-- Navigation -->
	<%@ include file="inc/topbar.jsp"%>


	<!-- joinCheck -->
	<br><br><br><br><h1 align="center">회원가입</h1><br><br>

	<!-- Main Join Form -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<hr>
				<form name="joinform" id="contactForm" novalidate>
					<!-- id -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>ID</label> <input type="text" class="form-control"
								placeholder="ID" id="id">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<!-- password -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Password</label> <input type="password"
								class="form-control" placeholder="Password" id="password">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<!-- passwordchk -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Password Check</label> <input type="password"
								class="form-control" placeholder="Password Check"
								id="passwordcheck">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<!-- name -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Name</label> <input type="text" class="form-control"
								placeholder="Name" id="name">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<!-- profile -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Profile</label> <input type="file" class="form-control"
								placeholder="" id="profile">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<!-- sex -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Sex</label>
							<p class="help-block text-danger"></p>
							<label class="radio-inline"> <input type="radio"
								name="gender_male" checked>Male
							</label> <label class="radio-inline"> <input type="radio"
								name="gender_female">Femail
							</label>

						</div>
					</div>
					<!-- age -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Age</label>
							<p class="help-block text-danger"></p>
							<label class="radio-inline"> <input type="radio"
								name="age_10" checked>10
							</label> <label class="radio-inline"> <input type="radio"
								name="age_20">20
							</label> <label class="radio-inline"> <input type="radio"
								name="age_30">30
							</label> <label class="radio-inline"> <input type="radio"
								name="age_40">40
							</label> <label class="radio-inline"> <input type="radio"
								name="age_50">50
							</label>
						</div>
					</div>
					<!-- address -->
					<div class="row control-group">
						<div
							class="form-group col-xs-11 floating-label-form-group controls">
							<label>Address</label>
							<div style="display: -webkit-box;">
								<input type="text" class="form-control" placeholder="Address"
									id="address">
								<button type="button" class="btn btn-default" onclick="">주소
									api</button>
								<p class="help-block text-danger"></p>
							</div>
						</div>
					</div>
					<!-- email -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Email</label> <input type="email" class="form-control"
								placeholder="Email Address" id="email">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<!-- teather 1-->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Teather 1</label> <select class="form-control" id="sel1">
								<option>용산</option>
								<option>강남</option>
								<option>영등포</option>
							</select>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<!-- teather 2-->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Teather 2</label> <select class="form-control" id="sel2">
								<option>용산</option>
								<option>강남</option>
								<option>영등포</option>
							</select>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<!-- teather 3-->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Teather 3</label> <select class="form-control" id="sel3">
								<option>용산</option>
								<option>강남</option>
								<option>영등포</option>
							</select>
							<p class="help-block text-danger"></p>
						</div>
					</div>					
					<br>
					<div id="success"></div>
					<div class="row">
						<div class="form-group col-xs-12">
							<button type="submit" class="btn btn-default" style="margin-left: 46%;">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<hr>
	<br>
	<%@ include file="inc/footer.jsp"%>

</body>
</html>