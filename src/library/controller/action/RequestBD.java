package library.controller.action;
import library.service.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import library.model.RequestBean;
import java.util.ArrayList;
public class RequestBD {
	
	static boolean addRequest(RequestBean rb,HttpServletResponse response,HttpServletRequest request,Part image)
	{
		RequestTO rt=Bean2TO(rb);
		return service.addRequest(rt,response,request,image);
	}
	
	static ArrayList<RequestBean>getRequests(String username)
	{
		return Cast2Bean(service.getRequests(username));
	}
	static ArrayList<RequestBean>getRequests()
	{
		return Cast2Bean(service.getRequests());
	}
	
	static void approveRequest(int id)
	{
		System.out.println("RequestBD" + id);
		service.approveRequest(id);
	}
	private static ArrayList<RequestBean> Cast2Bean(ArrayList<RequestTO> requestst) {
		ArrayList<RequestBean> requests = new ArrayList<>();
		for(RequestTO bkt : requestst) {
			requests.add( TO2Bean(bkt) );
		}
		return requests;
	}
	private static RequestBean TO2Bean(RequestTO bkt) {
		RequestBean request = new RequestBean(bkt.getId(),bkt.getTitle(), 
				bkt.getAuthor(), bkt.getCategory(),bkt.getImage(),bkt.getUsername(),bkt.getStatus());
		return request;
	}
 
	private static RequestTO Bean2TO(RequestBean bk) {
		RequestTO request = new RequestTO(bk.getTitle(),bk.getAuthor(),bk.getCategory(),bk.getImage(),bk.getUsername());
		return request;
	}	
	private static RequestService service = RequestService.getInstance();	
}
