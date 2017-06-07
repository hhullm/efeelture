package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.JectiveDao;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;
import entity.Jective;
/**
 * DAO�㣬�����ݿ�����
 */


public class JectiveDaoImpl implements JectiveDao {

	@Override
	public void addJective(Jective jective) {
		Connection conn = null;
		try {
			jective.setId(PKUtil.getRandomPk());
			jective.setJtime(DateUtil.getDate());	
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into db_jective(id,uid,temperature,humidity,air,weekday,peoplenumber,word,picturecolor,picturenumber,music,jtime) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			stat.setString(1, jective.getId());
			stat.setString(2, jective.getUid());
			stat.setString(3, jective.getTemperature());
			stat.setString(4, jective.getHumidity());
			stat.setString(5, jective.getAir());
			stat.setString(6, jective.getWeekday());
			stat.setString(7, jective.getPeoplenumber());
			stat.setString(8, jective.getWord());
			stat.setString(9, jective.getPicturecolor());
			stat.setString(10, jective.getPicturenumber());
			stat.setString(11, jective.getMusic());
			stat.setString(12, jective.getJtime());
			stat.executeUpdate();

			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}



	@Override
	public void deleteJective(Jective jective) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("delete from db_jective where id=?");
			stat.setString(1, jective.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	
	}



	@Override
	public void modifyJective(Jective jective) {
		Connection conn = null;
		try {
			jective = getJective(jective,jective.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update db_jective set uid=?,temperature=?,humidity=?,air=?,weekday=?,peoplenumber=?,word=?,picturecolor=?,Picturenumber=?,music=?,jtime=? where id=?");
			stat.setString(1, jective.getUid());
			stat.setString(2, jective.getTemperature());
			stat.setString(3, jective.getHumidity());
			stat.setString(4, jective.getAir());
			stat.setString(5, jective.getWeekday());
			stat.setString(6, jective.getPeoplenumber());
			stat.setString(7, jective.getWord());
			stat.setString(8, jective.getPicturecolor());
			stat.setString(9, jective.getPicturenumber());
			stat.setString(10, jective.getMusic());
			stat.setString(11, jective.getJtime());
			stat.setString(12, jective.getId());
			stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}



	@Override
	public List<Jective> selectJective(Jective jective) {
		Connection conn = null;
		List<Jective> jectiveList = new ArrayList<Jective>();
		try {
			conn = DBUtil.getConnection();
			String sql = getSql(jective);
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, jective.getId());
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				jective = new Jective();
				jective.setId(rst.getString("id"));
				jective.setUid(rst.getString("uid"));
				jective.setTemperature(rst.getString("temperature"));
				jective.setHumidity(rst.getString("humidity"));
				jective.setAir(rst.getString("air"));
				jective.setWeekday(rst.getString("weekdays"));
				jective.setPeoplenumber(rst.getString("amountofpeople"));
				jective.setWord(rst.getString("words"));
				jective.setPicturecolor(rst.getString("picturecolor"));
				jective.setPicturenumber(rst.getString("picturenumber"));
				jective.setMusic(rst.getString("music"));
				jective.setJtime(rst.getString("jtime"));
				jectiveList.add(jective);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return jectiveList;
	
	}
	private Jective getJective(Jective jective,String Id) {
		Jective f = new Jective();
		f.setId(Id);
		f = selectJective(f).get(0);
		if (jective.getId() != null && !jective.getId().equals(""))
			f.setId(jective.getId());
		if (jective.getUid() != null && !jective.getUid().equals(""))
			f.setUid(jective.getUid());
		if (jective.getTemperature() != null && !jective.getTemperature().equals(""))
			f.setTemperature(jective.getTemperature());
		if (jective.getHumidity() != null && !jective.getHumidity().equals(""))
			f.setHumidity(jective.getHumidity());
		if (jective.getAir() != null && !jective.getAir().equals(""))
			f.setAir(jective.getAir());
		if (jective.getWeekday() != null && !jective.getWeekday().equals(""))
			f.setWeekday(jective.getWeekday());
		if (jective.getPeoplenumber() != null && !jective.getPeoplenumber().equals(""))
			f.setPeoplenumber(jective.getPeoplenumber());
		if (jective.getWord() != null && !jective.getWord().equals(""))
			f.setWord(jective.getWord());
		if (jective.getPicturecolor() != null && !jective.getPicturecolor().equals(""))
			f.setPicturecolor(jective.getPicturecolor());
		if (jective.getPicturenumber() != null && !jective.getPicturenumber().equals(""))
			f.setPicturenumber(jective.getPicturenumber());
		if (jective.getMusic() != null && !jective.getMusic().equals(""))
			f.setMusic(jective.getMusic());
		if (jective.getJtime() != null && !jective.getJtime().equals(""))
			f.setJtime(jective.getJtime());
	
		
		
		return f;
	}
	
	private String getSql(Jective jective) {
		String sql = "selete * from db_jective";
		if (jective != null) {
			sql += " WHERE 1=1 ";
				
			if (jective.getId() != null && !jective.getId().equals(""))
				sql += " and id=" + jective.getId();
			if (jective.getUid() != null && !jective.getUid().equals(""))
				sql += " and uid=" + jective.getUid();
			if (jective.getTemperature() != null && !jective.getTemperature().equals(""))
				sql += " and temperature=" + jective.getTemperature();
			if (jective.getHumidity() != null && !jective.getHumidity().equals(""))
				sql += " and humidity=" + jective.getHumidity();
			if (jective.getAir() != null && !jective.getAir().equals(""))
				sql += " and air=" + jective.getAir();
			if (jective.getWeekday() != null && !jective.getWeekday().equals(""))
				sql += " and weekday=" + jective.getWeekday();
			if (jective.getPeoplenumber() != null && !jective.getPeoplenumber().equals(""))
				sql += " and eoplenumber=" + jective.getPeoplenumber();
			if (jective.getWord() != null && !jective.getWord().equals(""))
				sql += " and word=" + jective.getWord();
			if (jective.getPicturecolor() != null && !jective.getPicturecolor().equals(""))
				sql += " and picturecolor=" + jective.getPicturecolor();
			if (jective.getPicturenumber() != null && !jective.getPicturenumber().equals(""))
				sql += " and icturenumber=" + jective.getPicturenumber();
			if (jective.getMusic() != null && !jective.getMusic().equals(""))
				sql += " and music=" + jective.getMusic();
			if (jective.getJtime() != null && !jective.getJtime().equals(""))
				sql += " and jtime=" + jective.getJtime();
			
			
		}

		return sql;
	}
}
