package controller.friend;

/**
 * @author 994072500
 * 
 * 删除朋友关系
 */
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FriendServiceImpl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.Friend;

public class DelFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Gson gson = new Gson();
		String resultCode = "";
		Friend friend = new Friend();
		friend.setCustId(request.getParameter("custId"));
		friend.setFriendCustId(request.getParameter("friendCustId"));
		try {
			FriendServiceImpl friendServiceImpl = new FriendServiceImpl();
			resultCode = friendServiceImpl.delFriend(friend);
			Map<String, Object> map = gson.fromJson(resultCode,
					new TypeToken<Map<String, Object>>() {
					}.getType());
			resultCode = (String) map.get("resultCode");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("resultCode.jsp?resultCode=" + resultCode);
	}
}
