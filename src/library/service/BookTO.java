package library.service;
import library.service.Book;
import library.service.BookTO;
public class BookTO {

	 public BookTO() {
	    	book = new Book();
	    }
	 
	 public BookTO(String isbn,String title,String author,String cat,int qty,String img,int rack)
	 {
		 book=new Book(isbn,title,author,cat,qty,img,rack);
	 }
	 public void setISBN(String isbn)
		{
			book.setISBN(isbn);
		}
		
		public String getISBN()
		{
			return book.getISBN();
		}
		public void setTitle(String title)
		{
		  book.setTitle(title);
		}
		
		public String getTitle()
		{
			return book.getTitle();
		}
		public void setAuthor(String author)
		{
			book.setAuthor(author);
		}
		
		public String getAuthor()
		{
			return book.getAuthor();
		}
		
		public void setCategory(String cat)
		{
		    book.setCategory(cat);
		}
		
		public String getCategory()
		{
			return book.getCategory();
		}
		
		public void setQty(int qty)
		{
			  book.setQty(qty);
		}
		
		public int getQty()
		{
			return book.getQty();
		}
		
		public String getImage()
		{
			return book.getImage();
		}
		
		public void setImage(String image)
		{
			 book.setImage(image);
		}
		
		public int getRack()
		{
			return book.getRack();
		}
		
		public void setRack(int rack)
		{
			book.setRack(rack);
		}

	 
	    @Override
	    public BookTO clone() {
	        BookTO book = null;
	        try {
	            book = (BookTO) super.clone();
	            book.book = this.book.clone();            
	        }
	        catch(CloneNotSupportedException e) {}
	        return book;
	    }
	    
	    void setBook(Book bk) {
	    	book = bk;
	    }
	    
	    Book getBook() {
	    	return book.clone();
	    }
	    
	    
	private Book book;
}
