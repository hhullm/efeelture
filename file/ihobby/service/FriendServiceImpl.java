package service;

/**
 * @author 994072500
 * 
 * 实现好友等基本操作的服务层
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dao.FriendDaoImpl;
import dao.UserDaoImpl;
import entity.Friend;
import entity.User;

public class FriendServiceImpl implements FriendService {

	@Override
	public List<Friend> selectFriend(Friend friend) {
		FriendDaoImpl friendDaoImpl = new FriendDaoImpl();
		List<Friend> friendList = friendDaoImpl.selectFriend(friend);
		return friendList;
	}

	@Override
	public String addFriend(Friend friend) {
		User user = new User();
		user.setCustId(friend.getFriendCustId());
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			user = userDaoImpl.selectUser(user).get(0);
			friend.setFriendCustId(user.getCustId());
			friend.setFriendName(user.getCustName());
			friend.setFriendType("0");
			FriendDaoImpl friendDaoImpl = new FriendDaoImpl();
			friendDaoImpl.addFriend(friend);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "605");
		}
		return j.toJson(m);
	}

	@Override
	public String delFriend(Friend friend) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			FriendDaoImpl friendDaoImpl = new FriendDaoImpl();
			friendDaoImpl.deleteFriend(friend);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "606");
		}
		return j.toJson(m);
	}

	@Override
	public String modifyFriend(Friend friend) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			FriendDaoImpl friendDaoImpl = new FriendDaoImpl();
			friendDaoImpl.updateFriend(friend);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "607");
		}
		return j.toJson(m);
	}

	@Override
	public List<User> selectNoFriend(User userRequest) {
		List<User> friendUserList = new ArrayList<User>();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = new User();
		List<User> userList = userDaoImpl.selectUser(user);
		for (int i = 0; i < userList.size(); i++) {
			User u = userList.get(i);
			FriendDaoImpl friendDaoImpl = new FriendDaoImpl();
			Friend friend = new Friend();
			friend.setCustId(userRequest.getCustId());
			friend.setFriendCustId(u.getCustId());
			List<Friend> friendList = friendDaoImpl.selectFriend(friend);
			if ((!u.getCustId().equals(userRequest.getCustId()))
					&& friendList.size() == 0) {
				User uu = new User();
				uu.setCustName(u.getCustName());
				uu.setPhoneNumber(u.getPhoneNumber());
				uu.setCustQq(u.getCustQq());
				uu.setCustId(u.getCustId());
				uu.setCustVip(u.getCustVip());
				friendUserList.add(uu);
			}
		}
		return friendUserList;
	}
}
