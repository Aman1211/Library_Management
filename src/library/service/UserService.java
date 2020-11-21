package library.service;
import java.util.ArrayList;
public abstract class UserService{
	
	public abstract UserTO Verify(UserTO ut);
	public abstract boolean addUser(UserTO ut);
	public abstract boolean updateUser(UserTO ut,String current_password);
	public abstract boolean forgot(UserTO ut);
	public abstract ArrayList<UserTO>fetchAll(); 
	public static UserService getInstance() {
    	return new UserServiceImpl();
    }

	
}