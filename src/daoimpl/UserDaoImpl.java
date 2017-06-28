package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;

import entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		Connection conn = null;
		try {
			user.setId(PKUtil.getRandomPk());
			user.setUtime(DateUtil.getDate());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"insert into db_user(id,phone,uname,utype,upassword,ipaddress,ustatus,sex,age,picture,sign,utime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
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
			stat.setString(12, user.getUtime());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

	@Override
	public void deleteUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("delete from db_user where id=?");
			stat.setString(1, user.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void modifyUser(User user) {
		Connection conn = null;
		try {
			user = getUser(user, user.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"update db_user set phone=?,uname=?,utype=?,upassword=?,ipaddress=?,ustatus=?,sex=?,age=?,picture=?,sign=?,utime=? where id=?");
			stat.setString(1, user.getPhone());
			stat.setString(2, user.getUname());
			stat.setString(3, user.getUtype());
			stat.setString(4, user.getUpassword());
			stat.setString(5, user.getIpaddress());
			stat.setString(6, user.getUstatus());
			stat.setString(7, user.getSex());
			stat.setString(8, user.getAge());
			stat.setString(9, user.getPicture());
			stat.setString(10, user.getSign());
			stat.setString(11, user.getUtime());
			stat.setString(12, user.getId());
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
			PreparedStatement stat = null;
			String sql = getSql(user);
			stat = conn.prepareStatement(sql);
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
				user.setUtime(rst.getString("utime"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return userList;
	}

	private User getUser(User user, String Id) {
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
		if (user.getUtime() != null && !user.getUtime().equals(""))
			f.setUtime(user.getUtime());

		return f;
	}

	private String getSql(User user) {
		String sql = "select * from db_user";
		if (user != null) {
			sql += " WHERE 1=1";
			if (user.getId() != null && !user.getId().equals(""))
				sql += " and id='" + user.getId() + "'";
			if (user.getPhone() != null && !user.getPhone().equals(""))
				sql += " and phone='" + user.getPhone() + "'";
			if (user.getUname() != null && !user.getUname().equals(""))
				sql += " and uname='" + user.getUname() + "'";
			if (user.getUtype() != null && !user.getUtype().equals(""))
				sql += " and utype='" + user.getUtype() + "'";
			if (user.getUpassword() != null && !user.getUpassword().equals(""))
				sql += " and upassword='" + user.getUpassword() + "'";
			if (user.getIpaddress() != null && !user.getIpaddress().equals(""))
				sql += " and ipaddress='" + user.getIpaddress() + "'";
			if (user.getUstatus() != null && !user.getUstatus().equals(""))
				sql += " and ustatus='" + user.getUstatus() + "'";
			if (user.getSex() != null && !user.getSex().equals(""))
				sql += " and sex='" + user.getSex() + "'";
			if (user.getAge() != null && !user.getAge().equals(""))
				sql += " and age='" + user.getAge() + "'";
			if (user.getPicture() != null && !user.getPicture().equals(""))
				sql += " and picture='" + user.getPicture() + "'";
			if (user.getSign() != null && !user.getSign().equals(""))
				sql += " and sign='" + user.getSign() + "'";
			if (user.getUtime() != null && !user.getUtime().equals(""))
				sql += " and utime='" + user.getUtime() + "'";

		}
		sql += " order by utime desc";

		return sql;
	}

	@Override
	public User loginUser(User user) {
		Connection conn = null;
		try {
			// user.setUpassword(CipherUtil.generatePassword(user.getUpassword()));
			user.setUpassword(user.getUpassword());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("select * from db_user where (phone=? or id=?) and upassword=?");
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
				user.setUtime(rst.getString("utime"));

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
		if (user.getUtime() == null)
			user.setUtime("");

		if (user.getId().equals("") && user.getPhone().equals("") && user.getUname().equals("")
				&& user.getUtype().equals("") && user.getUpassword().equals("") && user.getIpaddress().equals("")
				&& user.getUstatus().equals("") && user.getSex().equals("") && user.getAge().equals("")
				&& user.getPicture().equals("") && user.getSign().equals("") && user.getUtime().equals(""))
			return null;
		else
			return user;

	}

	@Override
	public User checkUser(User user) {
		Connection conn = null;
		try {
			// user.setUpassword(CipherUtil.generatePassword(user.getUpassword()));
			user.setUpassword(user.getUpassword());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("select * from db_user where phone=?");
			stat.setString(1, user.getUname());
			stat.setString(2, user.getPhone());
			ResultSet rst = stat.executeQuery();
			user = new User();
			if (rst.next()) {
				user.setId(rst.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return user;
	}

}
