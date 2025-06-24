package dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import db.DBconnect;
import entity.Feedback;
import entity.Payment;

public class FeedbackDbcImpl implements FeedbackDbc {

	public boolean addFeedback(int user_id, String name, String email, String rate, String feedback) {

		Connection con = null;
		boolean f = false;
		PreparedStatement ps = null;

		try {

			con = DBconnect.getcon();

			String sql = "insert into feedback (User_id,Name,Email,rate,feedback) values(? , ? , ? , ? , ?)";

			ps = con.prepareStatement(sql);

			ps.setInt(1, user_id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, rate);
			ps.setString(5, feedback);

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected == 1) {

				f = rowsAffected > 0;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Feedback> getAllFd() {

		List<Feedback> fblist = new ArrayList<Feedback>();

		Feedback fb = null;
		Connection con = null;
		PreparedStatement ps = null;

		ResultSet rs = null;

		try {
			

			con = DBconnect.getcon();

			String sql = "select * from feedback ";

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				fb = new Feedback();

				fb.setFeedbackid(rs.getInt(2));
				fb.setName(rs.getString(3));
				fb.setEmail(rs.getString(4));
				fb.setRate(rs.getString(5));
				fb.setFeedback(rs.getString(6));

				
				fblist.add(fb);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fblist;
	}

	public Feedback getFdById(int id) {
		Feedback fb = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = DBconnect.getcon();

			String sql = "select * from feedback where Feedback_id = ?";

			ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			
			rs = ps.executeQuery();

			while (rs.next()) {

				fb = new Feedback();

				fb.setFeedbackid(rs.getInt(2));
				fb.setName(rs.getString(3));
				fb.setEmail(rs.getString(4));
				fb.setRate(rs.getString(5));
				fb.setFeedback(rs.getString(6));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return fb;
	}

	public boolean FeedbackEdit(Feedback fb) {
		
		Connection con = null;
		PreparedStatement ps = null;
		boolean f = false;
		
		
		
		try {
			
			
			con = DBconnect.getcon();
			
			String sql = "update feedback set Name=? , Email =? , rate = ? , feedback = ? where Feedback_id = ? ";
			
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getEmail());
			ps.setString(3, fb.getRate());
			ps.setString(4, fb.getFeedback());
			ps.setInt(5, fb.getFeedbackid());
			
			int i = ps.executeUpdate();
			
			if (i == 1) {

				f = true;

			}
			
	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		

		return f;
	}
	
	
	public boolean DeleteFeedback(int id) {

		
		Connection con = null;
		
		boolean f = false;

		try {

			
			con = DBconnect.getcon();
			
			String sql = "delete from feedback where Feedback_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {

				f = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
		
	}
	
	
	
	
	

}
