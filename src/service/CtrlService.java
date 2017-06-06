package service;

import java.util.List;
import java.util.Map;

import entity.Ctrl;

public interface CtrlService {

	/*
	 * save db
	 */
	String saveCtrl(Map<String, Object> map);

	/*
	 * to raspberry
	 */
	String forwardCtrl(Map<String, Object> map);

	/*
	 * select ctrl
	 */
	List<Ctrl> selectCtrl(Map<String, Object> map);
}
