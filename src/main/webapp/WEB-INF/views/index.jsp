
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
		 button. Handle errors like empty fields -->
	<div class="form-group form">
		<form action='add' method="post">
			<label>Note Title:</label> <input type="text" id="noteTitle"
				name="noteTitle" placeholder="note title" class="form-control" /> <br />
			<label>Note Content:</label> <input type="text" id="noteContent"
				name="noteContent" placeholder="note content" class="form-control" />
			<br /> <label>Note Status:</label> <select name="noteStatus">
				<option value="active">active</option>
				<option value="inactive">inactive</option>
			</select> <br /><br />
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<c:if test="${!errorMessage.isEmpty()}">
		<p style="color: red;">${errorMessage}</p>
	</c:if>
	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
	<table>
		<c:forEach items="${noteList}" var="note">
			<tr>
				<td>Note Id :</td>
				<td>${note.noteId}</td>
			</tr>
			<tr>
				<td>Note Title :</td>
				<td>${note.noteTitle}</td>
			</tr>
			<tr>
				<td>Note Content :</td>
				<td>${note.noteContent}</td>
			</tr>
			<tr>
				<td>Note Status :</td>
				<td>${note.noteStatus}</td>
			</tr>
			<tr>
				<td>Note created at :</td>
				<td>${note.createdAt}</td>
			</tr>
			<tr>
				<td>
					<div>
						<form action='delete' method="post">
							<input type="hidden" id="noteId" name="noteId"
								value="${note.noteId}"/>
							<button type="submit" class="btn btn-dark">Delete</button>
						</form>
					</div>
				</td>
				<td><button data-toggle="modal" data-target="#exampleModal" class="btn btn-primary">Update</button></td>
			</tr>
			<div class="modal" id="exampleModal" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">Update</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form action='update' method="post">
								<input type="hidden" id="noteId" name="noteId"
									value="${note.noteId}" class="form-control" /> <label>Note
									Title:</label> <input type="text" id="noteTitle" name="noteTitle"
									placeholder="note title" value="${note.noteTitle}"
									class="form-control" /> <br /> <label>Note Content:</label> <input
									type="text" id="noteContent" name="noteContent"
									placeholder="note content" value="${note.noteContent}"
									class="form-control" /> <br /> <label>Note Status:</label> <select
									name="noteStatus">
									<option value="active">active</option>
									<option value="inactive">inactive</option>
								</select> <br />
								<button type="submit" class="class="btn btn-primary">Update</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</table>
</body>
</html>
