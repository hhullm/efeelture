package service;
/**
 * @author 
 * 
 * 
 */

import java.util.Map;

public interface UserService {

	/*
	 * 注册
	 */
	String register(Map<String, Object> map);

	/*
	 * 登录
	 */
	String login(Map<String, Object> map);

	/*
	 * 头像上传
	 */
	String uploadPicture(Map<String, Object> map);

	/*
	 * 用户信息修改
	 */
	String modifyUser(Map<String, Object> map);

	/*
	 * 重置密码
	 */
	String resetPassword(Map<String, Object> map);
}
