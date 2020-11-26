package library.service;

import java.util.Date;

public class Transaction implements Cloneable {
	private int TransactionId;
	private String Username;
	private  String ISBN;
	private Date  Issuedate;
	private Date Duedate;
	private double Fine;

	public Transaction clone() {
        Transaction transaction = null;
        try {
            transaction = (Transaction) super.clone();
        }
        catch(CloneNotSupportedException e) {}
        return transaction;
    }
	Transaction(String uname,String isbn)
	{
		Username=uname;
		ISBN=isbn;
	
	}
	Transaction(){}

	public int getTransactionId()
	{
		return TransactionId;
	}
	public void setTransactionId(int id)
	{
		TransactionId=id;
	}
	public String getUsername()
	{
	   return Username;	
	}

	public void setUsername(String uname)
	{
		Username=uname;
	}
	public String getISBN()
	{
		return ISBN;
	}
	public void  setISBN(String isbn)
	{
		ISBN=isbn;
	}
	public Date getIssuedate()
	{
		return Issuedate;
	}

	public void setIssuedate(Date dt)
	{
		Issuedate=dt;
	}
	public Date getDuedate()
	{
		return Duedate;
	}

	public void setDuedate(Date dt)
	{
		Duedate=dt;
	}

	public double getFine()
	{
		return Fine;
	}
	public void setFine(double amt)
	{
		Fine=amt;
	}

}
