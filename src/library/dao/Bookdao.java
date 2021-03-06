package library.dao;

import java.util.ArrayList;

import library.service.BookTO;

public abstract class Bookdao {
	public abstract ArrayList<BookTO> fetchBook(String key);

	public abstract ArrayList<BookTO> fetchAll();

	public abstract ArrayList<BookTO> top3mostissuedbook(String date);

	public abstract int deleteBook(String isbn);

	public abstract BookTO getBook(String isbn);

	public abstract void updateBook(BookTO bt);

	public abstract void updateBook1(BookTO bt);

	public abstract BookTO Exists(String isbn);

	public abstract void decrementcnt(BookTO bt);

	public abstract void addBook(String ISBN, String Title, String Author, String Category, int Qty, String Image,
			int Rack);

}
