<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	var baseUrl = '<%=basePath%>';
	$("#button").click(function() {
		$.ajax({
			   type: 'GET',
			   url: baseUrl + 'getUser' ,
			   dataType: "json",
			   success: function(data) { //callback
				   $("#id").val(data.id);
				   $("#name").val(data.name);
				   $("#age").val(data.age);
				   $("#createDate").val(data.createDate);
			   }
			});
		}
	);
});

</script>
<title>JQuery Ajax</title>
</head>
<body>
	<h2>jQuery and AJAX is FUN!!!</h2>
	<form id="jquery" action="<%=basePath%>login.do" method="post" >
		id:<input type="text" id="id" name="id" /> 
		<br/>
		<br/>
		name:<input type="text" id="name" name="name" /> 
		<br/>
		<br/>
		age:<input type="text" id="age" name="age" /> 
		<br/>
		<br/>
		date:<input type="text" id="createDate" name="createDate" /> 
		<br/>
		<br/>
		<input type="submit" id="submit" value="submit" />
		<br/>
		<br/>
		<input type="button" id="button" value="please click me get info" />
	</form>
</body>
</html>