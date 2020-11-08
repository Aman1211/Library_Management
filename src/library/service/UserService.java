package library.service;

public abstract class UserService{
	
	public abstract UserTO Verify(UserTO ut);
	public abstract boolean addUser(UserTO ut);
	public abstract boolean updateUser(UserTO ut,String current_password);
	public abstract boolean forgot(UserTO ut);
	
	public static UserService getInstance() {
    	return new UserServiceImpl();
    }

	
}