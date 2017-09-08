package controller;

/**
 * @author zhangshu
 * 
 * 涓庡叾浠栨帴鍙ｇ閫氳
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.Ctrl;
import entity.Friend;
import entity.Hardware;
import entity.Jective;
import entity.Like;
import entity.Message;
import entity.Reply;
import entity.Status;
import entity.Talk;
import entity.User;
import serviceimpl.CtrlServiceImpl;
import serviceimpl.FriendServiceImpl;
import serviceimpl.HardwareServiceImpl;
import serviceimpl.JectiveServiceImpl;
import serviceimpl.LikeServiceImpl;
import serviceimpl.MessageServiceImpl;
import serviceimpl.ReplyServiceImpl;
import serviceimpl.StatusServiceImpl;
import serviceimpl.TalkServiceImpl;
import serviceimpl.UserServiceImpl;
import util.MapToEntity;
import util.ResultUtil;

public class WebAppServlet extends HttpServlet implements MobileApp {

	/**
	 * 鐗堟湰鍙�
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int func = Integer.valueOf(request.getParameter("func"));
		String zson = request.getParameter("zson");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		Map<String, Object> map = gson.fromJson(zson, new TypeToken<Map<String, Object>>() {
		}.getType());
		switch (func) {

		case saveCtrl:
			try {
				if (map.containsKey("hid") && map.containsKey("uid") && map.containsKey("hipaddress")
						&& map.containsKey("hname") && map.containsKey("clevel") && map.containsKey("uipaddress")) {
					CtrlServiceImpl mobile = new CtrlServiceImpl();
					Ctrl ctrl = new Ctrl();
					ctrl = MapToEntity.toCtrl(map);
					String resultCode = mobile.saveCtrl(ctrl);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectCtrl:
			try {
				if (map.containsKey("uid")) {
					CtrlServiceImpl mobile = new CtrlServiceImpl();
					Ctrl ctrl = new Ctrl();
					ctrl = MapToEntity.toCtrl(map);
					String resultCode = mobile.selectCtrl(ctrl);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case addFriend:
			try {
				if (map.containsKey("firstid") && map.containsKey("secondid")) {
					FriendServiceImpl mobile = new FriendServiceImpl();
					Friend friend = new Friend();
					friend = MapToEntity.toFriend(map);
					friend.setFstatus("1");
					String resultCode = mobile.addFriend(friend, friend.getFstatus());
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyFriendStatus:
			try {
				if (map.containsKey("id") && map.containsKey("fstatus")) {
					FriendServiceImpl mobile = new FriendServiceImpl();
					Friend friend = new Friend();
					friend = MapToEntity.toFriend(map);
					String resultCode = mobile.modifyFriendStatus(friend, friend.getFstatus());
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectFriend:
			try {
				if (map.containsKey("firstid") && map.containsKey("fstatus")) {
					FriendServiceImpl mobile = new FriendServiceImpl();
					Friend friend = new Friend();
					friend = MapToEntity.toFriend(map);
					String resultCode = mobile.selectFriend(friend, friend.getFstatus());
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectNoFriend:
			try {
				if (map.containsKey("id")) {
					FriendServiceImpl mobile = new FriendServiceImpl();
					User user = new User();
					user = MapToEntity.toUser(map);
					String resultCode = mobile.selectNoFriend(user);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case addHardware:
			try {
				if (map.containsKey("uid") && map.containsKey("hardwareid")) {
					HardwareServiceImpl mobile = new HardwareServiceImpl();
					Hardware hardware = new Hardware();
					hardware = MapToEntity.toHardware(map);
					String resultCode = mobile.addHardware(hardware);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteHardware:
			try {
				if (map.containsKey("id")) {
					HardwareServiceImpl mobile = new HardwareServiceImpl();
					Hardware hardware = new Hardware();
					hardware = MapToEntity.toHardware(map);
					String resultCode = mobile.deleteHardware(hardware);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectHardware:
			try {
				if (map.containsKey("uid")) {
					HardwareServiceImpl mobile = new HardwareServiceImpl();
					Hardware hardware = new Hardware();
					hardware = MapToEntity.toHardware(map);
					String resultCode = mobile.selectHardware(hardware);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case addJective:
			try {
				if (map.containsKey("uid")) {
					JectiveServiceImpl mobile = new JectiveServiceImpl();
					Jective jective = new Jective();
					jective = MapToEntity.toJective(map);
					String resultCode = mobile.addJective(jective);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectJective:
			try {
				JectiveServiceImpl mobile = new JectiveServiceImpl();
				Jective jective = new Jective();
				jective = MapToEntity.toJective(map);
				String resultCode = mobile.selectJective(jective);
				out.write(resultCode);
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case addLike:
			try {
				if (map.containsKey("messageid") && map.containsKey("uid")) {
					LikeServiceImpl mobile = new LikeServiceImpl();
					Like like = new Like();
					like = MapToEntity.toLike(map);
					String resultCode = mobile.addLike(like);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteLike:
			try {
				if (map.containsKey("id")) {
					LikeServiceImpl mobile = new LikeServiceImpl();
					Like like = new Like();
					like = MapToEntity.toLike(map);
					String resultCode = mobile.deleteLike(like);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectLike:
			try {
				if (map.containsKey("messageid")) {
					LikeServiceImpl mobile = new LikeServiceImpl();
					Like like = new Like();
					like = MapToEntity.toLike(map);
					String resultCode = mobile.selectLike(like);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case addMessage:
			try {
				if (map.containsKey("uid") && map.containsKey("content") && map.containsKey("mtype")
						&& map.containsKey("uname")) {
					MessageServiceImpl mobile = new MessageServiceImpl();
					Message message = new Message();
					message = MapToEntity.toMessage(map);
					message.setMstatus("1");
					message.setLikenumber("0");
					String resultCode = mobile.addMessage(message, message.getMstatus(), message.getLikenumber());
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectFriendMessage:
			try {
				if (map.containsKey("uid")) {
					MessageServiceImpl mobile = new MessageServiceImpl();
					Message message = new Message();
					message = MapToEntity.toMessage(map);
					message.setMstatus("1");
					String resultCode = mobile.selectFriendMessage(message);
					out.write(resultCode);
				} else {
					out.write(ResultUtil.getResultCode());
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectMessage:
			try {
				MessageServiceImpl mobile = new MessageServiceImpl();
				Message message = new Message();
				message = MapToEntity.toMessage(map);
				message.setMstatus("1");
				String resultCode = mobile.selectMessage(message, message.getMstatus());
				out.write(resultCode);
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyMessageLikenumber:
			try {
				if (map.containsKey("id")) {
					MessageServiceImpl mobile = new MessageServiceImpl();
					Message message = new Message();
					message = MapToEntity.toMessage(map);
					String resultCode = mobile.modifyMessageLikenumber(message);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyMessageStatus:
			try {
				if (map.containsKey("id") && map.containsKey("mstatus")) {
					MessageServiceImpl mobile = new MessageServiceImpl();
					Message message = new Message();
					message = MapToEntity.toMessage(map);
					String resultCode = mobile.modifyMessageStatus(message, message.getMstatus());
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyMessage:
			try {
				if (map.containsKey("id")) {
					MessageServiceImpl mobile = new MessageServiceImpl();
					Message message = new Message();
					message = MapToEntity.toMessage(map);
					String resultCode = mobile.modifyMessage(message);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case addReply:
			try {
				if (map.containsKey("firstid") && map.containsKey("secondid") && map.containsKey("messageid")
						&& map.containsKey("content")) {
					ReplyServiceImpl mobile = new ReplyServiceImpl();
					Reply reply = new Reply();
					reply = MapToEntity.toReply(map);
					String resultCode = mobile.addReply(reply);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteReply:
			try {
				if (map.containsKey("id")) {
					ReplyServiceImpl mobile = new ReplyServiceImpl();
					Reply reply = new Reply();
					reply = MapToEntity.toReply(map);
					String resultCode = mobile.deleteReply(reply);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectReply:
			try {
				if (map.containsKey("messageid")) {
					ReplyServiceImpl mobile = new ReplyServiceImpl();
					Reply reply = new Reply();
					reply = MapToEntity.toReply(map);
					String resultCode = mobile.selectReply(reply);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case addStatus:
			try {
				if (map.containsKey("uid") && map.containsKey("sstatus")) {
					StatusServiceImpl mobile = new StatusServiceImpl();
					Status status = new Status();
					status = MapToEntity.toStatus(map);
					String resultCode = mobile.addStatus(status, status.getSstatus());
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectStatus:
			try {
				if (map.containsKey("uid")) {
					StatusServiceImpl mobile = new StatusServiceImpl();
					Status status = new Status();
					status = MapToEntity.toStatus(map);
					String resultCode = mobile.selectStatus(status);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case addTalk:
			try {
				if (map.containsKey("firstid") && map.containsKey("secondid") && map.containsKey("content")) {
					TalkServiceImpl mobile = new TalkServiceImpl();
					Talk talk = new Talk();
					talk = MapToEntity.toTalk(map);
					String resultCode = mobile.addTalk(talk);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteTalk:
			try {
				if (map.containsKey("id")) {
					TalkServiceImpl mobile = new TalkServiceImpl();
					Talk talk = new Talk();
					talk = MapToEntity.toTalk(map);
					String resultCode = mobile.deleteTalk(talk);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectTalk:
			try {
				if (map.containsKey("firstid") && map.containsKey("secondid")) {
					TalkServiceImpl mobile = new TalkServiceImpl();
					Talk talk = new Talk();
					talk = MapToEntity.toTalk(map);
					String resultCode = mobile.selectTalk(talk);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case login:
			try {
				if (map.containsKey("upassword") && map.containsKey("phone")) {
					UserServiceImpl mobile = new UserServiceImpl();
					User user = new User();
					user = MapToEntity.toUser(map);
					String resultCode = mobile.login(user);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyPassword:
			try {
				if (map.containsKey("upassword") && map.containsKey("newpassword") && (map.containsKey("id"))) {
					UserServiceImpl mobile = new UserServiceImpl();
					String resultCode = mobile.modifyPassword(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyUser:
			try {
				if (map.containsKey("id")) {
					UserServiceImpl mobile = new UserServiceImpl();
					User user = new User();
					user = MapToEntity.toUser(map);
					String resultCode = mobile.modifyUser(user);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case register:
			try {
				if (map.containsKey("phone") && map.containsKey("uname") && map.containsKey("upassword")) {
					UserServiceImpl mobile = new UserServiceImpl();
					User user = new User();
					user = MapToEntity.toUser(map);
					String resultCode = mobile.register(user);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;

		case getUserByType:
			try {
				if (map.containsKey("utype")) {
					UserServiceImpl mobile = new UserServiceImpl();
					User user = new User();
					user = MapToEntity.toUser(map);
					String resultCode = mobile.getUserByType(user);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		default:
			try {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("resultCode", "0000");
				String resultCode = gson.toJson(m);
				out.write(resultCode);
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		}
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
