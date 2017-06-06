package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.TalkDao;
import util.DBUtil;
/**
 * DAO�㣬�����ݿ�����
 */
import entity.Talk;

public class TalkDaoImpl implements TalkDao {

	@Override
	public void addTalk(Talk talk) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("INSERT INTO TALK(ID,FIRSTID,SECONDID,TTYPE,CONTENT) VALUES(?,?,?,?,?)");
			stat.setString(1, talk.getId());
			stat.setString(2, talk.getFirstid());
			stat.setString(3, talk.getSecondid());
			stat.setString(4, talk.getTtype());
			stat.setString(5, talk.getContent());

			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}



	@Override
	public void deleteTalk(Talk talk) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("DELETE * FROM TALK WHERE ID=?");
			stat.setString(1, talk.getId());
			ResultSet rst = stat.executeQuery();
			talk = new Talk();
			if (rst.next()) {
				talk.setId(rst.getString("id"));
				talk.setFirstid(rst.getString("Firstid"));
				talk.setSecondid(rst.getString("Secondid"));
				talk.setTtype(rst.getString("tType"));
				talk.setContent(rst.getString("Status"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return;
		
	}

	@Override
	public void updateTalk(Talk talk) {
		Connection conn = null;
		try {
			talk = getTalk(talk,talk.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("UPDATE TALK SET ID=?,FIRSTID=?,SECONDID=?,TTYPE=?,CONTENT=?");
			stat.setString(1, talk.getId());
			stat.setString(2, talk.getFirstid());
			stat.setString(3, talk.getSecondid());
			stat.setString(4, talk.getTtype());
			stat.setString(5, talk.getContent());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public List<Talk> selectTalk(Talk talk) {
		Connection conn = null;
		List<Talk> talkList = new ArrayList<Talk>();
		try {
			conn = DBUtil.getConnection();
			String sql = getSql(talk);
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, talk.getId());
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				talk = new Talk();
				talk.setId(rst.getString("tid"));
				talk.setFirstid(rst.getString("Firstid"));
				talk.setSecondid(rst.getString("Secondid"));
				talk.setTtype(rst.getString("tType"));
				talk.setContent(rst.getString("Status"));

				talkList.add(talk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return talkList;
		
	}
	private Talk getTalk(Talk talk,String Id) {
		Talk f = new Talk();
		f.setId(Id);
		f = selectTalk(f).get(0);
		if (talk.getId() != null && !talk.getId().equals(""))
			f.setId(talk.getId());
		if (talk.getFirstid() != null && !talk.getFirstid().equals(""))
			f.setFirstid(talk.getFirstid());
		if (talk.getSecondid() != null && !talk.getSecondid().equals(""))
			f.setSecondid(talk.getSecondid());
		if (talk.getTtype() != null && !talk.getTtype().equals(""))
			f.setTtype(talk.getTtype());
		if (talk.getContent() != null && !talk.getContent().equals(""))
			f.setContent(talk.getContent());
		
	
		
		
		return f;
	}
	
	private String getSql(Talk talk) {
		String sql = "SELECT * FROM TALK";
		if (talk != null) {
			sql += " WHERE 1=1 ";
			if (talk.getId() != null && !talk.getId().equals(""))
				sql += "AND ID=" + talk.getId();
			if (talk.getFirstid() != null && !talk.getFirstid().equals(""))
				sql += "AND FIRSTID=" + talk.getFirstid();
			if (talk.getSecondid() != null && !talk.getSecondid().equals(""))
				sql += "AND SECONDID=" + talk.getSecondid();
			if (talk.getTtype() != null && !talk.getTtype().equals(""))
				sql += "AND TTYPE=" + talk.getTtype();
			if (talk.getContent() != null && !talk.getContent().equals(""))
				sql += "AND CONTENT=" + talk.getContent();
			
			
		}

		return sql;
	}
}
