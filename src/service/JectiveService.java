package service;

import java.util.List;
import java.util.Map;

import entity.Jective;


public interface JectiveService {

	/*
	 * 
	 */
	String addJective(Map<String, Object> map);
	
	/*
	 * 
	 */
	List<Jective> selectJective(Map<String, Object> map);
	
}