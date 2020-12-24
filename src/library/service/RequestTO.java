package library.service;

public class RequestTO {
	public RequestTO() {
		request = new Request();
	}

	public RequestTO(String title, String author, String category, String image, String username) {
		request = new Request(title, author, category, image, username);
	}

	public int getId() {
		return request.getId();
	}

	public void setId(int id) {
		request.setId(id);
	}

	public void setTitle(String title) {
		request.setTitle(title);
	}

	public String getTitle() {
		return request.getTitle();
	}

	public void setAuthor(String author) {
		request.setAuthor(author);
	}

	public String getAuthor() {
		return request.getAuthor();
	}

	public void setCategory(String cat) {
		request.setCategory(cat);
	}

	public String getCategory() {
		return request.getCategory();
	}

	public String getImage() {
		return request.getImage();
	}

	public void setImage(String image) {
		request.setImage(image);
	}

	public String getUsername() {
		return request.getUsername();
	}

	public void setUsername(String username) {
		request.setUsername(username);
	}

	public boolean getStatus() {
		return request.getStatus();
	}

	public void setStatus(boolean st) {
		request.setStatus(st);
	}

	@Override
	public RequestTO clone() {
		RequestTO request = null;
		try {
			request = (RequestTO) super.clone();
			request.request = this.request.clone();
		} catch (CloneNotSupportedException e) {
		}
		return request;
	}

	void setRequest(Request rq) {
		request = rq;
	}

	Request getRequest() {
		return request.clone();
	}

	private Request request;

}
