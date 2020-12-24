package library.model;

public class RequestBean {

	private int RequestId;
	private String Title;
	private String Author;
	private String Category;
	private String Image;
	private String Username;
	private boolean status;

	public RequestBean(String title, String author, String category, String image, String username) {
		Title = title;
		Author = author;
		Category = category;
		Image = image;
		Username = username;
	}

	public RequestBean(int id, String title, String author, String category, String image, String username,
			boolean Status) {
		RequestId = id;
		Title = title;
		Author = author;
		Category = category;
		Image = image;
		Username = username;
		status = Status;
	}

	public RequestBean() {

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

	public void setUsername(String uname) {
		Username = uname;
	}

	public void setStatus(boolean st) {
		status = st;
	}

	public boolean getStatus() {
		return status;
	}
}
