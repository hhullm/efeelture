package util;

public class RecogUtil {
	public static String getSemantic(String txt) {
		// talk to txt
		
		String uname="";
		String clevel="";
		for (int i = 1; i <= txt.length(); i++) {
			String ctrl = txt.substring(i-1, i);
			//System.out.println(ctrl);
			if (ctrl.equals("灯"))
			{
				uname="light";
			}else if (ctrl.equals("空调"))
			{
				uname="air";
			}
			else if (ctrl.equals("一"))
			{
				clevel="1";
			}else if (ctrl.equals("二"))
			{
				
				clevel="2";
			}else if (ctrl.equals("三"))
			{
				clevel="3";
			}else if (ctrl.equals("四"))
			{
				
				clevel="4";
			}
			
		}
		//System.out.println(uname+"  "+clevel);
		return uname+"  "+clevel;
	}
}
