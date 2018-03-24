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


@WebServlet("/add.do")
public class AddCSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/Project")
    private DataSource ds;
	Connection conn;
	
	private CSSService cssService = new CSSService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/csshome.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String i=request.getParameter("css_id");
		//int css_id = Integer.parseInt(i);
		//System.out.println(n);
		String url = request.getParameter("url");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String doc_num= request.getParameter("doc_num");
		String d = request.getParameter("val_date");
		if(d=="" || d== null)
		d="1970/01/01";
		String doc_name = request.getParameter("doc_name");
		System.out.println(doc_name);
		String cvv = request.getParameter("cvv");
		String type_info = request.getParameter("type_info");
		System.out.println(type_info);
		String nation = request.getParameter("nation");
		String address = request.getParameter("address");
		String reference = request.getParameter("reference");
		String category = request.getParameter("category");
		String name=(String) request.getSession().getAttribute("name");
		int cat_id;
		if(category.equals("Website")){cat_id=1;}else if(category.equals("BankCard")){cat_id=2;}else if(category.equals("Passport")){cat_id=3;}else if(category.equals("AadharCard")){cat_id=4;}else if(category.equals("License")){cat_id=5;}else{cat_id=6;}
		try
		{
			conn = ds.getConnection();
			CSS t=new CSS();
			//t.setCss_id(css_id);
			t.setUrl(url);
			t.setUsername(username);
			t.setPassword(password);
			t.setDoc_num(doc_num);
			t.setVal_date(d);
			t.setDoc_name(doc_name);
			t.setCvv(cvv);
			t.setType_info(type_info);
			t.setNation(nation);
			t.setAddress(address);
			t.setReference(reference);
			t.setCategory(category);			
			t.setUname(name);
			t.setCat_id(cat_id);
			cssService.addCSS(name,t,conn);
			response.sendRedirect("CSSList.do");
			
		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}

