package dao;
/**
 * @author 
 * 
 * 
 */
import java.util.List;

import entity.Talk;

public interface TalkDao {

	/*
	 * 新增聊天内容
	 */
	void addTalk(Talk talk);
	
	/*
	 * 删除聊天内容
	 */
	
	void deleteTalk(Talk talk);
	
	/*
	 * 更改聊天内容
	 */
	void modifyTalk(Talk talk);

	/*
	 * 查询聊天内容
	 */
	List<Talk> selectTalk(Talk talk);
	
}



