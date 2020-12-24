package library.service;

import library.service.User;
import library.service.UserTO;

public class UserTO {
	public UserTO() {
		user = new User();
	}

	public UserTO(String name, String username, String password, long contact, String type, String role, int cnt) {
		user = new User(name, username, password, contact, type, role, cnt);
	}

	public String getUsername() {
		return user.getUsername();
	}

	public void setUsername(String uname) {
		user.setUsername(uname);
	}

	public String getPassword() {
		return user.getPassword();
	}

	public void setPassword(String password) {
		user.setPassword(password);
	}

	public String getName() {
		return user.getName();
	}

	public void setName(String name) {
		user.setName(name);
	}

	public long getContact() {
		return user.getContact();
	}

	public void setContact(long con) {
		user.setContact(con);
	}

	public String getType() {
		return user.getType();
	}

	public void setType(String type) {
		user.setType(type);
	}

	public String getRole() {
		return user.getRole();
	}

	public void setRole(String role) {
		user.setRole(role);
	}

	public void setCnt(int cnt) {
		user.setCnt(cnt);
	}

	public int getCnt() {
		return user.getCnt();
	}

	@Override
	public UserTO clone() {
		UserTO user = null;
		try {
			user = (UserTO) super.clone();
			user.user = this.user.clone();
		} catch (CloneNotSupportedException e) {
		}
		return user;
	}

	void setUser(User bk) {
		user = bk;
	}

	User getUser() {
		return user.clone();
	}

	private User user;

}
