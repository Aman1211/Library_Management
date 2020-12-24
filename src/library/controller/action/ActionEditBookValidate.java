package library.controller.action;

import library.controller.Action;
import library.model.BookBean;

import javax.servlet.http.Part;

import java.util.ArrayList;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class ActionEditBookValidate implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> err = new ArrayList<>();
		String title = request.getParameter("title");
		String isbn = request.getParameter("isbn");
		String aname = request.getParameter("aname");
		String qty = request.getParameter("qty");
		String category = request.getParameter("category");
		Part img = null;
		try {
			img = request.getPart("bookimg");
		} catch (Exception e) {
		}
		String rno = request.getParameter("rno");

		if (title.isEmpty() || aname.isEmpty() || qty.isEmpty() || category.isEmpty() || rno.isEmpty()) {

			err.add("Please Enter all the required fields");
			request.setAttribute("errMessage", err); // If authenticateUser() function returnsother than SUCCESS string
														// it will be sent to Login page again. Here the error message
														// returned from function has been stored in a errMessage key.
			// request.getSession().setAttribute("user", null);
			return "edit_book.jsp";
		}

		int qty_n = Integer.parseInt(qty);

		if (qty_n <= 0) {
			err.add("Quantity can not be less than or equals to 0");
			request.setAttribute("errMessage", err);
			request.getSession().setAttribute("user", null);
			return "edit_book.jsp";
		}
		String image = getFileName(img);
		int qty_i = Integer.parseInt(qty);
		int rack = Integer.parseInt(rno);
		BookBean bb = new BookBean(isbn, title, aname, category, qty_i, image, rack);
		if (image.isEmpty()) {
			BookBD.editBook(bb);

		} else {
			BookBD.editBook(bb, response, request, img);
		}

		return "/Controller?action=managebook";
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
