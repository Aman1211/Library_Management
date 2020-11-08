package library.service;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import library.dao.*;
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

import library.dao.Bookdao;
public class BookServiceImpl extends BookService {
   public ArrayList<BookTO>Search(String key)
   {
	   ArrayList<BookTO>bt=new ArrayList<>();
	   bt=bookdo.fetchBook(key);
	   return bt;
   }
   public ArrayList<BookTO>fetchAll()
   {
	   ArrayList<BookTO>bt=new ArrayList<>();
	   bt=bookdo.fetchAll();
	   return bt;
   }
   
   public boolean addBook(BookTO bt,HttpServletResponse res,HttpServletRequest req,Part img)
   {
	   System.out.println("in add book with bt");
	    String ISBN= bt.getISBN();
	    BookTO bb=bookdo.Exists(ISBN);
	   
	    if(bb.getISBN()!=null)
	    {
	    	return false;
	    }
	    else
	    {
	    	String SAVE_DIR="\\WebContent\\images";
	    	String appPath = req.getServletContext().getRealPath("/");
	    	String[] path = appPath.split("\\.metadata");
	    	appPath = path[0];
	    	String projectname[] = path[1].split("\\wtpwebapps");
	    	projectname[1] = projectname[1].substring(1,projectname[1].length()-1);
	    	SAVE_DIR = projectname[1]+SAVE_DIR;
	    	String savePath = appPath + SAVE_DIR;
	    	
	    	String photo = "images/"+bt.getImage();
	    	System.out.println(savePath);
	    	System.out.println(savePath + File.separator + bt.getImage());
	    	File file = new File(savePath);
	    	try {
	    		img.write(savePath + File.separator + bt.getImage());
	    	}
	    	catch(Exception e) {}
	    	bt.setImage(photo);
	    	
	    	String Title = bt.getTitle();
	    	String Author = bt.getAuthor();
	    	String Category = bt.getCategory();
	    	int Qty = bt.getQty();
	    	String Image = bt.getImage();
	    	int Rack = bt.getRack();
	    	bookdo.addBook(ISBN,Title,Author,Category,Qty,Image,Rack);
	    }
	    return true;
	}
   
private Bookdao bookdo=new Bookdao();
}
