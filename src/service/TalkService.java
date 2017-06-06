package service;

import java.util.List;

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
	String addTalk(Talk talk);

	/*
	 * 
	 */
	String deleteTalk(Talk talk);
	
	/*
	 * 
	 */
	List<Talk> selectTalk(Talk talk);
	
}



