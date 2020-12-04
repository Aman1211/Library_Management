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
	
public ArrayList<TransactionTO> top3user(String date) {
		
		ArrayList<TransactionTO> to = new ArrayList<>();
		
    String[] ans=date.trim().split("-");

		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select count(*) as count1,Username from transaction where ?=month(IssueDate) and ?=year(IssueDate) group by Username having count(*) >=(select *from (select distinct(p2.count) as countt from(select count(*) as count,Username from transaction where ?=month(IssueDate) and ?=year(IssueDate) group by Username order by count(*) desc)as p2 limit 3) as p order by p.countt limit 1)order by count(*) desc");
			ps.setString(1, ans[1]);
			ps.setString(2, ans[0]);
			ps.setString(3, ans[1]);
			ps.setString(4, ans[0]);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				TransactionTO tt = new TransactionTO();
			//	tt.setISBN(rs.getString("ISBN"));
			//	tt.setTransactionId(rs.getInt("TransactionId"));
				tt.setUsername(rs.getString("Username"));
				//tt.setDuedate(rs.getDate("DueDate"));
				tt.setFine(rs.getDouble("count1"));
				//tt.setIssuedate(rs.getDate("IssueDate"));

				to.add(tt);
			}



			con.close();
		} catch (Exception e) {
                System.out.println("error THIRD="+e.getMessage());
		}
		return to;
	}


	public ArrayList<TransactionTO> totalAmoountOfFine(String date) {
		
		ArrayList<TransactionTO> to = new ArrayList<>();
		
    String[] ans=date.trim().split("-");

		try {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select *from transaction where ?=month(DueDate) and ?=year(DueDate)");
			ps.setString(1, ans[1]);
			ps.setString(2, ans[0]);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				TransactionTO tt = new TransactionTO();
				tt.setISBN(rs.getString("ISBN"));
				tt.setTransactionId(rs.getInt("TransactionId"));
				tt.setUsername(rs.getString("Username"));
				tt.setDuedate(rs.getDate("DueDate"));
				tt.setFine(rs.getDouble("Fine"));
				tt.setIssuedate(rs.getDate("IssueDate"));

				to.add(tt);
			}



			con.close();
		} catch (Exception e) {
                System.out.println("error SECOND="+e.getMessage());
		}
		return to;
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
