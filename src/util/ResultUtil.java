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
			return "操作成功";
		case 110:
			return "未知错误600";
		case 111:
			return "未知错误601";
		case 131:
			return "未知错误602";
		case 130:
			return "未知错误603";
		case 211:
			return "未知错误604";
		case 210:
			return "未知错误604";
		case 220:
			return "未知错误604";
		case 230:
			return "未知错误604";
		case 240:
			return "未知错误604";
		case 250:
			return "未知错误604";
		case 310:
			return "未知错误604";
		case 320:
			return "未知错误604";
		case 331:
			return "未知错误604";
		case 330:
			return "未知错误604";
		case 410:
			return "未知错误604";
		case 420:
			return "未知错误604";
		case 421:
			return "未知错误604";
		case 510:
			return "未知错误604";
		case 520:
			return "未知错误604";
		case 530:
			return "未知错误604";
		case 531:
			return "未知错误604";
		case 610:
			return "未知错误604";
		case 620:
			return "未知错误604";
		case 630:
			return "未知错误604";
		case 631:
			return "未知错误604";
		case 710:
			return "未知错误604";
		case 720:
			return "未知错误604";
		case 730:
			return "未知错误604";
		case 731:
			return "未知错误604";
		case 810:
			return "未知错误604";
		case 830:
			return "未知错误604";
		case 910:
			return "未知错误604";
		case 920:
			return "未知错误604";
		case 930:
			return "未知错误604";
		case 931:
			return "未知错误604";
		case 1010:
			return "未知错误604";
		case 1011:
			return "未知错误604";
		case 1020:
			return "未知错误604";
		case 1021:
			return "未知错误604";
		case 1040:
			return "未知错误604";
		case 1051:
			return "未知错误604";
		case 1050:
			return "未知错误604";
		case 1061:
			return "未知错误604";
		case 1060:
			return "未知错误604";
		default:
			return "未知错误";
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
