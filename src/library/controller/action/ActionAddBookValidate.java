package library.controller.action;

import library.controller.Action;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import javax.servlet.http.Part;
import library.model.*;

@MultipartConfig
public class ActionAddBookValidate implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> err = new ArrayList<>();
		Pattern pattern;
		Matcher match;
		String view = "add_book.jsp";
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String aname = request.getParameter("aname");
		String qty = request.getParameter("qty");
		String category = request.getParameter("category");
		String rno = request.getParameter("rno");
		Part bookimg = null;
		try {
			bookimg = request.getPart("bookimg");
		} catch (Exception e) {
		}

		if (isbn.isEmpty() || title.isEmpty() || aname.isEmpty() || qty.isEmpty() || category.isEmpty()
				|| rno.isEmpty()) {
			System.out.print("empty");
			err.add("Please Enter all the required fields");
			request.setAttribute("errMessage", err); // If authenticateUser() function returnsother than SUCCESS string
														// it will be sent to Login page again. Here the error message
														// returned from function has been stored in a errMessage key.
			// request.getSession().setAttribute("user", null);
			return "add_book.jsp";
		}
		System.out.println(isbn.length() + "length");
		if (isbn.length() < 13 || isbn.length() > 13) {
			System.out.println("isbn err");
			err.add("ISBN must be of 13 character.");
			request.setAttribute("errMessage", err);
			// request.getSession().setAttribute("user", null);
			return "add_book.jsp";
		}
		int qty_n = Integer.parseInt(qty);

		if (qty_n <= 0) {
			err.add("Quantity can not be less than or equals to 0");
			request.setAttribute("errMessage", err);
			request.getSession().setAttribute("user", null);
			return "add_book.jsp";
		}

		String image = getFileName(bookimg);
		int qty_i = Integer.parseInt(qty);
		int rack = Integer.parseInt(rno);
		BookBean bb = new BookBean(isbn, title, aname, category, qty_i, image, rack);
		boolean res = BookBD.addBook(bb, response, request, bookimg);
		System.out.print(res + "janvi");
		if (res == false) {
			err.clear();
			err.add("Book Already Exists!");
			request.setAttribute("errMessage", err);
			view = "add_book.jsp";
		} else {
			err.clear();
			err.add("Book added Successfully");
			request.setAttribute("errMessage", err);
			view = "add_book.jsp";
		}

		return view;

	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
