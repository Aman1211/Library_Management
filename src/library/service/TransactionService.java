package library.service;
import java.util.ArrayList;
public abstract class TransactionService {
	public static TransactionService getInstance() {

		return new TransactionServiceImpl();
	}
}
