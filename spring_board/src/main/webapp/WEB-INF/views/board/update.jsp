<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Create</title>
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
		<h2>Update Board form</h2>
		<form action="/board/update/${board.b_id}" method="post">
			<input type="hidden" value="${board.b_id }" name="b_id">

			<div class="form-group">
				<label for="form">Writer:</label> <input type="text"
					class="form-control" id="writer" name="b_writer"
					readonly="readonly" value="${board.b_writer }">
			</div>

			<div class="form-group">
				<label for="form">Title:</label> <input type="text"
					class="form-control" id="title" name="b_title"
					value="${board.b_title}">
			</div>
			<div class="form-group">
				<label for="form">contents:</label>
				<textarea rows="20" cols="100" id="contents" name="b_contents"
				>${board.b_contents}</textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<a href="/board/${board.b_id}"><button type="button" class="btn btn-danger">Cancel</button></a>
		<a href="/board/list"><button type="button" class="btn btn-info">Move to List</button></a>
	</div>
</body>
</html>
