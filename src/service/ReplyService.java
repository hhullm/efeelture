package service;

import java.util.List;
import java.util.Map;

import entity.Reply;


public interface ReplyService {

	/*
	 * 
	 */
	String addReply(Map<String, Object> map);

	/*
	 * 
	 */
	String deleteReply(Map<String, Object> map);
	
	/*
	 * 
	 */
	List<Reply> selectReply(Map<String, Object> map);
}
