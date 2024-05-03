<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="java.util.List"%>
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
	
	
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<div class="row">
			<h3>게시판 목록</h3>
			<hr />
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<div class="card-title">
							<h4>일반 게시판 목록</h4>
						</div>
					</div>
					<div class="card-body">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<td width="8%">번호</td>
									<td>제목</td>
									<td width="12%">작성자</td>
									<td width="16%">작성일</td>
									<td width="10%">조회수</td>
								</tr>
							</thead>
							<tbody>
								<!-- 
									1. 넘겨받은 목록 데이터가 null일 때
									2. 넘겨받은 목록 데이터가 null이 아닐 때
								 -->
								<%
								 	List<BoardVO> boardList = 
								 	(List<BoardVO>) request.getAttribute("boardList");
								 	
								 	if(boardList == null || boardList.size() == 0){
								 		%>
								<tr>
									<td colspan="5">조회하신 게시글이 존재하지 않습니다.</td>
								</tr>
								<%								 		
								 	}else{
								 		for(int i = 0; i < boardList.size(); i++){
								 			BoardVO boardVO = boardList.get(i);
								 			%>
								<tr>
									<td><%=boardVO.getNo() %></td>
									<td>
										<a href="/board/detail.do?no=<%=boardVO.getNo()%>"> 
											<%=boardVO.getTitle() %>
										</a>
									<td><%=boardVO.getWriter() %></td>
									<td><%=boardVO.getRegDate() %></td>
									<td><%=boardVO.getHit() %></td>
								</tr>
								<%
								 		}
								 	}
								 
								 %>
							</tbody>
						</table>
					</div>
					<div class="card-footer">
						<button class="btn btn-primary" id="addBtn">등록</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	$(function(){
		var addBtn = $("#addBtn");
		
		addBtn.on("click", function(){
			location.href = "/board/form.do";
		});
		
	});
	
	</script>
	
	
	
	
	
	
	
</body>
</html>