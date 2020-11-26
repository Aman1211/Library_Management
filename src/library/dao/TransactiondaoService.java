package library.dao;
import library.service.*;
public abstract class TransactiondaoService {
  
	public abstract void issue(TransactionTO tt);
	public abstract TransactionTO fetchTransaction(String uname,String isbn);
}
