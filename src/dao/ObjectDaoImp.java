package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ObjectDao;
import util.DBUtil;
import entity.Object;
/**
 * DAO层，与数据库连接
 */


public class ObjectDaoImp implements ObjectDao {

	@Override
	public void addObject(Object object) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("INSERT INTO OBJECT(OID,OTEMPERATURE,OHUMIDITY,OAIR,OWEEKDAYS,OAMOUNTOFPEOPLE,OWORDS,OMUSIC,OTIME) VALUES(?,?,?,?,?,?,?,?,?)");
			stat.setString(1, object.getOid());
			stat.setString(2, object.getOtemperature());
			stat.setString(3, object.getOhumidity());
			stat.setString(4, object.getOair());
			stat.setLong(5, object.getOweekdays());
			stat.setLong(6, object.getOamountofpeople());
			stat.setString(7, object.getOwords());
			stat.setString(8, object.getOmusic());
			stat.setString(9, object.getOtime());

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
			stat.setString(1, object.getOid());
			ResultSet rst = stat.executeQuery();
			object = new Object();
			if (rst.next()) {
				object.setOid(rst.getString("Oid"));
				object.setOtemperature(rst.getString("Otemperature"));
				object.setOhumidity(rst.getString("Ohumidity"));
				object.setOair(rst.getString("Oair"));
				object.setOweekdays(rst.getInt("Oweekdays"));
				object.setOamountofpeople(rst.getInt("Oamountofpeople"));
				object.setOwords(rst.getString("Owords"));
				object.setOmusic(rst.getString("Omusic"));
				object.setOtime(rst.getString("Otime"));

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
			stat.setString(1, object.getOid());
			stat.setString(2, object.getOtemperature());
			stat.setString(3, object.getOhumidity());
			stat.setString(4, object.getOair());
			stat.setLong(5, object.getOweekdays());
			stat.setLong(6, object.getOamountofpeople());
			stat.setString(7, object.getOwords());
			stat.setString(8, object.getOmusic());
			stat.setString(9, object.getOtime());
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
			if (object.getOid() != null)
				sql = "SELECT * FROM OBJECT WHERE OID=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, object.getOid());
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				object.setOid(rst.getString("Oid"));
				object.setOtemperature(rst.getString("Otemperature"));
				object.setOhumidity(rst.getString("Ohumidity"));
				object.setOair(rst.getString("Oair"));
				object.setOweekdays(rst.getInt("Oweekdays"));
				object.setOamountofpeople(rst.getInt("Oamountofpeople"));
				object.setOwords(rst.getString("Owords"));
				object.setOmusic(rst.getString("Omusic"));
				object.setOtime(rst.getString("Otime"));


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
