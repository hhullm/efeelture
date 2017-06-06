package dao;
/**
 * @author 
 * 
 * 
 */
import java.util.List;

import entity.Jective;

public interface JectiveDao {

	/*
	 * ��������
	 */
	void addJective(Jective jective);
	
	/*
	 * ɾ��������Ϣ
	 */
	
	void deleteJective(Jective jective);
	
	/*
	 * ���Ķ�����Ϣ
	 */
	void updateJective(Jective jective);

	/*
	 * ��ѯ������Ϣ
	 */
	List<Jective> selectJective(Jective jective);
	
}