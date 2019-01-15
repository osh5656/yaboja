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
	
	<!-- 영화매칭, 마이페이지말고는 여기부터 소스 넣으면 돼!!! -->
	<div class="container">
	<h2>후기게시판(상세)</h2>
		<div class="form-group">
			제목 : <input type="text" name="title"value="${boardDto.title }" readonly="readonly"class="form-control">
		</div>
		<div class="form-group">
			작성자 : <input type="text" name="username"value="${userDto.user_name }" readonly="readonly"class="form-control">
		</div>
		<div class="form-group">
			내용 : <textarea class="form-control" name="content" value="${userDto.title }" readonly="readonly" maxlength="2048" style="height: 350px"></textarea>
		</div>
		<input type="button" class="btn btn-default pull-right" value="삭제" onclick="#">
			<input type="button" class="btn btn-default pull-right" value="수정" onclick="#">
	</div>
<!-- -------------------------------------댓글-------------------------------------------------------------------- -->
	<div class="container">
	<hr class="my-4">
				<ul class="list-group">
					<!-- 댓글창 -->
					<li class="list-group-item note-item clearfix">
						<div class="content-body panel-body pull-left">
							<div class="avatar avatar-medium clearfix ">
								<div class="avatar-info">
								<!-- comment_seq_id를 이렇게 못받아온다면, form으로 처리해서 컨트롤러로 바로 보내버리자. -->
								${commentDto.user_nickname }
									<div class="date-created">
										<span class="timeago">
										</span>
									</div>
								</div>
							</div>
						<fieldset class="form">
							<article class="list-group-item-text note-text">
								${commentDto.comment_content }
							</article>
						</fieldset>
						</div>
							<div class="content-function pull-right">
								<div class="content-function-group">
										<div class="note-evaluate-wrapper">
											<div class="content-function-cog note-submit-buttons clearfix">
											
											<form id="comment_delete_form" method="post" action="controller.do?category=comment_delete"> 
												<input type="hidden" name="user_seq" id="user_seq" value="${userDto.user_seq }">
												<input type="hidden" name="board_seq_id" id="board_seq_id" value="${boardDto.board_seq_id }">
												<input type="hidden" name="comment_seq_id" id="comment_seq_id" value="${commentDto.comment_seq_id }">
												<input style="float: right;" type="submit" id="button" class="btn btn-default btn-wide" value="삭제">
											</form>
											</div>
										</div>
								</div>
							</div>
						</li>
							
						<!-- 댓글 입력창 -->
							<li class="list-group-item note-form clearfix">
								<form id="commentInsert" action="controller.do?category=comment_insert" method="post" class="note-create-form">
									<input type="hidden" name="board_seq_id" value="${boardDto.board_seq_id }">
									<input type="hidden" name="user_seq" value="${userDto.user_seq }">
									<div class="content-body panel-body pull-left">
										<div style="margin-left: 5px;">
											<div class="avatar avatar-medium clearfix ">
												<div class="avatar-info">
													<div class="activity block">
														<span class="fa fa-flash">
															${userDto.user_nickname }
														</span>
													</div>
												</div>
											</div>
										</div>
										<fieldset class="form">
											<textarea name="comment_content" id="comment_content" placeholder="댓글 쓰기" class="form-control"></textarea>
										</fieldset>
									</div>
									<div class="content-function-cog note-submit-buttons clearfix">
										<input style="float: right;" type="submit" name="comment_insert" id="btn-create-btn" class="btn btn-default btn-wide" value="등록">
									</div>
								</form>
							</li>
				</ul>
				</div>
	

	<!-- Footer -->
	<%@ include file="inc/footer.jsp"%>

	

</body>

</html>
