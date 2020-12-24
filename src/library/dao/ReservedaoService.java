package library.dao;

import java.util.ArrayList;

import library.service.ReserveTO;

public abstract class ReservedaoService {
	public abstract void addReserve(ReserveTO rt);

	public abstract int checkReservation(ReserveTO rt);

	public abstract int checkTransaction(ReserveTO rt);

	public abstract ArrayList<ReserveTO> fetchReservations(String username);

	public abstract ArrayList<ReserveTO> verifyReservation(String isbn);

	public abstract ReserveTO fetchnonnotify(String isbn);

	public abstract void marknotify(int id);

	public abstract void cancelReserve(String isbn, String username);
}
