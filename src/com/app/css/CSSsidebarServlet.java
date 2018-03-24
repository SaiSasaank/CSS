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


@WebServlet("/csssidebar.do")
public class CSSsidebarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/Project")
    private DataSource ds;
	Connection conn;
	
	private CSSService cssService = new CSSService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cat_id=Integer.parseInt((String) request.getParameter("cat_id"));		
		System.out.println("cat_id"+cat_id);
		try
		{
			//LOG.trace("doGet : DBConnection Open");
			conn = ds.getConnection();
			//LOG.info("doGet : Retrive todo list");
			
			request.setAttribute("css", cssService.retrieveCSS(cat_id,conn));
			//LOG.info("doGet : Request from TodoServlet to csslist.jsp");
			request.getRequestDispatcher("view/csshome.jsp").forward(request, response);

		}
		catch(SQLException e)
		{
			//LOG.error("doGet : Catch block : SQLException : "+e.getMessage());
			log(e.getMessage(), e);
		}
		finally
		{
			try {
				conn.close();
				//LOG.trace("doGet : DBConnection Close");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//LOG.error("doGet : Finally block : SQLException : "+e.getMessage());
				e.printStackTrace();
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
