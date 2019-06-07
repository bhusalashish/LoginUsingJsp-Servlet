<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Watch Videos</title>
</head>
<body bgcolor="cyan">
<h3>Welcome to Watch Videos Official Website</h3>
<h4>You need to login first to watch our videos</h4>
<form action="VerifyLogin" method="post">
	E-mail:<input type="email" name="uname" required><br>
	Password: <input type="password" name="pass" required> <br>
	<input type="submit" value="Login">
</form>
<form action="SignUp" method="post">
<br>
Don't have an account yet? <h3>Sign Up for Free</h3>
<input type="text" name="fname" placeholder="First Name" required> <input type="text" name="lname" placeholder="Last Name" required><br>
<input type="email" name="email" placeholder="E-mail" required> <br>
<input type="number" name="pnumber" placeholder="Phone Number" required><br>
Gender:<br>    Male<input type="radio" name="gender" required>	Female<input type="radio" name="gender" required><br>
Password: <br>
<input type="password" name="password" placeholder="New Password" id="NewPassword" required>
<input type= "password" name="rpassword" placeholder="Re-type Password" id="ConfirmPassword" required> <br>
<br><input type="submit" value="SignUp">
</form>
</body>
</html>