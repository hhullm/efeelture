package util;

public class RecogUtil {

	public static String getClevel(String txt) {
		String result = "";
		String clevel = "";
		for (int i = 1; i <= txt.length(); i++) {
			clevel = txt.substring(i - 1, i);
			switch (clevel) {
			case "零":
			case "0":
				result = "0";
				break;
			case "一":
			case "1":
				result = "1";
				break;
			case "二":
			case "2":
				result = "2";
				break;
			case "三":
			case "3":
				result = "3";
				break;
			case "四":
			case "4":
				result = "4";
				break;
			case "五":
			case "5":
				result = "5";
				break;
			case "六":
			case "6":
				result = "6";
				break;
			case "七":
			case "7":
				result = "7";
				break;
			case "八":
			case "8":
				result = "8";
				break;
			case "九":
			case "9":
				result = "9";
				break;
			case "十":
			case "10":
				result = "10";
				break;
			default:
				result = "0";
				break;
			}
		}
		return result;
	}

	public static String getUname(String txt) {
		String result = "";
		String uname = "";
		for (int i = 1; i <= txt.length(); i++) {
			uname = txt.substring(i - 1, i);
			switch (uname) {
			case "车":
				result = "car";
				break;
			case "空调":
				result = "air";
				break;
			case "灯":
				result = "light";
				break;
			case "抓":
			case "机器臂":
			case "取":
				result = "arm";
				break;
			default:
				result = "light";
				break;
			}
		}
		return result;
	}
}
