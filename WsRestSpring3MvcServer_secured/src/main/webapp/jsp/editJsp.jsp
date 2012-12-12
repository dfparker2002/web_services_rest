<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${pageContext.request.contextPath}/">
	<title>Hello</title>
</head>

<body>
<form name="form" method="POST" action="edit/update-button">
<input type="hidden" id="id" name="id" value="${command.id}"/>

<div style="width: 400px; font-family: Arial; font-size: 9pt;">
	<table>
		<tr>
			<td colspan="2" style="padding-bottom: 10px;">
				<h2>Page: <b>Edit</b></h2>
			</td>
		</tr>
		<tr>
			<td>Type your name:</td>
			<td><input type="text" id="userName" name="userName" value="${command.userName}" size="10"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" id="update" name="update" value="Update"/>
				<a id="cancel" name="cancel" href="edit/cancel-button">Cancel</a>
			</td>
		</tr>		
	</table>
</div>
</form>
</body>

</html>