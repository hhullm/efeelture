package service;

import java.util.Map;

import entity.User;




public interface UserService {

	/*
	 * 
	 */
	String register(User user);

	/*
	 *
	 */
	String login(User user);

	/*
	 * 
	 */
	String uploadPicture(User user);

	/*
	 * 
	 */
	String modifyUser(User user);

	/*
	 * 
	 */
	String resetPassword(Map<String, Object> map);
	
	/*
	 * 
	 */
	String modifyPassword(Map<String, Object> map);
	
	/*
	 * 
	 */
	String bindPhone(User user);
	
	/*
	 * get yanzhen
	 */
	String getCode(User user);
	
}
