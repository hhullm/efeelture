package util;

public class RecogUtil {
	public static String getSemantic(String txt) {
		// talk to txt
		
		String uname="";
		String clevel="";
		for (int i = 1; i <= txt.length(); i++) {
			String ctrl = txt.substring(i-1, i);
			//System.out.println(ctrl);
			if (ctrl.equals("��"))
			{
				uname="light";
			}else if (ctrl.equals("�յ�"))
			{
				uname="air";
			}
			else if (ctrl.equals("һ"))
			{
				clevel="1";
			}else if (ctrl.equals("��"))
			{
				
				clevel="2";
			}else if (ctrl.equals("��"))
			{
				clevel="3";
			}else if (ctrl.equals("��"))
			{
				
				clevel="4";
			}
			
		}
		//System.out.println(uname+"  "+clevel);
		return uname+"  "+clevel;
	}
}
