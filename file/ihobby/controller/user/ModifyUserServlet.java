package controller.user;

/**
 * @author 994072500
 * 
 * 修改用户信息
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

public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 3673423252290364498L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = new User();
		user.setCustId(request.getParameter("custId"));
		user.setCustName(request.getParameter("custName"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		user.setEmail(request.getParameter("email"));
		user.setCustVip(request.getParameter("custVip"));
		user.setCustQq(request.getParameter("custQq"));
		Gson gson = new Gson();
		String resultCode = "";
		try {
			UserServiceImpl userServiceImpl = new UserServiceImpl();
			resultCode = userServiceImpl.modifyUser(user);
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
