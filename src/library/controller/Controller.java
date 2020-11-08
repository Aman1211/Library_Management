package library.controller;
import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.Action;
import library.util.Util;
@MultipartConfig
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String theAction = request.getParameter("action");
        System.out.println("action "+theAction);
        if ( theAction == null)
            theAction = "index";
        
        Action action = getActionFromConfig( theAction );

        String view = action.perform(request, response);
        
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);    
    } 
    
    private Action getActionFromConfig( String theAction ) 
            throws ServletException, IOException{
        Properties map = new Properties();
        map.load( this.getClass().getClassLoader().getResourceAsStream( ACTION_MAPPING ));
            
        String action_class = map.getProperty( 
                theAction.toLowerCase() );      
        Action action = (Action) Util
                .createObject(action_class);       
        return action;
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	private final static String ACTION_MAPPING = "library/controller/ActionMapping.properties"; 
}
