<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("email")==null){
			System.out.println("Redirecting to index page");
			response.sendRedirect("/watchvideos/index.jsp");
		}
	%>
	<h2>Welcome Dude</h2><br>
	You are now connected to the global leader video website!!!<br>
	<form action="/watchvideos/Videos.jsp">
	<input type="submit" value="Videos Here!!!">
	</form>  
	<br>
	<br>
	<h4>You are logged in as: </h4>
	<%
	out.print((String)session.getAttribute("email"));
	%>
	<form action="/watchvideos/Logout">
		<input type="submit" value="Logout">
	
	</form>
	
	
</body>
</html>