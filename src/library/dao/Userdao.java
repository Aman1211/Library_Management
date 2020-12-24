package library.dao;

import library.service.UserTO;
import java.util.ArrayList;

public abstract class Userdao {
	public abstract UserTO Find(String username, String password);

	public abstract UserTO Exists(String Username);

	public abstract void addUser(String uname, String pass, String name, long contact, String type, String role);

	public abstract void updateUser(String uname, String pass);

	public abstract UserTO currentpassword_check(String Username, String current_password);

	public abstract ArrayList<UserTO> fetchAll();

	public abstract void incrementcnt(UserTO ut);

	public abstract void updateProfile(UserTO ut, String uname);

	public abstract void decrementcnt(String uname);

}
