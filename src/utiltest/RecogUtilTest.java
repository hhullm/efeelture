package utiltest;

import util.RecogUtil;

public class RecogUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "空调开五档";
		System.out.println(RecogUtil.getUname(txt)+RecogUtil.getClevel(txt));
		
	}

}
