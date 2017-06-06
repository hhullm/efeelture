package service;

import java.util.List;
import java.util.Map;

import entity.Talk;

/**
 * @author 
 * 
 * 
 */


public interface TalkService {


	/*
	 * 
	 */
	String addTalk(Map<String, Object> map);

	/*
	 * 
	 */
	String deleteTalk(Map<String, Object> map);
	
	/*
	 * 
	 */
	List<Talk> selectTalk(Map<String, Object> map);
	
}



