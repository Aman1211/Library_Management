
package library.controller.action;
import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import library.model.BookBean;
import java.util.ArrayList;
public class ActionBookDeleteValidate implements Action {
	 public String perform(HttpServletRequest request,
	            HttpServletResponse response) {
		
		 JFrame f;  
         f=new JFrame();   
		 int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
		 if(a==JOptionPane.YES_OPTION){  
		     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  BookBD.deleteBook( request.getParameter("isbn") );
				 JOptionPane.showMessageDialog(f,"Deleted Successfully");  
		 }
        ArrayList<BookBean>bb=new ArrayList<>();
		 bb=BookBD.fetchAll();
		 request.getSession().setAttribute("Itemlist", bb);	

   	  
		 return "manage_book.jsp";     
}
}
