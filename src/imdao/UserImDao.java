package imdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import daoimpl.UserDaoImpl;
import entity.User;
import util.DBUtil;

public class UserImDao {

	private UserImDao() {
	}
	public static void updateIsOnline(String id, String ustatus) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "update db_user set ustatus=? where id=?";
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, ustatus);
				ps.setString(2, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				try {
					//System.out.println("数据库正在回滚....");
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		DBUtil.close(con);
	}

	public static ArrayList<User> selectFriendByAccountOrID(String id) {
		User user = new User();
		user.setId(id);
		UserDaoImpl udi = new UserDaoImpl();
		ArrayList<User> list = (ArrayList<User>) udi.selectUser(user);
		return list;
	}

	/**
	 * 查询账号是否存在
	 * 
	 */
	public static boolean selectAccount(String id) {
		String sql = "select * from db_user where id=?";
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			try {
				con.setAutoCommit(false);
				PreparedStatement ps;
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				return rs.first() ? true : false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DBUtil.close(con);
		return false;
	}

	/**
	 * 进行登录的验证
	 */
	public static boolean login(User user) {
		boolean isExisted = false;
		UserDaoImpl udi = new UserDaoImpl();
		User u = udi.loginUser(user);
		if (u != null)
			isExisted = true;
		return isExisted;
	}
}
