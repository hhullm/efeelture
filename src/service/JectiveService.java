package service;

import java.util.List;

import entity.Jective;


public interface JectiveService {

	/*
	 * 
	 */
	String addJective(Jective jective);
	
	/*
	 * 
	 */
	List<Jective> selectJective(Jective jective);
	
}