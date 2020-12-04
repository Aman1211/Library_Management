package library.controller.action;
import library.service.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import library.model.BookBean;
import library.model.TransactionBean;
import java.util.ArrayList;
import java.util.Set;
public class TransactionBD {
	static boolean verify(String username,String isbn)
	{
	  return service.verifytransaction(username,isbn);
	}
	static void issue(TransactionBean tb)
	{
		TransactionTO tt=Bean2TO(tb);
		service.issue(tt);
	}
	
	static void Notify(String uname,Set s) {
		service.Notify(uname,s);
	}
	
	
	static ArrayList<TransactionBean> top3user(String date)
	{
		
		return Cast2Bean(service.top3user(date));
	}
	static ArrayList<TransactionBean> totalAmoountOfFine(String date)
	{
		
		return Cast2Bean(service.totalAmoountOfFine(date));
	}
	
	
	private static ArrayList<TransactionBean> Cast2Bean(ArrayList<TransactionTO> transactionst) {
		ArrayList<TransactionBean> transactions = new ArrayList<>();
		for(TransactionTO bkt : transactionst) {
			transactions.add( TO2Bean(bkt) );
		}
		return transactions;
	}
	private static TransactionBean TO2Bean(TransactionTO bkt) {
		TransactionBean request = new TransactionBean(bkt.getTransactionId(),bkt.getUsername(),bkt.getISBN(),bkt.getIssuedate(),bkt.getDuedate(),bkt.getFine());
		return request;
	}
 
	private static TransactionTO Bean2TO(TransactionBean bk) {
		TransactionTO request = new TransactionTO(bk.getISBN(),bk.getUsername());
		return request;
	}	
	private static TransactionService service = TransactionService.getInstance();
}
