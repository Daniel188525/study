<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
	<h2>user login</h2>
	<sf:form id="form" action="/study/login.do" modelAttribute="user" method="post" >
		<label for="id">id:</label>
		<input type="text" id="id" name="id" />
		<br />

		<label for="name">name:</label>
		<input type="text" id="name" name="name" />
		<br /> 
		
		<input type="submit" value="login" />
	</sf:form>
</body>
</html>
