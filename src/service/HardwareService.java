package service;

import java.util.List;
import java.util.Map;

import entity.Hardware;

public interface HardwareService {
	/*
	 * 
	 */
	String addHardware(Map<String, Object> map);
	
	/*
	 * 
	 */
	String deleteHardware(Map<String, Object> map);
	
	/*
	 * 
	 */
	List<Hardware> selectHardware(Map<String, Object> map);

}
