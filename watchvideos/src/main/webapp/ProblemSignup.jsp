<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Problem Sign Up</title>
</head>
<body bgcolor="cyan">
<h2>Problem Sign Up???</h2><br>
<%
	String problem=(String)request.getAttribute("problem");
	out.println("It seems like"+problem);
%>
<br>
<form action="SignUp" method="post">
<br>
<input type="text" name="fname" placeholder="First Name" required> <input type="text" name="lname" placeholder="Last Name" required><br>
<input type="email" name="email" placeholder="E-mail" required> <br>
<input type="number" name="pnumber" placeholder="Phone Number" required><br>
Gender:<br>    Male<input type="radio" name="gender" required>	Female<input type="radio" name="gender" required><br>
Password: <br>
<input type="password" name="password" placeholder="New Password" id="NewPassword" required>
<input type= "password" name="rpassword" placeholder="Re-type Password" id="ConfirmPassword" required> <br>
<br><input type="submit" value="SignUp">
</form>
<h3>Already have an Account?</h3>
<form action="/watchvideos/index.jsp">
	<input type="submit" value="Login Here">
</form>
</body>
</html>