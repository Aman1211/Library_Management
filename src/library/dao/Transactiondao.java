package library.dao;
import java.sql.*;
import java.util.ArrayList;
import library.service.*;
import library.util.DBConnection;
public class Transactiondao extends TransactiondaoService {
 
	public void issue(TransactionTO tt)
	{
		try {
		 Connection con=DBConnection.createConnection();
		 java.sql.Date idate=new java.sql.Date(tt.getIssuedate().getTime());
		 java.sql.Date ddate=new java.sql.Date(tt.getDuedate().getTime());
		  PreparedStatement ps=con.prepareStatement("insert into transaction(Username,ISBN,IssueDate,DueDate,Fine) values(?,?,?,?,?)");
		  ps.setString(1, tt.getUsername());
		  ps.setString(2,tt.getISBN());
		  ps.setDate(3,idate);
		  ps.setDate(4, ddate);
		  ps.setDouble(5, tt.getFine());
		  int i=ps.executeUpdate();  
		  con.close();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public TransactionTO fetchTransaction(String uname,String isbn)
	{
		TransactionTO tt=new TransactionTO();
		try {
			 Connection con=DBConnection.createConnection();
			 PreparedStatement ps=con.prepareStatement("select * from transaction where Username=? and ISBN=?");
			 ps.setString(1,uname);
			 ps.setString(2,isbn);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 tt.setDuedate(rs.getDate("DueDate"));
			 
		}
		catch(Exception e)
		{}
		return tt;
	}
}
