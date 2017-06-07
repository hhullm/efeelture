package service;

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
	String selectLike(Like like);
}
