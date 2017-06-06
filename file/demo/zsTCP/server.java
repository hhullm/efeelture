package zsTCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket server =null;
		server =new ServerSocket(5002);
			Socket s=server.accept();
			//System.out.println("link");
			
			BufferedReader br =new BufferedReader(new InputStreamReader(s.getInputStream()));
			String a=null;
			while ((a=br.readLine())!=null)
			{
				System.out.println(a);
			}
			//s.shutdownInput();
			
			PrintWriter pw=new PrintWriter(s.getOutputStream());
			pw.write("server");
			pw.flush();
			
//			DataOutputStream out =new DataOutputStream(s.getOutputStream());
//			out.writeUTF("zhangshu22222");
//			out.close();
			
			pw.close();
			br.close();
			s.close();
			server.close();
		}
		

}
