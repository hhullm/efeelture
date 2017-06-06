package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class tcpclient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		Socket s=new Socket("192.168.1.105",20006);
		
		OutputStream os =s.getOutputStream();
		PrintWriter pw=new PrintWriter(os);
	
		pw.write("lianjie");
		pw.flush();
		//s.shutdownOutput();
		

		BufferedReader br =new BufferedReader(new InputStreamReader(s.getInputStream()));
		String in=null;
		while ((in=br.readLine())!=null)
		
		{
			System.out.println(in);
		}
		
		br.close();
		pw.close();
		os.close();
		s.close();
		
		//s.shutdownOutput();
		
		//DataOutputStream out =new DataOutputStream(s.getOutputStream());
		//out.writeUTF("zhangshu11111");
		
		
		//DataInputStream in =new DataInputStream(s.getInputStream());
		//System.out.println(in.toString());
		
		//in.close();
		//s.close();
	}

}
