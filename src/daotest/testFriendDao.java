package daotest;

import daoimpl.FriendDaoImpl;
import entity.Friend;
import util.PKUtil;

public class testFriendDao {
	static Friend f=new Friend();
	static FriendDaoImpl fi=new FriendDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		add();
//	    delete();
//		update();
    	select();

	}
	
	public static void add(){
		f.setId(PKUtil.getRandomPk());
		f.setFirstid(PKUtil.getRandomPk());
		f.setSecondid(PKUtil.getRandomPk());
		fi.addFriend(f);
		
	}
	
	public static void delete(){
		f.setId("53ddccc158fd43c2");
		fi.deleteFriend(f);
		
	}
	
	public static void update(){
		f.setId("8bc908ad44274eff");
		f.setFstatus("0");
		fi.modifyFriend(f);
		
	}
	
	public static void select(){
		f.setId("308ca59380224559");
		System.out.println(fi.selectFriend(f).get(0).getFirstid());
		System.out.println(fi.selectFriend(f).get(0).getSecondid());
		
	}

}
