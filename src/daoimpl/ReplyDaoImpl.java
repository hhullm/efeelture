package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ReplyDao;
import entity.Reply;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;

public class ReplyDaoImpl implements ReplyDao{

	@Override
	public void addReply(Reply reply) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			reply.setId(PKUtil.getRandomPk());
			reply.setRtime(DateUtil.getDate());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into db_reply(id,messageid,rtime,firstid,secondid,content) VALUES(?,?,?,?,?,?)");
			stat.setString(1, reply.getId());
			stat.setString(2, reply.getMessageid());
			stat.setString(3, reply.getRtime());
			stat.setString(4, reply.getFirstid());
			stat.setString(5, reply.getSecondid());
			stat.setString(6, reply.getContent());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteReply(Reply reply) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("delete from db_reply where id=?");
			stat.setString(1, reply.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void modifyReply(Reply reply) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			reply = getReply(reply,reply.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update db_reply set messageid=?,rtime=?,firstid=?,secondid=?,content=? where id=?");
			stat.setString(1, reply.getMessageid());
			stat.setString(2, reply.getRtime());
			stat.setString(3, reply.getFirstid());
			stat.setString(4, reply.getSecondid());
			stat.setString(5, reply.getContent());
			stat.setString(6, reply.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	private Reply getReply(Reply reply, String id) {
		// TODO Auto-generated method stub
		Reply r = new Reply();
		r.setId(id);
		r = selectReply(r).get(0);
		if (reply.getId() != null && !reply.getId().equals(""))
			r.setId(reply.getId());
		if (reply.getMessageid() != null && !reply.getMessageid().equals(""))
			r.setMessageid(reply.getMessageid());
		if (reply.getRtime() != null && !reply.getRtime().equals(""))
			r.setRtime(reply.getRtime());
		if (reply.getFirstid() != null && !reply.getFirstid().equals(""))
			r.setFirstid(reply.getFirstid());
		if (reply.getSecondid() != null && !reply.getSecondid().equals(""))
			r.setSecondid(reply.getSecondid());
		if (reply.getContent() != null && !reply.getContent().equals(""))
			r.setContent(reply.getContent());
		return r;
	}

	@Override
	public List<Reply> selectReply(Reply reply) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Reply> replyList = new ArrayList<Reply>();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = null;
			String sql = getSql(reply);
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				reply = new Reply();
				reply.setId(rst.getString("id"));
				reply.setMessageid(rst.getString("messageid"));
				reply.setRtime(rst.getString("rtime"));
				reply.setFirstid(rst.getString("firstid"));
				reply.setSecondid(rst.getString("secondid"));
				reply.setContent(rst.getString("content"));
				replyList.add(reply);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return replyList;
	}

	private String getSql(Reply reply) {
		// TODO Auto-generated method stub
		String sql = "select * from db_reply";
		if (reply != null) {
			sql += " WHERE 1=1 ";
			if (reply.getId() != null && !reply.getId().equals(""))
				sql += " and id='" + reply.getId()+"'";
			if (reply.getMessageid() != null && !reply.getMessageid().equals(""))
				sql += " and messageid='" + reply.getMessageid()+"'";
			if (reply.getRtime()!= null && !reply.getRtime().equals(""))
				sql += " and rtime='" + reply.getRtime()+"'";
			if (reply.getFirstid() != null && !reply.getFirstid().equals(""))
				sql += " and firstid='" + reply.getFirstid()+"'";
			if (reply.getSecondid() != null && !reply.getSecondid().equals(""))
				sql += " and secondid='" + reply.getSecondid()+"'";
			if (reply.getContent() != null && !reply.getContent().equals(""))
				sql += " and content='" + reply.getContent()+"'";
			
		}

		return sql;
	}

}
