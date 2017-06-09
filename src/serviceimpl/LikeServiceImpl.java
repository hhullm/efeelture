package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.LikeDaoImpl;
import entity.Like;
import service.LikeService;

public class LikeServiceImpl implements LikeService {
	/*
	 * 
	 */
	public String addLike(Like like) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			LikeDaoImpl Impl = new LikeDaoImpl();
			Impl.addLike(like);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "510");
		}
		return j.toJson(m);
	}

	/*
	 * 
	 */
	public String deleteLike(Like like) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			LikeDaoImpl Impl = new LikeDaoImpl();
			Impl.deleteLike(like);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "520");
		}
		return j.toJson(m);
	}
	
	/*
	 * 
	 */
	public String selectLike(Like like) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			LikeDaoImpl Impl = new LikeDaoImpl();
			List<Like> likeList = Impl.selectLike(like);
			if (likeList.size() > 0) {
				m.put("likeList", likeList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "531");//have no people like
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "530");
		}
		return j.toJson(m);
	}
}
