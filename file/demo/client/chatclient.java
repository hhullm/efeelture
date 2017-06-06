package client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;

public class chatclient {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		chatclient app = new chatclient();

		new Thread(new Runnable() {
			public void run() {
				Scanner sc = new Scanner(System.in);
				while (true) {
					str = sc.nextLine();
					try {
						app.action();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					app.run();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		;

		// app.run();
	}

	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private FileInputStream fis;
	private PrintStream fos;
	static String str = "start from client";
	String host = "192.168.1.107";
	int post = 5000;

	
	// public chatclient() throws IOException, ClassNotFoundException {
	// run();
	// }

	public void action() throws IOException {
		fis=new FileInputStream("/Users/test/Desktop/4659.wav");
//		byte [] bb=new byte[1024];
//		int len;
//		while ((len=fis.read(bb))>0)
//		{
//			fos.write(bb,0,len);
//		}
		
		fos.print(fis);
		fos.flush();
	}

	public void run() throws UnknownHostException, IOException, ClassNotFoundException {
		Socket s = new Socket(host, post);
		System.out.println(s.getInetAddress());

		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
//		for (int i = 0; i <= 4; i++) {
//			str = "client" + i;
//			action();
//		}

		do {
			str = (String) ois.readObject();
			System.out.println(str);
		} while (!str.equalsIgnoreCase("q"));

		oos.writeObject("q");
		oos.flush();
		oos.close();
		ois.close();
		s.close();
	}

}
