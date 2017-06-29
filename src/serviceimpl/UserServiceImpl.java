package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.UserDaoImpl;
import entity.User;
import service.UserService;
import util.MapToEntity;

public class UserServiceImpl implements UserService {

	/**
	 * 1096
	 */
	public String register(User user) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			User u = userDaoImpl.checkUser(user);
			String custId = u.getId();
			if (custId != null && !custId.equals(""))
				m.put("resultCode", "1061");// already used
			else {
				userDaoImpl.addUser(user);
				m.put("resultCode", "999");
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1060");
		}
		return j.toJson(m);
	}

	/**
	 * 1093
	 */
	public String login(User user) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			user = userDaoImpl.loginUser(user);
			if (user.getId() == null || (user.getId()).equals(""))
				m.put("resultCode", "1031");
			else {
				m.put("user", user);
				m.put("resultCode", "999");
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1030");
		}
		return j.toJson(m);
	}

	/**
	 * 1098
	 */
	public String uploadPicture(User user) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		return j.toJson(m);
	}

	/**
	 * 1095
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
			m.put("resultCode", "1050");
		}
		return j.toJson(m);
	}

	/**
	 * 1097
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
				m.put("resultCode", "1071");// from data error
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1070");//
		}
		return j.toJson(m);
	}

	/**
	 * 1094
	 */
	public String modifyPassword(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			User user = new User();
			user.setId((String) map.get("id"));
			user.setPhone((String) map.get("phone"));
			user.setUpassword((String) map.get("upassword"));
			user = userImpl.loginUser(user);
			if (user.getId() != null && !user.getId().equals("")) {
				user = new User();
				user.setId((String) map.get("id"));
				user.setUpassword((String) map.get("newpassword"));
				userImpl.modifyUser(user);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "1041");// data error
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1040");
		}
		return j.toJson(m);
	}

	/**
	 * 1091
	 */
	public String bindPhone(User user) {
		return null;
	}

	/**
	 * 1092
	 */
	public String getCode(User user) {
		return null;
	}

	/**
	 * 1099
	 */
	public String getUserByType(User user) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl daoImpl = new UserDaoImpl();
			List<User> userList = daoImpl.selectUser(user);
			if (user.getUtype() != null && user.getUtype() != "") {
				if (userList.size() > 0) {
					m.put("userList", userList);
					m.put("resultCode", "999");
				} else
					m.put("resultCode", "1091");// have no user
			} else
				m.put("resultCode", "1092");// lack of type
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1090");// select failed
		}
		return j.toJson(m);
	}
}
