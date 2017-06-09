package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.MessageDaoImpl;
import entity.Message;
import service.MessageService;

public class MessageServiceImpl implements MessageService {

	/*
	 * 
	 */
	public String addMessage(Message message) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			MessageDaoImpl Impl = new MessageDaoImpl();
			Impl.addMessage(message);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "610");
		}
		return j.toJson(m);
	}

	/*
	 * 
	 */
	public String deleteMessage(Message message) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			MessageDaoImpl Impl = new MessageDaoImpl();
			message.setMstatus("0");
			Impl.modifyMessage(message);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "620");
		}
		return j.toJson(m);
	}

	public String updateLikenumberMessage(Message message) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			MessageDaoImpl Impl = new MessageDaoImpl();
			String likenumber = Impl.selectMessage(message).get(0).getLikenumber();
			int liken = Integer.parseInt(likenumber);
			if (message.getLikenumber() != null && message.getLikenumber() != "") {
				if (message.getLikenumber().equals("-1")) {
					liken--;
					message.setLikenumber(String.valueOf(liken));
					Impl.modifyMessage(message);
					m.put("resultCode", "999");
				} else if (message.getLikenumber().equals("1")) {
					liken++;
					message.setLikenumber(String.valueOf(liken));
					Impl.modifyMessage(message);
					m.put("resultCode", "999");
				} else {
					m.put("resultCode", "621");// data format error
				}
			} else {
				m.put("resultCode", "622");//have no data
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "620");
		}
		return j.toJson(m);
	}

	/*
	 * 
	 */
	public String selectMessage(Message message) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			MessageDaoImpl Impl = new MessageDaoImpl();
			List<Message> messageList = Impl.selectMessage(message);
			if (messageList.size() > 0) {
				m.put("messageList", messageList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "631");//have no message
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "630");
		}
		return j.toJson(m);
	}

	/*
	 * no realize
	 */
	public String selectFriendMessage(Message message) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		return j.toJson(m);
	}
}
