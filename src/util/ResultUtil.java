package util;

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
		case 200:
			return "操作成功";
		case 600:
			return "未知错误600";
		case 601:
			return "未知错误601";
		case 602:
			return "未知错误602";
		case 603:
			return "未知错误603";
		case 604:
			return "未知错误604";
		default:
			return "未知错误";
		}
	}
}
