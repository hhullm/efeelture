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
	 * ����һ���û�
	 */
	void addUser(User user);

	/*
	 * ��¼����
	 */
	void deleteUser(User user);

	/*
	 * �����û���Ϣ
	 */
	void modifyUser(User user);

	/*
	 * ��ѯ�û���Ϣ
	 */
	List<User> selectUser(User user);
	
	
	
	User loginUser(User user);
	
	
	
	
	User isEmpty(User user);
	
	
	
	
	User checkUser(User user);
	
}
