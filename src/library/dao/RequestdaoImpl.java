package library.dao;

import java.sql.*;
import library.service.*;
import library.util.DBConnection;
import java.util.ArrayList;

public class RequestdaoImpl extends Requestdao {
	public void addRequest(RequestTO rt) {
		try {
			String title = rt.getTitle();
			String author = rt.getAuthor();
			String cat = rt.getCategory();
			String path = rt.getImage();
			String user = rt.getUsername();

			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into request(Title,Author,Category,Image,Username,Status) values(?,?,?,?,?,?)");
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setString(3, cat);
			ps.setString(4, path);
			ps.setString(5, user);
			ps.setInt(6, 0);
			int i = ps.executeUpdate();
			con.close();
		} catch (Exception e) {

		}

	}

	public ArrayList<RequestTO> fetchRequests(String username) {
		ArrayList<RequestTO> rto = new ArrayList<>();

		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from request where Username=? ");

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RequestTO rto1 = new RequestTO();
				rto1.setId(rs.getInt("RequestId"));
				rto1.setTitle(rs.getString("Title"));
				rto1.setAuthor(rs.getString("Author"));
				rto1.setCategory(rs.getString("Category"));

				rto1.setImage(rs.getString("Image"));
				rto1.setStatus(rs.getBoolean("Status"));

				rto.add(rto1);
			}

			con.close();
		} catch (Exception e) {
			return rto;
		}

		return rto;
	}

	public ArrayList<RequestTO> fetchRequests() {
		ArrayList<RequestTO> rto = new ArrayList<>();

		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from request where Status=? ");

			ps.setInt(1, 0);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RequestTO rto1 = new RequestTO();
				rto1.setId(rs.getInt("RequestId"));
				rto1.setTitle(rs.getString("Title"));
				rto1.setAuthor(rs.getString("Author"));
				rto1.setCategory(rs.getString("Category"));
				rto1.setImage(rs.getString("Image"));
				rto.add(rto1);
			}

			con.close();
		} catch (Exception e) {
			return rto;
		}

		return rto;
	}

	public RequestTO getRequest(int id) {
		RequestTO rto = new RequestTO();
		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from request where RequestId=?");

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			rto.setId(rs.getInt("RequestId"));
			rto.setTitle(rs.getString("Title"));
			rto.setAuthor(rs.getString("Author"));
			rto.setCategory(rs.getString("Category"));
			rto.setImage(rs.getString("Image"));
			rto.setUsername(rs.getString("Username"));
			con.close();
		} catch (Exception e) {
			return rto;
		}

		return rto;
	}

	public void removeRequest(int id) {
		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("update request set Status=? where RequestId=?");

			ps.setInt(1, 1);
			ps.setInt(2, id);
			ps.executeUpdate();

			con.close();
		} catch (Exception e) {
		}

	}
}
