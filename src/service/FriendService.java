package service;


import entity.Friend;
import entity.User;

public interface FriendService {


	/*
	 * 好友列表查询
	 */
	String selectFriend(Friend friend);

	/*
	 * 加好友
	 */
	String addFriend(Friend friend);

	/*
	 * 删除好友
	 */
	String deleteFriend(Friend friend);
	
	/*
	 * 修改好友信息
	 */
	String modifyFriend(Friend friend);
	
	/*
	 * 查询非好友信息
	 */
	String selectNoFriend(User user);
}
