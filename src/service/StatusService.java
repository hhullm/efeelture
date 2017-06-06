package service;

import java.util.List;
import java.util.Map;

import entity.Status;


public interface StatusService {
	

	/*
	 * 
	 */
	String addStatus(Map<String, Object> map);
	
	/*
	 * 
	 */
	List<Status> selectStatus(Map<String, Object> map);
}
