package imdao;

import daoimpl.FriendDaoImpl;
import entity.Friend;

public class FriendImDao {

	private FriendImDao() {
	}

	public static void addFriend(String firstid, String secondid) {
		Friend friend = new Friend();
		friend.setFirstid(firstid);
		friend.setSecondid(secondid);
		FriendDaoImpl fdi = new FriendDaoImpl();
		fdi.addFriend(friend);
	}
}
