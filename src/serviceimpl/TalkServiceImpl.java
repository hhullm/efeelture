package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.TalkDaoImpl;
import entity.Talk;
import service.TalkService;


public class TalkServiceImpl implements TalkService {


	/**
	 * 1081
	 */
	public String addTalk(Talk talk) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			TalkDaoImpl Impl = new TalkDaoImpl();
			Impl.addTalk(talk);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "910");
		}
		return j.toJson(m);
	}

	/**
	 * 1082
	 */
	public String deleteTalk(Talk talk) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			TalkDaoImpl Impl = new TalkDaoImpl();
			Impl.deleteTalk(talk);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "920");
		}
		return j.toJson(m);
	}
	
	/**
	 * 1083
	 */
	public String selectTalk(Talk talk) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			TalkDaoImpl Impl = new TalkDaoImpl();
			List<Talk> talkList = Impl.selectTalk(talk);
			if (talkList.size() > 0) {
				m.put("talkList", talkList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "931");//have no talk
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "930");
		}
		return j.toJson(m);
	}
	
}



