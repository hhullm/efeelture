package serviceimpl;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import daoimpl.UserDaoImpl;
import entity.User;
import service.UserService;
import util.MapToEntity;

/**
 * @author
 * 
 * 
 */

public class UserServiceImpl implements UserService {

	/*
	 * 注册
	 */
	public String register(User user) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			User u = userDaoImpl.checkUser(user);
			String custId = u.getId();
			if (custId != null && !custId.equals(""))
				m.put("resultCode", "1011");// 已被注册
			else {
				userDaoImpl.addUser(user);
				u.setPhone(user.getPhone());
				m.put("userList", userDaoImpl.selectUser(u));
				m.put("resultCode", "999");
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1010");// 注册失败
		}
		return j.toJson(m);
	}

	/*
	 * 登录
	 */
	public String login(User user) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			user = userDaoImpl.loginUser(user);
			if (user.getId() == null || (user.getId()).equals(""))
				m.put("resultCode", "1021");// 用户名密码不正确
			else {
				m = j.fromJson(j.toJson(user), new TypeToken<Map<String, Object>>() {
				}.getType());
				m.put("resultCode", "999");
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1020");// 登录出现错误
		}
		return j.toJson(m);
	}

	/*
	 * 头像上传
	 */
	public String uploadPicture(User user) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		return j.toJson(m);
	}

	/*
	 * 用户信息修改
	 */
	public String modifyUser(User user) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			userImpl.modifyUser(user);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1040");// 修改用户信息失败
		}
		return j.toJson(m);
	}

	/*
	 * 重置密码
	 */
	public String resetPassword(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			User user = MapToEntity.toUser(map);
			user = userImpl.checkUser(user);
			if (user.getId() != null && !user.getId().equals("")) {
				user.setUpassword((String) map.get("newpassword"));
				userImpl.modifyUser(user);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "1051");// 请确认手机号码是否存在
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1050");// 重置密码错误
		}
		return j.toJson(m);
	}

	public String modifyPassword(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			User user = new User();
			user.setId((String) map.get("id"));
			user.setPhone((String) map.get("phone"));
			user.setUname((String) map.get("uname"));
			user.setUpassword((String) map.get("upassword"));
			user = userImpl.loginUser(user);
			if (user.getId() != null && !user.getId().equals("")) {
				user = new User();
				user.setId((String) map.get("id"));
				user.setUpassword((String) map.get("newpassword"));
				userImpl.modifyUser(user);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "1061");// 原密码错误
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1060");// 修改密码失败
		}
		return j.toJson(m);
	}

	/*
	 * 绑定手机
	 */
	public String bindPhone(User user) {
		return null;
	}

	/*
	 * get yanzhen
	 */
	public String getCode(User user) {
		return null;
	}

}
