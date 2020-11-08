package library.service;
import java.util.ArrayList;
public abstract class BookService {
	
	public abstract ArrayList<BookTO>Search(String key);
	public abstract ArrayList<BookTO>fetchAll();
	 public abstract void deleteBook(String isbn);
	 public abstract BookTO getBook(String isbn);
	 

	public static BookService getInstance() {
    	return new BookServiceImpl();
    }
}
