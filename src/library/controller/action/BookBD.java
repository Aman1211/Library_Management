package library.controller.action;
import library.service.*;
import library.model.BookBean;
import library.model.UserBean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class BookBD {
	static ArrayList<BookBean> Search(String keyword)  {
	    return  Cast2Bean(service.Search(keyword)) ;     
	}
	
	static ArrayList<BookBean> fetchAll()
	{
		return Cast2Bean(service.fetchAll());
	}
	
	static boolean addBook(BookBean bb,HttpServletResponse response,HttpServletRequest request, Part img) {
		BookTO bt=Bean2TO(bb);
		return service.addBook(bt,response,request,img);
	}
	
	private static ArrayList<BookBean> Cast2Bean(ArrayList<BookTO> bookst) {
		ArrayList<BookBean> books = new ArrayList<>();
		for(BookTO bkt : bookst) {
			books.add( TO2Bean(bkt) );
		}
		return books;
	}
	private static BookBean TO2Bean(BookTO bkt) {
		BookBean book = new BookBean(bkt.getISBN(), bkt.getTitle(), 
				bkt.getAuthor(), bkt.getCategory(),bkt.getQty(),bkt.getImage(),bkt.getRack());
		return book;
	}

	private static BookTO Bean2TO(BookBean bk) {
		BookTO book = new BookTO(bk.getISBN(),bk.getTitle(),bk.getAuthor(),bk.getCategory(),bk.getQty(),bk.getImage(),bk.getRack());
		return book;
	}	
	private static BookService service = BookService.getInstance();	
}

