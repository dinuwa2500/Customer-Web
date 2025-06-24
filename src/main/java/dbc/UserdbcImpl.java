
 package dbc;
 
 /* 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet;
 * 
 * import entity.User;
 * 
 * 
 * public class UserdbcImpl implements Userdbc {
 * 
 * 
 * 
 * private Connection con;
 * 
 * 
 * 
 * public UserdbcImpl(Connection con) { super(); this.con = con;
 * 
 * }
 * 
 * public Boolean UserRegister(User us) {
 * 
 * boolean f = false;
 * 
 * try {
 * 
 * String Sql =
 * "insert into user(fname,lname,email,phno,password) values (?, ? ,? ,?,?)";
 * PreparedStatement ps = con.prepareStatement(Sql); ps.setString(1,
 * us.getFname()); ps.setString(2, us.getLname()); ps.setString(3,
 * us.getEmail()); ps.setString(4, us.getPhno()); ps.setString(5,
 * us.getPassword());
 * 
 * int i = ps.executeUpdate(); if (i == 1) {
 * 
 * f = true;
 * 
 * }
 * 
 * } catch (Exception e) {
 * 
 * System.out.println("error in this file"); //
 * Logger.severe("Data insertion failed: " + e.getMessage());
 * e.printStackTrace(); // This helps in detailed debugging (optional) }
 * 
 * return f; }
 * 
 * public User UserLogin(String email, String password) {
 * 
 * User us = null;
 * 
 * try {
 * 
 * String sql = "select * from user where email =? and password = ?";
 * PreparedStatement ps = con.prepareStatement(sql); ps.setString(1, email);
 * ps.setString(2, password);
 * 
 * ResultSet rs = ps.executeQuery(); while (rs.next()) {
 * 
 * us = new User(); us.setId(rs.getInt(1)); us.setFname(rs.getString(2));
 * us.setLname(rs.getString(3)); us.setEmail(rs.getString(4));
 * us.setPhno(rs.getString(5)); us.setPassword(rs.getString(6));
 * 
 * 
 * 
 * }
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace();
 * 
 * } return us;
 * 
 * }
 * 
 * }
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBconnect;
import entity.User;

public class UserdbcImpl implements Userdbc{

	// Insert Data Function
	public boolean insertData(String fname, String lname, String email, String phno,String password) {
			boolean isSuccess = false;
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				// DB CONNECTION CALL
				con = DBconnect.getcon();

				
				// SQL QUERY
				String sql = "insert into user(fname,lname,email,phno,password) values (?, ? ,? ,?,?)";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, fname);
				pstmt.setString(2, lname);
				pstmt.setString(3, email);
				pstmt.setString(4, phno);
				pstmt.setString(5, password);

				int rowsAffected = pstmt.executeUpdate();
				isSuccess = rowsAffected > 0; // Check if insert was successful

			} catch (SQLException e) {
				e.printStackTrace(); // Handle exception (could be logged)
			} finally {
				// Close resources
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace(); // Handle exception on close

	
				}
				
				}
			return isSuccess;
			}
	
	public User UserLogin(String email, String password) {

		
		Connection con= null;
		ResultSet rs=null;
		User us = null;


		try {

			con = DBconnect.getcon();
			
			String sql = "select * from user where email =? and password = ?";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			rs = ps.executeQuery();
			while (rs.next()) {

				us = new User();
				us.setId(rs.getInt(1));
				us.setFname(rs.getString(2));
				us.setLname(rs.getString(3));
				us.setEmail(rs.getString(4));
				us.setPhno(rs.getString(5));
				us.setPassword(rs.getString(6));
			
		
		
			}


		} catch (Exception e) {

			e.printStackTrace();

		}
		return us;

	}
	
	
	
	
	
	
	
}
