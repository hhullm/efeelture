package daotest;

import daoimpl.CtrlDaoImpl;
import entity.Ctrl;
import util.DateUtil;
import util.PKUtil;

public class testCtrlDao {
	static Ctrl c=new Ctrl();
	static CtrlDaoImpl ci=new CtrlDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		add();
//		delete();
//		update();
//    	select();

	}
	
	public static void add(){
		c.setId(PKUtil.getRandomPk());
		c.setUid(PKUtil.getRandomPk());
		c.setHid(PKUtil.getRandomPk());
		c.setUipaddress("192.168.1.1");
		ci.addCtrl(c);
		
	}
	
	public static void delete(){
		
	}

}
