package service;

import entity.Message;

public interface MessageService {

	/*
	 * 
	 */
	String addMessage(Message message, String mstatus, String likenumber);

	/*
	 * 
	 */
	String deleteMessage(Message message);

	/*
	 * 
	 */
	String selectMessage(Message message, String mstatus);

	/*
	 * no realize
	 */
	String selectFriendMessage(Message message);

	String modifyMessageStatus(Message message, String mstatus);

	String modifyMessage(Message message);

	String modifyMessageLikenumber(Message message);

}
