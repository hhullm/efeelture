package dao;

import java.util.List;

import entity.Hardware;

public interface HardwareDao {
	
	void addHardware(Hardware hardware);
	
	void deleteHardware(Hardware hardware);
	
	void modifyHardware(Hardware hardware);
	
	List<Hardware> selectHardware(Hardware hardware);

}
