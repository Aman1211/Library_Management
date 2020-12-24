package library.controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import library.controller.Action;
import library.model.BookBean;
import library.model.ReserveBean;

public class ActionCancelReservationValidate implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {

		JFrame f;
		f = new JFrame();
		int a = JOptionPane.showConfirmDialog(f, "Are you sure you want to cancel reservation?");
		if (a == JOptionPane.YES_OPTION) {
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			String username = (String) request.getSession().getAttribute("user");
			ReserveBD.cancelReserve(request.getParameter("isbn"), username);
			JOptionPane.showMessageDialog(f, "Reservation Canceled");
		}
		ArrayList<ReserveBean> bb = new ArrayList<>();
		String username = (String) request.getSession().getAttribute("user");
		bb = ReserveBD.getReservations(username);
		ArrayList<BookBean> aa = new ArrayList<BookBean>();
		for (ReserveBean b : bb) {
			aa.add(BookBD.getBook(b.getISBN()));
		}
		request.getSession().setAttribute("Itemlist", aa);

		return "book_reservation.jsp";

	}
}
