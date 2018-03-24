package com.app.login;

import java.io.IOException;
import java.util.Random;

//import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.mail.SendMail;
import com.app.user.User;


@WebServlet("/otp.do")
public class OTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String num="";
	
       
	//private OTPService OTPValidation = new OTPService();
	private SendMail sendmail = new SendMail();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		Random r = new Random();
		int OTP = r.nextInt((9999 - 999) + 1) + 999;
		num =  Integer.toString(OTP);
		String num2 = "Your OTP is:"+num;
		System.out.println(num);
		sendmail.send(num2,email);
		System.out.println(email);
		request.getRequestDispatcher("view/OTP.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otp=request.getParameter("otp");
		
			//boolean check = OTPValidation.isOTPValid(OTP);
			if(otp.equals(num)) {
				response.sendRedirect("CSSList.do");
			}
			else
			{
				request.setAttribute("error","Invalid OTP");
				request.getRequestDispatcher("view/login.jsp").forward(request, response);
			}
	}


}
