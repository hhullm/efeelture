package daotest;

import daoimpl.ReplyDaoImpl;
import entity.Reply;
import util.PKUtil;

public class testReplyDao {
	static Reply r=new Reply();
	static ReplyDaoImpl ri =new ReplyDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add();
//	    delete();
//		update();
//    	select();

	}
	
	public static void add(){
		r.setId(PKUtil.getRandomPk());
		r.setMessageid(PKUtil.getRandomPk());
		r.setFirstid(PKUtil.getRandomPk());
		r.setSecondid(PKUtil.getRandomPk());
		ri.addReply(r);
		
	}
	
	public static void delete(){
		r.setId("2799c475b9d64c11");
		ri.deleteReply(r);
		
	}
	
	public static void update(){
		r.setId("d4209a1aaa054989");
		ri.modifyReply(r);
		
	}
	
	public static void select(){
		System.out.println(ri.selectReply(r).get(0).getId());
		System.out.println(ri.selectReply(r).get(1).getId());
		
	}

}
