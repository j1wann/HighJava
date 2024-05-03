<%@page import="kr.or.ddit.vo.BoardVO"%>
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

	<%
	BoardVO vo = (BoardVO)request.getAttribute("boardVO");
	%>

	<div class="container">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<div class="row">
			<h3>게시판 상세보기</h3>
			<hr />
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<div class="card-title">
							<h4><%=vo.getTitle() %></h4>
						</div>
					</div>
					<div class="card-body">
						<%=vo.getWriter() %> <%=vo.getRegDate() %> <%=vo.getHit()%>
					</div>
					<div class="card-body">
						<%=vo.getContent() %>
					</div>
					<div class="card-footer">
						<button class="btn btn-warning" id="updateBtn">수정</button>
						<button class="btn btn-danger" id="deleteBtn">삭제</button>
						<button class="btn btn-primary" id="listBtn">목록</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	var updateBtn = $("#updateBtn");
	var deleteBtn = $("#deleteBtn");
	var listBtn = $("#listBtn");
	
	listBtn.on("click", function(){
		location.href = "/board/list.do";
	});
	
	deleteBtn.on("click", function(){
		if(confirm("정말로 삭제하시겠습니까?")){
		location.href = "/board/delete.do?no=<%=vo.getNo()%>";			
		}
	});
	
	updateBtn.on("click", function(){
		location.href = "/board/update.do";
	});
})
</script>





</html>