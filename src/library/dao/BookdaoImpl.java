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

public class BookdaoImpl extends Bookdao {
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
	public ArrayList<BookTO> top3mostissuedbook(String date) {

		ArrayList<BookTO> bt = new ArrayList<>();

		String[] ans = date.trim().split("-");

		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement(
					"select count(*) as count1,ISBN from transaction where ?=month(IssueDate) and ?=year(IssueDate) group by ISBN having count(*) >=(select *from (select distinct(p2.count) as countt from(select count(*) as count,ISBN from transaction where ?=month(IssueDate) and ?=year(IssueDate) group by ISBN order by count(*) desc)as p2 limit 3) as p order by p.countt limit 1)order by count(*) desc");
			ps.setString(1, ans[1]);
			ps.setString(2, ans[0]);
			ps.setString(3, ans[1]);
			ps.setString(4, ans[0]);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				PreparedStatement ps1 = con.prepareStatement("select * from book where ISBN=?");
				ps1.setString(1, rs.getString("ISBN"));
				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {

					BookTO bto = new BookTO();
					bto.setISBN(rs1.getString("ISBN"));
					bto.setTitle(rs1.getString("Title"));
					bto.setAuthor(rs1.getString("Author"));
					bto.setCategory(rs1.getString("Category"));
					bto.setQty(rs1.getInt("Qty"));
					bto.setImage(rs1.getString("Image"));
					// in rack count will be stored
					bto.setRack(rs.getInt("count1"));
					bt.add(bto);

				}

			}

			con.close();
		} catch (Exception e) {
			System.out.println("erro=" + e.getMessage());
		}
		return bt;
	}

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

	public void updateBook(BookTO bt) {
		try {

			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con
					.prepareStatement("update book set Title=?,Author=?,Qty=?,Category=?,Rackno=? where ISBN = ?");
			ps.setString(1, bt.getTitle());
			ps.setString(2, bt.getAuthor());
			ps.setInt(3, bt.getQty());
			ps.setString(4, bt.getCategory());
			ps.setInt(5, bt.getRack());
			ps.setString(6, bt.getISBN());

			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
		}
	}

	public void updateBook1(BookTO bt) {
		try {

			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement(
					"update book set Title=?,Author=?,Qty=?,Category=?,Image=?,Rackno=? where ISBN = ?");
			ps.setString(1, bt.getTitle());
			ps.setString(2, bt.getAuthor());
			ps.setInt(3, bt.getQty());
			ps.setString(4, bt.getCategory());
			ps.setNString(5, bt.getImage());
			ps.setInt(6, bt.getRack());
			ps.setString(7, bt.getISBN());

			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
		}
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
			bb.setAuthor(rs.getString("Author"));
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

	public void decrementcnt(BookTO bt) {
		try {
			bt.setQty(bt.getQty() - 1);
			Connection con = DBConnection.createConnection();

			PreparedStatement ps = con.prepareStatement("update book set Qty=? where ISBN=?");

			ps.setInt(1, bt.getQty());
			ps.setString(2, bt.getISBN());

			int i = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
		}
	}

}
