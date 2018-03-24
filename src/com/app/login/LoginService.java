package com.app.login;

import java.sql.*;

import com.app.user.User;


public class LoginService {

	

	public boolean isUserValid(String name, String password, User user,Connection conn) {
		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;				
				//Statement stmt = conn.createStatement();
				String sql = "select * from login where username=? and password=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, password);
				//System.out.println(sql);
				rs = pstmt.executeQuery();

				if (rs != null && rs.next()) {
					user.setUsername(rs.getString("username"));
					user.setFullname(rs.getString("fullname"));
					user.setEmail(rs.getString("email"));
					
					return true;
				}
				

			}

		} catch (SQLException e) {
			// log(e.getMessage(), e);
			e.printStackTrace();
		}
		return false;
	}

	public String getSaltDB(String name, User user,Connection conn) {
		String s="";
		try {
			
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				String sql = "select salt from login where username=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
					s = rs.getString(1);
					System.out.println("Salt in service:"+s);
					
				}
				
			}
		} catch (SQLException e) {
			// log(e.getMessage(), e);
			e.printStackTrace();
		}
		return s;

	}
}
