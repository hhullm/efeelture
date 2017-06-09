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
			user.setIpaddress((String) map.get("ipaddress"));
		if (map.containsKey("phone"))
			user.setPhone((String) map.get("phone"));
		if (map.containsKey("picture"))
			user.setPicture((String) map.get("picture"));
		if (map.containsKey("sex"))
			user.setSex((String) map.get("sex"));
		if (map.containsKey("sign"))
			user.setSign((String) map.get("sign"));
		if (map.containsKey("uname"))
			user.setUname((String) map.get("uname"));
		if (map.containsKey("upassword"))
			user.setUpassword((String) map.get("upassword"));
		if (map.containsKey("ustatus"))
			user.setUstatus((String) map.get("ustatus"));
		if (map.containsKey("utype"))
			user.setUtype((String) map.get("utype"));
		if (map.containsKey("utime"))
			user.setUtime((String) map.get("utime"));
		return user;
	}
	public static Ctrl toCtrl(Map<String, Object> map){
		Ctrl ctrl = new Ctrl();
		if (map.containsKey("content"))
			ctrl.setContent((String) map.get("content"));
		if (map.containsKey("clevel"))
			ctrl.setClevel((String) map.get("clevel"));
		if (map.containsKey("ctime"))
			ctrl.setCtime((String) map.get("ctime"));
		if (map.containsKey("hid"))
			ctrl.setHid((String) map.get("hid"));
		if (map.containsKey("hname"))
			ctrl.setHname((String) map.get("hname"));
		if (map.containsKey("id"))
			ctrl.setId((String) map.get("id"));
		if (map.containsKey("uid"))
			ctrl.setUid((String) map.get("uid"));
		if (map.containsKey("uipaddress"))
			ctrl.setUipaddress((String) map.get("uipaddress"));
		if (map.containsKey("uname"))
			ctrl.setUname((String) map.get("uname"));
		return ctrl;
	}
	public static Friend toFriend(Map<String, Object> map){
		Friend friend = new Friend();
		if (map.containsKey("firstid"))
			friend.setFirstid((String) map.get("firstid"));
		if (map.containsKey("fstatus"))
			friend.setFstatus((String) map.get("fstatus"));
		if (map.containsKey("id"))
			friend.setId((String) map.get("id"));
		if (map.containsKey("ftime"))
			friend.setFtime((String) map.get("ftime"));
		if (map.containsKey("secondid"))
			friend.setSecondid((String) map.get("secondid"));
		return friend;
	}
	public static Hardware toHardware(Map<String, Object> map){
		Hardware hardware = new Hardware();
		if (map.containsKey("hardwareid"))
			hardware.setHardwareid((String) map.get("hardwareid"));
		if (map.containsKey("id"))
			hardware.setId((String) map.get("id"));
		if (map.containsKey("htime"))
			hardware.setHtime((String) map.get("htime"));
		if (map.containsKey("uid"))
			hardware.setUid((String) map.get("uid"));
		return hardware;
	}
	public static Jective toJective(Map<String, Object> map){
		Jective jective = new Jective();
		if (map.containsKey("air"))
			jective.setAir((String) map.get("air"));
		if (map.containsKey("humidity"))
			jective.setHumidity((String) map.get("humidity"));
		if (map.containsKey("id"))
			jective.setId((String) map.get("id"));
		if (map.containsKey("jtime"))
			jective.setJtime((String) map.get("jtime"));
		if (map.containsKey("music"))
			jective.setMusic((String) map.get("music"));
		if (map.containsKey("peoplenumber"))
			jective.setPeoplenumber((String) map.get("peoplenumber"));
		if (map.containsKey("picturecolor"))
			jective.setPicturecolor((String) map.get("picturecolor"));
		if (map.containsKey("picturenumber"))
			jective.setPicturenumber((String) map.get("picturenumber"));
		if (map.containsKey("temperature"))
			jective.setTemperature((String) map.get("tenperature"));
		if (map.containsKey("uid"))
			jective.setUid((String) map.get("uid"));
		if (map.containsKey("weekday"))
			jective.setWeekday((String) map.get("weekday"));
		if (map.containsKey("word"))
			jective.setWord((String) map.get("word"));
		return jective;
	}
	public static Like toLike(Map<String, Object> map){
		Like like = new Like();
		if (map.containsKey("id"))
			like.setId((String) map.get("id"));
		if (map.containsKey("ltime"))
			like.setLtime((String) map.get("ltime"));
		if (map.containsKey("messageid"))
			like.setMessageid((String) map.get("messageid"));
		if (map.containsKey("uid"))
			like.setUid((String) map.get("uid"));
		return like;
	}
	public static Message toMessage(Map<String, Object> map){
		Message message = new Message();
		if (map.containsKey("address"))
			message.setAddress((String) map.get("address"));
		if (map.containsKey("content"))
			message.setContent((String) map.get("content"));
		if (map.containsKey("id"))
			message.setId((String) map.get("id"));
		if (map.containsKey("likenumber"))
			message.setLikenumber((String) map.get("likenumber"));
		if (map.containsKey("mstatus"))
			message.setMstatus((String) map.get("mstatus"));
		if (map.containsKey("mtype"))
			message.setMtype((String) map.get("mtype"));
		if (map.containsKey("mtime"))
			message.setMtime((String) map.get("mtime"));
		if (map.containsKey("permission"))
			message.setPermission((String) map.get("permission"));
		if (map.containsKey("picture"))
			message.setPicture((String) map.get("picture"));
		if (map.containsKey("uid"))
			message.setUid((String) map.get("uid"));
		if (map.containsKey("uname"))
			message.setUname((String) map.get("uname"));
		if (map.containsKey("jword"))
			message.setJword((String) map.get("jword"));
		if (map.containsKey("jpicturecolor"))
			message.setJpicturecolor((String) map.get("jpicturecolor"));
		if (map.containsKey("jpicturenumber"))
			message.setJpicturenumber((String) map.get("jpicturenumber"));
		if (map.containsKey("jmusic"))
			message.setJmusic((String) map.get("jmusic"));
		return message;
	}
	public static Reply toReply(Map<String, Object> map){
		Reply reply = new Reply();
		if (map.containsKey("content"))
			reply.setContent((String) map.get("content"));
		if (map.containsKey("firstid"))
			reply.setFirstid((String) map.get("firstid"));
		if (map.containsKey("id"))
			reply.setId((String) map.get("id"));
		if (map.containsKey("messageid"))
			reply.setMessageid((String) map.get("messageid"));
		if (map.containsKey("rtime"))
			reply.setRtime((String) map.get("rtime"));
		if (map.containsKey("secondid"))
			reply.setSecondid((String) map.get("secondid"));
		return reply;
	}
	public static Status toStatus(Map<String, Object> map){
		Status status = new Status();
		if (map.containsKey("address"))
			status.setAddress((String) map.get("address"));
		if (map.containsKey("id"))
			status.setId((String) map.get("id"));
		if (map.containsKey("ipaddress"))
			status.setIpaddress((String) map.get("ipaddress"));
		if (map.containsKey("ipport"))
			status.setIpport((String) map.get("ipport"));
		if (map.containsKey("sstatus"))
			status.setSstatus((String) map.get("sstatus"));
		if (map.containsKey("stime"))
			status.setStime((String) map.get("stime"));
		if (map.containsKey("uid"))
			status.setUid((String) map.get("uid"));
		if (map.containsKey("uname"))
			status.setUname((String) map.get("uname"));
		return status;
	}
	public static Talk toTalk(Map<String, Object> map){
		Talk talk = new Talk();
		if (map.containsKey("content"))
			talk.setContent((String) map.get("content"));
		if (map.containsKey("firstid"))
			talk.setFirstid((String) map.get("firstid"));
		if (map.containsKey("id"))
			talk.setId((String) map.get("id"));
		if (map.containsKey("secondid"))
			talk.setSecondid((String) map.get("secondid"));
		if (map.containsKey("ttype"))
			talk.setTtype((String) map.get("ttype"));
		if (map.containsKey("ttime"))
			talk.setTtime((String) map.get("ttime"));
		return talk;
	}
}
