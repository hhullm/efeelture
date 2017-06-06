package service;

import java.util.List;
import java.util.Map;

import entity.Like;

public interface LikeService {
	/*
	 * 
	 */
	String addLike(Map<String, Object> map);

	/*
	 * 
	 */
	String deleteLike(Map<String, Object> map);
	
	/*
	 * 
	 */
	List<Like> selectLike(Map<String, Object> map);
}
