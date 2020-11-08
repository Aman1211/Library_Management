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
   
 
 public BookTO Exists(String isbn)
	{
		 BookTO bb=new BookTO();
			try{
			
				Connection con=DBConnection.createConnection();
				         
				PreparedStatement ps=con.prepareStatement(  
				    "select * from book where ISBN=?");  
				  
				ps.setString(1,isbn);  
				
				              
				ResultSet rs=ps.executeQuery(); 
				rs.next();
			  bb.setISBN(rs.getString("ISBN"));
			  bb.setTitle(rs.getString("Title"));
			  bb.setAuthor(rs.getString("Auther"));
			  bb.setCategory(rs.getString("Category"));
			  bb.setQty(rs.getInt("Qty"));
			  bb.setImage(rs.getString("Image"));
			  bb.setRack(rs.getInt("Rack")); // here check only Rack or Rackno as in db 
				
				
				con.close();
			}catch(Exception e)
			{ 
				return bb;
			}
			
			return bb;
	}
	
	public void addBook(String ISBN,String Title,String Author,String Category,int Qty,String Image,int Rack)
	{
		System.out.println("add process in db");
		
		try {
			
			System.out.println(ISBN+Title+Author+Qty+Rack);
		  Connection con=DBConnection.createConnection();
		  PreparedStatement ps=con.prepareStatement("insert into book values(?,?,?,?,?,?,?)");
		  ps.setString(1, ISBN);
		  ps.setString(2,Title);
		  ps.setString(3, Author);
		  ps.setInt(4,Qty);
		  ps.setString(5,Category);
		  ps.setString(6, Image);
		  ps.setInt(7,Rack);
		  int i=ps.executeUpdate();  
		  System.out.println(i+" records inserted");  
		    
		  con.close();  
		}catch(Exception e)
		{
			
		}
		} 
 

}
