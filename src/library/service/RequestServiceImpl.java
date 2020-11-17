package library.service;
import java.io.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import library.dao.*;
import java.util.*;
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;
public class RequestServiceImpl extends RequestService{

	public boolean addRequest(RequestTO rt,HttpServletResponse res,HttpServletRequest req,Part image)
	{
	   
        String SAVE_DIR="\\WebContent\\images";
		String appPath = req.getServletContext().getRealPath("/");
		String[] path=appPath.split("\\.metadata");
		  appPath=path[0];
		  String projectname[]=path[1].split("\\wtpwebapps");
		  projectname[1] = projectname[1].substring(1, projectname[1].length() - 1); 
		  SAVE_DIR=projectname[1]+SAVE_DIR;
		String savePath = appPath+ SAVE_DIR;
	       
		 String photo="images/"+rt.getImage();
         System.out.println(savePath);
         System.out.println(savePath + File.separator + rt.getImage());
         File file=new File(savePath);
         try {
          image.write(savePath + File.separator + rt.getImage());
         }
         catch(Exception e) {}
         rt.setImage(photo);
       		rdao.addRequest(rt);
         return true;
	}
	
	public ArrayList<RequestTO> getRequests(String username)
	{
		return rdao.fetchRequests(username);
	}
      
	public ArrayList<RequestTO> getRequests()
	{
		return rdao.fetchRequests();
	}
	public void approveRequest(int id)
	{
	
	    RequestTO rto=rdao.getRequest(id);
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
       return new PasswordAuthentication("aman.sharma122111@gmail.com","aman$1234");  
         }  
       });  
     
      //Compose the message  
       try {  
        MimeMessage message = new MimeMessage(session);  
        message.setFrom(new InternetAddress("aman.sharma122111@gmail.com"));  
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(rto.getUsername()));
        message.setSubject("Book Request Approved");  
        message.setContent("<b> Hello,</b><br><h2> Requested Book with the following details has been added to Catalogue</h2><br>"
        		+ "Book Title:-" + rto.getTitle() + "<br>" + "Book Author:-"  + rto.getAuthor() + "<br>" + "Book Category:-"  + rto.getCategory() +"<br><br> Regards,<br>Library Admin.","text/html");  
 
        // Send message  
        Transport.send(message);  
        System.out.println("message sent successfully....");  
 
     }catch (MessagingException mex) {mex.printStackTrace();}
	    rdao.removeRequest(id);
	}
      
        
	private Requestdao rdao=new Requestdao();
}
