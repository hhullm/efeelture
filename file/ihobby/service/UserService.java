package service;

import java.util.List;
import entity.User;

/**
 * 
 * @author 994072500
 *
 *         服务层。实现DAO层的方法并将数据交给controller层
 */
public interface UserService {

	
	/*
	 * 查询用户信息
	 */
	List<User> selectUser(User user);
	
	/*
	 * 修改用户基本信息
	 */
	String modifyUser(User user);
	
	/*
	 * 删除一个用户
	 */
	String delUser(User user);

}
