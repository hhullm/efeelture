package service;

import java.util.List;

import entity.Like;

public interface LikeService {
	/*
	 * 
	 */
	String addLike(Like like);

	/*
	 * 
	 */
	String deleteLike(Like like);
	
	/*
	 * 
	 */
	List<Like> selectLike(Like like);
}
