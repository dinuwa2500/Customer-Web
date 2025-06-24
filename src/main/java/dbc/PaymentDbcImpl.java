package dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBconnect;
import entity.Package;
import entity.Payment;

public class PaymentDbcImpl implements PaymentDbc {

	@Override
	public boolean addPayment(int userid, String cardName, String cardNumber, String expiryDate, String Cvv,
			String Amount) {

		Connection con = null;
		boolean f = false;
		PreparedStatement ps = null;

		try {

			con = DBconnect.getcon();

			String sql = "insert into payments(Userid,cardowner,cardnumber,expiremy,cvv,amount) values (? , ? , ? , ? , ? , ? )";

			ps = con.prepareStatement(sql);

			ps.setInt(1, userid);
			ps.setString(2, cardName);
			ps.setString(3, cardNumber);
			ps.setString(4, expiryDate);
			ps.setString(5, Cvv);
			ps.setString(6, Amount);

			int rowsAffected = ps.executeUpdate();
			f = rowsAffected > 0;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return f;
	}

	public List<Payment> getAllPay() {

		List<Payment> plist = new ArrayList<Payment>();

		Payment py = null;
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = DBconnect.getcon();

			String sql = "select * from payments";

			ps = con.prepareStatement(sql);



			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				py = new Payment();

				py.setPayid(rs.getInt(2));
				py.setCardname(rs.getString(3));
				py.setCardnumber(rs.getString(4));
				py.setExpirydate(rs.getString(5));
				py.setCvv(rs.getString(6));
				py.setAmount(rs.getString(7));

				plist.add(py);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return plist;
	}

	public Payment getPaymentById(int id) {

		Payment py = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = DBconnect.getcon();

			String sql = "select * from payments where payid = ?";

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				py = new Payment();

				py.setPayid(rs.getInt(2));
				py.setCardname(rs.getString(3));
				py.setCardnumber(rs.getString(4));
				py.setExpirydate(rs.getString(5));
				py.setCvv(rs.getString(6));
				py.setAmount(rs.getString(7));

			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return py;
	}


	public boolean deletePayment(int id) {
	
		
		Connection con = null;
		PreparedStatement ps = null;
		boolean f = false;
		
		
		try {
			
			con = DBconnect.getcon();
			
			String sql = "delete from payments where payid = ?";

			ps = con.prepareStatement(sql);
			
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
