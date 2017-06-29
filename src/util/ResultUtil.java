package util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ResultUtil {
	public static String getResult(String resultCode) {
		int result = Integer.valueOf(resultCode);
		switch (result) {
		/*
		 * first number is table
		 * 
		 * middle number is function id
		 * 
		 * last number is result,0 is succeed,1~9 is error
		 * 
		 * 999 100 1000 is other code
		 */
		case 999:
			return "operate success";
		case 100:
			return "lack of nessary data";
		case 1000:
			return "server error";
		case 120:
			return "save ctrl failed";
		case 121:
			return "lack of data";
		case 131:
			return "not have ctrl data";
		case 130:
			return "select ctrl failed";
		case 241:
			return "not have friend data";
		case 240:
			return "select friend failed";
		case 210:
			return "add friend failed";
		case 220:
			return "delete friend failed";
		case 230:
			return "modify friend failed";
		case 260:
			return "modify friend status failed";
		case 250:
			return "select Not Friend failed";
		case 310:
			return "add hardware failed";
		case 320:
			return "delete hardware failed";
		case 331:
			return "not have hardware data";
		case 330:
			return "select hardware failed";
		case 410:
			return "add jective failed";
		case 420:
			return "select jective failed";
		case 421:
			return "not have jective data";
		case 510:
			return "add like failed";
		case 520:
			return "delete like failed";
		case 530:
			return "select like failed";
		case 531:
			return "not have like data";
		case 610:
			return "add message failed";
		case 620:
			return "delete message failed";
		case 660:
			return "modify message status failed";
		case 662:
			return "status data error";
		case 661:
			return "status data format error";
		case 670:
			return "modify message failed";
		case 650:
			return "modify message likenumber failed";
		case 641:
			return "not have message data";
		case 640:
			return "select message failed";
		case 630:
			return "select friend message failed";
		case 631:
			return "not have friend message data";
		case 632:
			return "lack of data";
		case 710:
			return "add reply failed";
		case 720:
			return "delete reply failed";
		case 730:
			return "select reply failed";
		case 731:
			return "not have reply data";
		case 810:
			return "add status failed";
		case 820:
			return "select status failed";
		case 821:
			return "not have status data";
		case 910:
			return "add talk failed";
		case 920:
			return "delete talk failed";
		case 930:
			return "select talk failed";
		case 931:
			return "not have talk data";
		case 1060:
			return "register failed";
		case 1061:
			return "phone already used";
		case 1030:
			return "login failed";
		case 1031:
			return "please register";
		case 1050:
			return "modify user failed";
		case 1070:
			return "reset password failed";
		case 1071:
			return "the phone have not been used";
		case 1040:
			return "modify password failed";
		case 1041:
			return "the phone have not been used";
		case 1090:
			return "select users failed";
		case 1091:
			return "not hava users data";
		case 1092:
			return "lack of type data";
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
		// upload data format not ture
		return gson.toJson(map);
	}

	public static String getErrorResultCode() {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("resultCode", "1000");
		return gson.toJson(map);
	}
}
