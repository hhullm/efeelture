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
		if (map.containsKey("ipaddress"))
			user.setId((String) map.get("ipaddress"));
		if (map.containsKey("phone"))
			user.setId((String) map.get("phone"));
		if (map.containsKey("picture"))
			user.setId((String) map.get("picture"));
		if (map.containsKey("sex"))
			user.setId((String) map.get("sex"));
		if (map.containsKey("sign"))
			user.setId((String) map.get("sign"));
		if (map.containsKey("uname"))
			user.setId((String) map.get("uname"));
		if (map.containsKey("upassword"))
			user.setId((String) map.get("upassword"));
		if (map.containsKey("ustatus"))
			user.setId((String) map.get("ustatus"));
		if (map.containsKey("utype"))
			user.setId((String) map.get("utype"));
		return user;
	}
	public static Ctrl toCtrl(Map<String, Object> map){
		Ctrl ctrl = new Ctrl();
		if (map.containsKey("content"))
			ctrl.setId((String) map.get("content"));
		if (map.containsKey("cstatus"))
			ctrl.setId((String) map.get("cstatus"));
		if (map.containsKey("ctime"))
			ctrl.setId((String) map.get("ctime"));
		if (map.containsKey("hid"))
			ctrl.setId((String) map.get("hid"));
		if (map.containsKey("hname"))
			ctrl.setId((String) map.get("hname"));
		if (map.containsKey("id"))
			ctrl.setId((String) map.get("id"));
		if (map.containsKey("uid"))
			ctrl.setId((String) map.get("uid"));
		if (map.containsKey("uipaddress"))
			ctrl.setId((String) map.get("uipaddress"));
		if (map.containsKey("uname"))
			ctrl.setId((String) map.get("uname"));
		return ctrl;
	}
	public static Friend toFriend(Map<String, Object> map){
		Friend friend = new Friend();
		if (map.containsKey("firstid"))
			friend.setId((String) map.get("firstid"));
		if (map.containsKey("fstatus"))
			friend.setId((String) map.get("fstatus"));
		if (map.containsKey("id"))
			friend.setId((String) map.get("id"));
		if (map.containsKey("secondid"))
			friend.setId((String) map.get("secondid"));
		return friend;
	}
	public static Hardware toHardware(Map<String, Object> map){
		Hardware hardware = new Hardware();
		if (map.containsKey("hardwareid"))
			hardware.setId((String) map.get("hardwareid"));
		if (map.containsKey("id"))
			hardware.setId((String) map.get("id"));
		if (map.containsKey("uid"))
			hardware.setId((String) map.get("uid"));
		return hardware;
	}
	public static Jective toJective(Map<String, Object> map){
		Jective jective = new Jective();
		if (map.containsKey("air"))
			jective.setId((String) map.get("air"));
		if (map.containsKey("humidity"))
			jective.setId((String) map.get("humidity"));
		if (map.containsKey("id"))
			jective.setId((String) map.get("id"));
		if (map.containsKey("jtime"))
			jective.setId((String) map.get("jtime"));
		if (map.containsKey("music"))
			jective.setId((String) map.get("music"));
		if (map.containsKey("peoplenumber"))
			jective.setId((String) map.get("peoplenumber"));
		if (map.containsKey("picturecolor"))
			jective.setId((String) map.get("picturecolor"));
		if (map.containsKey("picturenumber"))
			jective.setId((String) map.get("picturenumber"));
		if (map.containsKey("temperature"))
			jective.setId((String) map.get("tenperature"));
		if (map.containsKey("uid"))
			jective.setId((String) map.get("uid"));
		if (map.containsKey("weekday"))
			jective.setId((String) map.get("weekday"));
		if (map.containsKey("word"))
			jective.setId((String) map.get("word"));
		return jective;
	}
	public static Like toLike(Map<String, Object> map){
		Like like = new Like();
		if (map.containsKey("id"))
			like.setId((String) map.get("id"));
		if (map.containsKey("messageid"))
			like.setId((String) map.get("messageid"));
		if (map.containsKey("uid"))
			like.setId((String) map.get("uid"));
		return like;
	}
	public static Message toMessage(Map<String, Object> map){
		Message message = new Message();
		if (map.containsKey("address"))
			message.setId((String) map.get("address"));
		if (map.containsKey("content"))
			message.setId((String) map.get("content"));
		if (map.containsKey("id"))
			message.setId((String) map.get("id"));
		if (map.containsKey("likenumber"))
			message.setId((String) map.get("likenumber"));
		if (map.containsKey("mstatus"))
			message.setId((String) map.get("mstatus"));
		if (map.containsKey("mtype"))
			message.setId((String) map.get("mtype"));
		if (map.containsKey("permission"))
			message.setId((String) map.get("permission"));
		if (map.containsKey("picture"))
			message.setId((String) map.get("picture"));
		if (map.containsKey("uid"))
			message.setId((String) map.get("uid"));
		if (map.containsKey("uname"))
			message.setId((String) map.get("uname"));
		return message;
	}
	public static Reply toReply(Map<String, Object> map){
		Reply reply = new Reply();
		if (map.containsKey("content"))
			reply.setId((String) map.get("content"));
		if (map.containsKey("firstid"))
			reply.setId((String) map.get("firstid"));
		if (map.containsKey("id"))
			reply.setId((String) map.get("id"));
		if (map.containsKey("messageid"))
			reply.setId((String) map.get("messageid"));
		if (map.containsKey("rtime"))
			reply.setId((String) map.get("rtime"));
		if (map.containsKey("secondid"))
			reply.setId((String) map.get("secondid"));
		return reply;
	}
	public static Status toStatus(Map<String, Object> map){
		Status status = new Status();
		if (map.containsKey("address"))
			status.setId((String) map.get("address"));
		if (map.containsKey("id"))
			status.setId((String) map.get("id"));
		if (map.containsKey("ipaddress"))
			status.setId((String) map.get("ipaddress"));
		if (map.containsKey("ipport"))
			status.setId((String) map.get("ipport"));
		if (map.containsKey("sstatus"))
			status.setId((String) map.get("sstatus"));
		if (map.containsKey("stime"))
			status.setId((String) map.get("stime"));
		if (map.containsKey("uid"))
			status.setId((String) map.get("uid"));
		if (map.containsKey("uname"))
			status.setId((String) map.get("uname"));
		return status;
	}
	public static Talk toTalk(Map<String, Object> map){
		Talk talk = new Talk();
		if (map.containsKey("content"))
			talk.setId((String) map.get("content"));
		if (map.containsKey("firstid"))
			talk.setId((String) map.get("firstid"));
		if (map.containsKey("id"))
			talk.setId((String) map.get("id"));
		if (map.containsKey("secondid"))
			talk.setId((String) map.get("secondid"));
		if (map.containsKey("ttype"))
			talk.setId((String) map.get("ttype"));
		return talk;
	}
}
