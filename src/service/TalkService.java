package service;

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
	String selectTalk(Talk talk);
	
}



