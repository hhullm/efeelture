package daotest;

import daoimpl.JectiveDaoImpl;
import entity.Jective;
import util.PKUtil;

public class testJectiveDao {
	static Jective j=new Jective();
	static JectiveDaoImpl ji=new JectiveDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		add();
//		delete();
//		update();
    	select();

	}
	
	public static void add() {
		j.setId(PKUtil.getRandomPk());
		j.setUid(PKUtil.getRandomPk());
		ji.addJective(j);
	}
	public static void delete() {
		j.setId("0ed7b99c84084811");
		ji.deleteJective(j);
	}
	public static void update() {
		j.setId("1704ec3850ea4a82");
		j.setWord("cys");
		ji.modifyJective(j);
	}
	public static void select(){
		j.setId("1704ec3850ea4a82");
		System.out.println(ji.selectJective(j).get(0).getWord());
		System.out.println(ji.selectJective(j).get(0).getJtime());
		
	}

}
