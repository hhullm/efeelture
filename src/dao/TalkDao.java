package dao;
/**
 * @author 
 * 
 * 
 */
import java.util.List;

import entity.Talk;

public interface TalkDao {

	/*
	 * ������������
	 */
	void addTalk(Talk talk);
	
	/*
	 * ɾ����������
	 */
	
	void deleteTalk(Talk talk);
	
	/*
	 * ������������
	 */
	void modifyTalk(Talk talk);

	/*
	 * ��ѯ��������
	 */
	List<Talk> selectTalk(Talk talk);
	
}



