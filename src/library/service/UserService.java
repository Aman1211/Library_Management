package library.service;
<<<<<<< HEAD
import java.util.ArrayList;
=======

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

>>>>>>> 883800dc5be2de6867440a014564755a118f6ed4
public abstract class UserService{
	
	public abstract UserTO Verify(UserTO ut);
	public abstract boolean addUser(UserTO ut);
	public abstract boolean updateUser(UserTO ut,String current_password);
	public abstract boolean forgot(UserTO ut);
<<<<<<< HEAD
	public abstract ArrayList<UserTO>fetchAll(); 
	public abstract UserTO getUser(String uname);
=======
	public abstract UserTO getUser(String username);
	public abstract void editProfile(UserTO ut , String uname);
	public abstract ArrayList<UserTO>fetchAll();
>>>>>>> 883800dc5be2de6867440a014564755a118f6ed4
	public static UserService getInstance() {
    	return new UserServiceImpl();
    }

	
}