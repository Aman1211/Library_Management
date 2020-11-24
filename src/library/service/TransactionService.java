package library.service;
import java.util.ArrayList;
import java.util.Set;
public abstract class TransactionService {
	public abstract boolean verifytransaction(String uname,String isbn);
	public abstract void issue(TransactionTO tt);  
	public abstract void Notify(String uname,Set s);
	public  static TransactionService getInstance() {
  
		return new TransactionServiceImpl();
	}
}
