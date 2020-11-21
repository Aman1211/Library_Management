package library.dao;

import library.service.UserTO;
import java.util.ArrayList;
public abstract class UserdaoService {
	public abstract UserTO Find(String username,String password);
	public abstract UserTO Exists(String Username);
	public abstract void addUser(String uname,String pass,String name,long contact,String type,String role);
	public abstract void updateUser(String uname,String pass);
	public abstract UserTO currentpassword_check(String Username,String current_password);
	public abstract ArrayList<UserTO>fetchAll();
	
}
