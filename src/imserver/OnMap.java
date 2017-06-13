package imserver;
import java.util.HashMap;

import imclient.ClientActivity;


/**
 * 用于保存与所有在线用户的socket连接
 * 当转发消息的时候获得好友与服务器的连接
 */
public class OnMap {
	//静态成员只要虚拟机加载了类 ，这个成员就一直存在
	private HashMap<String,ClientActivity> clientMap ; 
	private static OnMap instance ;//此静态实例类加载完成后就一直存在
	
	public static OnMap getInstance(){
		if(instance == null)
			instance = new OnMap();
		return instance;
	}
	private OnMap(){
		clientMap = new HashMap<String,ClientActivity>();
	}
    public synchronized  ClientActivity getClientById(String id){
    	return clientMap.get(id);
    }
    public synchronized void addClient(String id,ClientActivity ca0){
    	clientMap.put(id, ca0);
    }
    public synchronized void removeClient(String id){
    	clientMap.remove(id);
    }
    public synchronized boolean isContainId(String id){
      	return clientMap.containsKey(id);
    }

	public int size() {
		return clientMap.size();
	}
}
