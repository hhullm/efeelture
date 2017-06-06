package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.UserDaoImpl;
import utils.CipherUtil;
import utils.DateUtil;
import entity.User;

public class UserServiceImpl implements UserService {

	@Override
	public String modifyUser(User user) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			userDaoImpl.modifyUser(user);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "603");
		}
		return j.toJson(m);
	}

	@Override
	public String delUser(User user) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			user.setCustStatus("black");
			userDaoImpl.modifyUser(user);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "604");
		}
		return j.toJson(m);
	}

	@Override
	public List<User> selectUser(User user) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<User> userList = userDaoImpl.selectUser(user);
		return userList;
	}

}
