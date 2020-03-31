<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Simple Spring Boot Board</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h2>Simple Spring Boot Board</h2>
		<p>TEST Simple Board</p>
		<div>
			<a href="/board/create"><button type="button"
					class="btn btn-primary">Create</button></a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Number</th>
					<th>Title</th>
					<th>Writer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.b_id}</td>
						<td><a href="/board/${board.b_id}">${board.b_title}</a></td>
						<td>${board.b_writer}</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>