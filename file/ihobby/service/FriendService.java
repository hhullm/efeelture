package service;

import java.util.List;
import entity.Friend;
import entity.User;

/**
 * 
 * @author 994072500
 *
 *         用户好友的服务层实现方法
 */
public interface FriendService {

	/*
	 * 好友列表查询
	 */
	List<Friend> selectFriend(Friend friend);

	/*
	 * 加好友
	 */
	String addFriend(Friend friend);

	/*
	 * 删除好友
	 */
	String delFriend(Friend friend);
	
	/*
	 * 修改好友信息
	 */
	String modifyFriend(Friend friend);
	
	/*
	 * 查询非好友信息
	 */
	List<User> selectNoFriend(User user);
}
