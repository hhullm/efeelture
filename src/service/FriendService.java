package service;

import java.util.List;
import java.util.Map;

import entity.Friend;
import entity.User;

public interface FriendService {


	/*
	 * 好友列表查询
	 */
	List<Friend> selectFriend(Map<String, Object> map);

	/*
	 * 加好友
	 */
	String addFriend(Map<String, Object> map);

	/*
	 * 删除好友
	 */
	String deleteFriend(Map<String, Object> map);
	
	/*
	 * 修改好友信息
	 */
	String modifyFriend(Map<String, Object> map);
	
	/*
	 * 查询非好友信息
	 */
	List<User> selectNoFriend(Map<String, Object> map);
}
