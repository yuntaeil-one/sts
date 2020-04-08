<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>자산  등록</title>
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
		<h2>자산 등록</h2>
		<form action="/account/create" method="post">
			<div class="form-group">
				<label for="form">자산 구분 : </label> <input type="text" class="form-control" id="type" placeholder="Enter Type" name="type" autocomplete="off">
			</div>
			<div class="form-group">
				<label for="form">금액 : </label> <input type="text" class="form-control" id="balance" placeholder="Enter Balance" name="balance" autocomplete="off">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/account/list"><button type="button" class="btn btn-info">Move to List</button></a>
		</form>
			
	</div>
</body>
</html>