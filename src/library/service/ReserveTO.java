package library.service;

import library.model.BookBean;

public class ReserveTO {

	public ReserveTO() {
		// request = new Request();

		reserve = new Reserve();

	}

	public ReserveTO(String isbn, String username) {
		reserve = new Reserve(isbn, username);

	}

	public int getId() {
		return reserve.getId();
	}

	public void setId(int id) {
		reserve.setId(id);
	}

	public void setISBN(String isbn) {
		reserve.setISBN(isbn);
	}

	public String getISBN() {
		return reserve.getISBN();
	}

	public String getUsername() {
		return reserve.getUsername();
	}

	public void setUsername(String username) {
		reserve.setUsername(username);
	}

	public void setNotify(int status) {
		reserve.setnotify(status);
	}

	public int getNotify() {
		return reserve.getnotify();
	}

	@Override
	public ReserveTO clone() {
		ReserveTO reserve = null;
		try {
			reserve = (ReserveTO) super.clone();
			reserve.reserve = this.reserve.clone();
		} catch (CloneNotSupportedException e) {
		}
		return reserve;
	}

	void setReserve(Reserve re) {
		reserve = re;
	}

	Reserve getReserve() {
		return reserve.clone();
	}

	private Reserve reserve;

}
