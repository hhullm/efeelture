package daotest;

import daoimpl.CtrlDaoImpl;
import entity.Ctrl;
import util.PKUtil;

public class testCtrlDao {
	static Ctrl c=new Ctrl();
	static CtrlDaoImpl ci=new CtrlDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		add();
//	    delete();
//		update();
    	select();

	}
	
	public static void add(){
		c.setId(PKUtil.getRandomPk());
		c.setUid(PKUtil.getRandomPk());
		c.setHid(PKUtil.getRandomPk());
		c.setUipaddress("192.168.1.1");
		ci.addCtrl(c);
		
	}
	
	public static void delete(){
		c.setId("2799c475b9d64c11");
		ci.deleteCtrl(c);
		
	}
	
	public static void update(){
		c.setId("d4209a1aaa054989");
		c.setUipaddress("192.168.1.2");
		ci.modifyCtrl(c);
		
	}
	
	public static void select(){
		c.setId("6eab27e6faa043dd");
		System.out.println(ci.selectCtrl(c).get(0).getId());
		System.out.println(ci.selectCtrl(c).get(0).getCtime());
		
	}

}
