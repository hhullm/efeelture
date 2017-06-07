package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.JectiveDaoImpl;
import entity.Jective;
import service.JectiveService;


public class JectiveServiceImpl implements JectiveService {

	/*
	 * 
	 */
	public String addJective(Jective jective) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			JectiveDaoImpl Impl = new JectiveDaoImpl();
			Impl.addJective(jective);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "310");
		}
		return j.toJson(m);
	}
	
	/*
	 * 
	 */
	public String selectJective(Jective jective) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			JectiveDaoImpl Impl = new JectiveDaoImpl();
			List<Jective> jectiveList = Impl.selectJective(jective);
			if (jectiveList.size() > 0) {
				m.put("jectiveList", jectiveList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "331");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "330");
		}
		return j.toJson(m);
	}
	
}