package serviceimpl;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import entity.User;
import service.UserService;

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
				m.put("resultCode", "601");// 已被注册
			else {
				userDaoImpl.addUser(user);
				u.setPhone(user.getPhone());
				m.put("userList", userDaoImpl.selectUser(u));
				m.put("resultCode", "200");
				String headUrl = getAvatar(custId);
				if (headUrl != null && !headUrl.equals(""))
					m.put("headUrl", headUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "602");// 注册失败
		}
		return j.toJson(m);
	}

	/*
	 * 登录
	 */
	public String login(User user) {
		return null;
	}

	/*
	 * 头像上传
	 */
	public String uploadPicture(User user) {
		return null;
	}

	/*
	 * 用户信息修改
	 */
	public String modifyUser(User user) {
		return null;
	}

	/*
	 * 重置密码
	 */
	public String resetPassword(User user) {
		return null;
	}
	
	/*
	 * 忘记密码
	 */
	public String findPassword(User user) {
		return null;
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
