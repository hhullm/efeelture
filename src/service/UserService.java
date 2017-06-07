package service;

import java.util.Map;

import entity.User;

/**
 * @author 
 * 
 * 
 */


public interface UserService {

	/*
	 * 注册
	 */
	String register(User user);

	/*
	 * 登录
	 */
	String login(User user);

	/*
	 * 头像上传
	 */
	String uploadPicture(User user);

	/*
	 * 用户信息修改
	 */
	String modifyUser(User user);

	/*
	 * 重置密码
	 */
	String resetPassword(Map<String, Object> map);
	
	/*
	 * 忘记密码
	 */
	String modifyPassword(Map<String, Object> map);
	
	/*
	 * 绑定手机
	 */
	String bindPhone(User user);
	
	/*
	 * get yanzhen
	 */
	String getCode(User user);
	
}
