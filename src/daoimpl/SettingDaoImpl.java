package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.LikeDao;
import dao.SettingDao;
import entity.Like;
import entity.Setting;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;

public class SettingDaoImpl implements SettingDao{

	@Override
	public void addSetting(Setting setting) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			setting.setId(PKUtil.getRandomPk());
			setting.setStime(DateUtil.getDate());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into db_setting(id,uid,stime,topbutton,personbutton) VALUES(?,?,?,?,?)");
			stat.setString(1, setting.getId());
			stat.setString(2, setting.getUid());
			stat.setString(3, setting.getStime());
			stat.setString(4, setting.getTopbutton());
			stat.setString(5, setting.getPersonbutton());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void deleteSetting(Setting setting) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("delete from db_setting where id=?");
			stat.setString(1, setting.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void modifySetting(Setting setting) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			setting = getSetting(setting,setting.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update db_setting set uid=?,stime=?,topbutton=?,personbutton=? where id=?");
			stat.setString(1, setting.getUid());
			stat.setString(2, setting.getStime());
			stat.setString(3, setting.getTopbutton());
			stat.setString(4, setting.getPersonbutton());
			stat.setString(5, setting.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	private Setting getSetting(Setting setting, String id) {
		// TODO Auto-generated method stub
		Setting l = new Setting();
		l.setId(id);
		l = selectSetting(l).get(0);
		if (setting.getId() != null && !setting.getId().equals(""))
			l.setId(setting.getId());
		if (setting.getUid() != null && !setting.getUid().equals(""))
			l.setUid(setting.getUid());
		if (setting.getStime() != null && !setting.getStime().equals(""))
			l.setStime(setting.getStime());
		if (setting.getTopbutton() != null && !setting.getTopbutton().equals(""))
			l.setTopbutton(setting.getTopbutton());
		if (setting.getPersonbutton() != null && !setting.getPersonbutton().equals(""))
			l.setPersonbutton(setting.getPersonbutton());
		return l;
	}

	@Override
	public List<Setting> selectSetting(Setting setting) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Setting> settingList = new ArrayList<Setting>();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = null;
			String sql = getSql(setting);
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				setting = new Setting();
				setting.setId(rst.getString("id"));
				setting.setUid(rst.getString("uid"));
				setting.setStime(rst.getString("stime"));
				setting.setTopbutton(rst.getString("topbutton"));
				setting.setPersonbutton(rst.getString("personbutton"));
				settingList.add(setting);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return settingList;
	}

	private String getSql(Setting setting) {
		// TODO Auto-generated method stub
		String sql = "select * from db_setting";
		if (setting != null) {
			sql += " WHERE 1=1 ";
			if (setting.getId() != null && !setting.getId().equals(""))
				sql += " and id='" + setting.getId()+"'";
			if (setting.getUid() != null && !setting.getUid().equals(""))
				sql += " and uid='" + setting.getUid()+"'";
			if (setting.getStime() != null && !setting.getStime().equals(""))
				sql += " and uid='" + setting.getStime()+"'";
			if (setting.getTopbutton()!= null && !setting.getTopbutton().equals(""))
				sql += " and topbutton='" + setting.getTopbutton()+"'";
			if (setting.getPersonbutton()!= null && !setting.getPersonbutton().equals(""))
				sql += " and personbutton='" + setting.getPersonbutton()+"'";
			
		}
		sql += " order by ltime desc";

		return sql;
	}

}
