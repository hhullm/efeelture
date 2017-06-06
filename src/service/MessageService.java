package service;

import java.util.List;

import entity.Message;

public interface MessageService {

	/*
	 * 
	 */
	String addMessage(Message message);
	
	/*
	 * 
	 */
	String deleteMessage(Message message);

	/*
	 * 
	 */
	List<Message> selectMessaga(Message message);
	
	/*
	 * 
	 */
	List<Message> selectUidMessaga(Message message);
	
	/*
	 * no realize
	 */
	List<Message> selectFriendMessaga(Message message);
}
