package library.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import library.dao.Requestdao;
import library.dao.Reservedao;

public class ReserveServiceImpl extends ReserveService{

	public int addReserve(ReserveTO rt,HttpServletResponse res,HttpServletRequest req)
	{

	      int i=rdao.checkReservation(rt);
	      /*if(i==0)
	      {
	    	  return 0;
	      }
	      else if(i==-1)
	      {
	    	return -1;  
	      }
	      else if(i==1)
	      {

          rdao.addReserve(rt);
          return 1;
          
	      }
         return 2;
         */
         if(i==-1)
         {
        	 return -1;
         }
         else
         {
        	 int i2=rdao.checkTransaction(rt);
        	 if(i2==0)
        	 {
        		 return 0;
        	 }
        	 else
        	 {
                 rdao.addReserve(rt);
                 return 1;        		 
        	 }
         }
	}
	 public void cancelReserve(String isbn,String username) {
		 
		 rdao.cancelReserve(isbn,username);
	    }
	public ArrayList<ReserveTO> getReservations(String username)
	{
		return rdao.fetchReservations(username);
	}

	private Reservedao rdao=new Reservedao();
}
