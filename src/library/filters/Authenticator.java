package library.filters;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticator
 */
public class Authenticator implements Filter {
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException,ServletException
	{
		HttpServletRequest req=(HttpServletRequest)request;
		String action=req.getParameter("action");
		String user=(String)req.getSession().getAttribute("user");
		if(action==null)
			action="index";
		if(user!=null || action.equals("login") || action.equals("loginvalidate"))
		{
			chain.doFilter(request,response);
		}
		else
		{
			req.getSession().setAttribute("user", null);
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

    
   
}
