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

/**
 * Servlet implementation class Userdao
 */
public class Userdao{
	public UserTO Find(String username,String password)
	{
		
	 boolean status=false;  
	 UserTO ub=new UserTO();
	try{
	
		Connection con=DBConnection.createConnection();
		              
		PreparedStatement ps=con.prepareStatement(  
		    "select * from login where Username=? and Password=?");  
		  
		ps.setString(1,username);  
		ps.setString(2, password);  
		              
		ResultSet rs=ps.executeQuery();  
		status=rs.next();
		ub.setUsername(rs.getString("Username"));
		ub.setPassword(rs.getString("Password"));
		ub.setContact(rs.getLong("Contact"));
		ub.setType(rs.getString("Type"));
		ub.setName(rs.getString("Name"));
		
		con.close();
	}catch(Exception e)
	{ 
		return ub;
	}
	
	return ub;
	}
	
	
	public UserTO Exists(String Username)
	{
		 UserTO ub=new UserTO();
			try{
			
				Connection con=DBConnection.createConnection();
				         
				PreparedStatement ps=con.prepareStatement(  
				    "select * from login where Username=?");  
				  
				ps.setString(1,Username);  
				
				              
				ResultSet rs=ps.executeQuery(); 
				rs.next();
			  ub.setUsername(rs.getString("Username"));
				ub.setPassword(rs.getString("Password"));
				ub.setContact(rs.getLong("Contact"));
				ub.setType(rs.getString("Type"));
				ub.setName(rs.getString("Name"));
				
				
				con.close();
			}catch(Exception e)
			{ 
				return ub;
			}
			
			return ub;
	}
	
	public void addUser(String uname,String pass,String name,long contact,String type,String role)
	{
		try {
		  Connection con=DBConnection.createConnection();
		  PreparedStatement ps=con.prepareStatement("insert into login values(?,?,?,?,?,?)");
		  ps.setString(1, uname);
		  ps.setString(2,pass);
		  ps.setString(3, name);
		  ps.setLong(4,contact);
		  ps.setString(5,type);
		  ps.setString(6, role);
		  int i=ps.executeUpdate();  
		  System.out.println(i+" records inserted");  
		    
		  con.close();  
		}catch(Exception e)
		{
			
		}
		}
	public void updateUser(String uname,String pass)
	{
		try {
		  Connection con=DBConnection.createConnection();
		  PreparedStatement ps=con.prepareStatement("update login " + "set Password=? where Username = ?");
		 
		  ps.setString(1,pass);
		  ps.setString(2, uname);
		  int i=ps.executeUpdate();  
		  System.out.println(i+" records updated");  
		    
		  con.close();  
		}catch(Exception e)
		{
			
		}
		}
	
	public UserTO currentpassword_check(String Username,String current_password)
	{
		 UserTO ub=new UserTO();
			try{

				Connection con=DBConnection.createConnection();
				         
				PreparedStatement ps=con.prepareStatement(  
				    "select * from login where Username=? and Password=?");  
				  
				ps.setString(1,Username);  
				ps.setString(2,current_password);
				              
				ResultSet rs=ps.executeQuery(); 
				rs.next();
			    ub.setUsername(rs.getString("Username"));
				ub.setPassword(rs.getString("Password"));
				ub.setContact(rs.getLong("Contact"));
				ub.setType(rs.getString("Type"));
				ub.setName(rs.getString("Name"));
				
				
				con.close();
			}catch(Exception e)
			{ 
				return ub;
			}
			
			return ub;
	}
		
}


