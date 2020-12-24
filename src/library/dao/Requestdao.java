package library.dao;

import java.util.ArrayList;

import library.service.RequestTO;

public abstract class Requestdao {
	public abstract void addRequest(RequestTO rt);

	public abstract ArrayList<RequestTO> fetchRequests(String username);

	public abstract ArrayList<RequestTO> fetchRequests();

	public abstract RequestTO getRequest(int id);

	public abstract void removeRequest(int id);

}
