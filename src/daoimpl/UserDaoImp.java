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

public class UserDaoImp implements UserDao {

	@Override
	public void addUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("INSERT INTO USER(UID,UNAME,PHONE,PASSWORD,SEX,AGE,UPICTURE,SIGN) VALUES(?,?,?,?,?,?,?,?)");
			stat.setString(1, user.getId());
			stat.setString(2, user.getName());
			stat.setLong(3, user.getPhone());
			stat.setString(4, user.getPassword());
			stat.setString(5, user.getSex());
			stat.setLong(6, user.getAge());
			stat.setString(7, user.getPicture());
			stat.setString(8, user.getSign());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

	@Override
	public User checkUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("SELECT * FROM USER WHERE (UNAME=? OR PHONENUMBER=?) AND PASSWORD=?");
			stat.setString(1, user.getName());
			stat.setLong(2, user.getPhone());
			stat.setString(3, user.getPassword());
			ResultSet rst = stat.executeQuery();
			user = new User();
			if (rst.next()) {
				user.setId(rst.getString("uId"));
				user.setName(rst.getString("uName"));
				user.setPhone(rst.getInt("phone"));
				user.setPassword(rst.getString("password"));
				user.setStatus(rst.getInt("uStatus"));
				user.setAge(rst.getInt("age"));
				user.setSign(rst.getString("sign"));
				user.setSex(rst.getString("sex"));
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
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("UPDATE USER SET UNAME=?,PHONE=?,PASSWORD=?,SEX=?,AGE=?,UPICTURE=?,SIGN=?,UID=?");
			stat.setString(1, user.getName());
			stat.setLong(2, user.getPhone());
			stat.setString(3, user.getPassword());
			stat.setString(4, user.getSex());
			stat.setLong(5, user.getAge());
			stat.setString(6, user.getPicture());
			stat.setString(7, user.getSign());
			stat.setString(19, user.getId());
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
			String sql = "SELECT * FROM USER WHERE 1=1 OR UID=? ";
			if (user.getId() != null)
				sql = "SELECT * FROM USER WHERE CUSTID=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, user.getId());
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				user = new User();
				user.setId(rst.getString("uId"));
				user.setName(rst.getString("uName"));
				user.setPhone(rst.getInt("phone"));
				user.setPassword(rst.getString("password"));
				user.setStatus(rst.getInt("uStatus"));
				user.setAge(rst.getInt("age"));
				user.setSign(rst.getString("sign"));
				user.setSex(rst.getString("sex"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return userList;
	}
}
