<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Read</title>
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

<script type="text/javascript">
	$("#deleteBoard").click(function() {
		var result = confirm("Do you really want to delete your Board?");

		if (result) {
			location.href = 'board/delete/${board.b_id}';
		}
	});
</script>
</head>

<body>
	<div class="container">
		<h2>No : ${board.b_id}</h2>
		<div class="form-group">
			<label for="form">Writer: ${board.b_writer}</label>
		</div>
		<div class="form-group">
			<label for="form">Title: ${board.b_title}</label>
		</div>
		<div class="form-group">
			<label for="form">contents:</label>
			<textarea rows="20" cols="100" id="contents" readonly="readonly">${board.b_contents}</textarea>
		</div>
		<div class="form-group">
			<label class="form">Created Time : ${board.b_created_date} </label> <label
				class="form">Modified Time : ${board.b_update_date} </label>
		</div>
		<div>
			<a href="/board/list"><button type="button" class="btn btn-info">Move
					to List</button></a> <a href="/board/update/${board.b_id}"><button
					type="button" class="btn btn-success">Update</button></a>
			<button type="button" id="deleteBoard" class="btn btn-danger">Delete</button>
		</div>
	</div>
</body>

</html>