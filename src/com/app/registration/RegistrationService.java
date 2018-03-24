package com.app.registration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.hashtool.PasswordTool;

public class RegistrationService {
	
	public boolean isUserRegistered(String name,String fullname,String email, String password, Connection conn) {
		boolean usernameExists=true;
		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from login where username='" + name + "'";
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
				  usernameExists = true;
				}
				else
				{
					PasswordTool pt = new PasswordTool();
					String salt = pt.GenerateSalt();
					String storedHash = pt.get_SHA_512_SecurePassword(password, salt);
					String insertSql = "insert into login (username,fullname,email, password,salt) values('" + name + "','" + fullname + "','" + email + "', '"+storedHash+"', '"+salt+"');";
					stmt.executeUpdate(insertSql);
					usernameExists=false;
					return usernameExists;
				}

			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usernameExists;
		
	}
	
	

}
