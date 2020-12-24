package library.model;

public class BookBean {

	private String ISBN;
	private String Title;
	private String Author;
	private String Category;
	private int Qty;
	private String Image;
	private int Rackno;

	public BookBean(String isbn, String title, String author, String category, int qty, String image, int rack) {
		ISBN = isbn;
		Title = title;
		Author = author;
		Category = category;
		Qty = qty;
		Image = image;
		Rackno = rack;

	}

	public BookBean() {

	}

	public void setISBN(String isbn) {
		ISBN = isbn;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getTitle() {
		return Title;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getAuthor() {
		return Author;
	}

	public void setCategory(String cat) {
		Category = cat;
	}

	public String getCategory() {
		return Category;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public int getQty() {
		return Qty;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public int getRack() {
		return Rackno;
	}

	public void setRack(int rack) {
		Rackno = rack;
	}
}
