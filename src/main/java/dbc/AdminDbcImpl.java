package dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import db.DBconnect;

public class AdminDbcImpl implements AdminDbc {

	@SuppressWarnings("unused")
	public void incrementVisitCount(int userId) {

		try {

			Connection con = DBconnect.getcon();

			String query = "UPDATE user SET visit_count = visit_count + 1 WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, userId);

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected == 0) {
				System.out.println("No rows updated. ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int getTotalVisits() {
	    int totalVisits = 0;

	    try {
	        Connection con = DBconnect.getcon();
	        String query = "SELECT SUM(visit_count) AS total_visits FROM user";
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            totalVisits = rs.getInt("total_visits");
	            System.out.println("totalVisits");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return totalVisits;
	}


	public double getTotalPayments() {

		double totalPayments = 0.0;

		try (Connection con = DBconnect.getcon()) {

			String query = "SELECT amount FROM payments";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String amountStr = rs.getString("amount");
				if (amountStr != null && !amountStr.isEmpty()) {
					try {
						double amount = Double.parseDouble(amountStr);
						totalPayments += amount;
					} catch (NumberFormatException e) {
						System.out.println("Invalid amount: " + amountStr);
					}
				}
			}
			System.out.println("Total Payments calculated: " + totalPayments); // Log the total

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return totalPayments;
	}

}
