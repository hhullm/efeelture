package zsTCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Socket s=new Socket("localhost",5000);
		DataInputStream datain =new DataInputStream(s.getInputStream());
		System.out.println(datain.readUTF());
		
		datain.close();
		s.close();
		
	}

}
