package dao;
/**
 
 * 
 * 
 */
import java.util.List;

import entity.Object;

public interface ObjectDao {

	/*
	 * 新增对象
	 */
	void addObject(Object object);
	
	/*
	 * 删除对象信息
	 */
	
	void deleteObject(Object object);
	
	/*
	 * 更改对象信息
	 */
	void modifyObject(Object object);

	/*
	 * 查询对象信息
	 */
	List<Object> selectObject(Object object);
	
}