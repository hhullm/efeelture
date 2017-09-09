package dao;

import java.util.List;

import entity.Setting;


public interface SettingDao {
	
	void addSetting(Setting setting);
	
	void deleteSetting(Setting setting);
	
	void modifySetting(Setting setting);
	
	List<Setting> selectSetting(Setting setting);

}
