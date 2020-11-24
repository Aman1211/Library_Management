package library.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public abstract class UserService{
	
	public abstract UserTO Verify(UserTO ut);
	public abstract boolean addUser(UserTO ut);
	public abstract boolean updateUser(UserTO ut,String current_password);
	public abstract boolean forgot(UserTO ut);
	public abstract UserTO getUser(String username);
	public abstract void editProfile(UserTO ut , String uname);
	public abstract ArrayList<UserTO>fetchAll();
	public static UserService getInstance() {
    	return new UserServiceImpl();
    }

	
}