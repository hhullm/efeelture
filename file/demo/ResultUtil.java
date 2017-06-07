ackage utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ResultUtil {
	public static String getResult(String resultCode) {
		int result = Integer.valueOf(resultCode);
		switch (result) {
		case 200:
			return "鎿嶄綔鎴愬姛";
		case 600:
			return "鏈煡閿欒";
		case 601:
			return "鏈煡閿欒";
		case 602:
			return "鏈煡閿欒";
		case 603:
			return "鏈煡閿欒";
		case 604:
			return "鏈煡閿欒";
		default:
			return "鏈煡閿欒";
		}
	}

	public static String getResultCode() {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("resultCode", "600");//鐢ㄦ埛涓婁紶瀛楁涓嶇鍚�
		return gson.toJson(map);
	}
	
	public static String getErrorResultCode(){
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("resultCode", "0000");
		return gson.toJson(map);
	}
}
