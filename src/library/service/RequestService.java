package library.service;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
public abstract class RequestService {
	
 public abstract boolean addRequest(RequestTO bt,HttpServletResponse response,HttpServletRequest request,Part image);
 public abstract ArrayList<RequestTO>getRequests(String username);
 public abstract ArrayList<RequestTO>getRequests();
 public abstract void approveRequest(int id);
public static RequestService getInstance() {

	return new RequestServiceImpl();
}
}
