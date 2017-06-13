package imtest;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import entity.TranObject;
import entity.User;
import util.TranObjectType;



public class Client {
	public static void main(String []args){
		try {
			Socket s =new Socket("115.159.120.220",8399);
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			entity.TranObject tran = new TranObject();
			User user = new User();
			user.setPhone("18262896789");
			user.setUpassword("123456");
			tran.setObject(user);
			tran.setTranType(TranObjectType.LOGIN);
			out.writeObject(tran);
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			while(true){}//保持程序不退出
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
