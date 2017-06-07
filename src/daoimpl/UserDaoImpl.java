package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import util.CipherUtil;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;
/**
 * DAO�㣬�����ݿ�����
 */
import entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		Connection conn = null;
		try {
			user.setId(PKUtil.getRandomPk());
			user.setUtime(DateUtil.getDate());			
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into db_user(id,phone,uname,utype,upassword,ipaddress,ustatus,sex,age,picture,sign) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
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
					.prepareStatement("select * from db_user where (uname=? or phone=?) and upassword=?");
			stat.setString(1, user.getUname());
			stat.setString(2, user.getPhone());
			stat.setString(3, user.getUpassword());
			ResultSet rst = stat.executeQuery();
			user = new User();
			if (rst.next()) {
				user.setId(rst.getString("id"));
				user.setPhone(rst.getString("phone"));
				user.setUname(rst.getString("uname"));		
				user.setUname(rst.getString("utype"));	
				user.setUpassword(rst.getString("upassword"));
				user.setUpassword(rst.getString("ipaddress"));
				user.setUstatus(rst.getString("ustatus"));
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
	public void modifyUser(User user) {
		Connection conn = null;
		try {
			user = getUser(user,user.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update user set id=?,phone=?,uname=?,utype =?,upassword=?,ipaddress=?,sex=?,age=?,picture=?,sign=?");
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

			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				user = new User();
				user.setId(rst.getString("id"));
				user.setPhone(rst.getString("phone"));
				user.setUname(rst.getString("uname"));		
				user.setUtype(rst.getString("utype"));	
				user.setUpassword(rst.getString("upassword"));
				user.setIpaddress(rst.getString("ipaddress"));
				user.setUstatus(rst.getString("ustatus"));
				user.setSex(rst.getString("sex"));
				user.setAge(rst.getString("age"));
				user.setPicture(rst.getString("picture"));
				user.setSign(rst.getString("sign"));
				userList.add(user);
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
		String sql = "select * from db_user";
		if (user != null) {
			sql += " WHERE 1=1";
			if (user.getId() != null && !user.getId().equals(""))
				sql += " and id=" + user.getId();
			if (user.getPhone() != null && !user.getPhone().equals(""))
				sql += " and phone=" + user.getPhone();
			if (user.getUname() != null && !user.getUname().equals(""))
				sql += " and uname=" + user.getUname();
			if (user.getUtype() != null && !user.getUtype().equals(""))
				sql += " and utype=" + user.getUtype();
			if (user.getUpassword() != null && !user.getUpassword().equals(""))
				sql += " and upassword=" + user.getUpassword();
			if (user.getIpaddress() != null && !user.getIpaddress().equals(""))
				sql += " and ipaddress=" + user.getIpaddress();
			if (user.getUstatus() != null && !user.getUstatus().equals(""))
				sql += " and ustatus=" + user.getUstatus();
			if (user.getSex() != null && !user.getSex().equals(""))
				sql += " and sex=" + user.getSex();
			if (user.getAge() != null && !user.getAge().equals(""))
				sql += " and age=" + user.getAge();
			if (user.getPicture() != null && !user.getPicture().equals(""))
				sql += " and picture=" + user.getPicture();
			if (user.getSign() != null && !user.getSign().equals(""))
				sql += " and sign=" + user.getSign();
			
			
		}

		return sql;
	}

	@Override
	public User loginUser(User user) {
		Connection conn = null;
		try {
			user.setUpassword(CipherUtil.generatePassword(user.getUpassword()));
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("select * from db_user where (uname=? or phone=? or id=?) and password=?");
			stat.setString(1, user.getUname());
			stat.setString(2, user.getPhone());
			stat.setString(3, user.getId());
			stat.setString(4, user.getUpassword());
			ResultSet rst = stat.executeQuery();
			user = new User();
			if (rst.next()) {
				user.setId(rst.getString("id"));
				user.setPhone(rst.getString("phone"));
				user.setUname(rst.getString("uname"));		
				user.setUtype(rst.getString("utype"));	
				user.setUpassword(rst.getString("upassword"));
				user.setIpaddress(rst.getString("ipaddress"));
				user.setUstatus(rst.getString("ustatus"));
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
		return user;
		
	}

	@Override
	public User isEmpty(User user) {
		// TODO 自动生成的方法存根
		if (user.getId() == null)
			user.setId("");
		if (user.getPhone() == null)
			user.setPhone("");
		if (user.getUname() == null)
			user.setUname("");
		if (user.getUtype() == null)
			user.setUtype("");
		if (user.getUpassword() == null)
			user.setUpassword("");
		if (user.getIpaddress() == null)
			user.setIpaddress("");
		if (user.getUstatus() == null)
			user.setUstatus("");
		if (user.getSex() == null)
			user.setSex("");
		if (user.getAge() == null)
			user.setAge("");
		if (user.getPicture() == null)
			user.setPicture("");
		if (user.getSign() == null)
			user.setSign("");
		
		if (user.getId().equals("") && user.getPhone().equals("") && user.getUname().equals("")
				&& user.getUtype().equals("") && user.getUpassword().equals("") && user.getIpaddress().equals("")
				&& user.getUstatus().equals("") && user.getSex().equals("") && user.getAge().equals("")
				&& user.getPicture().equals("") && user.getSign().equals("")
				)
			return null;
		else
			return user;
	
	}

	@Override
	public User checkUser(User user) {
		Connection conn = null;
		try {
			user.setUpassword(CipherUtil.generatePassword(user.getUpassword()));
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("select * from user where name=? or phone=?");
			stat.setString(1, user.getUname());
			stat.setString(2, user.getPhone());
			ResultSet rst = stat.executeQuery();
			user = new User();
			if (rst.next()) {
				user.setId(rst.getString("custId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return user;
	}

}
