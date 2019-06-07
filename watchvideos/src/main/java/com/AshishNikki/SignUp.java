package com.AshishNikki;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AshishNikki.dao.Database;
import com.AshishNikki.model.UserData;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String rpassword=request.getParameter("rpassword");
		if(password.equals(rpassword)) {
			String pnumber=request.getParameter("pnumber");
			if(pnumber.length()==10) {
				UserData userdata=new UserData();
				userdata.setEmail(email);
				userdata.setPassword(password);
				userdata.setPnumber(pnumber);
				String name=request.getParameter("fname");
				name=name+" "+request.getParameter("lname");
				userdata.setName(name);
				userdata.setGender(request.getParameter("gender"));
				//PrintWriter out=response.getWriter();
				//out.println("User's Info:" +userdata);
				Database db=new Database();
				if(db.signUp(userdata)) {
					HttpSession session=request.getSession();
					session.setAttribute("email", email);
					response.sendRedirect("/watchvideos/homepage.jsp");
				}
				else {
					RequestDispatcher rd=request.getRequestDispatcher("/ProblemSignup.jsp");
					request.setAttribute("problem", " you already have an account. Please choose another E-mail ID.");
					rd.forward(request, response);
				}
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("/ProblemSignup.jsp");
				request.setAttribute("problem", " phone number is not Valid. Please type correct Phone Number.");
				rd.forward(request, response);
			}
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/ProblemSignup.jsp");
			request.setAttribute("problem", " you've not typed password correctly. Note that password is case sensetive.");
			rd.forward(request, response);
		}
	}

}
