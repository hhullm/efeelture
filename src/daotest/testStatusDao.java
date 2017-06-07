package daotest;

import daoimpl.StatusDaoImpl;
import entity.Status;
import util.PKUtil;

public class testStatusDao {
	static Status s=new Status();
	static StatusDaoImpl si=new StatusDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add();
//	    delete();
//		update();
//    	select();

	}
	
	public static void add(){
		s.setId(PKUtil.getRandomPk());
		s.setUid(PKUtil.getRandomPk());
		si.addStatus(s);
		
	}
	
	public static void delete(){
		s.setId("2799c475b9d64c11");
		si.deleteStatus(s);
		
	}
	
	public static void update(){
		s.setId("d4209a1aaa054989");
		si.modifyStatus(s);
		
	}
	
	public static void select(){
		System.out.println(si.selectStatus(s).get(0).getId());
		System.out.println(si.selectStatus(s).get(1).getId());
		
	}

}
