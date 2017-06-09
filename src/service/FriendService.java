package service;


import entity.Friend;
import entity.User;

public interface FriendService {


	/*
	 * 
	 */
	String selectFriend(Friend friend);

	/*
	 * 
	 */
	String addFriend(Friend friend);

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
}
