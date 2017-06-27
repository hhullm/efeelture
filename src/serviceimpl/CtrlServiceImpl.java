package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

import daoimpl.CtrlDaoImpl;
import entity.Ctrl;
import service.CtrlService;
import util.HttpUtil;

public class CtrlServiceImpl implements CtrlService {

	/**
	 * save db
	 * 1002
	 */

	public String saveCtrl(Ctrl ctrl) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {

			String hid = ctrl.getHid();
			String uid = ctrl.getUid();
			String uipaddress = ctrl.getUipaddress();
			String hname = ctrl.getHname();
			String hipaddress = ctrl.getHipaddress();
			String clevel = ctrl.getClevel();
			if (hid == null || hid.equals("") || uid == null || uid.equals("") || uipaddress == null
					|| uipaddress.equals("") || hname == null || hname.equals("") || hipaddress == null
					|| hipaddress.equals("") || clevel == null || clevel.equals(""))
				m.put("resultCode", "121");// miss data
			else {
				CtrlDaoImpl daoimpl = new CtrlDaoImpl();
				daoimpl.addCtrl(ctrl);
				String resp = HttpUtil.sendPost(HttpUtil.getUrl(hipaddress, hname, clevel), "");
				return resp;
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "120");// savectrl failed
		}
		return j.toJson(m);
	};

	/**
	 * select ctrl
	 * 1003
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
				m.put("resultCode", "131");// have no ctrl
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "130");// selectctrl failed
		}
		return j.toJson(m);
	}
}
