<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${pageContext.request.contextPath}/">
	<title>Hello</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
		
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript">
		
		function createUser(){
			
			var dataObj = {
				name: $('#userName').val()					
			};
			var dataJson = JSON.stringify(dataObj, null, 2);
			
			var requestUrlJson = "ajax/create";
	        
	        $.ajax({
	    	    type: "PUT",
	    	    url: requestUrlJson,
	    	    data : dataJson,
	    	    dataType: "json",
	    	    contentType: "application/json",
	    	    success: function(data){
	    	    	$(location).attr('href',"create/create-button");
	    	    }
	    	})
	       		
		}
					
	</script>
	
</head>

<body>
<form name="form" method="POST" action="create/create-button">
<input type="hidden" id="id" name="id" value="${command.id}"/>

<div style="width: 400px; font-family: Arial; font-size: 9pt;">
	<table>
		<tr>
			<td colspan="2" style="padding-bottom: 10px;">
				<h2>Page: <b>Create</b></h2>
			</td>
		</tr>
		<tr>
			<td>Type your name:</td>
			<td><input type="text" id="userName" name="userName" size="10"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="create" name="create" value="Create" onclick="createUser();"/>
				<a id="cancel" name="cancel" href="create/cancel-button">Cancel</a>
			</td>
		</tr>		
	</table>
</div>
</form>
</body>

</html>