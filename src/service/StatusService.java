package service;

import entity.Status;

public interface StatusService {

	/*
	 * 
	 */
	String addStatus(Status status, String sstatus);

	/*
	 * 
	 */
	String selectStatus(Status status);
}
