package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.CipherUtil;
import utils.DBUtil;
import utils.DateUtil;
import utils.PKUtil;
/**
 * DAO层，与数据库连接
 */
import entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		Connection conn = null;
		try {
			user.setCustId(PKUtil.getRandomPk());
			user.setLastLoginTime(DateUtil.getDate());
			user.setSignature("今天加入了爱好贝~~~");
			user.setCustVip("0");
			user.setCustStatus("0");
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("INSERT INTO USER(CUSTID,CUSTNAME,PHONENUMBER,PASSWORD,CUSTVIP,LASTLOGINTIME,CUSTSTATUS,SIGNATURE) VALUES(?,?,?,?,?,?,?,?)");
			stat.setString(1, user.getCustId());
			stat.setString(2, user.getCustName());
			stat.setString(3, user.getPhoneNumber());
			stat.setString(4, user.getPassword());
			stat.setString(5, user.getCustVip());
			stat.setString(6, user.getLastLoginTime());
			stat.setString(7, user.getCustStatus());
			stat.setString(8, user.getSignature());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

	@Override
	public User loginUser(User user) {
		Connection conn = null;
		try {
			user.setPassword(CipherUtil.generatePassword(user.getPassword()));
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("SELECT * FROM USER WHERE (CUSTNAME=? OR PHONENUMBER=? OR CUSTID=?) AND PASSWORD=?");
			stat.setString(1, user.getCustName());
			stat.setString(2, user.getPhoneNumber());
			stat.setString(3, user.getCustId());
			stat.setString(4, user.getPassword());
			ResultSet rst = stat.executeQuery();
			user = new User();
			if (rst.next()) {
				user.setCustId(rst.getString("custId"));
				user.setCustName(rst.getString("custName"));
				user.setPhoneNumber(rst.getString("phoneNumber"));
				user.setPassword(rst.getString("password"));
				user.setGender(rst.getString("gender"));
				user.setEmail(rst.getString("email"));
				user.setCustQq(rst.getString("custQq"));
				user.setCustVip(rst.getString("custVip"));
				user.setLastLoginTime(rst.getString("lastLoginTime"));
				user.setQuestionId(rst.getString("questionId"));
				user.setAnswer(rst.getString("answer"));
				user.setAddress(rst.getString("address"));
				user.setBirthday(rst.getString("birthday"));
				user.setCustStatus(rst.getString("custStatus"));
				user.setLocationX(rst.getString("locationX"));
				user.setLocationY(rst.getString("locationY"));
				user.setEducation(rst.getString("education"));
				user.setSignature(rst.getString("signature"));
				user.setName(rst.getString("name"));
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
			user = getUser(user);
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("UPDATE USER SET CUSTNAME=?,PHONENUMBER=?,PASSWORD=?,GENDER=?,EMAIL=?,CUSTQQ=?,NAME=?,CUSTVIP=?,LASTLOGINTIME=?,"
							+ "QUESTIONID=?,ANSWER=?,CUSTSTATUS=?,LOCATIONX=?,LOCATIONY=?,BIRTHDAY=?,EDUCATION=?,ADDRESS=?,SIGNATURE=? WHERE CUSTID=?");
			stat.setString(1, user.getCustName());
			stat.setString(2, user.getPhoneNumber());
			stat.setString(3, user.getPassword());
			stat.setString(4, user.getGender());
			stat.setString(5, user.getEmail());
			stat.setString(6, user.getCustQq());
			stat.setString(7, user.getName());
			stat.setString(8, user.getCustVip());
			stat.setString(9, user.getLastLoginTime());
			stat.setString(10, user.getQuestionId());
			stat.setString(11, user.getAnswer());
			stat.setString(12, user.getCustStatus());
			stat.setString(13, user.getLocationX());
			stat.setString(14, user.getLocationY());
			stat.setString(15, user.getBirthday());
			stat.setString(16, user.getEducation());
			stat.setString(17, user.getAddress());
			stat.setString(18, user.getSignature());
			stat.setString(19, user.getCustId());
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
			user = isEmpty(user);
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM USER";
			PreparedStatement stat = null;
			if (user != null) {
				sql = "SELECT * FROM USER WHERE CUSTID=? OR CUSTNAME=? OR PHONENUMBER=? OR GENDER=? OR EMAIL=? OR CUSTVIP=? OR CUSTQQ=? OR (LOCATIONX=? AND LOCATIONY=?) OR CUSTSTATUS=? OR BIRTHDAY=? OR EDUCATION=? OR ADDRESS=? ORDER BY LASTLOGINTIME";
				stat = conn.prepareStatement(sql);
				stat.setString(1, user.getCustId());
				stat.setString(2, user.getCustName());
				stat.setString(3, user.getPhoneNumber());
				stat.setString(4, user.getGender());
				stat.setString(5, user.getEmail());
				stat.setString(6, user.getCustVip());
				stat.setString(7, user.getCustQq());
				stat.setString(8, user.getLocationX());
				stat.setString(9, user.getLocationY());
				stat.setString(10, user.getCustStatus());
				stat.setString(11, user.getBirthday());
				stat.setString(12, user.getEducation());
				stat.setString(13, user.getAddress());
			} else
				stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				user = new User();
				user.setCustId(rst.getString("custId"));
				user.setCustName(rst.getString("custName"));
				user.setPhoneNumber(rst.getString("phoneNumber"));
				user.setPassword(rst.getString("password"));
				user.setGender(rst.getString("gender"));
				user.setEmail(rst.getString("email"));
				user.setCustQq(rst.getString("custQq"));
				user.setCustVip(rst.getString("custVip"));
				user.setLastLoginTime(rst.getString("lastLoginTime"));
				user.setQuestionId(rst.getString("questionId"));
				user.setAnswer(rst.getString("answer"));
				user.setCustStatus(rst.getString("custStatus"));
				user.setLocationX(rst.getString("locationX"));
				user.setLocationY(rst.getString("locationY"));
				user.setBirthday(rst.getString("birthday"));
				user.setEducation(rst.getString("education"));
				user.setAddress(rst.getString("address"));
				user.setSignature(rst.getString("signature"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return userList;
	}

	private User getUser(User user) {
		User u = selectUser(user).get(0);
		if (user.getCustName() != null && !user.getCustName().equals(""))
			u.setCustName(user.getCustName());
		if (user.getPhoneNumber() != null && !user.getPhoneNumber().equals(""))
			u.setPhoneNumber(user.getPhoneNumber());
		if (user.getPassword() != null && !user.getPassword().equals(""))
			u.setPassword(CipherUtil.generatePassword(user.getPassword()));
		if (user.getGender() != null && !user.getGender().equals(""))
			u.setGender(user.getGender());
		if (user.getEmail() != null && !user.getEmail().equals(""))
			u.setEmail(user.getEmail());
		if (user.getCustVip() != null && !user.getCustVip().equals(""))
			u.setCustVip(user.getCustVip());
		if (user.getCustQq() != null && !user.getCustQq().equals(""))
			u.setCustQq(user.getCustQq());
		if (user.getLocationX() != null && !user.getLocationX().equals(""))
			u.setLocationX(user.getLocationX());
		if (user.getLocationY() != null && !user.getLocationY().equals(""))
			u.setLocationY(user.getLocationY());
		if (user.getCustStatus() != null && !user.getCustStatus().equals(""))
			u.setCustStatus(user.getCustStatus());
		if (user.getLastLoginTime() != null && !user.getLastLoginTime().equals(""))
			u.setLastLoginTime(user.getLastLoginTime());
		if (user.getQuestionId() != null && !user.getQuestionId().equals(""))
			u.setQuestionId(user.getQuestionId());
		if (user.getAnswer() != null && !user.getAnswer().equals(""))
			u.setAnswer(user.getAnswer());
		if (user.getBirthday() != null && !user.getBirthday().equals(""))
			u.setBirthday(user.getBirthday());
		if (user.getEducation() != null && !user.getEducation().equals(""))
			u.setEducation(user.getEducation());
		if (user.getAddress() != null && !user.getAddress().equals(""))
			u.setAddress(user.getAddress());
		if (user.getSignature() != null && !user.getSignature().equals(""))
			u.setSignature(user.getSignature());
		if (user.getName() != null && !user.getName().equals(""))
			u.setName(user.getName());
		return u;
	}

	private User isEmpty(User user) {
		if (user.getCustId() == null)
			user.setCustId("");
		if (user.getCustName() == null)
			user.setCustName("");
		if (user.getPhoneNumber() == null)
			user.setPhoneNumber("");
		if (user.getGender() == null)
			user.setGender("");
		if (user.getEmail() == null)
			user.setEmail("");
		if (user.getCustVip() == null)
			user.setCustVip("");
		if (user.getCustQq() == null)
			user.setCustQq("");
		if (user.getLocationX() == null)
			user.setLocationX("");
		if (user.getLocationY() == null)
			user.setLocationY("");
		if (user.getCustStatus() == null)
			user.setCustStatus("");
		if (user.getBirthday() == null)
			user.setBirthday("");
		if (user.getEducation() == null)
			user.setEducation("");
		if (user.getAddress() == null)
			user.setAddress("");
		if (user.getCustId().equals("") && user.getCustName().equals("") && user.getPhoneNumber().equals("")
				&& user.getGender().equals("") && user.getEmail().equals("") && user.getCustVip().equals("")
				&& user.getCustQq().equals("") && user.getLocationX().equals("") && user.getLocationY().equals("")
				&& user.getCustStatus().equals("") && user.getBirthday().equals("") && user.getEducation().equals("")
				&& user.getAddress().equals(""))
			return null;
		else
			return user;
	}

	@Override
	public User checkUser(User user) {
		Connection conn = null;
		try {
			user.setPassword(CipherUtil.generatePassword(user.getPassword()));
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("SELECT * FROM USER WHERE CUSTNAME=? OR PHONENUMBER=?");
			stat.setString(1, user.getCustName());
			stat.setString(2, user.getPhoneNumber());
			ResultSet rst = stat.executeQuery();
			user = new User();
			if (rst.next()) {
				user.setCustId(rst.getString("custId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return user;
	}

}
