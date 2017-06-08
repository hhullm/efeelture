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
//	    delete();
//		update();
    	select();

	}
	
	public static void add(){
		h.setId(PKUtil.getRandomPk());
		h.setUid(PKUtil.getRandomPk());
		h.setHardwareid(PKUtil.getRandomPk());
		hi.addHardware(h);
	}
	
	public static void delete(){
		h.setId("9e07772ca2d947af");
		hi.deleteHardware(h);
		
	}
	
	public static void update(){
		h.setId("04b76fc9400b4a59");
		h.setUid("44516546456466hk");
		hi.modifyHardware(h);;
		
	}
	
	public static void select(){
		h.setId("8031773b9eae476c");
		System.out.println(hi.selectHardware(h).get(0).getUid());
		System.out.println(hi.selectHardware(h).get(0).getHardwareid());
		
	}
	
}
