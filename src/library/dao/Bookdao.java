package library.dao;

import java.sql.*;
import library.service.*;
import library.util.DBConnection;
import library.util.DBConnection.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Bookdao extends BookdaoService {
	// to fetch the books which matches keyword
	public ArrayList<BookTO> fetchBook(String key) {
		ArrayList<BookTO> bt = new ArrayList<>();

		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement(
					"select * from book where Title LIKE ? or ISBN like ? or Author like ? or Category like ?");

			ps.setString(1, "%" + key + "%");
			ps.setString(2, "%" + key + "%");
			ps.setString(3, "%" + key + "%");
			ps.setString(4, "%" + key + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookTO bto = new BookTO();
				bto.setISBN(rs.getString("ISBN"));
				bto.setTitle(rs.getString("Title"));
				bto.setAuthor(rs.getString("Author"));
				bto.setCategory(rs.getString("Category"));
				bto.setQty(rs.getInt("Qty"));
				bto.setImage(rs.getString("Image"));
				bto.setRack(rs.getInt("Rackno"));
				bt.add(bto);
			}

			con.close();
		} catch (Exception e) {

		}
		return bt;
	}

	// to fetch all the books
	public ArrayList<BookTO> fetchAll() {
		ArrayList<BookTO> bt = new ArrayList<>();

		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from book");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookTO bto = new BookTO();
				bto.setISBN(rs.getString("ISBN"));
				bto.setTitle(rs.getString("Title"));
				bto.setAuthor(rs.getString("Author"));
				bto.setCategory(rs.getString("Category"));
				bto.setQty(rs.getInt("Qty"));
				bto.setImage(rs.getString("Image"));
				bto.setRack(rs.getInt("Rackno"));
				bt.add(bto);
			}

			con.close();
		} catch (Exception e) {

		}
		return bt;
	}

	public void deleteBook(String isbn) {
		System.out.println("step4");
		try {
			Connection con = DBConnection.createConnection();

			PreparedStatement ps = con.prepareStatement("delete from book where ISBN = ?");
			ps.setString(1, isbn);

			int i = ps.executeUpdate();
			// boolean i=ps.execute();
			System.out.println(i + " book deleted");

			con.close();
		} catch (Exception e) {

		}
	}

	public BookTO getBook(String isbn) {

		BookTO bto = new BookTO();
		try {

			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from book where ISBN = ?");
			ps.setString(1, isbn);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bto.setISBN(rs.getString("ISBN"));

				bto.setTitle(rs.getString("Title"));
				bto.setAuthor(rs.getString("Author"));
				bto.setCategory(rs.getString("Category"));
				bto.setQty(rs.getInt("Qty"));
				bto.setImage(rs.getString("Image"));
				bto.setRack(rs.getInt("Rackno"));

			}

			con.close();
		} catch (Exception e) {

		}
		return bto;
	}
	
	public void updateBook(BookTO bt)
	{
		try {

			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("update book set Title=?,Author=?,Qty=?,Category=?,Rackno=? where ISBN = ?");
			ps.setString(1, bt.getTitle());
			ps.setString(2, bt.getAuthor());
			ps.setInt(3, bt.getQty());
			ps.setString(4,bt.getCategory());
			ps.setInt(5,bt.getRack());
			ps.setString(6,bt.getISBN());

			 ps.executeUpdate();
			 con.close();
		}
		catch(Exception e) {}
	}
	
	public void updateBook1(BookTO bt)
	{
		try {

			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("update book set Title=?,Author=?,Qty=?,Category=?,Image=?,Rackno=? where ISBN = ?");
			ps.setString(1, bt.getTitle());
			ps.setString(2, bt.getAuthor());
			ps.setInt(3, bt.getQty());
			ps.setString(4,bt.getCategory());
			ps.setNString(5, bt.getImage());
			ps.setInt(6,bt.getRack());
			ps.setString(7,bt.getISBN());

			 ps.executeUpdate();
			 con.close();
		}
		catch(Exception e) {}
	}

	public BookTO Exists(String isbn) {
		BookTO bb = new BookTO();
		try {

			Connection con = DBConnection.createConnection();

			PreparedStatement ps = con.prepareStatement("select * from book where ISBN=?");

			ps.setString(1, isbn);

			ResultSet rs = ps.executeQuery();
			rs.next();
			bb.setISBN(rs.getString("ISBN"));
			bb.setTitle(rs.getString("Title"));
			bb.setAuthor(rs.getString("Auther"));
			bb.setCategory(rs.getString("Category"));
			bb.setQty(rs.getInt("Qty"));
			bb.setImage(rs.getString("Image"));
			bb.setRack(rs.getInt("Rack")); // here check only Rack or Rackno as in db

			con.close();
		} catch (Exception e) {
			return bb;
		}

		return bb;
	}

	public void addBook(String ISBN, String Title, String Author, String Category, int Qty, String Image, int Rack) {
		System.out.println("add process in db");

		try {

			System.out.println(ISBN + Title + Author + Qty + Rack);
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?,?,?,?,?)");
			ps.setString(1, ISBN);
			ps.setString(2, Title);
			ps.setString(3, Author);
			ps.setInt(4, Qty);
			ps.setString(5, Category);
			ps.setString(6, Image);
			ps.setInt(7, Rack);
			int i = ps.executeUpdate();
			System.out.println(i + " records inserted");

			con.close();
		} catch (Exception e) {

		}
	}
	
	public void decrementcnt(BookTO bt)
	{
		try {
            bt.setQty(bt.getQty()-1);
			Connection con = DBConnection.createConnection();

			PreparedStatement ps = con.prepareStatement("update book set Qty=? where ISBN=?");

			ps.setInt(1,bt.getQty());
			ps.setString(2,bt.getISBN());
     
			int i = ps.executeUpdate();
			con.close();
	}
		catch(Exception e)
		{
		}
		}

}
