package library.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserBean
{
	private String Name;
	private String UserName;
	private String Password;
	private long Contact;
	private String Type;
	private String Role;
	private int bookcnt;
	
	
	public UserBean(String name,String user,String pass,long con,String type,String role,int cnt)
	{
		Name=name;
		UserName=user;
		Password=pass;
		Contact=con;
	    Type=type;
	    Role=role;
	    bookcnt=cnt;
	    
	}
	public UserBean()
	{}
	
	
	
	public String getName()
	{
		return Name;
	}
	
	
	public void setName(String name)
	{
		Name=name;
	}
	
	public String getUsername()
	{
		return UserName;
	}
	
	public void setUsername(String name)
	{
		UserName=name;
	}
	public String getPassword()
	{
		return Password;
	}
	
	public void setPassword(String pass)
	{
		Password=pass;
	}
	
	public long getContact()
	{
		return Contact;
	}
	
	public void setContact(long con)
	{
		Contact=con;
	}
	
	public String getType()
	{
		return Type;
	}
	
	public void setType(String type)
	{
		Type=type;
	}
	public String getRole()
	{
		return Role;
	}
	public void setRole(String role)
	{
		Role=role;
	}
	
	public int getCnt()
	{
		return bookcnt;
	}
	
	public void setCnt(int cnt)
	{
		bookcnt=cnt;
	}
	
}
