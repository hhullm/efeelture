package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.FriendDaoImpl;
import entity.Friend;
import entity.User;
import service.FriendService;

public class FriendServiceImpl implements FriendService {

	/*
	 * 好友列表查询
	 */
	public String selectFriend(Friend friend) {

		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			friend.setFstatus("1");
			List<Friend> friendList = friendImpl.selectFriend(friend);
			if (friendList.size() > 0) {
				m.put("friendList", friendList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "211");// 没有朋友列表
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "210");// 朋友列表查询失败
		}
		return j.toJson(m);
	}

	/*
	 * 加好友
	 */
	public String addFriend(Friend friend) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			friendImpl.addFriend(friend);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "220");// 增加相册失败
		}
		return j.toJson(m);
	}

	/*
	 * 删除好友
	 */
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
			m.put("resultCode", "220");// 增加相册失败
		}
		return j.toJson(m);
	}

	/*
	 * 修改好友信息
	 */
	public String modifyFriend(Friend friend) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			friendImpl.addFriend(friend);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "220");// 增加相册失败
		}
		return j.toJson(m);
	}

	/*
	 * 查询非好友信息
	 */
	public String selectNoFriend(User user) {

		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			List<Friend> friendList = friendImpl.selectFriend(friend);
			if (friendList.size() > 0) {
				m.put("friendList", friendList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "211");// 没有朋友列表
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "210");// 朋友列表查询失败
		}
		return j.toJson(m);
	}
}
