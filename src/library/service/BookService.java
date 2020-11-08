package library.service;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
public abstract class BookService {
	
	public abstract ArrayList<BookTO>Search(String key);
	public abstract boolean addBook(BookTO bt,HttpServletResponse res,HttpServletRequest req,Part img);
	public abstract ArrayList<BookTO>fetchAll();
	 public abstract void deleteBook(String isbn);
	 public abstract BookTO getBook(String isbn);
	 

	public static BookService getInstance() {
    	return new BookServiceImpl();
    }
}
