package com.platform.open_house.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginURLWritingServlet")
public class LoginURLWritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginURLWritingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (password.equals("1234")) {
			response.sendRedirect("WelcomePage?currentUser=" + userName);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
			rd.forward(request, response);
		}
	}

}
