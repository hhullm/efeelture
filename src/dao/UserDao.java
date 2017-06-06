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
	User deleteUser(User user);

	/*
	 * �����û���Ϣ
	 */
	void updateUser(User user);

	/*
	 * ��ѯ�û���Ϣ
	 */
	List<User> selectUser(User user);
	
}
