package library.service;

public class Request {
	private int RequestId;
	private String Title;
	private String Author;
	private String Category;
	private String Image;
	private String Username;
	private boolean Status;

	public Request clone() {
		Request request = null;
		try {
			request = (Request) super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return request;
	}

	public Request(String title, String author, String category, String image, String username) {
		Title = title;
		Author = author;
		Category = category;
		Image = image;
		Username = username;

	}

	public Request() {
	}

	public int getId() {
		return RequestId;
	}

	public void setId(int id) {
		RequestId = id;
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

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public void setStatus(boolean st) {
		Status = st;
	}

	public boolean getStatus() {
		return Status;
	}
}
