package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.LikeDaoImpl;
import daoimpl.MessageDaoImpl;
import entity.Like;
import entity.Message;
import service.MessageService;

public class MessageServiceImpl implements MessageService {

	/**
	 * 1051
	 */
	public String addMessage(Message message, String mstatus, String likenumber) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			MessageDaoImpl Impl = new MessageDaoImpl();
			// message.setMstatus("1");
			// message.setLikenumber("0");
			Impl.addMessage(message);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "610");
		}
		return j.toJson(m);
	}

	/**
	 * 1052
	 */
	public String deleteMessage(Message message) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			MessageDaoImpl Impl = new MessageDaoImpl();
			Impl.deleteMessage(message);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "620");
		}
		return j.toJson(m);
	}

	/**
	 * 1056
	 */
	public String modifyMessageStatus(Message message, String mstatus) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			int status = Integer.parseInt(mstatus);
			if (status >= 0 && status <= 1) {
				try {
					MessageDaoImpl Impl = new MessageDaoImpl();
					message.setMstatus(mstatus);
					Impl.modifyMessage(message);
					m.put("resultCode", "999");
				} catch (Exception e) {
					e.printStackTrace();
					m.put("resultCode", "660");
				}
			} else {
				m.put("resultCode", "662");// not 0~1
			}
		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
			m.put("resultCode", "661");// not number
		}
		return j.toJson(m);
	}

	/**
	 * 1057
	 */
	public String modifyMessage(Message message) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			MessageDaoImpl Impl = new MessageDaoImpl();
			Impl.modifyMessage(message);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "670");
		}
		return j.toJson(m);
	}

	/**
	 * 1055
	 * 
	 * @param message
	 * @return
	 */
	public String modifyMessageLikenumber(Message message) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			MessageDaoImpl Impl = new MessageDaoImpl();
			LikeDaoImpl likeImpl = new LikeDaoImpl();
			Like like = new Like();
			like.setMessageid(message.getId());
			List<Like> likeList = likeImpl.selectLike(like);
			int likenumber = likeList.size();
			String likenumberstr = String.valueOf(likenumber);
			message.setLikenumber(likenumberstr);
			Impl.modifyMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "650");
		}
		return j.toJson(m);
	}

	/**
	 * 1054
	 */
	public String selectMessage(Message message, String mstatus) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			MessageDaoImpl Impl = new MessageDaoImpl();
			List<Message> messageList = Impl.selectMessage(message);
			if (messageList.size() > 0) {
				m.put("messageList", messageList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "641");// have no message
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "640");
		}
		return j.toJson(m);
	}

	/**
	 * 1053
	 */
	public String selectFriendMessage(Message message) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		if (message.getUid() != null && message.getUid() != "") {
			try {
				MessageDaoImpl Impl = new MessageDaoImpl();
				List<Message> messageList = Impl.selectFriendMessage(message);
				if (messageList.size() > 0) {
					m.put("messageList", messageList);
					m.put("resultCode", "999");
				} else
					m.put("resultCode", "631");// have no message
			} catch (Exception e) {
				e.printStackTrace();
				m.put("resultCode", "630");
			}
		} else {
			m.put("resultCode", "632");// upload uid
		}
		return j.toJson(m);
	}

}
