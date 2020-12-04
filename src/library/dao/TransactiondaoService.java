package library.dao;
import java.util.ArrayList;

import library.service.*;
public abstract class TransactiondaoService {
  
	public abstract void issue(TransactionTO tt);
	public abstract TransactionTO fetchTransaction(String uname,String isbn);
	public abstract ArrayList<TransactionTO> totalAmoountOfFine(String date);
	public abstract ArrayList<TransactionTO> top3user(String date);
	
}
