package library.service;

public class UserNotFound extends Exception {
	  public UserNotFound() {
	        super("Invalid Credentials");
	    }    
	    public UserNotFound(String message) {
	        super(message);
	    }
}
