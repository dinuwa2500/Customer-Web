package dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import db.DBconnect;
import entity.User;
import entity.Package;

public class PckImpl implements PckDbc {

	private Connection con;

	public PckImpl(Connection con) {
		super();
		this.con = con;
	}

	public boolean AddPck(Package pck) {

		boolean f = false;

		try {

			String sql = "insert into packages(Userid,full_name,package_name,ph_no,duration,price,pMethod) values(? , ? ,? , ? , ? , ? , ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, pck.getUserId());
			ps.setString(2, pck.getFull_name());
			ps.setString(3, pck.getPcktype());
			ps.setString(4, pck.getNum());
			ps.setString(5, pck.getDuration());
			ps.setString(6, pck.getPrice());
			ps.setString(7, pck.getpMethod());

			int i = ps.executeUpdate();

			if (i == 1) {

				f = true;

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return f;
	}

	public List<Package> getAllPck(int userId) {

		List<Package> list = new ArrayList<Package>();
		Package p = null;
		PreparedStatement ps = null;

		try {

			

			String sql = "select * from packages where Userid = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, userId);

			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				p = new Package();

				p.setPckid(rs.getInt(2));
				p.setFull_name(rs.getString(3));
				p.setPcktype(rs.getString(4));
				p.setNum(rs.getString(5));
				p.setDuration(rs.getString(6));
				p.setPrice(rs.getString(7));
				p.setpMethod(rs.getString(8));

				list.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * System.out.println(userId); System.out.println(list);
		 */
		return list;
	}

	@SuppressWarnings("null")
	public Package getPckById(int id) {

		Package p = null;
		PreparedStatement ps = null;
		
		
		try {
			
		
			
			String sql = "select * from packages where package_id =?";
			
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				p = new Package();
				
				p.setPckid(rs.getInt(2));
				p.setFull_name(rs.getString(3));
				p.setPcktype(rs.getString(4));
				p.setNum(rs.getString(5));
				p.setDuration(rs.getString(6));
				p.setPrice(rs.getString(7));
				p.setpMethod(rs.getString(8));
				
				
		
			}
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		return p;
			
	}

	@Override
	public boolean updateEditPck(Package p) {


		boolean f = false;
		PreparedStatement ps = null;
		
		
		try {
			
			
			String sql = "update packages set full_name = ? , package_name = ? , ph_no = ? , duration = ? , price = ? , pMethod= ? where package_id = ?";
			
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, p.getFull_name());
			ps.setString(2, p.getPcktype());
			ps.setString(3, p.getNum());
			ps.setString(4, p.getDuration());
			ps.setString(5, p.getPrice());
			ps.setString(6, p.getpMethod());
			ps.setInt(7, p.getPckid());
			
			
			int i = ps.executeUpdate();

			if (i == 1) {

				f = true;

			}
			
		} catch (Exception e) {

				e.printStackTrace();
		}
		
		
		
		
		
		return f;
	}

	
	public boolean deletePck(int id) {
		
		
		boolean f = false;

		try {

			String sql = "delete from packages where package_id = ?";

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