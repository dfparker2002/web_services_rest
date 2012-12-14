<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${pageContext.request.contextPath}/">
	<title>Hello</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
		
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/jquery.tmpl.min.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript">
		
		function loadTable(){
			
			var requestUrlJson = "ajax/table";
	        
	        $.ajax({
	    	    type: "GET",
	    	    url: requestUrlJson,
	    	    dataType: "json",
	    	    contentType: "application/json",
	    	    success: function(data){
	    	    	$("#usersTableTemplate").tmpl(data).appendTo("#usersTable tbody");
	    	    }
	    	})
	       		
		}
					
	</script>
	
</head>

<body onload="loadTable();">
<div style="width: 400px; font-family: Arial; font-size: 9pt;">
	<table>
		<tr>
			<td colspan="2" style="padding-bottom: 10px;">
				<h2>Page: <b>Table</b></h2>
			</td>
		</tr>		
		<tr>
			<td colspan="2">
			
				<table id="usersTable" border="1px;" cellpadding="0px;" cellspacing="0px;" style="width: 300px;">
					<thead>
						<tr>
							<td>Id</td>
							<td>Name</td>
							<td>Actions</td>
						</tr>
					</thead>
					<tbody>
						<script id="usersTableTemplate" type="text/x-jquery-tmpl">		
							<tr>					 
								<td>\${id}</td>
								<td>\${name}</td>
								<td> 
									<a href="table/view-link/\${id}">View</a> &nbsp;
									<a href="table/edit-link/\${id}">Edit</a> &nbsp;
									<a href="table/delete-link/\${id}">Delete</a> 
								</td>
							</tr>	
						</script>
					</tbody>
				</table>
				
			
			</td>
		</tr>		
		<tr>
			<td colspan="2">
				<a id="create" name="create" href="table/create-button">Create</a>
			</td>
		</tr>		
	</table>
</div>

<div class="modal"><!-- Ajax Loading Animation - place at bottom of page --></div>
</body>

<!-- Ajax Loading Animation - this has to be on end of page -->
<script type="text/javascript">

	$("body").on({
	    // When ajaxStart is fired, add 'loading' to body class
	    ajaxStart: function() { 
	        $(this).addClass("loading"); 
	    },
	    // When ajaxStop is fired, rmeove 'loading' from body class
	    ajaxStop: function() { 
	        $(this).removeClass("loading"); 
	    }    
	});

</script>
</html>