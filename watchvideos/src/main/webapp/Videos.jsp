<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Videos</title>
</head>
<body>
<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("email")==null){
		response.sendRedirect("/watchvideos/index.jsp");
	}
%>
<p>
<a href="http://www.youtube.com/">
   <img class="irc_mi" src="https://www.youtube.com/yts/img/yt_1200-vfl4C3T0K.png" onload="typeof google==='object'&amp;&amp;google.aft&amp;&amp;google.aft(this)" alt="Image result for youtube image" style="margin-top: 0px;" data-iml="1559844195078" width="416" height="416">
</a>

<a href="https://vimeo.com/watch/">
<img class="irc_mi" src="https://pmcvariety.files.wordpress.com/2014/01/vimeo_logo.jpg?w=912" onload="typeof google==='object'&amp;&amp;google.aft&amp;&amp;google.aft(this)" alt="Image result for vimeo.com" style="margin-top: 0px;" data-iml="1559844821890" width="500" height="416">
</a>
&nbsp &nbsp &nbsp &nbsp
<a href="https://www.twitch.tv/">
<img class="irc_mi" src="https://www.twitch.tv/p/assets/uploads/twitch_474x356.png" onload="typeof google==='object'&amp;&amp;google.aft&amp;&amp;google.aft(this)" style="margin-top: 30px;" data-iml="1559845107712" alt="Image result for www.twitch.com" width="474" height="416">
</a>
</p>
<br><br><br>
<form action="/watchvideos/Logout">
<input type="submit" value="Logout">
</form>
</body>
</html>
