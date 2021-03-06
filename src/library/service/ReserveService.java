package library.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public abstract class ReserveService {

	public abstract int addReserve(ReserveTO bt, HttpServletResponse response, HttpServletRequest request);

	public abstract ArrayList<ReserveTO> getReservations(String username);

	// public abstract ArrayList<RequestTO>getReserves();
	// public abstract void approveRequest(int id);
	public abstract void cancelReserve(String isbn, String username);

	public abstract boolean getReservation(String isbn);

	public abstract void notify(String isbn);

	public static ReserveService getInstance() {

		return new ReserveServiceImpl();
	}

}