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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@WebServlet("/CSSList.do")
public class CSSList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOG = LoggerFactory.getLogger(CSSList.class);

	
	@Resource(name = "jdbc/Project")
    private DataSource ds;
	Connection conn;
	
	private CSSService cssService = new CSSService();
    CSS css =new CSS();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getSession().getAttribute("name"));
		String name=(String) request.getSession().getAttribute("name");
		LOG.info("Hello, user");
		try
		{
			LOG.trace("doGet : DBConnection Open");
			conn = ds.getConnection();
			LOG.info("doGet : Retrive todo list");
			request.setAttribute("css", cssService.retrieveCSS(name,conn));
			LOG.info("doGet : Request from TodoServlet to csslist.jsp");
			request.getRequestDispatcher("view/csshome.jsp").forward(request, response);

		}
		catch(SQLException e)
		{
			LOG.error("doGet : Catch block : SQLException : "+e.getMessage());
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

}
