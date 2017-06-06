package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import util.DBUtil;
/**
 * DAO�㣬�����ݿ�����
 */
import entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("INSERT INTO USER(ID,PHONE,UNAME,UTYPE,UPASSWORD,IPADDRESS,USTATUS,SEX,AGE,PICTURE,SIGN) VALUES(?,?,?,?,?,?,?,?)");
			stat.setString(1, user.getId());
			stat.setString(2, user.getPhone());
			stat.setString(3, user.getUname());
			stat.setString(4, user.getUtype());
			stat.setString(5, user.getUpassword());
			stat.setString(6, user.getIpaddress());
			stat.setString(7, user.getUstatus());
			stat.setString(8, user.getSex());
			stat.setString(9, user.getAge());
			stat.setString(10, user.getPicture());
			stat.setString(11, user.getSign());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

	@Override
	public User deleteUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("SELECT * FROM USER WHERE (UNAME=? OR PHONE=?) AND UPASSWORD=?");
			stat.setString(1, user.getUname());
			stat.setString(2, user.getPhone());
			stat.setString(3, user.getUpassword());
			ResultSet rst = stat.executeQuery();
			user = new User();
			if (rst.next()) {
				user.setId(rst.getString("Id"));
				user.setPhone(rst.getString("phone"));
				user.setUname(rst.getString("uName"));		
				user.setUname(rst.getString("uType"));	
				user.setUpassword(rst.getString("Upassword"));
				user.setUpassword(rst.getString("Ipaddress"));
				user.setUstatus(rst.getString("uStatus"));
				user.setSex(rst.getString("sex"));
				user.setAge(rst.getString("age"));
				user.setSex(rst.getString("picture"));
				user.setSign(rst.getString("sign"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		Connection conn = null;
		try {
			user = getUser(user,user.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("UPDATE USER SET ID=?,PHONE=?,UNAME=?,UTYPE =?,UPASSWORD=?,UIPADDRESS=?,SEX=?,AGE=?,PICTURE=?,SIGN=?");
			stat.setString(1, user.getId());
			stat.setString(2, user.getPhone());
			stat.setString(3, user.getUname());
			stat.setString(4, user.getUtype());
			stat.setString(5, user.getUpassword());
			stat.setString(6, user.getIpaddress());
			stat.setString(7, user.getUstatus());
			stat.setString(8, user.getSex());
			stat.setString(9, user.getAge());
			stat.setString(10, user.getPicture());
			stat.setString(11, user.getSign());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public List<User> selectUser(User user) {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
		try {
			
			conn = DBUtil.getConnection();
			String sql = getSql(user);			
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setString(1, user.getId());
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				user = new User();
				user.setId(rst.getString("Id"));
				user.setPhone(rst.getString("phone"));
				user.setUname(rst.getString("uName"));		
				user.setUtype(rst.getString("uType"));	
				user.setUpassword(rst.getString("Upassword"));
				user.setIpaddress(rst.getString("Ipaddress"));
				user.setUstatus(rst.getString("uStatus"));
				user.setSex(rst.getString("sex"));
				user.setAge(rst.getString("age"));
				user.setPicture(rst.getString("picture"));
				user.setSign(rst.getString("sign"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return userList;
	}
	private User getUser(User user,String Id) {
		User f = new User();
		f.setId(Id);
		f = selectUser(f).get(0);
		if (user.getId() != null && !user.getId().equals(""))
			f.setId(user.getId());
		if (user.getPhone() != null && !user.getPhone().equals(""))
			f.setPhone(user.getPhone());
		if (user.getUname() != null && !user.getUname().equals(""))
			f.setUname(user.getUname());
		if (user.getUtype() != null && !user.getUtype().equals(""))
			f.setUtype(user.getUtype());
		if (user.getUpassword() != null && !user.getUpassword().equals(""))
			f.setUpassword(user.getUpassword());
		if (user.getIpaddress() != null && !user.getIpaddress().equals(""))
			f.setIpaddress(user.getIpaddress());
		if (user.getUstatus() != null && !user.getUstatus().equals(""))
			f.setUstatus(user.getUstatus());
		if (user.getSex() != null && !user.getSex().equals(""))
			f.setSex(user.getSex());
		if (user.getAge() != null && !user.getAge().equals(""))
			f.setAge(user.getAge());
		if (user.getPicture() != null && !user.getPicture().equals(""))
			f.setPicture(user.getPicture());
		if (user.getSign() != null && !user.getSign().equals(""))
			f.setSign(user.getSign());
	
		
		
		return f;
	}
	
	private String getSql(User user) {
		String sql = "SELECT * FROM USER";
		if (user != null) {
			sql += " WHERE 1=1 ";
			if (user.getId() != null && !user.getId().equals(""))
				sql += "AND ID=" + user.getId();
			if (user.getPhone() != null && !user.getPhone().equals(""))
				sql += "AND PHONE=" + user.getPhone();
			if (user.getUname() != null && !user.getUname().equals(""))
				sql += "AND UNAME=" + user.getUname();
			if (user.getUtype() != null && !user.getUtype().equals(""))
				sql += "AND UTYPE=" + user.getUtype();
			if (user.getUpassword() != null && !user.getUpassword().equals(""))
				sql += "AND UPASSWORD=" + user.getUpassword();
			if (user.getIpaddress() != null && !user.getIpaddress().equals(""))
				sql += "AND IPADDRESS=" + user.getIpaddress();
			if (user.getUstatus() != null && !user.getUstatus().equals(""))
				sql += "AND USTATUS=" + user.getUstatus();
			if (user.getSex() != null && !user.getSex().equals(""))
				sql += "AND SEX=" + user.getSex();
			if (user.getAge() != null && !user.getAge().equals(""))
				sql += "AND AGE=" + user.getAge();
			if (user.getPicture() != null && !user.getPicture().equals(""))
				sql += "AND PICTURE=" + user.getPicture();
			if (user.getSign() != null && !user.getSign().equals(""))
				sql += "AND SIGN=" + user.getSign();
			
			
		}

		return sql;
	}
}
