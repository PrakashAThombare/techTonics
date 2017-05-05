<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Techtalk</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Update TechTalk</h2>
		<form class="form-horizontal" action="updateTechtalkServlet?id=${tech.techId}" method="get">
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Title</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="pwd"
						placeholder="Title" name="title" value="${tech.title }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Description</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="pwd"
						placeholder="Description" name="description" value="${tech.description }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Presentor</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="pwd"
						placeholder="Presentor" name="presentor" value="${tech.presentor }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Date</label>
				<div class="col-sm-10">
					<label class="control-label" for="date"></label> <input
									class="form-control" id="date" name="date"
									placeholder="YYYYMMDD" type="text" value="${tech.presentationdate }" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" onclick="adminToHome.jsp">Submit</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>