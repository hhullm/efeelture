package service;

import java.util.List;
import java.util.Map;

import entity.Message;

public interface MessageService {

	/*
	 * 
	 */
	String addMessage(Map<String, Object> map);
	
	/*
	 * 
	 */
	String deleteMessage(Map<String, Object> map);

	/*
	 * 
	 */
	List<Message> selectMessaga(Map<String, Object> map);
	
	/*
	 * 
	 */
	List<Message> selectUidMessaga(Map<String, Object> map);
	
	/*
	 * no realize
	 */
	List<Message> selectFriendMessaga(Map<String, Object> map);
}
