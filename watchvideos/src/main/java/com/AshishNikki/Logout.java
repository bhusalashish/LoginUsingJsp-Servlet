package com.AshishNikki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("email")==null) {
			response.sendRedirect("/watchvideos/index.jsp");
		}
		else {
			session.removeAttribute("email");
			session.invalidate();
			response.sendRedirect("/watchvideos/index.jsp");
		}
	}


}
