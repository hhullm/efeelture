package controllertest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import entity.Ctrl;

public class CtrlControllerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ctrl ctrl = new Ctrl();

		//input
		String func = "1003";
		ctrl.setClevel("");
		ctrl.setContent("");
		ctrl.setCtime("");
		ctrl.setHid("");
		ctrl.setHname("");
		ctrl.setId("");
		ctrl.setUid("eb1b3f446f154ab5");
		ctrl.setUipaddress("");
		ctrl.setUname("");
		try {
			String u = "http://localhost:8080/efeelture/mobileAppServlet?";
			URL myUrl = new URL(u);

			String result = "";

			Map<String, Object> m = new HashMap<String, Object>();
			Gson j = new Gson();
			m.put("clevel", ctrl.getClevel());
			m.put("content", ctrl.getContent());
			m.put("ctime", ctrl.getCtime());
			m.put("hid", ctrl.getHid());
			m.put("hname", ctrl.getHname());
			m.put("id", ctrl.getId());
			m.put("uid", ctrl.getUid());
			m.put("uipaddress", ctrl.getUipaddress());
			m.put("uname", ctrl.getUname());

			String zson = j.toJson(m);

			// System.out.println(u+"func=" + func + "&zson=" + zson);

			HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();

			conn.setDoOutput(true);
			conn.setDoInput(true);
			OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
			osw.write("func=" + func + "&zson=" + zson);
			osw.flush();
			osw.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String s = null;
			while ((s = br.readLine()) != null) {
				result += s;
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
