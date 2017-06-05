package dao;

import java.util.List;

import entity.Ctrl;

public interface CtrlDao {
	
	void addCtrl(Ctrl ctrl);
	
	void deleteCtrl(Ctrl ctrl);
	
	void modifyCtrl(Ctrl ctrl);
	
	List<Ctrl> selectCtrl(Ctrl ctrl);

}
