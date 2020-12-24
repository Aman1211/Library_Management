package library.controller.action;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import library.controller.Action;
import library.model.ReserveBean;
import library.model.UserBean;

public class ActionReserveBookValidation implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> err = new ArrayList<>();
		String view = "";

		String username = (String) request.getSession().getAttribute("user");

		if (username == null) {

			return "login.jsp";
		}
		// System.out.println("hello1="+username);
		/*
		 * if(username.isEmpty() || password.isEmpty() || current_password.isEmpty() ||
		 * confirm_password.isEmpty()) {
		 * err.add("Please Enter all the required fields");
		 * request.setAttribute("errMessage1", err); //If authenticateUser() function
		 * returnsother than SUCCESS string it will be sent to Login page again. Here
		 * the error message returned from function has been stored in a errMessage key.
		 * 
		 * request.getSession().setAttribute("user", username); return
		 * "change_password.jsp"; } if(password.length()<8 || password.length()>20) {
		 * 
		 * err.add("Password length must be between 8 and 20");
		 * request.setAttribute("errMessage1", err);
		 * request.getSession().setAttribute("user", username); return
		 * "change_password.jsp"; } if(password.equals(confirm_password)==false) {
		 * err.add("You must enter the same password twice in order to confirm password"
		 * ); request.setAttribute("errMessage1", err);
		 * request.getSession().setAttribute("user", username); return
		 * "change_password.jsp"; } else { String regex = "^(?=.*[0-9])" +
		 * "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$"; Pattern
		 * p = Pattern.compile(regex); Matcher m = p.matcher(password);
		 * if(m.matches()==false) { err.
		 * add("Password length must be 8 of characters and must  contain UpperCase,LowerCase,digit and Special Character !"
		 * ); request.setAttribute("errMessage1", err); //If authenticateUser() function
		 * returnsother than SUCCESS string it will be sent to Login page again. Here
		 * the error message returned from function has been stored in a errMessage key.
		 * 
		 * return "change_password.jsp"; } UserBean user=new UserBean();
		 * user.setUsername(username); user.setPassword(password);
		 * 
		 * boolean res=UserBD.updateUser(user,current_password);
		 * 
		 * if(res==true) { err.clear(); err.add("Password Changed");
		 * request.setAttribute("errMessage1", err); view="change_password.jsp"; } else
		 * { err.clear(); err.add("Current password not matched");
		 * request.setAttribute("errMessage1", err); view="change_password.jsp"; }
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
		else {

			ReserveBean reserve = new ReserveBean();
			reserve.setUsername(username);
			reserve.setISBN(request.getParameter("isbn"));

			int res = ReserveBD.addReserve(reserve, response, request);
			if (res == 0) {
				JFrame f;
				f = new JFrame();
				err.clear();
				err.add("You already have book");
				JOptionPane.showMessageDialog(f, "You have already this book");
				System.out.println("You have already this book");
				request.setAttribute("errMessage1", err);
				view = "index.jsp";

			} else if (res == -1) {
				JFrame f;
				f = new JFrame();

				err.clear();
				err.add("You have already reserve this book");
				JOptionPane.showMessageDialog(f, "You have already reserve this book");

				System.out.println("You have already reserve this book");
				request.setAttribute("errMessage1", err);
				view = "index.jsp";
			} else if (res == 1) {
				JFrame f;
				f = new JFrame();
				err.clear();
				err.add("Book Reserved Sucessfully");
				JOptionPane.showMessageDialog(f, "Book Reserved Sucessfully");
				System.out.println("Book Reserved Sucessfully");
				request.setAttribute("errMessage1", err);
				view = "index.jsp";
			}

			return view;
			// return "index.jsp";
		}

	}

}
