package service;

import java.util.List;

import entity.Ctrl;

public interface CtrlService {

	/*
	 * save db
	 */
	String saveCtrl(Ctrl ctrl);

	/*
	 * to raspberry
	 */
	String forwardCtrl(Ctrl ctrl);

	/*
	 * select ctrl
	 */
	List<Ctrl> selectCtrl(Ctrl ctrl);
}
