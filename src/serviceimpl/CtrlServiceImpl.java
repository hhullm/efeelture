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
				m.put("resultCode", "111");//miss data
			else {
				CtrlDaoImpl daoimpl = new CtrlDaoImpl();
				daoimpl.addCtrl(ctrl);
				m.put("resultCode", "999");//success
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "110");//savectrl failed
		}
		return j.toJson(m);
	};

	/*
	 * to raspberry
	 */
	public String forwardCtrl(Ctrl ctrl) {
		return "";
	}

	/*
	 * select ctrl
	 */
	public String selectCtrl(Ctrl ctrl) {

		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			CtrlDaoImpl daoImpl = new CtrlDaoImpl();
			List<Ctrl> ctrlList = daoImpl.selectCtrl(ctrl);
			if (ctrlList.size() > 0) {
				m.put("ctrlList", ctrlList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "131");//have no ctrl
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "130");//selectctrl failed
		}
		return j.toJson(m);
	}
}
