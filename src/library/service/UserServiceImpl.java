package library.service;
import library.model.*;
import java.io.IOException;
import library.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;
import java.util.*;


public class UserServiceImpl extends UserService{
	
	
	public ArrayList<UserTO>fetchAll()
	{
	    return dao.fetchAll();
	}
	public UserTO Verify(UserTO user) 
	{
		 String username=user.getUsername();
		 String password=user.getPassword();
		 
		 UserTO ub=dao.Find(username,password);
		 return ub;
	}
	
<<<<<<< HEAD
	public UserTO getUser(String uname)
	{
		return dao.Exists(uname);
	}
=======
	public ArrayList<UserTO>fetchAll()
	   {
		   ArrayList<UserTO>ut=new ArrayList<>();
		   ut=dao.fetchAll();
		   return ut;
	   }
	
	
	public UserTO getUser(String username) {
		
		 return dao.getUser(username);
	    }
	
	public void editProfile(UserTO ut, String uname)
	 {
		 dao.updateProfile(ut, uname);
	 }
>>>>>>> 883800dc5be2de6867440a014564755a118f6ed4

	public boolean addUser(UserTO user)
	{
	    String username=user.getUsername();
	    String password=user.getPassword();
	    UserTO ub=dao.Exists(username);
	   
	    if(ub.getUsername()!=null)
	    {
	    	return false;
	    }
	    else
	    {
	       long contact=user.getContact();
	       String type=user.getType();
	       String name=user.getName();
	       String role=user.getRole();
	       dao.addUser(username,password,name,contact,type,role);
	       Properties props = new Properties();  
	          
	          props.put("mail.smtp.host", "smtp.gmail.com");    
	          props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class",    
	                    "javax.net.ssl.SSLSocketFactory");    
	          props.put("mail.smtp.auth", "true");    
	          props.put("mail.smtp.port", "465");    
	          //get Session   
	          
	        Session session = Session.getDefaultInstance(props,  
	         new javax.mail.Authenticator() {  
	           protected PasswordAuthentication getPasswordAuthentication() {  
	         return new PasswordAuthentication("lmsecdss@gmail.com","lms$1234");  
	           }  
	         });  
	       
	        //Compose the message  
	         try {  
	          MimeMessage message = new MimeMessage(session);  
	          message.setFrom(new InternetAddress("lmsecdss@gmail.com"));  
	          message.addRecipient(Message.RecipientType.TO,new InternetAddress(username));
	          message.setSubject("Login Credentials of Library Management System"); 
	          
	          message.setContent("<b> Hello " + name + ",</b><br><h3> Please find below the Credentials of Library Management System</h3><br>"
	          		+ "Username:-" + username + "<br>" + "Password:-"  + password + "<br><br> Regards,<br>Library Admin.","text/html");  
	   
	          // Send message  
	          Transport.send(message);  
	          System.out.println("message sent successfully....");  
	   
	       }catch (MessagingException mex) {mex.printStackTrace();}
	    }
	    return true;
	}
	public boolean updateUser(UserTO user,String current_password)
	{
	    String username=user.getUsername();
	    String password=user.getPassword();
	    
	    
	    UserTO ub=dao.currentpassword_check(username,current_password);
	    System.out.print(ub.getName());
	    if(ub.getUsername()==null)
	    {
	    	return false;
	    }
	    else {
	       dao.updateUser(username,password);
	    }
	    return true;
	}

	public boolean forgot(UserTO user)
	{
		String username=user.getUsername();
		UserTO ub=dao.Exists(username);
		if(ub.getUsername()==null)
		{
			return false;
		}
		else
		{
			 Properties props = new Properties();  
	          
	          props.put("mail.smtp.host", "smtp.gmail.com");    
	          props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class",    
	                    "javax.net.ssl.SSLSocketFactory");    
	          props.put("mail.smtp.auth", "true");    
	          props.put("mail.smtp.port", "465");    
	          //get Session   
	          
	        Session session = Session.getDefaultInstance(props,  
	         new javax.mail.Authenticator() {  
	           protected PasswordAuthentication getPasswordAuthentication() {  
	         return new PasswordAuthentication("lmsecdss@gmail.com","lms$1234");  
	           }  
	         });  
	       
	        //Compose the message  
	         try {  
	          MimeMessage message = new MimeMessage(session);  
	          message.setFrom(new InternetAddress("lmsecdss@gmail.com"));  
	          message.addRecipient(Message.RecipientType.TO,new InternetAddress(username));
	          message.setSubject("Password Recovery");  
	          message.setContent("<b> Hello " + ub.getName() + ",</b><br><h3>It seems you have forgotten your password.Following is your current password:</h3><br>"+
	          	 "<b>Password:-"  + ub.getPassword() + " </b><br><br> Regards,<br>Library Admin.","text/html");  
	   
	          // Send message  
	          Transport.send(message);  
	          System.out.println("message sent successfully....");  
	   
	       }catch (MessagingException mex) {mex.printStackTrace();}

		}
		return true;
	}
	
	
	private Userdao dao=new Userdao();
}