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
			talk.setTtime(DateUtil.getDate());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into db_talk(id,firstid,secondid,ttype,content,ttime,trantype,resulttype,sendname) VALUES(?,?,?,?,?,?,?,?,?)");
			stat.setString(1, talk.getId());
			stat.setString(2, talk.getFirstid());
			stat.setString(3, talk.getSecondid());
			stat.setString(4, talk.getTtype());
			stat.setString(5, talk.getContent());
			stat.setString(6, talk.getTtime());
			stat.setString(7, talk.getTrantype());
			stat.setString(8, talk.getResulttype());
			stat.setString(9, talk.getSendname());
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
					.prepareStatement("delete from db_talk where id=?");
			stat.setString(1, talk.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void modifyTalk(Talk talk) {
		Connection conn = null;
		try {
			talk = getTalk(talk,talk.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update db_talk set firstid=?,secondid=?,ttype=?,content=?,ttime=?,trantype=?,resulttype=?,sendname=? where id=?");
			stat.setString(1, talk.getFirstid());
			stat.setString(2, talk.getSecondid());
			stat.setString(3, talk.getTtype());
			stat.setString(4, talk.getContent());
			stat.setString(5, talk.getTtime());
			stat.setString(6, talk.getTrantype());
			stat.setString(7, talk.getResulttype());
			stat.setString(8, talk.getSendname());
			stat.setString(9, talk.getId());
			stat.executeUpdate();
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
			PreparedStatement stat = null;
			String sql = getSql(talk);
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				talk = new Talk();
				talk.setId(rst.getString("id"));
				talk.setFirstid(rst.getString("firstid"));
				talk.setSecondid(rst.getString("secondid"));
				talk.setTtype(rst.getString("ttype"));
				talk.setContent(rst.getString("content"));
				talk.setTtime(rst.getString("ttime"));
				talk.setTrantype(rst.getString("trantype"));
				talk.setResulttype(rst.getString("resulttype"));
				talk.setSendname(rst.getString("sendname"));
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
		if (talk.getTtime() != null && !talk.getTtime().equals(""))
			f.setTtime(talk.getTtime());
		if (talk.getTrantype() != null && !talk.getTrantype().equals(""))
			f.setTrantype(talk.getTrantype());
		if (talk.getResulttype() != null && !talk.getResulttype().equals(""))
			f.setResulttype(talk.getResulttype());
		if (talk.getSendname() != null && !talk.getSendname().equals(""))
			f.setSendname(talk.getSendname());
		
		return f;
	}
	
	private String getSql(Talk talk) {
		String sql = "select * from db_talk";
		if (talk != null) {
			sql += " WHERE 1=1 ";
			if (talk.getId() != null && !talk.getId().equals(""))
				sql += " and id='" + talk.getId()+"'";
			if (talk.getFirstid() != null && !talk.getFirstid().equals(""))
				sql += " and firstid='" + talk.getFirstid()+"'";
			if (talk.getSecondid() != null && !talk.getSecondid().equals(""))
				sql += " and secondid='" + talk.getSecondid()+"'";
			if (talk.getTtype() != null && !talk.getTtype().equals(""))
				sql += " and ttype='" + talk.getTtype()+"'";
			if (talk.getContent() != null && !talk.getContent().equals(""))
				sql += " and content='" + talk.getContent()+"'";
			if (talk.getTtime() != null && !talk.getTtime().equals(""))
				sql += " and ttime='" + talk.getTtime()+"'";
			if (talk.getTrantype() != null && !talk.getTrantype().equals(""))
				sql += " and trantype='" + talk.getTrantype()+"'";
			if (talk.getResulttype() != null && !talk.getResulttype().equals(""))
				sql += " and resulttype='" + talk.getResulttype()+"'";
			if (talk.getSendname() != null && !talk.getSendname().equals(""))
				sql += " and sendname='" + talk.getSendname()+"'";
			
		}
		sql += " order by ttime asc";

		return sql;
	}
}
