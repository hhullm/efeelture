package service;

import java.util.List;

import entity.Status;


public interface StatusService {
	

	/*
	 * 
	 */
	String addStatus(Status status);
	
	/*
	 * 
	 */
	List<Status> selectStatus(Status status);
}
