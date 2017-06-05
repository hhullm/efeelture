package dao;

import java.util.List;

import entity.Friend;

public interface FriendDao {
	
	void addFriend(Friend friend);
	
	void deleteFriend(Friend friend);
	
	void modifyFriend(Friend friend);
	
	List<Friend> selectFriend(Friend friend);

}
