package com.app.css;

import java.io.IOException;
//import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



@WebServlet("/search.do")
public class SearchCSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/Project")
    private DataSource ds;
	Connection conn;
	private CSSService cssService = new CSSService();
	private List<CSS> searchList =null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String name=request.getParameter("name");
		String keyword=request.getParameter("keyword");
		try
		{
			conn = ds.getConnection();
			request.setAttribute("keyword", keyword);
			searchList=cssService.searchCSS(name,keyword,conn);
			request.setAttribute("searchSize", searchList.size());
			request.setAttribute("css1", searchList);
			
			//response.setHeader("X-XSS-Protection", "1; mode=block");
			
			request.getRequestDispatcher("view/csssearch.jsp").forward(request, response);
			

			
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
