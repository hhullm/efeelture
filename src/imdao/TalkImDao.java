package imdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import daoimpl.TalkDaoImpl;
import entity.Talk;
import entity.TranObject;
import entity.User;
import util.DBUtil;
import util.ResultUtil;
import util.TranObjectType;

public class TalkImDao {

	private static HashMap<String, String> idResult = new HashMap<String, String>();
	private static HashMap<String, String> resultId = new HashMap<String, String>();
	private static HashMap<String, TranObjectType> idTrantype = new HashMap<String, TranObjectType>();
	private static HashMap<TranObjectType, String> trantypeId = new HashMap<TranObjectType, String>();

	static {
		// 为Result枚举添加映射
		idResult.put("0", null);
		resultId.put(null, "0");
		idResult.put("1", ResultUtil.getResult("1119"));
		resultId.put(ResultUtil.getResult("1119"), "1");
		idResult.put("2", ResultUtil.getResult("1118"));
		resultId.put(ResultUtil.getResult("1118"), "2");
		idResult.put("3", ResultUtil.getResult("1117"));
		resultId.put(ResultUtil.getResult("1117"), "3");
		// 为TranObjectType枚举添加映射
		idTrantype.put("0", null);
		trantypeId.put(null, "0");
		idTrantype.put("1", TranObjectType.FRIEND_REQUEST);
		trantypeId.put(TranObjectType.FRIEND_REQUEST, "1");
		idTrantype.put("2", TranObjectType.MESSAGE);
		trantypeId.put(TranObjectType.MESSAGE, "2");
	}

	private TalkImDao() {

	}

	public static void insertSaveMsg(String firstid, TranObject tran) {

		String ttype = Talk.RECEIVE;

		String msg = "";
		Talk talk = new Talk();
		talk.setFirstid(firstid);
		talk.setSecondid(tran.getReceiveId());

		if (tran.getTranType() == TranObjectType.MESSAGE) {
			Talk chat = (Talk) tran.getObject();
			msg = chat.getContent();
			ttype = chat.getTtype();
			talk.setTtime(chat.getTtime());
		} else
			talk.setTtime(tran.getSendTime());

		talk.setContent(msg);
		talk.setTrantype(trantypeId.get(tran.getTranType()));
		talk.setResulttype(resultId.get(tran.getResult()));
		talk.setSendname(tran.getSendName());
		talk.setTtype(ttype);
		TalkDaoImpl tdi = new TalkDaoImpl();
		tdi.addTalk(talk);
	}

	/**
	 * 删除保存的离线信息
	 */
	public static void deleteSaveMsg(String getid) {

		TalkDaoImpl tdi = new TalkDaoImpl();
		Talk talk = new Talk();
		talk.setSecondid(getid);
		tdi.deleteTalk(talk);
	}

	/**
	 * 查询所有的离线消息
	 * 
	 */
	public static ArrayList<TranObject> selectMsg(String id) {
		ArrayList<TranObject> msgList = new ArrayList<TranObject>();
		String sql1 = "select * from db_talk where secondid=?";
		Connection con;
		try {
			con = DBUtil.getConnection();

			PreparedStatement ps;
			ResultSet rs;
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					TranObject tran = new TranObject();
					tran.setSendId(rs.getString("firstid"));
					tran.setTranType(idTrantype.get(rs.getString("trantype")));
					tran.setSendName(rs.getString("sendname"));
					tran.setResult(idResult.get(rs.getString("resulttype")));
					if (idTrantype.get(rs.getString("trantype")).equals(TranObjectType.MESSAGE)) {
						Talk chatEntity = new Talk();
						chatEntity.setContent(rs.getString("content"));
						chatEntity.setTtype(rs.getString("ttype"));
						chatEntity.setFirstid(tran.getSendId());
						chatEntity.setSecondid(tran.getReceiveId());
						chatEntity.setTtime(rs.getString("ttime"));
						tran.setObject(chatEntity);
					} else if (rs.getString("resulttype").equals("1119")) {
						ArrayList<User> list = UserImDao.selectFriendByAccountOrID(tran.getSendId());
						tran.setObject(list.get(0));
						tran.setSendTime(rs.getString("ttime"));
					} else {
						tran.setSendTime(rs.getString("ttime"));
					}
					msgList.add(tran);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return msgList;

	}
}
