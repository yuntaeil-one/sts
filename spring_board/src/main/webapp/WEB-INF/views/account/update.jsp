<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
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
		<h2>자산현황 업데이트</h2>
		<form action="/account/update/${account.type}" method="post">
			<div class="form-group">
				<label for="form">자산구분 : </label> <input type="text" class="form-control" value="${account.type }">
			</div>

			<div class="form-group">
				<label for="form">금액 : </label> <input type="text" class="form-control" id="balance" name="balance" value="${account.balance}">
			</div>
		</form>
		
		<button type="submit" class="btn btn-primary">저장</button>
		<a href="/account/list"><button type="button" class="btn btn-danger"">취소</button></a>
		<a href="/account/delete/${account.type}"><button type="button" class="btn btn-danger">삭제</button></a>
		
	</div>
</body>
</html>
