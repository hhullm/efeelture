package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.StatusDaoImpl;
import entity.Status;
import service.StatusService;

public class StatusServiceImpl implements StatusService {

	/**
	 * 1071
	 */
	public String addStatus(Status status,String sstatus) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			StatusDaoImpl Impl = new StatusDaoImpl();
			Impl.addStatus(status);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "810");
		}
		return j.toJson(m);
	}

	/**
	 * 1072
	 */
	public String selectStatus(Status status) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			StatusDaoImpl Impl = new StatusDaoImpl();
			List<Status> statusList = Impl.selectStatus(status);
			if (statusList.size() > 0) {
				m.put("statusList", statusList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "821");// have no status
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "820");
		}
		return j.toJson(m);
	}
}
