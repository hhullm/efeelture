package controller.user;

/**
 * @author 994072500
 * 
 * 用来增加一个新用户
 */
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.User;
import service.UserServiceImpl;

public class AddUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Gson gson = new Gson();
		String resultCode = "";
		User user = new User();
		user.setCustName(request.getParameter("custName"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setPassword(request.getParameter("password"));
		try {
			UserServiceImpl userServiceImpl = new UserServiceImpl();
		//	resultCode = userServiceImpl.register(user);
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
