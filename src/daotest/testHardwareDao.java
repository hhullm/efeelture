package daotest;

import daoimpl.HardwareDaoImpl;
import entity.Hardware;
import util.PKUtil;

public class testHardwareDao {
	static Hardware h=new Hardware();
	static HardwareDaoImpl hi=new HardwareDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		add();
	    delete();
//		update();
//    	select();

	}
	
	public static void add(){
		h.setId(PKUtil.getRandomPk());
		h.setUid(PKUtil.getRandomPk());
		h.setHardwareid(PKUtil.getRandomPk());
		hi.addHardware(h);
	}
	
	public static void delete(){
		h.setId("a057aa4150534c33");
		hi.deleteHardware(h);
		
	}
	
	public static void update(){
		h.setId("d4209a1aaa054989");
		hi.modifyHardware(h);;
		
	}
	
	public static void select(){
		System.out.println(hi.selectHardware(h).get(0).getId());
		System.out.println(hi.selectHardware(h).get(1).getId());
		
	}
	
}
