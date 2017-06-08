package daotest;

import daoimpl.LikeDaoImpl;
import entity.Like;
import util.PKUtil;

public class testLikeDao {
	static Like l=new Like();
	static LikeDaoImpl li=new LikeDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add();
//	    delete();
//		update();
//    	select();

	}
	
	public static void add(){
		l.setId(PKUtil.getRandomPk());
		l.setUid(PKUtil.getRandomPk());
		l.setMessageid(PKUtil.getRandomPk());
		li.addLike(l);
		
	}
	
	public static void delete(){
		l.setId("2799c475b9d64c11");
		li.deleteLike(l);
		
	}
	
	public static void update(){
		l.setId("5fa0b2c06b8243b3");
		l.setUid("654564as5d4sad55");
		li.modifyLike(l);
		
	}
	
	public static void select(){
		l.setId("5fa0b2c06b8243b3");
		System.out.println(li.selectLike(l).get(0).getLtime());
		System.out.println(li.selectLike(l).get(0).getMessageid());
		
	}

}
