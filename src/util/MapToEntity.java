package util;

import java.util.Map;

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

public class MapToEntity {

	public static User toUser(Map<String, Object> map){
		User user = new User();
		if (map.containsKey("age"))
			user.setAge((String) map.get("age"));
		if (map.containsKey("id"))
			user.setId((String) map.get("id"));
		return user;
	}
	public static Ctrl toCtrl(Map<String, Object> map){
		Ctrl ctrl = new Ctrl();

		return ctrl;
	}
	public static Friend toFriend(Map<String, Object> map){
		Friend friend = new Friend();

		return friend;
	}
	public static Hardware toHardware(Map<String, Object> map){
		Hardware hardware = new Hardware();

		return hardware;
	}
	public static Jective toJective(Map<String, Object> map){
		Jective jective = new Jective();

		return jective;
	}
	public static Like toLike(Map<String, Object> map){
		Like like = new Like();

		return like;
	}
	public static Message toMessage(Map<String, Object> map){
		Message message = new Message();

		return message;
	}
	public static Reply toReply(Map<String, Object> map){
		Reply reply = new Reply();

		return reply;
	}
	public static Status toStatus(Map<String, Object> map){
		Status status = new Status();

		return status;
	}
	public static Talk toTalk(Map<String, Object> map){
		Talk talk = new Talk();

		return talk;
	}
}
