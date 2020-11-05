package library.controller.action;

public class UserNotFound extends Exception {
	  public UserNotFound() {
	        super("Error: Item Not Found");
	    }    
	    public UserNotFound(String message) {
	        super(message);
	    }
}
