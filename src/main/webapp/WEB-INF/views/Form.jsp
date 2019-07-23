<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
<form action="./submit" method="post">
	ID: <input type="text" name="id"><br>
	Name: <input type="text" name="name"><br>
	Age: <input type="text" name="age"><br>
	<input type="submit" value="submit">
	<%
		session.setAttribute("person", null);
	%>
</form>
</body>
</html>