package utiltest;

import util.HttpUtil;

public class HttpUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="http://115.159.120.220:8080/efeelture/mobileAppServlet";
		String param="func=1003&zson=%7buid:eb1b3f446f154ab5%7d";
		String result =HttpUtil.sendPost(url, param);
		System.out.println(result);
	}

}
