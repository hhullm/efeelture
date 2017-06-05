package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.TalkDao;
import util.DBUtil;
/**
 * DAO层，与数据库连接
 */
import entity.Talk;

public class TalkDaoImp implements TalkDao {

	@Override
	public void addTalk(Talk talk) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("INSERT INTO TALK(TID,TFIRSTID,TSECONDID,TTYPE,TCONTENT) VALUES(?,?,?,?,?)");
			stat.setString(1, talk.getTid());
			stat.setString(2, talk.getTfirstid());
			stat.setString(3, talk.getTsecondid());
			stat.setLong(4, talk.getTtype());
			stat.setString(5, talk.getTcontent());

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
					.prepareStatement("DELETE * FROM TALK WHERE TID=?");
			stat.setString(1, talk.getTid());
			ResultSet rst = stat.executeQuery();
			talk = new Talk();
			if (rst.next()) {
				talk.setTid(rst.getString("tid"));
				talk.setTfirstid(rst.getString("tFirstid"));
				talk.setTsecondid(rst.getString("tSecondid"));
				talk.setTtype(rst.getInt("tType"));
				talk.setTcontent(rst.getString("uStatus"));

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
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("UPDATE TALK SET TID=?,TFIRSTID=?,TSECONDID=?,TTYPE=?,TCONTENT=?");
			stat.setString(1, talk.getTid());
			stat.setString(2, talk.getTfirstid());
			stat.setString(3, talk.getTsecondid());
			stat.setLong(4, talk.getTtype());
			stat.setString(5, talk.getTcontent());

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
			String sql = "SELECT * FROM TALK WHERE 1=1 OR TID=? ";
			if (talk.getTid() != null)
				sql = "SELECT * FROM TALK WHERE TID=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, talk.getTid());
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				talk = new Talk();
				talk.setTid(rst.getString("tid"));
				talk.setTfirstid(rst.getString("tFirstid"));
				talk.setTsecondid(rst.getString("tSecondid"));
				talk.setTtype(rst.getInt("tType"));
				talk.setTcontent(rst.getString("uStatus"));

				talkList.add(talk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return talkList;
		
	}
}
