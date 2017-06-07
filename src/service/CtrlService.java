package service;


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
	String selectCtrl(Ctrl ctrl);
}
