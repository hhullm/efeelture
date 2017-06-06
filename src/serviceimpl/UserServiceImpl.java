package serviceimpl;
/**
 * @author 
 * 
 * 
 */

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import entity.User;

public class UserServiceImpl {

	/*
	 * 注册
	 */
	String register(Map<String, Object> map) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			User user = MapTransEntity.transUser(map);
			User u = userDaoImpl.checkUser(user);
			String custId = u.getCustId();
			if (custId != null && !custId.equals(""))
				m.put("resultCode", "601");// 已被注册
			else {
				userDaoImpl.addUser(user);
				u.setPhoneNumber(user.getPhoneNumber());
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
	String login(Map<String, Object> map) {
		return null;
	}

	/*
	 * 头像上传
	 */
	String uploadPicture(Map<String, Object> map) {
		return null;
	}

	/*
	 * 用户信息修改
	 */
	String modifyUser(Map<String, Object> map) {
		return null;
	}

	/*
	 * 重置密码
	 */
	String resetPassword(Map<String, Object> map) {
		return null;
	}
	
	/*
	 * 忘记密码
	 */
	String findPassword(Map<String, Object> map) {
		return null;
	}
	
	/*
	 * 绑定手机
	 */
	String bindPhone(Map<String, Object> map) {
		return null;
	}
	
	/*
	 * get yanzhen
	 */
	String getCode(Map<String, Object> map) {
		return null;
	}
	
}
