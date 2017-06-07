package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.HardwareDao;
import entity.Hardware;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;

public class HardwareDaoImpl implements HardwareDao{

	@Override
	public void addHardware(Hardware hardware) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			hardware.setId(PKUtil.getRandomPk());
			hardware.setHtime(DateUtil.getDate());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into db_hardware(id,uid,hardwareid,htime) VALUES(?,?,?,?)");
			stat.setString(1, hardware.getId());
			stat.setString(2, hardware.getUid());
			stat.setString(3, hardware.getHardwareid());
			stat.setString(4, hardware.getHtime());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteHardware(Hardware hardware) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("delete from db_hardware where id=?");
			stat.setString(1, hardware.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void modifyHardware(Hardware hardware) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			hardware = getHardware(hardware,hardware.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update db_hardware set uid=?,hardwareid=?,htime=? where id=?");
			stat.setString(1, hardware.getUid());
			stat.setString(2, hardware.getHardwareid());
			stat.setString(3, hardware.getHtime());
			stat.setString(4, hardware.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	private Hardware getHardware(Hardware hardware, String id) {
		// TODO Auto-generated method stub
		Hardware h = new Hardware();
		h.setId(id);;
		h = selectHardware(h).get(0);
		if (hardware.getId() != null && !hardware.getId().equals(""))
			h.setId(hardware.getId());
		if (hardware.getUid() != null && !hardware.getUid().equals(""))
			h.setUid(hardware.getUid());
		if (hardware.getHardwareid() != null && !hardware.getHardwareid().equals(""))
			h.setHardwareid(hardware.getHardwareid());
		if (hardware.getHtime() != null && !hardware.getHtime().equals(""))
			h.setHtime(hardware.getHtime());
		return h;
	}

	@Override
	public List<Hardware> selectHardware(Hardware hardware) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Hardware> hardwareList = new ArrayList<Hardware>();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = null;
			String sql = getSql(hardware);
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				hardware = new Hardware();
				hardware.setId(rst.getString("id"));
				hardware.setUid(rst.getString("uid"));
				hardware.setHardwareid(rst.getString("hardwareid"));
				hardware.setHtime(rst.getString("htime"));
				hardwareList.add(hardware);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return hardwareList;
	}

	private String getSql(Hardware hardware) {
		// TODO Auto-generated method stub
		String sql = "select * from db_hardware";
		if (hardware != null) {
			sql += " WHERE 1=1 ";
			if (hardware.getId() != null && !hardware.getId().equals(""))
				sql += " and id=" + hardware.getId();
			if (hardware.getUid() != null && !hardware.getUid().equals(""))
				sql += " and uid=" + hardware.getUid();
			if (hardware.getHardwareid()!= null && !hardware.getHardwareid().equals(""))
				sql += " and hardwareid=" + hardware.getHardwareid();
			if (hardware.getHtime()!= null && !hardware.getHtime().equals(""))
				sql += " and htime=" + hardware.getHtime();
			
		}

		return sql;
	}

}
