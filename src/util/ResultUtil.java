package util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ResultUtil {
	public static String getResult(String resultCode) {
		int result = Integer.valueOf(resultCode);
		switch (result) {
		/*
		 * first table
		 * second function
		 * third 0:Exception 1~9
		 * 
		 * 999 true
		 */
		case 999:
			return "operate success";
		case 110:
			return "save ctrl error";
		case 111:
			return "lose data";
		case 131:
			return "have no ctrl";
		case 130:
			return "selectctrl failed";
		case 211:
			return "have no friend";
		case 210:
			return "selectfriend failed";
		case 220:
			return "addfriend failed";
		case 230:
			return "deletefriend failed";
		case 240:
			return "modifyfriend failed";
		case 250:
			return "selectNoFriend failed";
		case 310:
			return "addHardware failed";
		case 320:
			return "deleteHardware failed";
		case 331:
			return "have no hardware";
		case 330:
			return "selectHardware failed";
		case 410:
			return "addJective failed";
		case 420:
			return "selectJective failed";
		case 421:
			return "have no jective";
		case 510:
			return "addLike failed";
		case 520:
			return "deleteLike failed";
		case 530:
			return "selectLike failed";
		case 531:
			return "have no people like";
		case 610:
			return "addMessage failed";
		case 620:
			return "deleteMessage failed";
		case 621:
			return "data format error";
		case 622:
			return "have no data";
		case 630:
			return "selectMessage failed";
		case 631:
			return "have no message";
		case 710:
			return "addReply failed";
		case 720:
			return "deleteReply failed";
		case 730:
			return "selectReply failed";
		case 731:
			return "have no reply";
		case 810:
			return "addStatus failed";
		case 830:
			return "selectStatus failed";
		case 831:
			return "have no status";
		case 910:
			return "addTalk failed";
		case 920:
			return "deleteTalk failed";
		case 930:
			return "selectTalk failed";
		case 931:
			return "have no talk";
		case 1010:
			return "register failed";
		case 1011:
			return "already used";
		case 1020:
			return "login failed";
		case 1021:
			return "data error";
		case 1040:
			return "modifyUser failed";
		case 1051:
			return "from data error";
		case 1050:
			return "resetPassword failed";
		case 1061:
			return "data error";
		case 1060:
			return "modifyPassword failed";
		case 1111:
			return "ACCOUNT_EXISTED";
		case 1112:
			return "ACCOUNT_CAN_USE";
		case 1113:
			return "REGISTER_SUCCESS";
		case 1114:
			return "REGISTER_FAILED";
		case 1115:
			return "LOGIN_SUCCESS";
		case 1116:
			return "LOGIN_FAILED";
		case 1117:
			return "MAKE_FRIEND_REQUEST";
		case 1118:
			return "FRIEND_REQUEST_RESPONSE_REJECT";
		case 1119:
			return "FRIEND_REQUEST_RESPONSE_ACCEPT";
		default:
			return "unknown error";
		}
	}
	public static String getResultCode() {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("resultCode", "100");
		//upload data format not ture
		return gson.toJson(map);
	}
	
	public static String getErrorResultCode(){
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("resultCode", "0000");
		return gson.toJson(map);
	}
}
