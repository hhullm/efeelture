package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.LikeDao;
import entity.Like;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;

public class LikeDaoImpl implements LikeDao{

	@Override
	public void addLike(Like like) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			like.setId(PKUtil.getRandomPk());
			like.setLtime(DateUtil.getDate());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into like(id,uid,messageid,ltime) VALUES(?,?,?,?)");
			stat.setString(1, like.getId());
			stat.setString(2, like.getUid());
			stat.setString(3, like.getMessageid());
			stat.setString(4, like.getLtime());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void deleteLike(Like like) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("delete from like where id=?");
			stat.setString(1, like.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void modifyLike(Like like) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			like = getLike(like,like.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update like set uid=?,messageid=?,ltime=? where id=?");
			stat.setString(1, like.getUid());
			stat.setString(2, like.getMessageid());
			stat.setString(3, like.getLtime());
			stat.setString(4, like.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	private Like getLike(Like like, String id) {
		// TODO Auto-generated method stub
		Like l = new Like();
		l.setId(id);;
		l = selectLike(l).get(0);
		if (like.getId() != null && !like.getId().equals(""))
			l.setId(like.getId());
		if (like.getUid() != null && !like.getUid().equals(""))
			l.setUid(like.getUid());
		if (like.getMessageid() != null && !like.getMessageid().equals(""))
			l.setMessageid(like.getMessageid());
		if (like.getLtime() != null && !like.getLtime().equals(""))
			l.setLtime(like.getLtime());
		return l;
	}

	@Override
	public List<Like> selectLike(Like like) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Like> likeList = new ArrayList<Like>();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = null;
			String sql = getSql(like);
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				like = new Like();
				like.setId(rst.getString("id"));
				like.setUid(rst.getString("uid"));
				like.setMessageid(rst.getString("messageid"));
				like.setLtime(rst.getString("ltime"));
				likeList.add(like);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return likeList;
	}

	private String getSql(Like like) {
		// TODO Auto-generated method stub
		String sql = "select * from like";
		if (like != null) {
			sql += " WHERE 1=1 ";
			if (like.getId() != null && !like.getId().equals(""))
				sql += " and id=" + like.getId();
			if (like.getUid() != null && !like.getUid().equals(""))
				sql += " and uid=" + like.getUid();
			if (like.getMessageid()!= null && !like.getMessageid().equals(""))
				sql += " and messageid=" + like.getMessageid();
			if (like.getLtime()!= null && !like.getLtime().equals(""))
				sql += " and ltime=" + like.getLtime();
			
		}

		return sql;
	}

}
