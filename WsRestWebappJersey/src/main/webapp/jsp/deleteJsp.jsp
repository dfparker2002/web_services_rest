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
		
		function loadUser(){
			
			var requestUrlJson = "rest/ajax/delete/" + $("#userId").val();
	        
	        $.ajax({
	    	    type: "GET",
	    	    url: requestUrlJson,
	    	    dataType: "json",
	    	    contentType: "application/json",
	    	    success: function(data){
	    	    	$("#userName").html(data.name);	    	    	
	    	    }
	    	})
	       		
		}
		
		
		function deleteUser(){
			
			var requestUrlJson = "rest/ajax/delete/" + $("#userId").val();
	        
	        $.ajax({
	    	    type: "DELETE",
	    	    url: requestUrlJson,
	    	    dataType: "json",
	    	    contentType: "application/json",
	    	    success: function(data){
	    	    	$(location).attr('href',"rest/delete/delete-button");
	    	    }
	    	})
	       		
		}
					
	</script>
	
</head>

<body onload="loadUser();">
<form name="form" method="POST" action="delete/delete-button">
<input type="hidden" id="userId" name="userId" value="${it.userId}"/>

<div style="width: 400px; font-family: Arial; font-size: 9pt;">
	<table>
		<tr>
			<td colspan="2" style="padding-bottom: 10px;">
				<h2>Page: <b>Delete</b></h2>
			</td>
		</tr>
		<tr>
			<td colspan="2">Do you really want delete name: <span id="userName"></span> ?</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="delete" name="delete" value="Delete" onclick="deleteUser();"/>
				<a id="cancel" name="cancel" href="rest/delete/cancel-button">Cancel</a>
			</td>
		</tr>		
	</table>
</div>
</form>
</body>

</html>