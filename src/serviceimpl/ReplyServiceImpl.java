package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.ReplyDaoImpl;
import entity.Reply;
import service.ReplyService;


public class ReplyServiceImpl implements ReplyService {

	/*
	 * 
	 */
	public String addReply(Reply reply) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ReplyDaoImpl Impl = new ReplyDaoImpl();
			Impl.addReply(reply);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "710");
		}
		return j.toJson(m);
	}

	/*
	 * 
	 */
	public String deleteReply(Reply reply) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ReplyDaoImpl Impl = new ReplyDaoImpl();
			Impl.deleteReply(reply);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "720");
		}
		return j.toJson(m);
	}
	
	/*
	 * 
	 */
	public String selectReply(Reply reply) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ReplyDaoImpl Impl = new ReplyDaoImpl();
			List<Reply> replyList = Impl.selectReply(reply);
			if (replyList.size() > 0) {
				m.put("replyList", replyList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "731");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "730");
		}
		return j.toJson(m);
	}
}
