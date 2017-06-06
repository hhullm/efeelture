package dao;
/**
 * @author 
 * 
 * 
 */
import java.util.List;

import entity.Jective;

public interface ObjectDao {

	/*
	 * ��������
	 */
	void addObject(Jective object);
	
	/*
	 * ɾ��������Ϣ
	 */
	
	void deleteObject(Jective object);
	
	/*
	 * ���Ķ�����Ϣ
	 */
	void modifyObject(Jective object);

	/*
	 * ��ѯ������Ϣ
	 */
	List<Jective> selectObject(Jective object);
	
}