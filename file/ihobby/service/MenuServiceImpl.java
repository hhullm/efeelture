package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dao.MenuDaoImpl;
import entity.Menu;
import entity.User;

public class MenuServiceImpl implements MenuService {

	@Override
	public String selectMenu(User user) {
		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		Menu menu = new Menu();
		List<Menu> menuList = menuDaoImpl.selectMenu(menu);
		Map<String, Object> m = new HashMap<String, Object>();
		Gson g = new Gson();
		m.put("list", menuList);
		return g.toJson(m);
	}

}
