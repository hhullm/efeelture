package dao;
/**
 * @author 
 * 
 * 
 */
import java.util.List;

import entity.User;

public interface UserDao {

	/*
	 * 新增一个用户
	 */
	void addUser(User user);

	/*
	 * 登录操作
	 */
	User checkUser(User user);

	/*
	 * 更改用户信息
	 */
	void modifyUser(User user);

	/*
	 * 查询用户信息
	 */
	List<User> selectUser(User user);
	
}
