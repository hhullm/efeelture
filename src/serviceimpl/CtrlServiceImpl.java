package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.CtrlDaoImpl;
import entity.Ctrl;
import service.CtrlService;

public class CtrlServiceImpl implements CtrlService {

	/*
	 * save db
	 */

	public String saveCtrl(Ctrl ctrl) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			
			String hid = ctrl.getHid();
			String uid = ctrl.getUid();
			String uipaddress = ctrl.getUipaddress();
			if (hid == null || hid.equals("") || uid == null || uid.equals("") || uipaddress == null
					|| uipaddress.equals(""))
				m.put("resultCode", "111");// 缺少数据
			else {
				CtrlDaoImpl daoimpl = new CtrlDaoImpl();
				daoimpl.addCtrl(ctrl);
				m.put("resultCode", "001");
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "110");// 注册失败
		}
		return j.toJson(m);
	};

	/*
	 * to raspberry
	 */
	public String forwardCtrl(Ctrl ctrl) {
		return null;
	}

	/*
	 * select ctrl
	 */
	public List<Ctrl> selectCtrl(Ctrl ctrl) {
		return null;
	}
}
