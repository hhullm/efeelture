package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.DBUtil;
import utils.DateUtil;
import entity.Activity;
import entity.Friend;

public class FriendDaoImpl implements FriendDao {

	@Override
	public void addFriend(Friend friend) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("INSERT INTO FRIEND(CUSTID,FRIENDNAME,FRIENDTYPE,MODIFYFRIENDTIME,FRIENDCUSTID,FRIENDTYPESELF) VALUES(?,?,?,?,?,?)");
			stat.setString(1, friend.getCustId());
			stat.setString(2, friend.getFriendName());
			stat.setString(3, friend.getFriendType());
			stat.setString(4, friend.getModifyFriendTime());
			stat.setString(5, friend.getFriendCustId());
			stat.setString(6, friend.getFriendTypeSelf());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void deleteFriend(Friend friend) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("DELETE FROM FRIEND WHERE FRIENDCUSTID=? AND CUSTID=?");
			stat.setString(1, friend.getFriendCustId());
			stat.setString(2, friend.getCustId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void updateFriend(Friend friend) {
		Connection conn = null;
		try {
			friend = getFriend(friend,friend.getCustId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("UPDATE FRIEND SET FRIENDNAME=?,FRIENDTYPE=?,MODIFYFRIENDTIME=?,FRIENDTYPESELF=? WHERE FRIENDCUSTID=? AND CUSTID=?");
			stat.setString(1, friend.getFriendName());
			stat.setString(2, friend.getFriendType());
			stat.setString(3, friend.getModifyFriendTime());
			stat.setString(4, friend.getFriendTypeSelf());
			stat.setString(5, friend.getFriendCustId());
			stat.setString(6, friend.getCustId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public List<Friend> selectFriend(Friend friend) {
		Connection conn = null;
		List<Friend> friendList = new ArrayList<Friend>();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = null;
			String sql = getSql(friend);
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				friend = new Friend();
				friend.setCustId(rst.getString("custId"));
				friend.setFriendName(rst.getString("friendName"));
				friend.setModifyFriendTime(rst.getString("modifyFriendTime"));
				friend.setFriendCustId(rst.getString("friendCustId"));
				friend.setFriendType(rst.getString("friendType"));
				friend.setFriendTypeSelf(rst.getString("friendTypeSelf"));
				friendList.add(friend);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return friendList;
	}

	private Friend getFriend(Friend friend,String custId) {
		Friend f = new Friend();
		f.setCustId(custId);
		f = selectFriend(f).get(0);
		if (friend.getFriendName() != null && !friend.getFriendName().equals(""))
			f.setFriendName(friend.getFriendName());
		if (friend.getFriendType() != null && !friend.getFriendType().equals(""))
			f.setFriendType(friend.getFriendType());
		if (friend.getFriendTypeSelf() != null && !friend.getFriendTypeSelf().equals(""))
			f.setFriendTypeSelf(friend.getFriendTypeSelf());
		f.setModifyFriendTime(DateUtil.getDate());
		return f;
	}
	
	private String getSql(Friend friend) {
		String sql = "SELECT * FROM FRIEND";
		if (friend != null) {
			sql += " WHERE 1=1 ";
			if (friend.getCustId() != null && !friend.getCustId().equals(""))
				sql += "AND CUSTID=" + friend.getCustId();
			if (friend.getFriendCustId() != null && !friend.getFriendCustId().equals(""))
				sql += "AND FRIENDCUSTID=" + friend.getFriendCustId();
			if (friend.getFriendType()!= null && !friend.getFriendType().equals(""))
				sql += "AND FRIENDTYPE=" + friend.getFriendType();
			
		}

		return sql;
	}
}
