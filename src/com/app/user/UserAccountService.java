package com.app.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserAccountService {

private static List<User> userList = new ArrayList<User>();
	
	public List<User> retrieveAccountDetails(String name,Connection conn) {
		userList.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				
				String sql = "select * from login where username=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				System.out.println(sql);
				System.out.println(name);
				rs = pstmt.executeQuery();

				if (rs != null) {
					
					while (rs.next()) {
						User user=new User();
						user.setUsername(rs.getString("username"));
						user.setFullname(rs.getString("fullname"));
						user.setEmail(rs.getString("email"));
						user.setPassword(rs.getString("password"));
						userList.add(user);
			        }  
					
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("size of List: "+userList.size());
		return userList;
	}
	
	
	public int updateUser(User user, Connection conn) {
		int update=0;
		try {
			if (conn != null && !conn.isClosed()) {

				Statement stmt = conn.createStatement();
				
				String sql = "update login set fullname='"+user.getFullname()+"', email='"+user.getEmail()+"' , password='"+user.getPassword()+"' where username='"+user.getUsername()+"'";
				System.out.println(sql);
				update=stmt.executeUpdate(sql);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
	
}
