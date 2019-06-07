<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Problem Login</title>
</head>
<body bgcolor="cyan">
<h2>Problem Login???</h2>
<h3>The Credentials does not match </h3>
<form action="VerifyLogin" method="post">
	E-mail:<input type="email" name="uname" required><br>
	Password: <input type="password" name="pass" required> <br>
	<input type="submit" value="Login">
</form>
<br> <br>
<h4>Do not have an account?</h4>
<form action="/watchvideos/index.jsp">
	<input type="submit" value="SignUp Here">
</form>

</body>
</html>