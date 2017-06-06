package service;

import java.util.List;

import entity.Hardware;

public interface HardwareService {
	/*
	 * 
	 */
	String addHardware(Hardware hardware);
	
	/*
	 * 
	 */
	String deleteHardware(Hardware hardware);
	
	/*
	 * 
	 */
	List<Hardware> selectHardware(Hardware hardware);

}
