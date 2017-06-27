package service;

import entity.Ctrl;

public interface CtrlService {

	/*
	 * save db
	 */
	String saveCtrl(Ctrl ctrl);


	/*
	 * select ctrl
	 */
	String selectCtrl(Ctrl ctrl);
}
