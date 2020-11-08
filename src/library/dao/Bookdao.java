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

public class Bookdao {
	//to fetch the books which matches keyword
     public ArrayList<BookTO>fetchBook(String key)
     {
    	 ArrayList<BookTO>bt=new ArrayList<>();
     
	try {
	Connection con=DBConnection.createConnection();
	PreparedStatement ps=con.prepareStatement(  
	    "select * from book where Title LIKE ? or ISBN like ? or Author like ? or Category like ?");  
	  
	ps.setString(1,"%"+ key + "%");
	ps.setString(2,"%"+ key + "%");
	ps.setString(3,"%"+ key + "%");
	ps.setString(4,"%"+ key + "%");
	ResultSet rs=ps.executeQuery();  
	while(rs.next())
	{
		BookTO bto=new BookTO();
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
}catch(Exception e)
{ 
	
}
	return bt;
  }
    // to fetch all the books 
 public ArrayList<BookTO>fetchAll()
     {
    	 ArrayList<BookTO>bt=new ArrayList<>();
     
	try {
	Connection con=DBConnection.createConnection();
	PreparedStatement ps=con.prepareStatement(  
	    "select * from book");  
	  
	
	ResultSet rs=ps.executeQuery();  
	while(rs.next())
	{
		BookTO bto=new BookTO();
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
}catch(Exception e)
{ 
	
}
	return bt;
     }
 public void deleteBook(String isbn)
	{
	 System.out.println("step4");
		try {
		  Connection con=DBConnection.createConnection();
		
		  PreparedStatement ps=con.prepareStatement("delete from book where ISBN = ?");
		  ps.setString(1,isbn);
		 
		  int i=ps.executeUpdate();
		  //boolean i=ps.execute();
		  System.out.println(i+" book deleted");  
		    
		  con.close();  
		}catch(Exception e)
		{
			
		}
		}
 public BookTO getBook(String isbn)
	{

	 BookTO bto=new BookTO();	 
	 try {

		 Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement(  
			    "select * from book where ISBN = ?");  
			ps.setString(1,isbn);  

			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{					
				bto.setISBN(rs.getString("ISBN"));
			
				bto.setTitle(rs.getString("Title"));
				bto.setAuthor(rs.getString("Author"));
				bto.setCategory(rs.getString("Category"));
				bto.setQty(rs.getInt("Qty"));
				bto.setImage(rs.getString("Image"));
				bto.setRack(rs.getInt("Rackno"));
			
			}

			con.close();
		}catch(Exception e)
		{ 
			
		}
			return bto; 
	}
 
	
 
   

}
