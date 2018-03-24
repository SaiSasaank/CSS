package com.app.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register.do")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/Project")
    private DataSource ds;
	Connection conn;
	private RegistrationService userRegister= new RegistrationService();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String name = request.getParameter("name");
				String fullname = request.getParameter("fullname");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String confirm_password = request.getParameter("confirm_password");
				if(usernameValid(name)&&emailValid(email))	{				
					if (password!=null && confirm_password!=null) {
						if (!password.equals(confirm_password)) {				   
							request.setAttribute("error", "Confirmation password did not match");
							request.getRequestDispatcher("view/registration.jsp").forward(request, response);			
						}
						else {
							try	{
								conn = ds.getConnection();
							}
							catch(SQLException e) {
								log(e.getMessage(), e);
							}
							boolean isUserRegistered=userRegister.isUserRegistered(name,fullname,email, password,conn);
							if(isUserRegistered) {
								request.setAttribute("error", "User already registered");
								request.getRequestDispatcher("view/registration.jsp").forward(request, response);										
							}
							else {
								request.setAttribute("error", "Registration successful");
								response.sendRedirect("login.do");
							}				 
						}				   
					}
					else {
						request.setAttribute("error", "Please enter the password");
					}
				}
				else {
					request.setAttribute("error", "Invalid Username  or email");
				}
				
	}

	boolean usernameValid(String username) {
		Pattern regex = Pattern.compile("^[A-Za-z0-9_-]{3,15}$");
		Matcher matcher = regex .matcher(username);
		return matcher.matches();
	}
	boolean emailValid(String email) {
		Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = regex .matcher(email);
		return matcher.find();
	}

}
