package imclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import entity.TranObject;
import entity.User;
import imdao.FriendImDao;
import imdao.TalkImDao;
import imdao.UserImDao;
import imserver.ServerListen;
import util.ResultUtil;
import util.TranObjectType;

/**
 * @author Administrator 客户端线程
 */
public class ClientActivity {
	/*
	 * 发送队列， 因为服务器有多个监听客户端的线程，当很多好友一起向他发送消息，每个服务器线程 都同时调用此实例的socket争夺send
	 * ，并发控制异常。
	 */
	private LinkedList<TranObject> sendQueue;
	private ServerListen mServer; // 服务器
	private User user;
	private Socket mClient; // 客户端连接
	private ClientListenThread mClientListen; // 客户端监听进程
	private ClientSendThread mClientSend; // 客户端发送进程
	private ObjectOutputStream mOutput;
	private ObjectInputStream mInput;

	public ClientActivity(ServerListen mServer, Socket mClient) {
		user = new User();
		sendQueue = new LinkedList<TranObject>();
		this.mServer = mServer;
		this.mClient = mClient;
		try {
			mOutput = new ObjectOutputStream(mClient.getOutputStream());
			mInput = new ObjectInputStream(mClient.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		mClientListen = new ClientListenThread(mInput, this);
		mClientSend = new ClientSendThread(this);
		Thread listen = new Thread(mClientListen);
		Thread send = new Thread(mClientSend);
		listen.start();
		send.start();
	}

	public Socket getmClient() {
		return mClient;
	}

	public void setmClient(Socket mClient) {
		this.mClient = mClient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user.setPhone(user.getPhone());
		this.user.setAge(user.getAge());
		this.user.setSex(user.getSex());
		this.user.setId(user.getId());
		this.user.setUname(user.getUname());
		this.user.setPicture(user.getPicture());
	}

	/**
	 * 检查注册账号是否存在
	 */
	public void checkAccount(String account) {
		mServer.addClient(user.getId(), this);
		boolean isExisted = UserImDao.selectAccount(account);
		TranObject tran = new TranObject("", TranObjectType.REGISTER_ACCOUNT);
		if (isExisted)
			tran.setResult(ResultUtil.getResult("1111"));
		else
			tran.setResult(ResultUtil.getResult("1112"));
		send(tran);
	}

	/**
	 * 检查账号和用户名是否存在
	 */

	public void login(TranObject tran) {
		User user = (User) tran.getObject();
		// 验证密码和用户名是否存在，若存在则为user对象赋值
		boolean isExisted = UserImDao.login(user);
		if (isExisted == true) {
			UserImDao.updateIsOnline(user.getId(), "1");
			setUser(user);
			System.out.println(user.getPhone() + "上线了");
			tran.setResult(ResultUtil.getResult("1115"));
			mServer.addClient(user.getId(), this);
			System.out.println("当前在线人数：" + mServer.size());
			// 获取好友列表

			tran.setObject(user);

		} else
			tran.setResult(ResultUtil.getResult("1116"));
		send(tran);
		/*
		 * try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		// 获取离线信息
		ArrayList<TranObject> offMsg = TalkImDao.selectMsg(user.getId());
		for (int i = 0; i < offMsg.size(); i++)
			insertQueue(offMsg.get(i));
		TalkImDao.deleteSaveMsg(user.getId());

	}

	public synchronized void send(TranObject tran) {
		try {
			mOutput.writeObject(tran);
			mOutput.flush();
			notify();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 注册
	 */
	/*
	 * public void regist(TranObject tran) { User user = (User)
	 * tran.getObject(); int id = UserDao.insertInfo(user); user.setId(id); if
	 * (id == -1) tran.setResult(ResultUtil.getResult("1114")); else
	 * tran.setResult(ResultUtil.getResult("1113"));
	 * System.out.println("发送注册结果..."); send(tran); }
	 */
	/**
	 * 客户端下线
	 */
	public void getOffLine() {
		mServer.closeClientByID(user.getId());
		UserImDao.updateIsOnline(user.getId(), "0");
	}

	/**
	 * 关闭与客户端的连接
	 */
	public void close() {
		try {
			mClient.close();// socket关闭后，他所在的流也都自动关闭
			mClientListen.close();
			mClientSend.close();
			if (!user.getId().equals("0"))
				getOffLine();
			System.out.println(user.getPhone() + "下线了...");
		} catch (IOException e) {
			System.out.println("关闭失败.....");
			e.printStackTrace();
		}
	}

	/**
	 * 查找朋友
	 */
	public void searchFriend(TranObject tran) {
		String values[] = ((String) tran.getObject()).split(" ");
		ArrayList<User> list= UserImDao.selectFriendByAccountOrID(values[1]);
		System.out.println((String) tran.getObject());
		System.out.println("发送客户端查找的好友列表...");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		tran.setObject(list);
		send(tran);
	}

	/**
	 * 处理好友请求
	 */
	public void friendRequset(TranObject tran) {
		System.out.println("添加好友");
		String result = tran.getResult();
		// if (result == Result.FRIEND_REQUEST_RESPONSE_ACCEPT) {

		if (result.equals("1119")) {
			System.out.println("接收方id" + tran.getReceiveId());
			FriendImDao.addFriend(tran.getReceiveId(), tran.getSendId());
			FriendImDao.addFriend(tran.getSendId(), tran.getReceiveId());
			System.out.println("添加好友成功....");
			// 向好友发起方 发送自己的信息
			tran.setObject(user);
			ArrayList<User> friend = UserImDao.selectFriendByAccountOrID(tran.getSendId());
			tran.setObject(friend.get(0));
			tran.setSendName(user.getUname());
			// 向自己添加好友
			friend = UserImDao.selectFriendByAccountOrID(tran.getReceiveId());
			TranObject tran2 = new TranObject();
			tran2.setObject(friend.get(0));
			tran2.setResult(tran.getResult());
			tran2.setReceiveId(tran.getSendId());
			tran2.setSendId(tran.getReceiveId());
			tran2.setSendName(friend.get(0).getUname());
			tran2.setTranType(tran.getTranType());
			tran2.setSendTime(tran2.getSendTime());
			send(tran2);
		}
		sendFriend(tran);
	}

	/**
	 * 转发消息 将转发的消息发送到 服务器与该客户端连接的 发送队列中
	 */
	public void sendFriend(TranObject tran) {
		ClientActivity friendClient = null;
		System.out.println("包含要发送的那个好友吗？" + tran.getReceiveId() + mServer.contatinId(tran.getReceiveId()));
		if (mServer.contatinId(tran.getReceiveId())) {
			friendClient = mServer.getClientByID(tran.getReceiveId());
			System.out.println("将好友请求发给好友...");
			friendClient.insertQueue(tran);
		} else {
			TalkImDao.insertSaveMsg(user.getId(), tran);
		}

	}

	public void sendMessage(TranObject tran) {
		// 添加到好友的发送队列
		System.out.println("发送聊天信息....");
		sendFriend(tran);
	}

	/******************************** 对发送队列的异步处理 ***********************************/
	/**
	 * 发送数据 如果是从好友那里发送来的 就先添加到队列 并发控制，因为同步性太强 否则直接发送； 属于发送线程
	 */
	public synchronized void insertQueue(TranObject tran) {
		sendQueue.add(tran);
	}

	public synchronized int sizeOfQueue() {
		return sendQueue.size();
	}

	public synchronized TranObject removeQueueEle(int i) {
		return sendQueue.remove(i);
	}
}
