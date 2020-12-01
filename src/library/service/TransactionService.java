package library.service;
import java.util.ArrayList;
import java.util.Set;
public abstract class TransactionService {
	public abstract boolean verifytransaction(String uname,String isbn);
	public abstract void issue(TransactionTO tt);  
	public abstract void renew(TransactionTO tt);
	public abstract void Notify(String uname,Set s);
	public abstract ArrayList<TransactionTO> getTransactions(String uname);
	public abstract int checkFine(int id);
	public abstract void markFine(int id,int fine);
	public abstract TransactionTO getTransaction(int id);
	public  static TransactionService getInstance() {
  
		return new TransactionServiceImpl();
	}
}
