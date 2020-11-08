package library.service;
import java.util.ArrayList;
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
	 public void deleteBook(String isbn) {
		 
		 bookdo.deleteBook(isbn);
	    }
	 public BookTO getBook(String isbn) {
		 
		 return bookdo.getBook(isbn);
	    }
	 
	 
private Bookdao bookdo=new Bookdao();
}
