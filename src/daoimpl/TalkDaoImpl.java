package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.TalkDao;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;
/**
 * DAO�㣬�����ݿ�����
 */
import entity.Talk;

public class TalkDaoImpl implements TalkDao {

	@Override
	public void addTalk(Talk talk) {
		Connection conn = null;
		try {
			talk.setId(PKUtil.getRandomPk());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into db_talk(id,firstid,secondid,ttype,content) VALUES(?,?,?,?,?)");
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
					.prepareStatement("delete * from db_talk where id=?");
			stat.setString(1, talk.getId());
			ResultSet rst = stat.executeQuery();
			talk = new Talk();
			if (rst.next()) {
				talk.setId(rst.getString("id"));
				talk.setFirstid(rst.getString("firstid"));
				talk.setSecondid(rst.getString("secondid"));
				talk.setTtype(rst.getString("ttype"));
				talk.setContent(rst.getString("status"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return;
		
	}

	@Override
	public void modifyTalk(Talk talk) {
		Connection conn = null;
		try {
			talk = getTalk(talk,talk.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update db_talk set id=?,firstid=?,secondid=?,ttype=?,content=?");
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
				talk.setFirstid(rst.getString("firstid"));
				talk.setSecondid(rst.getString("secondid"));
				talk.setTtype(rst.getString("ttype"));
				talk.setContent(rst.getString("content"));

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
		String sql = "select * from db_talk";
		if (talk != null) {
			sql += " WHERE 1=1 ";
			if (talk.getId() != null && !talk.getId().equals(""))
				sql += " and id=" + talk.getId();
			if (talk.getFirstid() != null && !talk.getFirstid().equals(""))
				sql += " and firstid=" + talk.getFirstid();
			if (talk.getSecondid() != null && !talk.getSecondid().equals(""))
				sql += " and secondid=" + talk.getSecondid();
			if (talk.getTtype() != null && !talk.getTtype().equals(""))
				sql += " and ttype=" + talk.getTtype();
			if (talk.getContent() != null && !talk.getContent().equals(""))
				sql += " and content=" + talk.getContent();
			
			
		}

		return sql;
	}
}
