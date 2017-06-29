package dao;

import java.util.List;

import entity.Message;

public interface MessageDao {

	void addMessage(Message message);

	void deleteMessage(Message message);

	void modifyMessage(Message message);

	List<Message> selectMessage(Message message);

	List<Message> selectFriendMessage(Message message);

}
