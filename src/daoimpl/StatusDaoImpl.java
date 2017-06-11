package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.StatusDao;
import entity.Status;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;

public class StatusDaoImpl implements StatusDao{

	@Override
	public void addStatus(Status status) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			status.setId(PKUtil.getRandomPk());
			status.setStime(DateUtil.getDate());
			status.setSstatus("1");
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into db_status(id,uid,sstatus,stime,ipaddress,ipport,uname,address) VALUES(?,?,?,?,?,?,?,?)");
			stat.setString(1, status.getId());
			stat.setString(2, status.getUid());
			stat.setString(3, status.getSstatus());
			stat.setString(4, status.getStime());
			stat.setString(5, status.getIpaddress());
			stat.setString(6, status.getIpport());
			stat.setString(7, status.getUname());
			stat.setString(8, status.getAddress());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteStatus(Status status) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("delete from db_status where id=?");
			stat.setString(1, status.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void modifyStatus(Status status) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			status = getStatus(status,status.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update db_status set uid=?,sstatus=?,stime=?,ipaddress=?,ipport=?,uname=?,address=? where id=?");
			stat.setString(1, status.getUid());
			stat.setString(2, status.getSstatus());
			stat.setString(3, status.getStime());
			stat.setString(4, status.getIpaddress());
			stat.setString(5, status.getIpport());
			stat.setString(6, status.getUname());
			stat.setString(7, status.getAddress());
			stat.setString(8, status.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	private Status getStatus(Status status, String id) {
		// TODO Auto-generated method stub
		Status s = new Status();
		s.setId(id);
		s = selectStatus(s).get(0);
		if (status.getId() != null && !status.getId().equals(""))
			s.setId(status.getId());
		if (status.getUid() != null && !status.getUid().equals(""))
			s.setUid(status.getUid());
		if (status.getSstatus() != null && !status.getSstatus().equals(""))
			s.setSstatus(status.getSstatus());
		if (status.getStime() != null && !status.getStime().equals(""))
			s.setStime(status.getStime());
		if (status.getIpaddress() != null && !status.getIpaddress().equals(""))
			s.setIpaddress(status.getIpaddress());
		if (status.getIpport() != null && !status.getIpport().equals(""))
			s.setIpport(status.getIpport());
		if (status.getUname() != null && !status.getUname().equals(""))
			s.setUname(status.getUname());
		if (status.getAddress() != null && !status.getAddress().equals(""))
			s.setAddress(status.getAddress());
		return s;
	}

	@Override
	public List<Status> selectStatus(Status status) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Status> statusList = new ArrayList<Status>();
		try {
			status.setSstatus("1");
			conn = DBUtil.getConnection();
			PreparedStatement stat = null;
			String sql = getSql(status);
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				status = new Status();
				status.setId(rst.getString("id"));
				status.setUid(rst.getString("uid"));
				status.setSstatus(rst.getString("sstatus"));
				status.setStime(rst.getString("stime"));
				status.setIpaddress(rst.getString("ipaddress"));
				status.setIpport(rst.getString("ipport"));
				status.setUname(rst.getString("uname"));
				status.setAddress(rst.getString("address"));
				statusList.add(status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return statusList;
		
	}






private String getSql(Status status) {
		// TODO Auto-generated method stub
	String sql = "select * from db_status";
	if (status != null) {
		sql += " WHERE 1=1 ";
		if (status.getId() != null && !status.getId().equals(""))
			sql += " and id='" + status.getId()+"'";
		if (status.getUid() != null && !status.getUid().equals(""))
			sql += " and uid='" + status.getUid()+"'";
		if (status.getSstatus() != null && !status.getSstatus().equals(""))
			sql += " and sstatus='" + status.getSstatus()+"'";
		if (status.getStime() != null && !status.getStime().equals(""))
			sql += " and stime='" + status.getStime()+"'";
		if (status.getIpaddress() != null && !status.getIpaddress().equals(""))
			sql += " and ipaddress='" + status.getIpaddress()+"'";
		if (status.getIpport() != null && !status.getIpport().equals(""))
			sql += " and ipport='" + status.getIpport()+"'";
		if (status.getUname() != null && !status.getUname().equals(""))
			sql += " and uname='" + status.getUname()+"'";
		if (status.getAddress() != null && !status.getAddress().equals(""))
			sql += " and address='" + status.getAddress()+"'";
		
		}
	sql += " order by stime desc";

	return sql;
	}


}