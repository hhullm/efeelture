package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.MessageDao;
import entity.Message;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;

public class MessageDaoImpl implements MessageDao {

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			message.setId(PKUtil.getRandomPk());
			message.setMtime(DateUtil.getDate());
			// message.setMstatus("1");
			// message.setLikenumber("0");
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"insert into db_message(id,content,picture,address,mstatus,permission,likenumber,uname,uid,mtype,mtime,jword,jpicturecolor,jpicturenumber,jmusic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stat.setString(1, message.getId());
			stat.setString(2, message.getContent());
			stat.setString(3, message.getPicture());
			stat.setString(4, message.getAddress());
			stat.setString(5, message.getMstatus());
			stat.setString(6, message.getPermission());
			stat.setString(7, message.getLikenumber());
			stat.setString(8, message.getUname());
			stat.setString(9, message.getUid());
			stat.setString(10, message.getMtype());
			stat.setString(11, message.getMtime());
			stat.setString(12, message.getJword());
			stat.setString(13, message.getJpicturecolor());
			stat.setString(14, message.getJpicturenumber());
			stat.setString(15, message.getJmusic());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("delete from db_message where id=?");
			stat.setString(1, message.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

	@Override
	public void modifyMessage(Message message) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			message = getMessage(message, message.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"update db_message set content=?,picture=?,address=?,mstatus=?,permission=?,likenumber=?,uname=?,uid=?,mtype=?,mtime=?,jword=?,jpicturecolor=?,jpicturenumber=?,jmusic=? where id=?");
			stat.setString(1, message.getContent());
			stat.setString(2, message.getPicture());
			stat.setString(3, message.getAddress());
			stat.setString(4, message.getMstatus());
			stat.setString(5, message.getPermission());
			stat.setString(6, message.getLikenumber());
			stat.setString(7, message.getUname());
			stat.setString(8, message.getUid());
			stat.setString(9, message.getMtype());
			stat.setString(10, message.getMtime());
			stat.setString(11, message.getJword());
			stat.setString(12, message.getJpicturecolor());
			stat.setString(13, message.getJpicturenumber());
			stat.setString(14, message.getJmusic());
			stat.setString(15, message.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

	private Message getMessage(Message message, String id) {
		// TODO Auto-generated method stub
		Message m = new Message();
		m.setId(id);
		m = selectMessage(m).get(0);
		if (message.getId() != null && !message.getId().equals(""))
			m.setId(message.getId());
		if (message.getContent() != null && !message.getContent().equals(""))
			m.setContent(message.getContent());
		if (message.getPicture() != null && !message.getPicture().equals(""))
			m.setPicture(message.getPicture());
		if (message.getAddress() != null && !message.getAddress().equals(""))
			m.setAddress(message.getAddress());
		if (message.getMstatus() != null && !message.getMstatus().equals(""))
			m.setMstatus(message.getMstatus());
		if (message.getPermission() != null && !message.getPermission().equals(""))
			m.setPermission(message.getPermission());
		if (message.getLikenumber() != null && !message.getLikenumber().equals(""))
			m.setLikenumber(message.getLikenumber());
		if (message.getUname() != null && !message.getUname().equals(""))
			m.setUname(message.getUname());
		if (message.getUid() != null && !message.getUid().equals(""))
			m.setUid(message.getUid());
		if (message.getMtype() != null && !message.getMtype().equals(""))
			m.setMtype(message.getMtype());
		if (message.getMtime() != null && !message.getMtime().equals(""))
			m.setMtime(message.getMtime());
		if (message.getJword() != null && !message.getJword().equals(""))
			m.setJword(message.getJword());
		if (message.getJpicturecolor() != null && !message.getJpicturecolor().equals(""))
			m.setJpicturecolor(message.getJpicturecolor());
		if (message.getJpicturenumber() != null && !message.getJpicturenumber().equals(""))
			m.setJpicturenumber(message.getJpicturenumber());
		if (message.getJmusic() != null && !message.getJmusic().equals(""))
			m.setJmusic(message.getJmusic());
		return m;
	}

	@Override
	public List<Message> selectMessage(Message message) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			// message.setMstatus("1");
			conn = DBUtil.getConnection();
			PreparedStatement stat = null;
			String sql = getSql(message);
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				message = new Message();
				message.setId(rst.getString("id"));
				message.setContent(rst.getString("content"));
				message.setPicture(rst.getString("picture"));
				message.setAddress(rst.getString("address"));
				message.setMstatus(rst.getString("mstatus"));
				message.setPermission(rst.getString("permission"));
				message.setLikenumber(rst.getString("likenumber"));
				message.setUname(rst.getString("uname"));
				message.setUid(rst.getString("uid"));
				message.setMtype(rst.getString("mtype"));
				message.setMtime(rst.getString("mtime"));
				message.setJword(rst.getString("jword"));
				message.setJpicturecolor(rst.getString("jpicturecolor"));
				message.setJpicturenumber(rst.getString("jpicturenumber"));
				message.setJmusic(rst.getString("jmusic"));
				messageList.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return messageList;
	}

	private String getSql(Message message) {
		// TODO Auto-generated method stub
		String sql = "select * from db_message";
		if (message != null) {
			sql += " WHERE 1=1 ";
			if (message.getId() != null && !message.getId().equals(""))
				sql += " and id='" + message.getId() + "'";
			if (message.getContent() != null && !message.getContent().equals(""))
				sql += " and content='" + message.getContent() + "'";
			if (message.getPicture() != null && !message.getPicture().equals(""))
				sql += " and picture='" + message.getPicture() + "'";
			if (message.getAddress() != null && !message.getAddress().equals(""))
				sql += " and address='" + message.getAddress() + "'";
			if (message.getMstatus() != null && !message.getMstatus().equals(""))
				sql += " and mstatus='" + message.getMstatus() + "'";
			if (message.getPermission() != null && !message.getPermission().equals(""))
				sql += " and permission='" + message.getPermission() + "'";
			if (message.getLikenumber() != null && !message.getLikenumber().equals(""))
				sql += " and likenumber='" + message.getLikenumber() + "'";
			if (message.getUname() != null && !message.getUname().equals(""))
				sql += " and uname='" + message.getUname() + "'";
			if (message.getUid() != null && !message.getUid().equals(""))
				sql += " and uid='" + message.getUid() + "'";
			if (message.getMtype() != null && !message.getMtype().equals(""))
				sql += " and mtype='" + message.getMtype() + "'";
			if (message.getMtime() != null && !message.getMtime().equals(""))
				sql += " and mtime='" + message.getMtime() + "'";
			if (message.getJword() != null && !message.getJword().equals(""))
				sql += " and jword='" + message.getJword() + "'";
			if (message.getJpicturecolor() != null && !message.getJpicturecolor().equals(""))
				sql += " and jpicturecolor='" + message.getJpicturecolor() + "'";
			if (message.getJpicturenumber() != null && !message.getJpicturenumber().equals(""))
				sql += " and jpicturenumber='" + message.getJpicturenumber() + "'";
			if (message.getJmusic() != null && !message.getJmusic().equals(""))
				sql += " and jmusic='" + message.getJmusic() + "'";

		}
		sql += " order by mtime desc";

		return sql;
	}

	public List<Message> selectFriendMessage(Message message) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			// message.setMstatus("1");
			String uid = message.getUid();
			conn = DBUtil.getConnection();
			PreparedStatement stat = null;
			String sql = "select * from db_message where mstatus='1' and uid=(select secondid from db_friend where db_friend.firstid="
					+ uid + ")";
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				message = new Message();
				message.setId(rst.getString("id"));
				message.setContent(rst.getString("content"));
				message.setPicture(rst.getString("picture"));
				message.setAddress(rst.getString("address"));
				message.setMstatus(rst.getString("mstatus"));
				message.setPermission(rst.getString("permission"));
				message.setLikenumber(rst.getString("likenumber"));
				message.setUname(rst.getString("uname"));
				message.setUid(rst.getString("uid"));
				message.setMtype(rst.getString("mtype"));
				message.setMtime(rst.getString("mtime"));
				message.setJword(rst.getString("jword"));
				message.setJpicturecolor(rst.getString("jpicturecolor"));
				message.setJpicturenumber(rst.getString("jpicturenumber"));
				message.setJmusic(rst.getString("jmusic"));
				messageList.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return messageList;
	}

}
