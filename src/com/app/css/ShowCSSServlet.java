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

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


@WebServlet("/show.do")
public class ShowCSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/Project")
	//static final Logger LOG = LoggerFactory.getLogger(CSSList.class);
	private DataSource ds;
	Connection conn;
	
	private CSSService cssService = new CSSService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String css1id= request.getParameter("css1");
		System.out.println("css1"+css1id);
		request.setAttribute("css1id", css1id);
		int cssid=Integer.parseInt((String) request.getParameter("css_id"));
		System.out.println("css_id"+cssid);
		request.setAttribute("cssid", cssid);
		int catid=Integer.parseInt((String) request.getParameter("cat_id"));		
		System.out.println("cat_id"+catid);
		request.setAttribute("catid", catid);
		//String name=(String) request.getSession().getAttribute("name");
		//LOG.info("Hello, user");
		try
		{
			//LOG.trace("doGet : DBConnection Open");
			conn = ds.getConnection();
			//LOG.info("doGet : Retrive todo list");
			
			request.setAttribute("css", cssService.retrieveCSS(cssid,catid,conn));
			//LOG.info("doGet : Request from TodoServlet to csslist.jsp");
			request.getRequestDispatcher("view/cssshow.jsp").forward(request, response);

		}
		catch(SQLException e)
		{
			//LOG.error("doGet : Catch block : SQLException : "+e.getMessage());
			log(e.getMessage(), e);
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
