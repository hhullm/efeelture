package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ObjectDao;
import util.DBUtil;
import entity.Object;
/**
 * DAO�㣬�����ݿ�����
 */


public class ObjectDaoImp implements ObjectDao {

	@Override
	public void addObject(Object object) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("INSERT INTO OBJECT(OID,OTEMPERATURE,OHUMIDITY,OAIR,OWEEKDAYS,OAMOUNTOFPEOPLE,OWORDS,OMUSIC,OTIME) VALUES(?,?,?,?,?,?,?,?,?)");
			stat.setString(1, object.getId());
			stat.setString(2, object.getTemperature());
			stat.setString(3, object.getHumidity());
			stat.setString(4, object.getAir());
			stat.setLong(5, object.getWeekday());
			stat.setLong(6, object.getPeoplenumber());
			stat.setString(7, object.getWord());
			stat.setString(8, object.getMusic());
			stat.setString(9, object.getTime());

			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}



	@Override
	public void deleteObject(Object object) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("DELETE * FROM OBJECT WHERE OID=?");
			stat.setString(1, object.getId());
			ResultSet rst = stat.executeQuery();
			object = new Object();
			if (rst.next()) {
				object.setId(rst.getString("Oid"));
				object.setTemperature(rst.getString("Otemperature"));
				object.setHumidity(rst.getString("Ohumidity"));
				object.setAir(rst.getString("Oair"));
				object.setWeekday(rst.getInt("Oweekdays"));
				object.setPeoplenumber(rst.getInt("Oamountofpeople"));
				object.setWord(rst.getString("Owords"));
				object.setMusic(rst.getString("Omusic"));
				object.setTime(rst.getString("Otime"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return;
		
	}



	@Override
	public void modifyObject(Object object) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("UPDATE OBJECT SET OID=?,OTEMPERATURE=?,OHUMIDITY=?,OAIR=?,OWEEKDAYS=?,OAMOUNTOFPEOPLE=?,OWORDS=?,OMUSIC=?,OTIME=?");
			stat.setString(1, object.getId());
			stat.setString(2, object.getTemperature());
			stat.setString(3, object.getHumidity());
			stat.setString(4, object.getAir());
			stat.setLong(5, object.getWeekday());
			stat.setLong(6, object.getPeoplenumber());
			stat.setString(7, object.getWord());
			stat.setString(8, object.getMusic());
			stat.setString(9, object.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}



	@Override
	public List<Object> selectObject(Object object) {
		Connection conn = null;
		List<Object> objectList = new ArrayList<Object>();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM OBJECT WHERE 1=1 OR OID=? ";
			if (object.getId() != null)
				sql = "SELECT * FROM OBJECT WHERE OID=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, object.getId());
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				object.setId(rst.getString("Oid"));
				object.setTemperature(rst.getString("Otemperature"));
				object.setHumidity(rst.getString("Ohumidity"));
				object.setAir(rst.getString("Oair"));
				object.setWeekday(rst.getInt("Oweekdays"));
				object.setPeoplenumber(rst.getInt("Oamountofpeople"));
				object.setWord(rst.getString("Owords"));
				object.setMusic(rst.getString("Omusic"));
				object.setTime(rst.getString("Otime"));


				objectList.add(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return objectList;
	
	}
}
