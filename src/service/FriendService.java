package service;

import entity.Friend;
import entity.User;

public interface FriendService {

	/*
	 * 
	 */
	String selectFriend(Friend friend, String fstatus);

	/*
	 * 
	 */
	String addFriend(Friend friend,String fstatus);

	/*
	 * 
	 */
	String deleteFriend(Friend friend);

	/*
	 * 
	 */
	String modifyFriend(Friend friend);

	/*
	 * 
	 */
	String selectNoFriend(User user);

	/*
	 * 
	 */
	String modifyFriendStatus(Friend friend, String fstatus);
}
