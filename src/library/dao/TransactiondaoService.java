package library.dao;
import java.util.ArrayList;

import library.service.*;
import java.util.ArrayList;
public abstract class TransactiondaoService {
  
	public abstract void issue(TransactionTO tt);
	public abstract TransactionTO fetchTransaction(String uname,String isbn);
<<<<<<< HEAD
	public abstract ArrayList<TransactionTO> totalAmoountOfFine(String date);
	public abstract ArrayList<TransactionTO> top3user(String date);
	
=======
	public abstract ArrayList<TransactionTO> fetchTransactions(String uname);
	public abstract ArrayList<TransactionTO> fetchAllTransactions(String uname);
	public abstract TransactionTO fetchTransaction(int id);
	public abstract void markFine(int id,int fine);
>>>>>>> d297e29afbf2ac35750c5009c17de6005061a39d
}
