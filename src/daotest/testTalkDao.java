package daotest;

import daoimpl.TalkDaoImpl;
import entity.Talk;
import util.PKUtil;

public class testTalkDao {
	static Talk t=new Talk();
	static TalkDaoImpl ti=new TalkDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		add();
//		delete();
//		update();
    	select();

	}
	public static void add() {
		t.setId(PKUtil.getRandomPk());
		t.setFirstid(PKUtil.getRandomPk());
		t.setSecondid(PKUtil.getRandomPk());
		t.setTtype("0");
		ti.addTalk(t);;
	}
	public static void delete() {
		t.setId("1b1abba144724a25");
		ti.deleteTalk(t);;
	}
	public static void update() {
		t.setId("57ed4f947a7a4a6a");
		t.setTtype("1");
		t.setContent("cys");
		ti.modifyTalk(t);;
	}
	public static void select() {
		t.setId("57ed4f947a7a4a6a");
		System.out.println(ti.selectTalk(t).get(0).getTtype());
		System.out.println(ti.selectTalk(t).get(0).getContent());

	}

}
