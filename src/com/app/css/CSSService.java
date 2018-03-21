package com.app.css;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CSSService {

private static List<CSS> scss = new ArrayList<CSS>();
	
	public List<CSS> retrieveCSS(String name,Connection conn) {
		scss.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				
				String sql = "select * from credentials where uname=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);				
				System.out.println(sql);
				System.out.println(name);
				rs = pstmt.executeQuery();

				if (rs != null) {
					
					while (rs.next()) {
						
						CSS t=new CSS();
						t.setCss_id(rs.getInt("css_id"));
						System.out.println(rs.getInt("css_id"));
						t.setUrl(rs.getString("url"));
						t.setUsername(rs.getString("username"));
						t.setPassword(rs.getString("password"));
						t.setDoc_num(rs.getString("doc_num"));
						t.setVal_date(rs.getString("val_date"));
						t.setDoc_name(rs.getString("doc_name"));
						t.setCvv(rs.getInt("cvv"));
						t.setType_info(rs.getString("type_info"));
						t.setNation(rs.getString("nation"));
						t.setAddress(rs.getString("address"));
						t.setReference(rs.getString("reference"));
						t.setCategory(rs.getString("category"));
						t.setUname(rs.getString("uname"));
						t.setCat_id(rs.getInt("cat_id"));
			            scss.add(t);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("size of List: "+scss.size());
		return scss;
	}

	public List<CSS> retrieveCSS(int css_id,int cat_id,Connection conn) {
		scss.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				
				String sql = "select * from credentials where css_id=? and cat_id=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, css_id);
				pstmt.setInt(2, cat_id);
				System.out.println(sql);
				//System.out.println(name);
				rs = pstmt.executeQuery();

				if (rs != null) {
					
					while (rs.next()) {
						
						CSS t=new CSS();
						t.setCss_id(rs.getInt("css_id"));
						System.out.println(rs.getInt("css_id"));
						t.setUrl(rs.getString("url"));
						t.setUsername(rs.getString("username"));
						t.setPassword(rs.getString("password"));
						t.setDoc_num(rs.getString("doc_num"));
						t.setVal_date(rs.getString("val_date"));
						t.setDoc_name(rs.getString("doc_name"));
						t.setCvv(rs.getInt("cvv"));
						t.setType_info(rs.getString("type_info"));
						t.setNation(rs.getString("nation"));
						t.setAddress(rs.getString("address"));
						t.setReference(rs.getString("reference"));
						t.setCategory(rs.getString("category"));
						t.setUname(rs.getString("uname"));
						t.setCat_id(rs.getInt("cat_id"));
			            scss.add(t);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("size of List: "+scss.size());
		return scss;
	}

	
	public void addCSS(String name,CSS css,Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {

				Statement stmt = conn.createStatement();
				String sql = "insert into credentials(css_id,url,username,password,doc_num,val_date,doc_name,cvv,type_info,nation,address,reference,category,uname,cat_id) values('"+css.getCss_id()+"','"+css.getUrl()+"','"+css.getUsername()+"','"+css.getPassword()+"','"+css.getDoc_num()+"','"+css.getVal_date()+"','"+css.getDoc_name()+"','"+css.getCvv()+"','"+css.getType_info()+"','"+css.getNation()+"','"+css.getAddress()+"','"+css.getReference()+"','"+css.getCategory()+"','"+name+"','"+css.getCat_id()+"')";
				System.out.println(sql);
				System.out.println("Doc_name"+css.getDoc_name());
				int insert = stmt.executeUpdate(sql);
				if(insert==1) 
				{
					scss.add(css);
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deleteCSS(int css_id, Connection conn) {
		
	
		
		CSS t1 = null;
		System.out.println(css_id);
		for(CSS t : scss) { 
			   if(t.getCss_id()==css_id) { 
				   System.out.println("in");
				 t1=t;  
			   }
			}
		
		try {
			if (conn != null && !conn.isClosed()) {

				String sql = "delete from credentials where css_id=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, css_id);
				
				System.out.println(sql);
				int delete = pstmt.executeUpdate();
				if(delete==1)
				{
					scss.remove(t1);
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<CSS> searchCSS(String name,String keyword, Connection conn)
	{
		scss.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "SELECT * from credentials where reference  like '%" + keyword + "%' OR category like '%" + keyword+ "%'";
				System.out.println(sql);
				rs = stmt.executeQuery(sql);
				
				
				
				if (rs != null) {
					
					while (rs.next()) {
						CSS t=new CSS();
						t.setCss_id(rs.getInt("css_id"));
						t.setCategory(rs.getString("category"));
						t.setReference(rs.getString("reference"));
			            scss.add(t);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(scss.size());
		return scss;
	}

	public void updateCSS(CSS css, int css_id, int cat_id, Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				
				if(cat_id==1) {
					Statement stmt = conn.createStatement();	
					String sql = "update credentials set url='"+css.getUrl()+"', username='"+css.getUsername()+"' , password='"+css.getPassword()+"' where cat_id='"+cat_id+"' and cat_id='"+css_id+"' ";
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}
				if(cat_id==2) {
					Statement stmt = conn.createStatement();	
					String sql = "update credentials set doc_num='"+css.getDoc_num()+"', val_date='"+css.getVal_date()+"' , doc_name='"+css.getDoc_name()+"' , cvv='"+css.getCvv()+"' where cat_id='"+cat_id+"' and css_id='"+css_id+"' ";
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}
				if(cat_id==3) {
					Statement stmt = conn.createStatement();	
					String sql = "update credentials set doc_num='"+css.getDoc_num()+"', type_info='"+css.getType_info()+"', nation='"+css.getNation()+"', doc_name='"+css.getDoc_name()+"' , address='"+css.getAddress()+"', val_date='"+css.getVal_date()+"'  where cat_id='"+cat_id+"' and css_id='"+css_id+"' ";
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}
				if(cat_id==4 || cat_id==5) {
					Statement stmt = conn.createStatement();	
					String sql = "update credentials set doc_num='"+css.getDoc_num()+"', doc_name='"+css.getDoc_name()+"' , val_date='"+css.getVal_date()+"', address='"+css.getAddress()+"'  where cat_id='"+cat_id+"' and css_id='"+css_id+"' ";
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}
				if(cat_id==6) {
					Statement stmt = conn.createStatement();	
					String sql = "update credentials set doc_num='"+css.getDoc_num()+"', doc_name='"+css.getDoc_name()+"', doc_name='"+css.getType_info()+"' , val_date='"+css.getVal_date()+"', address='"+css.getAddress()+"'  where cat_id='"+cat_id+"' and css_id='"+css_id+"' ";
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}

