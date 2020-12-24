package library.controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import library.model.BookBean;
import library.model.RequestBean;
import library.model.ReserveBean;
import library.service.RequestService;
import library.service.RequestTO;
import library.service.ReserveService;
import library.service.ReserveTO;

public class ReserveBD {
	static int addReserve(ReserveBean rb, HttpServletResponse response, HttpServletRequest request) {
		ReserveTO rt = Bean2TO(rb);

		return service.addReserve(rt, response, request);
	}

	static boolean getReservation(String isbn) {
		return service.getReservation(isbn);
	}

	static void notify(String isbn) {
		service.notify(isbn);
	}

	static ArrayList<ReserveBean> getReservations(String username) {
		return Cast2Bean(service.getReservations(username));
	}/*
		 * static ArrayList<RequestBean>getRequests() { return
		 * Cast2Bean(service.getRequests()); }
		 */

	private static ArrayList<ReserveBean> Cast2Bean(ArrayList<ReserveTO> reservest) {
		ArrayList<ReserveBean> reservations = new ArrayList<>();
		for (ReserveTO bkt : reservest) {
			reservations.add(TO2Bean(bkt));
		}
		return reservations;
	}

	private static ReserveBean TO2Bean(ReserveTO bkt) {

		/*
		 * BookBean book = new BookBean(bkt.getISBNBook().getISBN(),
		 * bkt.getISBNBook().getTitle(), bkt.getISBNBook().getAuthor(),
		 * bkt.getISBNBook().getCategory(),bkt.getISBNBook().getQty(),bkt.getISBNBook().
		 * getImage(),bkt.getISBNBook().getRack());
		 */
		ReserveBean reserve = new ReserveBean(bkt.getId(), bkt.getUsername(), bkt.getISBN());
		return reserve;
	}

	private static ReserveTO Bean2TO(ReserveBean bk) {
		ReserveTO reserve = new ReserveTO(bk.getUsername(), bk.getISBN());
		return reserve;
	}

	static void cancelReserve(String isbn, String username) {

		service.cancelReserve(isbn, username);

	}

	private static ReserveService service = ReserveService.getInstance();

}
