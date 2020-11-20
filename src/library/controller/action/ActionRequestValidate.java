package library.controller.action;
import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import library.model.*;
@MultipartConfig
public class ActionRequestValidate implements Action {
	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

	public String perform(HttpServletRequest request,
            HttpServletResponse response) {
		
    String title=request.getParameter("title");
    String author=request.getParameter("author");
    String category=request.getParameter("category");
    Part image=null;
    try {
   image=request.getPart("image");
   
    }
    catch(Exception e)
    {
    	
    }
     
    String username=(String)request.getSession().getAttribute("user");
    if(title.isEmpty() || author.isEmpty() || category.isEmpty() || getFileName(image).isEmpty()  )
    {
   	 String requestValidate="Please Fill the required fields!";
	 request.setAttribute("errMessage", requestValidate); 
    }
    else
    {
    	String filename=getFileName(image);
   	    RequestBean rb=new RequestBean(title,author,category,filename,username);
    	boolean res=RequestBD.addRequest(rb,response,request,image);
    	if(res==true)
    	{
    		String requestValidate="Book Request Added!";
    		 request.setAttribute("errMessage", requestValidate); 
    		
    	}
    }
	
	
		
		return "request.jsp";	
}
}
