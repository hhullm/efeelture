package util;

public class RecogUtil {

	public static String getClevel(String txt) {
		String result = "";
		String clevel = "";
		for (int i = 1; i <= txt.length(); i++) {
			clevel = txt.substring(i - 1, i);
			// System.out.println(clevel);
			switch (clevel) {
			case "零":
				result = "0";
				break;
			case "0":
				result = "0";
				break;
			case "一":
				result = "1";
				break;
			case "1":
				result = "1";
				break;
			case "二":
				result = "2";
				break;
			case "2":
				result = "2";
				break;
			case "三":
				result = "3";
				break;
			case "3":
				result = "3";
				break;
			case "四":
				result = "4";
				break;
			case "4":
				result = "4";
				break;
			case "五":
				result = "5";
				break;
			case "5":
				result = "5";
				break;
			case "六":
				result = "6";
				break;
			case "6":
				result = "6";
				break;
			case "七":
				result = "7";
				break;
			case "7":
				result = "7";
				break;
			case "八":
				result = "8";
				break;
			case "8":
				result = "8";
				break;
			case "九":
				result = "9";
				break;
			case "9":
				result = "9";
				break;
			case "十":
				result = "0";
				break;
			case "10":
				result = "10";
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
			case "空":
			case "温":
				result = "air";
				break;
			case "灯":
				result = "light";
				break;
			case "抓":
			case "臂":
			case "取":
				result = "arm";
				break;
			}
		}
		return result;
	}
}
