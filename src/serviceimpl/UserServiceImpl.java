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

	/*
	 * 
	 */
	public String register(User user) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			User u = userDaoImpl.checkUser(user);
			String custId = u.getId();
			if (custId != null && !custId.equals(""))
				m.put("resultCode", "1011");//already used
			else {
				userDaoImpl.addUser(user);
				m.put("resultCode", "999");
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1010");
		}
		return j.toJson(m);
	}

	/*
	 * 
	 */
	public String login(User user) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			user = userDaoImpl.loginUser(user);
			if (user.getId() == null || (user.getId()).equals(""))
				m.put("resultCode", "1021");// data error
			else {
				m.put("user", user);
				m.put("resultCode", "999");
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1020");
		}
		return j.toJson(m);
	}

	/*
	 * 
	 */
	public String uploadPicture(User user) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		return j.toJson(m);
	}

	/*
	 * 
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
			m.put("resultCode", "1040");
		}
		return j.toJson(m);
	}

	/*
	 *
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
				m.put("resultCode", "1051");//from data error
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1050");//
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
				m.put("resultCode", "1061");//data error
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1060");
		}
		return j.toJson(m);
	}

	/*
	 * 
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
	public String getUserByType(User user) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl daoImpl = new UserDaoImpl();
			List<User> userList = daoImpl.selectUser(user);
			if (user.getUtype()!=null && user.getUtype()!=""){
			if (userList.size() > 0) {
				m.put("ctrlList", userList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "1081");// have no user
			}else
				m.put("resultCode", "1082");// lack of type 
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "1080");// select failed
		}
		return j.toJson(m);
	}
}
