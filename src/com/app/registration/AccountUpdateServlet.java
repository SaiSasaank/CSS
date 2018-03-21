package com.app.registration;

//import java.io.File;
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

import com.app.css.CSSList;
import com.app.user.User;
import com.app.user.UserAccountService;

/**
 * Servlet implementation class AccountUpdateServlet
 */
@WebServlet("/accountupdate.do")
public class AccountUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOG = LoggerFactory.getLogger(CSSList.class);
	@Resource(name = "jdbc/Project")
    private DataSource ds;
	Connection conn;
   
	private UserAccountService userAccountService = new UserAccountService();
	//private static final String SAVE_DIR = "uploadFiles";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int user_id=(int) request.getSession().getAttribute("user_id");
		//String fileName=SAVE_DIR + File.separator + name+"_"+".png";
		String name=(String) request.getSession().getAttribute("name");
		
		
		try
		{
			LOG.trace("doGet : DBConnection Open");
			conn = ds.getConnection();
			LOG.info("doGet : Retrive accout details");
			request.setAttribute("user", userAccountService.retrieveAccountDetails(name,conn));
			//request.setAttribute("fileName", fileName);
			LOG.info("doGet : Request from AccountUpdateServlet to accountUpdate.jsp");
			request.getRequestDispatcher("view/accountUpdate.jsp").forward(request, response);

			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String confirm_password = request.getParameter("confirm_password");
		//int user_id= (int)request.getSession().getAttribute("user_id");
		
		
		String storedToken = (String)request.getSession().getAttribute("csrfToken");
        String token = request.getParameter("token");
        
        System.out.println("T"+token);
        System.out.println("ST"+storedToken);
        //do check
        if (storedToken.equals(token) && confirm_password.equals(password)) {

        	try
    		{
        		LOG.trace("doPost : DBConnection Open");
    			conn = ds.getConnection();
    			User user=new User();
    			user.setUsername(name);
    			user.setFullname(fullname);
    			user.setEmail(email);
    			user.setPassword(password);
    			LOG.info("doPost : Update user data");
    			int update=userAccountService.updateUser(user,conn);
    			if(update==1)
    			{
    				LOG.info("doPost : Update done sucessfully");
    				request.setAttribute("success", "Updated");
    				LOG.info("doPost : Redirect from AccountUpdateServlet to AccountUpdateServlet");
    				response.sendRedirect("accountupdate.do");
    			}
    			else
    			{
    				//LOG.info("doPost : Update failed");
    				request.setAttribute("error", "Update failed");
    				//LOG.info("doPost : Redirect from AccountUpdateServlet to AccountUpdateServlet");
    				response.sendRedirect("accountupdate.do");
    				
    			}
    			
    			
    		}
    		catch(SQLException e)
    		{
    			//LOG.error("doPost : Catch block : SQLException : "+e.getMessage());
    			log(e.getMessage(), e);
    		}
    		finally
    		{
    			try {
    				conn.close();
    				//LOG.trace("doPost : DBConnection Close");
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				//LOG.error("doPost : Finally block : SQLException : "+e.getMessage());
    				e.printStackTrace();
    			}
    		}
        	
        } 
        else {
        	request.setAttribute("error","Passwords do not match");
        	//String name=(String) request.getSession().getAttribute("name");
    		
    		
    		try
    		{
    			LOG.trace("doGet : DBConnection Open");
    			conn = ds.getConnection();
    			LOG.info("doGet : Retrive accout details");
    			request.setAttribute("user", userAccountService.retrieveAccountDetails(name,conn));
    			//request.setAttribute("fileName", fileName);
    			LOG.info("doGet : Request from AccountUpdateServlet to accountUpdate.jsp");
    			request.getRequestDispatcher("view/accountUpdate.jsp").forward(request, response);

    			
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
		
	}
}
