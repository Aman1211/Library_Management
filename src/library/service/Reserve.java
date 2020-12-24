package library.service;

import library.model.BookBean;

public class Reserve {
	private int ReserveId;
	private String Username;
	private String ISBN;
	private int isnotify;

	public Reserve clone() {
		Reserve reserve = null;
		try {
			reserve = (Reserve) super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return reserve;
	}

	public Reserve(String username, String isbn) {

		Username = username;
		ISBN = isbn;

	}

	public Reserve() {
	}

	public int getId() {
		return ReserveId;
	}

	public void setId(int id) {
		ReserveId = id;
	}

	public void setISBN(String isbn) {
		ISBN = isbn;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String uname) {
		Username = uname;
	}

	public int getnotify() {
		return isnotify;
	}

	public void setnotify(int status) {
		isnotify = status;
	}
}
