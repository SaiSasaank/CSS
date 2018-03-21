package com.app.mail;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mail.do")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        
        //String name = request.getParameter("name");
        //String password = request.getParameter("password");
        //String message =  "Username : "+name+" Password : "+password;
        //
		//request.getRequestDispatcher("view/welcome.html").forward(request, response);

        
	}

}
