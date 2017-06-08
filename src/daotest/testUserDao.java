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
//    	select();
//    	login();
		isEmpty();
//		check();
	}
	public static void check() {
		t.setPhone("18262896789");
		System.out.println(ti.checkUser(t).getId());
		
	}
	public static void isEmpty() {
		t.setId("5ccf490c287749dd");
		t.setPhone("182628969");
		System.out.println(ti.isEmpty(t).getId());
		System.out.println(ti.isEmpty(t).getPhone());
		
	}
	public static void login() {
		t.setPhone("18262896789");
		t.setUpassword("123456");
		ti.loginUser(t);
		
		
	}
	public static void add() {
		t.setId(PKUtil.getRandomPk());
		t.setPhone("18262896789");
		t.setUpassword("123456");
		ti.addUser(t);
	}
	public static void delete() {
		t.setId("a30455616d9b4af6");
		ti.deleteUser(t);
	}
	public static void update() {
		t.setId("a30455616d9b4af6");
		t.setSign("saafsfas");
		ti.modifyUser(t);
	}
	public static void select() {
		t.setId("5ccf490c287749dd");
		System.out.println(ti.selectUser(t).get(0).getPhone());
		System.out.println(ti.selectUser(t).get(0).getSign());
		System.out.println(ti.selectUser(t).get(0).getUpassword());
	}

}
