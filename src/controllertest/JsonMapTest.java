package controllertest;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.Ctrl;
import util.MapToEntity;

public class JsonMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gson gson = new Gson();

		Map<String, Object> map=new HashMap<String, Object>();
		map.put("uid", "eb1b3f446f154ab5");
		String param = gson.toJson(map);
		System.out.println(param);
		
		Map<String, Object> map1 = gson.fromJson(param, new TypeToken<Map<String, Object>>() {
		}.getType());
		System.out.println(map1);
		
		System.out.println((String) map1.get("uid"));
		
		Ctrl ctrl = MapToEntity.toCtrl(map1);
		System.out.println(ctrl.getUid());
	}

}
