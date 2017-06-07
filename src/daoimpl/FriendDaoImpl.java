package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.FriendDao;
import entity.Friend;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;

public class FriendDaoImpl implements FriendDao{

	@Override
	public void addFriend(Friend friend) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			friend.setId(PKUtil.getRandomPk());
			friend.setFtime(DateUtil.getDate());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into friend(id,firstid,secondid,fstatus,ftime) VALUES(?,?,?,?,?)");
			stat.setString(1, friend.getId());
			stat.setString(2, friend.getFirstid());
			stat.setString(3, friend.getSecondid());
			stat.setString(4, friend.getFstatus());
			stat.setString(5, friend.getFtime());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteFriend(Friend friend) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("delete from friend where id=?");
			stat.setString(1, friend.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void modifyFriend(Friend friend) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			friend = getFriend(friend,friend.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update friend set firstid=?,secondid=?,fstatus=?,ftime=? where id=?");
			stat.setString(1, friend.getFirstid());
			stat.setString(2, friend.getSecondid());
			stat.setString(3, friend.getFstatus());
			stat.setString(4, friend.getFtime());
			stat.setString(5, friend.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	private Friend getFriend(Friend friend, String id) {
		// TODO Auto-generated method stub
		Friend f = new Friend();
		f.setId(id);
		f = selectFriend(f).get(0);
		if (friend.getId() != null && !friend.getId().equals(""))
			f.setId(friend.getId());
		if (friend.getFirstid() != null && !friend.getFirstid().equals(""))
			f.setFirstid(friend.getFirstid());
		if (friend.getSecondid() != null && !friend.getSecondid().equals(""))
			f.setSecondid(friend.getSecondid());
		if (friend.getFstatus() != null && !friend.getFstatus().equals(""))
			f.setFstatus(friend.getFstatus());
		if (friend.getFtime() != null && !friend.getFtime().equals(""))
			f.setFtime(friend.getFtime());

		return f;
	}

	@Override
	public List<Friend> selectFriend(Friend friend) {
		// TODO Auto-generated method stub
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
				friend.setId(rst.getString("id"));
				friend.setFirstid(rst.getString("firstid"));
				friend.setSecondid(rst.getString("secondid"));
				friend.setFstatus(rst.getString("fstatus"));
				friend.setFtime(rst.getString("ftime"));
				friendList.add(friend);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return friendList;
	}

	private String getSql(Friend friend) {
		// TODO Auto-generated method stub
		String sql = "select * from friend";
		if (friend != null) {
			sql += " WHERE 1=1 ";
			if (friend.getId() != null && !friend.getId().equals(""))
				sql += " and id=" + friend.getId();
			if (friend.getFirstid() != null && !friend.getFirstid().equals(""))
				sql += " and firstid=" + friend.getFirstid();
			if (friend.getSecondid()!= null && !friend.getSecondid().equals(""))
				sql += " and secondid=" + friend.getSecondid();
			if (friend.getFstatus()!= null && !friend.getFstatus().equals(""))
				sql += " and fstatus=" + friend.getFstatus();
			if (friend.getFtime()!= null && !friend.getFtime().equals(""))
				sql += " and ftime=" + friend.getFtime();
			
		}

		return sql;
	}

}
