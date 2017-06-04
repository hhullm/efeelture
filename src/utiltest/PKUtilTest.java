package utiltest;

import util.PKUtil;

public class PKUtilTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PKUtil pKUtil = new PKUtil();
		System.out.println(pKUtil.getRandomPk());
		
		// String pk = UUID.randomUUID().toString();
		// System.out.println(pk);
		// pk = pk.replaceAll("-", "").substring(0, 16);
		// System.out.println(pk);
	}
}
