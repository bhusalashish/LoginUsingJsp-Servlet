package com.AshishNikki;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  com.AshishNikki.dao.Database;
import com.AshishNikki.model.User;

@WebServlet("/VerifyLogin")
public class VerifyLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email=request.getParameter("uname");
		String password=request.getParameter("pass");
		User user=new User(email,password);
		Database db=new Database();
		if(db.login(user)) {
			HttpSession session =request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("/watchvideos/homepage.jsp");
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/ProblemLogin.jsp");
			rd.forward(request, response);
		}
		
	}

}
