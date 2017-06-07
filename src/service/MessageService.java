package service;

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
	String selectMessage(Message message);
	
	
	/*
	 * no realize
	 */
	String selectFriendMessage(Message message);
}
