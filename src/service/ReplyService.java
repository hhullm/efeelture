package service;

import java.util.List;

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
	List<Reply> selectReply(Reply reply);
}
