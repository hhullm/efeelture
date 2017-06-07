package daotest;

import daoimpl.LikeDaoImpl;
import entity.Like;
import util.PKUtil;

public class testLikeDao {
	static Like l=new Like();
	static LikeDaoImpl li=new LikeDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		add();
//	    delete();
//		update();
    	select();

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
		l.setId("d4209a1aaa054989");
		li.modifyLike(l);
		
	}
	
	public static void select(){
		System.out.println(li.selectLike(l).get(0).getId());
		System.out.println(li.selectLike(l).get(1).getId());
		
	}

}
