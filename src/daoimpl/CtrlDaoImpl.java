package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.CtrlDao;
import entity.Ctrl;
import util.DBUtil;
import util.DateUtil;
import util.PKUtil;

public class CtrlDaoImpl implements CtrlDao{

	@Override
	public void addCtrl(Ctrl ctrl) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			ctrl.setId(PKUtil.getRandomPk());
			ctrl.setCtime(DateUtil.getDate());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into db_ctrl(id,uid,hid,uname,hname,uipaddress,ctime,cstatus,content) VALUES(?,?,?,?,?,?,?,?,?)");
			stat.setString(1, ctrl.getId());
			stat.setString(2, ctrl.getUid());
			stat.setString(3, ctrl.getHid());
			stat.setString(4, ctrl.getUname());
			stat.setString(5, ctrl.getHname());
			stat.setString(6, ctrl.getUipaddress());
			stat.setString(7, ctrl.getCtime());
			stat.setString(8, ctrl.getCstatus());
			stat.setString(9, ctrl.getContent());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteCtrl(Ctrl ctrl) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement("delete from db_ctrl where id=?");
			stat.setString(1, ctrl.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void modifyCtrl(Ctrl ctrl) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			ctrl = getCtrl(ctrl,ctrl.getId());
			conn = DBUtil.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("update db_ctrl set uid=?,hid=?,uname=?,hname=?,uipaddress=?,ctime=?,cstatus=?,content=? where id=?");
			stat.setString(1, ctrl.getUid());
			stat.setString(2, ctrl.getHid());
			stat.setString(3, ctrl.getUname());
			stat.setString(4, ctrl.getHname());
			stat.setString(5, ctrl.getUipaddress());
			stat.setString(6, ctrl.getCtime());
			stat.setString(7, ctrl.getCstatus());
			stat.setString(8, ctrl.getContent());
			stat.setString(9, ctrl.getId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		
	}

	private Ctrl getCtrl(Ctrl ctrl, String id) {
		// TODO Auto-generated method stub
		Ctrl c = new Ctrl();
		c.setId(id);
		c = selectCtrl(c).get(0);
		if (ctrl.getUid() != null && !ctrl.getUid().equals(""))
			c.setUid(ctrl.getUid());
		if (ctrl.getHid() != null && !ctrl.getHid().equals(""))
			c.setHid(ctrl.getHid());
		if (ctrl.getUname() != null && !ctrl.getUname().equals(""))
			c.setUname(ctrl.getUname());
		if (ctrl.getHname() != null && !ctrl.getHname().equals(""))
			c.setHname(ctrl.getHname());
		if (ctrl.getUipaddress() != null && !ctrl.getUipaddress().equals(""))
			c.setUipaddress(ctrl.getUipaddress());
		if (ctrl.getCtime() != null && !ctrl.getCtime().equals(""))
			c.setCtime(ctrl.getCtime());
		if (ctrl.getCstatus() != null && !ctrl.getCstatus().equals(""))
			c.setCstatus(ctrl.getCstatus());
		if (ctrl.getContent() != null && !ctrl.getContent().equals(""))
			c.setContent(ctrl.getContent());
		
		return c;
	}

	@Override
	public List<Ctrl> selectCtrl(Ctrl ctrl) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		List<Ctrl> ctrlList = new ArrayList<Ctrl>();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat = null;
			String sql = getSql(ctrl);
			stat = conn.prepareStatement(sql);
			ResultSet rst = stat.executeQuery();
			while (rst.next()) {
				ctrl = new Ctrl();
				ctrl.setId(rst.getString("id"));
				ctrl.setUid(rst.getString("uid"));
				ctrl.setHid(rst.getString("hid"));
				ctrl.setUname(rst.getString("uname"));
				ctrl.setHname(rst.getString("hname"));
				ctrl.setUipaddress(rst.getString("uipaddress"));
				ctrl.setCtime(rst.getString("ctime"));
				ctrl.setCstatus(rst.getString("cstatus"));
				ctrl.setContent(rst.getString("content"));
				ctrlList.add(ctrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return ctrlList;
	}

	private String getSql(Ctrl ctrl) {
		// TODO Auto-generated method stub
		
		String sql = "select * from db_ctrl";
		if (ctrl != null) {
			sql += " WHERE 1=1 ";
			if (ctrl.getId() != null && !ctrl.getId().equals(""))
				sql += " and id=" + ctrl.getId();
			if (ctrl.getUid() != null && !ctrl.getUid().equals(""))
				sql += " and uid=" + ctrl.getUid();
			if (ctrl.getHid() != null && !ctrl.getHid().equals(""))
				sql += " and hid=" + ctrl.getHid();
			if (ctrl.getUname() != null && !ctrl.getUname().equals(""))
				sql += " and uname=" + ctrl.getUname();
			if (ctrl.getHname() != null && !ctrl.getHname().equals(""))
				sql += " and hname=" + ctrl.getHname();
			if (ctrl.getUipaddress() != null && !ctrl.getUipaddress().equals(""))
				sql += " and uipaddress=" + ctrl.getUipaddress();
			if (ctrl.getCtime() != null && !ctrl.getCtime().equals(""))
				sql += " and ctime=" + ctrl.getCtime();
			if (ctrl.getCstatus() != null && !ctrl.getCstatus().equals(""))
				sql += " and cstatus=" + ctrl.getCstatus();
			if (ctrl.getContent() != null && !ctrl.getContent().equals(""))
				sql += " and content=" + ctrl.getContent();
			
		}

		return sql;
	}

}
