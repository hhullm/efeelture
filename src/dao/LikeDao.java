package dao;

import java.util.List;

import entity.Like;


public interface LikeDao {
	
	void addLike(Like like);
	
	void deleteLike(Like like);
	
	void modifyLike(Like like);
	
	List<Like> selectLike(Like like);

}
