package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.service.BookTO;
import library.service.RequestTO;
import library.service.ReserveTO;
import library.service.UserTO;
import library.util.DBConnection;

public class ReservedaoImpl extends Reservedao {
	public void addReserve(ReserveTO rt) {

		try {

			String isbn = rt.getISBN();
			String user = rt.getUsername();

			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("insert into reserve(Username,ISBN,isnotify) values(?,?,?)");
			ps.setString(1, user);
			ps.setString(2, isbn);
			ps.setInt(3, 0);
			int i = ps.executeUpdate();

			con.close();

		} catch (Exception e) {

		}

	}

	public int checkReservation(ReserveTO rt) {

		try {

			String isbn = rt.getISBN();
			String user = rt.getUsername();

			Connection con = DBConnection.createConnection();
			// PreparedStatement ps=con.prepareStatement("insert into
			// reserve(Username,ISBN,Category,Image,Username,Status) values(?,?,?,?,?,?)");
			PreparedStatement ps = con.prepareStatement("select *from reserve where ISBN=? and Username=?");

			ps.setString(1, isbn);
			ps.setString(2, user);

			ResultSet rs = ps.executeQuery();
			// System.out.println("hello6="+(rs.getString("Username")));
			rs.next();
			if (rs.getString("Username") != null) {
				return -1;
			}

			con.close();

		} catch (Exception e) {

		}
		return 1;

	}

	public int checkTransaction(ReserveTO rt) {
		try {
			String isbn = rt.getISBN();
			String user = rt.getUsername();

			Connection con = DBConnection.createConnection();

			PreparedStatement ps2 = con.prepareStatement("select *from transaction where ISBN=? and Username=?");

			ps2.setString(1, isbn);
			ps2.setString(2, user);
			ResultSet rs1 = ps2.executeQuery();

			rs1.next();
			if (rs1.getString("Username") != null) {
				con.close();
				return 0;
			} else {
				con.close();
			}

		} catch (Exception e) {

		}

		return 1;
	}

	public ArrayList<ReserveTO> fetchReservations(String username) {

		ArrayList<ReserveTO> rto = new ArrayList<>();

		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from reserve where Username=?");

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ReserveTO rto1 = new ReserveTO();
				rto1.setId(rs.getInt("ReserveId"));
				rto1.setISBN(rs.getString("ISBN"));
				rto1.setUsername(rs.getString("Username"));

				rto.add(rto1);
			}

			con.close();
		} catch (Exception e) {

			return rto;
		}

		return rto;
	}

	public ArrayList<ReserveTO> verifyReservation(String isbn) {
		ArrayList<ReserveTO> rta = new ArrayList<>();
		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from reserve where ISBN=?");
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReserveTO rt = new ReserveTO();
				rt.setId(rs.getInt("ReserveId"));
				rt.setISBN(rs.getString("ISBN"));
				rt.setUsername(rs.getString("Username"));
				rta.add(rt);
			}
		} catch (Exception e) {

		}
		return rta;
	}

	public ReserveTO fetchnonnotify(String isbn) {

		ReserveTO rt = new ReserveTO();
		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from reserve where ISBN=? && isnotify=?");
			ps.setString(1, isbn);
			ps.setInt(2, 0);
			ResultSet rs = ps.executeQuery();
			rs.next();

			rt.setId(rs.getInt("ReserveId"));
			rt.setISBN(rs.getString("ISBN"));
			rt.setUsername(rs.getString("Username"));
			rt.setNotify(rs.getInt("isnotify"));
			con.close();
		} catch (Exception e) {

		}

		return rt;
	}

	public void marknotify(int id) {
		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("update reserve set isnotify=? where ReserveId=?");
			ps.setInt(1, 1);
			ps.setInt(2, id);

			int result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {

		}
	}

	public void cancelReserve(String isbn, String username) {

		try {
			Connection con = DBConnection.createConnection();

			PreparedStatement ps = con.prepareStatement("delete from reserve where ISBN = ? and Username=? ");
			ps.setString(1, isbn);
			ps.setString(2, username);
			int i = ps.executeUpdate();
			// boolean i=ps.execute();

			con.close();
		} catch (Exception e) {

		}
	}

}
