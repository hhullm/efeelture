package imserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import imclient.ClientActivity;

/**
 * 瀹㈡埛绔娇鐢� Scoket(ip,port);鍙傛暟鏄湇鍔″櫒鐨刬p鍜岀鍙ｅ彿锛屽洜涓烘病鏈夋寚瀹�
 * 瀹㈡埛绔鎺ュ瓧鐨勫噯纭甶p鍜岀鍙ｏ紝鎵�浠ユ湇鍔″櫒鍙戝線涓�鍙版満鍣ㄤ笂鐨勪换涓�瀹㈡埛绔殑娑堟伅锛屽叾浠�
 * 瀹㈡埛绔兘鑳芥敹鍒般�傛墍浠ュ垱寤哄鎺ュ瓧鏃讹紝鏈�濂芥寚瀹氬鎺ュ瓧绔彛
 */
public class ServerListen
// implements ServletContextListener
{
	private final int PORT = 8399;
	private ServerSocket server;

	// public static void main(String args[]){
	// new ServerListen().begin();
	// }
	/*
	 * @Override public void contextDestroyed(ServletContextEvent arg0) { //
	 * TODO Auto-generated method stub try { server.close(); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * } }
	 * 
	 * @Override public void contextInitialized(ServletContextEvent arg0) { //
	 * TODO Auto-generated method stub new ServerListen().begin();
	 * 
	 * }
	 * 
	 */
	public void begin() {
		try {
			server = new ServerSocket(PORT);
			//System.out.println("鏈嶅姟鍣ㄥ凡缁忓惎鍔�...");
		} catch (IOException e) {
			//System.out.println("鏈嶅姟鍣ㄥ惎鍔ㄥけ璐�");
			e.printStackTrace();
		}
		while (true) {
			try {
				Socket client = server.accept();
				new ClientActivity(this, client);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 鑾峰緱鍦ㄧ嚎鐢ㄦ埛
	 */
	public ClientActivity getClientByID(String id) {
		return OnMap.getInstance().getClientById(id);
	}

	public void closeClientByID(String id) {
		OnMap.getInstance().removeClient(id);
	}

	public void addClient(String id, ClientActivity ca0) {
		OnMap.getInstance().addClient(id, ca0);
	}

	public boolean contatinId(String id) {
		return OnMap.getInstance().isContainId(id);
	}

	public void close() {
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int size() {
		return OnMap.getInstance().size();
	}

}
