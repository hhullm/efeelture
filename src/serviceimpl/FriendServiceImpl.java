package serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.FriendDaoImpl;
import daoimpl.UserDaoImpl;
import entity.Friend;
import entity.User;
import service.FriendService;

public class FriendServiceImpl implements FriendService {

	public String selectFriend(Friend friend) {

		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			List<Friend> friendList = friendImpl.selectFriend(friend);
			if (friendList.size() > 0) {
				m.put("friendList", friendList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "211");//have no friend
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "210");//selectfirend failed
		}
		return j.toJson(m);
	}

	public String addFriend(Friend friend) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			friendImpl.addFriend(friend);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "220");//addfriend failed
		}
		return j.toJson(m);
	}

	public String deleteFriend(Friend friend) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			friend.setFstatus("0");
			friendImpl.modifyFriend(friend);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "230");//deletefriend failed
		}
		return j.toJson(m);
	}

	public String modifyFriend(Friend friend) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			friendImpl.modifyFriend(friend);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "240");//modifyfriend failed
		}
		return j.toJson(m);
	}

	public String selectNoFriend(User user) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			User u = new User();
			// all of the user
			List<User> userList = userDaoImpl.selectUser(u);
			List<User> friendUserList = new ArrayList<User>();
			for (int i = 0; i < userList.size(); i++) {
				u = userList.get(i);
				FriendDaoImpl friendDaoImpl = new FriendDaoImpl();
				Friend friend = new Friend();
				friend.setFirstid(user.getId());
				friend.setSecondid(u.getId());
				List<Friend> friendList = friendDaoImpl.selectFriend(friend);
				if ((!u.getId().equals(user.getId())) && friendList.size() == 0) {
					// not friend not self
					friendUserList.add(u);
				}
			}
			m.put("noFriendList", friendUserList);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "250");//selectNoFriend failed
		}
		return j.toJson(m);
	}
}
