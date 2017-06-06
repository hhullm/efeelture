package daotest;

import daoimpl.UserDaoImpl;
import entity.User;
import util.PKUtil;

public class testUserDao {

	static User t=new User();
	static UserDaoImpl ti=new UserDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		add();
//		delete();
//		update();
    	select();
	}
	public static void add() {

		t.setId(PKUtil.getRandomPk());
		t.setPhone("18262896780");
		ti.addUser(t);
	}
	public static void delete() {
		t.setPhone("18262896789");
		ti.deleteUser(t);
	}
	public static void update() {
		t.setPhone("32412412");
		ti.updateUser(t);
	}
	public static void select() {
		//t.setPhone("18262896780");
		System.out.println(ti.selectUser(t).get(0).getPhone());
		System.out.println(ti.selectUser(t).get(0).getId());
		
		System.out.println(ti.selectUser(t).get(1).getPhone());
		System.out.println(ti.selectUser(t).get(1).getId());
	}

}
