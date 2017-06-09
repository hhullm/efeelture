package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import daoimpl.HardwareDaoImpl;
import entity.Hardware;
import service.HardwareService;

public class HardwareServiceImpl implements HardwareService {
	/*
	 * 
	 */
	public String addHardware(Hardware hardware) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			HardwareDaoImpl Impl = new HardwareDaoImpl();
			Impl.addHardware(hardware);
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
	public String deleteHardware(Hardware hardware) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			HardwareDaoImpl Impl = new HardwareDaoImpl();
			Impl.deleteHardware(hardware);
			m.put("resultCode", "999");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "320");
		}
		return j.toJson(m);
	}
	
	/*
	 * 
	 */
	public String selectHardware(Hardware hardware) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			HardwareDaoImpl Impl = new HardwareDaoImpl();
			List<Hardware> hardwareList = Impl.selectHardware(hardware);
			if (hardwareList.size() > 0) {
				m.put("hardwareList", hardwareList);
				m.put("resultCode", "999");
			} else
				m.put("resultCode", "331");//have no hardware
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "330");
		}
		return j.toJson(m);
	}

}
