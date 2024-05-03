<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/dist/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">　</div>
		</div>
		<div class="row">
			<h3>게시판 등록</h3>
			<hr/>
			<div class="col-md-12">
				<div class="card">
					<form action="/board/form.do" method="post" id="insertForm">
					<div class="card-header">
						<div class="card-title">
							<input type="text" class = "form-control" name="title" id="title"/>
						</div>
					</div>
					<div class="card-body">
						<textarea rows="10" class = "form-control" cols="50" name="content" id="content"></textarea>
					</div>
					<div class="card-footer">
						<button type="button" class="btn btn-warning" id="addBtn">등록</button>
						<button type="button" class="btn btn-primary" id="listBtn">목록</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		var addBtn = $("#addBtn");
		var listBtn = $("#listBtn");
		var insertForm = $("#insertForm");
		
		// 목록 버튼 클릭 시
		listBtn.on("click", function(){
			location.href = "/board/list.do";
		});
		
		// 등록 버튼 클릭 시
		addBtn.on("click", function(){
			var title = $("#title").val();
			var content = $("#content").val();
			
			if(title == null || title == ""){
				alert("제목을 입력하세요!");
				return false;
			}
			if(content == null || content == ""){
				alert("내용을 입력하세요!");
				return false;
			}
			
			insertForm.submit(); //서버로 전송
			
		});
	});
	
	
	
	
	
	
	
	
	
	
</script>
</html>