package com.app.css;

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


@WebServlet("/update.do")
public class UpdateCSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/Project")
    private DataSource ds;
	private Connection conn;
	
	private CSSService cssService = new CSSService();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int css_id=Integer.parseInt((String) request.getParameter("css_id"));
		String catd= request.getParameter("catd");
		int cat_id= Integer.parseInt(catd);
		System.out.println(cat_id);
		String cssd="";
		for(int i=0;i<6;i++) {
			cssd= request.getParameter("eventId"+i);
			System.out.println(i+" CSS_ID:"+cssd);
			if(cssd=="" || cssd==null)continue;
			else break;
		}
		int css_id= Integer.parseInt(cssd);
		String url=request.getParameter("url");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String doc_num= request.getParameter("doc_num");
		String val_date= request.getParameter("val_date");
		String doc_name= request.getParameter("doc_name");
		System.out.println(doc_name);
		String c = request.getParameter("cvv");
		int cvv;
		if( !isStringInt(c) || c=="")
			cvv=0;
		else
			cvv = Integer.parseInt(c);
		String type_info= request.getParameter("type_info");
		String nation= request.getParameter("nation");
		String address= request.getParameter("address");
		//int cat_id=Integer.parseInt((String) request.getParameter("cat_id"));
		CSS t = new CSS();
		try
		{
			t.setUrl(url);
			t.setUsername(username);
			t.setPassword(password);
			t.setDoc_num(doc_num);
			t.setVal_date(val_date);
			t.setDoc_name(doc_name);
			t.setCvv(cvv);
			t.setType_info(type_info);
			t.setNation(nation);
			t.setAddress(address);
			conn = ds.getConnection();
			cssService.updateCSS(t,css_id,cat_id,conn);
			response.sendRedirect("CSSList.do");
		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}

	}
	public boolean isStringInt(String s)
	{
	    try
	    {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}

}
