package library.service;

import java.util.Date;

public class TransactionTO {

	public TransactionTO() {
		transaction = new Transaction();
	}

	public TransactionTO(String isbn, String uname) {
		transaction = new Transaction(uname, isbn);
	}

	public int getTransactionId() {
		return transaction.getTransactionId();
	}

	public void setTransactionId(int id) {
		transaction.setTransactionId(id);
	}

	public String getUsername() {
		return transaction.getUsername();
	}

	public void setUsername(String uname) {
		transaction.setUsername(uname);
	}

	public String getISBN() {
		return transaction.getISBN();
	}

	public void setISBN(String isbn) {
		transaction.setISBN(isbn);
	}

	public Date getIssuedate() {
		return transaction.getIssuedate();
	}

	public void setIssuedate(Date dt) {
		transaction.setIssuedate(dt);
	}

	public Date getDuedate() {
		return transaction.getDuedate();
	}

	public void setDuedate(Date dt) {
		transaction.setDuedate(dt);
	}

	public double getFine() {
		return transaction.getFine();
	}

	public void setFine(double amt) {
		transaction.setFine(amt);
	}

	@Override
	public TransactionTO clone() {
		TransactionTO transaction = null;
		try {
			transaction = (TransactionTO) super.clone();
			transaction.transaction = this.transaction.clone();
		} catch (CloneNotSupportedException e) {
		}
		return transaction;
	}

	void setTransaction(Transaction tq) {
		transaction = tq;
	}

	Transaction getTransaction() {
		return transaction.clone();
	}

	private Transaction transaction;
}
