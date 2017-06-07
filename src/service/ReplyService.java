package service;

import entity.Reply;


public interface ReplyService {

	/*
	 * 
	 */
	String addReply(Reply reply);

	/*
	 * 
	 */
	String deleteReply(Reply reply);
	
	/*
	 * 
	 */
	String selectReply(Reply reply);
}
