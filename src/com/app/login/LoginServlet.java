package com.app.login;
import java.io.IOException;
import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.app.user.User;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Resource(name="jdbc/Project")
    private DataSource ds;
	private Connection con;
	//private Statement stmt;
	//private ResultSet rs;

	private LoginService userValidation = new LoginService();
	User user=new User();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");

		try {
			con=ds.getConnection(); //creates connection
			//System.out.println("Connection successful");
			boolean isUserValid = userValidation.isUserValid(name, password,user,con);
			if(isUserValid) {
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("csrfToken", generateCSRFToken());
				String sessionid = request.getSession().getId();
				response.setHeader("Set-Cookie", "JSESSIONID=" +  sessionid + ";");
				response.sendRedirect("otp.do");
			}
			else
			{
				request.setAttribute("error","Invalid Credentials");
				request.getRequestDispatcher("view/login.jsp").forward(request, response);
			}
		}
		catch(Exception e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
	
	public static String generateCSRFToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}

}
