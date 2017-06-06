package dao;

import entity.Activity;

public class DaoTest {
	static ActivityDaoImpl Impl = new ActivityDaoImpl();
	static Activity m = new Activity();
	public static void main(String[] args) {
			
//		add();
//		delete();
//		update();
    	select();
	}
	public static void add() {

		m.setAddress("000");
		Impl.addActivity(m);
	}
	public static void delete() {
		m.setActivityId("2d473a1a93874b4e");
		Impl.deleteActivity(m);
	}
	public static void update() {
		m.setActivityId("9b490bfc005d4320");
		Impl.updateActivity(m);
	}
	public static void select() {
				//m.setActivityFinishTime("5201314");
		System.out.println(Impl.selectActivity(m).get(0).getActivityContent());
		System.out.println(Impl.selectActivity(m).get(1).getActivityContent());
		System.out.println(Impl.selectActivity(m).get(2).getActivityContent());
		System.out.println(Impl.selectActivity(m).get(3).getActivityContent());
		System.out.println(Impl.selectActivity(m).get(4).getActivityContent());
	}
	
	
}
