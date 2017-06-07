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
				m.put("resultCode", "631");
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
