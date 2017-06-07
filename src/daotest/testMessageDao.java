package daotest;

import daoimpl.MessageDaoImpl;
import entity.Message;
import util.PKUtil;

public class testMessageDao {
	static Message m=new Message();
	static MessageDaoImpl mi=new MessageDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add();
//	    delete();
//		update();
//    	select();

	}
	
	public static void add(){
		m.setId(PKUtil.getRandomPk());
		m.setLikenumber("0");
		m.setUid(PKUtil.getRandomPk());
		m.setMtype("0");
		mi.addMessage(m);
		
	}
	
	public static void delete(){
		m.setId("2799c475b9d64c11");
		mi.deleteMessage(m);
		
	}
	
	public static void update(){
		m.setId("d4209a1aaa054989");
		mi.modifyMessage(m);;
		
	}
	
	public static void select(){
		System.out.println(mi.selectMessage(m).get(0).getId());
		System.out.println(mi.selectMessage(m).get(1).getId());
		
	}

}
