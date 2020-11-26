package library.service;
import library.dao.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;
public class TransactionServiceImpl extends TransactionService {

	public boolean verifytransaction(String uname,String isbn)
	{
		ArrayList<ReserveTO>rta=new ArrayList<>();
		 boolean result=false;
		 
		 rta=rdao.verifyReservation(isbn);
		 if(rta.isEmpty())
		 {
			 return true;
		 }
		 ReserveTO rt=rta.get(0);
		 if(rt.getUsername().equalsIgnoreCase(uname))
		 {
			 rdao.cancelReserve(isbn, uname);
			 return true;
		 }
		 else
		 {
			result=false;
		 }
		 return result;
	}
	public void issue(TransactionTO tt)
	{
		System.out.println(tt.getUsername() + " " +tt.getISBN());
	    UserTO ut=udao.Exists(tt.getUsername());
	    
		
        Date idate=new Date();
	    Date ddate;
	    if(ut.getType().equalsIgnoreCase("Student"))
	    {
	    	 ddate=new Date(idate.getTime() + (1000 * 60 * 60 * (24*7)));
	    }
	    else
	    {
	    ddate=new Date(idate.getTime() + (1000 * 60 * 60 * (24*14)));
	    }
		
	    
	    tt.setIssuedate(idate);
	    tt.setDuedate(ddate);
	    tt.setFine(0);
	    tdao.issue(tt);
	    BookTO bt=new BookTO();
	    bt=bdao.getBook(tt.getISBN());
	    udao.incrementcnt(ut);
	    bdao.decrementcnt(bt);
	 	    
	}
	
	public void Notify(String uname,Set s)
	{
		Properties props = new Properties();  
        UserTO ut=udao.Exists(uname);
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
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(uname));
        message.setSubject("Book Issued"); 
        StringBuilder sb=new StringBuilder();
        int cnt=1;
        Iterator itr=s.iterator();  
	    while(itr.hasNext()){  
	        Map.Entry entry=(Map.Entry)itr.next(); 
	        if(entry.getValue().equals(true))
	        {
	        	 BookTO b=bdao.getBook(entry.getKey().toString());
	        	 TransactionTO tt1=tdao.fetchTransaction(uname,b.getISBN());
	        	 sb.append(cnt +". "+ "<b>" + b.getTitle() +"</b>" +"," + b.getAuthor() + ",Duedate:" + tt1.getDuedate()).append("<br>");
	        	 cnt++;
	        }
	    }
        message.setContent("<b> Hello " + ut.getName() + ",</b><br><h3>The following book/s have been issued in your name</h3><br>"
        		+ sb + "<br><br> Regards,<br>Library Admin."
        		,"text/html");  
      
	    
	   
        Transport.send(message);  
        System.out.println("message sent successfully....");  
 
     }catch (MessagingException mex) {mex.printStackTrace();}

	}
	
	Reservedao rdao=new Reservedao();
	Transactiondao tdao=new Transactiondao();
	Userdao udao=new Userdao();
	Bookdao bdao=new Bookdao(); 
}
