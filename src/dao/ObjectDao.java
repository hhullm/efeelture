package dao;
/**
 
 * 
 * 
 */
import java.util.List;

import entity.Object;

public interface ObjectDao {

	/*
	 * ��������
	 */
	void addObject(Object object);
	
	/*
	 * ɾ��������Ϣ
	 */
	
	void deleteObject(Object object);
	
	/*
	 * ���Ķ�����Ϣ
	 */
	void modifyObject(Object object);

	/*
	 * ��ѯ������Ϣ
	 */
	List<Object> selectObject(Object object);
	
}