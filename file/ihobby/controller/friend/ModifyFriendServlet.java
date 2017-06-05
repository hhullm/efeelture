package controller.friend;

/**
 * @author 994072500
 * 
 * 修改h好友信息
 */
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.Friend;
import service.FriendServiceImpl;

public class ModifyFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 3673423252290364498L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Friend friend = new Friend();
		friend.setCustId(request.getParameter("custId"));
		friend.setFriendCustId(request.getParameter("friendCustId"));
		friend.setFriendName(request.getParameter("friendName"));
		friend.setFriendType(request.getParameter("friendType"));
		friend.setFriendTypeSelf(request.getParameter("friendTypeSelf"));
		Gson gson = new Gson();
		String resultCode = "";
		try {
			FriendServiceImpl friendServiceImpl = new FriendServiceImpl();
			resultCode = friendServiceImpl.modifyFriend(friend);
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
