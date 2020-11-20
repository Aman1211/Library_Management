package library.model;

public class ReserveBean {

	private int ReserveId;
	private String Username;
	private String ISBN;


	public ReserveBean(String username,String isbn)
	{

		Username=username;
		ISBN=isbn;
	}
	public ReserveBean(int id,String username,String isbn)
	{
		ReserveId=id;
		Username=username;
		ISBN=isbn;	}
	
	public ReserveBean()
	{
		
	}
	
	public int getId()
	{
		return ReserveId;
	}
	
	public void setId(int id)
	{
		ReserveId=id;
	}
	public void setISBN(String isbn)
	{
		ISBN=isbn;
	}
	
	public String getISBN()
	{
		return ISBN;
	}
	
	public String getUsername()
	{
		return Username;
	}
	
	public void setUsername(String uname)
	{
		Username=uname;
	}
	
	

}
