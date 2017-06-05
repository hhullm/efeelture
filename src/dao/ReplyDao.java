package dao;

import java.util.List;

import entity.Reply;

public interface ReplyDao {
	
	void addReply(Reply reply);
	
	void deleteReply(Reply reply);
	
	void modifyReply(Reply reply);
	
	List<Reply> selectReply(Reply reply);

}
